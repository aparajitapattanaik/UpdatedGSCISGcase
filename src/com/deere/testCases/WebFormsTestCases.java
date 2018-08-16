package com.deere.testCases;

import static com.deere.global.CommonFunctions.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.deere.global.CoreTestCase;
import com.deere.global.FunctionalMethods;
import com.deere.global.GlobalDataProvider;
import com.deere.global.GlobalThings;
import com.deere.global.InputEnvironmentDetails;
import com.deere.global.InputTestDetails;
import com.deere.pages.NavigationClass;
import com.deere.pages.PegaLoginPage;
import com.deere.pages.SiteMinderLoginPage;
import com.deere.pages.casesearch.CaseSearchPage;
import com.deere.pages.isgcasecreation.ISGCasePage;
import com.deere.pages.isgcasecreation.ISGCaseSearchPage;
import com.deere.pages.webform.Agronomy;
import com.deere.pages.webform.AgronomyLoginPage;
import com.deere.pages.webform.Deere;
import com.deere.pages.webform.DeereLoginPage;
import com.deere.pages.webform.GreenFleetWebFormSubmissionPage;
import com.deere.pages.webform.India;
import com.deere.pages.webform.IndiaLoginPage;
import com.deere.pages.webform.JDLinks;
import com.deere.pages.webform.JDLinksWebFormSubmitionPage;
import com.deere.pages.webform.JDParts;
import com.deere.pages.webform.JDPartsWebFormSubmissionPage;
import com.deere.pages.webform.R4Turf;
import com.deere.pages.webform.R4TurfLoginPage;
import com.deere.pages.webform.R4_AgCC;
import com.deere.pages.webform.R4_AgCCWebFormSubmissionPage;
import com.deere.pages.webform.SouthEastAsia;
import com.deere.pages.webform.SouthEastAsiaLoginPage;
import com.deere.pages.webform.SouthSahara;
import com.deere.pages.webform.SouthSaharaLoginPage;
import com.deere.pages.webform.StellarSupport;
import com.deere.pages.webform.StellarSupportWebformSubmissionPage;
import com.deere.pages.webform.Techpubs;
import com.deere.pages.webform.TechpubsLoginPage;

public class WebFormsTestCases extends CoreTestCase {

	/**
	 * Author :Lahari Description :As a customer, I want to submit my query using
	 * web-form so that John Deere can look into it and respond.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 * @throws Throwable
	 */
	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6595_CreateWebFormForJDParts(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		JDParts jdParts;
		NavigationClass navigationClass;
		JDPartsWebFormSubmissionPage jdPartsWebFormSubmissionPage;
		ISGCasePage isgCasePage;
		CaseSearchPage caseSearchPag;

		FunctionalMethods functionalMethods = new FunctionalMethods();

		// Login to JDParts WebForm
		jdParts = functionalMethods.openJDPartsWebformPortal(getDriver(), testData.getTestdata()[0]);

		// Enter UseName ,Password and Click on Submit Button
		jdPartsWebFormSubmissionPage = functionalMethods.logintoWebform(jdParts, testData.getTestdata()[1],
				testData.getTestdata()[2]);

		// Validating if JDLinks WebForm is displayed
		assertTrue(jdPartsWebFormSubmissionPage.hasJDLinksWebFormPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to JDParts WebForm Page is Unsuccessful");

		// Validating that First Name Last Name is showing
		assertTrue(jdPartsWebFormSubmissionPage.hasFirstNameLastNameDisplayed(testData.getExpectedResult()[1]),
				"First Name Last Name is not displayed correctly");

		// Validating that Address is showing
		assertTrue(jdPartsWebFormSubmissionPage.hasAddressDisplayed(testData.getExpectedResult()[2]),
				"Address is not displayed correctly");

		// Validating that Phone Number is showing
		assertTrue(jdPartsWebFormSubmissionPage.hasPhoneNumberDisplayed(testData.getExpectedResult()[3]),
				"PhoneNumber is not displayed correctly");

		// Validating that Email Address is showing
		assertTrue(jdPartsWebFormSubmissionPage.hasEmailAddressDisplayed(testData.getExpectedResult()[4]),
				"EmailAddrress is not displayed correctly");

		// Validating that Primary Message is showing
		assertTrue(jdPartsWebFormSubmissionPage.hasPrimaryMessageDisplayed(testData.getExpectedResult()[5]),
				"Primary Message is not displayed correctly");

		// Validating that Comments Text Area filed is showing
		assertTrue(jdPartsWebFormSubmissionPage.hasCommentsTextAreaFiledDisplayed(),
				"Comments Text Area filed is n.ot displayed correctly");

		// Validating that Add File Button filed is showing
		assertTrue(jdPartsWebFormSubmissionPage.hasAddFileButtonDisplayed(),
				"AddFileButton  filed is not displayed correctly");

		// Validating that Submit Button is showing
		assertTrue(jdPartsWebFormSubmissionPage.hasSubmitButtonDisplayed(testData.getExpectedResult()[6]),
				"Submit Button  filed is not displayed correctly");

		// Validating that Clear Button is showing
		assertTrue(jdPartsWebFormSubmissionPage.hasClearButtonDisplayed(testData.getExpectedResult()[7]),
				"Clear Button  filed is not displayed correctly");

		// Enter Data into Detailed Description Text Area filed and Attach file using
		// File Attach Button
		jdPartsWebFormSubmissionPage = functionalMethods
				.enterdetailedDescriptionUploadFile(jdPartsWebFormSubmissionPage, testData.getTestdata()[3]);

		// Validating that Attachment is attached successfully after file attached
		assertTrue(jdPartsWebFormSubmissionPage.hasFileAttachedDisplayed(testData.getExpectedResult()[8]),
				"File is not attached successfully");

		// click on clear button and Validating validation messages appear
		jdPartsWebFormSubmissionPage = functionalMethods.clickClearButtonVefyValidaMeg(jdPartsWebFormSubmissionPage);

		// Enter Data into Detailed Description Text Area filed and Attach file using
		// File Attach Button
		jdPartsWebFormSubmissionPage = functionalMethods
				.enterdetailedDescriptionUploadFile(jdPartsWebFormSubmissionPage, testData.getTestdata()[3]);

		// Validating Attachment is attached
		assertTrue(jdPartsWebFormSubmissionPage.hasFileAttachedDisplayed(testData.getExpectedResult()[8]),
				"File is not attached successfully");

		// click on Submit button
		jdPartsWebFormSubmissionPage = functionalMethods.clickSubmitButton(jdPartsWebFormSubmissionPage);

		// Validating Final Message
		assertTrue(jdPartsWebFormSubmissionPage.hasFinalMessageDisplayed(testData.getExpectedResult()[9]),
				"Final Message with CaseID is not displayed correctly");

		// Get CaseId
		jdPartsWebFormSubmissionPage = functionalMethods.getCaseID(jdPartsWebFormSubmissionPage);

		// Delete all cookies
		getDriver().manage().deleteAllCookies();

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Validating that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[4],
				testData.getTestdata()[5]);

		// Validating that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[6],
				testData.getTestdata()[7], NavigationClass.class);

		// Validating that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed correctly");

		// Navigating to CaseSearch Page
		caseSearchPag = functionalMethods.navigateToCaseSerchPage(navigationClass);

		// Verifying that CaseSearch home page displayed
		assertTrue(caseSearchPag.hasCaseSearchHomePageDisplayed(), "Casesearch page is not displayed correctly");

		// Enter the CaseId in Case Search filed
		caseSearchPag = functionalMethods.enterCaseIDClickCaseSerch(caseSearchPag, GlobalThings.Caseid_JDParts);

		// Navigate to isgCasePage from isgCaseSearchPage
		isgCasePage = functionalMethods.navigateToISGCasPage(caseSearchPag);

		// Validating that Work Basket is showing
		assertTrue(isgCasePage.hasWorkBasketDisplayed(testData.getExpectedResult()[8]),
				"Work Basket is not displayed correctly");

		// Validating New-Draft status of the case
		assertTrue(isgCasePage.hasStatusNewDisplayed(), "Status of the Case is not New-Draft");

		// Validating that Summary is showing
		assertTrue(isgCasePage.hasSummaryTextDisplayed(testData.getExpectedResult()[10]),
				"R4 JDParts Support web form is not displayed correctly");

		// Validating that priority is showing
		assertTrue(isgCasePage.hasPriorityDrpDwnDisplayed(testData.getExpectedResult()[11]),
				"Normal is not displayed correctly");

