package com.deere.testCases;

import static com.deere.global.CommonFunctions.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.deere.global.CoreTestCase;
import com.deere.global.FunctionalMethods;
import com.deere.global.GlobalDataProvider;
import com.deere.global.InputEnvironmentDetails;
import com.deere.global.InputTestDetails;
import com.deere.pages.NavigationClass;
import com.deere.pages.OwnedCasePage;
import com.deere.pages.PegaLoginPage;
import com.deere.pages.SiteMinderLoginPage;
import com.deere.pages.homepage.HomePage;
import com.deere.pages.isgcasecreation.ISGCaseCreation;
import com.deere.pages.isgcasecreation.ISGCaseCreationHomePage;
import com.deere.pages.isgcasecreation.ISGCasePage;
import com.deere.pages.isgcasecreation.ISGLinkSolutionPage;
import com.deere.pages.isgcasecreation.ISGRecommendedSolutionsSectionPage;
import com.deere.pages.isgcasecreation.ISGWithdrawPage;
import com.deere.pages.solutionsearch.SolutionSearchHomePage;
import com.deere.pages.workbasketqueue.WorkGroupQueuePage;

public class ISGTestCases extends CoreTestCase {
	/**
	 * Author : Lahari Pasupuleti Description : As a TSS, I want to enter model in
	 * product information for GSC and ISG cases so that case is populated to model
	 * information
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */

	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6560_ISGProductInformation(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;
		HomePage homePage;
		ISGCaseCreationHomePage isgCaseCreationHomePage;

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

		// Verify that if Home Page is displayed
		assertTrue(homePage.hasHomePageDisplayed(), "Navigation to Home Page Page was Unsuccessful");

		// Navigate to case creation page and Click on ISG Case creation Button
		isgCaseCreationHomePage = functionalMethods.navToISGCaseCreatclkISGBtn(homePage);

		// Verify that if ISG case Creation Page is displayed
		assertTrue(isgCaseCreationHomePage.hasISGCaseCreationHomePageDisplayed(testData.getExpectedResult()[1]),
				"Navigation to ISG Case Creation Page was Unsuccessful");

		// Verify that Case Information section is displayed
		assertTrue(isgCaseCreationHomePage.hasCaseInformationSectionDisplayed(testData.getExpectedResult()[2]),
				"Case Information section heading  is not displayed currenctly");

		// Verify that Priority DropDown Field is displayed
		assertTrue(isgCaseCreationHomePage.hasPriorityDropDownDisplayed(),
				"Priority DropDown Filed  is not displayed ");

		// Verify that Language DropDown Field is displayed
		assertTrue(isgCaseCreationHomePage.hasLanguageDropDownDisplayed(),
				"Language DropDown Filed  is not displayed ");

		// Verify that Origin DropDown Field is displayed
		assertTrue(isgCaseCreationHomePage.hasOriginDropDownDisplayed(), "Origin DropDown Filed  is not displayed ");

		// Verify that NCCA Text Field is displayed
		assertTrue(isgCaseCreationHomePage.hasNCCATextFieldDisplayed(), "NCCA TextBox Filed  is not displayed ");

		// Verify that Rally Text Field is displayed
		assertTrue(isgCaseCreationHomePage.hasRallyTextFieldDisplayed(), "Rally TextBox Filed   is not displayed ");

		// Verify that Solution needs to be created for the issue of this case checkBox
		// is displayed
		assertTrue(isgCaseCreationHomePage.hasSolutionCreateChekBoxdDisplayed(),
				"Solution needs to be created for the issue of this case  checkbox  is not displayed currenctly");

		// Verify Case Information EYE Icon displayed
		assertTrue(isgCaseCreationHomePage.hasCaseCreationEYEIconDisplayed(),
				"Case Information EYE Icon  is not displayed");

		// Click on Case Information "EYE" button
		isgCaseCreationHomePage = functionalMethods.clickCaseInfmEyeBtn(isgCaseCreationHomePage);

		// Verify Small pop-up appears after click on EYE Icon
		assertTrue(isgCaseCreationHomePage.hasSmallPopUpDisplayed(), "Small pop-up appears is not displayed ");

		// Verify Created On displayed
		assertTrue(isgCaseCreationHomePage.hasCreatedOnDisplayed(testData.getExpectedResult()[3]),
				"Created On  is not displayed ");

		// Verify Created On with 'm/dd/yyy hh:mm am/pm' information displayed
		assertTrue(isgCaseCreationHomePage.hasCreatedOnWithDateTimeInfmDisplayed(),
				"Created On with  'm/dd/yyy hh:mm am/pm'  information  is not displayed");

		// Verify Last Assigned displayed
		assertTrue(isgCaseCreationHomePage.hasLastAssignedDisplayed(testData.getExpectedResult()[4]),
				"Last Assigned  is not displayed");

		// Verify Last Assigned with 'm/dd/yyy hh:mm am/pm' information displayed
		assertTrue(isgCaseCreationHomePage.hasLastAssignedWithDateTimeInfmDisplayed(),
				"Last Assigned with  'm/dd/yyy hh:mm am/pm'  information is not displayed");

		// Verify Last Modified displayed
		assertTrue(isgCaseCreationHomePage.hasLastModifiedDisplayed(testData.getExpectedResult()[5]),
				"Last Modified with is not displayed");

		// Verify Last Modified with 'm/dd/yyy hh:mm am/pm' information displayed
		assertTrue(isgCaseCreationHomePage.hasLastModifiedWithDateTimeInfmDisplayed(),
				"Last Modified with  'm/dd/yyy hh:mm am/pm'  information is not displayed");

		// Click on Add Product Info and Enter model details for Product Info
		isgCaseCreationHomePage = functionalMethods.clickAddProductInfoEnterModelDetail(isgCaseCreationHomePage,
				testData.getTestdata()[4]);

		// Verify after click on Submit for Add Product Info it closes the modal pop
		// screen or not and validate the screen heading
		assertTrue(isgCaseCreationHomePage.hasProductHeadingDisplayed(testData.getExpectedResult()[6]),
				"Product Heading is not displayed");

		// Click Edit in Product Info section
		isgCaseCreationHomePage = functionalMethods.clickEditBtn(isgCaseCreationHomePage);

		// Verify Product Information modal appears
		assertTrue(isgCaseCreationHomePage.hasProductInfDisplayed(testData.getExpectedResult()[7]),
				"Product Information is not displayed");

		// clear value for model filed
		isgCaseCreationHomePage = functionalMethods.clearValueFromModelDropDownfiled(isgCaseCreationHomePage);

		// Click on Edit Product Info and Enter model details for Product Info
		isgCaseCreationHomePage = functionalMethods.clickEditProductInfoEnterModelDetail(isgCaseCreationHomePage,
				testData.getTestdata()[5]);

		// Verify after click on Submit for Add Product Info it closes the modal pop
		// screen or not and validate the screen heading
		assertTrue(isgCaseCreationHomePage.hasProductHeadingDisplayed(testData.getExpectedResult()[6]),
				"Product Heading is not displayed");
	}

