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
import com.deere.pages.gmailverification.AddInternalCommentPage;
import com.deere.pages.gmailverification.GmailLoginPage;
import com.deere.pages.gmailverification.SendCaseEmail;
import com.deere.pages.gsccasecreation.CaseCoding;
import com.deere.pages.gsccasecreation.GSCCaseCreationPage;
import com.deere.pages.gsccasecreation.GSCCustomerSearch;
import com.deere.pages.gsccasecreation.GSCR4Page;
import com.deere.pages.gsccasecreation.GSCRoutingFilterSearchPage;
import com.deere.pages.gsccasecreation.GSCRoutingPage;
import com.deere.pages.gsccasecreation.ViewEmailZeacomPage;
import com.deere.pages.homepage.HomePage;
import com.deere.pages.isgcasecreation.ISGCasePage;
import com.deere.pages.isgcasecreation.ISGCaseSearchPage;
import com.deere.pages.solutionsearch.SolutionSearchHomePage;
import com.deere.pages.webform.Deere;
import com.deere.pages.webform.DeereLoginPage;
import com.deere.pages.webform.JDParts;
import com.deere.pages.webform.JDPartsWebFormSubmissionPage;
import com.deere.pages.webform.SouthEastAsia;
import com.deere.pages.webform.SouthEastAsiaLoginPage;
import com.deere.pages.webform.Techpubs;
import com.deere.pages.webform.TechpubsLoginPage;

public class GSCTestCases extends CoreTestCase {

	/**
	 * Author : Lahari Pasupuleti Description : As a TSS, I want to work on GSC case
	 * so that I can create, update, route and transfer and close the given case.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 * @throws Throwable
	 */

	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6333_GSCRouting(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) throws InterruptedException {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;
		GSCRoutingPage gscRoutingPage;
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
				"Landing page is not displayed");

		// Navigate to Home Page
		homePage = functionalMethods.navigateToHomeScreen(navigationClass);

		// Verify if Home Page is displayed
		assertTrue(homePage.isHomePageDisplayed(), "Navigation to Home Page was Unsuccessful");

		// Click on GSC case creation button
		gscRoutingPage = functionalMethods.clickOnGSCCaseButton(homePage);

		// verify if GSC page is displayed
		assertTrue(gscRoutingPage.hasNewDraftStatusDisplayed(testData.getExpectedResult()[5]),
				"Status of the Case is not New-DraftStatus");

		// verify if GSC page is displayed
		assertTrue(gscRoutingPage.hasGSCPageDisplayed(testData.getExpectedResult()[4]), "Create Case is not showing");

		// Entering GSC Case Creation All Mandatory fields data and click on submit
		// button
		gscRoutingPage = functionalMethods.gscCaseCreationDetails(gscRoutingPage, testData.getTestdata()[4],
				testData.getTestdata()[5], testData.getTestdata()[12], testData.getTestdata()[6],
				testData.getTestdata()[7], testData.getTestdata()[8], testData.getTestdata()[9],
				testData.getTestdata()[10], testData.getTestdata()[11]);

		// Validate Owned Status.
		assertTrue(gscRoutingPage.isOwnedStatusDisplayed(testData.getExpectedResult()[2]),
				"Status of the Case is not Owned");

		// Click Actions -> Transfer Case to Individual and click on submit button and
		// validate that Case is available in their My Cases grid.
		gscRoutingPage = functionalMethods.selTCWFromActionsClkSubmit(gscRoutingPage, testData.getTestdata()[12],
				testData.getTestdata()[13], GlobalThings.gscCaseIdNew);

		// verify if GSC page is displayed
		assertTrue(gscRoutingPage.hasNewDraftStatusDisplayed(testData.getExpectedResult()[5]),
				"Status of the Case is not New-DraftStatus");

		// verify if GSC page is displayed
		assertTrue(gscRoutingPage.hasGSCPageDisplayed(testData.getExpectedResult()[4]), "Create Case is not showing");

		// Entering GSC Case Creation All Mandatory fields data and click on submit
		// button
		gscRoutingPage = functionalMethods.gscCaseCreationDetails(gscRoutingPage, testData.getTestdata()[4],
				testData.getTestdata()[5], testData.getTestdata()[12], testData.getTestdata()[6],
				testData.getTestdata()[7], testData.getTestdata()[8], testData.getTestdata()[9],
				testData.getTestdata()[10], testData.getTestdata()[11]);

		// Validate Owned Status.
		assertTrue(gscRoutingPage.isOwnedStatusDisplayed(testData.getExpectedResult()[2]),
				"Status of the Case is not Owned");

		// Click Actions -> Transfer Case to WB ,work basket and click
		// on submit validate that Case is available in their My Cases grid.
		gscRoutingPage = functionalMethods.selWBFromActionsClkSubmit(gscRoutingPage, testData.getTestdata()[13],
				GlobalThings.gscCaseIdNew);

		// verify if GSC page is displayed
		assertTrue(gscRoutingPage.hasNewDraftStatusDisplayed(testData.getExpectedResult()[5]),
				"Status of the Case is not New-DraftStatus");

		// verify if GSC page is displayed
		assertTrue(gscRoutingPage.hasGSCPageDisplayed(testData.getExpectedResult()[4]), "Create Case is not showing");

		// Entering GSC Case Creation All Mandatory fields data and click on submit
		// button
		gscRoutingPage = functionalMethods.gscCaseCreationDetails(gscRoutingPage, testData.getTestdata()[4],
				testData.getTestdata()[5], testData.getTestdata()[12], testData.getTestdata()[6],
				testData.getTestdata()[7], testData.getTestdata()[8], testData.getTestdata()[9],
				testData.getTestdata()[10], testData.getTestdata()[11]);

		// Validate that Owned Status.
		assertTrue(gscRoutingPage.isOwnedStatusDisplayed(testData.getExpectedResult()[2]),
				"Status of the Case is not Owned");

		// click on close button
		gscRoutingPage = functionalMethods.clickOnCloseButton(gscRoutingPage);

