package com.deere.global;

import static com.deere.global.GlobalThings.downloadFilePath;
import static com.deere.global.GlobalThings.driversPath;
import static com.deere.global.GlobalThings.listOfInputs;
import static com.deere.global.GlobalThings.startTime_Excution;
import static com.deere.global.GlobalThings.timeForExecution;
import static com.deere.global.GlobalThings.testResultReports;

import java.lang.reflect.Method;
import java.util.HashMap;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.deere.pages.homepage.HomePage;
import com.relevantcodes.extentreports.LogStatus;

/**
 * 
 * @author sm24398
 * Description : This Class contains all WebDriver and Report Configuration
 */

public class CoreTestCase {
	
	protected static int passedCount = 0;
	protected static int failedCount = 0;
	
	private static HashMap<Long, WebDriver> mapDrivers = new HashMap<>();
	
	@BeforeSuite(alwaysRun = true)
	public void initTestSuite() {
		try {
			ExtentReportManager.createExtentReport();
			ExtentReportManager.getSystemInfoForExtentReport();
			System.out.println("Starting the test suite..");	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public static void initWebDriver(String browser, Method method) {
		try {
			System.out.println("Opening browser....");
			switch(browser) {
			case "IE" : 	System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
							DesiredCapabilities capsIE = DesiredCapabilities.internetExplorer();
							capsIE.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
							capsIE.setCapability("ignoreZoomSetting", true);
							capsIE.setCapability("requireWindowFocus", false);
							capsIE.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true); 
							InternetExplorerDriverService service = InternetExplorerDriverService.createDefaultService();
							setDriverForCurrentThread(new InternetExplorerDriver(service, capsIE));
							getDriver().manage().window().maximize();
							getDriver().manage().deleteAllCookies();
							break;

			case "Chrome" : HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
							chromePrefs.put("profile.default_content_settings.popups", 0);
							chromePrefs.put("download.default_directory", downloadFilePath);
					
							System.setProperty("webdriver.chrome.driver", driversPath + "//chromedriver.exe");
							ChromeOptions options = new ChromeOptions();
							HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
							options.setExperimentalOption("prefs", chromePrefs);
							options.addArguments("--test-type");
							options.addArguments("--disable-extensions");
							
							DesiredCapabilities capsChrome = DesiredCapabilities.chrome();
							capsChrome.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
							capsChrome.setCapability	(CapabilityType.ACCEPT_SSL_CERTS, true);
							capsChrome.setCapability(ChromeOptions.CAPABILITY, options);
							capsChrome.setCapability("prefs", chromePrefs);
							ChromeDriverService chromeService = ChromeDriverService.createDefaultService();
							setDriverForCurrentThread(new ChromeDriver(chromeService, capsChrome));
							getDriver().manage().deleteAllCookies();
							getDriver().manage().window().maximize();
							break;
							
			case "Firefox" : System.setProperty("webdriver.gecko.driver", driversPath + "//geckodriver.exe");
							 DesiredCapabilities firefoxCapabilities = DesiredCapabilities.firefox();
							 firefoxCapabilities.setCapability("marionette", true);
							 FirefoxProfile firefoxProfile = new FirefoxProfile();
							 firefoxProfile.setPreference("browser.download.folderList", 2);
							 firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
							 firefoxProfile.setPreference("browser.download.dir", downloadFilePath);
							 firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf, application/vnd.ms-excel, application/csv");
							 firefoxCapabilities.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
							 setDriverForCurrentThread(new FirefoxDriver(firefoxCapabilities));
							 getDriver().manage().deleteAllCookies();
							 break;
			
			default : throw new RuntimeException("Browser type not supported");
			}
			for(InputTestDetails inputTestDetails : listOfInputs) {
				if(inputTestDetails.getTestCaseID().equals(method.getName().replaceAll("test_", ""))) {
					ExtentReportManager.startTest(inputTestDetails.getFunctionality(), inputTestDetails.getTestCaseDescription());
					break;
				}
			}
			ExtentReportManager.getLogger().log(LogStatus.INFO, "Opening " + browser + " browser...");
			GlobalThings.executionStartTimeForScenario = System.currentTimeMillis();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() {
		return mapDrivers.get(Thread.currentThread().getId());
	}
	
	protected static void setDriverForCurrentThread(WebDriver driver) {
		mapDrivers.put(Thread.currentThread().getId(), driver);
	}
	
	@Parameters("browser")
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result, String browser) throws Exception {
		try {
			String sSPath = null;
			String functionalError = null;
			String techError = null;
			String userDefinedError = null;
			TestResultReport testResultReport = null;
			InputTestDetails inputTestDetails = (InputTestDetails) result.getParameters()[1];
			if(result.getStatus()==ITestResult.SUCCESS) {
				passedCount++;
				
				HomePage homePage = new HomePage(getDriver());
				homePage.signOut(getDriver());
					
				ExtentReportManager.endTest();
			} else if(result.getStatus()==ITestResult.FAILURE){
				failedCount++;
				sSPath = CommonFunctions.curDir + "\\" + result.getMethod().getMethodName().replace("test_", "") + "_" + browser + ".png";
				CommonFunctions.takeScreenShot(getDriver(), sSPath);
				if(!result.getThrowable().toString().contains("AssertionError")){
					userDefinedError = "Due to more reponse time , page or object may not be visible/loaded within timeout";
					techError = result.getThrowable().toString();
					ExtentReportManager.getLogger().log(LogStatus.FAIL, "Technical Error : " +techError);
				}
				else {
					functionalError = result.getThrowable().toString().substring(25, result.getThrowable().toString().length()).trim();
					ExtentReportManager.getLogger().log(LogStatus.FAIL, "Assertion Error : " +functionalError);
				}
				ExtentReportManager.getLogger().log(LogStatus.INFO, "Failed in " + browser + " browser");
				ExtentReportManager.getLogger().log(LogStatus.INFO, "Screenshot : " + ExtentReportManager.getLogger().addScreenCapture(sSPath));
				
				HomePage homePage = new HomePage(getDriver());
				homePage.signOut(getDriver());		
				
				ExtentReportManager.endTest();
				AutomationEmail.sendFailedTCEmail(sSPath, result.getThrowable().toString(), inputTestDetails.getTestCaseID(), inputTestDetails.getTestCaseDescription(), inputTestDetails.getFunctionalityFlow());
			}else {
				ExtentReportManager.getLogger().log(LogStatus.SKIP, "Skipped Test Case");
				ExtentReportManager.endTest();
			}
		    testResultReport = CommonFunctions.updateResultObject(inputTestDetails, techError, functionalError, userDefinedError, getDriver(), GlobalThings.listOfEnv.get(0), browser, sSPath);
		    testResultReports.add(testResultReport);	    
			getDriver().quit();
			mapDrivers.remove(Thread.currentThread().getId());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterSuite(alwaysRun = true)
	public void endSuite() throws Exception {
		try {
			System.out.println("Finished all threads!!");
			ExtentReportManager.extentReports.flush();
			ExtentReportManager.extentReports.close();
			timeForExecution = System.currentTimeMillis()-startTime_Excution;
			CommonFunctions.writeReportExcel();
			AutomationEmail.sendEmail();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
