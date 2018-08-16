package com.deere.testCases;

import static org.testng.Assert.assertTrue;

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
import com.deere.pages.greenfleet.GreenFleetCreationPage;
import com.deere.pages.homepage.HomePage;
import com.deere.pages.isgcasecreation.ISGCasePage;
import com.deere.pages.isgcasecreation.ISGCaseSearchPage;

public class GreenFleetTestCases extends CoreTestCase {

	/**
	 * Author : Aparajita Pattanaik Description :Create GreenFleet Case and search
	 * case ID in CCMS portal.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */

	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6695_CreateGreenFleetcase(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		ISGCaseSearchPage isgCaseSearchPage;
		ISGCasePage isgCasePage;
		NavigationClass navigationClass;
		HomePage homePage;
		GreenFleetCreationPage greenFleetCreationPage;

		FunctionalMethods functionalMethods = new FunctionalMethods();

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Verify that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[0],
				testData.getTestdata()[1]);

		// Verify that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[2],
				testData.getTestdata()[3], NavigationClass.class);

		// Verify that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(testData.getExpectedResult()[0]),
				"Landing page is not displayed");

		// Navigate to HomePage
		homePage = functionalMethods.navigateToHomePage(navigationClass);

		// Verify that Landing of home Page is displayed
		assertTrue(homePage.isHomePageDisplayed(testData.getExpectedResult()[1]),
				"Navigation to Home page was Unsuccessful");

		// Click on GreenFleet case button .
		greenFleetCreationPage = functionalMethods.clickOnGreenFleetCaseBtnDealerUser(homePage);

		// verify landing of GreenFleet GSC page
		assertTrue(greenFleetCreationPage.hasGreenFleetPageDisplayedDealerUser(testData.getExpectedResult()[2]),
				"Green fleet GSC page is not displayed successfully");

    	// Validate customer info header
		assertTrue(greenFleetCreationPage.hasAddCustomerrInfoHeaderDisplayed(testData.getExpectedResult()[3]),
				"customer info header is not Displayed successfully");

		// Validate Product info header
		assertTrue(greenFleetCreationPage.hasProductInfoHeaderDealerDisplayed(testData.getExpectedResult()[5]),
				"product info header is not Displayed successfully");

		// Validate Case Information header
		assertTrue(greenFleetCreationPage.hasCaseInformationHeaderDisplayed(testData.getExpectedResult()[6]),
				"Case Information header is not Displayed successfully");

		// Validate for Priority header
		 assertTrue(greenFleetCreationPage.hasPriorityHeadDisplayed(testData.getExpectedResult()[7]),"Priority is not Displayed successfully");

		// Validate for Language dropdown
		assertTrue(greenFleetCreationPage.hasLanguageHeaderDisplayed(testData.getExpectedResult()[8]),
				"Language is not Displayed successfully");

		// Validate for GreenFleet Number
		assertTrue(greenFleetCreationPage.hasGrnFltHeaderDisplayed(testData.getExpectedResult()[9]),
				"GreenFleetNumber is not Displayed successfully");

		// Validate Related Case header
		assertTrue(greenFleetCreationPage.hasRelatedCaseHeaderDisplayed(testData.getExpectedResult()[10]),
				"Related case header is not Displayed successfully");

		// Validate Problem Details header
		assertTrue(greenFleetCreationPage.hasProblemDetailsHeaderDisplayed(testData.getExpectedResult()[11]),
				"Problem Details info header is not Displayed successfully");

		// Validate Summary header
		assertTrue(greenFleetCreationPage.hasSummaryHeaderDisplayed(testData.getExpectedResult()[12]),
				"Summary header is not Displayed successfully");

		// Validate Submit button
		assertTrue(greenFleetCreationPage.hasSubmitBtnDisplayed(), "Submit button is not Displayed successfully");

		// Validate save button
		assertTrue(greenFleetCreationPage.hasSaveBtnDisplayed(), "Save button is not Displayed successfully");

		// Validate withdraw button
		assertTrue(greenFleetCreationPage.hasWithdrawBtnDisplayed(), "Withdraw button is not Displayed successfully");

		// Enter customer and case details for greenfleet case creation and click on
		// accept button.
		greenFleetCreationPage = functionalMethods.enterGreenFleetCaseDetailsForDealerUser(greenFleetCreationPage,
				testData.getTestdata()[4], testData.getTestdata()[5], testData.getTestdata()[6],
				testData.getTestdata()[7], testData.getTestdata()[8], testData.getTestdata()[9],
				testData.getTestdata()[10]);

		// Validate Case ID
		assertTrue(greenFleetCreationPage.hasCaseIDDisplayed(), "CaseID displayed correctly");
		
		 // Get CaseId and click on logout
		greenFleetCreationPage = functionalMethods.getDealerCase(greenFleetCreationPage);

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[0],
				testData.getTestdata()[1]);

		// Verify that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[11],
				testData.getTestdata()[3], NavigationClass.class);

		// Verify that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to Landing page is not displayed successfully");

		// Navigate to case search Page
		isgCaseSearchPage = functionalMethods.clickOnCaseSearchHomeLink(navigationClass);

		// Verify that navigated to Case search page
		assertTrue(isgCaseSearchPage.hasCaseSearchHomePageDisplayed(),
				"Navigation to Case search page is not displayed successfully");

		// Enter the CaseId in search box text field.
		isgCaseSearchPage = functionalMethods.enterDealerCaseId(isgCaseSearchPage, GlobalThings.caseIDGF);

		// Click on Case Search image icon button and click on case Id link
		isgCaseSearchPage = functionalMethods.clickCaseSearchImgLink(isgCaseSearchPage);

		// Click on Action, workcase, accept button.
		 isgCasePage=functionalMethods.clickonActionsWorkcaseAccept(isgCaseSearchPage,testData.getTestdata()[12],testData.getTestdata()[13]);

		// Validate the owned_Status
		assertTrue(isgCasePage.hasOwnedStatusDisplayed(testData.getExpectedResult()[13]),
				"Owned status is not Displayed successfully");

		// Validate Save button
		assertTrue(isgCasePage.hasSaveBtnDisplayed(), "Save button is not Displayed successfully");

		// Validate cancel button
		assertTrue(isgCasePage.hasCancelBtnDisplayed(), "Cancel button is not Displayed successfully");

		// Validate close button
		assertTrue(isgCasePage.hasCloseBtnDisplayed(), "Close button is not Displayed successfully");

		// Click on close button
		isgCasePage = functionalMethods.clickOnClose(isgCasePage);

		// Validate the ResolvedCompleted status
		assertTrue(isgCasePage.hasResolvedCompletedStatusDisplayed(),"Resolved & Compleetd status is not Displayed successfully");

	}


	/**
	 * /** Author :Aparajita Description : Create Greenfleet case and verifying the
	 * header text of Green fleet case page.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */

	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6696GreenFleetCaseCreation(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		GreenFleetCreationPage greenFleetCreationPage;
		NavigationClass navigationClass;
		HomePage homePage;

		FunctionalMethods functionalMethods = new FunctionalMethods();

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Verify that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[0],
				testData.getTestdata()[1]);

		// Verify that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[2],
				testData.getTestdata()[3], NavigationClass.class);

		// Verify that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(testData.getExpectedResult()[0]),
				"Landing page is not displayed unsuccessful");

		// Navigate to HomePage
		homePage = functionalMethods.navigateToHomePage(navigationClass);

		// Verify that Landing of home Page is displayed
		assertTrue(homePage.isHomePageDisplayed(testData.getExpectedResult()[1]),
				"Navigation to Home page was Unsuccessful");

		// Verify tiles Workgroup Queue text
		assertTrue(homePage.hasWorkgroupTextDisplayed(testData.getExpectedResult()[2]),
				"WorkgroupQueue text  is not displayed successfully ");

		// Verify tiles of My Cases text
		assertTrue(homePage.hasMyCasesTextDisplayed(testData.getExpectedResult()[3]),
				"My cases text  is not displayed successfully");

		// Verify tiles Case Search text
		assertTrue(homePage.hasCaseSearchTextDisplayed(testData.getExpectedResult()[4]),
				"CaseSearch text  is not displayed successfully");

		// Verify tiles Solution Search text
		assertTrue(homePage.hasSolutionSearchTextDisplayed(testData.getExpectedResult()[5]),
				"Solution search text is not displayed successfully");

		// Verify tiles FAQ/Help text
		assertTrue(homePage.hasFAQHelpTextDisplayed(testData.getExpectedResult()[6]),
				"FAQ text  is not displayed successfully ");

		// Verify tiles DMAc Case text
		assertTrue(homePage.hasDMACTextDisplayed(testData.getExpectedResult()[7]),
				"DMAC text  is  not displayed successfully");

		// Verify tiles DPAc Case text
		assertTrue(homePage.hasDPACTextDisplayed(testData.getExpectedResult()[8]),
				"DPAC text is not displayed successfully");

		// Verify tiles DTAC Case text
		assertTrue(homePage.hasDTACTextDisplayed(testData.getExpectedResult()[9]),
				"DTAC text  is not displayed successfully ");

		// Verify tiles GSC Case text
		assertTrue(homePage.hasGSCCaseTextDisplayed(testData.getExpectedResult()[10]),
				"GSC Case text  is not displayed successfully");

		// Verify ISG Case text
		assertTrue(homePage.hasISGCaseTextDisplayed(), "ISG Case text in homepage is not displayed successfully");

		// Verify GreenFleet Case text
		assertTrue(homePage.hasGreenfleetCaseTextDisplayed(),
				"GreenFleetCase text in homepage is not displayed successfully");

		// Click on GreenFleet case button .
		greenFleetCreationPage = functionalMethods.clickOnGreenFleetCaseBtn(homePage);

		// verify landing of GSC page text
		assertTrue(greenFleetCreationPage.hasGreenFleetPageDisplayed(testData.getExpectedResult()[13]),
				" Green fleet page text in homepage is not displayed successfully");

		// Validate customer info header
		assertTrue(greenFleetCreationPage.hasAddCustomerrInfoHeaderDisplayed(testData.getExpectedResult()[14]),
				"customer info text  is not Displayed");

		// Validate Contact & Dealership info header
		assertTrue(greenFleetCreationPage.hasConatctAndDealershipHeaderDisplayed(testData.getExpectedResult()[15]),
				"Contact & Dealership info is not Displayed");

		// Validate Product info header
		assertTrue(greenFleetCreationPage.hasProductInfoHeaderDisplayed(testData.getExpectedResult()[16]),
				"product info text is not Displayed");

		// Validate Case Coding header
		assertTrue(greenFleetCreationPage.hasCaseCodingHeaderDisplayed(testData.getExpectedResult()[17]),
				"Case Coding text is not Displayed");

		// Validate Case Information header
		assertTrue(greenFleetCreationPage.hasCaseInformationHeaderDisplayed(testData.getExpectedResult()[18]),
				"Case Information text is not Displayed");

		// Validate Related Case header
		assertTrue(greenFleetCreationPage.hasRelatedCaseHeaderDisplayed(testData.getExpectedResult()[19]),
				"Related case text is not Displayed");

		// Validate Problem Details header
		assertTrue(greenFleetCreationPage.hasProblemDetailsHeaderDisplayed(testData.getExpectedResult()[20]),
				"Problem Details text info is not Displayed");

		// Validate Summary field header
		assertTrue(greenFleetCreationPage.hasSummaryHeaderDisplayed(testData.getExpectedResult()[21]),
				"Summary field text is not Displayed");

		// Validate Workbasket field header
		assertTrue(greenFleetCreationPage.hasWorkbasketHeaderDisplayed(testData.getExpectedResult()[22]),
				"Workbasket filed text is not Displayed");

		// Validate Greenfleet R4 header
		assertTrue(greenFleetCreationPage.hasGreenFleetR4HeaderDisplayed(testData.getExpectedResult()[23]),
				"GreenfleetR4 text is not Displayed");

		// Validate Accept button
		assertTrue(greenFleetCreationPage.hasAcceptBtnDisplayed(), "Accept button is not Displayed successfully");

		// Validate Accept and Close button
		assertTrue(greenFleetCreationPage.hasAcceptandCloseBtnDisplayed(),
				"Accept and Close button is not Displayed successfully");

		// Validate save button
		assertTrue(greenFleetCreationPage.hasSaveBtnDisplayed(), "Save button is not Displayed successfully");

		// Enter case details for Greenfleet case craetion and click on accept
		greenFleetCreationPage = functionalMethods.enterGreenFleetCaseDetails(greenFleetCreationPage,
				testData.getTestdata()[4], testData.getTestdata()[5], testData.getTestdata()[6],
				testData.getTestdata()[7], testData.getTestdata()[8], testData.getTestdata()[9],
				testData.getTestdata()[10], testData.getTestdata()[11], testData.getTestdata()[12]);

		// Validate the case status
		assertTrue(greenFleetCreationPage.hasOwnedStatusDisplayed(), "Owned status is not Displayed successfully");

		// Click on Audit and validate audit history
		greenFleetCreationPage = functionalMethods.clickOnAuditTrails(greenFleetCreationPage);

		// Click on Actions
		greenFleetCreationPage = functionalMethods.clickOnActionsDD(greenFleetCreationPage);

		// Validate Refresh option
		assertTrue(greenFleetCreationPage.hasRefreshOptionDisplayed(testData.getExpectedResult()[24]),
				"Refresh option is not Displayed successfully");

		// Validate Transfer Case to WB option
		assertTrue(greenFleetCreationPage.hasWorkBasketOptionDisplayed(testData.getExpectedResult()[25]),
				"Transfer To WB option is not Displayed successfully");

		// Validate Transfer Case to Individual option
		assertTrue(greenFleetCreationPage.hasTransferIndividualOptionDisplayed(testData.getExpectedResult()[26]),
				"Transfer to Individual option is not Displayed successfully");

		// Validate Send Case Email option
		assertTrue(greenFleetCreationPage.hasSendCaseEmailOptionDisplayed(testData.getExpectedResult()[27]),
				"send case email option is not Displayed successfully");

		// Validate Print option
		assertTrue(greenFleetCreationPage.hasPrintOptionDisplayed(testData.getExpectedResult()[28]),
				"print option is not Displayed successfully");

		// Click on close button
		greenFleetCreationPage = functionalMethods.clickCloseButton(greenFleetCreationPage);

		// Validate Resolved-complete status
		assertTrue(greenFleetCreationPage.hasResolvedCompletedStatusDisplayed(testData.getExpectedResult()[29]),
				"Resolved completed status is not  Displayed successfully");

	}

	/**
	 * /** Author :Aparajita Description : Verifying the alert for Greenfleet case .
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */
	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6867GreenFleetCaseCreationNegative(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		GreenFleetCreationPage greenFleetCreationPage;
		NavigationClass navigationClass;
		HomePage homePage;
		FunctionalMethods functionalMethods = new FunctionalMethods();

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Verify that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[0],
				testData.getTestdata()[1]);

		// Verify that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[2],
				testData.getTestdata()[3], NavigationClass.class);

		// Verify that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(testData.getExpectedResult()[0]),
				"Landing page is not displayed unsuccessful");

		// Navigate to HomePage
		homePage = functionalMethods.navigateToHomePage(navigationClass);

		// Verify landing of HomePage
		assertTrue(homePage.hasHomePageDisplayed(), "Navigation to homepage was unsuccessful");

		// click on GreenFleet case creation
		greenFleetCreationPage = functionalMethods.clickOnGreenFleetCaseBtn(homePage);

		// verify landing of GSC page
		assertTrue(greenFleetCreationPage.hasGreenFleetPageDisplayedTCSMUser(testData.getExpectedResult()[2]),
				" Green fleet page is not displayed successfully");

		// Validate customer info header
		assertTrue(greenFleetCreationPage.hasAddCustomerrInfoHeaderDisplayed(testData.getExpectedResult()[3]),
				"customer info header is not Displayed");

		// Validate Contact & Dealership info header
		assertTrue(greenFleetCreationPage.hasConatctAndDealershipHeaderDisplayed(testData.getExpectedResult()[4]),
				"Contact & Dealership info header is not Displayed");

		// Validate Product info icon.
		assertTrue(greenFleetCreationPage.hasProductInfoHeaderDisplayed(testData.getExpectedResult()[5]),
				"product info text header is not Displayed successfully");

		// Validate Case Coding header
		assertTrue(greenFleetCreationPage.hasCaseCodingHeaderDisplayed(testData.getExpectedResult()[6]),
				"Case Coding text header is not Displayed successfully");

		// Validate Case Information header
		assertTrue(greenFleetCreationPage.hasCaseInformationHeaderDisplayed(testData.getExpectedResult()[7]),
				"Case Information text  is not Displayed successfully");

		// Validate Related Case header
		assertTrue(greenFleetCreationPage.hasRelatedCaseHeaderDisplayed(testData.getExpectedResult()[8]),
				"Related case text is not Displayed successfully");

		// Validate Problem Details Header:
		assertTrue(greenFleetCreationPage.hasProblemDetailsHeaderDisplayed(testData.getExpectedResult()[9]),
				"Problem Details info is not Displayed successfully");

		// Validate Summary field header
		assertTrue(greenFleetCreationPage.hasSummaryHeaderDisplayed(testData.getExpectedResult()[10]),
				"Summary is not Displayed successfully");

		// Validate Workbasket field header
		assertTrue(greenFleetCreationPage.hasWorkbasketHeaderDisplayed(testData.getExpectedResult()[11]),
				"Workbasket field is not Displayed successfully");

		// Validate Greenfleet R4 field header
		assertTrue(greenFleetCreationPage.hasGreenFleetR4HeaderDisplayed(testData.getExpectedResult()[12]),
				"GreenfleetR4 field is not Displayed successfully");

		// Validate Accept button
		assertTrue(greenFleetCreationPage.hasAcceptBtnDisplayed(), "Accept button is not Displayed successfuly");

		// Validate Accept and Close button
		assertTrue(greenFleetCreationPage.hasAcceptandCloseBtnDisplayed(),
				"Accept and Close button is not Displayed successfuly");

		// Validate Withdraw button
		assertTrue(greenFleetCreationPage.hasWithdrawBtnDisplayed(), "Withdraw Button is not Displayed successfuly");

		// Validate Save button
		assertTrue(greenFleetCreationPage.hasSaveBtnDisplayed(), "Save Button is not Displayed successfuly");

		// Expand Audit Header
		assertTrue(greenFleetCreationPage.hasAuditTextDisplayed(), "Audit HeaderText is not Displayed successfuly");

		// Click on Accept button & Verify the alert.
		greenFleetCreationPage = functionalMethods.clickAcceptVerfyAlert(greenFleetCreationPage);

		// Entering details in summary , priority ,click on accept and verify the alert
		greenFleetCreationPage = functionalMethods.enterGreenFleetCaseDetailsForAlert(greenFleetCreationPage,
				testData.getTestdata()[4], testData.getTestdata()[5], testData.getTestdata()[6],
				testData.getTestdata()[7], testData.getTestdata()[8], testData.getTestdata()[9],
				testData.getTestdata()[10]);

		// Click on product info button
		greenFleetCreationPage = functionalMethods.clickOnProductInfButton(greenFleetCreationPage);

		// Validate Model field text
		assertTrue(greenFleetCreationPage.hasModalProductTextDisplayed(), "Model text is not Displayed successfully");

		// Validate Usgaefield text
		assertTrue(greenFleetCreationPage.hasUsageProductTextDisplayed(), "Usgae text is not Displayed successfully");

		// Validate Units field text
		assertTrue(greenFleetCreationPage.hasUnitsProductTextDisplayed(), "Units text is not Displayed successfully");

		// Validate PIN field text
		assertTrue(greenFleetCreationPage.hasPinProductTextDisplayed(), "PIN is not displayed successfully");

		// Validate Part number text.
		assertTrue(greenFleetCreationPage.hasPartNumberProductTextDisplayed(),
				"Part number  text is not Displayed successfully");

		// Validate componet serial number text
		// assertTrue(greenFleetCreationPage.hasComponentSerialNumberDisplayed(),
		// "componet serial number text is not Displayed successfully");

		// Validate enter characters in product field, click on submit, verify the alert
		greenFleetCreationPage = functionalMethods.entrCharClkSubmt(greenFleetCreationPage, testData.getTestdata()[11]);

		// Validate meassge for invalid product .
		assertTrue(greenFleetCreationPage.hasMessageForInavlidProductDisplayed(),
				"Enter a valid model is not Displayed successfully");

		// Enter valid product model and click on submit button.
		greenFleetCreationPage = functionalMethods.entrValidModelClkSubmt(greenFleetCreationPage,
				testData.getTestdata()[12]);

		// Validate Owned status.
		assertTrue(greenFleetCreationPage.hasOwnedStatusDisplayed(), "Owned Staus is not Displayed successfully");

		// Click close and and verify the alerts
		greenFleetCreationPage = functionalMethods.clickCloseBtnVerfyAlert(greenFleetCreationPage);

		// Enter functional code ,functional area and click on close button.
		greenFleetCreationPage = functionalMethods.enterFCodeFAreaClkCloseBtn(greenFleetCreationPage,
				testData.getTestdata()[13], testData.getTestdata()[14]);

		// Validate Resolved-Completed Status.
		assertTrue(greenFleetCreationPage.hasResolvedCompletedStatusDisplayed(testData.getExpectedResult()[13]),
				" Resolved-Completed Staus is not Displayed successfully");
	}

	/**
	 * /** Author :Aparajita Description : Verifying the alert for Greenfleet case .
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */

	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6828GreenFleetCaseCreationTCSM(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		GreenFleetCreationPage greenFleetCreationPage;
		NavigationClass navigationClass;
		HomePage homePage;

		FunctionalMethods functionalMethods = new FunctionalMethods();

		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

		// Verify that Site Minder Page is opened
		assertTrue(siteMinderLoginPage.hasPortalOpened(), "Site Minder Portal is not opened");

		// Login to Site Minder Site
		pegaLoginPage = functionalMethods.loginToSiteMinder(siteMinderLoginPage, testData.getTestdata()[0],
				testData.getTestdata()[1]);

		// Verify that Logged in to Site Minder Site
		assertTrue(pegaLoginPage.hasPegaLoginPageDisplayed(), "Login to Site Minder Site is Unsuccessful");

		// Login to PEGA site
		navigationClass = functionalMethods.loginToPega(pegaLoginPage, testData.getTestdata()[2],
				testData.getTestdata()[3], NavigationClass.class);

		// Verify that Landing Page is displayed
		assertTrue(navigationClass.isLandingPageDisplayed(testData.getExpectedResult()[0]),
				"Landing page was unsuccessful");

		// Navigate to HomePage
		homePage = functionalMethods.navigateToHomePage(navigationClass);

		// Verify landing of HomePage
		assertTrue(homePage.hasHomePageDisplayed(), "Navigation to homepage was unsuccessful");

		// click on GreenFleet case creation
		greenFleetCreationPage = functionalMethods.clickOnGreenFleetCaseBtn(homePage);

		// verify landing of GSC page
		assertTrue(greenFleetCreationPage.hasGreenFleetPageDisplayedTCSMUser(testData.getExpectedResult()[2]),
				" Green fleet page is not displayed successfully");

		// VAlidate customer info header
		assertTrue(greenFleetCreationPage.hasAddCustomerrInfoHeaderDisplayed(testData.getExpectedResult()[3]),
				"customer info header is not Displayed");

		// VAlidate Contact & Dealership info header
		assertTrue(greenFleetCreationPage.hasConatctAndDealershipHeaderDisplayed(testData.getExpectedResult()[4]),
				"Contact & Dealership info header is not Displayed");

		// VAlidate Product info header
		assertTrue(greenFleetCreationPage.hasProductInfoHeaderDisplayed(testData.getExpectedResult()[5]),
				"product info header is not Displayed");

		// VAlidate Case Coding header
		assertTrue(greenFleetCreationPage.hasCaseCodingHeaderDisplayed(testData.getExpectedResult()[6]),
				"Case Coding header is not Displayed");

		// VAlidate Case Information header
		assertTrue(greenFleetCreationPage.hasCaseInformationHeaderDisplayed(testData.getExpectedResult()[7]),
				"Case Information header is not Displayed");

		// VAlidate Related Case header
		assertTrue(greenFleetCreationPage.hasRelatedCaseHeaderDisplayed(testData.getExpectedResult()[8]),
				"Related case header is not Displayed");

		// VAlidate Problem Details header:
		assertTrue(greenFleetCreationPage.hasProblemDetailsHeaderDisplayed(testData.getExpectedResult()[9]),
				"Problem Details header is not Displayed");

		// VAlidate Summary header
		assertTrue(greenFleetCreationPage.hasSummaryHeaderDisplayed(testData.getExpectedResult()[10]),
				"Summary header is not Displayed");

		// VAlidate Workbasket header
		assertTrue(greenFleetCreationPage.hasWorkbasketHeaderDisplayed(testData.getExpectedResult()[11]),
				"Workbasket header is not Displayed");

		// VAlidate Greenfleet R4 header
		assertTrue(greenFleetCreationPage.hasGreenFleetR4HeaderDisplayed(testData.getExpectedResult()[12]),
				"GreenfleetR4 header is not Displayed");

		// Validate Accept button
		assertTrue(greenFleetCreationPage.hasAcceptBtnDisplayed(), "Accept button is not Displayed");

		// Validate Accept and Close button
		assertTrue(greenFleetCreationPage.hasAcceptandCloseBtnDisplayed(), "Accept and Close button is not Displayed");

		// Validate Save button
		assertTrue(greenFleetCreationPage.hasSaveBtnDisplayed(), "Save button is not Displayed");

		// Validate Withdraw button.
		assertTrue(greenFleetCreationPage.hasWithdrawBtnDisplayed(), "Withdraw button is not Displayed");

		// Validate Audit status button
		assertTrue(greenFleetCreationPage.hasAuditHistoryDisplayed(), "Audit is not Displayed");

		// Enter case details for Greenfleet case creation and click on acceptButton
		greenFleetCreationPage = functionalMethods.enterGreenFleetCaseDetailsTCSMUser(greenFleetCreationPage,
				testData.getTestdata()[4], testData.getTestdata()[5], testData.getTestdata()[6],
				testData.getTestdata()[7], testData.getTestdata()[8], testData.getTestdata()[9],
				testData.getTestdata()[10], testData.getTestdata()[11]);

		// Validate close button
		assertTrue(greenFleetCreationPage.hasCloseBtnDisplayed(), "Close button is not Displayed successfully");

		// Validate save button
		assertTrue(greenFleetCreationPage.hasSaveBtnDisplayed(), "Save button is not Displayed successfully");

		// Validate cancel button
		assertTrue(greenFleetCreationPage.hasCancelBtnDisplayed(), "Cancel button is not Displayed successfully");

		// Click on Actions button
		greenFleetCreationPage = functionalMethods.clickOnActionsDD(greenFleetCreationPage);

		// Validate Refresh option
		assertTrue(greenFleetCreationPage.hasRefreshOptionDisplayed(testData.getExpectedResult()[13]),
				"Refresh option  is not Displayed successfully");

		// Validate transfer to wb option
		assertTrue(greenFleetCreationPage.hasWorkBasketOptionDisplayed(testData.getExpectedResult()[14]),
				"Transfer To Workbasket is not Displayed successfully");

		// Validate transfer to Individual option
		assertTrue(greenFleetCreationPage.hasTransferIndividualOptionDisplayed(testData.getExpectedResult()[15]),
				"Transfer To Individual option is not Displayed successfully");

		// Validate Send case email option
		assertTrue(greenFleetCreationPage.hasSendCaseEmailOptionDisplayed(testData.getExpectedResult()[16]),
				"send case email option is not Displayed successfully");

		// Validate print option
		assertTrue(greenFleetCreationPage.hasPrintOptionDisplayed(testData.getExpectedResult()[17]),
				"print option is not Displayed successfully");

	}

}
