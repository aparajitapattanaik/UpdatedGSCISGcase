package com.deere.global;

import static com.deere.global.GlobalThings.listOfBrowser;
import static com.deere.global.GlobalThings.listOfEnv;
import static com.deere.global.GlobalThings.listOfTestSkipped;
import static com.deere.global.CommonFunctions.curDir;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * 
 * @author sm24398
 * Description : This Class contains Report Configuration and Initialization
 *
 */

public class ExtentReportManager {

	static ExtentReports extentReports;
	private static Map<Long, ExtentTest> mapExtentTests = new HashMap<>();
	
	private ExtentReportManager() {	}
	
	/**
	 * Author : Sachin Mashalkar
	 * Description : Initialization of Extent Report
	 */
	public static void createExtentReport() {
		//File Location where the Report is generated
		extentReports = new ExtentReports(curDir + "/Extent_Report.html");
		
		//Load Config XML file
		extentReports.loadConfig(new File(GlobalThings.extentConfigFile));
	}
	
	public static synchronized ExtentTest getLogger() {
		return mapExtentTests.get(Thread.currentThread().getId());
	}
	
	public static synchronized ExtentTest startTest(String testName, String description) {
		ExtentTest test = extentReports.startTest(testName, description);
		mapExtentTests.put(Thread.currentThread().getId(), test);
		return test;
	}
	
    public static synchronized void endTest() {
    	extentReports.endTest(mapExtentTests.get(Thread.currentThread().getId()));
    }

	public static void getSystemInfoForExtentReport() {
		//Add Environment Details to the System Info
		for(InputEnvironmentDetails e : listOfEnv) {
			extentReports.addSystemInfo("Environment", e.getEnvironment());
		}
		
		//Add Browser Details to the System Info
		for(InputBrowserDetails b : listOfBrowser) {
			extentReports.addSystemInfo("Browser", b.getBrowserName());
		}
	}
	
	public static void addSkippedTestCasesToReport() {
		for(InputTestDetails e : listOfTestSkipped) {
			startTest(e.getFunctionality(), e.getTestCaseDescription());
			getLogger().log(LogStatus.SKIP, "Skipped Test Case");
			extentReports.endTest(getLogger());
		}
	}
}