		// Validate that resolved-completed status .
		assertTrue(gscRoutingPage.isResolvedCompletedStatusDisplayed(), "Status of the Case is not ResolvedCompleted");
	}

	/**
	 * Author : Lahari Pasupuleti Description : As TSS, want to select TSS group
	 * where case need to be routed and indicate the Sub-group from drop-down for
	 * TSS to use as queue filter so that case goes to appropriate group only
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 * @throws Throwable
	 */

	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6541_GSCRoutingFilterSearch(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;
		GSCRoutingPage gscRoutingPage;
		HomePage homePage;
		GSCRoutingFilterSearchPage gscRoutingFilterSearchPage;

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

		// Navigate to Home Page
		homePage = functionalMethods.navigateToHomeScreen(navigationClass);

		// Verify if Home Page is displayed
		assertTrue(homePage.isHomePageDisplayed(), "Navigation to Home Page was Unsuccessful");

		// Click on GSC case creation button
		gscRoutingPage = functionalMethods.clickOnGSCCaseButton(homePage);

		// verify if GSC page is displayed
		assertTrue(gscRoutingPage.hasNewDraftStatusDisplayed(testData.getExpectedResult()[1]),
				"Status of the Case is not New-DraftStatus");

		// Entering GSC Case Creation All Mandatory fields data and click on submit
		// button
		gscRoutingPage = functionalMethods.gscCaseCreationDetails(gscRoutingPage, testData.getTestdata()[4],
				testData.getTestdata()[5], testData.getTestdata()[16], testData.getTestdata()[6],
				testData.getTestdata()[7], testData.getTestdata()[8], testData.getTestdata()[9],
				testData.getTestdata()[10], testData.getTestdata()[11]);

		// Validate Owned Status
		assertTrue(gscRoutingPage.isOwnedStatusDisplayed(testData.getExpectedResult()[2]),
				"Owned Status is not displayed successfully");

		// Click Actions -> select Transfer Case to Individual and click on submit
		gscRoutingPage = functionalMethods.selectTransWB(gscRoutingPage);

		// verify Owned status is displayed
		assertTrue(gscRoutingPage.hasOwnedStatusDisplayed(testData.getExpectedResult()[2]),
				"OwnedStatus is not displayed successfully");

		// Select value from workBaket and click on transfer button
		gscRoutingPage = functionalMethods.selectValFromWBClkTrnsBtn(gscRoutingPage, testData.getTestdata()[14]);

		// verify NewStatus
		assertTrue(gscRoutingPage.hasNewStatusDisplayed(testData.getExpectedResult()[3]),
				"NewStatus is not displayed successfully");

		// Navigating to Routing page and click on WorkgroupQueue
		gscRoutingFilterSearchPage = functionalMethods.gscRoutingFilterWBQueue(gscRoutingPage);

		// Verify that navigated to WorkgroupQueue page
		assertTrue(gscRoutingFilterSearchPage.hasFiltersLinkDisplayed(testData.getExpectedResult()[4]),
				"Filters is not displaying successfully");

		// Capture the current case id and click on Filters Link
		gscRoutingFilterSearchPage = functionalMethods.capCaseIdClkFilters(gscRoutingFilterSearchPage);

		// validate WorkGroups area is displayed
		assertTrue(gscRoutingFilterSearchPage.hasWorkGroupsDisplayed(testData.getExpectedResult()[5]),
				"Workgroups area is not displaying successfully");

		// verify with WorkBasket auto-complete is displayed
		assertTrue(gscRoutingFilterSearchPage.hasWorkBasketDisplayed(), "Workbasket is displaying successfully");

		// Select value from WorkBasket click on submit
		gscRoutingFilterSearchPage = functionalMethods.selectValFromWorkBasketandClikSubmit(gscRoutingFilterSearchPage,
				testData.getTestdata()[14]);

		// Validate WorkBasket page is refreshed
		assertTrue(gscRoutingFilterSearchPage.hasWorkGroupRefreshedDisplayed(),
				"WorkGroup page is not refreshed successfully ");

		// Validate grid contains WorkGroup as selected in Filters button
		assertTrue(gscRoutingFilterSearchPage.hasWorkGroupContSameWGNameDisplayed(testData.getExpectedResult()[6]),
				"Grid contains Workgroup that you chose in the Filters is unsuccessful");

		// Validate Grid contains all cases that were routed to this WorkBasket
		// including case created above.
		gscRoutingFilterSearchPage = functionalMethods.verfyCaseIsExistInWBQ(gscRoutingFilterSearchPage);

	}

	/**
	 * Author : Lahari Pasupuleti Description : As TSS, want to select TSS group
	 * where case need to be routed and indicate the Sub-group from drop-down for
	 * TSS to use as queue filter so that case goes to appropriate group only..
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 * @throws Throwable
	 */

	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6551_GSCRoutingWorkBasketSearch(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;
		GSCRoutingPage gscRoutingPage;
		HomePage homePage;
		GSCRoutingFilterSearchPage gscRoutingFilterSearchPage;

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

		// Navigate to Home Page
		homePage = functionalMethods.navigateToHomeScreen(navigationClass);

		// Verify if Home Page is displayed
		assertTrue(homePage.isHomePageDisplayed(), "Navigation to Home Page was Unsuccessful");

		// Click on GSC case creation button
		gscRoutingPage = functionalMethods.clickOnGSCCaseButton(homePage);

		// verify if GSC page is displayed
		assertTrue(gscRoutingPage.hasNewDraftStatusDisplayed(testData.getExpectedResult()[1]),
				"Status of the Case is not New-DraftStatus");

		// Entering GSC Case Creation All Mandatory fields data and click on submit
		// button
		gscRoutingPage = functionalMethods.gscCaseCreationDetails(gscRoutingPage, testData.getTestdata()[4],
				testData.getTestdata()[5], testData.getTestdata()[16], testData.getTestdata()[6],
				testData.getTestdata()[7], testData.getTestdata()[8], testData.getTestdata()[9],
				testData.getTestdata()[10], testData.getTestdata()[11]);

		// Verify Owned Status is showing
		assertTrue(gscRoutingPage.isOwnedStatusDisplayed(testData.getExpectedResult()[2]),
				"Owned Status is not displayed currectly");

		// Click Actions -> select Transfer Case to Individual and click on submit
		gscRoutingPage = functionalMethods.selectTransWB(gscRoutingPage);

		// verify Owned status is displayed
		assertTrue(gscRoutingPage.hasOwnedStatusDisplayed(testData.getExpectedResult()[2]),
				"OwnedStatus is not displayed successfully");

		// Select value from workBaket
		gscRoutingPage = functionalMethods.selectValFromWBClkTrnsBtn(gscRoutingPage, testData.getTestdata()[14]);

		// verify NewStatus
		assertTrue(gscRoutingPage.hasNewStatusDisplayed(testData.getExpectedResult()[1]),
				"NewStatus is not displayed successfully");

		// Click on WorkgroupQueue
		gscRoutingFilterSearchPage = functionalMethods.navToGSCRoutingFilterSearchclkWBQueue(gscRoutingPage);

		// Capture the current case id
		gscRoutingFilterSearchPage = functionalMethods.capCaseId(gscRoutingFilterSearchPage);

		// Verify WorkBasket auto-complete box showing
		assertTrue(gscRoutingPage.hasWorkBasketAutoCompleteDisplayed(),
				"WorkBasket auto-complete box is not displayed successfully");

		gscRoutingFilterSearchPage = functionalMethods.selectValFromWorkBasket(gscRoutingFilterSearchPage,
				testData.getTestdata()[14]);

		// verify that work basket is refreshed
		assertTrue(gscRoutingFilterSearchPage.hasWorkGroupRefreshedDisplayed(),
				"WorkGroup is  not Refreshed successfully");

		// Verify that grid contains Work group Name
		assertTrue(gscRoutingFilterSearchPage.hasWorkGroupContSameWGNameDisplayed(testData.getExpectedResult()[3]),
				"Grid contains Workgroup Name is  not displaying successfully");

		// Verify Grid contains all cases that were routed to this WorkBasket including
		// case created above.
		gscRoutingFilterSearchPage = functionalMethods.verfyCaseIsExistInWBQ(gscRoutingFilterSearchPage);
	}

	/**
	 * Author : Lahari Pasupuleti Description : The TSS ability to create a GSC
	 * case, transfer to individual, workBasket, route, and close a case.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 * @throws Throwable
	 */

	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6849_GSCRoutingNegitive(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;
		HomePage homePage;
		GSCRoutingPage gscRoutingPage;

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

		// Navigate to Home Page
		homePage = functionalMethods.navigateToHomeScreen(navigationClass);

		// Verify if Home Page is displayed
		assertTrue(homePage.isHomePageDisplayed(), "Navigation to Home Page was Unsuccessful");

		// Click on GSC case creation button
		gscRoutingPage = functionalMethods.clickOnGSCCaseButton(homePage);

		// verify if GSC page is displayed
		assertTrue(gscRoutingPage.hasNewDraftStatusDisplayed(testData.getExpectedResult()[1]),
				"Status of the Case is not New-DraftStatus");

		// Verify Add customer Info section is displayed
		assertTrue(gscRoutingPage.hasAddNewCusInfoSectionDisplayed(),
				"Add customer Info section is not displayed successfully");

		// Verify Add Contact & Dealership Info section is displayed
		assertTrue(gscRoutingPage.hasAddContactDealershipInfoSectionDisplayed(),
				"Add Contact & Dealership Info section is not displayed successfully");

		// Verify Add Product Info section is displayed
		assertTrue(gscRoutingPage.hasAddProductInfoSectionDisplayed(),
				"Add Product Info section is not displayed successfully");

		// Verify Case Coding section is displayed
		assertTrue(gscRoutingPage.hasCaseCodingSectionDisplayed(testData.getExpectedResult()[2]),
				"Case Coding section is not displayed successfully");

		// Verify Case Information section is displayed
		assertTrue(gscRoutingPage.hasCaseInformationSectionDisplayed(testData.getExpectedResult()[3]),
				"Case  Information  section is not displayed successfully");

		// Verify related Case section is displayed
		assertTrue(gscRoutingPage.hasRelatedCaseSectionDisplayed(),
				"Related Case section is not displayed successfully");

		// Verify Problem details section is displayed
		assertTrue(gscRoutingPage.hasProbDetailsSectionDisplayed(testData.getExpectedResult()[4]),
				"Problem Details  section is not displayed successfully");

		// Verify Add Files section is displayed
		assertTrue(gscRoutingPage.hasAddFilesSectionDisplayed(testData.getExpectedResult()[5]),
				"Add Files section is not displayed successfully");

		// Verify Action Buttons is displayed
		assertTrue(gscRoutingPage.hasAcceptBtnDisplayed(testData.getExpectedResult()[6]),
				"Accept Button is not displayed successfully");

		// Verify Accept And CLose Buttons is displayed
		assertTrue(gscRoutingPage.hasAccpAndCloseBtnDisplayed(testData.getExpectedResult()[7]),
				"Accept and close button is not displayed successfully");

		// Verify save Buttons is displayed
		assertTrue(gscRoutingPage.hasSaveBtnDisplayed(testData.getExpectedResult()[8]),
				"Save button is not displayed successfully");

		// Verify Withdraw Buttons is displayed
		assertTrue(gscRoutingPage.hasWithdrawBtnDisplayed(testData.getExpectedResult()[9]),
				"Withdraw button is not displayed successfully");

		// Entering GSC Case Creation All Mandatory fields data and click on submit
		// button
		gscRoutingPage = functionalMethods.caseCreationDetails(gscRoutingPage, testData.getTestdata()[4],
				testData.getTestdata()[5], testData.getTestdata()[16], testData.getTestdata()[6],
				testData.getTestdata()[7], testData.getTestdata()[8], testData.getTestdata()[9],
				testData.getTestdata()[10], testData.getTestdata()[11], testData.getTestdata()[17]);

		// verify Owned status is displayed
		assertTrue(gscRoutingPage.hasOwnedStatusDisplayed(testData.getExpectedResult()[10]),
				"OwnedStatus is not displayed successfully");

		// Select Transfer case to individual from Actions DD
		gscRoutingPage = functionalMethods.selectTransferToIndividual(gscRoutingPage);

		// verify Operator auto complete filed is showing
		assertTrue(gscRoutingPage.hasOperatorDisplayed(testData.getExpectedResult()[11]),
				"Operator is not displayed successfully");

		// verify WorkBasket auto complete filed is showing
		assertTrue(gscRoutingPage.hasWorkBasketFieldDisplayed(testData.getExpectedResult()[12]),
				"WorkBasket is not displayed successfully");

		// Validate Cancel Button
		assertTrue(gscRoutingPage.hasCancelButtonnDisplayed(testData.getExpectedResult()[13]),
				" Cancel Button is  not displayed successfully");

		// Validate Submit button
		assertTrue(gscRoutingPage.hasSubmitBtnDisplayed(testData.getExpectedResult()[14]),
				"Submit Button is not displayed successfully");

		// Enter data into Operator field
		gscRoutingPage = functionalMethods.enterOperatorFiledDataInvalid(gscRoutingPage, testData.getTestdata()[12]);

		// verify User entered is not valid alert appears.
		assertTrue(gscRoutingPage.hasUserEnteredAlertDisplayed(testData.getExpectedResult()[15]),
				"User entered is not valid alert  is not displayed successfully");

		// Enter data into Operator filed
		gscRoutingPage = functionalMethods.enterOperatorFiledData(gscRoutingPage, testData.getTestdata()[13]);

		// Click on Submit Button and switch to alert
		gscRoutingPage = functionalMethods.clkSubmitBtnSwitchToAlert(gscRoutingPage);

		// verify Value cannot be blank valid alert appears.
		assertTrue(gscRoutingPage.hasValidationMessgDisplayed(testData.getExpectedResult()[16]),
				"Value cannot be blank  is not displayed successfully");

		// Enter data into Operator filed ,Select work basket value and click on submit
		// button
		gscRoutingPage = functionalMethods.enterOperatorSelWBClkSub(gscRoutingPage, testData.getTestdata()[14],
				testData.getTestdata()[15]);

		// verify Owned status is displayed
		assertTrue(gscRoutingPage.hasOwnedStatusDisplayed(testData.getExpectedResult()[10]),
				"OwnedStatus is not displayed successfully");

		// Click Actions dropdown>Work Case
		gscRoutingPage = functionalMethods.selectWorkCaseFrmActionsDD(gscRoutingPage);

		// verify Owned status is displayed
		assertTrue(gscRoutingPage.hasOwnedStatusDisplayed(testData.getExpectedResult()[10]),
				"OwnedStatus is not displayed successfully");

		// verify Cancel button displayed
		assertTrue(gscRoutingPage.hasCancelBtnDisplayed(testData.getExpectedResult()[13]),
				"Cancle button is not displayed successfully");

		// verify Save button is displayed
		assertTrue(gscRoutingPage.hasSaveBtnDisplayed(testData.getExpectedResult()[8]),
				"Save Button is not displayed successfully");

		// Click Actions>Transfer to WB
		gscRoutingPage = functionalMethods.selectTranfWorkbasketFrmActionsDD(gscRoutingPage);

		// verify Cancel button displayed
		assertTrue(gscRoutingPage.hasCancelBtnDisplayed(testData.getExpectedResult()[13]),
				"Cancel button is not displayed successfully");

		// verify transfer button displayed
		assertTrue(gscRoutingPage.hasTransferBtnDisplayed(testData.getExpectedResult()[17]),
				"Transfer button is not displayed successfully");

		// verify WorkBasekt displayed
		assertTrue(gscRoutingPage.hasWorkBasektDisplayed(), "WorkBasekt is not displayed successfully");

		// click on Transfer button and accept alert
		gscRoutingPage = functionalMethods.clikTransfBtnAccetAlert(gscRoutingPage);

		// verify Value cannot be blank valid alert appears.
		assertTrue(gscRoutingPage.hasValidationMessageDisplayed(),
				"Value cannot be blank  is not displayed successfully");

		// Select work basket value and click on Cancel button
		gscRoutingPage = functionalMethods.selectWorkBasketFiledclickCancel(gscRoutingPage);

		// Validate Owned status is displayed
		assertTrue(gscRoutingPage.hasOwnedStatusDisplayed(testData.getExpectedResult()[10]),
				"OwnedStatus is not displayed successfully");

	}

	/**
	 * Author :Lahari Description :Verify the Auto Reply mail to customer to add
	 * comments
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws IOException
	 * @throws AWTException
	 * @throws Throwable
	 */
	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC3670_GSCWebFormAutoReplyToCustomerForMail(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		ISGCaseSearchPage isgCaseSearchPage;
		ISGCasePage isgCasePage;
		NavigationClass navigationClass;
		JDPartsWebFormSubmissionPage jdPartsWebFormSubmissionPage;
		JDParts jdParts;
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
		jdPartsWebFormSubmissionPage = functionalMethods.enterdetailedDescription(jdPartsWebFormSubmissionPage,
				testData.getTestdata()[3]);

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

		// Click on correspondence
		isgCaseSearchPage = functionalMethods.clickOnCorrespondence(isgCasePage);

		// Verify presence of email to customer
		isgCaseSearchPage = functionalMethods.clickOnMail(isgCaseSearchPage);

		// Validate mail window
		assertTrue(isgCaseSearchPage.hasMailWindowDisplayed(), "Email View Window Details are not Displayed");

		// Validate mail window
		assertTrue(isgCaseSearchPage.hasSubjectDisplayed(), "Subject not Displayed");

		// switch to main Window page
		isgCaseSearchPage = functionalMethods.switchToMainPage(isgCaseSearchPage);

	}

	/**
	 * Author :Lahari Description : Verify the Auto Reply mail to Zeacom.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */
	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC3671_AutoReplyToZeacom(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;
		ISGCaseSearchPage isgCaseSearchPage;
		ViewEmailZeacomPage viewEmailZeacomPage;
		ISGCasePage isgCasePage;
		CaseSearchPage caseSearchPag;
		JDPartsWebFormSubmissionPage jdPartsWebFormSubmissionPage;
		JDParts jdParts;

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
		jdPartsWebFormSubmissionPage = functionalMethods.enterdetailedDescription(jdPartsWebFormSubmissionPage,
				testData.getTestdata()[3]);

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

		// Click on correspondence
		isgCaseSearchPage = functionalMethods.clickOnCorrespondence(isgCasePage);

		// Click on New Case Mail For Zeacom
		viewEmailZeacomPage = functionalMethods.clickOnMailZeacom(isgCaseSearchPage);

		// Validate mail window
		assertTrue(viewEmailZeacomPage.hasMailWindowZeacomDisplayed(), "Email View Window Details are not Displayed");

		// Get the opened case information
		viewEmailZeacomPage = functionalMethods.getOpenedCaseMessageZeacom(viewEmailZeacomPage);

		// Validate From mail id
		assertTrue(viewEmailZeacomPage.HTMLPageSourceCode.contains(testData.getExpectedResult()[10]),
				"From mail ID is not displayed ");

		// Validate Full name
		assertTrue(viewEmailZeacomPage.HTMLPageSourceCode.contains(testData.getExpectedResult()[11]),
				"Full name is not displayed ");

		// Validate Business Name
		assertTrue(viewEmailZeacomPage.HTMLPageSourceCode.contains(testData.getExpectedResult()[12]),
				"Business Name is not displayed ");

		// Validate Business Phone
		assertTrue(viewEmailZeacomPage.HTMLPageSourceCode.contains(testData.getExpectedResult()[13]),
				"Business Phone is not displayed ");

		// Validate Home Phone
		assertTrue(viewEmailZeacomPage.HTMLPageSourceCode.contains(testData.getExpectedResult()[14]),
				"Home Phone is not displayed ");

		// Validate Mobile Phone
		assertTrue(viewEmailZeacomPage.HTMLPageSourceCode.contains(testData.getExpectedResult()[15]),
				"Mobile Phone is not displayed ");

		// Validate Email Address
		assertTrue(viewEmailZeacomPage.HTMLPageSourceCode.contains(testData.getExpectedResult()[16]),
				"Email Address is not displayed ");

		// Validate Product
		assertTrue(viewEmailZeacomPage.HTMLPageSourceCode.contains(testData.getExpectedResult()[17]),
				"Product is not displayed ");

		// Validate Machine PIN
		assertTrue(viewEmailZeacomPage.HTMLPageSourceCode.contains(testData.getExpectedResult()[18]),
				"Machine PIN is not displayed ");

		// Validate Comments/Questions
		assertTrue(viewEmailZeacomPage.HTMLPageSourceCode.contains(testData.getExpectedResult()[19]),
				"Comments/Questions is not displayed ");

		// // Validate Dealer Information
		// assertTrue(viewEmailZeacomPage.HTMLPageSourceCode.contains(testData.getExpectedResult()[20]),
		// "Dealer Information is not displayed ");
		//
		// // Validate Dealer Name
		// assertTrue(viewEmailZeacomPage.HTMLPageSourceCode.contains(testData.getExpectedResult()[21]),
		// "Dealer Name is not displayed ");
		//
		// // Validate Dealer City
		// assertTrue(viewEmailZeacomPage.HTMLPageSourceCode.contains(testData.getExpectedResult()[22]),
		// "Dealer City is not displayed ");
		//
		// // Validate Dealer State
		// assertTrue(viewEmailZeacomPage.HTMLPageSourceCode.contains(testData.getExpectedResult()[23]),
		// "Dealer State is not displayed ");

		// switch to main Window page
		isgCasePage = functionalMethods.switchToMainPage(viewEmailZeacomPage);

	}

	/**
	 * Author :Lahari Description : Customer receives email with reply to his
	 * questions/comments.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */
	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6649_CustomerReplyBackToEmail(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;
		ISGCasePage isgCasePage;
		SouthEastAsiaLoginPage southEastAsiaLoginPage;
		SouthEastAsia southEastAsia;
		SendCaseEmail sendCaseEmail;
		GmailLoginPage gmailLoginPage;
		CaseSearchPage caseSearchPage;

		FunctionalMethods functionalMethods = new FunctionalMethods();

		// opening SouthEastAsia Form Portal
		southEastAsiaLoginPage = functionalMethods.openWebformPortal_SouthEastAsia(getDriver(),
				testData.getTestdata()[0]);

		// Entering UserName ,Password and click on Submit
		southEastAsia = functionalMethods.loginToSouthEastAsiaWebform(southEastAsiaLoginPage, testData.getTestdata()[1],
				testData.getTestdata()[2]);

		// Validating if South East Asia WebForm is displayed
		assertTrue(southEastAsia.hasSouthEastAsiaWebFormPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to South East Asia WebForm Page was Unsuccessful");

		// Validating that FirstName is displaying
		assertTrue(southEastAsia.hasFirstNameDisplayed(testData.getExpectedResult()[1]),
				"First name is not displayed correctly");

		// Validating that Business Address is displaying
		assertTrue(southEastAsia.hasSouthEastAsiaBusinessAddrDisplayed(testData.getExpectedResult()[2]),
				"Business Address is not displayed correctly");

		// Validating that Phone number is displaying
		assertTrue(southEastAsia.hasSouthEastAsiaPhoneDisplayed(testData.getExpectedResult()[3]),
				"Phonenumber is not Displayed correctly");

		// Validating that Email is displaying
		assertTrue(southEastAsia.hasSouthEastAsiaEmailDisplayed(testData.getExpectedResult()[4]),
				"Email is not Displayed correctly");

		// Validating that Primary Message is displaying
		assertTrue(southEastAsia.hasSouthEastAsiaPrimaryMessageDisplayed(testData.getExpectedResult()[5]),
				"Primary Message is not Displayed correctly");

		// Entering Detailed description and Attaching file
		southEastAsia = functionalMethods.enterDetailedDesp(southEastAsia, testData.getTestdata()[3]);

		// Validate that Clear button
		assertTrue(southEastAsia.hasClearButtonDisplayed(), "Clear Button not showing");

		// click on Submit button
		southEastAsia = functionalMethods.clickSubmitBtn(southEastAsia);

		// Validate that Final Message is displayed
		assertTrue(southEastAsia.hasFinalMessageDisplayed(testData.getExpectedResult()[7]),
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
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed correctly");

		// Navigate to Case search page
		caseSearchPage = functionalMethods.clickCaseSearch(navigationClass);

		// Validating that navigated to Case search page
		assertTrue(caseSearchPage.hasCaseSearchHomePageDisplayed(), "Navigation to Case search page was Unsuccessful");

		// Entering the Case Id in Case Search Box and click on case link
		isgCasePage = functionalMethods.enterCaseIDClickCaseSrch(caseSearchPage, GlobalThings.caseID_SouthEastAsia);

		// Validating that New Status is displayed
		assertTrue(isgCasePage.hasNewStatusDisplayed(testData.getExpectedResult()[8]),
				"New Status  is not displayed correctly");

		// Validating that Work Basket is displayed
		assertTrue(isgCasePage.hasWorkBasketDisplayed(), "Work Basket is not displayed correctly");

		// Validating that Priority is displayed
		assertTrue(isgCasePage.hasPriorityTextDisplayed(), "Priority is not displayed correctly");

		// Validating that Origin is displayed
		assertTrue(isgCasePage.hasOriginTextDisplayed(), "Origin is not displayed correctly");

		// Click on Action and select Work Case
		isgCasePage = functionalMethods.selectWCFrmAction(isgCasePage, testData.getTestdata()[8],
				testData.getTestdata()[9], testData.getTestdata()[10]);

		// Validating that Owned Status is displayed
		// assertTrue(isgCasePage.hasOwnedStatusDisplayed(testData.getExpectedResult()[12]),
		// "Owned Status is not displayed correctly");

		// click on Close button
		isgCasePage = functionalMethods.clickCloseButton(isgCasePage);

		// Validating that resolved completed status
		assertTrue(isgCasePage.hasResolvedCompletedStatusDisplayed(), "resolved completed status is not displayed ");

		// Navigating to Send Case Email page and click send case Email option
		sendCaseEmail = functionalMethods.navigateToSendCaseEmailPage(isgCasePage);

		// Validating that Send Case Email pop up is showing
		assertTrue(sendCaseEmail.hasSendEmailPopUpDisplayed(), "Send Case Email pop up is  not showing");

		// Enter To filed data and click on send button
		sendCaseEmail = functionalMethods.entetToFiledData(sendCaseEmail, testData.getTestdata()[11]);

		// Validating that Resolved-Completed Status is displayed
		assertTrue(isgCasePage.hasResolvedCompletedStatusDisplayed(),
				"Resolved-Completed Status  is not displayed correctly");

		// open GMail portal
		gmailLoginPage = functionalMethods.openGmailPortal(getDriver(), testData.getTestdata()[12]);

		// Enter login details
		gmailLoginPage = functionalMethods.loginToGmailPage(gmailLoginPage, testData.getTestdata()[13],
				testData.getTestdata()[14]);

		// Verify GMail login page is opened
		assertTrue(gmailLoginPage.hasAppButtonExist(), "Gmail App Button is not displayed");

		// //Enter date into Search Box and click on search icon
		// gmailLoginPage=functionalMethods.clickOnSearchBox(gmailLoginPage,GlobalThings.caseID_SouthEastAsia,testData.getTestdata()[13]);
		//
		// // Validate final message.
		// assertTrue(gmailLoginPage.hasFinalMessage(), "Final Message is not
		// displayed");
		//
		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

	}

	/**
	 * Author :Lahari Description : Customer receives email with reply to his
	 * questions/comments.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */
	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6650_CustomerCanNotAddadditionalComment(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;
		ISGCasePage isgCasePage;
		SouthEastAsiaLoginPage southEastAsiaLoginPage;
		SouthEastAsia southEastAsia;
		SendCaseEmail sendCaseEmail;
		GmailLoginPage gmailLoginPage;
		CaseSearchPage caseSearchPage;

		FunctionalMethods functionalMethods = new FunctionalMethods();
		// opening SouthEastAsia Form Portal
		southEastAsiaLoginPage = functionalMethods.openWebformPortal_SouthEastAsia(getDriver(),
				testData.getTestdata()[0]);

		// Entering UserName ,Password and click on Submit
		southEastAsia = functionalMethods.loginToSouthEastAsiaWebform(southEastAsiaLoginPage, testData.getTestdata()[1],
				testData.getTestdata()[2]);

		// Validating if South East Asia WebForm is displayed
		assertTrue(southEastAsia.hasSouthEastAsiaWebFormPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to South East Asia WebForm Page was Unsuccessful");

		// Validating that FirstName is displaying
		assertTrue(southEastAsia.hasFirstNameDisplayed(testData.getExpectedResult()[1]),
				"First name is not displayed correctly");

		// Validating that Business Address is displaying
		assertTrue(southEastAsia.hasSouthEastAsiaBusinessAddrDisplayed(testData.getExpectedResult()[2]),
				"Business Address is not displayed correctly");

		// Validating that Phone number is displaying
		assertTrue(southEastAsia.hasSouthEastAsiaPhoneDisplayed(testData.getExpectedResult()[3]),
				"Phonenumber is not Displayed correctly");

		// Validating that Email is displaying
		assertTrue(southEastAsia.hasSouthEastAsiaEmailDisplayed(testData.getExpectedResult()[4]),
				"Email is not Displayed correctly");

		// Validating that Primary Message is displaying
		assertTrue(southEastAsia.hasSouthEastAsiaPrimaryMessageDisplayed(testData.getExpectedResult()[5]),
				"Primary Message is not Displayed correctly");

		// Entering Detailed description and Attaching file
		southEastAsia = functionalMethods.enterDetailedDesp(southEastAsia, testData.getTestdata()[3]);

		// Validate that Clear button
		assertTrue(southEastAsia.hasClearButtonDisplayed(), "Clear Button not showing");

		// click on Submit button
		southEastAsia = functionalMethods.clickSubmitBtn(southEastAsia);

		// Validate that Final Message is displayed
		assertTrue(southEastAsia.hasFinalMessageDisplayed(testData.getExpectedResult()[7]),
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
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed correctly");

		// Navigate to Case search page
		caseSearchPage = functionalMethods.clickCaseSearch(navigationClass);

		// Validating that navigated to Case search page
		assertTrue(caseSearchPage.hasCaseSearchHomePageDisplayed(), "Navigation to Case search page was Unsuccessful");

		// Entering the Case Id in Case Search Box and click on case link
		isgCasePage = functionalMethods.enterCaseIDClickCaseSrch(caseSearchPage, GlobalThings.caseID_SouthEastAsia);

		// Validating that New Status is displayed
		assertTrue(isgCasePage.hasNewStatusDisplayed(testData.getExpectedResult()[8]),
				"New Status  is not displayed correctly");

		// Validating that Work Basket is displayed
		assertTrue(isgCasePage.hasWorkBasketDisplayed(), "Work Basket is not displayed correctly");

		// Validating that Priority is displayed
		assertTrue(isgCasePage.hasPriorityTextDisplayed(), "Priority is not displayed correctly");

		// Validating that Origin is displayed
		assertTrue(isgCasePage.hasOriginTextDisplayed(), "Origin is not displayed correctly");

		// Click on Action and select Work Case
		isgCasePage = functionalMethods.selectWCFrmAction(isgCasePage, testData.getTestdata()[8],
				testData.getTestdata()[9], testData.getTestdata()[10]);

		// Validating that Owned Status is displayed
		// assertTrue(isgCasePage.hasOwnedStatusDisplayed(testData.getExpectedResult()[12]),
		// "Owned Status is not displayed correctly");

		// click on Close button
		isgCasePage = functionalMethods.clickCloseButton(isgCasePage);

		// Validating that resolved completed status
		assertTrue(isgCasePage.hasResolvedCompletedStatusDisplayed(), "resolved completed status is not displayed ");

		// Navigating to Send Case Email page and click send case Email option
		sendCaseEmail = functionalMethods.navigateToSendCaseEmailPage(isgCasePage);

		// Validating that Send Case Email pop up is showing
		assertTrue(sendCaseEmail.hasSendEmailPopUpDisplayed(), "Send Case Email pop up is  not showing");

		// Enter To filed data and click on send button
		sendCaseEmail = functionalMethods.entetToFiledData(sendCaseEmail, testData.getTestdata()[11]);

		// Validating that Resolved-Completed Status is displayed
		assertTrue(isgCasePage.hasResolvedCompletedStatusDisplayed(),
				"Resolved-Completed Status  is not displayed correctly");

		// open GMail portal
		gmailLoginPage = functionalMethods.openGmailPortal(getDriver(), testData.getTestdata()[12]);

		// Enter login details
		gmailLoginPage = functionalMethods.loginToGmailPage(gmailLoginPage, testData.getTestdata()[13],
				testData.getTestdata()[14]);

		// Verify GMail login page is opened
		assertTrue(gmailLoginPage.hasAppButtonExist(), "Gmail App Button is not displayed");

		// //Enter date into Search Box and click on search icon
		// gmailLoginPage=functionalMethods.clickOnSearchBox(gmailLoginPage,GlobalThings.caseID_SouthEastAsia,testData.getTestdata()[13]);
		//
		// // Validate final message.
		// assertTrue(gmailLoginPage.hasFinalMessage(), "Final Message is not
		// displayed");
		//
		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

	}

	/**
	 * Author :Lahari Description : Customer receives email with reply to his
	 * questions/comments.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */
	@Test(enabled = true, dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6870_CustomerCanNotSeeExternalAttachmnets(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;
		ISGCasePage isgCasePage;
		SouthEastAsiaLoginPage southEastAsiaLoginPage;
		SouthEastAsia southEastAsia;
		SendCaseEmail sendCaseEmail;
		GmailLoginPage gmailLoginPage;
		CaseSearchPage caseSearchPage;

		FunctionalMethods functionalMethods = new FunctionalMethods();

		// opening SouthEastAsia Form Portal
		southEastAsiaLoginPage = functionalMethods.openWebformPortal_SouthEastAsia(getDriver(),
				testData.getTestdata()[0]);

		// Entering UserName ,Password and click on Submit
		southEastAsia = functionalMethods.loginToSouthEastAsiaWebform(southEastAsiaLoginPage, testData.getTestdata()[1],
				testData.getTestdata()[2]);

		// Validating if South East Asia WebForm is displayed
		assertTrue(southEastAsia.hasSouthEastAsiaWebFormPageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to South East Asia WebForm Page was Unsuccessful");

		// Validating that FirstName is displaying
		assertTrue(southEastAsia.hasFirstNameDisplayed(testData.getExpectedResult()[1]),
				"First name is not displayed correctly");

		// Validating that Business Address is displaying
		assertTrue(southEastAsia.hasSouthEastAsiaBusinessAddrDisplayed(testData.getExpectedResult()[2]),
				"Business Address is not displayed correctly");

		// Validating that Phone number is displaying
		assertTrue(southEastAsia.hasSouthEastAsiaPhoneDisplayed(testData.getExpectedResult()[3]),
				"Phonenumber is not Displayed correctly");

		// Validating that Email is displaying
		assertTrue(southEastAsia.hasSouthEastAsiaEmailDisplayed(testData.getExpectedResult()[4]),
				"Email is not Displayed correctly");

		// Validating that Primary Message is displaying
		assertTrue(southEastAsia.hasSouthEastAsiaPrimaryMessageDisplayed(testData.getExpectedResult()[5]),
				"Primary Message is not Displayed correctly");

		// Entering Detailed description and Attaching file
		southEastAsia = functionalMethods.enterDetailedDesp(southEastAsia, testData.getTestdata()[3]);

		// Validate that Clear button
		assertTrue(southEastAsia.hasClearButtonDisplayed(), "Clear Button not showing");

		// click on Submit button
		southEastAsia = functionalMethods.clickSubmitBtn(southEastAsia);

		// Validate that Final Message is displayed
		assertTrue(southEastAsia.hasFinalMessageDisplayed(testData.getExpectedResult()[7]),
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
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed correctly");

		// Navigate to Case search page
		caseSearchPage = functionalMethods.clickCaseSearch(navigationClass);

		// Validating that navigated to Case search page
		assertTrue(caseSearchPage.hasCaseSearchHomePageDisplayed(), "Navigation to Case search page was Unsuccessful");

		// Entering the Case Id in Case Search Box and click on case link
		isgCasePage = functionalMethods.enterCaseIDClickCaseSrch(caseSearchPage, GlobalThings.caseID_SouthEastAsia);

		// Validating that New Status is displayed
		assertTrue(isgCasePage.hasNewStatusDisplayed(testData.getExpectedResult()[8]),
				"New Status  is not displayed correctly");

		// Validating that Work Basket is displayed
		assertTrue(isgCasePage.hasWorkBasketDisplayed(), "Work Basket is not displayed correctly");

		// Validating that Priority is displayed
		assertTrue(isgCasePage.hasPriorityTextDisplayed(), "Priority is not displayed correctly");

		// Validating that Origin is displayed
		assertTrue(isgCasePage.hasOriginTextDisplayed(), "Origin is not displayed correctly");

		// Click on Action and select Work Case
		isgCasePage = functionalMethods.selectWCFrmAction(isgCasePage, testData.getTestdata()[8],
				testData.getTestdata()[9], testData.getTestdata()[10]);

		// Validating that Owned Status is displayed
		// assertTrue(isgCasePage.hasOwnedStatusDisplayed(testData.getExpectedResult()[12]),
		// "Owned Status is not displayed correctly");

		// click on Close button
		isgCasePage = functionalMethods.clickCloseButton(isgCasePage);

		// Validating that resolved completed status
		assertTrue(isgCasePage.hasResolvedCompletedStatusDisplayed(), "resolved completed status is not displayed ");

		// Navigating to Send Case Email page and click send case Email option
		sendCaseEmail = functionalMethods.navigateToSendCaseEmailPage(isgCasePage);

		// Validating that Send Case Email pop up is showing
		assertTrue(sendCaseEmail.hasSendEmailPopUpDisplayed(), "Send Case Email pop up is  not showing");

		// Enter To filed data and click on send button
		sendCaseEmail = functionalMethods.entetToFiledData(sendCaseEmail, testData.getTestdata()[11]);

		// Validating that Resolved-Completed Status is displayed
		assertTrue(isgCasePage.hasResolvedCompletedStatusDisplayed(),
				"Resolved-Completed Status  is not displayed correctly");

		// open GMail portal
		gmailLoginPage = functionalMethods.openGmailPortal(getDriver(), testData.getTestdata()[12]);

		// Enter login details
		gmailLoginPage = functionalMethods.loginToGmailPage(gmailLoginPage, testData.getTestdata()[13],
				testData.getTestdata()[14]);

		// Verify GMail login page is opened
		assertTrue(gmailLoginPage.hasAppButtonExist(), "Gmail App Button is not displayed");

		// //Enter date into Search Box and click on search icon
		// gmailLoginPage=functionalMethods.clickOnSearchBox(gmailLoginPage,GlobalThings.caseID_SouthEastAsia,testData.getTestdata()[13]);
		//
		// // Validate final message.
		// assertTrue(gmailLoginPage.hasFinalMessage(), "Final Message is not
		// displayed");
		//
		// Login to Site Minder
		siteMinderLoginPage = functionalMethods.openPortal(getDriver(), inputEnvironmentDetails.getUrl());

	}

	/**
	 * Author :Aparajita Pattanaik Description : Validating GSC customer search
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */

	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6339_GSCCustomerSearch(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		GSCCustomerSearch gscCustomerSearch;
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
				"Landing page is not displayed");

		// Navigate to home page.
		homePage = functionalMethods.navigateHomePage(navigationClass);

		// Verify that Landing of home Page is displayed
		assertTrue(homePage.isHomePageDisplayed(testData.getExpectedResult()[1]),
				"Navigation to Home page was Unsuccessful");

		// Click on GSC case in homepage.
		gscCustomerSearch = functionalMethods.clickOnGSCCaseBtn(homePage);

		// verify landing of GSC page
		assertTrue(gscCustomerSearch.isGSCPageDisplayed(testData.getExpectedResult()[2]),
				"Navigate to gsc page displayed successfully");

		// click on Add customer Info icon
		gscCustomerSearch = functionalMethods.clickAddCustomeInfoDetails(gscCustomerSearch);

		// Validate Phone field
		assertTrue(gscCustomerSearch.hasPhoneDisplayed(testData.getExpectedResult()[3]),
				"Phone is not displayed successfully");

		// Validate for Business Name text
		assertTrue(gscCustomerSearch.hasBusinessNameDisplayed(testData.getExpectedResult()[4]),
				"Business is not displayed successfully");

		// Validate for Last Name text
		assertTrue(gscCustomerSearch.hasLastNameDisplayed(testData.getExpectedResult()[5]),
				"LastName is not displayed successfully");

		// Validate for First Name text
		assertTrue(gscCustomerSearch.hasFirstNameDisplayed(testData.getExpectedResult()[6]),
				"FirstName is not displayed successfully");

		// Validate for Country text
		assertTrue(gscCustomerSearch.hasCountryDisplayed(testData.getExpectedResult()[7]),
				"Country is not displayed successfully");

		// Validate for State text
		assertTrue(gscCustomerSearch.hasStateDisplayed(testData.getExpectedResult()[8]),
				"State is not displayed successfully");

		// Validate for City text
		assertTrue(gscCustomerSearch.hasCityDisplayed(testData.getExpectedResult()[9]),
				"City is not displayed successfully");

		// Validate for Zip text
		assertTrue(gscCustomerSearch.hasZipDisplayed(testData.getExpectedResult()[10]),
				"Zip is not displayed successfully");

		// Enter details for case creation and validate customer search
		gscCustomerSearch = functionalMethods.customerSearchValidation(gscCustomerSearch, testData.getTestdata()[4],
				testData.getTestdata()[5], testData.getTestdata()[6]);

		// Validate Business text
		assertTrue(gscCustomerSearch.hasBusinessTextDisplayed(testData.getExpectedResult()[11]),
				"business is not displayed successfully");

		// Validate Physical address text
		assertTrue(gscCustomerSearch.hasPhysicalTextDisplayed(testData.getExpectedResult()[12]),
				"physical address is not displayed successfully");

		// Validate Mailing address text
		assertTrue(gscCustomerSearch.hasMailingDisplayed(testData.getExpectedResult()[13]),
				"mailing address is not displayed successfully");

		// Validate Business number text
		assertTrue(gscCustomerSearch.hasBusinessNumberDisplayed(testData.getExpectedResult()[14]),
				"Business number is not displayed successfully");

		// Validate Back button
		assertTrue(gscCustomerSearch.hasBackBtnDisplayed(), "Back button is not displayed successfully");

		// Click on back button and then click on customer details link.
		gscCustomerSearch = functionalMethods.clkBakBtnCustDtlsLink(gscCustomerSearch);

		// Validate Firstname is displaying correctly in Add customer section
		assertTrue(gscCustomerSearch.hasFirstnameDetailsDisplayed(), "Firstname details are displaying correctly");

		// Validate Lastname is displaying correctly in Add customer section
		assertTrue(gscCustomerSearch.hasLastnameDetailsDisplayed(), "Lastname details are displaying correctly");

		// Validate Business Phone is displaying correctly in Add customer section
		assertTrue(gscCustomerSearch.hasLastnameDetailsDisplayed(), "PhoneNumber details are displaying correctly");

		// Validate Address Details are displaying correctly in Add customer section
		assertTrue(gscCustomerSearch.hasAddressDetailsDisplayed(), "Address details are displaying correctly");

		// Validate Entity ID is displaying correctly in Add customer section
		assertTrue(gscCustomerSearch.hasEntityIDDetailsDisplayed(), "EntityID details are displaying correctly");

		// Click on change customer link
		gscCustomerSearch = functionalMethods.clickOnCustomerLink(gscCustomerSearch);

		// Validate modal appears with above customer info,
		assertTrue(gscCustomerSearch.hasSearchCustomerModalDisplayed(testData.getExpectedResult()[16]),
				"CustomerSearchModal is not displayed successfully");

		// Validate Clear Customer link
		assertTrue(gscCustomerSearch.hasClearCustomerLinkDisplayed(),
				"CustomerSearchModal is not displayed successfully");

		// Validate Cancel button.
		assertTrue(gscCustomerSearch.hasCancelBtnCustomerSearchDisplayed(), "Cancel Button is not displayed successfully");

		// Click Clear Customer
		gscCustomerSearch = functionalMethods.clickOnClearCustomer(gscCustomerSearch);
	}

	/**
	 * Author : Aparajita Pattanaik Description : GSC case creation and verifying
	 * status.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */
	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6585_GSCButtons(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		GSCCustomerSearch gscCustomerSearch;
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
				"Landing page is not displayed");

		// Navigate to home page.
		homePage = functionalMethods.navigateToHomeMenu(navigationClass);

		// Verify that Landing of home Page is displayed
		assertTrue(homePage.isHomePageDisplayed(testData.getExpectedResult()[1]),
				"Navigation to Home page was Unsuccessful");

		// Click on GSC page.
		gscCustomerSearch = functionalMethods.clickOnGSCCaseBtn(homePage);

		// verify landing of GSC page
		assertTrue(gscCustomerSearch.isGSCPageDisplayed(testData.getExpectedResult()[2]),
				"Navigate to gsc page was unsuccessful");

		// Entered customer details for GSC case creation .
		gscCustomerSearch = functionalMethods.enterGSCCaseCustomerDetails(gscCustomerSearch, testData.getTestdata()[4],
				testData.getTestdata()[5], testData.getTestdata()[6], testData.getTestdata()[7],
				testData.getTestdata()[8], testData.getTestdata()[9], testData.getTestdata()[10],
				testData.getTestdata()[11], testData.getTestdata()[12], testData.getTestdata()[13],
				testData.getTestdata()[14]);

		// Validate for new draft status.
		assertTrue(gscCustomerSearch.hasNewDraftStatusDisplayed(testData.getExpectedResult()[3]),
				"NewDraft status is not displayed successfully");

		// Validate for Save button
		assertTrue(gscCustomerSearch.hasSaveBtnDisplayed(), "Save button is not displayed successfully");

		// Validate for Accept & Close button.
		assertTrue(gscCustomerSearch.hasAcceptAndCloseBtnDisplayed(),
				"Accept & Close button is not displayed successfully");

		// Validate for accept button
		assertTrue(gscCustomerSearch.hasAcceptBtnDisplayed(), "Accept button is not displayed successfully");

		// Click on Accept button
		gscCustomerSearch = functionalMethods.clickOnAccept(gscCustomerSearch);

		// Validate for owned status button
		assertTrue(gscCustomerSearch.hasOwnedStatusDisplayed(testData.getExpectedResult()[7]),
				"Owned status is not displayed successfully");

		// Validate for close button
		assertTrue(gscCustomerSearch.hasCloseBtnDisplayed(testData.getExpectedResult()[8]),
				"Close button is not displayed successfully");

		// Validate for save button
		assertTrue(gscCustomerSearch.hasSaveBtnDisplayed(testData.getExpectedResult()[9]),
				"Save button is not displayed successfully");

		// Validate for cancel button
		assertTrue(gscCustomerSearch.hasCancelBtnDisplayed(), "Cancel button is not displayed successfully");

		// Click on close button
		gscCustomerSearch = functionalMethods.clickOnCloseBtn(gscCustomerSearch);

		// Validate for Resolved and completed status.
		assertTrue(gscCustomerSearch.hasResolveCompletedStatusDisplayed(testData.getExpectedResult()[11]),
				"Resolve and completed status is not displayed successfully");

		// Click on Action and select reopen
		gscCustomerSearch = functionalMethods.clickOnActionReopenBtn(gscCustomerSearch);

		// Validate reopened status
		assertTrue(gscCustomerSearch.hasReopenStatusDisplayed(testData.getExpectedResult()[12]),
				"Reopen status is not displayed successfully");

		// Click on Action and workcase button.
		gscCustomerSearch = functionalMethods.clickOnActionWorkcaseBtn(gscCustomerSearch);

		// Validate for accept button
		assertTrue(gscCustomerSearch.hasAcceptBtnDisplayed(testData.getExpectedResult()[13]),
				"Accept button is not displayed successfully");

		// Validate for save button
		assertTrue(gscCustomerSearch.hasSaveBtnDisplayed(testData.getExpectedResult()[14]),
				"Save button is not displayed successfully");

		// Validate for cancel button
		assertTrue(gscCustomerSearch.hasCancelBtnDisplayed(), "Cancel button is not displayed successfully");

		// Click on cancel button
		gscCustomerSearch = functionalMethods.clickOnCancelButton(gscCustomerSearch);

	}

	/**
	 * Author : Aparajita Pattanaik Description : GSC case creation.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */

	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6330_GSCCaseCreation(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		GSCCustomerSearch gscCustomerSearch;
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

		// Navigate to home page.
		homePage = functionalMethods.navigateToHomePage(navigationClass);

		// Verify that Landing of home Page is displayed
		assertTrue(homePage.isHomePageDisplayed(testData.getExpectedResult()[1]),
				"Navigation to Home page was Unsuccessful");

		// Click on GSC case in homepage.
		gscCustomerSearch = functionalMethods.clickOnGSCCaseBtn(homePage);

		// verify landing of GSC page
		assertTrue(gscCustomerSearch.isGSCPageDisplayed(testData.getExpectedResult()[2]),
				"Navigate to gsc page displayed successfully");

		// Validate customer info header
		assertTrue(gscCustomerSearch.hasCustomerInfoHeaderDisplayed(testData.getExpectedResult()[3]),
				"customer info is not Displayed succesfully");

		// Validate Contact & Dealership header
		assertTrue(gscCustomerSearch.hasConatctAndDealershipHeaderDisplayed(testData.getExpectedResult()[4]),
				"Contact & Dealership info is not Displayed succesfully");

		// Validate Product info header
		assertTrue(gscCustomerSearch.hasProductInfoHeaderDisplayed(testData.getExpectedResult()[5]),
				"product info is not Displayed successfully");

		// Validate Case Coding header
		assertTrue(gscCustomerSearch.hasCaseCodingHeaderDisplayed(testData.getExpectedResult()[6]),
				"Case Coding is not Displayed successfully");

		// Validate Case Information header
		assertTrue(gscCustomerSearch.hasCaseInformationHeaderDisplayed(testData.getExpectedResult()[7]),
				"Case Information  is not Displayed successfully");

		// Validate Related Case header
		assertTrue(gscCustomerSearch.hasRelatedCaseHeaderDisplayed(testData.getExpectedResult()[8]),
				"Related case is not Displayed successfully");

		// Validate Problem Details header
		assertTrue(gscCustomerSearch.hasProblemDetailsHeaderDisplayed(testData.getExpectedResult()[9]),
				"Problem Details info is not Displayed successfully");

		// Validate Summary field header
		assertTrue(gscCustomerSearch.hasSummaryHeaderDisplayed(testData.getExpectedResult()[10]),
				"Summary is not Displayed successfully");

		// Validate Workbasket field
		assertTrue(gscCustomerSearch.hasWorkbasketHeaderDisplayed(testData.getExpectedResult()[11]),
				"Workbasket is not Displayed successfully");

		// Validate Accept button
		assertTrue(gscCustomerSearch.hasAcceptBtnDisplayed(), "Accept Button is not Displayed successfully");

		// Assert Accept and Close button
		assertTrue(gscCustomerSearch.hasAcceptandCloseBtnDisplayed(),
				"Accept and Close Button is not Displayed successfully");

		// Validate Withdraw button
		assertTrue(gscCustomerSearch.hasWithdrawBtnDisplayed(), "Withdraw Buttonis not Displayed successfully");

		// Validate Save button
		assertTrue(gscCustomerSearch.hasSaveBtnDisplayed(), "Save Buttonis not Displayed successfully");

		// Validate Audit button
		//// assertTrue(gscCustomerSearch.hasAuditHistoryDisplayed(testData.getExpectedResult()[12]),
		// "Audit is not Displayed successfully ");

		// Enter customer details for GSC case creation and click on Accept button
		gscCustomerSearch = functionalMethods.enterGSCCustomerDetails(gscCustomerSearch, testData.getTestdata()[4],
				testData.getTestdata()[5], testData.getTestdata()[6], testData.getTestdata()[7],
				testData.getTestdata()[8], testData.getTestdata()[9], testData.getTestdata()[10],
				testData.getTestdata()[11], testData.getTestdata()[12], testData.getTestdata()[13],
				testData.getTestdata()[14]);

		// Validate for owned status .
		assertTrue(gscCustomerSearch.hasOwnedStatusDisplayed(testData.getExpectedResult()[13]),
				"Owned status is not displayed successfully");

	}

	/**
	 * Author : Aparajita Pattanaik Description : Negative flow for GSC case.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */

	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6847_GSCNegativeCaseCreation(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		GSCCustomerSearch gscCustomerSearch;
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
				"Landing page is not displayed");

		// Navigate to home page.
		homePage = functionalMethods.navigateToHomePage(navigationClass);

		// Verify that Landing of home Page is displayed
		assertTrue(homePage.isHomePageDisplayed(testData.getExpectedResult()[1]),
				"Navigation to Home page was Unsuccessful");

		// Click on GSC case in homepage.
		gscCustomerSearch = functionalMethods.clickOnGSCCaseBtn(homePage);

		// verify landing of GSC page
		assertTrue(gscCustomerSearch.isGSCPageDisplayed(testData.getExpectedResult()[2]),
				"Navigate to gsc page displayed successfully");

		// Validate customer info header
		assertTrue(gscCustomerSearch.hasCustomerInfoHeaderDisplayed(testData.getExpectedResult()[3]),
				"customer info is not Displayed");

		// Validate Contact & Dealership info header
		assertTrue(gscCustomerSearch.hasConatctAndDealershipHeaderDisplayed(testData.getExpectedResult()[4]),
				"Contact & Dealership info is not Displayed");

		// Validate Product info header
		assertTrue(gscCustomerSearch.hasProductInfoHeaderDisplayed(testData.getExpectedResult()[5]),
				"product info is not Displayed");

		// Validate Case Coding header
		assertTrue(gscCustomerSearch.hasCaseCodingHeaderDisplayed(testData.getExpectedResult()[6]),
				"Case Coding is not Displayed");

		// Validate Case Information header
		assertTrue(gscCustomerSearch.hasCaseInformationHeaderDisplayed(testData.getExpectedResult()[7]),
				"Case Information  is not Displayed");

		// Validate Related Case header
		assertTrue(gscCustomerSearch.hasRelatedCaseHeaderDisplayed(testData.getExpectedResult()[8]),
				"Related case is not Displayed");

		// Validate Problem Details header
		assertTrue(gscCustomerSearch.hasProblemDetailsHeaderDisplayed(testData.getExpectedResult()[9]),
				"Problem Details info is not Displayed");

		// Validate Summary field
		assertTrue(gscCustomerSearch.hasSummaryHeaderDisplayed(testData.getExpectedResult()[10]),
				"Summary is not Displayed");

		// Validate Workbasket field
		assertTrue(gscCustomerSearch.hasWorkbasketHeaderDisplayed(testData.getExpectedResult()[11]),
				"Workbasket is not Displayed");

		// Validate Accept button
		assertTrue(gscCustomerSearch.hasAcceptBtnDisplayed(), "Accept button is not Displayed successfully");

		// Validate Accept and Close button
		assertTrue(gscCustomerSearch.hasAcceptandCloseBtnDisplayed(),
				"Accept and Close button is not Displayed successfully");

		// Validate Withdraw button
		assertTrue(gscCustomerSearch.hasWithdrawBtnDisplayed(), "Withdraw button is not Displayed successfully");

		// Validate Save button
		assertTrue(gscCustomerSearch.hasSaveBtnDisplayed(), "Save button is not Displayed successfully");

		// Validate Audit History
		// assertTrue(gscCustomerSearch.hasAuditHistoryDisplayed(testData.getExpectedResult()[12]),
		// "Audit is not Displayed successfully");

		// Enter customer details for gsc case and verifying alert .
		gscCustomerSearch = functionalMethods.gscCaseAlertVerification(gscCustomerSearch, testData.getTestdata()[4],
				testData.getTestdata()[5], testData.getTestdata()[6], testData.getTestdata()[7],
				testData.getTestdata()[8], testData.getTestdata()[9], testData.getTestdata()[10],
				testData.getTestdata()[11], testData.getTestdata()[12], testData.getTestdata()[13],
				testData.getTestdata()[14]);

		// Validate owned status
		assertTrue(gscCustomerSearch.hasResolveCompletedStatusDisplayed(testData.getExpectedResult()[13]),
				"Resolved-completed status is not displaying successfully");

	}

	/**
	 * Author :Aparajita Pattanaik Description :Creating GSC case and validating
	 * AUdit History.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */

	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6540_AuditTrailDetails(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		GSCCustomerSearch gscCustomerSearch;
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
				"Landing page is not displayed successfully");

		// Navigate to home page.
		homePage = functionalMethods.navigateToHomePage(navigationClass);

		// Verify that Landing of home Page is displayed
		assertTrue(homePage.isHomePageDisplayed(testData.getExpectedResult()[1]),
				"Navigation to Home page was Unsuccessful");

		// Click on GSC case in homepage.
		gscCustomerSearch = functionalMethods.clickOnGSCCaseBtn(homePage);

		// verify landing of GSC page
		assertTrue(gscCustomerSearch.isGSCPageDisplayed(testData.getExpectedResult()[2]),
				"Navigate to gsc page displayed successfully");

		// click on Add customer Info
		gscCustomerSearch = functionalMethods.clickAddCustomeInfoDetails(gscCustomerSearch);

		// Verify landing of Customer Search page
		assertTrue(gscCustomerSearch.isAddCustomerDisplayed(),
				"Navigation to customer search is not displayed successfully");

		// Enter customer details for case creation ,attach file and click on Accept
		// button
		gscCustomerSearch = functionalMethods.enterAuditCustomerDetails(gscCustomerSearch, testData.getTestdata()[4],
				testData.getTestdata()[5], testData.getTestdata()[6], testData.getTestdata()[7],
				testData.getTestdata()[8], testData.getTestdata()[9], testData.getTestdata()[10],
				testData.getTestdata()[11], testData.getTestdata()[12], testData.getTestdata()[13],
				testData.getTestdata()[14]);

		// Click on Audit and validate audit history
		gscCustomerSearch = functionalMethods.clickOnAuditTrails(gscCustomerSearch);

		// Validate Audit History details.
		assertTrue(gscCustomerSearch.hasValidateAuditHistoryDetailsDisplayed(),
				"Audit History Details is not displayed successfully");

		// Click on Action-Transfer case to Individual and select mandatory details.
		gscCustomerSearch = functionalMethods.clickOnActionsTIndividual(gscCustomerSearch, testData.getTestdata()[15],
				testData.getTestdata()[16]);

		// Click on Audit and validate audit history.
		// gscCustomerSearch = functionalMethods.clickOnAuditTrails(gscCustomerSearch);

		// Click on Actions, send case email and verify audit details.
		gscCustomerSearch = functionalMethods.clickOnActionsSendCasMailEntrData(gscCustomerSearch,
				testData.getTestdata()[17]);

		// Validate for Resolved Completed status .
		assertTrue(gscCustomerSearch.hasOwnedStatusDisplayed(testData.getExpectedResult()[3]),
				"Resolved completed status is not displayed successfully");

	}

	/**
	 * Author : Aparajita Description : verifying withdraw functionality in GSC Case
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
	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6826_GSCWithdrawDetail(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		GSCCustomerSearch gscCustomerSearch;
		HomePage homePage;
		NavigationClass navigationClass;

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
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed");

		// Navigate to home page.
		homePage = functionalMethods.navigateToHomePage(navigationClass);

		// Verify that Landing of home Page is displayed
		assertTrue(homePage.isHomePageDisplayed(testData.getExpectedResult()[1]),
				"Navigation to Home page was Unsuccessful");

		// Click on GSC case in homepage.
		gscCustomerSearch = functionalMethods.clickOnGSCCaseBtn(homePage);

		// verify landing of GSC page
		assertTrue(gscCustomerSearch.isGSCPageDisplayed(testData.getExpectedResult()[2]),
				"Navigate to gsc page displayed successfully");

		// click on Add customer Info
		gscCustomerSearch = functionalMethods.clickAddCustomeInfoDetails(gscCustomerSearch);

		// Verify landing of Customer Search page
		assertTrue(gscCustomerSearch.isAddCustomerDisplayed(), "Navigation to customer search displayed");

		// Enter customer first name
		gscCustomerSearch = functionalMethods.enterGSCWithdrawDetails(gscCustomerSearch, testData.getTestdata()[4],
				testData.getTestdata()[5], testData.getTestdata()[6], testData.getTestdata()[7],
				testData.getTestdata()[8], testData.getTestdata()[9], testData.getTestdata()[10],
				testData.getTestdata()[11], testData.getTestdata()[12], testData.getTestdata()[6],
				testData.getTestdata()[6]);

		// Validate Accept button
		assertTrue(gscCustomerSearch.hasAcceptBtnDisplayed(), "Accept button is not Displayed successfully");

		// Validate Accept and Close button
		assertTrue(gscCustomerSearch.hasAcceptandCloseBtnDisplayed(),
				"Accept and Close button is not Displayed successfully");

		// Validate Withdraw button
		assertTrue(gscCustomerSearch.hasWithdrawBtnDisplayed(), "Withdraw button is not Displayed successfully");

		// Validate Save button
		assertTrue(gscCustomerSearch.hasSaveBtnDisplayed(), "Save button is not Displayed successfully");

		// Click on Withdraw and verify the text message.
		gscCustomerSearch = functionalMethods.clickOnWithdraw(gscCustomerSearch);

		// Validate new draft status.
		assertTrue(gscCustomerSearch.hasNewDraftStatusDisplayed(testData.getExpectedResult()[6]),
				"New Draft status is not displayed correctly");

		// click on Submit and verify the text message.
		gscCustomerSearch = functionalMethods.clickOnSubmit(gscCustomerSearch);

		// Validate of Withdraw status
		assertTrue(gscCustomerSearch.hasWithdrawStatusDisplayed(),
				" Resolved-Withdrawn status not displayed correctly");

	}

	/**
	 * Author : Aparajita Description : verifying cancel functionality in GSC Case
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

	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6825_GSC_Cancel_button(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		GSCCustomerSearch gscCustomerSearch;
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
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed");

		// Navigate to home page.
		homePage = functionalMethods.navigateToHomePage(navigationClass);

		// Verify that Landing of home Page is displayed
		assertTrue(homePage.isHomePageDisplayed(testData.getExpectedResult()[0]),
				"Navigation to Home page was Unsuccessful");

		// Click on GSC case in homepage.
		gscCustomerSearch = functionalMethods.clickOnGSCCaseBtn(homePage);

		// verify landing of GSC page
		assertTrue(gscCustomerSearch.isGSCPageDisplayed(testData.getExpectedResult()[1]),
				"Navigate to gsc page displayed successfully");

		// Click on Withdraw button
		gscCustomerSearch = functionalMethods.clickOnWithdraw(gscCustomerSearch);

		// Validate withdraw button
		assertTrue(gscCustomerSearch.hasNewDraftStatusDisplayed(testData.getExpectedResult()[2]),
				"New Draft status is not displayed correctly");

		// Click on cancel button and Actions button
		gscCustomerSearch = functionalMethods.clickOnCancelAndActns(gscCustomerSearch);

		// Validate refresh option, workcase, print.
		assertTrue(gscCustomerSearch.isOptionsRefreshDisplayed(testData.getExpectedResult()[3]),
				"Refresh option is not displayed ");

		// Validate work case option
		assertTrue(gscCustomerSearch.isOptionsWorkCaseDisplayed(testData.getExpectedResult()[4]),
				"Work Case option is not displayed ");

		// Validate print option
		assertTrue(gscCustomerSearch.isOptionsPrintDisplayed(testData.getExpectedResult()[5]),
				"Print option is not displayed ");
	}

	/**
	 * Author : Aparajita Pattanaik Description :Validation of GSC Customer Search
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */
	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6465_GSCCustomerSearchValidationAlert(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		GSCCustomerSearch gscCustomerSearch;
		NavigationClass navigationClass;
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
		gscCustomerSearch = navigationClass.clickHomePageButton();

		// Verify landing of HomePage
		assertTrue(gscCustomerSearch.isHomePageDisplayed(testData.getExpectedResult()[1]),
				"Navigation to homepage displayed successfully");

		// click on GSC case creation
		gscCustomerSearch = functionalMethods.clickonGSCCase(gscCustomerSearch);

		// verify landing of GSC page
		assertTrue(gscCustomerSearch.isGSCPageDisplayed(testData.getExpectedResult()[2]),
				"Navigate to gsc pageis  not displayed successfully");

		// click on Add customer Info
		gscCustomerSearch = functionalMethods.clickAddCustomeInfoDetails(gscCustomerSearch);

		// Validate customer search modal appears.
		// assertTrue(gscCustomerSearch.haCcustomerSearchModalHeaderDisplayed(),
		// "Customer Search Modal Header is not displaying successfully");

		// Validation of customer search and alert .
		gscCustomerSearch = functionalMethods.addCustomeValidation(gscCustomerSearch);

		// Enter data in last name,click on search customer and verify the alerts
		// Enter data in city field,click on search customer and verify the alerts
		gscCustomerSearch = functionalMethods.entrLnameClkSrchCustVrfyAlert(gscCustomerSearch,
				testData.getTestdata()[4], testData.getTestdata()[5]);

	}

	/**
	 * Author : Aparajita Pattanaik Description :Validation of GSC Customer Alert
	 * Validation
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */
	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6481_GSCCustomerInfoPanelValidation(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		GSCCustomerSearch gscCustomerSearch;
		NavigationClass navigationClass;
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
		gscCustomerSearch = navigationClass.clickHomePageButton();

		// Verify landing of HomePage
		assertTrue(gscCustomerSearch.isHomePageDisplayed(testData.getExpectedResult()[1]),
				"Navigation to homepage displayed successfully");

		// click on GSC case creation
		gscCustomerSearch = functionalMethods.clickonGSCCase(gscCustomerSearch);

		// verify landing of GSC page
		assertTrue(gscCustomerSearch.isGSCPageDisplayed(testData.getExpectedResult()[2]),
				"Navigate to gsc pageis  not displayed successfully");

		// click on Add customer Info
		gscCustomerSearch = functionalMethods.clickAddCustomeInfoDetails(gscCustomerSearch);

		// Validate customer search modal appears.
		assertTrue(gscCustomerSearch.haCcustomerSearchModalHeaderDisplayed(),
				"Navigate to gsc pageis not displayed successfully");

		// Enter details for case creation in customer search
		gscCustomerSearch = functionalMethods.customerSearchPanelValidation(gscCustomerSearch,
				testData.getTestdata()[4], testData.getTestdata()[5], testData.getTestdata()[6]);

		// Validate firstname details are displaying correctly
		assertTrue(gscCustomerSearch.hasFirstnameDetailsDisplayed(),
				"Firstname Details are  not displayed successfully");

		// Validate lastname details are displaying correctly.
		assertTrue(gscCustomerSearch.hasLastnameDetailsDisplayed(), "Lastname Details are  not displayed successfully");

		// Validate Address details are displaying correctly.
		assertTrue(gscCustomerSearch.hasAddressDetailsDisplayed(), "Address Details are  not displayed successfully");

		// Validate phone number is displaying correctly.
		assertTrue(gscCustomerSearch.hasPhoneNumberDetailsDisplayed(),
				"PhoneNumber details is  not displayed successfully");

		// Validate Entity ID is displaying correctly
		assertTrue(gscCustomerSearch.hasEntityIDDetailsDisplayed(),
				"Entity ID Details are  not displayed successfully");

	}

	/**
	 * Author :Aparajita Pattanaik Description : Verify case coding field for GSC
	 * case..
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */

	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6543_GSCCaseCoding(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) throws InterruptedException {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		CaseCoding casecoding;
		HomePage homePage;
		NavigationClass navigationClass;

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

		// Navigate to home page.
		homePage = functionalMethods.navigateToHomePage(navigationClass);

		// Verify that Landing of home Page is displayed
		assertTrue(homePage.isHomePageDisplayed(testData.getExpectedResult()[1]),
				"Navigation to Home page was Unsuccessful");

		// Click on GSC case in homepage.
		casecoding = functionalMethods.clickOnGSCCaseCod(homePage);

		// verify landing of GSC page
		assertTrue(casecoding.isGSCPageDisplayed(testData.getExpectedResult()[2]),
				"Navigate to gsc page displayed successfully");

		// Validate for DeniedAssistance dropdown
		assertTrue(casecoding.hasActionDeniedAssistanceDisplayed(testData.getExpectedResult()[3]),
				"Denied Assistance is not displayed");

		// Validate for ActionDocumented dropdown
		assertTrue(casecoding.hasActionDocumentedInformationDisplayed(testData.getExpectedResult()[4]),
				"Documented Information is not displayed");

		// Validate Forwarded to Field Manager
		assertTrue(casecoding.hasForwardedFieldManagerDisplayed(testData.getExpectedResult()[5]),
				"Forwarded to Field Manager field is not displayed");

		// Validate Forwarded to Legal
		assertTrue(casecoding.hasForwardedToLegalDisplayed(testData.getExpectedResult()[6]),
				"Forwarded to Legal field is not displayed");

		// Validate Forwarded to Legal and Safety
		assertTrue(casecoding.hasForwardedLegalSafetyDisplayed(testData.getExpectedResult()[7]),
				"Forwarded to Legal and Safety is not displayed");

		// Validate Forwarded to Other Deere Unit
		assertTrue(casecoding.hasDeereUnitDisplayed(testData.getExpectedResult()[8]),
				"Forwarded to Deere Unit is not displayed");

		// Validate Forwarded to Tier 2
		assertTrue(casecoding.hasForwardedTier2Displayed(testData.getExpectedResult()[9]),
				"Forwarded to Tier 2 is not displayed");

		// Validate No Action/Response by Customer
		assertTrue(casecoding.hasNoActionResponseDisplayed(testData.getExpectedResult()[10]),
				"No Action/Response by Customer is not displayed");

		// Validate Referred to Dealer
		assertTrue(casecoding.hasReferredDealerDisplayed(testData.getExpectedResult()[11]),
				"Referred to Dealer is not displayed");

		// Validate Resolved by Customer
		assertTrue(casecoding.hasResolvedbyCustomerDisplayed(testData.getExpectedResult()[12]),
				"Resolved by Customer is not displayed");

		// Validate Resolved by DTAC
		assertTrue(casecoding.hasResolvedbyDTACDisplayed(testData.getExpectedResult()[13]),
				"Resolved by DTAC is not displayed");

		// Validate Resolved by Dealer
		assertTrue(casecoding.hasResolvedbyDealerDisplayed(testData.getExpectedResult()[14]),
				"Resolved by Dealer is not displayed");

		// Validate Resolved with Coupon
		assertTrue(casecoding.hasResolvedwithCouponDisplayed(testData.getExpectedResult()[15]),
				"Resolved with Coupon field is not displayed");

		// Validate Resolved with JD Promise
		assertTrue(casecoding.hasResolvedwithJDPromiseDisplayed(testData.getExpectedResult()[16]),
				"Resolved with JD Promise field is not displayed");

		// Validate Resolved with Special Allowance
		assertTrue(casecoding.hasResolvedwithSpecialAllowanceDisplayed(testData.getExpectedResult()[17]),
				"Resolved with Special Allowance field is not displayed");

		// Validate Resolved with Warranty
		assertTrue(casecoding.hasResolvedwithWarrantyDisplayed(testData.getExpectedResult()[18]),
				"Resolved with Warranty field is not displayed");

		// Validate Sent Free Part(s)
		assertTrue(casecoding.hasSentFreePartDisplayed(testData.getExpectedResult()[19]),
				"Sent Free Part(s) field is not displayed");

		// Validate Sent free manual
		assertTrue(casecoding.hasSentfreeManualonDisplayed(testData.getExpectedResult()[20]),
				"Sent free manual field is not displayed");

		// Validate Supplied information
		assertTrue(casecoding.hasSuppliedInformationDisplayed(testData.getExpectedResult()[21]),
				"Supplied information field is not displayed");

	}

	/**
	 * Author : Jyothsna Description : Create GSC Case (R4 AgCC & TurfCC) Report
	 * Only
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 * @throws Throwable
	 */

	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6480_Report(InputEnvironmentDetails inputEnvironmentDetails, InputTestDetails testData)
			throws InterruptedException {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		SolutionSearchHomePage solutionSearchHomePage;
		NavigationClass navigationClass;
		HomePage homePage;
		ISGCaseSearchPage isgCaseSearchPage;
		GSCR4Page gscR4Page;
		GSCCaseCreationPage gscCaseCreationPage;

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
		assertTrue(navigationClass.isLandingPageDisplayed(), "Landing page is not displayed");

		// Navigate to HomePage
		homePage = functionalMethods.clickHomeLink(navigationClass);

		// Verify landing of HomePage
		assertTrue(homePage.isHomePageDisplayed(), "Navigation to homepage displayed successfully");

		// //Verify that My Territory is displayed
		// assertTrue(homePage.hasMyTerritoryDisplayed(), " My Territory is not
		// displayed");
		//
		// //Verify that correct category is displayed
		// assertTrue(homePage.hasMyCasesDisplayed(), "My Cases is not displayed");
		//
		// //Verify that correct category is displayed
		// assertTrue(homePage.hasCaseSearchDisplayed(), "Case search is not
		// displayed");
		//
		// //Verify that correct category is displayed
		// assertTrue(homePage.hasSolutionSearchDisplayed(), "Solution Search is not
		// displayed");
		//
		// //Verify that correct category is displayed
		// assertTrue(homePage.hasFAQHelpDisplayed(), "Faq / Helpis not displayed");
		//
		// //Verify that correct category is displayed
		// assertTrue(homePage.hasDMACDisplayed(), "Create DMAC Case is not displayed");
		//
		// //Verify that correct category is displayed
		// assertTrue(homePage.hasDPACisplayed(), "Create DPAC Case is not displayed");
		//
		// //Verify that correct category is displayed
		// assertTrue(homePage.hasDTACisplayed(), "Create DTAC Case is not displayed");
		//
		// //Verify that correct category is displayed
		// assertTrue(homePage.hasGSCCaseDisplayed(), "Create GSC Case is not
		// displayed");
		//
		// //Verify that correct category is displayed
		// assertTrue(homePage.hasISGCaseDisplayed(), "Create ISG Case is not
		// displayed");
		//
		// //Verify that correct category is displayed
		// assertTrue(homePage.hasGSCReportCaseDisplayed(), "Create GSC R4 Case Report
		// only is not displayed");
		//
		// //Verify that correct category is displayed
		// assertTrue(homePage.hasGreenFleetCaseDisplayed(), "GreenFleet case is not
		// displayed");
		//
		// Navigate to GSC Case Reports only
		gscR4Page = functionalMethods.clickGSCCaseReportOnly(homePage);

		// switch to frame
		gscR4Page = functionalMethods.switchToIFrame(gscR4Page);

		// validate Submit button
		assertTrue(gscR4Page.hasSubmitDisplayed(), "Submit button is not displayed");
		//
		// //validate Save button
		// assertTrue(gscR4Page.hasSaveDisplayed(), "Save button is not displayed");
		//
		// //validate product Details
		// assertTrue(gscR4Page.hasProblemDetailsDisplayed(), "Problem Details is not
		// displayed");
		//
		// //validate Summary
		// assertTrue(gscR4Page.hasSummaryDisplayed(), "Summary is not displayed");
		//
		// //validate workBasket
		// assertTrue(gscR4Page.hasWorkBasketDisplayed(), "workBasket is not
		// displayed");
		//
		// //validate case type
		// assertTrue(gscR4Page.hasCaseTypeDisplayed(), "case type is not displayed");
		//
		// //validate case subtype Agcc
		// assertTrue(gscR4Page.hasCaseTypeValueR4AgccDisplayed(), "case subtype Agcc is
		// not displayed");
		//
		// //validate case subtype Turf
		// assertTrue(gscR4Page.hasCaseTypeValueR4TurfDisplayed(), "case subtype Turf is
		// not displayed");
		//
		// //validate CCC Case number
		// assertTrue(gscR4Page.hasCCCCaseNumberDisplayed(), "CCC Case number is not
		// displayed");
		//
		// //validate Comments
		// assertTrue(gscR4Page.hasCommentsDisplayed(), "Comments is not displayed");
		//
		// //validate Internal Comments
		// assertTrue(gscR4Page.hasInternalCommentsDisplayed(), "Internal Comments is
		// not displayed");
		//
		// Navigate to GSC Case Creation page
		gscCaseCreationPage = functionalMethods.navigateToGSCCaseCreationPage(gscR4Page);

		// validate case status as New Draft
		assertTrue(gscCaseCreationPage.hasNewDraftStatysDisplayed(), "New Draft Status is not Displayed");

		// click on Add customer Info
		gscCaseCreationPage = functionalMethods.clickAddCustomeInfo(gscCaseCreationPage);

		// Verify landing of Customer Search page
		assertTrue(gscCaseCreationPage.isAddCustomerDisplayed(), "Navigation to customer search displayed");

		gscCaseCreationPage = functionalMethods.gscSearchCustomerDetailsReportVerification(gscCaseCreationPage,
				testData.getTestdata()[4], testData.getTestdata()[5], testData.getTestdata()[6],
				testData.getTestdata()[8], testData.getTestdata()[9], testData.getTestdata()[10],
				testData.getTestdata()[11], testData.getTestdata()[12], testData.getTestdata()[13],
				testData.getTestdata()[14], testData.getTestdata()[15]);

		// navigate to GSCR4Page
		gscR4Page = functionalMethods.navigateToGSCR4Page(gscCaseCreationPage);

		// select R4Turf as case type and add comments
		gscR4Page = functionalMethods.selectCaseTypeValueTurf(gscR4Page, testData.getTestdata()[15]);

		// save the case
		gscR4Page = functionalMethods.clickSave(gscR4Page);

		// close the case
		gscR4Page = functionalMethods.clickOnClose(gscR4Page);

		// save the case in close box
		gscR4Page = functionalMethods.clickSaveInCloseBox(gscR4Page);

		// navigate to case search page
		isgCaseSearchPage = functionalMethods.navigateToCaseSearchPage(gscR4Page);

		// Navigate to Case search page
		isgCaseSearchPage = navigationClass.clickCaseSearchHomeLink();

		// Verify that navigated to Case search page
		assertTrue(isgCaseSearchPage.hasCaseSearchHomePageDisplayed(),
				"Navigation to Case search page was Unsuccessful");

		// Enter the CaseId
		isgCaseSearchPage = functionalMethods.csEnterCaseId(isgCaseSearchPage, GSCR4Page.gscCaseID);// Deere.Caseid_Deere/

		// Click on Case Search image button
		isgCaseSearchPage = functionalMethods.clickCaseSearchImgLink(isgCaseSearchPage);

		// Click on Case Link to navigate to main page
		gscR4Page = functionalMethods.clickCaseLinkGSCReportOnly(isgCaseSearchPage);

		// switch to frame
		gscR4Page = functionalMethods.switchToActionsIFrame(gscR4Page);

		// Transfer to WB
		gscR4Page = functionalMethods.clickOnActionsR4Turf(gscR4Page);

		// validate Submit button
		assertTrue(gscR4Page.hasSubmitDisplayed(), "Submit button is not displayed");

		// submit the case
		gscR4Page = functionalMethods.clickSubmit(gscR4Page);

		// validate case status as Resolved-Completed
		assertTrue(gscR4Page.hasResolvedCompleted(), "Case status change to Resolved-Completed is unsuccessful");

	}

}