	/**
	 * Author : Lahari Pasupuleti Description : As a TSS, I want to access and
	 * search cases and solutions in CCMS system so that I can utilize exiting
	 * information available in CCMS
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */

	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6587_ISGRecommendedSolutionsSection(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;
		HomePage homePage;
		ISGRecommendedSolutionsSectionPage isgRecommendedSolutionsSectionPage;

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

		// Verify that if Home Page is displayed
		assertTrue(homePage.hasHomePageDisplayed(), "Navigation to Home Page Page was Unsuccessful");

		// Navigate to ISGRecommendedSolutionsSectionPage and Click on ISG Case creation
		// Button
		isgRecommendedSolutionsSectionPage = functionalMethods.navToISGCaseCreatClkISGBtn(homePage);

		// Verify that if ISG case Creation Page is displayed
		assertTrue(
				isgRecommendedSolutionsSectionPage.hasISGCaseCreationHomePageDisplayed(testData.getExpectedResult()[1]),
				"Navigation to ISG Case Creation Page was Unsuccessful");

		// Verify that Recommended Solutions section is displayed
		assertTrue(isgRecommendedSolutionsSectionPage.hasRecommendedSolutionsDisplayed(testData.getExpectedResult()[2]),
				"Recommended Solutions  section heading  is not displayed correctly");

		// Verify that Languages is displayed
		assertTrue(isgRecommendedSolutionsSectionPage.hasLanguagesDisplayed(testData.getExpectedResult()[3]),
				"Languages Label  is not displayed currenctly");

		// Verify that ID is displayed
		assertTrue(isgRecommendedSolutionsSectionPage.hasIDDisplayed(testData.getExpectedResult()[4]),
				"ID Label  is not displayed currenctly");

		// Verify that Description is displayed
		assertTrue(isgRecommendedSolutionsSectionPage.hasDescriptionDisplayed(testData.getExpectedResult()[5]),
				"Description Label  is not displayed currenctly");

		// Verify that Link New Solution is displayed
		assertTrue(isgRecommendedSolutionsSectionPage.hasLinkNewSolutionDisplayed(testData.getExpectedResult()[6]),
				"Link New Solution heading  is not displayed currenctly");

		// Verify that Solution ID text box filed is displayed
		assertTrue(isgRecommendedSolutionsSectionPage.hasSolutionIDTextBoxDisplayed(),
				"Solution ID text box filed is not displayed");

		// Verify that Search Icon is displayed
		assertTrue(isgRecommendedSolutionsSectionPage.hasSearchIconDisplayed(), "Search Icon filed is not displayed");

		// Verify that Languages is displayed
		assertTrue(isgRecommendedSolutionsSectionPage.hasLanguageForLinkNewSolutionDisplayed(
				testData.getExpectedResult()[7]), "Languages Label  is not displayed");

		/*
		 * // Verify that ID is displayed assertTrue(isgRecommendedSolutionsSectionPage.
		 * hasIDForLinkNewSolutionDisplayed(testData.getExpectedResult()[8]),
		 * "ID Label is not displayed");
		 */

		// Verify that Description is displayed
		assertTrue(isgRecommendedSolutionsSectionPage.hasDescriptionForLinkNewSolutionDisplayed(
				testData.getExpectedResult()[8]), "Description Label  is not displayed");

		// Verify that Link is displayed
		assertTrue(isgRecommendedSolutionsSectionPage.hasLinkDisplayed(testData.getExpectedResult()[9]),
				"Link Label  is not displayed");

		// Do a blank search of Solution ID
		isgRecommendedSolutionsSectionPage = functionalMethods
				.clickOnSearchForSolutionIdField(isgRecommendedSolutionsSectionPage);

		// Verify validation Message appears
		assertTrue(isgRecommendedSolutionsSectionPage.hasValidationMesgDisplayed(testData.getExpectedResult()[10]),
				"No published solution was found for or the solution is for internal view only and cannot be linked to the case.");

		// In Solution ID search field, enter a valid solution ID and Click on search of
		// Solution ID
		isgRecommendedSolutionsSectionPage = functionalMethods.enterSoluIdClickSecrh(isgRecommendedSolutionsSectionPage,
				testData.getTestdata()[4]);

		// verify solution will be automatically added to the case.
		assertTrue(isgRecommendedSolutionsSectionPage.hasSolutionIDDisplayed(testData.getExpectedResult()[11]),
				"72904 Id Number Not Showing under Recommended Solutions");

		// In Solution ID search field, enter a valid solution ID
		isgRecommendedSolutionsSectionPage = functionalMethods.enterSoluId(isgRecommendedSolutionsSectionPage,
				testData.getTestdata()[4]);

		// Click on search of Solution ID
		isgRecommendedSolutionsSectionPage = functionalMethods
				.clickOnSearchForSolutionIdField(isgRecommendedSolutionsSectionPage);

		// Verify validation Message appears
		assertTrue(isgRecommendedSolutionsSectionPage.hasValidationMessageDisplayed(testData.getExpectedResult()[12]),
				"Solution already added not showing");

		// In Solution ID search field, enter a valid solution ID and Click on search of
		// Solution ID
		isgRecommendedSolutionsSectionPage = functionalMethods.enterSoluIdClickSecrh(isgRecommendedSolutionsSectionPage,
				testData.getTestdata()[5]);

		// verify Language is showing as English
		assertTrue(isgRecommendedSolutionsSectionPage.hasLanguageNameDisplayed(testData.getExpectedResult()[13]),
				"English is not Showing under Recommended Solutions");

		// verify solution ID showing
		assertTrue(isgRecommendedSolutionsSectionPage.hasSolutionIDRecomdedDisplayed(testData.getExpectedResult()[14]),
				"1234 Id Number Not Showing under Recommended Solutions");

		// verify solution Description showing
		assertTrue(isgRecommendedSolutionsSectionPage.hasSolutionDescriptionDisplayed(testData.getExpectedResult()[15]),
				"1234-HBI-AX-1345 APR 21 1989 610 SEEDING TOOL WITH 8 INCH SPACING THROWS TOO MUCH DIRT OVER SEED-Jan 11 2001");

		// verify Delete Icon showing
		assertTrue(isgRecommendedSolutionsSectionPage.hasDeleteIconDisplayed(),
				"Delete Icon not Showing under Recommended Solutions");

		// Click on ID
		isgRecommendedSolutionsSectionPage = functionalMethods
				.clickOnSolutionIdLink(isgRecommendedSolutionsSectionPage);

		// verify Solution Number is showing
		assertTrue(isgRecommendedSolutionsSectionPage.hasSolutionNumberDisplayed(testData.getExpectedResult()[14]),
				"Solution Number is not displaying");

		// verify Solution Summary is showing
		assertTrue(isgRecommendedSolutionsSectionPage.hasSolutionSummaryDisplayed(testData.getExpectedResult()[15]),
				"Solution Summary is not  displaying ");

		// verify Publication Date is showing
		assertTrue(isgRecommendedSolutionsSectionPage.hasPublicationDateDisplayed(testData.getExpectedResult()[16]),
				"Publication Date is not displaying");

	}