		// Validating that Origin is showing
		assertTrue(isgCasePage.hasOriginDrpDwnDisplayed(testData.getExpectedResult()[12]),
				"Email is not displayed correctly");

	}

	/**
	 * Author :Lahari Description :As a customer, I want to submit my query using
	 * web-form so that John Deere can look into it and respond.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 * @throws Throwable
	 */
	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6862_CreateWebFormForJDParts_Negative(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		JDParts jdParts;
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;
		CaseSearchPage caseSearchPag;
		ISGCasePage isgCasePage;
		JDPartsWebFormSubmissionPage jdPartsWebFormSubmissionPage;
		FunctionalMethods functionalMethods = new FunctionalMethods();

		// Login to JDParts WebForm
		jdParts = functionalMethods.openJDPartsWebformPortal(getDriver(), testData.getTestdata()[0]);

		// Enter UseName ,Password and Click on Submit Button
		jdPartsWebFormSubmissionPage = functionalMethods.logintoWebform(jdParts, testData.getTestdata()[1],
				testData.getTestdata()[2]);

		// Validating if JDLinks WebForm is displayed
		assertTrue(jdPartsWebFormSubmissionPage.hasJDLinksWebFormPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to JDParts WebForm Page is Unsuccessful");

		// Validating that First Name Last Name is showing
		assertTrue(jdPartsWebFormSubmissionPage.hasFirstNameLastNameDisplayed(testData.getExpectedResult()[1]),
				"First Name Last Name is not displayed correctly");

		// Validating that Address is showing
		assertTrue(jdPartsWebFormSubmissionPage.hasAddressDisplayed(testData.getExpectedResult()[2]),
				"Address is not displayed correctly");

		// Validating that Phone Number is showing
		assertTrue(jdPartsWebFormSubmissionPage.hasPhoneNumberDisplayed(testData.getExpectedResult()[3]),
				"PhoneNumber is not displayed correctly");

		// Validating that Email Address is showing
		assertTrue(jdPartsWebFormSubmissionPage.hasEmailAddressDisplayed(testData.getExpectedResult()[4]),
				"EmailAddrress is not displayed correctly");

		// Validating that Primary Message is showing
		assertTrue(jdPartsWebFormSubmissionPage.hasPrimaryMessageDisplayed(testData.getExpectedResult()[5]),
				"Primary Message is not displayed correctly");

		// Validating that Comments Text Area filed is showing
		assertTrue(jdPartsWebFormSubmissionPage.hasCommentsTextAreaFiledDisplayed(),
				"Comments Text Area filed is not displayed correctly");

		// Validating that Add File Button filed is showing
		assertTrue(jdPartsWebFormSubmissionPage.hasAddFileButtonDisplayed(),
				"AddFileButton  filed is not displayed correctly");

		// Validating that Submit Button is showing
		assertTrue(jdPartsWebFormSubmissionPage.hasSubmitButtonDisplayed(testData.getExpectedResult()[6]),
				"Submit Button  filed is not displayed correctly");

		// Validating that Clear Button is showing
		assertTrue(jdPartsWebFormSubmissionPage.hasClearButtonDisplayed(testData.getExpectedResult()[7]),
				"Clear Button  filed is not displayed correctly");

//		// click on submit button and validate validation messages appear
//		jdPartsWebFormSubmissionPage = functionalMethods
//				.clickOnSubBtnValidateValidMsgAppear(jdPartsWebFormSubmissionPage);

		// Enter Data into Detailed Description Text Area filed and Attach file using
		// File Attach Button
		jdPartsWebFormSubmissionPage = functionalMethods
				.enterdetailedDescriptionUploadFile(jdPartsWebFormSubmissionPage, testData.getTestdata()[3]);

		// Validating file attachment is attached successfully
		assertTrue(jdPartsWebFormSubmissionPage.hasFileAttachedDisplayed(testData.getExpectedResult()[8]),
				"File not attached successfully");

		// click on Submit button
		jdPartsWebFormSubmissionPage = functionalMethods.clickSubmitButton(jdPartsWebFormSubmissionPage);

		// Validate Final Message
		assertTrue(jdPartsWebFormSubmissionPage.hasFinalMessageDisplayed(testData.getExpectedResult()[9]),
				"Final Message with CaseID is not Displayed");

		// Get CaseId
		jdPartsWebFormSubmissionPage = functionalMethods.getCaseID(jdPartsWebFormSubmissionPage);

		// Delete all cookies
		//getDriver().manage().deleteAllCookies();

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Validating that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[4],
				testData.getTestdata()[5]);

		// Validating that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[6],
				testData.getTestdata()[7], NavigationClass.class);

		// Validating that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed correctly");

		// Navigating to CaseSearch Page
		caseSearchPag = functionalMethods.navigateToCaseSerchPage(navigationClass);

		// Verifying that CaseSearch home page displayed
		assertTrue(caseSearchPag.hasCaseSearchHomePageDisplayed(), "Casesearch page is not displayed correctly");

		// Enter the CaseId in Case Search filed
		caseSearchPag = functionalMethods.enterCaseIDClickCaseSerch(caseSearchPag, GlobalThings.Caseid_JDParts);

		// Navigate to isgCasePage from isgCaseSearchPage
		isgCasePage = functionalMethods.navigateToISGCasPage(caseSearchPag);

		// Validating that Work Basket is showing
		assertTrue(isgCasePage.hasWorkBasketDisplayed(testData.getExpectedResult()[8]),
				"Work Basket is not displayed correctly");

		// Validating New-Draft status of the case
		assertTrue(isgCasePage.hasStatusNewDisplayed(), "Status of the Case is not New-Draft");

		// Validating that Summary is showing
		assertTrue(isgCasePage.hasSummaryTextDisplayed(testData.getExpectedResult()[10]),
				"R4 JDParts Support web form is not displayed correctly");

		// Validating that priority is showing
		assertTrue(isgCasePage.hasPriorityDrpDwnDisplayed(testData.getExpectedResult()[11]),
				"Normal is not displayed correctly");

		// Validating that Origin is showing
		assertTrue(isgCasePage.hasOriginDrpDwnDisplayed(testData.getExpectedResult()[12]),
				"Email is not displayed correctly");

	}

	/**
	 * Author :Lahari Description :As a customer, I want to submit my query using
	 * web-form so that John Deere can look into it and respond
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 * @throws Throwable
	 */
	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6596_CreateWebFormForR4AgCC(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		R4_AgCC r4Agcc;
		ISGCasePage isgCasePage;
		ISGCaseSearchPage isgCaseSearchPage;
		NavigationClass navigationClass;
		CaseSearchPage caseSearchPag;
		R4_AgCCWebFormSubmissionPage r4_AgCCWebFormSubmissionPage;

		FunctionalMethods functionalMethods = new FunctionalMethods();

		// Login to R4_AgCC WebForm
		r4Agcc = functionalMethods.openAgccWebformPortal(getDriver(), testData.getTestdata()[0]);

		// Enter UseName ,Password and Click on Submit Button
		r4_AgCCWebFormSubmissionPage = functionalMethods.logintoWebform(r4Agcc, testData.getTestdata()[1],
				testData.getTestdata()[2]);

		// Validating if r4Agcc WebForm is displayed
		assertTrue(r4_AgCCWebFormSubmissionPage.hasR4AgccWebFormPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to r4Agcc WebForm Page is Unsuccessful");

		// Validating that First Name Last Name is showing
		assertTrue(r4_AgCCWebFormSubmissionPage.hasFirstNameLastNameDisplayed(testData.getExpectedResult()[1]),
				"First Name Last Name is not displayed correctly");

		// Validating that Address is showing
		assertTrue(r4_AgCCWebFormSubmissionPage.hasAddressDisplayed(testData.getExpectedResult()[2]),
				"Address is not displayed correctly");

		// Validating that Phone number is showing
		assertTrue(r4_AgCCWebFormSubmissionPage.hasPhoneNumberDisplayed(testData.getExpectedResult()[3]),
				"Phonenumber is not displayed correctly");

		// Validating that Email Addrress is showing
		assertTrue(r4_AgCCWebFormSubmissionPage.hasEmailAddressDisplayed(testData.getExpectedResult()[4]),
				"Email Addrress is not displayed correctly");

		// Validating Primary Message showing
		assertTrue(r4_AgCCWebFormSubmissionPage.hasPrimaryMessageDisplayed(testData.getExpectedResult()[5]),
				"Primary Message is not displayed correctly");

		// Validating Comments Text Area filed showing
		assertTrue(r4_AgCCWebFormSubmissionPage.hasCommentsTextAreaDisplayed(),
				"Comments Text Area filed is not displayed correctly");

		// Validating that Dealer Name Text Area filed is showing
		assertTrue(r4_AgCCWebFormSubmissionPage.hasDealerNameTextAreaDisplayed(),
				"Dealer Name Text Area filed is not displayed correctly");

		// Validating that Dealer City Text Area filed is showing
		assertTrue(r4_AgCCWebFormSubmissionPage.hasDealerCityTextAreaDisplayed(),
				"Dealer City Text Area filed is not displayed correctly");

		// Validating that Dealer State Text area filed showing
		assertTrue(r4_AgCCWebFormSubmissionPage.hasDealerStateAreaDisplayed(),
				"Dealer State Text Area filed is not displayed correctly");

		// Validating that AddFileButton is showing
		assertTrue(r4_AgCCWebFormSubmissionPage.hasAddFileButtonDisplayed(),
				"AddFileButton   is not displayed correctly");

		// Validating that submit button is showing
		assertTrue(r4_AgCCWebFormSubmissionPage.hasSubmitButtonDisplayed(testData.getExpectedResult()[6]),
				"Submit Button  is not displayed correctly");

		// Validating Clear Button is showing
		assertTrue(r4_AgCCWebFormSubmissionPage.hasClearButtonDisplayed(testData.getExpectedResult()[7]),
				"Clear Button is not displayed correctly");

		// Enter data in Detailed Description filed and upload file
		r4_AgCCWebFormSubmissionPage = functionalMethods
				.enterDetailedDescriptionUploadFile(r4_AgCCWebFormSubmissionPage, testData.getTestdata()[3]);

		// Validating Clear button and validate validation messages appear
		r4_AgCCWebFormSubmissionPage = functionalMethods.clickOnClearButtonValValidMesg(r4_AgCCWebFormSubmissionPage);

		// Enter data in Detailed Description filed and upload file
		r4_AgCCWebFormSubmissionPage = functionalMethods
				.enterDetailedDescriptionUploadFile(r4_AgCCWebFormSubmissionPage, testData.getTestdata()[3]);

		// Validating Attachment is attached successfully
		 assertTrue(r4_AgCCWebFormSubmissionPage.hasFileAttachedDisplayed(testData.getExpectedResult()[8]), "File not attached successfully");

		// click on Submit button
		r4_AgCCWebFormSubmissionPage = functionalMethods.clickSubmitBtn(r4_AgCCWebFormSubmissionPage);

		// Validate Final Message
		assertTrue(r4_AgCCWebFormSubmissionPage.hasFinalMessageDisplayed(testData.getExpectedResult()[9]),
				"Final Message with CaseID is not Displayed");

		// GetCaseId
		r4_AgCCWebFormSubmissionPage = functionalMethods.getCaseID(r4_AgCCWebFormSubmissionPage);

		// Delete all cookies
		getDriver().manage().deleteAllCookies();

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Validating that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[4],
				testData.getTestdata()[5]);

		// Validating that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[6],
				testData.getTestdata()[7], NavigationClass.class);

		// Validating that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed correctly");

		// Validating that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed correctly");

		// Navigating to CaseSearch Page
		caseSearchPag = functionalMethods.navigateToCaseSerchPage(navigationClass);

		// Verifying that CaseSearch home page displayed
		assertTrue(caseSearchPag.hasCaseSearchHomePageDisplayed(), "Casesearch page is not displayed correctly");

		// Enter the CaseId in Case Search filed
		caseSearchPag = functionalMethods.enterCaseIDClickCaseSerch(caseSearchPag, GlobalThings.Caseid_R4Agcc);

		// // Navigate to Case search page
		// isgCaseSearchPage =
		// functionalMethods.navigateToCaseSearchPage(navigationClass);
		//
		// // Validating that Case search page is displayed
		// assertTrue(isgCaseSearchPage.hasSolutionSearchHomePageDisplayed(),
		// "Navigation to Case search page was Unsuccessful");

		// Enter the CaseId in Case Search filed
		// isgCaseSearchPage =
		// functionalMethods.enterCaseIDClickCaseSrch(isgCaseSearchPage,
		// GlobalThings.Caseid_R4Agcc);

		// Navigate to isgCasePage from isgCaseSearchPage
		isgCasePage = functionalMethods.navigateToISGCasPage(caseSearchPag);

		// Validating that Work Basket is showing
		assertTrue(isgCasePage.hasWorkBasketDisplayed(testData.getExpectedResult()[10]),
				"Work Basket is not displayed correctly");

		// Validate New Status
		assertTrue(isgCasePage.hasStatusNewDisplayed(), "Status as New is not Displayed");

		// Validate Summary
		assertTrue(isgCasePage.hasSummaryTextDisplayed(testData.getExpectedResult()[11]),
				"R4 JDParts Support web form is not Displayed");

		// Validate priority
		assertTrue(isgCasePage.hasPriorityDrpDwnDisplayed(testData.getExpectedResult()[12]), "Normal is not Displayed");

		// Validate Origin
		assertTrue(isgCasePage.hasOriginDrpDwnDisplayed(testData.getExpectedResult()[13]), "Email is not Displayed");

	}

	/**
	 * Author :Lahari Description :As a customer, I want to submit my query using
	 * web-form so that John Deere can look into it and respond
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 * @throws Throwable
	 */
	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6859_CreateWebFormForR4AgCC_Negative(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		R4_AgCC r4Agcc;
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;
		CaseSearchPage caseSearchPag;
		ISGCasePage isgCasePage;
		R4_AgCCWebFormSubmissionPage r4_AgCCWebFormSubmissionPage;

		FunctionalMethods functionalMethods = new FunctionalMethods();

		// Login to R4_AgCC WebForm
		r4Agcc = functionalMethods.openAgccWebformPortal(getDriver(), testData.getTestdata()[0]);

		// Enter UseName ,Password and Click on Submit Button
		r4_AgCCWebFormSubmissionPage = functionalMethods.logintoWebform(r4Agcc, testData.getTestdata()[1],
				testData.getTestdata()[2]);

		// Validating if r4Agcc WebForm is displayed
		assertTrue(r4_AgCCWebFormSubmissionPage.hasR4AgccWebFormPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to r4Agcc WebForm Page is Unsuccessfull");

		// Validating that First Name Last Name is showing
		assertTrue(r4_AgCCWebFormSubmissionPage.hasFirstNameLastNameDisplayed(testData.getExpectedResult()[1]),
				"First Name Last Name is not displayed correctly");

		// Validating that Address is showing
		assertTrue(r4_AgCCWebFormSubmissionPage.hasAddressDisplayed(testData.getExpectedResult()[2]),
				"Address is not displayed correctly");

		// Validating that Phone number is showing
		assertTrue(r4_AgCCWebFormSubmissionPage.hasPhoneNumberDisplayed(testData.getExpectedResult()[3]),
				"Phonenumber is not displayed correctly");

		// Validating that Email Addrress is showing
		assertTrue(r4_AgCCWebFormSubmissionPage.hasEmailAddressDisplayed(testData.getExpectedResult()[4]),
				"Email Addrress is not displayed correctly");

		// Validating Primary Message showing
		assertTrue(r4_AgCCWebFormSubmissionPage.hasPrimaryMessageDisplayed(testData.getExpectedResult()[5]),
				"Primary Message is not displayed correctly");

		// Validating Comments Text Area filed showing
		assertTrue(r4_AgCCWebFormSubmissionPage.hasCommentsTextAreaDisplayed(),
				"Comments Text Area filed is not displayed correctly");

		// Validating that Dealer Name Text Area filed is showing
		assertTrue(r4_AgCCWebFormSubmissionPage.hasDealerNameTextAreaDisplayed(),
				"Dealer Name Text Area filed is not displayed correctly");

		// Validating that Dealer City Text Area filed is showing
		assertTrue(r4_AgCCWebFormSubmissionPage.hasDealerCityTextAreaDisplayed(),
				"Dealer City Text Area filed is not displayed correctly");

		// Validating that Dealer State Text area filed showing
		assertTrue(r4_AgCCWebFormSubmissionPage.hasDealerStateAreaDisplayed(),
				"Dealer State Text Area filed is not displayed correctly");

		// Validating that AddFileButton is showing
		assertTrue(r4_AgCCWebFormSubmissionPage.hasAddFileButtonDisplayed(),
				"AddFileButton   is not displayed correctly");

		// Validating that submit button is showing
		assertTrue(r4_AgCCWebFormSubmissionPage.hasSubmitButtonDisplayed(testData.getExpectedResult()[6]),
				"Submit Button  is not displayed correctly");

		// Validating Clear Button is showing
		assertTrue(r4_AgCCWebFormSubmissionPage.hasClearButtonDisplayed(testData.getExpectedResult()[7]),
				"Clear Button is not displayed correctly");

		// Validating Submit button and validate validation messages appear
		r4_AgCCWebFormSubmissionPage = functionalMethods.clickOnSubmitButton(r4_AgCCWebFormSubmissionPage);

		// Enter data in Detailed Description filed and upload file
		r4_AgCCWebFormSubmissionPage = functionalMethods
				.enterDetailedDescriptionUploadFile(r4_AgCCWebFormSubmissionPage, testData.getTestdata()[3]);

		// Validating that attachment is attached successfully
		// assertTrue(r4_AgCCWebFormSubmissionPage.hasFileAttachedDisplayed(testData.getExpectedResult()[8]),
		// "File not attached successfully");

		// click on Submit button
		r4_AgCCWebFormSubmissionPage = functionalMethods.clickSubmitBtn(r4_AgCCWebFormSubmissionPage);

		// Validate Final Message
		assertTrue(r4_AgCCWebFormSubmissionPage.hasFinalMessageDisplayed(testData.getExpectedResult()[9]),
				"Final Message with CaseID is not displayed correctly");

		// Get CaseId
		r4_AgCCWebFormSubmissionPage = functionalMethods.getCaseID(r4_AgCCWebFormSubmissionPage);

		// Delete all cookies
		getDriver().manage().deleteAllCookies();

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Validating that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[4],
				testData.getTestdata()[5]);

		// Validating that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[6],
				testData.getTestdata()[7], NavigationClass.class);

		// Validating that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed correctly");

	}

	/**
	 * Author :Lahari Description :Case Creation using R4Turf web form
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */
	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6597_CreateWebFormForR4Turf(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;
		R4TurfLoginPage r4TurfLoginPage;
		R4Turf r4Turf;
		ISGCasePage isgCasePage;
		CaseSearchPage caseSearchPag;

		FunctionalMethods functionalMethods = new FunctionalMethods();

		// Login to r4Turf Web Form
		r4TurfLoginPage = functionalMethods.openWebformPortal_R4Turf(getDriver(), testData.getTestdata()[0]);

		// Entering UserName ,Password and Submit
		r4Turf = functionalMethods.logintoR4Turfwebform(r4TurfLoginPage, testData.getTestdata()[1],
				testData.getTestdata()[2]);

		// Validating if r4Agcc WebForm is displayed
		assertTrue(r4Turf.hasR4TurfWebFormPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to R4Turf WebForm Page is Unsuccessful");

		// Validating that First Name Last Name is showing
		assertTrue(r4Turf.hasFirstNameLastNameDisplayed(testData.getExpectedResult()[1]),
				"First Name Last Name is not displayed correctly");

		// Validating that Address is showing
		assertTrue(r4Turf.hasAddressDisplayed(testData.getExpectedResult()[2]), "Address is not displayed correctly");

		// Validating that Phone number is showing
		assertTrue(r4Turf.hasPhoneNumberDisplayed(testData.getExpectedResult()[3]),
				"Phonenumber is not displayed correctly");

		// Validating that Email is showing
		assertTrue(r4Turf.hasR4TurfEmailAdressDisplayed(testData.getExpectedResult()[4]),
				" Email is not displayed correctly");

		// Validating that Primary Message is showing
		assertTrue(r4Turf.hasPrimaryMessageDisplayed(), " Primary Message is not displayed correctly");

		// Validating that Detailed description TextBox is showing
		assertTrue(r4Turf.hasDetailedDesDisplayed(), "Detaild description TextBox is not  displayed correctly");

		// Validating that Dealer Name is showing
		assertTrue(r4Turf.hasDealerNameDisplayed(), " Dealer Name is not displayed correctly");

		// Validating thatDealer City is showing
		assertTrue(r4Turf.hasDealerCityDisplayed(), " Dealer City is not displayed correctly");

		// Validating that Dealer State is showing
		assertTrue(r4Turf.hasDealerStateDisplayed(), " Dealer State is not displayed correctly");

		// Validating that Add File Button is showing
		assertTrue(r4Turf.hasAddFileButtonDisplayed(), "AddFileButton  filed is not displayed correctly");

		// Validating that submit button filed showing
		assertTrue(r4Turf.hasSubmitButtonDisplayed(testData.getExpectedResult()[6]),
				"Submit Button  filed is not displayed correctly");

		// Validating that Clear Button filed showing
		assertTrue(r4Turf.hasClearButtonDisplayed(testData.getExpectedResult()[7]),
				"Clear Button  filed is not displayed correctly");

		// Enter data into Detailed Description filed and uploading file
		r4Turf = functionalMethods.detailedDescriptionUploadFile(r4Turf, testData.getTestdata()[3]);

		// Validating attachment attached
		// assertTrue(r4Turf.hasFileAttachmentDisplayed(testData.getExpectedResult()[8]),
		// "File is not attached successfully");

		// click on clear button and validate validation messages appear
		r4Turf = functionalMethods.clkClearBtnValValdMesg(r4Turf);

		// Enter data into Detailed Description filed and uploading file
		r4Turf = functionalMethods.detailedDescriptionUploadFile(r4Turf, testData.getTestdata()[3]);

		// Validating attachment attached
		// assertTrue(r4Turf.hasFileAttachmentDisplayed(testData.getExpectedResult()[8]),
		// "File not attached successfully");

		// click on Submit button
		r4Turf = functionalMethods.clickSubmitBtn(r4Turf);

		// Validate Final Message
		assertTrue(r4Turf.hasFinalMessageDisplayed(testData.getExpectedResult()[9]),
				"Final Message with CaseID is not Displayed");

		// Storing the Case ID generated at R4Turf
		r4Turf = functionalMethods.getCaseID(r4Turf);

		getDriver().manage().deleteAllCookies();

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Validating that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[4],
				testData.getTestdata()[5]);

		// Validating that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[6],
				testData.getTestdata()[7], NavigationClass.class);

		// Validating that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed");

		// Validating that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed correctly");

		// Navigating to CaseSearch Page
		caseSearchPag = functionalMethods.navigateToCaseSerchPage(navigationClass);

		// Verifying that CaseSearch home page displayed
		assertTrue(caseSearchPag.hasCaseSearchHomePageDisplayed(), "Casesearch page is not displayed correctly");

		// Enter the CaseId in Case Search filed
		caseSearchPag = functionalMethods.enterCaseIDClickCaseSerch(caseSearchPag, GlobalThings.CaseID_R4Turf);

		// // Navigate to Case search page
		// isgCaseSearchPage =
		// functionalMethods.navigateToCaseSearchPage(navigationClass);
		//
		// // Validating that navigated to Case search page
		// assertTrue(isgCaseSearchPage.hasSolutionSearchHomePageDisplayed(),
		// "Navigation to Case search page was Unsuccessful");

		// Enter the CaseId in Case Search filed
		// caseSearchPag = functionalMethods.enterCaseIDClickCaseSerch(caseSearchPag,
		// GlobalThings.Caseid_R4Agcc);

		// Navigate to isgCasePage from isgCaseSearchPage
		isgCasePage = functionalMethods.navigateToISGCasPage(caseSearchPag);

		// Validating that Work Basket is showing
		assertTrue(isgCasePage.hasWorkBasketDisplayed(testData.getExpectedResult()[10]),
				"Work Basket is not displayed correctly");

		// Validate New Status
		assertTrue(isgCasePage.hasStatusNewDisplayed(), "Status as New is not Displayed");

		// Validate Summary
		assertTrue(isgCasePage.hasSummaryTextDisplayed(testData.getExpectedResult()[11]),
				"Comment form submittal - Turf: US is not displayed correctly");

		// Validate priority
		//assertTrue(isgCasePage.hasPriorityDrpDwnDisplayed(testData.getExpectedResult()[12]),
			//	"Priority is not displayed correctly");

		// Validate Origin
		assertTrue(isgCasePage.hasOriginDrpDwnDisplayed(testData.getExpectedResult()[13]),
				"Email is not displayed correctly");

	}

	/**
	 * Author :Lahari Description :Case Creation using R4Turf webform
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */
	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6858_CreateWebFormForR4Turf_Negative(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		ISGCaseSearchPage isgCaseSearchPage;
		NavigationClass navigationClass;
		R4TurfLoginPage r4TurfLoginPage;
		R4Turf r4Turf;
		ISGCasePage isgCasePage;
		CaseSearchPage caseSearchPag;
		FunctionalMethods functionalMethods = new FunctionalMethods();

		// Login to r4Turf Web Form
		r4TurfLoginPage = functionalMethods.openWebformPortal_R4Turf(getDriver(), testData.getTestdata()[0]);

		// Entering UserName ,Password and Submit
		r4Turf = functionalMethods.logintoR4Turfwebform(r4TurfLoginPage, testData.getTestdata()[1],
				testData.getTestdata()[2]);

		// Validating if r4Agcc WebForm is displayed
		assertTrue(r4Turf.hasR4TurfWebFormPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to R4Turf WebForm Page is Unsuccessful");

		// Validating that First Name Last Name is showing
		assertTrue(r4Turf.hasFirstNameLastNameDisplayed(testData.getExpectedResult()[1]),
				"First Name Last Name is not displayed correctly");

		// Validating that Address is showing
		assertTrue(r4Turf.hasAddressDisplayed(testData.getExpectedResult()[2]), "Address is not displayed correctly");

		// Validating that Phone number is showing
		assertTrue(r4Turf.hasPhoneNumberDisplayed(testData.getExpectedResult()[3]),
				"Phonenumber is not displayed correctly");

		// Validating that Email is showing
		assertTrue(r4Turf.hasR4TurfEmailAdressDisplayed(testData.getExpectedResult()[4]),
				" Email is not displayed correctly");

		// Validating that Primary Message is showing
		assertTrue(r4Turf.hasR4TurfPrimaryMessageDisplayed(testData.getExpectedResult()[5]),
				"r4Turf Email is not displayed correctly");

		// Validating that Dealer Name is showing
		assertTrue(r4Turf.hasDealerNameDisplayed(), " Dealer Name is not displayed correctly");

		// Validating thatDealer City is showing
		assertTrue(r4Turf.hasDealerCityDisplayed(), " Dealer City is not displayed correctly");

		// Validating that Dealer State is showing
		assertTrue(r4Turf.hasDealerStateDisplayed(), " Dealer State is not displayed correctly");

		// Validating that Add File Button is showing
		assertTrue(r4Turf.hasAddFileButtonDisplayed(), "AddFileButton  filed is not displayed correctly");

		// Validating that submit button filed showing
		assertTrue(r4Turf.hasSubmitButtonDisplayed(testData.getExpectedResult()[6]),
				"Submit Button  filed is not displayed correctly");

		// Validating that Clear Button filed showing
		assertTrue(r4Turf.hasClearButtonDisplayed(testData.getExpectedResult()[7]),
				"Clear Button  filed is not displayed correctly");

		// click on Submit button and validate validation messages appear
		r4Turf = functionalMethods.clickOnSubmitButton(r4Turf);

		// Enter data into Detailed Description filed and uploading file
		r4Turf = functionalMethods.detailedDescriptionUploadFile(r4Turf, testData.getTestdata()[3]);

		// Validating that file attachment is attached successfully
		// assertTrue(r4Turf.hasFileAttachmentDisplayed(testData.getExpectedResult()[8]),
		// "File not attached successfully");

		// click on Submit button
		r4Turf = functionalMethods.clickSubmitBtn(r4Turf);

		// Validate Final Message
		assertTrue(r4Turf.hasFinalMessageDisplayed(testData.getExpectedResult()[9]),
				"Final Message with CaseID is not Displayed");

		// GetCaseId
		r4Turf = functionalMethods.getCaseID(r4Turf);

		getDriver().manage().deleteAllCookies();

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Validating that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[4],
				testData.getTestdata()[5]);

		// Validating that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[6],
				testData.getTestdata()[7], NavigationClass.class);

		// Validating that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed");

	}

	/**
	 * Author :Jyothsna Description :Case Creation using TechPubs Webform
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */
	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6599_Techpubs(InputEnvironmentDetails inputEnvironmentDetails, InputTestDetails testData)
			throws Throwable {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;
		TechpubsLoginPage techpubsLoginPage;
		Techpubs techpubs;
		ISGCasePage isgCasePage;
		CaseSearchPage caseSearchPag;

		FunctionalMethods functionalMethods = new FunctionalMethods();

		// Login to Techpubs Form Portal
		techpubsLoginPage = functionalMethods.openWebformPortalTechpubs(getDriver(), testData.getTestdata()[0]);

		// Entering UsetName ,Password and Submit
		techpubs = functionalMethods.logintoTechpubsWebform(techpubsLoginPage, testData.getTestdata()[1],
				testData.getTestdata()[2]);

		// Validating if Techpubs WebForm is displayed
		assertTrue(techpubs.hasTechPubWebFormPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to Techpubs WebForm Page is Unsuccessful");

		// Validating that Techpubs Form is opened and FirstName and Last name is
		// validated
		assertTrue(techpubs.hasFirstNameDisplayed(testData.getExpectedResult()[1]),
				"First name is not displayed correctly");

		// Validating Address is showing
		assertTrue(techpubs.hasAddressDisplayed(testData.getExpectedResult()[2]),
				" Address is not displayed correctly");

		// Validating that Phone number
		assertTrue(techpubs.hasPhoneNumberDisplayed(testData.getExpectedResult()[3]),
				" Phonenumber is not displayed correctly");

		// Validating that Email
		assertTrue(techpubs.hasTechpubsEmailDisplayed(testData.getExpectedResult()[4]),
				" Email is not displayed correctly");

		// Validating that Primary Message
		assertTrue(techpubs.hasTechpubsPrimaryMessageDisplayed(testData.getExpectedResult()[5]),
				" Email is not displayed correctly");

		// Validating that Techpubs Form Default language is selected
		assertTrue(techpubs.hasTechpubsDefaultLanguageSelected(), " Default Language is not selected");

		// ValidatingDetailed Description filed showing
		assertTrue(techpubs.hasDetailedDescriptionDisplayed(), "Detailed Description  filed is not displayed ");

		// Validating AddFileButton showing
		assertTrue(techpubs.hasAddFileButtonDisplayed(), "AddFileButton   is not displayed ");

		// Validating submit button showing
		assertTrue(techpubs.hasSubmitButtonDisplayed(testData.getExpectedResult()[6]),
				"Submit Button   is not displayed ");

		// Validating Clear Button showing
		assertTrue(techpubs.hasClearButtonDisplayed(testData.getExpectedResult()[7]),
				"Clear Button  is not displayed ");

		// Insert Detailed Description and upload file
		techpubs = functionalMethods.enterdetailedDesUplaodFile(techpubs, testData.getTestdata()[3]);

		// Validating attachment attached
		// assertTrue(techpubs.hasFileAttachedDisplayed(testData.getExpectedResult()[8]),
		// "File not attached successfully");

		// click on clear button and validate validation messages appear
		// techpubs = functionalMethods.clickOnClearButton(techpubs);

		// Insert Detailed Description and upload file
		// techpubs = functionalMethods.enterdetailedDesUplaodFile(techpubs,
		// testData.getTestdata()[3]);

		// Validating attachment attached
		// assertTrue(techpubs.hasFileAttachedDisplayed(testData.getExpectedResult()[8]),
		// "File not attached successfully");

		// click on Submit button
		techpubs = functionalMethods.clickSubmit(techpubs);

		// Validate Final Message
		assertTrue(techpubs.hasFinalMessageDisplayed(testData.getExpectedResult()[9]),
				"Final Message with CaseID is not Displayed");

		// GetCaseId
		techpubs = functionalMethods.getCaseID(techpubs);

		getDriver().manage().deleteAllCookies();

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Validating that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[4],
				testData.getTestdata()[5]);

		// Validating that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[6],
				testData.getTestdata()[7], NavigationClass.class);

		// Navigating to CaseSearch Page
		caseSearchPag = functionalMethods.navigateToCaseSerchPage(navigationClass);

		// Verifying that CaseSearch home page displayed
		assertTrue(caseSearchPag.hasCaseSearchHomePageDisplayed(), "Casesearch page is not displayed correctly");

		// Enter the CaseId in Case Search filed
		caseSearchPag = functionalMethods.enterCaseIDClickCaseSerch(caseSearchPag, GlobalThings.Caseid_Techpubs);

		// Navigate to isgCasePage from isgCaseSearchPage
		isgCasePage = functionalMethods.navigateToISGCasPage(caseSearchPag);

		// Validating that Work Basket is showing
		assertTrue(isgCasePage.hasWorkBasketDisplayed(testData.getExpectedResult()[10]),
				"Work Basket is not displayed correctly");

		// Validate New Status
		assertTrue(isgCasePage.hasStatusNewDisplayed(), "Status as New is not Displayed");

		// Validate Summary
		assertTrue(isgCasePage.hasSummaryTextDisplayed(testData.getExpectedResult()[11]),
				" TechPubs Comment form Submittal is not displayed correctly");

		// Validate priority
		assertTrue(isgCasePage.hasPriorityDrpDwnDisplayed(testData.getExpectedResult()[12]),
				"Priority is not displayed correctly");

		// Validate Origin
		assertTrue(isgCasePage.hasOriginDrpDwnDisplayed(testData.getExpectedResult()[13]),
				"Email is not displayed correctly");

	}

	/**
	 * Author :Lahari Description :Case Creation using TechPubs Webform
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */
	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6853_Techpubs_Negative(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		TechpubsLoginPage techpubsLoginPage;
		Techpubs techpubs;
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;

		NavigationClass navigationClass;
		FunctionalMethods functionalMethods = new FunctionalMethods();

		// Login to Techpubs Form Portal
		techpubsLoginPage = functionalMethods.openWebformPortalTechpubs(getDriver(), testData.getTestdata()[0]);

		// Entering UsetName ,Password and Submit
		techpubs = functionalMethods.logintoTechpubsWebform(techpubsLoginPage, testData.getTestdata()[1],
				testData.getTestdata()[2]);

		// Validating if Techpubs WebForm is displayed
		assertTrue(techpubs.hasTechPubWebFormPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to Techpubs WebForm Page is Unsuccessful");

		// Validating that Techpubs Form is opened and FirstName and Last name is
		// validated
		assertTrue(techpubs.hasFirstNameDisplayed(testData.getExpectedResult()[1]),
				"First name is not displayed correctly");

		// Validating Address is showing
		assertTrue(techpubs.hasAddressDisplayed(testData.getExpectedResult()[2]),
				" Address is not displayed correctly");

		// Validating that Phone number
		assertTrue(techpubs.hasPhoneNumberDisplayed(testData.getExpectedResult()[3]),
				" Phonenumber is not displayed correctly");

		// Validating that Email
		assertTrue(techpubs.hasTechpubsEmailDisplayed(testData.getExpectedResult()[4]),
				" Email is not displayed correctly");

		// Validating that Primary Message
		assertTrue(techpubs.hasTechpubsPrimaryMessageDisplayed(testData.getExpectedResult()[5]),
				" Email is not displayed correctly");

		// Validating that Techpubs Form Default language is selected
		assertTrue(techpubs.hasTechpubsDefaultLanguageSelected(), " Default Language is not selected");

		// ValidatingDetailed Description filed showing
		assertTrue(techpubs.hasDetailedDescriptionDisplayed(), "Detailed Description  filed is not displayed ");

		// Validating AddFileButton showing
		assertTrue(techpubs.hasAddFileButtonDisplayed(), "AddFileButton   is not displayed ");

		// Validating submit button showing
		assertTrue(techpubs.hasSubmitButtonDisplayed(testData.getExpectedResult()[6]),
				"Submit Button   is not displayed ");

		// Validating Clear Button showing
		assertTrue(techpubs.hasClearButtonDisplayed(testData.getExpectedResult()[7]),
				"Clear Button  is not displayed ");

		// Validating that Techpubs Form Default language is selected
		assertTrue(techpubs.hasTechpubsDefaultLanguageSelected(), "Techpubs Default Language is not selected");

		// Select Portugues language
		techpubs = functionalMethods.selectPortuguesLanguage(techpubs);

		// Validating Message in Portugues language
		assertTrue(techpubs.hasPortuguesLanguageMsgDisplayed(), "Validating Message in Portugues language");

		// Select English language
		techpubs = functionalMethods.selectEnglishLanguage(techpubs);

		// click on submit button and validate validation messages appear
		techpubs = functionalMethods.clickOnSubmitButton(techpubs);

		// Enter data into Detailed description filed and uplaod file
		techpubs = functionalMethods.enterdetailedDesUplaodFile(techpubs, testData.getTestdata()[3]);

		// Validating attachment attached
		// assertTrue(techpubs.hasFileAttachedDisplayed(testData.getExpectedResult()[8]),
		// "File not attached successfully");

		// click on Submit button
		techpubs = functionalMethods.clickSubmit(techpubs);

		// Validate Final Message
		assertTrue(techpubs.hasFinalMessageDisplayed(testData.getExpectedResult()[9]),
				"Final Message with CaseID is not Displayed");

		getDriver().manage().deleteAllCookies();

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Validating that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[4],
				testData.getTestdata()[5]);

		// Validating that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[6],
				testData.getTestdata()[7], NavigationClass.class);

		// Validating that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed");

	}

	/**
	 * Author :Jyothsna Sameera Description :Regarding Deere webform details
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 * @throws Throwable
	 */
	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6600_CreateWebFormForDeere(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;
		DeereLoginPage deereLoginPage;
		Deere deere;
		CaseSearchPage caseSearchPag;
		ISGCasePage isgCasePage;

		FunctionalMethods functionalMethods = new FunctionalMethods();

		// opening Deere Form Portal
		deereLoginPage = functionalMethods.openWebformPortal_Deere(getDriver(), testData.getTestdata()[0]);

		// Entering Username ,Password and click on Submit button
		deere = functionalMethods.loginToDeereWebform(deereLoginPage, testData.getTestdata()[1],
				testData.getTestdata()[2]);

		// Validating if Deere WebForm is displayed
		assertTrue(deere.hasDeereWebFormPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to Deere WebForm Page was Unsuccessful");

		// Validating that FirstName is showing
		assertTrue(deere.hasFisrtNameDisplayed(testData.getExpectedResult()[1]),
				"First name is not displayed correctly");

		// Validating that Business Address is showing
		assertTrue(deere.hasAddressDisplayed(testData.getExpectedResult()[2]), "Address is not displayed correctly");

		// Validating Phone number is showing
		assertTrue(deere.hasPhoneNumberDisplayed(testData.getExpectedResult()[3]),
				" Phonenumber is not displayed correctly");

		// Validating Email is showing
		assertTrue(deere.hasEmailAddressDispalyed(testData.getExpectedResult()[4]),
				" Email Address is not displayed correctly");

		// Validating Primary Message is showing
		assertTrue(deere.hasPrimaryMessageDisplayed(testData.getExpectedResult()[5]),
				" Primary Message is not displayed correctly");

		// Validating Country is showing
		assertTrue(deere.hasCountryDisplayed(), " Country is not displayed correctly");

		// Validating Comments is showing
		assertTrue(deere.hasCommentsDisplayed(), " Comments is not displayed correctly");

		// Validating Dealer Name is showing
		assertTrue(deere.hasDealerNameExist(), " Dealer Name does not exist");

		// Validating Dealer City is showing
		assertTrue(deere.hasDealerCityExist(), " Dealer City does not exist");

		// Validating Dealer State is showing
		assertTrue(deere.hasDealerStateExist(), " Dealer State does not exist");

		// Validating Submit button
		assertTrue(deere.hasSubmitButton(testData.getExpectedResult()[6]), "Submit button is not diaplayed");

		// Validating Clear button
		assertTrue(deere.hasClearButton(testData.getExpectedResult()[7]), "Clear button is not diaplayed");

		// select country and Enter description and upload attachment and click on
		// submit button
		deere = functionalMethods.selCounEntDesUplodFile(deere, testData.getTestdata()[3]);

		// Validating that file attachment is attached successfully
		// assertTrue(deere.hasFileAttachedDisplayed(testData.getExpectedResult()[8]),
		// "File attachment not displayed correctly");

		// Click on Clear button, Submit button and Accept Alert
		deere = functionalMethods.clickOnClearBtnSubmitBtnAcptAlrt(deere);

		// Validating Validation Msg for Comments textbox field
		assertTrue(deere.hasValidMessgDisplayed(), "Validation Message of Comments textbox is not displayed correctly");

		// select country and Enter description and upload attachment and click on
		// submit button
		deere = functionalMethods.enterDesUplodFile(deere, testData.getTestdata()[3]);

		// Validating that file attachment is attached successfully
		// assertTrue(deere.hasFileAttachedDisplayed(testData.getExpectedResult()[8]),
		// "File attachment not displayed correctly");

		// Click On Submit button
		deere = functionalMethods.clickOnSubmitButton(deere);

		// Validating Final Message
		assertTrue(deere.hasFinalMessageDisplayed(testData.getExpectedResult()[9]),
				"Final Message with CaseID is not Displayed");

		// GetCaseId
		deere = functionalMethods.getCaseID(deere);

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Validating that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[4],
				testData.getTestdata()[5]);

		// Validating that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[6],
				testData.getTestdata()[7], NavigationClass.class);

		// Validating that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed");

		// Navigating to CaseSearch Page
		caseSearchPag = functionalMethods.navigateToCaseSerchPage(navigationClass);

		// Verifying that CaseSearch home page displayed
		assertTrue(caseSearchPag.hasCaseSearchHomePageDisplayed(), "Casesearch page is not displayed correctly");

		// Enter the CaseId in Case Search filed
		caseSearchPag = functionalMethods.enterCaseIDClickCaseSerch(caseSearchPag, GlobalThings.caseID_Deere);

		// Navigate to isgCasePage from isgCaseSearchPage
		isgCasePage = functionalMethods.navigateToISGCasPage(caseSearchPag);

		// Validating that Work Basket is displayed
		assertTrue(isgCasePage.hasGSCWorkBasketDisplayed(), "Work Basket is not displayed");

		// Validating that New Status is displayed
		assertTrue(isgCasePage.hasStatusNewDisplayed(), "Status as New is not Displayed");

		// Validating that Summary is displayed
		assertTrue(isgCasePage.hasSummaryTextDisplayed(testData.getExpectedResult()[10]),
				"Deere.com Comment form Submittal  is not Displayed");

		// Validating that Priority is displayed
		assertTrue(isgCasePage.hasPriorityDrpDwnDisplayed(testData.getExpectedResult()[11]), "Normal is not Displayed");

		// Validating that Origin is displayed
		assertTrue(isgCasePage.hasOriginDrpDwnDisplayed(testData.getExpectedResult()[12]), "Email is not Displayed");
	}

	/**
	 * Author :Jyothsna Sameera Description :Regarding Deere webform details
	 * Negative
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 * @throws Throwable
	 */

	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6855_CreateWebFormForDeere_Negative(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		ISGCaseSearchPage isgCaseSearchPage;
		NavigationClass navigationClass;
		DeereLoginPage deereLoginPage;
		Deere deere;
		CaseSearchPage caseSearchPag;
		ISGCasePage isgCasePage;

		FunctionalMethods functionalMethods = new FunctionalMethods();

		// opening Deere Form Portal
		deereLoginPage = functionalMethods.openWebformPortal_Deere(getDriver(), testData.getTestdata()[0]);

		// Entering Username ,Password and click on Submit button
		deere = functionalMethods.loginToDeereWebform(deereLoginPage, testData.getTestdata()[1],
				testData.getTestdata()[2]);

		// Validating if Deere WebForm is displayed
		assertTrue(deere.hasDeereWebFormPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to Deere WebForm Page was Unsuccessful");

		// Validating that FirstName is showing
		assertTrue(deere.hasFisrtNameDisplayed(testData.getExpectedResult()[1]),
				"First name is not displayed correctly");

		// Validating that Business Address is showing
		assertTrue(deere.hasAddressDisplayed(testData.getExpectedResult()[2]), "Address is not displayed correctly");

		// Validating Phone number is showing
		assertTrue(deere.hasPhoneNumberDisplayed(testData.getExpectedResult()[3]),
				" Phonenumber is not displayed correctly");

		// Validating Email is showing
		assertTrue(deere.hasEmailAddressDispalyed(testData.getExpectedResult()[4]),
				" Email Address is not displayed correctly");

		// Validating Primary Message is showing
		assertTrue(deere.hasPrimaryMessageDisplayed(testData.getExpectedResult()[5]),
				" Primary Message is not displayed correctly");

		// Validating Country is showing
		assertTrue(deere.hasCountryDisplayed(), " Country is not displayed correctly");

		// Validating Comments is showing
		assertTrue(deere.hasCommentsDisplayed(), " Comments is not displayed correctly");

		// Validating Dealer Name is showing
		assertTrue(deere.hasDealerNameExist(), " Dealer Name does not exist");

		// Validating Dealer City is showing
		assertTrue(deere.hasDealerCityExist(), " Dealer City does not exist");

		// Validating Dealer State is showing
		assertTrue(deere.hasDealerStateExist(), " Dealer State does not exist");

		// Validating Submit button
		assertTrue(deere.hasSubmitButton(testData.getExpectedResult()[6]), "Submit button is not diaplayed");

		// Validating Clear button
		assertTrue(deere.hasClearButton(testData.getExpectedResult()[7]), "Clear button is not diaplayed");

		// Click On Submit button and Accept Alert
		deere = functionalMethods.clickSbmtBtnAcptAlrt(deere);

		// Validating Validation Msg for Comments textbox field
		assertTrue(deere.hasValidMessgDisplayed(),"Validation Message of Comments textbox is not displayed correctly");

		// selecting country and Entering description and upload attachment and click on
		// submit button
		deere = functionalMethods.selCounEntDesUplodFile(deere, testData.getTestdata()[3]);

		// Validating that file attachment is attached successfully
//		assertTrue(deere.hasFileAttachedDisplayed(testData.getExpectedResult()[8]),
//				"File attachment not displayed correctly");

		// Click On Submit button
		deere = functionalMethods.clickOnSubmitButton(deere);

		// Validating Final Message
		assertTrue(deere.hasFinalMessageDisplayed(testData.getExpectedResult()[9]),
				"Final Message with CaseID is not Displayed");

		// GetCaseId
		deere = functionalMethods.getCaseID(deere);

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Validating that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[4],
				testData.getTestdata()[5]);

		// Validating that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[6],
				testData.getTestdata()[7], NavigationClass.class);

		// Validating that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed");

		// Navigating to CaseSearch Page
		caseSearchPag = functionalMethods.navigateToCaseSerchPage(navigationClass);

		// Verifying that CaseSearch home page displayed
		assertTrue(caseSearchPag.hasCaseSearchHomePageDisplayed(), "Casesearch page is not displayed correctly");

		// Enter the CaseId in Case Search filed
		caseSearchPag = functionalMethods.enterCaseIDClickCaseSerch(caseSearchPag, GlobalThings.caseID_Deere);

		// Navigate to isgCasePage from isgCaseSearchPage
		isgCasePage = functionalMethods.navigateToISGCasPage(caseSearchPag);

		// Validating that Work Basket is displayed
		assertTrue(isgCasePage.hasGSCWorkBasketDisplayed(), "Work Basket is not displayed");

		// Validating that New Status is displayed
		assertTrue(isgCasePage.hasStatusNewDisplayed(), "Status as New is not Displayed");

		// Validating that Summary is displayed
		assertTrue(isgCasePage.hasSummaryTextDisplayed(testData.getExpectedResult()[10]),
				"Deere.com Comment form Submittal  is not Displayed");

		// Validating that Priority is displayed
		assertTrue(isgCasePage.hasPriorityDrpDwnDisplayed(testData.getExpectedResult()[11]), "Normal is not Displayed");

		// Validating that Origin is displayed
		assertTrue(isgCasePage.hasOriginDrpDwnDisplayed(testData.getExpectedResult()[12]), "Email is not Displayed");

	}

	/**
	 * Author :Aparajita Description :Regarding Stellar Support details.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 * @throws Throwable
	 */

	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6589_WebFormStellarSupport(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;
		StellarSupport ss;
		ISGCaseSearchPage isgCaseSearchPage;
		StellarSupportWebformSubmissionPage stellarSupportWebformSubmissionPage;
		ISGCasePage isgCasePage;
		CaseSearchPage caseSearchPag;

		FunctionalMethods functionalMethods = new FunctionalMethods();

		// Login to StellarSupport WebForm
		ss = functionalMethods.openWebFormPortal(getDriver(), testData.getTestdata()[0]);

		// Entering Username ,Password and click on Submit button
		stellarSupportWebformSubmissionPage = functionalMethods.logintoWebform(ss, testData.getTestdata()[1],
				testData.getTestdata()[2]);

		// Validating if StellarSupport WebForm is displayed
		assertTrue(stellarSupportWebformSubmissionPage.hasStellarSupportWebFormPageDisplayed(
				testData.getExpectedResult()[0]), "Navigation to StellarSupport WebForm Page was Unsuccessful");

		// Validating that FirstName is showing
		assertTrue(stellarSupportWebformSubmissionPage.hasFirstNameDispalyed(testData.getExpectedResult()[1]),
				"First name is not displayed correctly");

		// Validating that Business Name is showing
		assertTrue(stellarSupportWebformSubmissionPage.hasStellarBusinessNameDisplayed(testData.getExpectedResult()[2]),
				"Business Name is not displayed correctly");

		// Validating that Business Address is showing
		assertTrue(stellarSupportWebformSubmissionPage.hasStellarBusinessAddrDisplayed(testData.getExpectedResult()[3]),
				"Business Address is not displayed correctly");

		// Validating that Phone number is showing
		assertTrue(stellarSupportWebformSubmissionPage.hasStellarPhoneDisplayed(testData.getExpectedResult()[4]),
				"Phone number is not displayed correctly");

		// Validating that Email is showing
		assertTrue(stellarSupportWebformSubmissionPage.hasStellarEmailDisplayed(testData.getExpectedResult()[5]),
				"Email is not displayed correctly");

		// Validating that Primary Message is showing
		assertTrue(
				stellarSupportWebformSubmissionPage.hasStellarPrimaryMessageDisplayed(testData.getExpectedResult()[6]),
				"Primary Message is not displayed correctly");

		// Validating that Dealer Name Textbox is displayed
		assertTrue(stellarSupportWebformSubmissionPage.hasDealerNameDisplayed(),
				"Dealer Name Textbox is not displayed");

		// Validating that Dealer City Textbox is displayed
		assertTrue(stellarSupportWebformSubmissionPage.hasDealerCityDisplayed(),
				"Dealer City Textbox is not displayed");

		// Validating that Dealer State Textbox is displayed
		assertTrue(stellarSupportWebformSubmissionPage.hasDealerStateDisplayed(),
				"Dealer State Textbox is not displayed");

		// Validating that Clear button is displayed
		assertTrue(stellarSupportWebformSubmissionPage.hasClearButtonDisplayed(testData.getExpectedResult()[7]),
				"Clear button is not diaplayed");

		// Enter Detailed Description and Attaching file
		stellarSupportWebformSubmissionPage = functionalMethods
				.detailedDescriptionAndAttachFile(stellarSupportWebformSubmissionPage, testData.getTestdata()[3]);

		// Validating that file attachment is attached successfully
		assertTrue(stellarSupportWebformSubmissionPage.hasFileAttachedDisplayed(testData.getExpectedResult()[8]),
				"File attachment not displayed correctly");

		// Click on Clear button, Submit button and Accept Alert
		stellarSupportWebformSubmissionPage = functionalMethods
				.clickOnClearBtnSubmitBtnAcceptAlert(stellarSupportWebformSubmissionPage);

		// Validating Validation Msg for Comments textbox field
		assertTrue(stellarSupportWebformSubmissionPage.hasErrorMsgDisplayed(testData.getExpectedResult()[9]),
				"Validation Message of Comments textbox is not displayed correctly");

		// Enter data into Detailed Description field and Attach file
		stellarSupportWebformSubmissionPage = functionalMethods
				.detailedDescriptionAndAttachFile(stellarSupportWebformSubmissionPage, testData.getTestdata()[3]);

		// Validating that file attachment is attached successfully
		assertTrue(stellarSupportWebformSubmissionPage.hasFileAttachedDisplayed(testData.getExpectedResult()[8]),
				"File attachment not displayed correctly");

		// Click on Submit button
		stellarSupportWebformSubmissionPage = functionalMethods.clickSubmit(stellarSupportWebformSubmissionPage);

		// Validating that Final Message is displayed
		assertTrue(stellarSupportWebformSubmissionPage.hasFinalMessageDisplayed(testData.getExpectedResult()[10]),
				"Final Message is not Displayed");

		// Storing CaseID
		stellarSupportWebformSubmissionPage = functionalMethods.getCaseID(stellarSupportWebformSubmissionPage);

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Validating that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[4],
				testData.getTestdata()[5]);

		// Validating that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[6],
				testData.getTestdata()[7], NavigationClass.class);

		// Validating that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed");

		// Navigate to Case search page
		caseSearchPag = functionalMethods.navigateToCaseSerchPage(navigationClass);

		// Validating that navigated to Case search page
		assertTrue(caseSearchPag.hasCaseSearchHomePageDisplayed(), "Casesearch page is not displayed correctly");

		// Enter the CaseId in Case Search filed
		caseSearchPag = functionalMethods.enterCaseIDClickCaseSerch(caseSearchPag, GlobalThings.caseID_StellarSupport);

		// Navigate to isgCasePage from isgCaseSearchPage
		isgCasePage = functionalMethods.navigateToISGCasPage(caseSearchPag);

		// Validating that Priority is displayed
		assertTrue(isgCasePage.hasPriorityTextDisplayed(),"Priority is not displayed correctly");

		// Validating that Origin is displayed
		assertTrue(isgCasePage.hasOriginTextDisplayed(),"Origin is not displayed correctly");

		// Click on Action Button Then WorkCase And Accept Button
		isgCasePage = functionalMethods.clickOnActionsBtnThenWorkCaseAndAcceptBtn(isgCasePage);

		// Validating that Owned Status is displayed
		assertTrue(isgCasePage.hasOwnedStatusDisplayed(testData.getExpectedResult()[13]),
				"Owned Status is not displayed");

	}

	/**
	 * Author :Aparajita Description :Regarding Stellar Support details Negative.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 * @throws Throwable
	 */

	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6869_WebFormStellarSupportNegative(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		StellarSupport ss;
		StellarSupportWebformSubmissionPage stellarSupportWebformSubmissionPage;
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;

		FunctionalMethods functionalMethods = new FunctionalMethods();

		// Login to StellarSupport WebForm
		ss = functionalMethods.openWebFormPortal(getDriver(), testData.getTestdata()[0]);

		// Entering Username ,Password and click on Submit button
		stellarSupportWebformSubmissionPage = functionalMethods.logintoWebform(ss, testData.getTestdata()[1],
				testData.getTestdata()[2]);

		// Validating if StellarSupport WebForm is displayed
		assertTrue(stellarSupportWebformSubmissionPage.hasStellarSupportWebFormPageDisplayed(
				testData.getExpectedResult()[0]), "Navigation to StellarSupport WebForm Page was Unsuccessful");

		// Validating that FirstName is showing
		assertTrue(stellarSupportWebformSubmissionPage.hasFirstNameDispalyed(testData.getExpectedResult()[1]),
				"First name is not displayed correctly");

		// Validating that Business Name is showing
		assertTrue(stellarSupportWebformSubmissionPage.hasStellarBusinessNameDisplayed(testData.getExpectedResult()[2]),
				"Business Name is not displayed correctly");

		// Validating that Business Address is showing
		assertTrue(stellarSupportWebformSubmissionPage.hasStellarBusinessAddrDisplayed(testData.getExpectedResult()[3]),
				"Business Address is not displayed correctly");

		// Validating that Phone number is showing
		assertTrue(stellarSupportWebformSubmissionPage.hasStellarPhoneDisplayed(testData.getExpectedResult()[4]),
				"Phone number is not displayed correctly");

		// Validating that Email is showing
		assertTrue(stellarSupportWebformSubmissionPage.hasStellarEmailDisplayed(testData.getExpectedResult()[5]),
				"Email is not displayed correctly");

		// Validating that Primary Message is showing
		assertTrue(
				stellarSupportWebformSubmissionPage.hasStellarPrimaryMessageDisplayed(testData.getExpectedResult()[6]),
				"Primary Message is not displayed correctly");

		// Validating that Dealer Name Textbox is displayed
		assertTrue(stellarSupportWebformSubmissionPage.hasDealerNameDisplayed(),
				"Dealer Name Textbox is not displayed");

		// Validating that Dealer City Textbox is displayed
		assertTrue(stellarSupportWebformSubmissionPage.hasDealerCityDisplayed(),
				"Dealer City Textbox is not displayed");

		// Validating that Dealer State Textbox is displayed
		assertTrue(stellarSupportWebformSubmissionPage.hasDealerStateDisplayed(),
				"Dealer State Textbox is not displayed");

		// Validating that Clear button is displayed
		assertTrue(stellarSupportWebformSubmissionPage.hasClearButtonDisplayed(testData.getExpectedResult()[7]),
				"Clear button is not diaplayed");

		// Click Submit button And Accept Alert
		stellarSupportWebformSubmissionPage = functionalMethods
				.clickSubmitAndAcceptAlert(stellarSupportWebformSubmissionPage);

		// Validating Validation Msg for Comments textbox field
		assertTrue(stellarSupportWebformSubmissionPage.hasErrorMsgDisplayed(testData.getExpectedResult()[9]),
				"Validation Message of Comments textbox is not displayed correctly");

		// Enter Stellar support Detailed Description and Attaching file
		stellarSupportWebformSubmissionPage = functionalMethods
				.detailedDescriptionAndAttachFile(stellarSupportWebformSubmissionPage, testData.getTestdata()[3]);

		// Validating that file attachment is attached successfully
		assertTrue(stellarSupportWebformSubmissionPage.hasFileAttachedDisplayed(testData.getExpectedResult()[8]),
				"File attachment not displayed correctly");

		// Click on Submit button
		stellarSupportWebformSubmissionPage = functionalMethods.clickSubmit(stellarSupportWebformSubmissionPage);

		// Validating that Final Message is displayed
		assertTrue(stellarSupportWebformSubmissionPage.hasFinalMessageDisplayed(testData.getExpectedResult()[10]),
				"Final Message is not Displayed");

		// Storing CaseID
		stellarSupportWebformSubmissionPage = functionalMethods.getCaseID(stellarSupportWebformSubmissionPage);

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Validating that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[4],
				testData.getTestdata()[5]);

		// Validating that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[6],
				testData.getTestdata()[7], NavigationClass.class);

		// Validating that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed");

	}

	/**
	 * Author :Lahari P Description :Regarding South East Asia details.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 * @throws Throwable
	 */

	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6614_WebFormSouthEastAsia(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		ISGCaseSearchPage isgCaseSearchPage;
		ISGCasePage isgCasePage;
		SouthEastAsiaLoginPage southEastAsiaLoginPage;
		SouthEastAsia southEastAsia;
		NavigationClass navigationClass;
		CaseSearchPage caseSearchPag;

		FunctionalMethods functionalMethods = new FunctionalMethods();

		// opening SouthEastAsia Form Portal
		southEastAsiaLoginPage = functionalMethods.openWebformPortal_SouthEastAsia(getDriver(),
				testData.getTestdata()[0]);

		// Entering Username ,Password and click on Submit
		southEastAsia = functionalMethods.loginToSouthEastAsiaWebform(southEastAsiaLoginPage, testData.getTestdata()[1],
				testData.getTestdata()[2]);

		// Validating if South East Asia WebForm is displayed
		assertTrue(southEastAsia.hasSouthEastAsiaWebFormPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to South East Asia WebForm Page was Unsuccessful");

		// Validating that FirstName is showing
		assertTrue(southEastAsia.hasFirstNameDisplayed(testData.getExpectedResult()[1]),
				"First name is not displayed correctly");

		// Validating that Business Address is showing
		assertTrue(southEastAsia.hasSouthEastAsiaBusinessAddrDisplayed(testData.getExpectedResult()[2]),
				"Business Address is not displayed correctly");

		// Validating that Phone number is showing
		assertTrue(southEastAsia.hasSouthEastAsiaPhoneDisplayed(testData.getExpectedResult()[3]),
				"Phonenumber is not Displayed correctly");

		// Validating that Email is showing
		assertTrue(southEastAsia.hasSouthEastAsiaEmailDisplayed(testData.getExpectedResult()[4]),
				"Email is not Displayed correctly");

		// Validating that Primary Message is showing
		assertTrue(southEastAsia.hasSouthEastAsiaPrimaryMessageDisplayed(testData.getExpectedResult()[5]),
				"Primary Message is not Displayed correctly");

		// Entering Detailed description and Attaching file
		southEastAsia = functionalMethods.detailedDesptAndAttachFileSouthEastAsia(southEastAsia,
				testData.getTestdata()[3]);

		// Validating that file attachment is attached successfully
		assertTrue(southEastAsia.hasFileAttachedDisplayed(testData.getExpectedResult()[7]),
				"File attachment not displayed correctly");

		// Validate that Clear button is displayed
		assertTrue(southEastAsia.hasClearButtonDisplayed(), "Clear button is not diaplayed");

		// Click on Clear button, Submit button and Accept Alert
		southEastAsia = functionalMethods.clickOnClearBtnSubmitBtnAcceptAlert(southEastAsia);

		// Validating Validation Msg for Comments textbox field
		assertTrue(southEastAsia.hasErrorMsgDisplayed(testData.getExpectedResult()[8]),
				"Validation Message of Comments textbox is not displayed correctly");

		// Entering the Detailed description and Attaching file
		southEastAsia = functionalMethods.detailedDesptAndAttachFileSouthEastAsia(southEastAsia,
				testData.getTestdata()[3]);

		// Validating that file attachment is attached successfully
		assertTrue(southEastAsia.hasFileAttachedDisplayed(testData.getExpectedResult()[7]),
				"File attachment not displayed correctly");

		// click on Submit btn
		southEastAsia = functionalMethods.clickSubmitBtn(southEastAsia);

		// Validate that Final Message is displayed
		assertTrue(southEastAsia.hasFinalMessageDisplayed(testData.getExpectedResult()[9]),
				"Final Message is not Displayed correctly");

		// Storing CaseID
		southEastAsia = functionalMethods.getCaseID(southEastAsia);

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Validating that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[4],
				testData.getTestdata()[5]);

		// Validating that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[6],
				testData.getTestdata()[7], NavigationClass.class);

		// Validating that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed");

		// Navigate to Case search page
		caseSearchPag = functionalMethods.navigateToCaseSerchPage(navigationClass);

		// Validating that navigated to Case search page
		assertTrue(caseSearchPag.hasCaseSearchHomePageDisplayed(), "Casesearch page is not displayed correctly");

		// Enter the CaseId in Case Search filed
		caseSearchPag = functionalMethods.enterCaseIDClickCaseSerch(caseSearchPag, GlobalThings.caseID_SouthEastAsia);

		// Navigate to isgCasePage from isgCaseSearchPage
		isgCasePage = functionalMethods.navigateToISGCasPage(caseSearchPag);

		// Validating that Work Basket is displayed
		assertTrue(isgCasePage.hasWorkBasketDisplayed(testData.getExpectedResult()[10]),
				"Work Basket is not displayed");

		// Validating that Priority is displayed
		assertTrue(isgCasePage.hasPriorityTextDisplayed(),"Priority is not displayed correctly");

		// Validating that Origin is displayed
		assertTrue(isgCasePage.hasOriginTextDisplayed(),"Origin is not displayed correctly");

		// Click on Action Button Then WorkCase And Accept Button
		isgCasePage = functionalMethods.clickOnActionsBtnThenWorkCaseAndAcceptBtn(isgCasePage);

		// Validating that Owned Status is displayed
		assertTrue(isgCasePage.hasOwnedStatusDisplayed(testData.getExpectedResult()[13]),
				"Owned Status is not displayed correctly");

	}

	/**
	 * Author :Lahari P Description :Regarding South East Asia details Negative.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 * @throws Throwable
	 */

	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6861_WebFormSouthEastAsiaNegative(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SouthEastAsiaLoginPage southEastAsiaLoginPage;
		SouthEastAsia southEastAsia;
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;

		FunctionalMethods functionalMethods = new FunctionalMethods();

		// opening SouthEastAsia Form Portal
		southEastAsiaLoginPage = functionalMethods.openWebformPortal_SouthEastAsia(getDriver(),
				testData.getTestdata()[0]);

		// Entering Username ,Password and click on Submit
		southEastAsia = functionalMethods.loginToSouthEastAsiaWebform(southEastAsiaLoginPage, testData.getTestdata()[1],
				testData.getTestdata()[2]);

		// Validating if South East Asia WebForm is displayed
		assertTrue(southEastAsia.hasSouthEastAsiaWebFormPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to South East Asia WebForm Page was Unsuccessful");

		// Validating that FirstName is showing
		assertTrue(southEastAsia.hasFirstNameDisplayed(testData.getExpectedResult()[1]),
				"First name is not displayed correctly");

		// Validating that Business Address is showing
		assertTrue(southEastAsia.hasSouthEastAsiaBusinessAddrDisplayed(testData.getExpectedResult()[2]),
				"Business Address is not displayed correctly");

		// Validating that Phone number is showing
		assertTrue(southEastAsia.hasSouthEastAsiaPhoneDisplayed(testData.getExpectedResult()[3]),
				"Phonenumber is not Displayed correctly");

		// Validating that Email is showing
		assertTrue(southEastAsia.hasSouthEastAsiaEmailDisplayed(testData.getExpectedResult()[4]),
				"Email is not Displayed correctly");

		// Validating that Primary Message is showing
		assertTrue(southEastAsia.hasSouthEastAsiaPrimaryMessageDisplayed(testData.getExpectedResult()[5]),
				"Primary Message is not Displayed correctly");

		// click on Submit btn and Accept Alert
		southEastAsia = functionalMethods.clickSubmitBtnAndAcceptAlert(southEastAsia);

		// Validating that Error Message is displayed
		assertTrue(southEastAsia.hasErrorMsgDisplayed(testData.getExpectedResult()[8]),
				"Validation Message of Comments textbox is not displayed correctly");

		// Entering the Detailed description and Attaching file
		southEastAsia = functionalMethods.detailedDesptAndAttachFileSouthEastAsia(southEastAsia,
				testData.getTestdata()[3]);

		// Validating that file attachment is attached successfully
		assertTrue(southEastAsia.hasFileAttachedDisplayed(testData.getExpectedResult()[7]),
				"File attachment not displayed correctly");

		// click on Submit btn
		southEastAsia = functionalMethods.clickSubmitBtn(southEastAsia);

		// Validate that Final Message is displayed
		assertTrue(southEastAsia.hasFinalMessageDisplayed(testData.getExpectedResult()[9]),
				"Final Message is not Displayed correctly");

		// Storing CaseID
		southEastAsia = functionalMethods.getCaseID(southEastAsia);

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Validating that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[4],
				testData.getTestdata()[5]);

		// Validating that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[6],
				testData.getTestdata()[7], NavigationClass.class);

		// Validating that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed");

	}

	/**
	 * Author :Aparajita Description :Regarding India webform details.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 * @throws Throwable
	 */

	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6594_WebFormIndia(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		ISGCaseSearchPage isgCaseSearchPage;
		NavigationClass navigationClass;
		IndiaLoginPage indiaLoginPage;
		India India;
		ISGCasePage isgCasePage;
		CaseSearchPage caseSearchPag;

		FunctionalMethods functionalMethods = new FunctionalMethods();

		// opening India Form Portal
		indiaLoginPage = functionalMethods.openWebformPortal_India(getDriver(), testData.getTestdata()[0]);

		// Entering Username ,Password and click on Submit button
		India = functionalMethods.loginToIndiaWebform(indiaLoginPage, testData.getTestdata()[1],
				testData.getTestdata()[2]);

		// Validating if India WebForm is displayed
		assertTrue(India.hasIndiaWebFormPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to India WebForm Page was Unsuccessful");

		// Validating that FirstName is showing
		assertTrue(India.hasIndiaFirstNameDisplayed(testData.getExpectedResult()[1]),
				"First name is not displayed correctly");

		// Validating that Business Name is showing
		assertTrue(India.hasIndiaBusinessNameDisplayed(testData.getExpectedResult()[2]),
				"Business Name is not displayed correctly");

		// Validating that Business Address is displayed
		assertTrue(India.hasIndiaBusinessAddrDisplayed(testData.getExpectedResult()[3]),
				"Business Address is not displayed correctly");

		// Validating that Phone number is displayed
		assertTrue(India.hasIndiaPhoneDisplayed(testData.getExpectedResult()[4]),
				"Phonenumber is not displayed correctly");

		// Validating that Email is displayed
		assertTrue(India.hasIndiaEmailDisplayed(testData.getExpectedResult()[5]), "Email is not displayed correctly");

		// Validating that Primary Message is displayed
		assertTrue(India.hasIndiaPrimaryMessageDisplayed(testData.getExpectedResult()[6]),
				"Primary message is not displayed correctly");

		// Entering the WebForm Detailed_description and Attaching file
		India = functionalMethods.detailedDescriptionAndAttachFile(India, testData.getTestdata()[3]);

		// Validating that file attachment is attached successfully
		assertTrue(India.hasFileAttachedDisplayed(testData.getExpectedResult()[7]),
				"File attachment not displayed correctly");

		// Validate clear button
		assertTrue(India.hasClearButtonDisplayed(testData.getExpectedResult()[8]), "Clear button is not displayed");

		// Click on Clear button, Submit button and Accept Alert
		India = functionalMethods.clickOnClearBtnSubmitBtnAcceptAlert(India);

		// Validating Validation Msg for Comments textbox field
		assertTrue(India.hasCommErrorMsgDisplayed(testData.getExpectedResult()[9]),
				"Validation Message of Comments textbox is not displayed correctly");

		// Entering the WebForm Detailed_description and Attaching file
		India = functionalMethods.detailedDescriptionAndAttachFile(India, testData.getTestdata()[3]);

		// Validating that file attachment is attached successfully
		assertTrue(India.hasFileAttachedDisplayed(testData.getExpectedResult()[7]),
				"File attachment not displayed correctly");

		// Click on Submit Btn
		India = functionalMethods.clickSubmitBtn(India);

		// Validating that Final Message is displayed
		assertTrue(India.hasFinalMessageDisplayed(testData.getExpectedResult()[10]),
				"Final Message is not Displayed correctly");

		// Storing CaseId
		India = functionalMethods.getCaseID(India);

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Verify that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[4],
				testData.getTestdata()[5]);

		// Verify that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[6],
				testData.getTestdata()[7], NavigationClass.class);

		// Verify that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed");

		// Navigate to Case search page
		caseSearchPag = functionalMethods.navigateToCaseSerchPage(navigationClass);

		// Validating that navigated to Case search page
		assertTrue(caseSearchPag.hasCaseSearchHomePageDisplayed(), "Casesearch page is not displayed correctly");

		// Enter the CaseId in Case Search filed
		caseSearchPag = functionalMethods.enterCaseIDClickCaseSerch(caseSearchPag, GlobalThings.caseID_India);

		// Navigate to isgCasePage from isgCaseSearchPage
		isgCasePage = functionalMethods.navigateToISGCasPage(caseSearchPag);

		// Validating that Work Basket is displayed
		assertTrue(isgCasePage.hasWorkBasketDisplayed(testData.getExpectedResult()[11]),
				"Work Basket is not displayed");

		// Validating that Priority is displayed
		assertTrue(isgCasePage.hasPriorityTextDisplayed(),"Priority is not displayed correctly");

		// Validating that Origin is displayed
		assertTrue(isgCasePage.hasOriginTextDisplayed(),"Origin is not displayed correctly");

		// Click on Action Button Then WorkCase And Accept Button
		isgCasePage = functionalMethods.clickOnActionsBtnThenWorkCaseAndAcceptBtn(isgCasePage);

		// Validating that Owned Status is displayed
		assertTrue(isgCasePage.hasOwnedStatusDisplayed(testData.getExpectedResult()[14]),
				"Owned Status is not displayed correctly");

	}

	/**
	 * Author :Aparajita Description :Regarding India webform details Negative.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 * @throws Throwable
	 */

	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6856_WebFormIndiaNegative(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		IndiaLoginPage indiaLoginPage;
		India India;
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;

		FunctionalMethods functionalMethods = new FunctionalMethods();

		// opening India Form Portal
		indiaLoginPage = functionalMethods.openWebformPortal_India(getDriver(), testData.getTestdata()[0]);

		// Entering Username ,Password and click on Submit button
		India = functionalMethods.loginToIndiaWebform(indiaLoginPage, testData.getTestdata()[1],
				testData.getTestdata()[2]);

		// Validating if India WebForm is displayed
		assertTrue(India.hasIndiaWebFormPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to India WebForm Page was Unsuccessful");

		// Validating that FirstName is showing
		assertTrue(India.hasIndiaFirstNameDisplayed(testData.getExpectedResult()[1]),
				"First name is not displayed correctly");

		// Validating that Business Name is showing
		assertTrue(India.hasIndiaBusinessNameDisplayed(testData.getExpectedResult()[2]),
				"Business Name is not displayed correctly");

		// Validating that Business Address is displayed
		assertTrue(India.hasIndiaBusinessAddrDisplayed(testData.getExpectedResult()[3]),
				"Business Address is not displayed correctly");

		// Validating that Phone number is displayed
		assertTrue(India.hasIndiaPhoneDisplayed(testData.getExpectedResult()[4]),
				"Phonenumber is not displayed correctly");

		// Validating that Email is displayed
		assertTrue(India.hasIndiaEmailDisplayed(testData.getExpectedResult()[5]), "Email is not displayed correctly");

		// Validating that Primary Message is displayed
		assertTrue(India.hasIndiaPrimaryMessageDisplayed(testData.getExpectedResult()[6]),
				"Primary Message is not displayed correctly");

		// Click Submit button And Accept Alert
		India = functionalMethods.clickSubmitAndAcceptAlert(India);

		// Validating Validation Msg for Comments textbox field
		assertTrue(India.hasCommErrorMsgDisplayed(testData.getExpectedResult()[9]),
				"Validation Message of Comments textbox is not displayed correctly");

		// Entering the WebForm Detailed_description and Attaching file
		India = functionalMethods.detailedDescriptionAndAttachFile(India, testData.getTestdata()[3]);

		// Validating that file attachment is attached successfully
		assertTrue(India.hasFileAttachedDisplayed(testData.getExpectedResult()[7]),
				"File attachment not displayed correctly");

		// Click on Submit Btn
		India = functionalMethods.clickSubmitBtn(India);

		// Validating that Final Message is displayed
		assertTrue(India.hasFinalMessageDisplayed(testData.getExpectedResult()[10]),
				"Final Message is not Displayed correctly");

		// Storing CaseId
		India = functionalMethods.getCaseID(India);

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Verify that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[4],
				testData.getTestdata()[5]);

		// Verify that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[6],
				testData.getTestdata()[7], NavigationClass.class);

		// Verify that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed");

	}

	/**
	 * Author :Aparajita Description :Regarding Sub sahara South Details
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 * @throws Throwable
	 */

	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6590_WebFormSubSahara(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		ISGCaseSearchPage isgCaseSearchPage;
		SouthSahara southSahara;
		SouthSaharaLoginPage southSaharaLoginPage;
		ISGCasePage isgCasePage;
		NavigationClass navigationClass;
		CaseSearchPage caseSearchPag;

		FunctionalMethods functionalMethods = new FunctionalMethods();

		// opening SouthSahara Form Portal
		southSaharaLoginPage = functionalMethods.openWebformPortal_SouthSahara(getDriver(), testData.getTestdata()[0]);

		// Entering Username ,Password and click on Submit button
		southSahara = functionalMethods.logintoSouthSaharaWebform(southSaharaLoginPage, testData.getTestdata()[1],
				testData.getTestdata()[2]);

		// Validating if SouthSahara WebForm is displayed
		assertTrue(southSahara.hasSouthSaharaWebFormPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to SouthSahara WebForm Page was Unsuccessful");

		// Validating that FirstName is showing
		assertTrue(southSahara.hasFirstNameDisplayed(testData.getExpectedResult()[1]),
				"First name is not displayed correctly");

		// Validating that Business Address is showing
		assertTrue(southSahara.hasSouthSaharaBusinessAddrDisplayed(testData.getExpectedResult()[2]),
				"Business Address is not displayed correctly");

		// Validating that Phone number is showing
		assertTrue(southSahara.hasSouthSaharaPhoneDisplayed(testData.getExpectedResult()[3]),
				"Phone number is not displayed correctly");

		// Validating that Email is showing
		assertTrue(southSahara.hasSouthSaharaEmailDisplayed(testData.getExpectedResult()[4]),
				"Email is not displayed correctly");

		// Validating that Primary Message is showing
		assertTrue(southSahara.hasSouthSaharaPrimaryMessageDisplayed(testData.getExpectedResult()[5]),
				"Primary Message is not displayed correctly");

		// Enter Detailed Description and Attaching file
		southSahara = functionalMethods.detailedDescriptionAndAttachFile(southSahara, testData.getTestdata()[3]);

		// Validating that file attachment is attached successfully
		assertTrue(southSahara.hasFileAttachedDisplayed(testData.getExpectedResult()[7]),
				"File attachment not displayed correctly");

		// Validating that Clear button is displayed
		assertTrue(southSahara.hasClearButtonDisplayed(testData.getExpectedResult()[6]),
				"Clear button is not diaplayed");

		// Click on Clear button, Submit button and Accept Alert
		southSahara = functionalMethods.clickOnClearBtnSubmitBtnAcceptAlert(southSahara);

		// Validating Validation Msg for Comments textbox field
		assertTrue(southSahara.hasErrorMsgDisplayed(testData.getExpectedResult()[8]),
				"Validation Message of Comments textbox is not displayed correctly");

		// Enter Detailed Description and Attaching file
		southSahara = functionalMethods.detailedDescriptionAndAttachFile(southSahara, testData.getTestdata()[3]);

		// Validating that file attachment is attached successfully
		assertTrue(southSahara.hasFileAttachedDisplayed(testData.getExpectedResult()[7]),
				"File attachment not displayed correctly");

		// click on Submit btn
		southSahara = functionalMethods.clickSubmitBtn(southSahara);

		// Validating that Final Message is displayed
		assertTrue(southSahara.hasFinalMessageDisplayed(testData.getExpectedResult()[9]),
				"Final Message is not Displayed correctly");

		// Get CaseID
		southSahara = functionalMethods.getCaseID(southSahara);

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Validating that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[4],
				testData.getTestdata()[5]);

		// Validating that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[6],
				testData.getTestdata()[7], NavigationClass.class);

		// Validating that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed");

		// Navigate to Case search page
		caseSearchPag = functionalMethods.navigateToCaseSerchPage(navigationClass);

		// Validating that navigated to Case search page
		assertTrue(caseSearchPag.hasCaseSearchHomePageDisplayed(), "Casesearch page is not displayed correctly");

		// Enter the CaseId in Case Search filed
		caseSearchPag = functionalMethods.enterCaseIDClickCaseSerch(caseSearchPag, GlobalThings.caseID_SouthSahara);

		// Navigate to isgCasePage from isgCaseSearchPage
		isgCasePage = functionalMethods.navigateToISGCasPage(caseSearchPag);

		// Validating that Work Basket is displayed
		assertTrue(isgCasePage.hasWorkBasketDisplayed(testData.getExpectedResult()[10]),
				"Work Basket is not displayed");

		// Validating that Priority is displayed
		assertTrue(isgCasePage.hasPriorityTextDisplayed(),"Priority is not displayed correctly");

		// Validating that Origin is displayed
		assertTrue(isgCasePage.hasOriginTextDisplayed(),"Origin is not displayed correctly");

		// Click on Action Button Then WorkCase And Accept Button
		isgCasePage = functionalMethods.clickOnActionsBtnThenWorkCaseAndAcceptBtn(isgCasePage);

		// Validating that Owned Status is displayed
		assertTrue(isgCasePage.hasOwnedStatusDisplayed(testData.getExpectedResult()[13]),
				"Owned Status is not displayed correctly");

	}

	/**
	 * Author :Aparajita Description :Regarding Sub Sahara webform details Negative.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 * @throws Throwable
	 */

	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6860_WebFormSubSaharaNegative(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SouthSahara southSahara;
		SouthSaharaLoginPage southSaharaLoginPage;
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;

		FunctionalMethods functionalMethods = new FunctionalMethods();

		// opening SouthSahara Form Portal
		southSaharaLoginPage = functionalMethods.openWebformPortal_SouthSahara(getDriver(), testData.getTestdata()[0]);

		// Entering Username ,Password and click on Submit button
		southSahara = functionalMethods.logintoSouthSaharaWebform(southSaharaLoginPage, testData.getTestdata()[1],
				testData.getTestdata()[2]);

		// Validating if SouthSahara WebForm is displayed
		assertTrue(southSahara.hasSouthSaharaWebFormPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to SouthSahara WebForm Page was Unsuccessful");

		// Validating that FirstName is showing
		assertTrue(southSahara.hasFirstNameDisplayed(testData.getExpectedResult()[1]),
				"First name is not displayed correctly");

		// Validating that Business Address is showing
		assertTrue(southSahara.hasSouthSaharaBusinessAddrDisplayed(testData.getExpectedResult()[2]),
				"Business Address is not displayed correctly");

		// Validating that Phone number is showing
		assertTrue(southSahara.hasSouthSaharaPhoneDisplayed(testData.getExpectedResult()[3]),
				"Phone number is not displayed correctly");

		// Validating that Email is showing
		assertTrue(southSahara.hasSouthSaharaEmailDisplayed(testData.getExpectedResult()[4]),
				"Email is not displayed correctly");

		// Validating that Primary Message is showing
		assertTrue(southSahara.hasSouthSaharaPrimaryMessageDisplayed(testData.getExpectedResult()[5]),
				"Primary Message is not displayed correctly");

		// Click Submit button And Accept Alert
		southSahara = functionalMethods.clickSubmitAndAcceptAlert(southSahara);

		// Validating Validation Msg for Comments textbox field
		assertTrue(southSahara.hasErrorMsgDisplayed(testData.getExpectedResult()[8]),
				"Validation Message of Comments textbox is not displayed correctly");

		// Enter Detailed Description and Attaching file
		southSahara = functionalMethods.detailedDescriptionAndAttachFile(southSahara, testData.getTestdata()[3]);

		// Validating that file attachment is attached successfully
		assertTrue(southSahara.hasFileAttachedDisplayed(testData.getExpectedResult()[7]),
				"File attachment not displayed correctly");

		// click on Submit btn
		southSahara = functionalMethods.clickSubmitBtn(southSahara);

		// Validating that Final Message is displayed
		assertTrue(southSahara.hasFinalMessageDisplayed(testData.getExpectedResult()[9]),
				"Final Message is not Displayed correctly");

		// Get CaseID
		southSahara = functionalMethods.getCaseID(southSahara);

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Validating that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[4],
				testData.getTestdata()[5]);

		// Validating that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[6],
				testData.getTestdata()[7], NavigationClass.class);

		// Validating that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed");

	}

	/**
	 * Author :Lahari P Description :Regarding JDLinks webform details.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 * @throws Throwable
	 */

	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6591_WebFormJDLink(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		JDLinks jd;
		NavigationClass navigationClass;
		JDLinksWebFormSubmitionPage jdLinksWebFormSubmitionPage;
		ISGCasePage isgCasePage;
		ISGCaseSearchPage isgCaseSearchPage;
		CaseSearchPage caseSearchPag;

		FunctionalMethods functionalMethods = new FunctionalMethods();

		// opening JDLinks Form Portal
		jd = functionalMethods.openWebformPortal(getDriver(), testData.getTestdata()[0]);

		// Entering Username ,Password and click on Submit button
		jdLinksWebFormSubmitionPage = functionalMethods.loginToWebform(jd, testData.getTestdata()[1],
				testData.getTestdata()[2]);

		// Validating if JDLinks WebForm is displayed
		assertTrue(jdLinksWebFormSubmitionPage.hasJDLinksWebFormPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to JDLinks WebForm Page was Unsuccessful");

		// Validating that FirstName is showing
		assertTrue(jdLinksWebFormSubmitionPage.hasJDLinksFirstNameDisplayed(testData.getExpectedResult()[1]),
				"First name is not displayed correctly");

		// Validating that Business Address is showing
		assertTrue(jdLinksWebFormSubmitionPage.hasJDLinksBusinessAddrDisplayed(testData.getExpectedResult()[2]),
				"Business Addr is not displayed correctly");

		// Validating that Phone number is showing
		assertTrue(jdLinksWebFormSubmitionPage.hasJDLinksPhoneDisplayed(testData.getExpectedResult()[3]),
				"Phone number is not displayed correctly");

		// Validating that Email is showing
		assertTrue(jdLinksWebFormSubmitionPage.hasJDLinksEmailDisplayed(testData.getExpectedResult()[4]),
				"Email is not displayed correctly");

		// Validating that Primary Message is showing
		assertTrue(jdLinksWebFormSubmitionPage.hasJDLinksPrimaryMessageDisplayed(testData.getExpectedResult()[5]),
				"Primary Message is not displayed correctly");

		// Selecting the product DP value, Enter Detailed Description and Attaching file
		jdLinksWebFormSubmitionPage = functionalMethods.prodSltEntDetlDescAtchFile(jdLinksWebFormSubmitionPage,
				testData.getTestdata()[3]);

		// Validating that file attachment is attached successfully
		assertTrue(jdLinksWebFormSubmitionPage.hasFileAttachedDisplayed(testData.getExpectedResult()[7]),
				"File attachment not displayed correctly");

		// click Clear button
		jdLinksWebFormSubmitionPage = functionalMethods
				.clickOnClearBtnSubmitBtnAcceptAlert(jdLinksWebFormSubmitionPage);

		// Validating Validation Msg for Comments textbox field
		assertTrue(jdLinksWebFormSubmitionPage.hasJDLinksDDErrMessage(testData.getExpectedResult()[8]),
				"Validation Message of Comments textbox is not displayed correctly");

		// Selecting the product DP value, Enter Detailed Description and Attaching file
		jdLinksWebFormSubmitionPage = functionalMethods.prodSltEntDetlDescAtchFile(jdLinksWebFormSubmitionPage,
				testData.getTestdata()[3]);

		// Validating that file attachment is attached successfully
		assertTrue(jdLinksWebFormSubmitionPage.hasFileAttachedDisplayed(testData.getExpectedResult()[7]),
				"File attachment not displayed correctly");

		// click on Submit button
		jdLinksWebFormSubmitionPage = functionalMethods.clickOnSubmitButton(jdLinksWebFormSubmitionPage);

		// Validating that Final Message is displayed
		assertTrue(jdLinksWebFormSubmitionPage.hasFinalMessageDisplayed(testData.getExpectedResult()[9]),
				"Final Message is not Displayed");

		// Get caseID
		jdLinksWebFormSubmitionPage = functionalMethods.getCaseID(jdLinksWebFormSubmitionPage);

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Validating that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[4],
				testData.getTestdata()[5]);

		// Validating that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[6],
				testData.getTestdata()[7], NavigationClass.class);

		// Validating that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed");

		// Navigating to CaseSearch Page
		caseSearchPag = functionalMethods.navigateToCaseSerchPage(navigationClass);

		// Verifying that CaseSearch home page displayed
		assertTrue(caseSearchPag.hasCaseSearchHomePageDisplayed(), "Casesearch page is not displayed correctly");

		// Enter the CaseId in Case Search filed
		caseSearchPag = functionalMethods.enterCaseIDClickCaseSerch(caseSearchPag, GlobalThings.caseID_JDlinks);

		// // Navigate to Case search page
		// isgCaseSearchPage =
		// functionalMethods.navigateToCaseSearchPage(navigationClass);
		//
		// // Validating that Case search page is displayed
		// assertTrue(isgCaseSearchPage.hasSolutionSearchHomePageDisplayed(),
		// "Navigation to Case search page was Unsuccessful");
		//
		//
		// Navigate to isgCasePage from isgCaseSearchPage
		// isgCasePage = functionalMethods.navigateToISGCasPage(caseSearchPag);

		// isgCaseSearchPage =
		// functionalMethods.enterCaseIDClickCaseSrch(isgCaseSearchPage,
		// GlobalThings.caseID_JDlinks);

		// Navigate to isgCasePage from isgCaseSearchPage
		isgCasePage = functionalMethods.navigateToISGCasPage(caseSearchPag);

		// Validating that Priority is displayed
		assertTrue(isgCasePage.hasPriorityTextDisplayed(),"Priority is not displayed correctly");

		// Validating that Origin is displayed
		assertTrue(isgCasePage.hasOriginTextDisplayed(),"Origin is not displayed correctly");

	}

	/**
	 * Author :Lahari P Description :Regarding JDLinks webform details Language
	 * Change.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 * @throws Throwable
	 */

	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6615_WebFormJDLinkLanguageChange(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage = null;
		JDLinks jd;
		NavigationClass navigationClass;
		JDLinksWebFormSubmitionPage jdLinksWebFormSubmitionPage;
		ISGCasePage isgCasePage;
		ISGCaseSearchPage isgCaseSearchPage;
		CaseSearchPage caseSearchPag;

		FunctionalMethods functionalMethods = new FunctionalMethods();

		// opening JDLinks Form Portal
		jd = functionalMethods.openWebformPortal(getDriver(), testData.getTestdata()[0]);

		// Entering Username ,Password and click on Submit button
		jdLinksWebFormSubmitionPage = functionalMethods.loginToWebform(jd, testData.getTestdata()[1],
				testData.getTestdata()[2]);

		// Validating if JDLinks WebForm is displayed
		assertTrue(jdLinksWebFormSubmitionPage.hasJDLinksWebFormPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to JDLinks WebForm Page was Unsuccessful");

		// Validating that FirstName is showing
		assertTrue(jdLinksWebFormSubmitionPage.hasJDLinksFirstNameDisplayed(testData.getExpectedResult()[1]),
				"First name is not displayed correctly");

		// Validating that Business Address is showing
		assertTrue(jdLinksWebFormSubmitionPage.hasJDLinksBusinessAddrDisplayed(testData.getExpectedResult()[2]),
				"Business Addr is not displayed correctly");

		// Validating that Phone number is showing
		assertTrue(jdLinksWebFormSubmitionPage.hasJDLinksPhoneDisplayed(testData.getExpectedResult()[3]),
				"Phone number is not displayed correctly");

		// Validating that Email is showing
		assertTrue(jdLinksWebFormSubmitionPage.hasJDLinksEmailDisplayed(testData.getExpectedResult()[4]),
				"Email is not displayed correctly");

		// Validating that Primary Message is showing
		assertTrue(jdLinksWebFormSubmitionPage.hasJDLinksPrimaryMessageDisplayed(testData.getExpectedResult()[5]),
				"Primary Message is not displayed correctly");

		// Selecting the Language, product DP value, Enter Detailed Description and
		// Attaching file
		jdLinksWebFormSubmitionPage = functionalMethods.slctLangProdSltEntDetlDescAtchFile(jdLinksWebFormSubmitionPage,
				testData.getTestdata()[3]);

		// Validating that file attachment is attached successfully
		// assertTrue(jdLinksWebFormSubmitionPage.hasFileAttachedDisplayed(testData.getExpectedResult()[7]),
		// "File attachment not displayed correctly");

		// click on Submit button
		jdLinksWebFormSubmitionPage = functionalMethods.clickOnSubmitButton(jdLinksWebFormSubmitionPage);

		// Validating that Final Message is displayed
		assertTrue(jdLinksWebFormSubmitionPage.hasFinalMessageDisplayed(testData.getExpectedResult()[9]),
				"Final Message is not Displayed correctly");

		getDriver().manage().deleteAllCookies();

		// Get caseID
		jdLinksWebFormSubmitionPage = functionalMethods.getCaseIDSpanish(jdLinksWebFormSubmitionPage);

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Validating that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[4],
				testData.getTestdata()[5]);

		// Validating that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[6],
				testData.getTestdata()[7], NavigationClass.class);

		// Validating that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed");

		// Navigating to CaseSearch Page
		caseSearchPag = functionalMethods.navigateToCaseSerchPage(navigationClass);

		// Verifying that CaseSearch home page displayed
		assertTrue(caseSearchPag.hasCaseSearchHomePageDisplayed(), "Casesearch page is not displayed correctly");

		// Enter the CaseId in Case Search filed
		caseSearchPag = functionalMethods.enterCaseIDClickCaseSerch(caseSearchPag, GlobalThings.caseID_JDlinks);

		// // Navigate to Case search page
		// isgCaseSearchPage =
		// functionalMethods.clickCaseSearchHomeLink(navigationClass);
		//
		// // Validating that navigated to Case search page
		// assertTrue(isgCaseSearchPage.hasSolutionSearchHomePageDisplayed(),
		// "Navigation to Case search page was Unsuccessful");

		// Entering the Case Id in Case Search Box and click on case link
		// isgCaseSearchPage =
		// functionalMethods.enterCaseIDClickCaseSrch(isgCaseSearchPage,
		// GlobalThings.caseID_JDlinks);

		// Navigate to isgCasePage from isgCaseSearchPage
		isgCasePage = functionalMethods.navigateToISGCasPage(caseSearchPag);

		// Validating that Priority is displayed
		assertTrue(isgCasePage.hasPriorityTextDisplayed(),"Priority is not displayed correctly");

		// Validating that Language is displayed
		assertTrue(isgCasePage.hasLanguageTextDisplayed(), "Language Spanish is not displayed correctly");

		// Validating that Origin is displayed
		assertTrue(isgCasePage.hasOriginTextDisplayed(),"Origin is not displayed correctly");

	}

	/**
	 * Author :Lahari P Description :Regarding JDLinks webform details Negative.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 * @throws Throwable
	 */

	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6863_WebFormJDLinkNegative(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		JDLinks jd;
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;
		JDLinksWebFormSubmitionPage jdLinksWebFormSubmitionPage;

		FunctionalMethods functionalMethods = new FunctionalMethods();

		// opening JDLinks Form Portal
		jd = functionalMethods.openWebformPortal(getDriver(), testData.getTestdata()[0]);

		// Entering Username ,Password and click on Submit button
		jdLinksWebFormSubmitionPage = functionalMethods.loginToWebform(jd, testData.getTestdata()[1],
				testData.getTestdata()[2]);

		// Validating if JDLinks WebForm is displayed
		assertTrue(jdLinksWebFormSubmitionPage.hasJDLinksWebFormPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to JDLinks WebForm Page was Unsuccessful");

		// Validating that FirstName is showing
		assertTrue(jdLinksWebFormSubmitionPage.hasJDLinksFirstNameDisplayed(testData.getExpectedResult()[1]),
				"First name is not displayed correctly");

		// Validating that Business Address is showing
		assertTrue(jdLinksWebFormSubmitionPage.hasJDLinksBusinessAddrDisplayed(testData.getExpectedResult()[2]),
				"Business Addr is not displayed correctly");

		// Validating that Phone number is showing
		assertTrue(jdLinksWebFormSubmitionPage.hasJDLinksPhoneDisplayed(testData.getExpectedResult()[3]),
				"Phone number is not displayed correctly");

		// Validating that Email is showing
		assertTrue(jdLinksWebFormSubmitionPage.hasJDLinksEmailDisplayed(testData.getExpectedResult()[4]),
				"Email is not displayed correctly");

		// Validating that Primary Message is showing
		assertTrue(jdLinksWebFormSubmitionPage.hasJDLinksPrimaryMessageDisplayed(testData.getExpectedResult()[5]),
				"Primary Message is not displayed correctly");

		// Click Submit button And Accept Alert
		jdLinksWebFormSubmitionPage = functionalMethods.clickSubmitAndAcceptAlert(jdLinksWebFormSubmitionPage);

		// Validating Product Err message
		assertTrue(jdLinksWebFormSubmitionPage.hasJDLinksProdErrMessageDisplayed(testData.getExpectedResult()[8]),
				"Product err msg is not Displayed");

		// Validating Comm error message
		assertTrue(jdLinksWebFormSubmitionPage.hasJDLinksDDErrMessage(testData.getExpectedResult()[8]),
				"Comm err msg is not Displayed");

		// Selecting the product DP value, Enter Detailed Description and Attaching file
		jdLinksWebFormSubmitionPage = functionalMethods.prodSltEntDetlDescAtchFile(jdLinksWebFormSubmitionPage,
				testData.getTestdata()[3]);

		// Validating that file attachment is attached successfully
		assertTrue(jdLinksWebFormSubmitionPage.hasFileAttachedDisplayed(testData.getExpectedResult()[7]),
				"File attachment not displayed correctly");

		// click on Submit button
		jdLinksWebFormSubmitionPage = functionalMethods.clickOnSubmitButton(jdLinksWebFormSubmitionPage);

		// Validating that Final Message is displayed
		assertTrue(jdLinksWebFormSubmitionPage.hasFinalMessageDisplayed(testData.getExpectedResult()[9]),
				"Final Message is not Displayed correctly");
		// Deleting cookies
		getDriver().manage().deleteAllCookies();

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Validating that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[4],
				testData.getTestdata()[5]);

		// Validating that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[6],
				testData.getTestdata()[7], NavigationClass.class);

		// Validating that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed");
	}

	/**
	 * Author :Aparajita Description :Regarding Agronmy webform details
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 * @throws Throwable
	 */

	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6598_WebFormAgronomy(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		ISGCaseSearchPage isgCaseSearchPage;
		NavigationClass navigationClass;
		AgronomyLoginPage agronomyLoginPage;
		Agronomy agronomy;
		ISGCasePage isgCasePage;
		CaseSearchPage caseSearchPag;
		FunctionalMethods functionalMethods = new FunctionalMethods();

		// opening Agronomy Form Portal
		agronomyLoginPage = functionalMethods.openWebformPortal_Agr(getDriver(), testData.getTestdata()[0]);

		// Entering Username ,Password and Submit
		agronomy = functionalMethods.loginToAgrWebform(agronomyLoginPage, testData.getTestdata()[1],
				testData.getTestdata()[2]);

		// Validating if Agronomy WebForm is displayed
		assertTrue(agronomy.hasAgronomyWebFormPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to Agronomy WebForm Page was Unsuccessful");

		// Validating that FirstName is showing
		assertTrue(agronomy.hasAgrFirstNameDisplayed(testData.getExpectedResult()[1]),
				"First name is not displayed correctly");

		// Validating that Phone number is showing
		assertTrue(agronomy.hasAgrPhoneDisplayed(testData.getExpectedResult()[3]),
				"Phone number is not displayed correctly");

		// Validating that Email is showing
		assertTrue(agronomy.hasAgrEmailDisplayed(testData.getExpectedResult()[4]), "Email is not displayed correctly");

		// Validating that Primary Message is showing
		assertTrue(agronomy.hasAgrPrimaryMessageDisplayed(testData.getExpectedResult()[5]),
				"Primary Message is not displayed correctly");

		// Enter Detailed Description and Attaching file
		agronomy = functionalMethods.detailedDescriptionAttachFile(agronomy, testData.getTestdata()[3]);

		// Validating that file attachment is attached successfully
	//	assertTrue(agronomy.hasFileAttachedDisplayed(testData.getExpectedResult()[7]),
		//		"File attachment not displayed correctly");

		// Validate Clear button
		assertTrue(agronomy.hasClearButtonDisplayed(testData.getExpectedResult()[6]), "Clear button is not diaplayed");

		// Click on Clear button, Submit button and Accept Alert
		agronomy = functionalMethods.clickOnClearBtnSubmitBtnAcceptAlert(agronomy);

		// Validating Validation Msg for Comments textbox field
		assertTrue(agronomy.hasCommErrorMsgDisplayed(testData.getExpectedResult()[8]),
				"Validation Message of Comments textbox is not displayed correctly");

		// Enter Detailed Description and Attaching file
		agronomy = functionalMethods.detailedDescriptionAttachFile(agronomy, testData.getTestdata()[3]);

		// Validating that file attachment is attached successfully
		// assertTrue(agronomy.hasFileAttachedDisplayed(testData.getExpectedResult()[7]),
		// "File attachment not displayed correctly");

		// click on Submit btn
		agronomy = functionalMethods.clickSubmitBtn(agronomy);

		// Validating that Final Message is displayed
		assertTrue(agronomy.hasFinalMessageDisplayed(testData.getExpectedResult()[9]),
				"Final Message is not Displayed correctly");

		// Get CaseID
		agronomy = functionalMethods.getCaseID(agronomy);

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Validating that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[4],
				testData.getTestdata()[5]);

		// Validating that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[6],
				testData.getTestdata()[7], NavigationClass.class);

		// Validating that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed");

		// Validating that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed correctly");

		// Navigating to CaseSearch Page
		caseSearchPag = functionalMethods.navigateToCaseSerchPage(navigationClass);

		// Verifying that CaseSearch home page displayed
		assertTrue(caseSearchPag.hasCaseSearchHomePageDisplayed(), "Casesearch page is not displayed correctly");

		// Enter the CaseId in Case Search filed
		caseSearchPag = functionalMethods.enterCaseIDClickCaseSerch(caseSearchPag, GlobalThings.caseID_Agronomy);

		// // Navigate to Case search page
		// isgCaseSearchPage =
		// functionalMethods.clickCaseSearchHomeLink(navigationClass);
		//
		// // Validating that navigated to Case search page
		// assertTrue(isgCaseSearchPage.hasSolutionSearchHomePageDisplayed(),
		// "Navigation to Case search page was Unsuccessful");

		// Entering the Case Id in Case Search Box and click on case link
		// isgCaseSearchPage = functionalMethods.enterCaseIDClickCaseSrch(caseSearchPag,
		// GlobalThings.caseID_Agronomy);

		// Navigate to isgCasePage from isgCaseSearchPage
		isgCasePage = functionalMethods.navigateToISGCasPage(caseSearchPag);

		// Validating that Priority is displayed
		assertTrue(isgCasePage.hasPriorityTextDisplayed(),"Priority is not displayed correctly");

		// Validating that Origin is displayed
		assertTrue(isgCasePage.hasOriginTextDisplayed(),"Origin is not displayed correctly");

	}

	/**
	 * Author :Aparajita Description :Regarding Agronmy webform details Negative
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 * @throws Throwable
	 */

	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6868_WebFormAgronomyNegative(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		AgronomyLoginPage agronomyLoginPage;
		Agronomy agronomy;
		CaseSearchPage caseSearchPag;
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;

		FunctionalMethods functionalMethods = new FunctionalMethods();

		// opening Agronomy Form Portal
		agronomyLoginPage = functionalMethods.openWebformPortal_Agr(getDriver(), testData.getTestdata()[0]);

		// Entering Username ,Password and click on Submit button
		agronomy = functionalMethods.loginToAgrWebform(agronomyLoginPage, testData.getTestdata()[1],
				testData.getTestdata()[2]);

		// Validating if Agronomy WebForm is displayed
		assertTrue(agronomy.hasAgronomyWebFormPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to Agronomy WebForm Page was Unsuccessful");

		// Validating that FirstName is showing
		assertTrue(agronomy.hasAgrFirstNameDisplayed(testData.getExpectedResult()[1]),
				"First name is not displayed correctly");

		// Validating that Phone number is showing
		assertTrue(agronomy.hasAgrPhoneDisplayed(testData.getExpectedResult()[3]),
				"Phone number is not displayed correctly");

		// Validating that Email is showing
		assertTrue(agronomy.hasAgrEmailDisplayed(testData.getExpectedResult()[4]), "Email is not displayed correctly");

		// Validating that Primary Message is showing
		assertTrue(agronomy.hasAgrPrimaryMessageDisplayed(testData.getExpectedResult()[5]),
				"Primary Message is not displayed correctly");

		// Click on Submit button And Accept Alert
		agronomy = functionalMethods.clickSubmitAndAcceptAlert(agronomy);

		// Validating Validation Msg for Comments textbox field
		assertTrue(agronomy.hasCommErrorMsgDisplayed(testData.getExpectedResult()[8]),
				"Validation Message of Comments textbox is not displayed correctly");

		// Enter Detailed Description and Attaching file
		agronomy = functionalMethods.detailedDescriptionAttachFile(agronomy, testData.getTestdata()[3]);

		// Validating that file attachment is attached successfully
		assertTrue(agronomy.hasFileAttachedDisplayed(testData.getExpectedResult()[7]),
				"File attachment not displayed correctly");

		// click on Submit btn
		agronomy = functionalMethods.clickSubmitBtn(agronomy);

		// Validating that Final Message is displayed
		assertTrue(agronomy.hasFinalMessageDisplayed(testData.getExpectedResult()[9]),
				"Final Message is not Displayed correctly");
		getDriver().manage().deleteAllCookies();

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Validating that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[4],
				testData.getTestdata()[5]);

		// Validating that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[6],
				testData.getTestdata()[7], NavigationClass.class);

		// Validating that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed");

	}

	/**
	 * Author :Aparajita Description :Details of GreenFleet Testcases
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 * @throws Throwable
	 */
	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6637_WebForm_GreenFleet(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;
		GreenFleetWebFormSubmissionPage greenFleetWebFormSubmissionPage;
		ISGCasePage isgCasePage;
		CaseSearchPage caseSearchPag;

		FunctionalMethods functionalMethods = new FunctionalMethods();

		// opening GreenFleet Form Portal
		greenFleetWebFormSubmissionPage = functionalMethods.greenFleetWebForm(getDriver(), testData.getTestdata()[0]);

		// Entering Username ,Password and Submit
		greenFleetWebFormSubmissionPage = functionalMethods.loginToWebform(greenFleetWebFormSubmissionPage,
				testData.getTestdata()[1], testData.getTestdata()[2]);

		// Validating if GreenFleet WebForm is displayed
		assertTrue(greenFleetWebFormSubmissionPage.hasGreenFleettWebFormPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to GreenFleet WebForm Page was Unsuccessful");

		// Validating that FirstName is showing
		assertTrue(greenFleetWebFormSubmissionPage.hasFirstNameDisplayed(testData.getExpectedResult()[1]),
				"GreenFleet Form is not  opened ,first name is not displayed");

		// Validating that Business Address is showing
		assertTrue(greenFleetWebFormSubmissionPage.hasBusinessAddrDisplayed(testData.getExpectedResult()[2]),
				"GreenFleet Business Address is not Displayed");

		// Validating that Phone number is showing
		assertTrue(greenFleetWebFormSubmissionPage.hasPhoneDisplayed(testData.getExpectedResult()[3]),
				"GreenFleet Phonenumber is not Displayed");

		// Validating that Email is showing
		assertTrue(greenFleetWebFormSubmissionPage.hasEmailDisplayed(testData.getExpectedResult()[4]),
				"GreenFleet Email is not Displayed");

		// Validating that Primary Message is showing
		assertTrue(greenFleetWebFormSubmissionPage.hasPrimaryMessageDisplayed(testData.getExpectedResult()[5]),
				"GreenFleet Email is not Displayed");

		// Enter data into Detailed Description field and Attaching file
		greenFleetWebFormSubmissionPage = functionalMethods
				.detailedDescriptionAndAttachFile(greenFleetWebFormSubmissionPage, testData.getTestdata()[3]);

		// Validating that file attachment is attached successfully
		assertTrue(greenFleetWebFormSubmissionPage.hasFileAttachedDisplayed(testData.getExpectedResult()[7]),
				"File attachment not displayed correctly");

		// Click on Clear button, Submit button and Accept Alert
		greenFleetWebFormSubmissionPage = functionalMethods
				.clickOnClearBtnSubmitBtnAcceptAlert(greenFleetWebFormSubmissionPage);

		// Validating Validation Msg for Comments textbox field
		assertTrue(greenFleetWebFormSubmissionPage.hasCommErrorMsgDisplayed(testData.getExpectedResult()[8]),
				"Validation Message of Comments textbox is not displayed correctly");

		// Enter data into Detailed Description field and Attaching file
		greenFleetWebFormSubmissionPage = functionalMethods
				.detailedDescriptionAndAttachFile(greenFleetWebFormSubmissionPage, testData.getTestdata()[3]);

		// Validating that file attachment is attached successfully
		assertTrue(greenFleetWebFormSubmissionPage.hasFileAttachedDisplayed(testData.getExpectedResult()[7]),
				"File attachment not displayed correctly");

		// Click on Submit Btn
		greenFleetWebFormSubmissionPage = functionalMethods.clickSubmitBtn(greenFleetWebFormSubmissionPage);

		// Validating that Final Message is displayed
		assertTrue(greenFleetWebFormSubmissionPage.hasFinalMessageDisplayed(testData.getExpectedResult()[9]),
				"Final Message is not Displayed correctly");

		// Get CaseID
		greenFleetWebFormSubmissionPage = functionalMethods.getCaseID(greenFleetWebFormSubmissionPage);

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Validating that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[4],
				testData.getTestdata()[5]);

		// Validating that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[6],
				testData.getTestdata()[7], NavigationClass.class);

		// Validating that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed");

		// Navigate to Case search page
		caseSearchPag = functionalMethods.navigateToCaseSerchPage(navigationClass);

		// Validating that navigated to Case search page
		assertTrue(caseSearchPag.hasCaseSearchHomePageDisplayed(), "Casesearch page is not displayed correctly");

		// Enter the CaseId in Case Search filed
		caseSearchPag = functionalMethods.enterCaseIDClickCaseSerch(caseSearchPag, GlobalThings.caseID_GreenFleet);

		// Navigate to isgCasePage from isgCaseSearchPage
		isgCasePage = functionalMethods.navigateToISGCasPage(caseSearchPag);

		// Validating that Work Basket is displayed
		assertTrue(isgCasePage.hasWorkBasketDisplayed(testData.getExpectedResult()[10]),
				"Work Basket is not displayed");

		// Validating that Priority is displayed
		assertTrue(isgCasePage.hasPriorityTextDisplayed(),"Priority is not displayed correctly");

		// Validating that Origin is displayed
		assertTrue(isgCasePage.hasOriginTextDisplayed(),"Origin is not displayed correctly");

		// Click on Action Button Then WorkCase And Accept Button
		isgCasePage = functionalMethods.clickOnActionsBtnThenWorkCaseAndAcceptBtn(isgCasePage);

		// Validating that Owned Status is displayed
		assertTrue(isgCasePage.hasOwnedStatusDisplayed(testData.getExpectedResult()[13]),
				"Owned Status is not displayed correctly");

	}

	/**
	 * Author :Aparajita Description :Details of GreenFleet Testcases Negative
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 * @throws Throwable
	 */

	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6857_WebForm_GreenFleetNegative(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		GreenFleetWebFormSubmissionPage greenFleetWebFormSubmissionPage;
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;

		FunctionalMethods functionalMethods = new FunctionalMethods();

		// opening GreenFleet Form Portal
		greenFleetWebFormSubmissionPage = functionalMethods.greenFleetWebForm(getDriver(), testData.getTestdata()[0]);

		// Entering Username ,Password and Submit
		greenFleetWebFormSubmissionPage = functionalMethods.loginToWebform(greenFleetWebFormSubmissionPage,
				testData.getTestdata()[1], testData.getTestdata()[2]);

		// Validating if GreenFleet WebForm is displayed
		assertTrue(greenFleetWebFormSubmissionPage.hasGreenFleettWebFormPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to GreenFleet WebForm Page was Unsuccessful");

		// Validating that FirstName is showing
		assertTrue(greenFleetWebFormSubmissionPage.hasFirstNameDisplayed(testData.getExpectedResult()[1]),
				"GreenFleet Form is not  opened ,first name is not displayed");

		// Validating that Business Address is showing
		assertTrue(greenFleetWebFormSubmissionPage.hasBusinessAddrDisplayed(testData.getExpectedResult()[2]),
				"GreenFleet Business Address is not Displayed");

		// Validating that Phone number is showing
		assertTrue(greenFleetWebFormSubmissionPage.hasPhoneDisplayed(testData.getExpectedResult()[3]),
				"GreenFleet Phonenumber is not Displayed");

		// Validating that Email is showing
		assertTrue(greenFleetWebFormSubmissionPage.hasEmailDisplayed(testData.getExpectedResult()[4]),
				"GreenFleet Email is not Displayed");

		// Validating that Primary Message is showing
		assertTrue(greenFleetWebFormSubmissionPage.hasPrimaryMessageDisplayed(testData.getExpectedResult()[5]),
				"GreenFleet Email is not Displayed");

		// Click Submit button And Accept Alert
		greenFleetWebFormSubmissionPage = functionalMethods.clickSubmitAndAcceptAlert(greenFleetWebFormSubmissionPage);

		// Validating Validation Msg for Comments textbox field
		assertTrue(greenFleetWebFormSubmissionPage.hasCommErrorMsgDisplayed(testData.getExpectedResult()[8]),
				"Validation Message of Comments textbox is not displayed correctly");

		// Enter data into Detailed Description field and Attaching file
		greenFleetWebFormSubmissionPage = functionalMethods
				.detailedDescriptionAndAttachFile(greenFleetWebFormSubmissionPage, testData.getTestdata()[3]);

		// Click on Submit Btn
		greenFleetWebFormSubmissionPage = functionalMethods.clickSubmitBtn(greenFleetWebFormSubmissionPage);

		// Validating that Final Message is displayed
		assertTrue(greenFleetWebFormSubmissionPage.hasFinalMessageDisplayed(testData.getExpectedResult()[9]),
				"Final Message is not Displayed correctly");

		// Get CaseID
		greenFleetWebFormSubmissionPage = functionalMethods.getCaseID(greenFleetWebFormSubmissionPage);

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Validating that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[4],
				testData.getTestdata()[5]);

		// Validating that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[6],
				testData.getTestdata()[7], NavigationClass.class);

		// Validating that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed");

	}

}