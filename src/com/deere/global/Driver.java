package com.deere.global;
import static com.deere.global.GlobalThings.startTime_Excution;
import static com.deere.global.GlobalThings.listOfsuite;


/**
 * @author sm24398
 * This class contains main function and Automation execution starts from here
 */

public class Driver {

	public static void main(String[] args) throws Exception {
		
		startTime_Excution = System.currentTimeMillis();
		CommonFunctions.createReportDirectory();
		CommonFunctions.getEnvironemtToBeExecuted();
		CommonFunctions.getEmailAddresses();
		CommonFunctions.getSuiteToBeExecuted();
		CommonFunctions.getBrowserToBeExecuted();
		for(InputSuiteDetails suite : listOfsuite)
		{
			CommonFunctions.getTestsToBeExecuted(suite.getModule().toString());
		}
		XML.createXMLFile();
		XML.saveXml();
		XML.triggerXml();
		System.exit(0);
	} 
}