	/**
	 * Author : Lahari Pasupuleti Description : As a TSS, I want to access and
	 * search cases and solutions in CCMS system so that I can utilize exiting
	 * information available in CCMS information available in CCMS
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */

	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6877_LinkNewSolutionssection_Negative(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;
		HomePage homePage;
		ISGRecommendedSolutionsSectionPage isgRecommendedSolutionsSectionPage;

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

		// Verify that if Home Page is displayed
		assertTrue(homePage.hasHomePageDisplayed(), "Navigation to Home Page Page was Unsuccessful");

		// Navigate to ISGRecommendedSolutionsSectionPage and Click on ISG Case creation
		// Button
		isgRecommendedSolutionsSectionPage = functionalMethods.navToISGCaseCreatClkISGBtn(homePage);

		// Verify that if ISG case Creation Page is displayed
		assertTrue(
				isgRecommendedSolutionsSectionPage.hasISGCaseCreationHomePageDisplayed(testData.getExpectedResult()[1]),
				"Navigation to ISG Case Creation Page was Unsuccessful");

		// Verify that Recommended Solutions section is displayed
		assertTrue(isgRecommendedSolutionsSectionPage.hasRecommendedSolutionsDisplayed(testData.getExpectedResult()[2]),
				"Recommended Solutions  section heading  is not displayed correctly");

		// Verify that Languages is displayed
		assertTrue(isgRecommendedSolutionsSectionPage.hasLanguagesDisplayed(testData.getExpectedResult()[3]),
				"Languages Label  is not displayed currenctly");

		// Verify that ID is displayed
		assertTrue(isgRecommendedSolutionsSectionPage.hasIDDisplayed(testData.getExpectedResult()[4]),
				"ID Label  is not displayed currenctly");

		// Verify that Description is displayed
		assertTrue(isgRecommendedSolutionsSectionPage.hasDescriptionDisplayed(testData.getExpectedResult()[5]),
				"Description Label  is not displayed currenctly");

		// Verify that Link New Solution is displayed
		assertTrue(isgRecommendedSolutionsSectionPage.hasLinkNewSolutionDisplayed(testData.getExpectedResult()[6]),
				"Link New Solution heading  is not displayed currenctly");

		// Verify that Solution ID text box filed is displayed
		assertTrue(isgRecommendedSolutionsSectionPage.hasSolutionIDTextBoxDisplayed(),
				"Solution ID text box filed is not displayed");

		// Verify that Search Icon is displayed
		assertTrue(isgRecommendedSolutionsSectionPage.hasSearchIconDisplayed(), "Search Icon filed is not displayed");

		// Verify that Languages is displayed
		assertTrue(isgRecommendedSolutionsSectionPage.hasLanguageForLinkNewSolutionDisplayed(
				testData.getExpectedResult()[7]), "Languages Label  is not displayed");

		/*
		 * // Verify that ID is displayed assertTrue(isgRecommendedSolutionsSectionPage.
		 * hasIDForLinkNewSolutionDisplayed(testData.getExpectedResult()[8]),
		 * "ID Label is not displayed");
		 */

		// Verify that Description is displayed
		assertTrue(isgRecommendedSolutionsSectionPage.hasDescriptionForLinkNewSolutionDisplayed(
				testData.getExpectedResult()[8]), "Description Label  is not displayed");

		// Verify that Link is displayed
		assertTrue(isgRecommendedSolutionsSectionPage.hasLinkDisplayed(testData.getExpectedResult()[9]),
				"Link Label  is not displayed");

		// Do a blank search of Solution ID
		isgRecommendedSolutionsSectionPage = functionalMethods
				.clickOnSearchForSolutionIdField(isgRecommendedSolutionsSectionPage);

		// Verify validation Message appears
		assertTrue(isgRecommendedSolutionsSectionPage.hasValidationMesgDisplayed(testData.getExpectedResult()[10]),
				"No published solution was found for or the solution is for internal view only and cannot be linked to the case.");

		// In Solution ID search field, enter a valid solution ID and Click on search of
		// Solution ID
		isgRecommendedSolutionsSectionPage = functionalMethods.enterSoluIdClickSecrh(isgRecommendedSolutionsSectionPage,
				testData.getTestdata()[4]);

		// verify solution will be automatically added to the case.
		assertTrue(isgRecommendedSolutionsSectionPage.hasSolutionIDDisplayed(testData.getExpectedResult()[11]),
				"72904 Id Number Not Showing under Recommended Solutions");

		// In Solution ID search field, enter a valid solution ID
		isgRecommendedSolutionsSectionPage = functionalMethods.enterSoluId(isgRecommendedSolutionsSectionPage,
				testData.getTestdata()[4]);

		// Click on search of Solution ID
		isgRecommendedSolutionsSectionPage = functionalMethods
				.clickOnSearchForSolutionIdField(isgRecommendedSolutionsSectionPage);

		// Verify validation Message appears
		assertTrue(isgRecommendedSolutionsSectionPage.hasValidationMessageDisplayed(testData.getExpectedResult()[12]),
				"Solution already added not showing");

		// In Solution ID search field, enter a valid solution ID and Click on search of
		// Solution ID
		isgRecommendedSolutionsSectionPage = functionalMethods.enterSoluIdClickSecrh(isgRecommendedSolutionsSectionPage,
				testData.getTestdata()[5]);

		// Validate Language field .
		assertTrue(isgRecommendedSolutionsSectionPage.hasLanguageNameDisplayed(testData.getExpectedResult()[13]),
				"English is not Showing under Recommended Solutions");

		// Validate solution ID textfield.
		assertTrue(isgRecommendedSolutionsSectionPage.hasSolutionIDRecomdedDisplayed(testData.getExpectedResult()[14]),
				"1234 Id Number Not Showing under Recommended Solutions");

		// Validate solution Description field
		assertTrue(isgRecommendedSolutionsSectionPage.hasSolutionDescriptionDisplayed(testData.getExpectedResult()[15]),
				"1234-HBI-AX-1345 APR 21 1989 610 SEEDING TOOL WITH 8 INCH SPACING THROWS TOO MUCH DIRT OVER SEED-Jan 11 2001");

		// Validate Delete Icon
		assertTrue(isgRecommendedSolutionsSectionPage.hasDeleteIconDisplayed(),
				"Delete Icon not Showing under Recommended Solutions");

		// Click on ID
		isgRecommendedSolutionsSectionPage = functionalMethods
				.clickOnSolutionIdLink(isgRecommendedSolutionsSectionPage);

		// Validate Solution Number field
		assertTrue(isgRecommendedSolutionsSectionPage.hasSolutionNumberDisplayed(testData.getExpectedResult()[14]),
				"Solution Number is not displaying correctly");

		// Validate Solution Summary field
		assertTrue(isgRecommendedSolutionsSectionPage.hasSolutionSummaryDisplayed(testData.getExpectedResult()[15]),
				"Solution Summary is not  displaying correctly ");

		// Validate Publication Date field
		assertTrue(isgRecommendedSolutionsSectionPage.hasPublicationDateDisplayed(testData.getExpectedResult()[16]),
				"Publication Date is not displaying correctly");

	}

	/**
	 * Author : Lahari Pasupuleti Description : As a TSS for ISG, I want to route
	 * cases to respective workbaskets as per details mentioned in attached
	 * worksheet, based on product selected in case so that respective workgroups ca
	 * work on it.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */
	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6486_RoutingForISG(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		ISGCasePage isgCasePage;
		NavigationClass navigationClass;
		WorkGroupQueuePage workGroupQueuePage;
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

		// Navigate to HomePage
		homePage = functionalMethods.navigateToHomePage(navigationClass);

		// Verify that if Home Page is displayed
		assertTrue(homePage.hasHomePageDisplayed(), "Navigation to Home Page  was Unsuccessful");

		// Click on Create ISG Case
		isgCasePage = functionalMethods.navigateToCreateISGCaseHome(homePage);

		// Verify that CreateISGCasePage is displayed
		assertTrue(isgCasePage.hasCreateISGCaseDisplayed(testData.getExpectedResult()[1]),
				"Navigation to CreateISGCasePage was Unsuccessful");

		/*
		 * // Enter ISG Case creation Customer Details isgCasePage =
		 * functionalMethods.enterIsgCustInfoDet(isgCasePage, testData.getTestdata()[4],
		 * testData.getTestdata()[5], testData.getTestdata()[6]);
		 */

		// Entered ISG case creation details and click on Accept button
		// isgCasePage = functionalMethods.enterIsgCustInfoDet(isgCasePage,
		// testData.getTestdata()[4],
		// testData.getTestdata()[5], testData.getTestdata()[6]);

	/*	isgCasePage = functionalMethods.isgEnterCaseCreationDetailsForRouting(isgCasePage, testData.getTestdata()[4],
				testData.getTestdata()[5], testData.getTestdata()[6]);*/
	// Entered ISG case creation details and click on Accept button
				isgCasePage = functionalMethods.isgEnterCaseCreationDetailsRouting(isgCasePage, testData.getTestdata()[4],
						testData.getTestdata()[5], testData.getTestdata()[6]);

		// Verify Model Header is displayed
		assertTrue(isgCasePage.isModelHeaderDisplayed(testData.getExpectedResult()[2]),
				"Model Header not displayed correctly");

		// Verify Usage Header is displayed
		assertTrue(isgCasePage.isUsageHeaderDisplayed(testData.getExpectedResult()[3]),
				"Usage Header not displayed correctly");

		// Verify Units Header is displayed
		assertTrue(isgCasePage.isUnitsHeaderDisplayed(testData.getExpectedResult()[4]),
				"Units Header not displayed correctly");

		// Verify Pin Header is displayed
		assertTrue(isgCasePage.isPinHeaderDisplayed(testData.getExpectedResult()[5]),
				"Pin Header not displayed correctly");

		// Verify Part Number Header is displayed
		assertTrue(isgCasePage.isPartNumHeaderDisplayed(testData.getExpectedResult()[6]),
				"Part Number Header not displayed correctly");

		// Verify Component Number Header is displayed
		assertTrue(isgCasePage.isComponentHeaderDisplayed(testData.getExpectedResult()[7]),
				"Component Serial Number Header not displayed correctly");

		// Click on Add Product Info and Enter model details for Product Info
		isgCasePage = functionalMethods.clickAddProductInfoEnterModelDetail(isgCasePage, testData.getTestdata()[7]);

		// Verify after click on Submit for Add Product Info it closes the modal pop
		// screen or not and validate the screen heading
		assertTrue(isgCasePage.hasProductHeadingDisplayed(testData.getExpectedResult()[8]),
				"Product Heading is not displayed");

		// Enter ISG Case creation all mandatory fields
		isgCasePage = functionalMethods.enterISGCASeMandatoryDetaislClikAccept(isgCasePage, testData.getTestdata()[8],
				testData.getTestdata()[9], testData.getTestdata()[10], testData.getTestdata()[11],
				testData.getTestdata()[12]);

		// Navigate to Home Page
		workGroupQueuePage = functionalMethods.NavToWorkBasketQueuePageClkWQ(isgCasePage);

		// Click on filters Enter case Id data into case id text filed and click on
		// submit
		workGroupQueuePage = functionalMethods.clkFilterEnterCaseData(workGroupQueuePage,
				testData.getExpectedResult()[9]);

	}

	/**
	 * Author : Lahari Pasupuleti Description : As TSS user I should have the
	 * ability to Link solutions to ISG cases.
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
	public static void test_TC6805_LinkSolutionsTotheCasefromSolutionScreen(
			InputEnvironmentDetails inputEnvironmentDetails, InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;
		ISGLinkSolutionPage isgLinkSolutionPage;

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
		isgLinkSolutionPage = functionalMethods.navToISGLinkSolutionPageClkHome(navigationClass);

		// Validating if Home is displayed
		assertTrue(isgLinkSolutionPage.hasHomePageDisplayed(), "Navigation to Home Page is Unsuccessful");

		// Click on WorkgroupQueue
		isgLinkSolutionPage = functionalMethods.clickWorkBasketQueue(isgLinkSolutionPage);

		// Verify WorkGroup queue grid showing
		assertTrue(isgLinkSolutionPage.hasWorkGroupQueueGridDisplayed(), " Workgroup queue grid is not displayed");

		// Click to open 5 ISG cases and Click on Solutions Search and click on search
		isgLinkSolutionPage = functionalMethods.clickISGCases(isgLinkSolutionPage);

		// Verify list of Solutions is presented under the search fields
		assertTrue(isgLinkSolutionPage.hasListOfSolutionsDisplayed(), "list of Solutions  is not showing");

		// Choose a Solution and click on Link to Case (link) next to it.
		isgLinkSolutionPage = functionalMethods.clickLinkSolution(isgLinkSolutionPage);

		// // Validate solution ID textfield.
		// assertTrue(isgRecommendedSolutionsSectionPage.hasSolutionIDRecomdedDisplayed(testData.getExpectedResult()[14]),
		// "1234 Id Number Not Showing under Recommended Solutions");
		//
		// // Validate solution Description field
		// assertTrue(isgRecommendedSolutionsSectionPage.hasSolutionDescriptionDisplayed(testData.getExpectedResult()[15]),
		// "1234-HBI-AX-1345 APR 21 1989 610 SEEDING TOOL WITH 8 INCH SPACING THROWS TOO
		// MUCH DIRT OVER SEED-Jan 11 2001");

	}

	/**
	 * Author : Lahari Pasupuleti Description : As a TSS for ISG, I want to route
	 * cases to respective workbaskets as per details mentioned in attached
	 * worksheet, based on product selected in case so that respective workgroups ca
	 * work on it.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */
	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6806_LinkSolutionsToCaseWithDifferentLanguage(
			InputEnvironmentDetails inputEnvironmentDetails, InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		ISGCasePage isgCasePage;
		NavigationClass navigationClass;
		ISGLinkSolutionPage isgLinkSolutionPage;
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
				"Navigation to landing page  was Unsuccessful");

		// Navigate to Home page
		homePage = functionalMethods.navigateHomePage(navigationClass);

		// Verify that Landing of home Page is displayed
		assertTrue(homePage.isHomePageDisplayed(testData.getExpectedResult()[1]),
				"Navigation to Home page was Unsuccessful");

		// Navigate to ISG case Creation page.
		isgCasePage = functionalMethods.navToISGCasePage(homePage);

		// Verify that ISG Page is displayed
		assertTrue(isgCasePage.hasCreateISGCasePageDisplayed(testData.getExpectedResult()[2]),
				"Navigation to Create ISG Case Page was Unsuccessful");

		// Entered ISG case creation details and click on Accept button
		isgCasePage = functionalMethods.isgEnterCaseCreationDetails(isgCasePage, testData.getTestdata()[4],
				testData.getTestdata()[5], testData.getTestdata()[6], testData.getTestdata()[7],
				testData.getTestdata()[8], testData.getTestdata()[9], testData.getTestdata()[10],
				testData.getTestdata()[11], testData.getTestdata()[12]);

		// Verify Correct Customer Details is showing
		//assertTrue(isgCasePage.hasCustomerDetailsDisplayedInMainPage(), "Correct Customer details are not displayed");

		// Navigate to Solutions Search
		isgLinkSolutionPage = functionalMethods.navigateToSolutionsSearchSwitchTOFrame(isgCasePage);

		// Verify Search Button is showing
		assertTrue(isgLinkSolutionPage.hasSearchBtnDisplayed(), "Search Button are not displayed");

		// Select solution language, Click on Search Button and click on link to case
		isgLinkSolutionPage = functionalMethods.sltLangClickSrhBtnAndLnkSol(isgLinkSolutionPage);

		// Verify Link Solution in Same Language PopUp is showing
		assertTrue(isgLinkSolutionPage.hasLinkSolPopHeaderDisplayed(),
				"Link Solution in Same Language PopUp not displayed correctly");

		// Verify Link Same Language PopUp Message is showing
		assertTrue(isgLinkSolutionPage.hasLinkSameLangPopUpMsgDisplayed(),
				"Link Same Language PopUp Message not displayed correctly");

		// Click on Next Button and click on link to case
		isgLinkSolutionPage = functionalMethods.clickNxtBtn(isgLinkSolutionPage);

		// Verify Link Other Language PopUp Message is showing
		assertTrue(isgLinkSolutionPage.hasLinkOthrLangPopUpMsgDisplayed(),
				"Link Other Language PopUp Message not displayed correctly");

		// Click on Case Dropdown in Link solution
		isgLinkSolutionPage = functionalMethods.clickCaseIDDrpdwn(isgLinkSolutionPage);

		// Verify Recommended Solutions Header In Link Solution is showing
		assertTrue(isgLinkSolutionPage.hasRecmmdSolInLnkSolDisplayed(),
				"Recommended Solutions Header In Link Solution not displayed correctly");

		// Verify Recommended Solutions language In Link Solution is showing
		assertTrue(isgLinkSolutionPage.hasRecmmdSolLangInLnkSolDisplayed(),
				"Recommended Solutions language In Link Solution not displayed correctly");

		// Verify Recommended Solutions ID In Link Solution is showing
		assertTrue(isgLinkSolutionPage.hasRecmmdSolIDInLnkSolDisplayed(),
				"Recommended Solutions ID In Link Solution not displayed correctly");

		// Verify Recommended Solutions Description In Link Solution is showing
		assertTrue(isgLinkSolutionPage.hasRecmmdSolDescInLnkSolDisplayed(),
				"Recommended Solutions Description In Link Solution not displayed correctly");

		// Verify Link New Solution Header In Link Solution is showing
		assertTrue(isgLinkSolutionPage.hasLinkNewSolInLnkSolDisplayed(),
				"Link New Solution Header In Link Solution not displayed correctly");

		// Verify Link New Solution language In Link Solution is showing
		assertTrue(isgLinkSolutionPage.hasLinkNewSolLangInLnkSolDisplayed(),
				"Link New Solution language In Link Solution not displayed correctly");

		// Verify Link New Solution ID In Link Solution is showing
		assertTrue(isgLinkSolutionPage.hasLinkNewSolIDInLnkSolDisplayed(),
				"Link New Solution ID In Link Solution not displayed correctly");

		// Verify Link New Solution Description In Link Solution is showing
		assertTrue(isgLinkSolutionPage.hasLinkNewSolDescInLnkSolDisplayed(),
				"Link New Solution Description In Link Solution not displayed correctly");

		// Verify Link New Solution Link In Link Solution is showing
		assertTrue(isgLinkSolutionPage.hasLinkNewSolLinkInLnkSolDisplayed(),
				"Link New Solution Link In Link Solution not displayed correctly");

		// Click on Link Button Click Finish And Click Case Tab
		isgLinkSolutionPage = functionalMethods.clickLnkBtnClkFinshAndClkCseTab(isgLinkSolutionPage);

		// Verify Linked Solution ID in ISG case is showing
		assertTrue(isgLinkSolutionPage.hasValidateLinkedSolIDInISGCaseDisplayed(),
				"Linked Solution ID in ISG case not displayed correctly");

	}

	/*
	 * Author : Lahari Pasupuleti Description : As a TSS for ISG, I want to route
	 * cases to respective workbaskets as per details mentioned in attached
	 * worksheet, based on product selected in case so that respective workgroups ca
	 * work on it.
	 * 
	 * @param testData
	 * 
	 * @param environmentDetails
	 * 
	 * @param inputBrowserDetails
	 * 
	 * @param driver
	 * 
	 * @return
	 * 
	 * @throws Throwable
	 */
	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6813_LinkSolutionFromSolutionsAction(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;
		ISGLinkSolutionPage isgLinkSolutionPage;

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
		isgLinkSolutionPage = functionalMethods.navToISGLinkSolutionPageClkHome(navigationClass);

		// Validating if Home is displayed
		assertTrue(isgLinkSolutionPage.hasHomePageDisplayed(), "Navigation to Home Page is Unsuccessful");

		// Click on WorkgroupQueue
		isgLinkSolutionPage = functionalMethods.clickWorkBasketQueue(isgLinkSolutionPage);

		// Verify WorkGroup queue grid showing
		assertTrue(isgLinkSolutionPage.hasWorkGroupQueueGridDisplayed(), " Workgroup queue grid is not showing");

		// Click to open 5 ISG cases and Click on Solutions Search and click on search
		isgLinkSolutionPage = functionalMethods.clickISGCases(isgLinkSolutionPage);

		// Verify list of Solutions is presented under the search fields
		assertTrue(isgLinkSolutionPage.hasListOfSolutionsDisplayed(), "list of Solutions  is not showing");

		// Choose a Solution and click on Link to Case (link) next to it.
		isgLinkSolutionPage = functionalMethods.clickLinkSolution(isgLinkSolutionPage);

		// Link Solution in Same Language pop-up is opened. It contains a list of 5
		// recently opened Cases with checkBox, case ID and Summary.
		// assertTrue(isgLinkSolutionPage.hasLinkSolutionInSameLanguagePopUpDisplayed(testData.getExpectedResult()[1]),
		// "Link Solution in Same Language Pop UP is not showing");

		// Choose a Solution and click on Link to Case (link) next to it.
		isgLinkSolutionPage = functionalMethods.selectLinkSolution(isgLinkSolutionPage);

		// Compare a list of 5 recently opened Cases with checkBox, case ID and Summary
		// and Check the checkBox next to case ID that you want to attach the Solution
		isgLinkSolutionPage = functionalMethods.CompareAndCheckCheckBoxForCaseId(isgLinkSolutionPage);

		// Open the case that you choose to attach the solution
		isgLinkSolutionPage = functionalMethods.openCaseIdOfChooseSolution(isgLinkSolutionPage);

		// Verify that Recommended Solutions
		assertTrue(isgLinkSolutionPage.hasRecommendedSolutionsDisplayed(testData.getExpectedResult()[3]),
				" Recommended Solutions is not displying");

		// Verify that The Solution is presented in Recommended Solutions grid.
		assertTrue(isgLinkSolutionPage.hasSolutionsDisplayed(), "  Solutions is not displying");

		// Click on Solutions Search and click on search
		isgLinkSolutionPage = functionalMethods.clickSolutionSearch(isgLinkSolutionPage);

		// Verify list of Solutions is presented under the search fields
		assertTrue(isgLinkSolutionPage.hasListOfSolutionsDisplayed(), "list of Solutions  is not showing");

		// Choose a Solution and click on Link to Case (link) next to it.
		isgLinkSolutionPage = functionalMethods.clickLinkSolution(isgLinkSolutionPage);

		// Link Solution in Same Language pop-up is opened. It contains a list of 5
		// recently opened Cases with checkBox, case ID and Summary.
		assertTrue(isgLinkSolutionPage.hasLinkSolutionInSameLanguagePopUpDisplayed(testData.getExpectedResult()[1]),
				"Link Solution in Same Language Pop UP is not showing");

		// Choose a Solution and click on Link to Case (link) next to it.
		isgLinkSolutionPage = functionalMethods.selectLinkSolution(isgLinkSolutionPage);

		// Compare a list of 5 recently opened Cases with checkBox, case ID and Summary
		// and Check the checkBox next to case ID that you want to attach the Solution
		isgLinkSolutionPage = functionalMethods.CompareAndCheckCheckBoxForCaseId(isgLinkSolutionPage);

		// Open the case that you choose to attach the solution
		isgLinkSolutionPage = functionalMethods.openCaseIdOfChooseSolution(isgLinkSolutionPage);

		// Verify that Recommended Solutions
		assertTrue(isgLinkSolutionPage.hasRecommendedSolutionsDisplayed(testData.getExpectedResult()[3]),
				" Recommended Solutions is not displying");

		// Verify that The Solution is presented in Recommended Solutions grid.
		assertTrue(isgLinkSolutionPage.hasSolutionsDisplayed(), "  Solutions is not displying");
	}

	/**
	 * Author : Aparajita Pattanaik Description :Create ISG case and tansfer the
	 * case to individual/transfer and transfer the case to Workbasket and validate
	 * the status of the case.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */

	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6441_ISGTransferToWBIndividual(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		ISGCasePage isgCasePage;
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

		// Navigate to HomePage
		homePage = functionalMethods.navigateToHomePage(navigationClass);

		// Verify that if Home Page is displayed
		assertTrue(homePage.hasHomePageDisplayed(), "Navigation to Home Page Page was Unsuccessful");

		// Click on Create ISG Case
		isgCasePage = functionalMethods.navigateToCreateISGCaseHome(homePage);

		// Verify that Landing Page is displayed
		assertTrue(isgCasePage.hasCreateISGCaseDisplayed(testData.getExpectedResult()[2]),
				"Navigation to Create ISG Case was Unsuccessful");

		// Enter case details for ISG case creation and click on accept button
		isgCasePage = functionalMethods.isgEnterCaseCreationDetails(isgCasePage, testData.getTestdata()[4],
				testData.getTestdata()[5], testData.getTestdata()[6], testData.getTestdata()[7],
				testData.getTestdata()[8], testData.getTestdata()[9], testData.getTestdata()[10],
				testData.getTestdata()[11], testData.getTestdata()[12]);

		// Validate owned status.
		assertTrue(isgCasePage.isStatusOwned(), "Status owned is not displayed successfully");

		// click on Actions, Transfer to Individual details and expand audit history.
		isgCasePage = functionalMethods.isgClkActionsBtnSelectIndividualClkAudit(isgCasePage,
				testData.getTestdata()[13], testData.getTestdata()[14]);

		// Validate Audit

		// click on case close button
		isgCasePage = functionalMethods.clickOnCaseCloseBtn(isgCasePage);

		// Navigate to ISG page.
		isgCasePage = functionalMethods.navToISGCasePageTranToWB(homePage);

		// Verify that ISG Page is displayed
		assertTrue(isgCasePage.hasCreateISGCasePageDisplayed(testData.getExpectedResult()[2]),
				"Navigation to Create ISG Case Page was Unsuccessful");

		// // Enter case details for ISG case creation and click on accept button
		isgCasePage = functionalMethods.isgEnterCaseCreationDetails(isgCasePage, testData.getTestdata()[4],
				testData.getTestdata()[5], testData.getTestdata()[6], testData.getTestdata()[7],
				testData.getTestdata()[8], testData.getTestdata()[9], testData.getTestdata()[10],
				testData.getTestdata()[11], testData.getTestdata()[12]);

		// Validate owned status.
		assertTrue(isgCasePage.isOwnedStatusDisplayed(testData.getExpectedResult()[3]),
				"Status owned is not displayed successfully");

		// click on Actions and select transfer case to workbasket and click on submit
		// button
		isgCasePage = functionalMethods.isgClkActionsTrToWBAudtButton(isgCasePage, testData.getTestdata()[15]);

		// Validate Audit History.

		// click on case close button
		isgCasePage = functionalMethods.clickOnCaseCloseBtn(isgCasePage);

		// Navigate to ISG page.
		isgCasePage = functionalMethods.navToISGCasePage(homePage);

		// Verify that ISG Page is displayed
		assertTrue(isgCasePage.hasCreateISGCasePageDisplayed(testData.getExpectedResult()[2]),
				"Navigation to Create ISG Case Page was Unsuccessful");

		// // Enter case details for ISG case creation
		isgCasePage = functionalMethods.isgEnterCaseCreationDetails(isgCasePage, testData.getTestdata()[4],
				testData.getTestdata()[5], testData.getTestdata()[6], testData.getTestdata()[7],
				testData.getTestdata()[8], testData.getTestdata()[9], testData.getTestdata()[10],
				testData.getTestdata()[11], testData.getTestdata()[12]);

		// Validate owned status.
		assertTrue(isgCasePage.isOwnedStatusDisplayed(testData.getExpectedResult()[3]),
				"Status owned is not displayed successfully");

		// Click on close button.
		isgCasePage = functionalMethods.clickOnCloseBtn(isgCasePage);

		// Validate Resolved completed status.
		assertTrue(isgCasePage.hasResolvedCompletedStatusDisplayed(testData.getExpectedResult()[4]),
				"Resolved completed status is not displayed successfully");

	}

	/**
	 * Author : Aparajita Pattanaik Description :Create ISG case and verifying the
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
	public static void test_TC6586_ISG_Buttons(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;
		ISGCasePage isgCasePage;
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
				"Navigation to landing page  was Unsuccessful");

		// Navigate to Home page
		homePage = functionalMethods.navigateHomePage(navigationClass);

		// Verify that Landing of home Page is displayed
		assertTrue(homePage.isHomePageDisplayed(testData.getExpectedResult()[1]),
				"Navigation to Home page was Unsuccessful");

		// Navigate to ISG case Creation page.
		isgCasePage = functionalMethods.navToISGCasePage(homePage);

		// Verify that ISG Page is displayed
		assertTrue(isgCasePage.hasCreateISGCasePageDisplayed(testData.getExpectedResult()[2]),
				"Navigation to Create ISG Case Page was Unsuccessful");

		// Validate for NewDraft status.
		assertTrue(isgCasePage.hasNewDraftStatusDisplayed(testData.getExpectedResult()[3]),
				"NewDraft status is not displayed successfully");

		// Validate for Accept button
		assertTrue(isgCasePage.hasAcceptBtnDisplayed(testData.getExpectedResult()[4]),
				"Accept button is not displayed successfully");

		// Validate for Accept and close button
		assertTrue(isgCasePage.hasAcceptAndCloseButtonDisplayed(testData.getExpectedResult()[5]),
				"Accept & Close button is not displayed successfully");

		// Validate for Save button
		assertTrue(isgCasePage.hasSaveBtnDisplayed(), "Save button is not displayed successfully");

		// Entered ISG case creation details and click on Accept button
		isgCasePage = functionalMethods.isgEnterCaseCreationDetails(isgCasePage, testData.getTestdata()[4],
				testData.getTestdata()[5], testData.getTestdata()[6], testData.getTestdata()[7],
				testData.getTestdata()[8], testData.getTestdata()[9], testData.getTestdata()[10],
				testData.getTestdata()[11], testData.getTestdata()[12]);

		// Validate owned status.
		assertTrue(isgCasePage.isOwnedStatusDisplayed(testData.getExpectedResult()[7]),
				"Owned status is not displayed successfully");

		// Validate for Cancel button
		assertTrue(isgCasePage.hasCancelBtnDisplayed(testData.getExpectedResult()[8]),
				"Cancel button is not displayed successfully");

		// Validate for Close button
		assertTrue(isgCasePage.hasCloseBtnDisplayed(testData.getExpectedResult()[9]),
				"Close button is not displayed successfully");

		// Validate for Save button
		assertTrue(isgCasePage.hasSaveBtnDisplayed(), "Save button is not displayed successfully");

		// Click on close button
		isgCasePage = functionalMethods.clickOnCloseBtn(isgCasePage);

		// Validate for Resolved Completed status
		assertTrue(isgCasePage.hasResolvedCompletedStatusDisplayed(testData.getExpectedResult()[11]),
				"Resolved compleetd status is not displayed successfully");

		// Click on Action and select Reopen option
		isgCasePage = functionalMethods.clickActionBtnSelectReopenOption(isgCasePage);

		// Validate for Reopened status
		// assertTrue(isgCasePage.hasReopenStatusDisplayed(testData.getExpectedResult()[12]),
		// "Reopen status is not displayed successfully");

		// Click on Action->,TSS reopen-> workCase
		isgCasePage = functionalMethods.selectWorkCaseFrmAction(isgCasePage);

		// Validate for Accept button
		assertTrue(isgCasePage.hasAcceptBtnDisplayed(testData.getExpectedResult()[13]),
				"Accept button is not displayed successfully");

		// Validate for save button
		assertTrue(isgCasePage.hasSaveBtnDisplayed(), "Save button is not displayed successfully");

		// Validate for cancel button
		assertTrue(isgCasePage.hasCancelBtnDisplayed(testData.getExpectedResult()[15]),
				"Cancel button is not displayed successfully");

		// Click on close button
		isgCasePage = functionalMethods.clickOnCancelButton(isgCasePage);

	}

	/**
	 * Author : Aparajita Pattanaik Description : Verify action button dropdown for
	 * each and every status of ISG case.
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */
	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6482_TestActions(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;
		ISGCasePage isgCasePage;
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
				"Navigation to landing page  was Unsuccessful");

		// Navigate to Home page
		homePage = functionalMethods.navigateToHomePage(navigationClass);

		// Verify that Landing of home Page is displayed
		assertTrue(homePage.isHomePageDisplayed(testData.getExpectedResult()[1]),
				"Navigation to Home page was Unsuccessful");

		// Navigate to ISG page.
		isgCasePage = functionalMethods.navToISGCasePage(homePage);

		// Verify that ISG Page is displayed
		assertTrue(isgCasePage.hasCreateISGCasePageDisplayed(testData.getExpectedResult()[2]),
				"Navigation to Create ISG Case Page was Unsuccessful");

		// Validate for NewDraft status
		assertTrue(isgCasePage.hasNewDraftStatusDisplayed(testData.getExpectedResult()[3]),
				"NewDraft status is not displayed successfully");

		// Click on Actions button
		isgCasePage = functionalMethods.isgActionsButton(isgCasePage);

		// Validate for Refresh button
		assertTrue(isgCasePage.hasRefreshOptionDisplayed(testData.getExpectedResult()[4]),
				"Refresh option is not displayed successfully");

		// Validate for Print button
		assertTrue(isgCasePage.hasPrintOptionDisplayed(testData.getExpectedResult()[5]),
				"Print option is not displayed successfully ");

		// Enter Customer details for ISG case and click on accept button.
		isgCasePage = functionalMethods.isgEnterCaseCreationDetails(isgCasePage, testData.getTestdata()[4],
				testData.getTestdata()[5], testData.getTestdata()[6], testData.getTestdata()[7],
				testData.getTestdata()[8], testData.getTestdata()[9], testData.getTestdata()[10],
				testData.getTestdata()[11], testData.getTestdata()[12]);

		// Validate the Owned status
		assertTrue(isgCasePage.isOwnedStatusDisplayed(testData.getExpectedResult()[6]),
				"Owned status is not displayed successfully");

		// Click on Actions button
		isgCasePage = functionalMethods.isgActionsButton(isgCasePage);

		// Validate Refresh option
		assertTrue(isgCasePage.hasRefreshOptionDisplayed(testData.getExpectedResult()[7]),
				"Refresh option is not displayed successfully ");

		// Validate Print option
		assertTrue(isgCasePage.hasPrintOptionDisplayed(testData.getExpectedResult()[8]),
				"Print option is not displayed ");

		// Validate for Transfer case to WB option Option
		assertTrue(isgCasePage.hasTransferCaseToWBOptionDisplayed(testData.getExpectedResult()[9]),
				"Transfer Case To WB option is not  displayed successfully");

		// Validate for Transfer case to Individual button Option
		assertTrue(isgCasePage.hasTransferIndividuOptionDisplayed(testData.getExpectedResult()[10]),
				"Transfer Case To Individual option is not  displayed successfully");

		// Validate for send case email button.
		assertTrue(isgCasePage.hasSendCaseEmailOptionDisplayed(testData.getExpectedResult()[11]),
				"Send Case Email option is not  displayed successfully ");

		// Validate the Owned status
		assertTrue(isgCasePage.isOwnedStatusDisplayed(testData.getExpectedResult()[12]),
				"Owned status is not displayed successfully");

		// Click on close button
		isgCasePage = functionalMethods.clickOnCloseBtn(isgCasePage);

		// Validate Resolved and completed status
		assertTrue(isgCasePage.hasResolvedCompletedStatusDisplayed(),
				"ResolvedCompleted option is not displayed successfully");

		// Click on Actions button
		isgCasePage = functionalMethods.isgActionsButton(isgCasePage);

		// Validate for Refresh option
		assertTrue(isgCasePage.hasRefreshOptionDisplayed(testData.getExpectedResult()[7]),
				"Refresh option is not displayed successfully ");

		// Validate for Print option
		assertTrue(isgCasePage.hasPrintOptionDisplayed(testData.getExpectedResult()[15]),
				"Print option is not displayed successfully ");

		// Validate for Send case email option
		assertTrue(isgCasePage.hasSendCaseEmailOptionDisplayed(testData.getExpectedResult()[16]),
				"Send Case Email option is not  displayed successfully");

	}

	/**
	 * Author : Aparajita Pattanaik Description :ISG case creation
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */

	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6804_ISGCaseCreation(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		NavigationClass navigationClass;
		ISGCasePage isgCasePage;
		HomePage homePage = null;
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
				"Navigation to landing page  was Unsuccessful");

		// Navigate to Home page
		homePage = functionalMethods.navigateToHomePage(navigationClass);

		// Verify that Landing of home Page is displayed
		assertTrue(homePage.isHomePageDisplayed(testData.getExpectedResult()[1]),
				"Navigation to Home page was Unsuccessful");

		// Navigate to ISG page.
		isgCasePage = functionalMethods.navToISGCasePage(homePage);

		// Verify that ISG Page is displayed
		assertTrue(isgCasePage.hasCreateISGCasePageDisplayed(testData.getExpectedResult()[2]),
				"Navigation to Create ISG Case Page was Unsuccessful");

		// Validate customer info header
		assertTrue(isgCasePage.hasCustomerInfoTextDisplayed(testData.getExpectedResult()[3]),
				"customer info is not Displayed succesfully");

		// Validate Contact & Dealership info
		assertTrue(isgCasePage.hasConatctAndDealershipTextDisplayed(testData.getExpectedResult()[4]),
				"Contact & Dealership info is not Displayed succesfully");

		// Validate Product info header
		assertTrue(isgCasePage.hasProductInfoTextDisplayed(testData.getExpectedResult()[5]),
				"product info is not Displayed successfully");

		// Validate Case Coding header
		assertTrue(isgCasePage.hasCaseCodingTextDisplayed(testData.getExpectedResult()[6]),
				"Case Coding is not Displayed successfully");

		// Validate Case Information header
		assertTrue(isgCasePage.hasCaseInformationTextDisplayed(testData.getExpectedResult()[7]),
				"Case Information  is not Displayed successfully");

		// Validate Related Case header
		assertTrue(isgCasePage.hasRelatedCaseTextDisplayed(testData.getExpectedResult()[8]),
				"Related case is not Displayed successfully");

		// Validate Problem Details header
		assertTrue(isgCasePage.hasProblemDetailsTextDisplayed(testData.getExpectedResult()[9]),
				"Problem Details info is not Displayed successfully");

		// Validate Summary field header
		assertTrue(isgCasePage.hasSummaryTextDisplayed(testData.getExpectedResult()[10]),
				"Summary is not Displayed successfully");

		// Validate Accept button
		assertTrue(isgCasePage.hasAcceptBtnDisplayed(), "Accept button is not Displayed successfully");

		// Validate Accept and Close button
		assertTrue(isgCasePage.hasAcceptandCloseBtnDisplayed(),
				"Accept and Close button is not Displayed successfully");

		// Validate Withdraw button
		assertTrue(isgCasePage.hasWithdrawBtnDisplayed(), "Withdraw  button is not Displayed successfully");

		// Validate Save button
		assertTrue(isgCasePage.hasSaveBtnDisplayed(), "Save button is not Displayed successfully");

		// Validate Audit button
		// assertTrue(isgCasePage.hasAuditHistoryDisplayed(testData.getExpectedResult()[11]),
		// "Audit is not Displayed successfully");

		// Enter case details for ISG case creation and click on accept button.
		isgCasePage = functionalMethods.isgEnterCaseCreationDetails(isgCasePage, testData.getTestdata()[4],
				testData.getTestdata()[5], testData.getTestdata()[6], testData.getTestdata()[7],
				testData.getTestdata()[8], testData.getTestdata()[9], testData.getTestdata()[10],
				testData.getTestdata()[11], testData.getTestdata()[12]);

		// Validate owned status.
		assertTrue(isgCasePage.isOwnedStatusDisplayed(testData.getExpectedResult()[12]),
				"Status owned is not displayed successfully");

	}

	/**
	 * Author :Aparajita Pattanaik Description : Verify case coding field for ISG
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
	public static void test_TC6543_ISGCaseCoding(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		ISGCaseCreation isgCaseCreation;
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
				"Navigation to landing page  was Unsuccessful");

		// Navigate to Home page
		homePage = functionalMethods.navigateToHomePage(navigationClass);

		// Verify that Landing of home Page is displayed
		assertTrue(homePage.isHomePageDisplayed(testData.getExpectedResult()[1]),
				"Navigation to Home page was Unsuccessful");

		// Navigate to ISG page.
		isgCaseCreation = functionalMethods.navToISGCasePag(homePage);

		// Verify that ISG Page is displayed
		assertTrue(isgCaseCreation.hasCreateISGCasePageDisplayed(testData.getExpectedResult()[2]),
				"Navigation to Create ISG Case Page was Unsuccessful");

		/*
		 * // Validate for Accept_Offer text from Action drop down
		 * assertTrue(isgCaseCreation.hasAcceptOffer(testData.getExpectedResult()[3]),
		 * "Accept Offer is not displayed");
		 */
		// Validate for Activate text from Action dropdown
		assertTrue(isgCaseCreation.hasActivate(testData.getExpectedResult()[4]), "Activate is not displayed");

		// Validate for NewHardware text from Action dropdown
		assertTrue(isgCaseCreation.hasAddNewHardwareDisplayed(testData.getExpectedResult()[5]),
				"Add New Hardware is not displayed");

		// Validate for ComarIssue text from Action dropdown
		assertTrue(isgCaseCreation.hasComarIssueDisplayed(testData.getExpectedResult()[6]),
				"Comar Issue is not displayed");

		// Validate for Deactivate. text from Action dropdown
		assertTrue(isgCaseCreation.hasDeactivateDisplayed(testData.getExpectedResult()[7]),
				"Deactivate is not displayed");

		/*
		 * // Validate for Decline text from Action dropdown
		 * assertTrue(isgCaseCreation.hasDeclineDisplayed(testData.getExpectedResult()[8
		 * ]), "Decline is not displayed");
		 */
		// Validate for Decomission text from Action dropdown
		assertTrue(isgCaseCreation.hasDecomissionDisplayed(testData.getExpectedResult()[9]),
				"Decomission is not displayed");

		// Validate for Demo text from Action dropdown
		assertTrue(isgCaseCreation.hasDemoDisplayed(testData.getExpectedResult()[10]), "Demo is not displayed");

		/*
		 * // Validate for Marketing text from Action dropdown
		 * assertTrue(isgCaseCreation.hasMarketingDisplayed(testData.getExpectedResult()
		 * [11]), "Marketing mirror is not displayed");
		 */
		// Validate for Normal_Transfer text from Action dropdown
		assertTrue(isgCaseCreation.hasNormal_TransferDisplayed(testData.getExpectedResult()[12]),
				"Normal Transfer is not displayed");

		/*
		 * // Validate for Preview text from Action dropdown
		 * assertTrue(isgCaseCreation.hasPreviewDisplayed(testData.getExpectedResult()[
		 * 13]), "Preview offer is not displayed");
		 * 
		 * // Validate for Publish text from Action dropdown
		 * assertTrue(isgCaseCreation.hasPublishDisplayed(testData.getExpectedResult()[
		 * 14]), "Publish offer is not displayed");
		 */
		// Validate for Reactivate text from Action dropdown
		assertTrue(isgCaseCreation.hasReactivateDisplayed(testData.getExpectedResult()[15]),
				"Reactivate is not displayed");

		// Validate for Reassign text from Action dropdown
		assertTrue(isgCaseCreation.hasReassignDisplayed(testData.getExpectedResult()[16]), "Reassign is not displayed");

		// Validate for Refund_Request text from Action dropdown
		assertTrue(isgCaseCreation.hasRefund_RequestDisplayed(testData.getExpectedResult()[17]),
				"Refund Request is not displayed");

		/*
		 * // Validate for Remove_offer text from Action dropdown
		 * assertTrue(isgCaseCreation.hasRemove_OfferDisplayed(testData.
		 * getExpectedResult()[18]), "Remove offer is not displayed");
		 */
		// Validate for Renew text from Action dropdown
		assertTrue(isgCaseCreation.hasRenewDisplayed(testData.getExpectedResult()[19]), "Renew is not displayed");

		// Validate for Sync text from Action dropdown
		assertTrue(isgCaseCreation.hasSyncDisplayed(testData.getExpectedResult()[20]), "Sync is not displayed");

		// Validate for Waranty_transfer text from Action dropdown
		assertTrue(isgCaseCreation.hasWarantyTransferDisplayed(testData.getExpectedResult()[21]),
				"Waranty transfer is not displayed");

	}

	/**
	 * Author : Aparajita Description : verifying withdraw functionality in ISG Case
	 * User
	 * 
	 * @param testData
	 * @param environmentDetails
	 * @param inputBrowserDetails
	 * @param driver
	 * @return
	 * @throws Throwable
	 */

	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6826_ISGWithdraw(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		HomePage homePage;
		NavigationClass navigationClass;
		ISGCaseCreation isgCaseCreation;

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
				"Navigation to landing page  was Unsuccessful");

		// Navigate to Home page
		homePage = functionalMethods.navigateToHomePage(navigationClass);

		// Verify that Landing of home Page is displayed
		assertTrue(homePage.isHomePageDisplayed(testData.getExpectedResult()[1]),
				"Navigation to Home page was Unsuccessful");

		// Navigate to ISG page.
		isgCaseCreation = functionalMethods.navToISGCasePag(homePage);

		// Verify that ISG Page is displayed
		assertTrue(isgCaseCreation.hasCreateISGCasePageDisplayed(testData.getExpectedResult()[2]),
				"Navigation to Create ISG Case Page was Unsuccessful");

		// click on withdraw button
		isgCaseCreation = functionalMethods.clickWithdrawBtn(isgCaseCreation);

		// Validate NewDraft status is displayed
		assertTrue(isgCaseCreation.hasNewDraftStatusDisplayed(testData.getExpectedResult()[3]),
				"New Draft status is not displayed correctly");

		// click on submit button in withdraw page
		isgCaseCreation = functionalMethods.clickSubmitButton(isgCaseCreation);

		// Validate that Landing Page is displayed
		assertTrue(isgCaseCreation.hasWithdrawPageDisplayed(), "Withdraw message  is not displayed sucessfully");

		// Validate Resolved-withdrawn successfully.
	}

	@Test(dataProvider = GlobalDataProvider.TEST_DATA_PROVIDER, dataProviderClass = GlobalDataProvider.class)
	public static void test_TC6825_cancelButton(InputEnvironmentDetails inputEnvironmentDetails,
			InputTestDetails testData) throws InterruptedException, AWTException, IOException {
		SiteMinderLoginPage siteMinderLoginPage;
		PegaLoginPage pegaLoginPage;
		ISGCaseCreation isgCaseCreation;
		NavigationClass navigationClass;
		FunctionalMethods functionalMethods = new FunctionalMethods();
		HomePage homePage;

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
				"Navigation to landing page  was Unsuccessful");

		// Navigate to Home page
		homePage = functionalMethods.navigateToHomePage(navigationClass);

		// Verify that Landing of home Page is displayed
		assertTrue(homePage.isHomePageDisplayed(testData.getExpectedResult()[1]),
				"Navigation to Home page was Unsuccessful");

		// Navigate to ISG page.
		isgCaseCreation = functionalMethods.navToISGCasePag(homePage);

		// Verify that ISG Page is displayed
		assertTrue(isgCaseCreation.hasCreateISGCasePageDisplayed(testData.getExpectedResult()[2]),
				"Navigation to Create ISG Case Page was Unsuccessful");

		// click on withdraw button
		isgCaseCreation = functionalMethods.clickWithdrawBtn(isgCaseCreation);

		// Validate NewDraft status is displayed
		assertTrue(isgCaseCreation.hasNewDraftStatusDisplayed(testData.getExpectedResult()[3]),
				"NewDraft status is Unsuccessful");

		// Click on cancel and action button
		isgCaseCreation = functionalMethods.clickCancelAndActionBtn(isgCaseCreation);

		// Validate refresh option, workcase, print.
		assertTrue(isgCaseCreation.isOptionsRefreshDisplayed(testData.getExpectedResult()[4]),
				"Refresh option is not displayed ");

		// Validate work case option
		assertTrue(isgCaseCreation.isOptionsWorkCaseDisplayed(testData.getExpectedResult()[5]),
				"Work Case option is not displayed ");

		// Validate print option
		assertTrue(isgCaseCreation.isOptionsPrintDisplayed(testData.getExpectedResult()[6]),
				"Print option is not displayed ");

	}

}