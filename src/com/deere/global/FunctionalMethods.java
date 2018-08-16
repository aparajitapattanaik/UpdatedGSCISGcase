package com.deere.global;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import com.deere.pages.NavigationClass;
import com.deere.pages.PegaLoginPage;
import com.deere.pages.SiteMinderLoginPage;
import com.deere.pages.casesearch.CaseSearchPage;
import com.deere.pages.gmailverification.GmailLoginPage;
import com.deere.pages.gmailverification.SendCaseEmail;
import com.deere.pages.greenfleet.GreenFleetCreationPage;
import com.deere.pages.gsccasecreation.CaseCoding;
import com.deere.pages.gsccasecreation.GSCCaseCreationPage;
import com.deere.pages.gsccasecreation.GSCCustomerSearch;
import com.deere.pages.gsccasecreation.GSCR4Page;
import com.deere.pages.gsccasecreation.GSCRoutingFilterPage;
import com.deere.pages.gsccasecreation.GSCRoutingFilterSearchPage;
import com.deere.pages.gsccasecreation.GSCRoutingPage;
import com.deere.pages.gsccasecreation.ViewEmailZeacomPage;
import com.deere.pages.homepage.HomePage;
import com.deere.pages.isgcasecreation.ISGCaseCreation;
import com.deere.pages.isgcasecreation.ISGCaseCreationHomePage;
import com.deere.pages.isgcasecreation.ISGCasePage;
import com.deere.pages.isgcasecreation.ISGCaseSearchPage;
import com.deere.pages.isgcasecreation.ISGLinkSolutionPage;
import com.deere.pages.isgcasecreation.ISGRecommendedSolutionsSectionPage;
import com.deere.pages.isgcasecreation.ISGWithdrawPage;
import com.deere.pages.reports.ReportsPage;
import com.deere.pages.solutionsearch.SolutionSearchHomePage;
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
import com.deere.pages.workbasketqueue.WorkGroupQueuePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * 
 * @author kw75188 Description : This Class contains Functional Methods that are
 *         used in Test Scripts
 *
 */

public class FunctionalMethods {

	private ExtentTest logger = ExtentReportManager.getLogger();

	private PegaLoginPage pegaLoginPage;

	private ISGRecommendedSolutionsSectionPage isgRecommendedSolutionsSection;
	private SolutionSearchHomePage solutionSearchHome;
	private ISGLinkSolutionPage isgLinkSolution;
	private CaseSearchPage caseSearch;
	private ISGCaseCreationHomePage isgCaseCreationHome;
	private HomePage home;
	private ISGCasePage isgCase;
	private ISGCaseSearchPage isgCaseSearch;
	private ReportsPage reports;
	private R4Turf r4Turf;
	private WorkGroupQueuePage workGroupQueuePage;
	private GmailLoginPage gmailLogin;
	private Deere deereForm;
	private R4_AgCCWebFormSubmissionPage r4AgCCWebFormSubmission;
	private SendCaseEmail sendCaseEmailPage;
	private SouthEastAsia southEastAsiaForm;
	private SouthSahara southSaharaForm;
	private StellarSupportWebformSubmissionPage stellarSupportWebformSubmission;
	private GreenFleetWebFormSubmissionPage greenFleetWebFormSubmission;
	private India indiaForm;
	private Agronomy agronomyForm;
	private JDLinksWebFormSubmitionPage jdLinksWebFormSubmition;
	private JDPartsWebFormSubmissionPage jdPartsWebFormSubmission;
	private Techpubs techpubsForm;
	private GreenFleetCreationPage greenFleetCreation;
	private GSCCustomerSearch gscCustomerSearchPage;
	private GSCRoutingFilterSearchPage gscRoutingFilterSearch;
	private ViewEmailZeacomPage viewEmailZeacom;
	private CaseCoding casecodingPage;
	private ISGCaseCreation isgCaseCreationPage;
	private GSCRoutingFilterPage gscRoutingFilter;
	private R4_AgCCWebFormSubmissionPage r4_AgCCWebFormSubmission;
	private GSCCaseCreationPage gscCaseCreation;
	private ISGCasePage isgGCase;
	private R4Turf r4TurffWebForm;
	private GSCRoutingPage gscRouting;
	private GSCCustomerSearch gscCustomerSerch;
	private String funcarea;
	private SendCaseEmail sendCaseEmail;
	private HomePage homePage;
	private GSCR4Page gscR4Page;
	private GSCCaseCreationPage gscCaseCreationPage;
	private ISGCaseSearchPage isgCaseSearchPage;

	// Open the Site Minder Portal
	public SiteMinderLoginPage openPortal(WebDriver driver, String url) {
		driver.get(url);
		logger.log(LogStatus.PASS, "Opening Site Minder Portal");
		return new SiteMinderLoginPage(driver);
	}

	// Login to Site Minder Portal
	public PegaLoginPage loginToSiteMinder(SiteMinderLoginPage siteMinderLoginPag, String username, String password) {
		pegaLoginPage = siteMinderLoginPag.enterUserName(username).enterPassword(password).clickSignInBtn();
		logger.log(LogStatus.PASS, "Logging in to Site Minder");
		return pegaLoginPage;
	}

	// Login to Pega Site
	public <T> T loginToPega(PegaLoginPage loginPage, String username, String password, Class<T> landingPage) {
		Object obj = loginPage.enterUserId(username).enterPassword(password).clickLogInBtn(landingPage);
		logger.log(LogStatus.PASS, "Logging in to Pega Site");
		return (T) obj;
	}

	// Navigate to Solution search page
	public SolutionSearchHomePage navigateToSolutionSearchHome(NavigationClass navigationPag) {
		solutionSearchHome = navigationPag.clickSolutionSearchHomeLink();
		logger.log(LogStatus.PASS, "Navigating to Solution Search home page");
		return solutionSearchHome;
	}

	// Entering Customer Details for ISG case
	public ISGCasePage enterIsgCaseCreationDet(ISGCasePage isgCasePag, String countrycode, String firstname,
			String lastname, String model, String funcarea, String funccode, String summary, String priority,
			String orgn) {
		isgCase = isgCasePag.clickAddCustomerInfo().enterCountryCode(countrycode).enterFirstName(firstname)
				.enterLastName(lastname).clickCustomerSearch().clickRadioButton().clickCustomerSubmitButton()
				.clickAddProductInfo().enterModel(model).clickProductSubmitButton().selFunctionalArea(funcarea)
				.selFunCode(funccode).selPriority(priority).selOrigin(orgn).enterIsgSummary(summary)
				.clickAcceptButton();
		logger.log(LogStatus.PASS, "Entering Customer details for ISG Case Creation  ");
		return isgCase;
	}

	// Entering Product info Details and click on submit
	public ISGCasePage addProductInfoDetails(ISGCasePage isgCasePag, String model) {
		isgCase = isgCasePag.clickAddProductInfo().enterModel(model).clickProductSubmitButton();
		logger.log(LogStatus.PASS, "Entering Product info Details and click on submit");
		return isgCase;
	}

	// Entering Functional Area and code,Priority,Origin,Summary and click on
	// accept button
	public ISGCasePage addFunctionalDetails(ISGCasePage isgCasePag, String funcarea, String funccod, String summary,
			String priorit, String orgn) {
		isgCase = isgCasePag.selFunctionalArea(funcarea).selFunCode(funccod).selPriority(priorit).selOrigin(orgn)
				.enterIsgSummary(summary).clickAcceptButton();
		logger.log(LogStatus.PASS,
				"Entering Functional Area and code Priority,Origin, ISGSummary and clicking on Accept button ");
		return isgCase;
	}

	// Click on Accept button
	public ISGCasePage isgAccept_Button(ISGCasePage isgCasePag) {
		isgCase = isgCasePag.clickAcceptButton();
		logger.log(LogStatus.PASS, "Clicking on Accept button ");
		return isgCase;
	}

	// Click on Case search Image button and click on case id link
	public ISGCaseSearchPage clickCaseSearchImgLink(ISGCaseSearchPage isgCaseSearchPag) {
		isgCaseSearch = isgCaseSearchPag.clickCaseSearchImgLink().clickCaseIdLink();
		logger.log(LogStatus.PASS, "Clicking on Case search Image button and clicking on case Id link");
		return isgCaseSearch;
	}

	// Click on Case Action-workcase->click on accept button
	public ISGCasePage clickonActionsWorkcaseAccept(ISGCaseSearchPage isgCaseSearchPage, String area, String code) {
		isgCase = isgCaseSearchPage.clickOnActionsBtnSwitchToFrame().selectWorkcaseOption().selFunctionalArea(area)
				.selFunCode(code).clickOnAcceptBtn();
		logger.log(LogStatus.PASS, "Clicking on action button, select workcase option ,entering functional area and"
				+ " functional code and click on accept button");
		return isgCase;
	}

	// Enter CaseId detail in solution search box
	public SolutionSearchHomePage clickOnSolutionSearchBox(SolutionSearchHomePage solutionSearchHomePag,
			String caseid) {
		solutionSearchHome = solutionSearchHomePag.enterCaseIdData(caseid);
		logger.log(LogStatus.PASS, "Entering the CaseId in search box ");
		return solutionSearchHome;
	}

	// Click on Solution Search Button
	public SolutionSearchHomePage clickSolutionSearchButton(SolutionSearchHomePage solutionSearchHomePag) {
		solutionSearchHome = solutionSearchHomePag.clickOnSolutionSearchButton();
		logger.log(LogStatus.PASS, "clicking on Solution Search Button");
		return solutionSearchHome;

	}

	// click on GSC home page
	public GSCCaseCreationPage clickOnGSCCase(GSCCaseCreationPage gscCaseCreationPag) {
		gscCaseCreation = gscCaseCreationPag.clickGSCCase();
		logger.log(LogStatus.PASS, "Clicking on GSC case");
		return gscCaseCreation;
	}

	// click on Add Customer Info
	public GSCCaseCreationPage clickAddCustomeInfo(GSCCaseCreationPage gscCaseCreationPag) {
		gscCaseCreation = gscCaseCreationPag.clickOnAddCustomeInfo();
		logger.log(LogStatus.PASS, "Clicking on Add customer Info icon");
		return gscCaseCreation;
	}

	// Click on Accept button
	public GSCCaseCreationPage clickOnAccept(GSCCaseCreationPage gscCaseCreationPag) {
		gscCaseCreation = gscCaseCreationPag.clickAccept();
		logger.log(LogStatus.PASS, "clicking on Accept button");
		return gscCaseCreation;
	}

	// Select workgroup dropdown
	public GSCCaseCreationPage selectWorkgroup(GSCCaseCreationPage gscCaseCreationPag, String workgroup) {
		gscCaseCreation = gscCaseCreationPag.selectWorkgroupDD(workgroup);
		logger.log(LogStatus.PASS, "selecting workgroup dropdown");
		return gscCaseCreation;

	}

	// Click on Actions button
	public GSCCaseCreationPage clickOnActions(GSCCaseCreationPage gscCaseCreationPag) {
		gscCaseCreation = gscCaseCreationPag.clickActions();
		logger.log(LogStatus.PASS, "clicking on Actions button");
		return gscCaseCreation;
	}

	// Click on send case mail button
	public GSCCaseCreationPage sendCaseMail(GSCCaseCreationPage gscCaseCreationPag) {
		gscCaseCreation = gscCaseCreationPag.clickSendCaseMail();
		logger.log(LogStatus.PASS, "clicking on send case mail button");
		return gscCaseCreation;
	}

	// Enter details in send case email
	public GSCCaseCreationPage enterSendCaseEmailData(GSCCaseCreationPage gscCaseCreationPag, String mail) {
		gscCaseCreation = gscCaseCreationPag.enterSendCaseEmail(mail);
		logger.log(LogStatus.PASS, "entering details in send case mail ");
		return gscCaseCreation;
	}

	// Click on send case email button
	public GSCCaseCreationPage clickSendButton(GSCCaseCreationPage gscCaseCreationPag) {
		gscCaseCreation = gscCaseCreationPag.clickOnSendButton();
		logger.log(LogStatus.PASS, "clicking on send case  button");
		return gscCaseCreation;
	}

	// Expand Audit trails button.
	public GSCCaseCreationPage auditTrails(GSCCaseCreationPage gscCaseCreationPag) {
		gscCaseCreation = gscCaseCreationPag.expandAuditTrails();
		logger.log(LogStatus.PASS, "Expanding on audit trails  button");
		return gscCaseCreation;
	}

	// Verifying alert for GSC case
	public GSCCaseCreationPage alertVerification(GSCCaseCreationPage gscCaseCreationPag) {
		gscCaseCreation = gscCaseCreationPag.alertVerificationGSC();
		logger.log(LogStatus.PASS, "Verifying alert for GSC case");
		return gscCaseCreation;
	}

	// click on ISG case button
	public ISGCaseCreation clickOnISGCase(ISGCaseCreation isgCaseCreation) {
		isgCaseCreation = isgCaseCreation.clickISGCaseButton();
		logger.log(LogStatus.PASS, "Clicking on ISG case");
		return isgCaseCreation;
	}

	// click on Action button
	public GSCCaseCreationPage clickOnAction(GSCCaseCreationPage gscCaseCreationPag) {
		gscCaseCreation = gscCaseCreationPag.clickActionBtn();
		logger.log(LogStatus.PASS, "clicking on Action");
		return gscCaseCreation;
	}

	// Click on workcase option from Action DD
	public GSCCaseCreationPage clickOnWorkcase(GSCCaseCreationPage gscCaseCreationPag) {
		gscCaseCreation = gscCaseCreationPag.selectWorkcase();
		logger.log(LogStatus.PASS, "Selecting workcase option from Actions dropdown");
		return gscCaseCreation;
	}

	// Click on transfer workbasket from Action DD
	public GSCCaseCreationPage selectTransferCaseWorkBasket(GSCCaseCreationPage gscCaseCreationPag) {
		gscCaseCreation = gscCaseCreationPag.clickTransferCaseWorkBasketOption();
		logger.log(LogStatus.PASS, "Clicking on transfer workbasket option from Actions");
		return gscCaseCreation;
	}

	// Click on transfer button from Action DD
	public GSCCaseCreationPage clickOntransfer(GSCCaseCreationPage gscCaseCreationPag) {
		gscCaseCreation = gscCaseCreationPag.clickTransferOption();
		logger.log(LogStatus.PASS, "Clicking on transfer");
		return gscCaseCreation;
	}

	// Switch to default frame
	public ISGCasePage switchToDefaultFrame(ISGCasePage isgCasePag) {
		isgCase = isgCasePag.switchToDefaultFrame();
		logger.log(LogStatus.PASS, "Switching to default frame ");
		return isgCase;
	}

	// Switch to main page.
	public ISGCasePage SwitchToMainFrame(ISGCasePage isgCasePag) {
		isgCase = isgCasePag.switchToMainFrame();
		logger.log(LogStatus.PASS, "Switched to Main Page ");
		return isgCase;
	}

	// Clicking on zeacom mail
	public ViewEmailZeacomPage clickOnMailZeacom(ISGCasePage isgCasePag) {
		viewEmailZeacom = isgCasePag.clickMailZeacom();
		logger.log(LogStatus.PASS, "Clicking on mail Zeacom ");
		return viewEmailZeacom;
	}

	// Click on Actions button
	public ISGCasePage clickOnActions(ISGCasePage isgCasePag) {
		isgCase = isgCasePag.clickActionsBtn();
		logger.log(LogStatus.PASS, "clicking on Actions button");
		return isgCase;
	}

	// click on WorkGroupQueue filter
	public GSCRoutingFilterPage clickOnWorkGroupQueueFilter(GSCRoutingFilterPage gscRoutingFilterPag) {
		gscRoutingFilter = gscRoutingFilterPag.clickWGQueueFilter();
		logger.log(LogStatus.PASS, "clicking on  WorkGroupQueue filter");
		return gscRoutingFilter;
	}

	// Entering workbasket details
	public GSCRoutingFilterPage enterWorkBasketInfo(GSCRoutingFilterPage gscRoutingFilterPag, String WBasket) {
		gscRoutingFilter = gscRoutingFilterPag.enterWorkBasket(WBasket);
		logger.log(LogStatus.PASS, "Entering workbasket details");
		return gscRoutingFilter;
	}

	// Entering subgroup selections
	public GSCRoutingFilterPage clkSubGroupSelection(GSCRoutingFilterPage gscRoutingFilterPag) {
		gscRoutingFilter = gscRoutingFilterPag.clickSubGroupSelection();
		logger.log(LogStatus.PASS, " clicking subgroup selection");
		return gscRoutingFilter;
	}

	// Navigating to home page and clicking on Home Button
	public ISGRecommendedSolutionsSectionPage navigateToHome(NavigationClass navigationPag) {
		isgRecommendedSolutionsSection = navigationPag.clickHomeBtn();
		logger.log(LogStatus.PASS, "Navigating to  home page and clicking on Home Button");
		return isgRecommendedSolutionsSection;
	}

	// Lahari : Navigate toISGCaseCreationHomePage
	public ISGCaseCreationHomePage navigateToISGCaseCreationHomePage(NavigationClass navigationPag) {
		isgCaseCreationHome = navigationPag.clickOnHomeBtn();
		logger.log(LogStatus.PASS, "Navigating to  ISGCaseCreationHomePage ");
		return isgCaseCreationHome;
	}

	// Lahari : Navigate to Home Page from any page
	public GSCRoutingPage navigateToGSCRoutingPageClkHomeBtn(NavigationClass navigationPag) {
		gscRouting = navigationPag.clickHomeButn();
		logger.log(LogStatus.PASS, "Navigating to GSCRoutingPage and clicking on Home Button");
		return gscRouting;
	}

	// Lahari : click on GSC button
	public GSCRoutingPage clickOnGSCCaseButton(GSCRoutingPage gscRoutingPag) {
		gscRouting = gscRoutingPag.clickGSCCase();
		logger.log(LogStatus.PASS, "Clicking on GSC Case Creation button");
		return gscRouting;
	}

	// Lahari : Perform Actions Functionalities
	public GSCRoutingPage selectValFromActionsClkSubmit(GSCRoutingPage gscRoutingPag, String oper, String work) {
		gscRouting = gscRoutingPag.clickonActionsSelectVal(oper, work);
		logger.log(LogStatus.PASS,
				"selecting Transfer to Individual option from Actions and submit all details in Transfer popup screen clicking on submit button");
		return gscRouting;
	}

	// Lahari : Perform Actions Functionalities
	public GSCRoutingPage getCaseId(GSCRoutingPage gscRoutingPag) {
		gscRouting = gscRoutingPag.getGscCaseId();
		logger.log(LogStatus.PASS,
				"selecting Transfer case to WB option from Actions and submit all details in Transfer popup screen clicking on submit button");
		return gscRouting;
	}

	// Lahari : select value from WorkBasket and click on transfer
	public GSCRoutingPage selectValFromWorkBasket(GSCRoutingPage gscRoutingPag, String workbasket) {
		gscRouting = gscRoutingPag.selectWorkBasketTrafCase(workbasket);
		logger.log(LogStatus.PASS, "selecting select WorkBasket value and  clicking on transfer button");
		return gscRouting;
	}

	// Lahari : click on transfer button
	public GSCRoutingPage clikTransfBtn(GSCRoutingPage gscRoutingPag) {
		gscRouting = gscRoutingPag.transferBtn();
		logger.log(LogStatus.PASS, "  clicking on transfer button");
		return gscRouting;
	}

	// Lahari : selecting Value From Workbasket and clicking on Submit button
	public GSCRoutingPage selectWorkBasketFiledData(GSCRoutingPage gscRoutingPag, String workbaket) {
		gscRouting = gscRoutingPag.selectValFromWorkBasket(workbaket);
		logger.log(LogStatus.PASS, "  selecting Value From Workbasket and clicking on Submit button");
		return gscRouting;
	}

	// Lahari :click on filters
	public GSCRoutingFilterSearchPage clickfiltersLink(GSCRoutingFilterSearchPage gscRoutingFilterSearchPag) {
		gscRoutingFilterSearch = gscRoutingFilterSearchPag.clickFilters();
		logger.log(LogStatus.PASS, "Clicking on filters");
		return gscRoutingFilterSearch;
	}

	// Lahari : Navigate ISGLinkSolutionPage page and add all Case Coding
	// Details
	// and Case Information Details
	public ISGLinkSolutionPage navigateToISGLinkSolutionPage(ISGCasePage isgCasePag, String func_area, String func_code,
			String language, String summary, String priority, String orign) {
		isgLinkSolution = isgCasePag.selFunctionalArea(func_area).functionalCode(func_code).selPriority(priority)
				.isgCase_Language(language).isgCase_Origin(orign).summary(summary).acceptButton();
		logger.log(LogStatus.PASS, "Navigating to  home page");
		return isgLinkSolution;
	}

	// Lahari : Navigate to Home Page from any page
	public ISGLinkSolutionPage navToISGLinkSolutionPageClkHome(HomePage homePag) {
		isgLinkSolution = homePag.clickOnHomeButton().clickonWorkGroupQueue();
		logger.log(LogStatus.PASS, "Navigating to  ISGLinkSolutionPage and clicking on Home Button and WorkGroupQueue");
		return isgLinkSolution;
	}

	// Click on SolutionSearch Link
	public ISGLinkSolutionPage clickSolutionsSearch(ISGCasePage isgCasePag) {
		isgLinkSolution = isgCasePag.clickSoluSeach().clickSearchBtn();
		logger.log(LogStatus.PASS, "Clicking on SolutionSearch ");
		return isgLinkSolution;
	}

	// Click on SolutionSearch Link
	public ISGLinkSolutionPage clickSolutionsSearch(ISGLinkSolutionPage isgLinkSolutionPag) {
		isgLinkSolution = isgLinkSolutionPag.clickSoluSeach().clickSearchBtn();
		logger.log(LogStatus.PASS, "Clicking on SolutionSearch ");
		return isgLinkSolution;
	}

	// Click on SolutionSearch Link
	public ISGLinkSolutionPage clickSolutionsSearchSeltLangu(ISGLinkSolutionPage isgLinkSolutionPag) {
		isgLinkSolution = isgLinkSolutionPag.clickSoluSeach();
		logger.log(LogStatus.PASS, "Clicking on SolutionSearch ");
		return isgLinkSolution;
	}

	// Click on Solution link.
	public ISGLinkSolutionPage clickAnySolution(ISGLinkSolutionPage isgLinkSolutionPag) {
		isgLinkSolution = isgLinkSolutionPag.clickSolution();
		logger.log(LogStatus.PASS, "Clicking on Solution Link   ");
		return isgLinkSolution;
	}

	// Click on Actions and link soultions button
	public ISGLinkSolutionPage clickActionsDD(ISGLinkSolutionPage isgLinkSolutionPag) {
		isgLinkSolution = isgLinkSolutionPag.clickAction().linksolutionPopUp().naviageToCase();
		logger.log(LogStatus.PASS, "Clicking on  Actions and click on Link Solutions ");
		return isgLinkSolution;
	}

	// Navigate to Case Search page
	public ISGCaseSearchPage navigateToCaseSearchPage(NavigationClass navigationCls) {
		isgCaseSearch = navigationCls.clickCaseSearchHomeLink();
		logger.log(LogStatus.PASS, "Navigating to Case Search  page");
		return isgCaseSearch;
	}

	// Entered Case Id into case search filed
	public ISGCaseSearchPage enterCaseIdInCaseSearchBox(ISGCaseSearchPage isgCaseSearchPag, String caseID) {
		isgCaseSearch = isgCaseSearchPag.enterCaseIDInCaseSearchBox(caseID);
		logger.log(LogStatus.PASS, "Entering Case Id into case search filed");
		return isgCaseSearch;

	}

	// clicking on Correspondence
	public ISGCaseSearchPage clickOnCorrespondence(ISGCaseSearchPage isgCaseSearchPag) {
		isgCaseSearch = isgCaseSearchPag.clickCorrespondence();
		logger.log(LogStatus.PASS, "clicking on Corresrpondence");
		return isgCaseSearch;
	}

	public ViewEmailZeacomPage clickOnMailZeacom(ISGCaseSearchPage isgCaseSearchPag) {
		viewEmailZeacom = isgCaseSearchPag.clickMailZeacom();
		logger.log(LogStatus.PASS, "Clicking on mail Zeacom ");
		return viewEmailZeacom;
	}

	public JDParts openJDPartsWebformPortal(WebDriver driver, String url) {
		driver.get(url);
		logger.log(LogStatus.PASS, "Opening JDParts Form Portal");
		return new JDParts(driver);
	}

	// Logged in to Web Forms
	public JDPartsWebFormSubmissionPage logintoWebform(JDParts jdPart, String username, String password) {
		jdPartsWebFormSubmission = jdPart.enterUserName(username).enterPassword(password).clickSignInBtn();
		logger.log(LogStatus.PASS, "Logging in to Web Forms");
		return jdPartsWebFormSubmission;
	}

	// Entering Data into Detailed description filed and uploading file using
	// File attach button
	public JDPartsWebFormSubmissionPage enterdetailedDescriptionUploadFile(
			JDPartsWebFormSubmissionPage jdPartsWebFormSubmission, String desc) {
		jdPartsWebFormSubmission = jdPartsWebFormSubmission.detailedDescription(desc).uploadFile();
		logger.log(LogStatus.PASS,
				"Entering Data into Detailed description filed and uploading file using File attach button");
		return jdPartsWebFormSubmission;
	}

	// Entering Data into Detailed description filed and uploading file using
	// File attach button
	public JDPartsWebFormSubmissionPage enterdetailedDescription(JDPartsWebFormSubmissionPage jdPartsWebFormSubmission,
			String desc) {
		jdPartsWebFormSubmission = jdPartsWebFormSubmission.detailedDescription(desc).clickSubmit();
		logger.log(LogStatus.PASS,
				"Entering Data into Detailed description filed and uploading file using File attach button");
		return jdPartsWebFormSubmission;
	}

	// Clicking on Clear button and validating validation message
	public JDPartsWebFormSubmissionPage clickClearButtonVefyValidaMeg(
			JDPartsWebFormSubmissionPage jdPartsWebFormSubmissionPag) {
		jdPartsWebFormSubmission = jdPartsWebFormSubmissionPag.clickOnClearButton();
		logger.log(LogStatus.PASS, "Clicking on Clear button and validating validation message ");
		return jdPartsWebFormSubmission;
	}

	// Clicking on Submit button and validate validation message appear
	public JDPartsWebFormSubmissionPage clickOnSubBtnValidateValidMsgAppear(
			JDPartsWebFormSubmissionPage jdPartsWebFormSubmissionPag) {
		jdPartsWebFormSubmission = jdPartsWebFormSubmissionPag.submitButton();
		logger.log(LogStatus.PASS, " Clicking  on Submit button and validating validation message appear ");
		return jdPartsWebFormSubmission;
	}

	// Clicking on submit button
	public JDPartsWebFormSubmissionPage clickSubmitButton(JDPartsWebFormSubmissionPage jdPartsWebFormSubmissionPag) {
		jdPartsWebFormSubmission = jdPartsWebFormSubmissionPag.clickSubmit();
		logger.log(LogStatus.PASS, " Clicking on submit button ");
		return jdPartsWebFormSubmission;
	}

	// Get Case Id
	public JDPartsWebFormSubmissionPage getCaseID(JDPartsWebFormSubmissionPage jdPartsWebFormSubmissionPag) {
		jdPartsWebFormSubmission = jdPartsWebFormSubmissionPag.getCaseID();
		logger.log(LogStatus.PASS, "Getting Case Id and storing into String Variable");
		return jdPartsWebFormSubmission;
	}

	// Opening Webform URL for R4_AgCC
	public R4_AgCC openAgccWebformPortal(WebDriver driver, String url) {
		driver.get(url);
		logger.log(LogStatus.PASS, "Opening R4_AgCC Form Portal");
		return new R4_AgCC(driver);
	}

	// Entering username and password and clicking on signin button.
	public R4_AgCCWebFormSubmissionPage logintoWebform(R4_AgCC r4agccForm, String username, String password) {
		r4_AgCCWebFormSubmission = r4agccForm.enterUserName(username).enterPassword(password).clickSignInBtn();
		logger.log(LogStatus.PASS, "Entering username and password and clicking on signin button");
		return r4_AgCCWebFormSubmission;
	}

	// Enter Data into Detaild Description Field and Uplaoding File
	public R4_AgCCWebFormSubmissionPage enterDetailedDescriptionUploadFile(
			R4_AgCCWebFormSubmissionPage r4AgCCWebFormSubmissionPag, String desc) {
		r4_AgCCWebFormSubmission = r4AgCCWebFormSubmissionPag.detailedDescription(desc).uploadFile();
		logger.log(LogStatus.PASS, "Enter Data into Detaild Description Field and Uploading File ");
		return r4_AgCCWebFormSubmission;
	}

	// Click on Clear button validating validation Message
	public R4_AgCCWebFormSubmissionPage clickOnClearButtonValValidMesg(
			R4_AgCCWebFormSubmissionPage r4_AgCCWebFormSubmissionPag) {
		r4_AgCCWebFormSubmission = r4_AgCCWebFormSubmissionPag.clickOnClearButton();
		logger.log(LogStatus.PASS, "Clicking on clear button and validating validation Message");
		return r4_AgCCWebFormSubmission;
	}

	// Clicking on submit button
	public R4_AgCCWebFormSubmissionPage clickSubmitBtn(R4_AgCCWebFormSubmissionPage r4_AgCCWebFormSubmissionPag) {
		r4_AgCCWebFormSubmission = r4_AgCCWebFormSubmissionPag.clickSubmit();
		logger.log(LogStatus.PASS, " Clicking on submit button ");
		return r4_AgCCWebFormSubmission;
	}

	// Get Case Id
	public R4_AgCCWebFormSubmissionPage getCaseID(R4_AgCCWebFormSubmissionPage r4_AgCCWebFormSubmissionPag) {
		r4_AgCCWebFormSubmission = r4_AgCCWebFormSubmissionPag.getCaseID();
		logger.log(LogStatus.PASS, " Getting CaseId  ");
		return r4_AgCCWebFormSubmission;
	}

	// Click on Clear button
	public R4_AgCCWebFormSubmissionPage clickOnSubmitButton(R4_AgCCWebFormSubmissionPage r4_AgCCWebFormSubmissionPag) {
		r4_AgCCWebFormSubmission = r4_AgCCWebFormSubmissionPag.clickSubmitButton();
		logger.log(LogStatus.PASS, "Clicking on clear button ");
		return r4_AgCCWebFormSubmission;
	}

	// click On Submit Button
	public R4Turf clickOnSubmitButton(R4Turf r4Turf) {
		r4Turf = r4Turf.clickSubmitButton();
		logger.log(LogStatus.PASS, "clicking On Submit Button ");
		return r4Turf;
	}

	// login to web form
	public R4Turf logintoR4Turfwebform(R4TurfLoginPage r4TurfLoginPage, String username, String password) {
		r4Turf = r4TurfLoginPage.enterUserName(username).enterPassword(password).clickSignInBtn();
		logger.log(LogStatus.PASS, "Logged in to web form");
		return r4Turf;
	}

	// open form portal
	public R4TurfLoginPage openWebformPortal_R4Turf(WebDriver driver, String url) {
		driver.get(url);
		logger.log(LogStatus.PASS, "Opening R4Turf WebForm Portal");
		return new R4TurfLoginPage(driver);
	}

	// Storing the case id to string
	public R4Turf getCaseID(R4Turf r4TurForm) {
		r4TurffWebForm = r4TurForm.getCaseID();
		logger.log(LogStatus.PASS, " Storing the case id to string ");
		return r4TurffWebForm;
	}

	// Select country
	public R4Turf countrySelection(R4Turf r4TurForm) {
		r4TurffWebForm = r4TurForm.country_selection();
		logger.log(LogStatus.PASS, "Selecting country");
		return r4TurffWebForm;
	}

	// Enter dealer name
	public R4Turf DealerName(R4Turf r4TurForm) {
		r4TurffWebForm = r4TurForm.dealerName();
		logger.log(LogStatus.PASS, "Entered Dealer name");
		return r4TurffWebForm;
	}

	// Enter Dealer city
	public R4Turf DealerCity(R4Turf r4TurForm) {
		r4TurffWebForm = r4TurForm.dealerCity();
		logger.log(LogStatus.PASS, "Entered Dealer city");
		return r4TurffWebForm;
	}

	// Enter dealer state
	public R4Turf DealerState(R4Turf r4TurForm) {
		r4TurffWebForm = r4TurForm.dealerState();
		logger.log(LogStatus.PASS, "Entered Dealer State");
		return r4TurffWebForm;
	}

	// Entering the WebForm Detailed_description and uploading file
	public R4Turf detailedDescriptionUploadFile(R4Turf r4TurForm, String desc) {
		r4TurffWebForm = r4TurForm.detailedDescription(desc).uploadFile();
		logger.log(LogStatus.PASS, "Entered description into R4_Turf webform  and uploading file");
		return r4TurffWebForm;
	}

	// Attaching file
	public R4Turf AddButton(R4Turf r4TurForm) {
		r4TurffWebForm = r4TurForm.uploadFile();
		logger.log(LogStatus.PASS, "Attaching a file is successful");
		return r4TurffWebForm;
	}

	// click On Clear Button
	public R4Turf clkClearBtnValValdMesg(R4Turf r4TurForm) {
		r4TurffWebForm = r4TurForm.clickOnClearButton();
		logger.log(LogStatus.PASS, "click On ClearButton is successful");
		return r4TurffWebForm;
	}

	// Clicking on submit button
	public R4Turf clickSubmitBtn(R4Turf r4TurForm) {
		r4TurffWebForm = r4TurForm.clickSubmit();
		logger.log(LogStatus.PASS, " Clicking on submit button ");
		return r4TurffWebForm;
	}

	// Get CaseId
	public R4Turf GetCaseID(R4Turf r4TurForm) {
		r4TurffWebForm = r4TurForm.getCaseIDOfR4Turf();
		logger.log(LogStatus.PASS, " Final message was displayed ");
		return r4TurffWebForm;
	}

	// Attaching file to Techpubs Form
	public Techpubs UploadAttachment(Techpubs techpub) {
		techpubsForm = techpub.uploadFile();
		logger.log(LogStatus.PASS, "Attaching a file is not successful");
		return techpubsForm;
	}

	// Selecting portugues language
	public Techpubs selectPortuguesLanguage(Techpubs techpub) {
		techpubsForm = techpub.selectPortuguesLanguage();
		logger.log(LogStatus.PASS, "Selecting portugues language");
		return techpubsForm;
	}

	// Selecting language
	public Techpubs selectEnglishLanguage(Techpubs techpub) {
		techpubsForm = techpub.selectPortuguesLanguage();
		logger.log(LogStatus.PASS, "Selecting  language");
		return techpubsForm;
	}

	// Click on Clear button
	public Techpubs clickOnClearButton(Techpubs techpub) {
		techpubsForm = techpub.clickOnClearButton();
		logger.log(LogStatus.PASS, "Clicking on clear button");
		return techpubsForm;
	}

	// Click on submit button
	public Techpubs clickOnSubmitButton(Techpubs techpub) {
		techpubsForm = techpub.clickSumitButton();
		logger.log(LogStatus.PASS, "Clicking on submit button");
		return techpubsForm;
	}

	// Clicking on submit button
	public Techpubs clickSubmit(Techpubs techpub) {
		techpubsForm = techpub.clickSubmit();
		logger.log(LogStatus.PASS, " Clicking on submit button ");
		return techpubsForm;
	}

	// click on submit
	public GSCR4Page clickSubmit(GSCR4Page gscR4Pag) {
		gscR4Page = gscR4Pag.clickSubmit();
		logger.log(LogStatus.PASS, "submitting report only case");
		return gscR4Page;
	}

	// Login to Deere form
	public Deere loginToDeereWebform(DeereLoginPage deereLoginPag, String username, String password) {
		deereForm = deereLoginPag.enterUserName(username).enterPassword(password).clickSignInBtn();
		logger.log(LogStatus.PASS, "Logging into web form");
		return deereForm;
	}

	// selecting country and Entering description and uplaod attachment
	public Deere selCounEntDesUplodFile(Deere deer, String desc) {
		deereForm = deer.selectCountry().detailedDesc(desc).fileUpload();
		logger.log(LogStatus.PASS,
				"selecting country and Entering description into Deere webform and uplaoding attachment");
		return deereForm;
	}

	// Entering description and uplaod attachment
	public Deere enterDesUplodFile(Deere deer, String desc) {
		deereForm = deer.detailedDesc(desc).fileUpload();
		logger.log(LogStatus.PASS, " Entering description into Deere webform and uplaoding attachment");
		return deereForm;
	}

	// Click on Clear button, Submit button and Accept Alert
	public Deere clickOnClearBtnSubmitBtnAcptAlrt(Deere deer) {
		deereForm = deer.clickOnClearButton().clkSubmitButton().alertAccept();
		logger.log(LogStatus.PASS, "Clicking on Clear button, Submit button");
		return deereForm;
	}

	// Opening Deere WebForm Portal
	public DeereLoginPage openWebformPortal_Deere(WebDriver driver, String url) {
		driver.get(url);
		logger.log(LogStatus.PASS, "Opening Deere WebForm Portal");
		return new DeereLoginPage(driver);
	}

	// Entered description into Deere webform
	public Deere detailedDescription_Deere(Deere deer, String desc) {
		deereForm = deer.detailedDescription(desc);
		logger.log(LogStatus.PASS, "Entering description into Deere webform");
		return deereForm;
	}

	// Click on clear button
	public Deere clickOnClearButton(Deere deer) {
		deereForm = deer.clickOnClearButton();
		logger.log(LogStatus.PASS, "Clicking on clear button");
		return deereForm;
	}

	// Clicking on submit button
	public Deere clickOnSubmitButton(Deere deer) {
		deereForm = deer.clkSubmitButton();
		logger.log(LogStatus.PASS, "Clicking on submit button ");
		return deereForm;
	}

	// Get Case Id
	public Deere getCaseID(Deere deer) {
		deereForm = deer.GetCaseID();
		logger.log(LogStatus.PASS, " Getting caseId ");
		return deereForm;
	}

	// Clicking on submit button and verify Alert
	public Deere clickSbmtBtnAcptAlrt(Deere deer) {
		deereForm = deer.clkSubmitButton().alertAccept();
		logger.log(LogStatus.PASS, "Clicking on submit button and verifying Alert");
		return deereForm;
	}

	// Click on Clear button, Submit button
	public Deere clickOnClearBtnSubmitBtn(Deere deer) {
		deereForm = deer.clickOnClearButton().clkSubmitButton();
		logger.log(LogStatus.PASS, "Clicking on Clear button, Submit button");
		return deereForm;
	}

	// Login to webform
	public JDLinks openWebformPortal(WebDriver driver, String url) {
		driver.get(url);
		logger.log(LogStatus.PASS, "Opening JDLinks Form Portal");
		return new JDLinks(driver);
	}

	// Login to WebForm Portal
	public JDLinksWebFormSubmitionPage loginToWebform(JDLinks JDLink, String username, String password) {
		jdLinksWebFormSubmition = JDLink.enterUserName(username).enterPassword(password).clickSignInBtn();
		logger.log(LogStatus.PASS, "Logging in to WebForm portal");
		return jdLinksWebFormSubmition;
	}

	// Selecting the product DP value, Enter Detailed Description and Attaching
	// file
	public JDLinksWebFormSubmitionPage prodSltEntDetlDescAtchFile(
			JDLinksWebFormSubmitionPage jdLinksWebFormSubmitionPag, String desc) {
		jdLinksWebFormSubmition = jdLinksWebFormSubmitionPag.productSelection().detailedDescription(desc).uploadFile();
		logger.log(LogStatus.PASS, "Selecting the product DP value, Enter Detailed Description and Attaching file");
		return jdLinksWebFormSubmition;
	}

	// Selecting the Language, product DP value, Enter Detailed Description and
	// Attaching file
	public JDLinksWebFormSubmitionPage slctLangProdSltEntDetlDescAtchFile(
			JDLinksWebFormSubmitionPage jdLinksWebFormSubmitionPag, String desc) {
		jdLinksWebFormSubmition = jdLinksWebFormSubmitionPag.selectLanguage().productSelection()
				.detailedDescription(desc).uploadFile();
		logger.log(LogStatus.PASS,
				"Selecting the Language, product DP value, Enter Detailed Description and Attaching file");
		return jdLinksWebFormSubmition;
	}

	// Entering the WebForm Detailed_description
	public JDLinksWebFormSubmitionPage detailedDescription(JDLinksWebFormSubmitionPage jdLinksWebFormSubmitionPag,
			String desc) {
		jdLinksWebFormSubmition = jdLinksWebFormSubmitionPag.detailedDescription(desc);
		logger.log(LogStatus.PASS, "Entering  the WebForm Detailed_description ");
		return jdLinksWebFormSubmition;
	}

	// Click Submit button And Accept Alert
	public JDLinksWebFormSubmitionPage clickSubmitAndAcceptAlert(
			JDLinksWebFormSubmitionPage jdLinksWebFormSubmitionPag) {
		jdLinksWebFormSubmition = jdLinksWebFormSubmitionPag.clickOnSubmitButton().waitForAlert();
		logger.log(LogStatus.PASS, "Clicking on Submit button And Accept Alert");
		return jdLinksWebFormSubmition;
	}

	// Click on Submit Btn
	public JDLinksWebFormSubmitionPage clickOnSubmitButton(JDLinksWebFormSubmitionPage jdLinksWebFormSubmitionPag) {
		jdLinksWebFormSubmition = jdLinksWebFormSubmitionPag.clickOnSubmitButton();
		logger.log(LogStatus.PASS, "Clicking on Submit Btn");
		return jdLinksWebFormSubmition;
	}

	// Veryfing alert
	public JDLinksWebFormSubmitionPage waitForAlert(JDLinksWebFormSubmitionPage jdLinksWebFormSubmitionPag) {
		jdLinksWebFormSubmition = jdLinksWebFormSubmitionPag.waitForAlert();
		logger.log(LogStatus.PASS, "Veryfing alert");
		return jdLinksWebFormSubmition;
	}

	// Click on Clear button
	public JDLinksWebFormSubmitionPage clickOnClearButton(JDLinksWebFormSubmitionPage jdLinksWebFormSubmitionPag) {
		jdLinksWebFormSubmition = jdLinksWebFormSubmitionPag.clickOnClearButton();
		logger.log(LogStatus.PASS, "Clicking on clear button ");
		return jdLinksWebFormSubmition;
	}

	// Click on Clear button, Submit button and verify Alert
	public JDLinksWebFormSubmitionPage clickOnClearBtnSubmitBtnAcceptAlert(
			JDLinksWebFormSubmitionPage jdLinksWebFormSubmitionPag) {
		jdLinksWebFormSubmition = jdLinksWebFormSubmitionPag.clickOnClearButton().clickOnSubmitButton().waitForAlert();
		logger.log(LogStatus.PASS, "Clicking on Clear button, Submit button and verifying Alert");
		return jdLinksWebFormSubmition;
	}

	// Get Case Id
	public JDLinksWebFormSubmitionPage getCaseID(JDLinksWebFormSubmitionPage jdLinksWebFormSubmitionPag) {
		jdLinksWebFormSubmition = jdLinksWebFormSubmitionPag.getCaseID();
		logger.log(LogStatus.PASS, "CaseId is generated successfully");
		return jdLinksWebFormSubmition;
	}

	// Get Case Id in spanish
	public JDLinksWebFormSubmitionPage getCaseIDSpanish(JDLinksWebFormSubmitionPage jdLinksWebFormSubmitionPag) {
		jdLinksWebFormSubmition = jdLinksWebFormSubmitionPag.getCaseIDSpanish();
		logger.log(LogStatus.PASS, "CaseId is generated successfully");
		return jdLinksWebFormSubmition;
	}

	// Uplaoding file
	public JDLinksWebFormSubmitionPage addButton(JDLinksWebFormSubmitionPage jdLinksWebFormSubmitionPag) {
		jdLinksWebFormSubmition = jdLinksWebFormSubmitionPag.uploadFile();
		logger.log(LogStatus.PASS, "Uploading file is  successful");
		return jdLinksWebFormSubmition;
	}

	// Opening StellarSupport Form Portal
	public StellarSupport openWebFormPortal(WebDriver driver, String url) {
		driver.get(url);
		logger.log(LogStatus.PASS, "Opening StellarSupport Form Portal");
		return new StellarSupport(driver);
	}

	// Logged in to web form
	public StellarSupportWebformSubmissionPage logintoWebform(StellarSupport stellarSupportPag, String username,
			String password) {
		stellarSupportWebformSubmission = stellarSupportPag.enterUserName(username).enterPassword(password)
				.clickSignInBtn();
		logger.log(LogStatus.PASS, "Logging in to web form");
		return stellarSupportWebformSubmission;
	}

	// Click on Clear button, Submit button and verify Alert
	public StellarSupportWebformSubmissionPage clickOnClearBtnSubmitBtnAcceptAlert(
			StellarSupportWebformSubmissionPage stellarSupportWebformSubmissionPag) {
		stellarSupportWebformSubmission = stellarSupportWebformSubmissionPag.clickOnClearButton().clickSubmit()
				.waitForAlert();
		logger.log(LogStatus.PASS, "Clicking on Clear button Submit button Accept Alert");
		return stellarSupportWebformSubmission;
	}

	// Entered Stellar support Detailed Description and Attaching file
	public StellarSupportWebformSubmissionPage detailedDescriptionAndAttachFile(
			StellarSupportWebformSubmissionPage stellarSupportWebformSubmissionPag, String desc) {
		stellarSupportWebformSubmission = stellarSupportWebformSubmissionPag.detailedDescription(desc).uploadFile();
		logger.log(LogStatus.PASS, "Entering Stellar support Detailed Description and Attaching file");
		return stellarSupportWebformSubmission;
	}

	// click Submit btn
	public StellarSupportWebformSubmissionPage clickSubmit(
			StellarSupportWebformSubmissionPage stellarSupportWebformSubmissionPag) {
		stellarSupportWebformSubmission = stellarSupportWebformSubmissionPag.clickSubmit();
		logger.log(LogStatus.PASS, "Clicking on Submit Button");
		return stellarSupportWebformSubmission;
	}

	// click Submit btn And verify Alert
	public StellarSupportWebformSubmissionPage clickSubmitAndAcceptAlert(
			StellarSupportWebformSubmissionPage stellarSupportWebformSubmissionPag) {
		stellarSupportWebformSubmission = stellarSupportWebformSubmissionPag.clickSubmit().waitForAlert();
		logger.log(LogStatus.PASS, "Clicking on Submit Button And verifying Alert");
		return stellarSupportWebformSubmission;
	}

	// Get CaseID
	public StellarSupportWebformSubmissionPage getCaseID(
			StellarSupportWebformSubmissionPage stellarSupportWebformSubmissionPag) {
		stellarSupportWebformSubmission = stellarSupportWebformSubmissionPag.getCaseID();
		logger.log(LogStatus.PASS, "CaseID is generated successfully");
		return stellarSupportWebformSubmission;
	}

	// Verifying alert.
	public StellarSupportWebformSubmissionPage waitForAlert(
			StellarSupportWebformSubmissionPage stellarSupportWebformSubmissionPag) {
		stellarSupportWebformSubmission = stellarSupportWebformSubmissionPag.waitForAlert();
		logger.log(LogStatus.PASS, "Accepting Alert");
		return stellarSupportWebformSubmission;
	}

	// Logging into webforms
	public SouthSahara logintoSouthSaharaWebform(SouthSaharaLoginPage southSaharaLoginPag, String username,
			String password) {
		southSaharaForm = southSaharaLoginPag.enterUserName(username).enterPassword(password).clickSignInBtn();
		logger.log(LogStatus.PASS, "Logging into web form");
		return southSaharaForm;
	}

	// opening webform
	public SouthSaharaLoginPage openWebformPortal_SouthSahara(WebDriver driver, String url) {
		driver.get(url);
		logger.log(LogStatus.PASS, "Opening SouthSahara WebForm Portal");
		return new SouthSaharaLoginPage(driver);
	}

	// Enter Detailed Description and Attaching file
	public SouthSahara detailedDescriptionAndAttachFile(SouthSahara southSaharPag, String desc) {
		southSaharaForm = southSaharPag.detailedDescription(desc).uploadFile();
		logger.log(LogStatus.PASS, "Entering description into SouthSahara webform and attaching file");
		return southSaharaForm;
	}

	// Click Submit button And Accept Alert
	public SouthSahara clickSubmitAndAcceptAlert(SouthSahara southSaharPag) {
		southSaharaForm = southSaharPag.clickSubmitBtn().waitForAlert();
		logger.log(LogStatus.PASS, "Clicking on Submit button and verifying the alert");
		return southSaharaForm;
	}

	// click on Submit
	public SouthSahara clickSubmitBtn(SouthSahara southSaharPag) {
		southSaharaForm = southSaharPag.clickSubmitBtn();
		logger.log(LogStatus.PASS, "Clicking on Submit button");
		return southSaharaForm;
	}

	// Verifying alert
	public SouthSahara waitForAlert(SouthSahara southSaharPag) {
		southSaharaForm = southSaharPag.waitForAlert();
		logger.log(LogStatus.PASS, " Verifying alert");
		return southSaharaForm;
	}

	// Click on Clear button
	public SouthSahara clickOnClearButton(SouthSahara southSaharPag) {
		southSaharaForm = southSaharPag.clickOnClearButton();
		logger.log(LogStatus.PASS, "Clicking on clear button .");
		return southSaharaForm;
	}

	// Get Case Id
	public SouthSahara getCaseID(SouthSahara southSaharPag) {
		southSaharaForm = southSaharPag.getCaseID();
		logger.log(LogStatus.PASS, "CaseId is generated successfully");
		return southSaharaForm;
	}

	// Click on Clear button, Submit button and Accept Alert
	public SouthSahara clickOnClearBtnSubmitBtnAcceptAlert(SouthSahara southSaharPag) {
		southSaharaForm = southSaharPag.clickOnClearButton().clickSubmitBtn().waitForAlert();
		logger.log(LogStatus.PASS, "Clicking on clear and submit button and veryfing the alert");
		return southSaharaForm;
	}

	// Logging into webforms
	public India loginToIndiaWebform(IndiaLoginPage indiaLoginPag, String username, String password) {
		indiaForm = indiaLoginPag.enterUserName(username).enterPassword(password).clickSignInBtn();
		logger.log(LogStatus.PASS, "Logging into web form");
		return indiaForm;
	}

	// Opening India Form Portal
	public IndiaLoginPage openWebformPortal_India(WebDriver driver, String url) {
		driver.get(url);
		logger.log(LogStatus.PASS, "Opening India Form Portal");
		return new IndiaLoginPage(driver);
	}

	// Entering the WebForm Detailed_description and Attaching file
	public India detailedDescriptionAndAttachFile(India indi, String desc) {
		indiaForm = indi.detailedDescription(desc).uploadFile();
		logger.log(LogStatus.PASS, "Entering data into detailed description and Attaching file");
		return indiaForm;
	}

	// Attaching file to WebForm
	public India addButton(India indi) {
		indiaForm = indi.uploadFile();
		logger.log(LogStatus.PASS, "Attaching a file is successful");
		return indiaForm;
	}

	// Click on Clear button, Submit button and Accept Alert
	public India clickOnClearBtnSubmitBtnAcceptAlert(India indi) {
		indiaForm = indi.clickOnClearButton().clickSubmitBtn().waitForAlert();
		logger.log(LogStatus.PASS, "Clicking on Clear button, Submit button and Accept Alert");
		return indiaForm;
	}

	// click on clear button
	public India clickOnClearButton(India indi) {
		indiaForm = indi.clickOnClearButton();
		logger.log(LogStatus.PASS, "Clicking on clear button");
		return indiaForm;
	}

	// Click Submit button And Accept Alert
	public India clickSubmitAndAcceptAlert(India indi) {
		indiaForm = indi.clickSubmitBtn().waitForAlert();
		logger.log(LogStatus.PASS, "Clicking on Submit button");
		return indiaForm;
	}

	// Click on Submit Btn
	public India clickSubmitBtn(India indi) {
		indiaForm = indi.clickSubmitBtn();
		logger.log(LogStatus.PASS, "Clicking on Submit button");
		return indiaForm;
	}

	// Verify Alert
	public India waitForAlert(India indi) {
		indiaForm = indi.waitForAlert();
		logger.log(LogStatus.PASS, "Accepting Alert");
		return indiaForm;
	}

	// Get CaseId
	public India getCaseID(India indi) {
		indiaForm = indi.getCaseID();
		logger.log(LogStatus.PASS, "CaseId is generated successfully");
		return indiaForm;
	}

	// Opening GreenFleet Form Portal
	public GreenFleetWebFormSubmissionPage greenFleetWebForm(WebDriver driver, String url) {
		driver.get(url);
		logger.log(LogStatus.PASS, "Opening GreenFleet Form Portal");
		return new GreenFleetWebFormSubmissionPage(driver);
	}

	// Logged into web form
	public GreenFleetWebFormSubmissionPage loginToWebform(
			GreenFleetWebFormSubmissionPage greenFleetWebFormSubmissionPag, String username, String password) {
		greenFleetWebFormSubmission = greenFleetWebFormSubmissionPag.enterUserName(username).enterPassword(password)
				.clickSignInBtn();
		logger.log(LogStatus.PASS, "Logging into web form");
		return greenFleetWebFormSubmission;
	}

	// Entering greenfleet number
	public GreenFleetWebFormSubmissionPage greenFleetNumber(GreenFleetWebFormSubmissionPage greenFleetWebFormSubmission,
			String number) {
		greenFleetWebFormSubmission = greenFleetWebFormSubmission.greenFleetNumber(number);
		logger.log(LogStatus.PASS, "entering greenfleet number");
		return greenFleetWebFormSubmission;
	}

	// Entered Green Fleet Detailed Description
	public GreenFleetWebFormSubmissionPage detailedDescription(
			GreenFleetWebFormSubmissionPage greenFleetWebFormSubmissionPag, String desc) {
		greenFleetWebFormSubmission = greenFleetWebFormSubmissionPag.detailedDescription(desc);
		logger.log(LogStatus.PASS, "Entering Green Fleet Detailed Description");
		return greenFleetWebFormSubmission;
	}

	// Entering Greenfleet serial number
	public GreenFleetWebFormSubmissionPage greenFleetMachineSerial(
			GreenFleetWebFormSubmissionPage greenFleetWebFormSubmissionPag, String number) {
		greenFleetWebFormSubmission = greenFleetWebFormSubmissionPag.greenFleetMachineSerial(number);
		logger.log(LogStatus.PASS, "entering greenfleet serial machine");
		return greenFleetWebFormSubmission;
	}

	// Entering GreenFleet comment
	public GreenFleetWebFormSubmissionPage enterComment(GreenFleetWebFormSubmissionPage greenFleetWebFormSubmissionPag,
			String comment) {
		greenFleetWebFormSubmission = greenFleetWebFormSubmissionPag.greenFleetEnterComment(comment);
		logger.log(LogStatus.PASS, "entering greenfleet comment");
		return greenFleetWebFormSubmission;
	}

	// Entering dealer name
	public GreenFleetWebFormSubmissionPage enterDealerName(
			GreenFleetWebFormSubmissionPage greenFleetWebFormSubmissionPag, String name) {
		greenFleetWebFormSubmission = greenFleetWebFormSubmissionPag.enterDealerName(name);
		logger.log(LogStatus.PASS, "entering dealer name");
		return greenFleetWebFormSubmission;
	}

	// Entering dealer state
	public GreenFleetWebFormSubmissionPage enterDealerState(
			GreenFleetWebFormSubmissionPage greenFleetWebFormSubmissionPag, String state) {
		greenFleetWebFormSubmission = greenFleetWebFormSubmissionPag.enterDealerState(state);
		logger.log(LogStatus.PASS, "entering  dealer state");
		return greenFleetWebFormSubmission;
	}

	// Entering dealer city
	public GreenFleetWebFormSubmissionPage enterDealerCity(
			GreenFleetWebFormSubmissionPage greenFleetWebFormSubmissionPag, String city) {
		greenFleetWebFormSubmission = greenFleetWebFormSubmissionPag.enterDealerCity(city);
		logger.log(LogStatus.PASS, "entering dealer city");
		return greenFleetWebFormSubmission;
	}

	// Uploading Attachment file
	public GreenFleetWebFormSubmissionPage addAttachment(
			GreenFleetWebFormSubmissionPage greenFleetWebFormSubmissionPag) {
		greenFleetWebFormSubmission = greenFleetWebFormSubmissionPag.addAttachment();
		logger.log(LogStatus.PASS, "Uploading attachment file");
		return greenFleetWebFormSubmission;
	}

	// clicking on Submit Btn
	public GreenFleetWebFormSubmissionPage clickSubmitBtn(
			GreenFleetWebFormSubmissionPage greenFleetWebFormSubmissionPag) {
		greenFleetWebFormSubmission = greenFleetWebFormSubmissionPag.clickSubmitBtn();
		logger.log(LogStatus.PASS, "clicking on Submit Btn");
		return greenFleetWebFormSubmission;
	}

	// Store CaseID
	public GreenFleetWebFormSubmissionPage getCaseID(GreenFleetWebFormSubmissionPage greenFleetWebFormSubmissionPag) {
		greenFleetWebFormSubmission = greenFleetWebFormSubmissionPag.getCaseID();
		logger.log(LogStatus.PASS, "Storing CaseID");
		return greenFleetWebFormSubmission;
	}

	// click On Clear Button
	public GreenFleetWebFormSubmissionPage clickOnClearButton(
			GreenFleetWebFormSubmissionPage greenFleetWebFormSubmissionPag) {
		greenFleetWebFormSubmission = greenFleetWebFormSubmissionPag.clickOnClearButton();
		logger.log(LogStatus.PASS, "Clicking On Clear Button");
		return greenFleetWebFormSubmission;
	}

	// Verifying Alert
	public GreenFleetWebFormSubmissionPage waitForAlert(
			GreenFleetWebFormSubmissionPage greenFleetWebFormSubmissionPag) {
		greenFleetWebFormSubmission = greenFleetWebFormSubmissionPag.waitForAlert();
		logger.log(LogStatus.PASS, "Verifying Alert");
		return greenFleetWebFormSubmission;
	}

	// Enter data into Detailed Description field and Attach file
	public GreenFleetWebFormSubmissionPage detailedDescriptionAndAttachFile(
			GreenFleetWebFormSubmissionPage greenFleetWebFormSubmission, String desc) {
		greenFleetWebFormSubmission = greenFleetWebFormSubmission.detailedDescription(desc).addAttachment();
		logger.log(LogStatus.PASS, "Entering data into Detailed Description field and Attaching file");
		return greenFleetWebFormSubmission;
	}

	// Click on Clear button, Submit button and Accept Alert
	public GreenFleetWebFormSubmissionPage clickOnClearBtnSubmitBtnAcceptAlert(
			GreenFleetWebFormSubmissionPage greenFleetWebFormSubmissionPag) {
		greenFleetWebFormSubmission = greenFleetWebFormSubmissionPag.clickOnClearButton().clickSubmitBtn()
				.waitForAlert();
		logger.log(LogStatus.PASS, "Clicking On Clear Button");
		return greenFleetWebFormSubmission;
	}

	// Click Submit button And Accept Alert
	public GreenFleetWebFormSubmissionPage clickSubmitAndAcceptAlert(
			GreenFleetWebFormSubmissionPage greenFleetWebFormSubmissionPag) {
		greenFleetWebFormSubmission = greenFleetWebFormSubmissionPag.clickSubmitBtn().waitForAlert();
		logger.log(LogStatus.PASS, "clicking on Submit Btn and verifying alert");
		return greenFleetWebFormSubmission;
	}

	// Click on submit button
	public Agronomy clickSubmitBtn(Agronomy agronom) {
		agronomyForm = agronom.clickSubmitBtn();
		logger.log(LogStatus.PASS, " Clicking  on submit button ");
		return agronomyForm;
	}

	// logging into WebForm
	public Agronomy loginToAgrWebform(AgronomyLoginPage agronomyLoginPag, String username, String password) {
		agronomyForm = agronomyLoginPag.enterUserName(username).enterPassword(password).clickSignInBtn();
		logger.log(LogStatus.PASS, "Logging into web form");
		return agronomyForm;
	}

	// opening form portal
	public AgronomyLoginPage openWebformPortal_Agr(WebDriver driver, String url) {
		driver.get(url);
		logger.log(LogStatus.PASS, "Opening Agronomy Web Form Portal");
		return new AgronomyLoginPage(driver);
	}

	// Enter Detailed Description and Attaching file
	public Agronomy detailedDescriptionAttachFile(Agronomy agronomyPag, String desc) {
		agronomyForm = agronomyPag.detailedDescription(desc).addButton();
		logger.log(LogStatus.PASS, "Entering Detailed Description and Attaching file");
		return agronomyForm;
	}

	// Entered description into Agronomy webform
	public Agronomy detailedDescriptionAgr(Agronomy agronomyPag, String desc) {
		agronomyForm = agronomyPag.detailedDescription(desc);
		logger.log(LogStatus.PASS, "Entering description into Agronomy webform");
		return agronomyForm;
	}

	// Attaching file to Agronomy Form
	public Agronomy addButton(Agronomy agronomyPag) {
		agronomyForm = agronomyPag.addButton();
		logger.log(LogStatus.PASS, "Attaching file to Agronomy Form");
		return agronomyForm;
	}

	// Click on Clear button
	public Agronomy clickOnClearButton(Agronomy agronomyPag) {
		agronomyForm = agronomyPag.clickOnClearButton();
		logger.log(LogStatus.PASS, "Clicking on clear button is sucessful");
		return agronomyForm;
	}

	// Get Case Id
	public Agronomy getCaseID(Agronomy agronomyPag) {
		agronomyForm = agronomyPag.getCaseID();
		logger.log(LogStatus.PASS, "CaseId is generated successfully ");
		return agronomyForm;
	}

	// switch and click on Alert box
	public Agronomy waitForAlert(Agronomy agronomyPag) {
		agronomyForm = agronomyPag.waitForAlert();
		logger.log(LogStatus.PASS, "Clicking on  Alert box accept button");
		return agronomyForm;
	}

	// Click Submit button And Accept Alert
	public Agronomy clickSubmitAndAcceptAlert(Agronomy agronomyPag) {
		agronomyForm = agronomyPag.clickSubmitBtn().waitForAlert();
		logger.log(LogStatus.PASS, " Clicking  on submit button ");
		return agronomyForm;
	}

	// Click on Clear button, Submit button and Accept Alert
	public Agronomy clickOnClearBtnSubmitBtnAcceptAlert(Agronomy agronomyPag) {
		agronomyForm = agronomyPag.clickOnClearButton().clickSubmitBtn().waitForAlert();
		logger.log(LogStatus.PASS, "Clicking on Clear button, Submit button and Accept Alert");
		return agronomyForm;
	}

	// Logging into webforms
	public SouthEastAsia logintoSouthEastAsiaWebform(SouthEastAsiaLoginPage southEastAsiaLoginPag, String username,
			String password) {
		southEastAsiaForm = southEastAsiaLoginPag.enterUserName(username).enterPassword(password).clickSignInBtn();
		logger.log(LogStatus.PASS, "Logging into web form");
		return southEastAsiaForm;
	}

	// click on Submit button and Accept Alert
	public SouthEastAsia clickSubmitBtnAndAcceptAlert(SouthEastAsia southEast) {
		southEastAsiaForm = southEast.clickSubmitBtn().waitForAlert();
		logger.log(LogStatus.PASS, "Clicking on Submit button and Accept Alert");
		return southEastAsiaForm;
	}

	// Verify Accept
	public SouthEastAsia waitForAlert(SouthEastAsia southEast) {
		southEastAsiaForm = southEast.waitForAlert();
		logger.log(LogStatus.PASS, "Verifying alert");
		return southEastAsiaForm;
	}

	// Click on Clear button, Submit button and Accept Alert
	public SouthEastAsia clickOnClearBtnSubmitBtnAcceptAlert(SouthEastAsia southEast) {
		southEastAsiaForm = southEast.clickOnClearButton().clickSubmitBtn().waitForAlert();
		logger.log(LogStatus.PASS, "Clicking on Clear button, Submit button and Accept Alert");
		return southEastAsiaForm;
	}

	// Switch to frame
	public ISGCasePage switchToFrame(ISGCasePage isgCasePag) {
		isgCase = isgCasePag.switchToFrame1();
		logger.log(LogStatus.PASS, "Switching to frame");
		return isgCase;
	}

	// Click on Action Button Then click on WorkCase And Accept Button
	public ISGCasePage clickOnActionsBtnThenWorkCaseAndAcceptBtn(ISGCasePage isgCasePag) {
		isgCase = isgCasePag.clickActionsBtn().clickWorkcase().clickAcceptBtn();
		logger.log(LogStatus.PASS, "Clicking on Action Button then WorkCase And Accept Button");
		return isgCase;
	}

	// Click on Action Button
	public ISGCasePage clickOnActionsBtn(ISGCaseSearchPage isgCaseSearchPag) {
		isgCase = isgCaseSearchPag.clickOnActionsBtn();
		logger.log(LogStatus.PASS, "Clicking on Action Button");
		return isgCase;
	}

	// Click on Work Case
	public ISGCasePage clickOnWorkCase(ISGCaseSearchPage isgCaseSearchPag) {
		isgCase = isgCaseSearchPag.clickOnWorkCase();
		logger.log(LogStatus.PASS, "Clicking on Work Case");
		return isgCase;
	}

	// Entering the Case Id in Case Search Box
	public ISGCaseSearchPage enterCaseID(ISGCaseSearchPage isgCaseSearchPag, String caseId) {
		isgCaseSearch = isgCaseSearchPag.enterCaseIDInCaseSearchBox(caseId);
		logger.log(LogStatus.PASS, "Entering the Case Id in Case Search Box");
		return isgCaseSearch;
	}

	// Click on GSC case
	public GSCCustomerSearch clickonGSCCase(GSCCustomerSearch gscCustomerSrch) {
		gscCustomerSerch = gscCustomerSrch.clickOnGSCCase();
		logger.log(LogStatus.PASS, "Clicking on GSC case");
		return gscCustomerSerch;
	}

	// click on Add Customer Info icon
	public GSCCustomerSearch clickAddCustomeInfoDetails(GSCCustomerSearch gscCustomerSrch) {
		gscCustomerSerch = gscCustomerSrch.clickOnAddCustomeInfoIcon();
		logger.log(LogStatus.PASS, "Clicking on Add customer Info icon");
		return gscCustomerSerch;
	}

	// enter business zipdetails
	public GSCCustomerSearch enterBusinessZipDetails(GSCCustomerSearch gscCustomerSrch, String business, String code) {
		gscCustomerSerch = gscCustomerSrch.enterBusiness(business).enterZip(code).clickOnReset();
		logger.log(LogStatus.PASS, "Clicking on GSC case");
		return gscCustomerSerch;
	}

	// Enter customer details for GSC case creation and click on accept button
	public GSCCustomerSearch enterGSCCustomerDetails(GSCCustomerSearch gscCustomerSrch, String custFirstName,
			String custLastName, String country, String model, String fArea, String fCode, String priority,
			String language, String origin, String summary, String workbasket) {
		gscCustomerSerch = gscCustomerSrch.clickOnAddCustomeInfoIcon().enterCustomerFirstName(custFirstName)
				.enterCustomerLastName(custLastName).selectCountry(country).clickGscSearchCustomerBtn()
				.clickSearchCustomerDetails().clickOnAddProductInfo().enterProductModel(model).clickAddProductSubmit()
				.enterCasecodingFA(fArea).enterCasecodingFC(fCode).enterPriority(priority).enterLanguage(language)
				.enterOrigin(origin).enterAddSummary(summary).selectWorkBasket(workbasket).clickOnAcceptBtn();
		logger.log(LogStatus.PASS, "Entering GSC Customer details and clicking on accept button ");
		return gscCustomerSerch;
	}

	// Navigate to Home page
	public HomePage navigateToHomeMenu(NavigationClass navigationcls) {
		home = navigationcls.clickOnHome();
		logger.log(LogStatus.PASS, "Navigating to home page");
		return home;
	}

	// click on GSC case from homepage
	public GSCCustomerSearch clickOnGSCCaseBtn(HomePage homePag) {
		gscCustomerSearchPage = homePag.clickonGSCCase();
		logger.log(LogStatus.PASS, "Clicking on GSC case button");
		return gscCustomerSearchPage;
	}

	// Click on close button
	public GSCCustomerSearch clickOnCloseBtn(GSCCustomerSearch gscCustomerSrch) {
		gscCustomerSerch = gscCustomerSrch.clickOnCloseBtn();
		logger.log(LogStatus.PASS, "Clicking on close button");
		return gscCustomerSerch;
	}

	/*
	 * // enter details of a customer business zipdetails public GSCCustomerSearch
	 * enterBusinessZipField(GSCCustomerSearch gscCustomerSrch, String business,
	 * String code, String custFirstName, String custLastName, String country) {
	 * gscCustomerSerch =
	 * gscCustomerSrch.enterBusiness(business).enterZip(code).enterCustomerFirstName
	 * (custFirstName) .enterCustomerLastName(custLastName).selectCountry(country).
	 * clickGscSearchCustomerBtn() .gscCustomerDetails(); logger.log(LogStatus.PASS,
	 * "entering data for business & zip field"); return gscCustomerSerch; }
	 */

	// enter customer details and click on search button and click on details
	// customer link and validate it.
	public GSCCustomerSearch customerSearchValidation(GSCCustomerSearch gscCustomerSrch, String country,
			String custFirstName, String custLastName) {
		gscCustomerSerch = gscCustomerSrch.selectCountry(country).enterCustomerFirstNameValidation(custFirstName)
				.enterCustomerLastName(custLastName).clickGscSearchCustomerBtn().gscCustomerDetails();
		logger.log(LogStatus.PASS, "entering data and click on search button then click on details customer link");
		return gscCustomerSerch;
	}

	// enter customer details and click on search button and click on details
	// customer link and validate it.
	public GSCCustomerSearch customerSearchPanelValidation(GSCCustomerSearch gscCustomerSrch, String country,
			String custFirstName, String custLastName) {
		gscCustomerSerch = gscCustomerSrch.selectCountrySwitchToFrame(country)
				.enterCustomerFirstNameValidation(custFirstName).enterCustomerLastName(custLastName)
				.clickGscSearchCustomerBtn().clickSearchCustomerDetails();
		logger.log(LogStatus.PASS, "entering data and click on search button then click on details customer link");
		return gscCustomerSerch;
	}

	// Click on Back button, click on customer details link .
	public GSCCustomerSearch clkBakBtnCustDtlsLink(GSCCustomerSearch gscCustomerSrch) {
		gscCustomerSerch = gscCustomerSrch.clickOnBackBtn().clickSearchCustomerDetails();
		logger.log(LogStatus.PASS, "Clicking on back button and then clicking on customer details ");
		return gscCustomerSerch;
	}

	// Click on Back button, click on customer details link .
	public GSCCustomerSearch clickOnCustomerLink(GSCCustomerSearch gscCustomerSrch) {
		gscCustomerSerch = gscCustomerSrch.clickChangeCustomerLink();
		logger.log(LogStatus.PASS, "entering data and click on search button then click on details customer link");
		return gscCustomerSerch;
	}

	// Click on clear customer
	public GSCCustomerSearch clickOnClearCustomer(GSCCustomerSearch gscCustomerSrch) {
		gscCustomerSerch = gscCustomerSrch.clickCustomerClear();
		logger.log(LogStatus.PASS, "Clickimg on clear customer for clearing the data in customer search");
		return gscCustomerSerch;
	}

	// Click on Accept Button
	public GSCCustomerSearch clickOnAccept(GSCCustomerSearch gscCustomerSrch) {
		gscCustomerSerch = gscCustomerSrch.clickOnAcceptBtn();
		logger.log(LogStatus.PASS, "clicking on Accept button");
		return gscCustomerSerch;
	}

	// click on actions, reopen button
	public GSCCustomerSearch clickOnActionReopenBtn(GSCCustomerSearch gscCustomerSrch) {
		gscCustomerSerch = gscCustomerSrch.clickOnActionsBtn().clickOnReopenBtn();
		logger.log(LogStatus.PASS, "Clicking on actions->reopen button");
		return gscCustomerSerch;
	}

	// Enter Add Summary and select workbasket
	public GSCCustomerSearch enterAddSummary(GSCCustomerSearch gscCustomerSrch, String summary, String workbasket) {
		gscCustomerSerch = gscCustomerSrch.enterAddSummary(summary).selectWorkBasket(workbasket);
		logger.log(LogStatus.PASS, "Entering details in summary and selecting workbasket");
		return gscCustomerSerch;
	}

	// click on close button
	public GSCCustomerSearch clickOnClose(GSCCustomerSearch gscCustomerSrch) {
		gscCustomerSerch = gscCustomerSrch.clickOnCloseBtn();
		logger.log(LogStatus.PASS, "Clicking on close button");
		return gscCustomerSerch;
	}

	// click on cancel button
	public GSCCustomerSearch clickOnCancelButton(GSCCustomerSearch gscCustomerSrch) {
		gscCustomerSearchPage = gscCustomerSrch.clickCancelBtn();
		logger.log(LogStatus.PASS, "Clicking on  cancel button ");
		return gscCustomerSearchPage;
	}

	// click on action button
	public GSCCustomerSearch clickOnAction(GSCCustomerSearch gscCustomerSrch) {
		gscCustomerSearchPage = gscCustomerSrch.clickOnAction();
		logger.log(LogStatus.PASS, "clicking on Action button");
		return gscCustomerSearchPage;
	}

	// Click on addCustomer Info Link
	public ISGCasePage isgAddCustomerInfo(ISGCasePage isgCasePag) {
		isgCase = isgCasePag.clickAddCustomerInfo();
		logger.log(LogStatus.PASS, "Clicking on addCustomer Info Link ");
		return isgCase;
	}

	// Entered customer details for ISG case creation and click on accept button
	public ISGCasePage isgEnterCaseCreationDetails(ISGCasePage isgCasePag, String countryCode, String firstName,
			String lastName, String model, String func_area, String func_code, String priority, String orign,
			String summar) {
		isgCase = isgCasePag.clickAddCustomerInfo().enterCountryCode(countryCode).enterFirstName(firstName)
				.enterLastName(lastName).clickCustomerSearch().clickRadioButton().clickCustomerSubmitButton()
				.clickAddProductInfo().enterModel(model).clickProductSubmitButton().selFunctionalArea(func_area)
				.functionalCode(func_code).selPriority(priority).selOrigin(orign).enterSummary(summar)
				.clickAcceptButton();
		logger.log(LogStatus.PASS, "Entering Customer details for ISG Case Creation and clicking on Accept Button");
		return isgCase;
	}
	
	public ISGCasePage isgEnterCaseCreationDetailsRouting(ISGCasePage isgCasePag, String countryCode, String firstName,
			String lastName) {
		isgCase = isgCasePag.clickAddCustomerInfo().enterCountryCode(countryCode).enterFirstName(firstName)
				.enterLastName(lastName).clickCustomerSearch().clickRadioButton().clickCustomerSubmitButton();
		logger.log(LogStatus.PASS, "Entering Customer details for ISG Case Creation and clicking on Accept Button");
		return isgCase;
	}
	
	// Entered customer details for ISG case creation and click on accept button
		public ISGCasePage isgEnterCaseCreationDetailsForLanguage(ISGCasePage isgCasePag, String countryCode, String firstName,
				String lastName, String model, String func_area, String func_code, String priority, String orign,
				String summar) {
			isgCase = isgCasePag.clickAddCustomerInfo().enterCountryCode(countryCode).enterFirstName(firstName)
					.enterLastName(lastName).clickCustomerSearch().clickRadioButton().clickCustomerSubmitButton()
					.clickAddProductInfo().enterModel(model).clickProductSubmitButton().selFunctionalArea(func_area)
					.functionalCode(func_code).selPriority(priority).selOrigin(orign).enterSummary(summar)
					.clickAcceptButton();
			logger.log(LogStatus.PASS, "Entering Customer details for ISG Case Creation and clicking on Accept Button");
			return isgCase;
		}

	// Entered customer details for ISG case creation for Routing and click on
	// accept button
	public ISGCasePage isgEnterCaseCreationDetailsForRouting(ISGCasePage isgCasePag, String countryCode,
			String firstName, String lastName) {
		isgCase = isgCasePag.clickAddCustomerInfo().enterCountryCode(countryCode).enterFirstName(firstName)
				.enterLastName(lastName).clickCustomerSearch().clickRadioButton().clickCustomerSubmitButton()
				.clickAddProductInfo();
		logger.log(LogStatus.PASS, "Entering Customer details for ISG Case Creation and clicking on Accept Button");
		return isgCase;
	}

	// click on Action Button-> select reopen option for isg case
	public ISGCasePage clickActionBtnSelectReopenOption(ISGCasePage isgCasePag) {
		isgCase = isgCasePag.clickActionsBtn().clickReopenBtn();
		logger.log(LogStatus.PASS, "Clicking on Action button and selecting Reopen option");
		return isgCase;
	}

	// Click on ISG case
	public ISGCasePage navToISGCasePage(HomePage homePag) {
		isgCase = homePag.clickCreateISGCase();
		logger.log(LogStatus.PASS, " Clicking on ISG case ");
		return isgCase;
	}

	public ISGCasePage navToISGCasePageTranToWB(HomePage homePag) {
		isgCase = homePag.clickCreateISGCaseForTranToWB();
		logger.log(LogStatus.PASS, " Clicking on ISG case ");
		return isgCase;
	}

	// click on action, Tss reopen->Workcase option for isg case
	public ISGCasePage selectWorkCaseFrmAction(ISGCasePage isgCasePag) {
		isgCase = isgCasePag.clickOnActionWorkcase();
		logger.log(LogStatus.PASS, "Clicking on Action, selecting  Reopen and selecting Workcase option");
		return isgCase;
	}

	// Click on cancel button
	public ISGCasePage clickOnCancelButton(ISGCasePage isgCasePag) {
		isgCase = isgCasePag.clickCancelBtn();
		logger.log(LogStatus.PASS, "Clicking on  cancel button ");
		return isgCase;
	}

	// click on action, reopen button for gsc case
	public GSCCustomerSearch clickOnActionWorkCase(GSCCustomerSearch gscCustomerSrch) {
		gscCustomerSearchPage = gscCustomerSrch.clickOnActionsBtn().clickonTSS().clickOnWorkCase();
		logger.log(LogStatus.PASS, "Clicking on Action,Reopen button");
		return gscCustomerSearchPage;
	}

	// Click on RadioButton
	public ISGCasePage isgClickRadioButton(ISGCasePage isgCasePag) {
		isgCase = isgCasePag.clickRadioButton();
		logger.log(LogStatus.PASS, "Clicking on RadioButton");
		return isgCase;
	}

	// Click on close button
	public ISGCasePage clickOnCloseBtn(ISGCasePage isgCasePag) {
		isgCase = isgCasePag.clickClose();
		logger.log(LogStatus.PASS, "Clicking on close button");
		return isgCase;
	}

	// Clicking on Action button.
	public ISGCasePage isgActionsButton(ISGCasePage isgCasePag) {
		isgCase = isgCasePag.isgClickActionsButton();
		logger.log(LogStatus.PASS, "Clicking on Actions button ");
		return isgCase;
	}

	// Clicking on Action -> transfer to WB-> click on Submit button and expand
	// audit history.
	public ISGCasePage isgClkActionsTrToWBAudtButton(ISGCasePage isgCasePag, String value) {
		isgCase = isgCasePag.isgClickActionsButton().isgClickTransferToWButton().enterToTransferWB(value)
				.clickTransferButton().isgExpandAuditHistory();
		logger.log(LogStatus.PASS,
				"Clicking on Actions,transfer to WB , click on submit button and expand audit history");
		return isgCase;
	}

	// Navigate to Homepage
	public HomePage navigateHomePage(NavigationClass navigationclss) {
		home = navigationclss.clickHomeMenuButton();
		logger.log(LogStatus.PASS, "Navigating to home page");
		return home;
	}

	// click on Actions button and select Transfer to Individual details and click
	// onexpand audit history.
	public ISGCasePage isgClkActionsBtnSelectIndividualClkAudit(ISGCasePage isgCase, String operator,
			String workbasket) {
		isgCase = isgCase.isgClickActionsButton().isgClickTransferToIndividual().isgEnterTransferOperator(operator)
				.isgEnterTransferWorkbasket(workbasket).isgClkTransferSubmitButton().isgExpandAuditHistory();
		logger.log(LogStatus.PASS,
				" click on Actions button and select Transfer to Individual details and expand audit history. ");
		return isgCase;
	}

	// clicking on AuditTrails
	public ISGCasePage isgAuditTrails(ISGCasePage isgCase) {
		isgCase = isgCase.isgExpandAuditHistory();
		logger.log(LogStatus.PASS, "Clicking on Audit ");
		return isgCase;
	}

	// clicking on CaseClose button
	public ISGCasePage clickOnCaseCloseBtn(ISGCasePage isgCase) {
		isgCase = isgCase.isgClickCaseClose();
		logger.log(LogStatus.PASS, "Clicking on case close button");
		return isgCase;
	}

	// Verify alert message for GSC case.
	public GSCCustomerSearch gscCaseAlertVerification(GSCCustomerSearch gscCustomerSearch, String priority,
			String language, String origin, String summary, String workbasket, String custfirstname,
			String custLastName, String country, String model, String farea, String fcode) {
		gscCustomerSerch = gscCustomerSearch.clickOnAcceptBtn().switchToAlert().enterPriority(priority)
				.enterLanguage(language).enterOrigin(origin).enterAddSummary(summary).selectWorkBasket(workbasket)
				.clickOnAcceptBtn().switchToAlert().clickOnAddCustomeInfoIcon().enterCustomerFirstName(custfirstname)
				.enterCustomerLastName(custLastName).selectCountry(country).clickGscSearchCustomerBtn()
				.clickSearchCustomerDetails().clickOnAcceptBtnAndSwitchToFrame().switchToAlert()
				.clickOnAddProductInfoForAlrtVrfy().enterProductModel(model).clickAddProductSubmit().clickOnAcceptBtn()
				.clickOnCloseBtn().switchToAlert().enterCasecodingFA(farea).enterCasecodingFC(fcode).clickOnCloseBtn();
		logger.log(LogStatus.PASS, "Verifying alert message for GSC case ");
		return gscCustomerSerch;
	}

	// Enter customer details for GSC case creation .
	public GSCCustomerSearch enterGSCCaseCustomerDetails(GSCCustomerSearch gscCustomerSearch, String custfirstname,
			String custlastname, String country, String model, String fArea, String fCode, String priority,
			String language, String origin, String summary, String workbasket) {
		gscCustomerSerch = gscCustomerSearch.clickOnAddCustomeInfoIcon().enterCustomerFirstName(custfirstname)
				.enterCustomerLastName(custlastname).selectCountry(country).clickGscSearchCustomerBtn()
				.clickSearchCustomerDetails().clickOnAddProductInfo().enterProductModel(model).clickAddProductSubmit()
				.enterCasecodingFA(fArea).enterCasecodingFC(fCode).enterPriority(priority).enterLanguage(language)
				.enterOrigin(origin).enterAddSummary(summary).selectWorkBasket(workbasket);
		logger.log(LogStatus.PASS, "Entering the GSC customer details .");
		return gscCustomerSerch;
	}

	// Enter Customer details for gsc case creation and click on search customer
	// details
	public GSCCustomerSearch enterAuditCustomerDetails(GSCCustomerSearch gscCustomerSearch, String CustFirstName,
			String CustLastName, String Country) {
		gscCustomerSerch = gscCustomerSearch.enterCustomerFirstName(CustFirstName).enterCustomerLastName(CustLastName)
				.selectCountry(Country).clickGscSearchCustomerBtn().clickSearchCustomerDetails();
		logger.log(LogStatus.PASS,
				" Entering Customer details for gsc case creation and click on search customer details");
		return gscCustomerSerch;
	}

	// Click on Action, reopen button
	public GSCCustomerSearch clickOnActionWorkcaseBtn(GSCCustomerSearch gscCustomerSearch) {
		gscCustomerSerch = gscCustomerSerch.clickOnActionsBtnWorkCaseBtn();
		logger.log(LogStatus.PASS, "Clicking on Action,Reopen button");
		return gscCustomerSerch;
	}

	// Clicking on select workbasket and operator individual button
	public GSCCustomerSearch gscTransferSelectDropdown(GSCCustomerSearch gscCustomerSearch, String operator,
			String workbasket) {
		gscCustomerSerch = gscCustomerSearch.gscOperatortDropdown(operator).gscTransferWorkbasket(workbasket);
		logger.log(LogStatus.PASS, "Clicking on select workbasket and operator individual button ");
		return gscCustomerSerch;
	}

	// Clicking on submit button
	public GSCCustomerSearch gscTransferSubmit(GSCCustomerSearch gscCustomerSearch) {
		gscCustomerSerch = gscCustomerSearch.transferSubmitButton();
		logger.log(LogStatus.PASS, "Clicking on submit button ");
		return gscCustomerSerch;

	}

	// click on audit trails button
	public GSCCustomerSearch clickOnAuditTrails(GSCCustomerSearch gscCustomerSearch) {
		gscCustomerSerch = gscCustomerSearch.auditTrails();
		logger.log(LogStatus.PASS, "clicking on audit trails  button and validate audit history");
		return gscCustomerSerch;
	}

	// Enter Customer details for case creation
	public GSCCustomerSearch enterAuditCustomerDetails(GSCCustomerSearch gscCustomerSearch, String custfirstname,
			String custlastname, String country, String model, String farea, String fcode, String priority,
			String language, String origin, String summary, String workbasket) {
		gscCustomerSerch = gscCustomerSearch.enterCustomerFirstName(custfirstname).enterCustomerLastName(custlastname)
				.selectCountry(country).clickGscSearchCustomerBtn().clickSearchCustomerDetails().clickOnAddProductInfo()
				.enterProductModel(model).clickAddProductSubmit().enterCasecodingFA(farea).enterCasecodingFC(fcode)
				.enterPriority(priority).enterLanguage(language).enterOrigin(origin).enterAddSummary(summary)
				.selectWorkBasket(workbasket).enterFileAttachmentDetails().clickOnAcceptBtn();
		logger.log(LogStatus.PASS, "Entering customer details for GSC case creation");
		return gscCustomerSerch;
	}

	// Click on Actions Button and validate TransferToIndividual and click on submit
	// button
	public GSCCustomerSearch clickOnActionsTIndividual(GSCCustomerSearch gscCustomerSearch, String operator,
			String workbasket) {
		gscCustomerSerch = gscCustomerSearch.clickOnActionsBtn().gscTransferToIndividual()
				.gscOperatortDropdown(operator).gscTransferWorkbasket(workbasket).transferSubmitButton();
		logger.log(LogStatus.PASS,
				"Click on Actions Button and validate TransferToIndividual and click on submit button");
		return gscCustomerSerch;
	}

	// Entered customer details for green fleet case creation and click on accept
	// button
	// button.
	public GreenFleetCreationPage enterGreenFleetCaseDetails(GreenFleetCreationPage greenFleetCreationPag,
			String firstname, String lastname, String country, String model, String fArea, String fCode,
			String priority, String language, String summary) {
		greenFleetCreation = greenFleetCreationPag.clickGreenFleetAddCustomeInfo()
				.enterGreenFleetCustomerFirstName(firstname).enterGreenFleetCustomerLastName(lastname)
				.enterGreenFleetselectCountry(country).greenFleetSearchCustomer().greenFleetSearchCustomerDetails()
				.greenFleetClickonAddProductInfo().greenFleetEnterProductModel(model).greenFleetClickAddProductSubmit()
				.greenFleetEnterCasecodingFA(fArea).greenFleetCasecodingFC(fCode).greenFleetEnterPriority(priority)
				.greenFleetenterLanguage(language).greenFleetEnterAddSummary(summary).clickOnAccept();
		logger.log(LogStatus.PASS,
				"Entered customer details for green fleet case creation and  click on accept button");
		return greenFleetCreation;
	}

	public GreenFleetCreationPage enterGreenFleetCaseDetailsForDealerUser(GreenFleetCreationPage greenFleetCreationPag,
			String firstname, String lastname, String country, String model, String priority, String language,
			String summary) {
		greenFleetCreation = greenFleetCreationPag.clickGreenFleetAddCustomeInfo()
				.enterGreenFleetCustomerFirstName(firstname).enterGreenFleetCustomerLastName(lastname)
				.enterGreenFleetselectCountry(country).greenFleetSearchCustomer().greenFleetSearchCustomerDetails()
				.greenFleetClickonAddProductInfoForDealer().greenFleetEnterProductModel(model)
				.greenFleetClickAddProductSubmit().greenFleetEnterPriority(priority).greenFleetEnterAddSummary(summary)
				.clickOnSubmitBtn();
		logger.log(LogStatus.PASS, "Entered customer details for green fleet case creation and click on  button");
		return greenFleetCreation;
	}

	// click on audit trails button
	public GreenFleetCreationPage clickOnAuditTrails(GreenFleetCreationPage greenFleetCreationPag) {
		greenFleetCreation = greenFleetCreationPag.auditTrails();
		logger.log(LogStatus.PASS, "clicking on audit trails  button and validate audit history");
		return greenFleetCreation;
	}

	// Entered customer details for green fleet case creation and click on accept
	// button
	// button.
	public GreenFleetCreationPage enterGreenFleetCaseDetailsTCSMUser(GreenFleetCreationPage greenFleetCreationPag,
			String firstname, String lastname, String country, String model, String fArea, String fCode,
			String priority, String summary) {
		greenFleetCreation = greenFleetCreationPag.clickGreenFleetAddCustomeInfo()
				.enterGreenFleetCustomerFirstName(firstname).enterGreenFleetCustomerLastName(lastname)
				.enterGreenFleetselectCountry(country).greenFleetSearchCustomer().greenFleetSearchCustomerDetails()
				.greenFleetClickonAddProductInfo().greenFleetEnterProductModel(model).greenFleetClickAddProductSubmit()
				.greenFleetEnterCasecodingFA(fArea).greenFleetCasecodingFC(fCode).greenFleetEnterPriority(priority)
				.greenFleetEnterAddSummary(summary).clkAcceptButton();
		logger.log(LogStatus.PASS,
				"Entered details for green fleet case creation for TCMS user and  click on accept button");
		return greenFleetCreation;
	}

	// Get green fleet Case Id
	public GreenFleetCreationPage getDealerCase(GreenFleetCreationPage greenFleetCreationPag) {
		greenFleetCreation = greenFleetCreationPag.getDealerCase().clickOnName().clickOnLogout();
		logger.log(LogStatus.PASS, " Displaying case id and clicking on logout button ");
		return greenFleetCreation;
	}

	// Entering a character , verify the negative message and click on submit button
	// .
	public GreenFleetCreationPage entrCharClkSubmt(GreenFleetCreationPage greenFleetCreationPag, String cha) {
		greenFleetCreation = greenFleetCreationPag.greenFleetEnterInvalidModel(cha).greenFleetClickAddProductSubmit();
		logger.log(LogStatus.PASS, "Entering invalid product details ,click on submit button ");
		return greenFleetCreation;
	}

	// Enter greenfleet product details then submit it and click on accept button
	// ,verify the
	// alert
	public GreenFleetCreationPage entrValidModelClkSubmt(GreenFleetCreationPage greenFleetCreationPag, String model) {
		greenFleetCreation = greenFleetCreationPag.greenFleetEnterProductModel(model).greenFleetClickAddProductSubmit()
				.clkAcceptButton().switchToAlert();
		logger.log(LogStatus.PASS,
				"Entering greenfleet product details ,click submit and click on accept button and verify the alert");
		return greenFleetCreation;
	}

	// Clicking on Action button
	public GreenFleetCreationPage clickOnAction(GreenFleetCreationPage greenFleetCreationPag) {
		greenFleetCreation = greenFleetCreationPag.clickOnGreenFleetAction();
		logger.log(LogStatus.PASS, "clicking on Action");
		return greenFleetCreation;
	}

	// Greenfleet
	// : Navigate to Home Page from any page
	public GreenFleetCreationPage navigateToGreenFleetCreationPage(NavigationClass navigationPag) {
		greenFleetCreation = navigationPag.clickHome();
		logger.log(LogStatus.PASS, "Navigating to  home page");
		return greenFleetCreation;
	}

	public GreenFleetCreationPage clickonGreenFleetCase(GreenFleetCreationPage greenFleetCreationPag) {
		greenFleetCreation = greenFleetCreationPag.clickOnGreenFleetCase();
		logger.log(LogStatus.PASS, "Clicking on Green fleet case");
		return greenFleetCreation;
	}

	// Click on Green fleet case for Dealer User
	public GreenFleetCreationPage clickOnGreenFleetCaseBtnDealerUser(HomePage homePag) {
		greenFleetCreation = homePag.clickOnGreenFleetCaseForDealer();
		logger.log(LogStatus.PASS, "Clicking on Green fleet case button");
		return greenFleetCreation;
	}

	// Click on Green fleet case
	public GreenFleetCreationPage clickOnGreenFleetCaseBtn(HomePage homePag) {
		greenFleetCreation = homePag.clickOnGreenFleetCase();
		logger.log(LogStatus.PASS, "Clicking on Green fleet case button");
		return greenFleetCreation;
	}

	// Entering the GreenFleet Case Id in Case Search Box
	public ISGCaseSearchPage enterDealerCaseId(ISGCaseSearchPage isgCaseSearchPag, String caseId) {
		isgCaseSearch = isgCaseSearchPag.enterCaseIDInCaseSearchBox(caseId);
		logger.log(LogStatus.PASS, "Entering the Case Id in Case Search Box");
		return isgCaseSearch;
	}

	// Click on close button
	public ISGCasePage clickOnClose(ISGCasePage isgCasePag) {
		isgCase = isgCasePag.clickClose();
		logger.log(LogStatus.PASS, "Clicking on close");
		return isgCase;
	}

	// click on GSC withdraw button
	public GSCCustomerSearch clickOnWithdraw(GSCCustomerSearch gscCustomerSearch) {
		gscCustomerSerch = gscCustomerSearch.clickOnWithdrawBtn();
		logger.log(LogStatus.PASS, "clciking on withdraw case button");
		return gscCustomerSerch;
	}

	// click on submit button
	public GSCCustomerSearch clickOnSubmit(GSCCustomerSearch gscCustomerSearch) {
		gscCustomerSerch = gscCustomerSearch.clickOnSubmitWithdraw();
		logger.log(LogStatus.PASS, "clicking on submit button");
		return gscCustomerSerch;
	}

	// Click on action and sendcase email button and verify the details
	public GSCCustomerSearch clickOnActionsSendCasMailEntrData(GSCCustomerSearch gscCustomerSearch, String mail) {
		gscCustomerSerch = gscCustomerSearch.clickOnActionsBtn().sendCaseMail().enterSendCaseMail(mail).sendButton()
				.auditTrails();
		logger.log(LogStatus.PASS,
				"clicking on Actions button,enter sendcase email details and validate audit history");
		return gscCustomerSerch;
	}

	// click on Audit Trails.
	public GSCCustomerSearch clickonAuditTrails(GSCCustomerSearch gscCustomerSearch) {
		gscCustomerSerch = gscCustomerSearch.auditTrails();
		logger.log(LogStatus.PASS, "clicking on Audit Trails");
		return gscCustomerSerch;
	}

	// Click on Green fleet case
	public GreenFleetCreationPage clickonGreenFleet(GreenFleetCreationPage greenFleetCreationPag) {
		greenFleetCreation = greenFleetCreationPag.clickOnGreenFleetCase();
		logger.log(LogStatus.PASS, "Clicking on Green fleet case");
		return greenFleetCreation;
	}

	// Entering green fleet customer details ,verify alert and click on cancel
	// button .
	public GreenFleetCreationPage enterGreenFleetCaseDetailsForAlert(GreenFleetCreationPage greenFleetCreationPag,
			String summary, String priority, String lastnamechar, String code, String firstname, String lastname,
			String country) {
		greenFleetCreation = greenFleetCreationPag.greenFleetEnterAddSummary(summary).greenFleetEnterPriority(priority)
				.clkAcceptButton().switchToAlert().clickGreenFleetAddCustomeInfo().grnFltClkSearchCustomerForAltVerfy()
				.switchToAlert().enterGreenFleetCustomerLastName(lastnamechar).clkOnSearchCustomer().switchToAlert()
				.enterPostalCod(code).clkOnSearchCustomer().switchToAlert().clickOnReset()
				.enterGreenFleetCustomerFirstNameForAlert(firstname).enterGreenFleetCustomerLastName(lastname)
				.enterGreenFleetselectCountry(country).greenFleetSearchCustomer().greenFleetSearchCustomerDetails()
				.clkAcceptButtonForAlertVrfy().switchToAlert();
		logger.log(LogStatus.PASS, "Entering GreenFleet details, verifying alert and clicking on cancel button");
		return greenFleetCreation;
	}

	// Click on green fleet Accept button and verify the alert.
	public GreenFleetCreationPage clickAcceptVerfyAlert(GreenFleetCreationPage greenFleetCreationPag) {
		greenFleetCreation = greenFleetCreationPag.clkAcceptButton().switchToAlert();
		logger.log(LogStatus.PASS, "Clicking on accept button and verifying the alert");
		return greenFleetCreation;
	}

	// Click on close button and verift the alert
	public GreenFleetCreationPage clickCloseBtnVerfyAlert(GreenFleetCreationPage greenFleetCreationPag) {
		greenFleetCreation = greenFleetCreationPag.clkCloseButton().switchToAlert();
		logger.log(LogStatus.PASS, "Clicking on close button and verifying the alert");
		return greenFleetCreation;
	}

	// Enter Functional Code and Functional Area and click on close Button.
	public GreenFleetCreationPage enterFCodeFAreaClkCloseBtn(GreenFleetCreationPage greenFleetCreationPag, String fArea,
			String fCode) {
		greenFleetCreation = greenFleetCreationPag.greenFleetEnterCasecodingFA(fArea).greenFleetCasecodingFC(fCode)
				.clkCloseButton();
		logger.log(LogStatus.PASS, "Clicking on accept button and verifying the alert");
		return greenFleetCreation;
	}

	// Click on product button.
	public GreenFleetCreationPage clickOnProductInfButton(GreenFleetCreationPage greenFleetCreationPag) {
		greenFleetCreation = greenFleetCreationPag.clickAddProductInfo();
		logger.log(LogStatus.PASS, "Clicking on Add Product Info Button ");
		return greenFleetCreation;
	}

	// click GreenFleet on submit button
	public GreenFleetCreationPage clickOnSubmitButton(GreenFleetCreationPage greenFleetCreationPag) {
		greenFleetCreation = greenFleetCreationPag.greenFleetSubmitButton();
		logger.log(LogStatus.PASS, "clicking on submit button");
		return greenFleetCreation;
	}

	// Click on action DD(green fleet)
	public GreenFleetCreationPage clickOnActionsDD(GreenFleetCreationPage greenFleetCreationPag) {
		greenFleetCreation = greenFleetCreationPag.clickAction();
		logger.log(LogStatus.PASS, "clicking on Actions Drop Down");
		return greenFleetCreation;
	}

	// Clicking on close button
	public GreenFleetCreationPage clickCloseButton(GreenFleetCreationPage greenFleetCreationPag) {
		greenFleetCreation = greenFleetCreationPag.clickOnCloseButton();
		logger.log(LogStatus.PASS, "Clicking  on close button");
		return greenFleetCreation;
	}

	// Jyothsna :Clicking on Add Product Info Button
	public ISGCasePage clickISGProductInfButton(ISGCasePage isgCasePage) {
		isgCasePage = isgCasePage.clickAddProductInfo();
		logger.log(LogStatus.PASS, "Clicking on Add Product Info Button ");
		return isgCasePage;
	}

	// Entering details for customer search and validating the alert
	public GSCCustomerSearch addCustomeValidation(GSCCustomerSearch gscCustomerSearch) {
		gscCustomerSerch = gscCustomerSearch.clickGscSearchCustomerBtnAlrtVerfy().switchToAlert();
		logger.log(LogStatus.PASS, "Validating customer search alert");
		return gscCustomerSerch;
	}

	// Entering details for customer search and validating the alert
	public GSCCustomerSearch entrLnameClkSrchCustVrfyAlert(GSCCustomerSearch gscCustomerSearch, String custLastName,
			String city) {
		gscCustomerSerch = gscCustomerSearch.enterCustomerLastName(custLastName).clickGscSearchCustomerBtn()
				.switchToAlert().clickOnReset().enterCityField(city).clickGscSearchCustomerBtn().switchToAlert();
		logger.log(LogStatus.PASS, "Validating customer search alert");
		return gscCustomerSerch;
	}

	// Entering details for customer search and validating the field details
	public GSCCustomerSearch customerDtlsValidation(GSCCustomerSearch gscCustomerSearch, String custLastName,
			String city) {
		gscCustomerSerch = gscCustomerSearch.enterCustomerLastName(custLastName).clickGscSearchCustomerBtn()
				.switchToAlert().enterCityField(city).clickGscSearchCustomerBtn();
		logger.log(LogStatus.PASS, "Entering details for customer search and validating the field details");
		return gscCustomerSerch;
	}

	// Click on GSC case from home page
	public CaseCoding clickonGSCCaseCod(HomePage homePage) {
		casecodingPage = homePage.clickonGSCCaseCo();
		logger.log(LogStatus.PASS, "Clicking on GSC case");
		return casecodingPage;
	}

	// Navigating to ISg Case Creation Page and Clicking on ISG Case Creation
	// Button
	public ISGCaseCreation navToISGCasePag(HomePage homePage) {
		isgCaseCreationPage = homePage.clickCreateISGCas();
		logger.log(LogStatus.PASS, " Navigating to ISg Case Creation Page and Clicking on ISG Case Creation Button ");
		return isgCaseCreationPage;
	}

	// Navigate to Case Search page and switching to frame
	public ISGCasePage navigateToISGCasePage(ISGCaseSearchPage isgCaseSearchPage) {
		isgCase = isgCaseSearchPage.navToISGCasePage();
		logger.log(LogStatus.PASS, "Navigating to Case Search page and Switchig to frame");
		return isgCase;
	}

	// Entering the Case Id in Case Search Box and click on case link
	public ISGCaseSearchPage enterCaseIDClickCaseSrch(ISGCaseSearchPage isgCaseSearchPag, String caseId) {
		isgCaseSearch = isgCaseSearchPag.enterCaseIDInCaseSearchBox(caseId).clickCaseSearchImgLink().clickOnCaseLink();
		logger.log(LogStatus.PASS, "Entering the Case Id in Case Search Box and clicking on case link");
		return isgCaseSearch;
	}

	/************** TC6649 (30-07-2018) **********************/
	// Lahari(30-07-2018) : opening SouthEastAsia webform
	public SouthEastAsiaLoginPage openWebformPortal_SouthEastAsia(WebDriver driver, String url) {
		driver.get(url);
		logger.log(LogStatus.PASS, "Opening SouthEastAsia WebForm Portal");
		return new SouthEastAsiaLoginPage(driver);
	}

	// Lahari(30-07-2018) : Logging into webforms
	public SouthEastAsia loginToSouthEastAsiaWebform(SouthEastAsiaLoginPage southEastAsiaLoginPag, String username,
			String password) {
		southEastAsiaForm = southEastAsiaLoginPag.enterUserName(username).enterPassword(password).clickSignInBtn();
		logger.log(LogStatus.PASS, "Logging into web form");
		return southEastAsiaForm;
	}

	// Lahari(30-07-2018) : Entering the Detailed description and Attach file
	public SouthEastAsia detailedDesptAndAttachFileSouthEastAsia(SouthEastAsia southEast, String desc) {
		southEastAsiaForm = southEast.detailedDescription(desc).uploadFile();
		logger.log(LogStatus.PASS, "Entering detailed description and Attaching File");
		return southEastAsiaForm;
	}

	// Lahari(30-07-2018) : click on Submit
	public SouthEastAsia clickSubmitBtn(SouthEastAsia southEast) {
		southEastAsiaForm = southEast.clickSubmitBtn();
		logger.log(LogStatus.PASS, "Clicking on Submit button");
		return southEastAsiaForm;
	}

	// Lahari(30-07-2018) : Entering the Detailed description
	public SouthEastAsia enterDetailedDesp(SouthEastAsia southEast, String desc) {
		southEastAsiaForm = southEast.detailedDescription(desc);
		logger.log(LogStatus.PASS, "Entering detailed description ");
		return southEastAsiaForm;
	}

	// Lahari(30-07-2018) : Get Case Id
	public SouthEastAsia getCaseID(SouthEastAsia southEast) {
		southEastAsiaForm = southEast.getCaseID();
		logger.log(LogStatus.PASS, "CaseId  generated successfully");
		return southEastAsiaForm;
	}

	// Lahari(30-07-2018) : Click Case Search tab
	public CaseSearchPage clickCaseSearch(NavigationClass navigationClas) {
		caseSearch = navigationClas.clickCaseSearch();
		logger.log(LogStatus.PASS, "Entering the Case Id in Case Search Box");
		return caseSearch;
	}

	// Lahari(30-07-2018) : Entering the Case Id in Case Search Box and click on
	// case link
	public ISGCasePage enterCaseIDClickCaseSrch(CaseSearchPage caseSearchPag, String caseId) {
		isgCase = caseSearchPag.enterCaseIDInCaseSearchBox(caseId).clickCaseSearchImgLink().clickOnCaseLink();
		logger.log(LogStatus.PASS, "Entering the Case Id in Case Search Box and clicking on case link");
		return isgCase;
	}

	// Lahari(30-07-2018) : Click on Actions button and reopening the case
	public ISGCasePage selectWCFrmAction(ISGCasePage isgCasePag, String comment, String func_area, String func_code) {
		isgCase = isgCasePag.clickActions().clickAddComments().enterComment(comment).clickSubmitBtn()
				.selFunctionalArea(func_area).selFunCode(func_code).clickSaveButton().clickAcceptButton();
		logger.log(LogStatus.PASS, "clicking on Actions, Adding comments and clicking on Accept button ");
		return isgCase;
	}

	// Lahari(30-07-2018) : Clicking on close button
	public ISGCasePage clickCloseButton(ISGCasePage isgCasePag) {
		isgCase = isgCasePag.clickCloseButton();
		logger.log(LogStatus.PASS, "Clicking  on close button");
		return isgCase;
	}

	// Lahari(30-07-2018) : Navigating to SendCaseEmail
	public SendCaseEmail navigateToSendCaseEmailPage(ISGCasePage isgCasePag) {
		sendCaseEmail = isgCasePag.selectSendCaseEmail();
		logger.log(LogStatus.PASS, " Navigating to SendCaseEmail ");
		return sendCaseEmail;
	}

	// Lahari(30-07-2018) : Entering To Filed data and clicking on send button
	public SendCaseEmail entetToFiledData(SendCaseEmail sendCaseEmailPag, String data) {
		sendCaseEmail = sendCaseEmailPag.enterToFieldData(data).clickSendButton();
		logger.log(LogStatus.PASS, " entering To Filed data and clicking  on send button ");
		return sendCaseEmail;
	}

	// Lahari(30-07-2018) : Open the Gmail Portal
	public GmailLoginPage openGmailPortal(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.log(LogStatus.PASS, "Opening Gmail Portal");
		return new GmailLoginPage(driver);

	}

	// Lahari(30-07-2018) : Login to Gmail Portal
	public GmailLoginPage loginToGmailPage(GmailLoginPage gmailLoginPag, String username, String password) {
		gmailLogin = gmailLoginPag.enterUserName(username).enterPassword(password);
		logger.log(LogStatus.PASS, "Logging in to Gmail Page");
		return gmailLogin;
	}

	/************** TC6333(30-07-2018) start **********************/
	// Lahari (30-07-2018) : Navigate to Home Page from any page
	public HomePage navigateToHomeScreen(NavigationClass navigationPag) {
		home = navigationPag.clickHomeBtnOne();
		logger.log(LogStatus.PASS, "Navigating to HomePage and clicking on Home Button");
		return home;
	}

	// Lahari (30-07-2018): click on GSC button
	public GSCRoutingPage clickOnGSCCaseButton(HomePage homePag) {
		gscRouting = homePag.clickGSCCase();
		logger.log(LogStatus.PASS, "Clicking on GSC Case Creation button");
		return gscRouting;
	}

	// Lahari (30-07-2018) :Entering GSC Case Creation All Mandatory fields data
	// clicking on
	// submit button
	public GSCRoutingPage gscCaseCreationDetails(GSCRoutingPage gscRoutingPag, String lastNme, String fisName,
			String country, String model, String funarea, String functionCode, String priorty, String orig,
			String summ) {
		gscRouting = gscRoutingPag.caseIdStote().clickAddCustomeInfo(lastNme, fisName, country)
				.clkProductInfoModel(model).selFunctionalArea(funarea).selFunctionalCode(functionCode)
				.selPriority(priorty).selOrigin(orig).entProblemDetailsSummary(summ).selectWorkBasket()
				.clickonAcceptBtn();
		logger.log(LogStatus.PASS,
				" Entering GSC Case Creation All Mandatory fileds data and clicking on submit button");
		return gscRouting;
	}

	// Lahari (30-07-2018) :Entering GSC Case Creation All Mandatory fields data
	// clicking on
	// submit button
	public GSCRoutingPage caseCreationDetails(GSCRoutingPage gscRoutingPag, String lastNme, String fisName,
			String country, String model, String funarea, String functionCode, String priorty, String orig, String summ,
			String workbasket) {
		gscRouting = gscRoutingPag.caseIdStote().clickAddCustomeInfo(lastNme, fisName, country)
				.clkProductInfoModel(model).selFunctionalArea(funarea).selFunctionalCode(functionCode)
				.selPriority(priorty).selOrigin(orig).entProblemDetailsSummary(summ).selectWB(workbasket)
				.clickonAcceptBtn();
		logger.log(LogStatus.PASS,
				" Entering GSC Case Creation All Mandatory fileds data and clicking on submit button");
		return gscRouting;
	}

	// Lahari (30-07-2018): Perform Actions Functionalities
	public GSCRoutingPage selTCWFromActionsClkSubmit(GSCRoutingPage gscRoutingPag, String oper, String work,
			String gscCaseIdNew) throws InterruptedException {
		gscRouting = gscRoutingPag.clickonActionsSelectVal(oper, work).enterDataInCaseIdSchBox(gscCaseIdNew)
				.clickAudit().clickHomeAndGSCbutton();
		logger.log(LogStatus.PASS,
				"selecting Transfer to Individual option from Actions and submit all details in Transfer popup screen clicking on submit button and Verifying  Case is available in their My Cases grid and Verifying the audit history of the case and clickHome and GSc Case");
		return gscRouting;
	}

	// Lahari (30-07-2018): Perform Actions Functionalities
	public GSCRoutingPage selWBFromActionsClkSubmit(GSCRoutingPage gscRoutingPag, String wrkBask, String gscCaseIdNew) {
		gscRouting = gscRoutingPag.clickOnTransferToWorkBasket().clickonActionsSelectValTranWB(wrkBask)
				.enterDataInCaseIdSchBox(gscCaseIdNew).clickAudit().clickHomeAndGSCbutton();
		logger.log(LogStatus.PASS,
				"selecting Transfer case to WB option from Actions and submit all details in Transfer popup screen clicking on submit button");
		return gscRouting;
	}

	// Lahari (30-07-2018): Clicking on close button
	public GSCRoutingPage clickOnCloseButton(GSCRoutingPage gscRoutingPag) {
		gscRouting = gscRoutingPag.clickOnCloseBtn();
		logger.log(LogStatus.PASS, "Clicking on close button ");
		return gscRouting;
	}

	// Lahari(30-07-2018) : Entering the Case Id in Case Search Box and click on
	// case link
	public CaseSearchPage enterCaseIDClkCaseSrch(CaseSearchPage caseSearchPag, String caseId) {
		caseSearch = caseSearchPag.enterCaseIDInCaseSearchBox(caseId).clickCaseSearchImgLink().clickCaseLink();
		logger.log(LogStatus.PASS, "Entering the Case Id in Case Search Box and clicking on case link");
		return caseSearch;
	}

	/*************************** TC6587--Start ************************/
	// Lahari (03-08-2018): Clicking in search icon for solution search Id filed
	public ISGRecommendedSolutionsSectionPage clickOnSearchForSolutionIdField(
			ISGRecommendedSolutionsSectionPage isgRecommendedSolutionsSectionPag) {
		isgRecommendedSolutionsSection = isgRecommendedSolutionsSectionPag.clickSearchIcon();
		logger.log(LogStatus.PASS, "Clicking on ISG Case Creation Button");
		return isgRecommendedSolutionsSection;
	}

	// Lahari (03-08-2018): Enter solution Id field data
	public ISGRecommendedSolutionsSectionPage enterSoluIdClickSecrh(
			ISGRecommendedSolutionsSectionPage isgRecommendedSolutionsSectionPag, String id) {
		isgRecommendedSolutionsSection = isgRecommendedSolutionsSectionPag.enterIdInSolSearchFiled(id)
				.clickSearchIcon();
		logger.log(LogStatus.PASS,
				"Entering Solution ID search field, enter a valid solution ID  and Clicking on search of Solution ID");
		return isgRecommendedSolutionsSection;
	}

	// Lahari (03-08-2018): Enter solution Id field data
	public ISGRecommendedSolutionsSectionPage enterSoluId(
			ISGRecommendedSolutionsSectionPage isgRecommendedSolutionsSectionPag, String id) {
		isgRecommendedSolutionsSection = isgRecommendedSolutionsSectionPag.enterIdInSolSearchFiled(id);
		logger.log(LogStatus.PASS, "Entering Solution Id filed data");
		return isgRecommendedSolutionsSection;
	}

	// Lahari (03-08-2018): Clicking on solution Id Link
	public ISGRecommendedSolutionsSectionPage clickOnSolutionIdLink(
			ISGRecommendedSolutionsSectionPage isgRecommendedSolutionsSectionPag) {
		isgRecommendedSolutionsSection = isgRecommendedSolutionsSectionPag.clickOnSolutionIdLink().frameSwitching();
		logger.log(LogStatus.PASS, " Clicking on  solution Id Link");
		return isgRecommendedSolutionsSection;
	}

	/*************************** TC6587--end ************************/
	/*************************** TC6560 --Start ************************/
	// Lahari (03-08-2018): Navigate to Home Page from any page
	public HomePage navigateToHomePage(NavigationClass navigationPag) {
		home = navigationPag.clickOnHomeButton();
		logger.log(LogStatus.PASS, "Navigating to  home page");
		return home;
	}

	// Lahari (03-08-2018): Clicking on EYE Icon
	public ISGCaseCreationHomePage clickCaseInfmEyeBtn(ISGCaseCreationHomePage isgCaseCreationHomePag) {
		isgCaseCreationHome = isgCaseCreationHomePag.clickEyeBtn();
		logger.log(LogStatus.PASS, "Clicking on EYE Icon");
		return isgCaseCreationHome;
	}

	// Lahari (03-08-2018): Navigating to ISg Case Creation Page and Clicking on ISG
	// Case
	// Creation Button
	public ISGCaseCreationHomePage navToISGCaseCreatclkISGBtn(HomePage homePage) {
		isgCaseCreationHome = homePage.clickISgBtn().switchToFrame();
		logger.log(LogStatus.PASS, " Navigating to ISg Case Creation Page and Clicking on ISG Case Creation Button ");
		return isgCaseCreationHome;
	}

	// Lahari (03-08-2018): Clicking on Edit Icon
	public ISGCaseCreationHomePage clickEditBtn(ISGCaseCreationHomePage isgCaseCreationHomePag) {
		isgCaseCreationHome = isgCaseCreationHomePag.clickEdit();
		logger.log(LogStatus.PASS, "Clicking on edit button");
		return isgCaseCreationHome;
	}

	// Lahari (03-08-2018): Entering model details for Product Info and clicking on
	// Submit
	// button
	public ISGCaseCreationHomePage clickAddProductInfoEnterModelDetail(ISGCaseCreationHomePage isgCaseCreationHomePag,
			String model) {
		isgCaseCreationHome = isgCaseCreationHomePag.productInfoModel(model);
		logger.log(LogStatus.PASS, "Entering model details for Product Info and clicking on Submit button");
		return isgCaseCreationHome;
	}

	// Lahari(03-08-2018) : Click on Edit Product Info and Enter model details for
	// Product
	// Info
	public ISGCaseCreationHomePage clickEditProductInfoEnterModelDetail(ISGCaseCreationHomePage isgCaseCreationHomePag,
			String model) {
		isgCaseCreationHome = isgCaseCreationHomePag.editproductInfoModel(model);
		logger.log(LogStatus.PASS, "Entering model details for Product Info");
		return isgCaseCreationHome;
	}

	// Lahari (03-08-2018): Clear Value from Product Model Drop down filed
	public ISGCaseCreationHomePage clearValueFromModelDropDownfiled(ISGCaseCreationHomePage isgCaseCreationHomePag) {
		isgCaseCreationHome = isgCaseCreationHomePag.clearproductInfoModel();
		logger.log(LogStatus.PASS, "Clearing model details for Product Info");
		return isgCaseCreationHome;
	}

	/*************************** TC6560 --End ************************/
	/*************************** TC6877 --Start ************************/
	// Lahari (03-08-2018): Navigating to ISg Case Creation Page and Clicking on ISG
	// Case
	// Creation Button
	public ISGRecommendedSolutionsSectionPage navToISGCaseCreatClkISGBtn(HomePage homePag) {
		isgRecommendedSolutionsSection = homePag.clickCreateISGCaseBtn().switchToFrame();
		logger.log(LogStatus.PASS,
				" Navigating to ISGRecommendedSolutionsSection and Clicking on ISG Case Creation Button ");
		return isgRecommendedSolutionsSection;
	}

	/*************************** TC6877 --End ************************/
	/*************************** TC6486--Start ************************/
	// Lahari (03-08-2018): Navigate to CreateISGCase page
	public ISGCasePage navigateToCreateISGCaseHome(HomePage homePag) {
		isgCase = homePag.clickCreateISGCaseHomeLink();
		logger.log(LogStatus.PASS, "Navigating to Create ISG Case home page");
		return isgCase;
	}

	// Lahari (03-08-2018): Entering Customer Info Details
	/*
	 * public ISGCasePage enterIsgCustInfoDet(ISGCasePage isgCasePage, String
	 * countryCode, String firstName, String lastName) { isgCasePage =
	 * isgCasePage.clickAddCustomerInfo().enterCountryCode(countryCode).
	 * enterFirstName(firstName)
	 * .enterLastName(lastName).clickCustomerSearch().clickRadioButton().
	 * clickCustomerSubmitButton() .clickAddProductInfo().clickAddProductInfo();
	 * 
	 * logger.log(LogStatus.PASS,
	 * "Entering Customer details for ISG Case Creation  "); return isgCasePage; }
	 */

	/*
	 * // Entered customer details for ISG case creation and click on accept button
	 * public ISGCasePage enterIsgCustInfoDet(ISGCasePage isgCasePag, String
	 * countryCode, String firstName, String lastName) { isgCase =
	 * isgCasePag.clickAddCustomerInfo().enterCountryCode(countryCode).
	 * enterFirstName(firstName)
	 * .enterLastName(lastName).clickCustomerSearch().clickRadioButton().
	 * clickCustomerSubmitButton() .clickAddProductInfo();
	 * logger.log(LogStatus.PASS,
	 * "Entering Customer details for ISG Case Creation and clicking on Accept Button"
	 * ); return isgCase; }
	 */

	// Lahari (03-08-2018): Entering model details for Product Info and clicking on
	// Submit
	// button
	public ISGCasePage clickAddProductInfoEnterModelDetail(ISGCasePage isgCasePage, String model) {
		isgCasePage = isgCasePage.productInfoModel(model);
		logger.log(LogStatus.PASS, "Entering model details for Product Info and clicking on Submit button");
		return isgCasePage;
	}

	// Lahari (03-08-2018):Entering ISG Case Case Information and case coding
	// Information
	// and
	// summary details and click on Accept
	public ISGCasePage enterISGCASeMandatoryDetaislClikAccept(ISGCasePage isgCasePage, String funcArea, String funcCode,
			String priority, String orign, String summary) {
		isgCasePage = isgCasePage.selFunctionalArea(funcArea).selFunCode(funcCode).selPriority(priority)
				.selOrigin(orign).enterIsgSummary(summary).acceptButton();
		logger.log(LogStatus.PASS,
				"Entering ISG Case Case Information and case coding Information and summary details and click on Accept ");
		return isgCasePage;
	}

	// Lahari (03-08-2018): Navigate to WorkBasketQueuePage
	public WorkGroupQueuePage NavToWorkBasketQueuePageClkWQ(ISGCasePage isgCasePage) {
		workGroupQueuePage = isgCasePage.clickWrkGrpQueue();
		logger.log(LogStatus.PASS, "Navigating to  WorkBasketQueuePage and clicking on WorkGroup Queue ");
		return workGroupQueuePage;
	}

	// Lahari (03-08-2018):Click Filter and Enter Case Id data and click on submit
	public WorkGroupQueuePage clkFilterEnterCaseData(WorkGroupQueuePage workGroupQueuePage, String caseIdTxtFiled) {
		workGroupQueuePage = workGroupQueuePage.clickOnFilter().enterDataInCaseIDField(caseIdTxtFiled)
				.clickOnFilterSubmit();
		logger.log(LogStatus.PASS, "Clicking on Filter and Entering Case Id data  and clic");
		return workGroupQueuePage;
	}

	/*************************** TC6877 --End ************************/

	/*************************** TC6805--Start ************************/
	// Lahari (03-08-2018):Navigate to Home Page from any page
	public ISGLinkSolutionPage navToISGLinkSolutionPageClkHome(NavigationClass navigationPag) {
		isgLinkSolution = navigationPag.clickHomeButton();
		logger.log(LogStatus.PASS, "Navigating to  ISGLinkSolutionPage and clicking on Home Button");
		return isgLinkSolution;
	}

	// Lahari (03-08-2018): click on WorkGroupQueue
	public ISGLinkSolutionPage clickWorkBasketQueue(ISGLinkSolutionPage isgLinkSolutionPag) {
		isgLinkSolution = isgLinkSolutionPag.clickonWorkGroupQueue();
		logger.log(LogStatus.PASS, "Clicking on WorkGroupQueue");
		return isgLinkSolution;
	}

	// Lahari (03-08-2018): click to open ISg cases from workBasket and Click on
	// Solutions Search and
	// click on search
	public ISGLinkSolutionPage clickISGCases(ISGLinkSolutionPage isgLinkSolutionPag) {
		isgLinkSolution = isgLinkSolutionPag.clickToOpenISGCase().clickSoluSeach().clickSearchBtn()
				.storingSoluIdInToString();
		logger.log(LogStatus.PASS,
				"clicking to open ISg cases from workGroup Queue and Clicking on Solutions Search and click on search");
		return isgLinkSolution;
	}

	// Lahari (03-08-2018): Click on Link solution
	public ISGLinkSolutionPage clickLinkSolution(ISGLinkSolutionPage isgLinkSolutionPag) {
		isgLinkSolution = isgLinkSolutionPag.clickLinkSolution().selectCheckBox().openCase()
				.solutionPresentedInRecommendedSolutions().compareCaseIdsAndOpenCase()
				.comparerecentlyOpenedCasesInLinkSolution();
		logger.log(LogStatus.PASS,
				"Clicking on Link solution and Comparing list of 5 recently opened Cases with checkBox, case ID and Summary and Clicking on checkCheckBoxForCaseId and Opening the case that you choose to attach the solution");
		return isgLinkSolution;
	}

	/*************************** TC6805 --End ************************/

	/*************************** TC6806--Start ************************/
	// Lahari (03-08-2018): Entered customer details for ISG case creation and
	// accepting the case.
	public ISGCasePage enterISGCaseCreationDetails(ISGCasePage isgCasePag, String countryCode, String firstName,
			String lastName, String model, String func_area, String func_code,  String summary,
			String pri, String ori) {
		isgCase = isgCasePag.clickAddCustomerInfo().enterCountryCode(countryCode).enterFirstName(firstName)
				.enterLastName(lastName).clickCustomerSearch().clickRadioButton().clickCustomerSubmitButton()
				.clickAddProductInfo().enterModel(model).clickProductSubmitButton().selFunctionalArea(func_area)
				.functionalCode(func_code).selPriority(pri).selOrigin(ori)
				.enterSummary(summary).clickAcceptButton();
		logger.log(LogStatus.PASS, "Entering Customer details for ISG Case Creation");
		return isgCase;
	}

	// Lahari (03-08-2018): Click on SolutionSearch Link
	public ISGLinkSolutionPage navigateToSolutionsSearch(ISGCasePage isgCasePag) {
		isgLinkSolution = isgCasePag.clickSoluSeach();
		logger.log(LogStatus.PASS, "Clicking on Solution Search ");
		return isgLinkSolution;
	}
	
	// Lahari (03-08-2018): Click on SolutionSearch Link
		public ISGLinkSolutionPage navigateToSolutionsSearchSwitchTOFrame(ISGCasePage isgCasePag) {
			isgLinkSolution = isgCasePag.switchTOFrame().clickSoluSeach();
			logger.log(LogStatus.PASS, "Clicking on Solution Search ");
			return isgLinkSolution;
		}

	// Lahari (03-08-2018): Select solution language, Click on Search Button and
	// click on link to case
	public ISGLinkSolutionPage sltLangClickSrhBtnAndLnkSol(ISGLinkSolutionPage isgLinkSolutionPag) {
		isgLinkSolution = isgLinkSolutionPag.clickLangInSol().clickSearchBtn().clickLinkSolution();
		logger.log(LogStatus.PASS, "Selecting solution language, Clicking on Search Button and click on link to case");
		return isgLinkSolution;
	}

	// Lahari (03-08-2018): Click on Next Button
	public ISGLinkSolutionPage clickNxtBtn(ISGLinkSolutionPage isgLinkSolutionPag) {
		isgLinkSolution = isgLinkSolutionPag.clickOnNextBtn();
		logger.log(LogStatus.PASS, "Clicking on Next Button ");
		return isgLinkSolution;
	}

	// Lahari (03-08-2018): Click on Case Dropdown in Link solution
	public ISGLinkSolutionPage clickCaseIDDrpdwn(ISGLinkSolutionPage isgLinkSolutionPag) {
		isgLinkSolution = isgLinkSolutionPag.clickCaseIDDrpdwn();
		logger.log(LogStatus.PASS, "Clicking on Case Dropdown in Link solution");
		return isgLinkSolution;
	}

	// Lahari (03-08-2018): Click on Link Button Click Finish And Click Case Tab
	public ISGLinkSolutionPage clickLnkBtnClkFinshAndClkCseTab(ISGLinkSolutionPage isgLinkSolutionPag) {
		isgLinkSolution = isgLinkSolutionPag.clickLinkBtnInLnkSol().clickFinishBtnInLnkSol().clickCaseTab();
		logger.log(LogStatus.PASS, "Clicking on Link Button Clicking Finish And Clicking Case Tab");
		return isgLinkSolution;
	}

	/*************************** TC6806--end ************************/

	/*************************** TC6806--start ************************/
	// Lahari (03-08-2018): selecting LinkSolution
	public ISGLinkSolutionPage selectLinkSolution(ISGLinkSolutionPage isgLinkSolutionPag) {
		isgLinkSolution = isgLinkSolutionPag.selectCheckBox().selectCheckBox();
		logger.log(LogStatus.PASS, "selecting LinkSolution");
		return isgLinkSolution;
	}

	// Lahari (03-08-2018): Comparing list of 5 recently opened Cases with checkBox,
	// case ID and
	// Summary
	// and Click on checkCheckBoxForCaseId
	public ISGLinkSolutionPage CompareAndCheckCheckBoxForCaseId(ISGLinkSolutionPage isgLinkSolutionPag) {
		isgLinkSolution = isgLinkSolutionPag.compareCaseIdsAndOpenCase().comparerecentlyOpenedCasesInLinkSolution();
		logger.log(LogStatus.PASS,
				"Comparing list of 5 recently opened Cases with checkBox, case ID and Summary and Clicking on checkCheckBoxForCaseId ");
		return isgLinkSolution;
	}

	// Lahari (03-08-2018): Opening the case that you choose to attach the solution
	public ISGLinkSolutionPage openCaseIdOfChooseSolution(ISGLinkSolutionPage isgLinkSolutionPag) {
		isgLinkSolution = isgLinkSolutionPag.openCase();
		logger.log(LogStatus.PASS, "Opening the case that you choose to attach the solution");
		return isgLinkSolution;
	}

	// Lahari (03-08-2018): Click on Solutions Search and // click on search
	public ISGLinkSolutionPage clickSolutionSearch(ISGLinkSolutionPage isgLinkSolutionPag) {
		isgLinkSolution = isgLinkSolutionPag.clickSoluSeach().clickSearchBtn();
		logger.log(LogStatus.PASS, "Clicking on Solutions Search and click on search");
		return isgLinkSolution;
	}

	/*************************** TC6806--end ************************/

	/*************************** TC6541--Start ************************/

	// Lahari (03-08-2018): selecting Transfer case to WB option from Actions
	public GSCRoutingPage selectTransWB(GSCRoutingPage gscRoutingPag) {
		gscRouting = gscRoutingPag.clickOnTransferToWorkBasket();
		logger.log(LogStatus.PASS, "selecting Transfer case to WB option from Actions ");
		return gscRouting;
	}

	// Lahari (03-08-2018): select value from WorkBasket and click on transfer
	public GSCRoutingPage selectValFromWBClkTrnsBtn(GSCRoutingPage gscRoutingPage, String workbasket) {
		gscRouting = gscRoutingPage.selectWorkBasketTrafCase(workbasket).transferBtn();
		logger.log(LogStatus.PASS, "selecting select WorkBasket value and  clicking on transfer button");
		return gscRouting;
	}

	// Lahari (03-08-2018):click on WorkGroupQueue
	public GSCRoutingFilterSearchPage gscRoutingFilterWBQueue(GSCRoutingPage gscRoutingPag) {
		gscRoutingFilterSearch = gscRoutingPag.clickOnWorkGroupQueue();
		logger.log(LogStatus.PASS, "Clicking on WorkGroupQueue");
		return gscRoutingFilterSearch;
	}

	// Lahari (03-08-2018): Get the case id and clicking on filters Link
	public GSCRoutingFilterSearchPage capCaseIdClkFilters(GSCRoutingFilterSearchPage gscRoutingFilterSearchPag) {
		gscRoutingFilterSearch = gscRoutingFilterSearchPag.setGscCaseID().clickFilters();
		// String caseid=gscRoutingFilterSearchPage.getGscCaseId();
		logger.log(LogStatus.PASS, "Capturing Case Id and  clicking on filters Link ");
		return gscRoutingFilterSearch;
	}

	// Lahari (03-08-2018): select value from WorkBasket and click on submit
	public GSCRoutingFilterSearchPage selectValFromWorkBasketandClikSubmit(
			GSCRoutingFilterSearchPage gscRoutingFilterSearchPag, String workbas) {
		gscRoutingFilterSearch = gscRoutingFilterSearchPag.selectFilterWorkBasket(workbas).submitBtn();
		logger.log(LogStatus.PASS, "selecting  value from WorkBasket and clicking on submit btn");
		return gscRoutingFilterSearch;
	}

	// Lahari (03-08-2018): select value from WorkBasket and click on submit
	public GSCRoutingFilterSearchPage verfyCaseIsExistInWBQ(GSCRoutingFilterSearchPage gscRoutingFilterSearchPag) {
		gscRoutingFilterSearch = gscRoutingFilterSearchPag.storeCaseIdIntoStringVar().verifyCaseIdExistInTable();
		logger.log(LogStatus.PASS, "selecting  value from WorkBasket and clicking on submit btn");
		return gscRoutingFilterSearch;
	}

	/*************************** TC6541--end ************************/

	/*************************** TC6551--end ************************/
	// Lahari (03-08-2018): click on WorkGroupQueue
	public GSCRoutingFilterSearchPage navToGSCRoutingFilterSearchclkWBQueue(GSCRoutingPage gscRoutingPag) {

		gscRoutingFilterSearch = gscRoutingPag.clickOnWorkGroupQueue();
		logger.log(LogStatus.PASS, "Clicking on WorkGroupQueue");
		return gscRoutingFilterSearch;
	}

	// Lahari (03-08-2018): Get the case id and clicking on filters Link
	public GSCRoutingFilterSearchPage capCaseId(GSCRoutingFilterSearchPage gscRoutingFilterSearchPag) {
		gscRoutingFilterSearch = gscRoutingFilterSearchPag.setGscCaseID();
		// String caseid=gscRoutingFilterSearchPage.getGscCaseId();
		logger.log(LogStatus.PASS, "Capturing Case Id ");
		return gscRoutingFilterSearch;
	}

	// Lahari (03-08-2018): select value from WorkBasket
	public GSCRoutingFilterSearchPage selectValFromWorkBasket(GSCRoutingFilterSearchPage gscRoutingFilterSearchPag,
			String workbas) {
		gscRoutingFilterSearch = gscRoutingFilterSearchPag.selectFilterWorkBasket(workbas);
		logger.log(LogStatus.PASS, "selecting  value from WorkBasket ");
		return gscRoutingFilterSearch;
	}

	/*************************** TC6551--end ************************/

	/*************************** TC6849--end ************************/
	// Lahari (03-08-2018): selecting transferToIndividual from Actions DD
	public GSCRoutingPage selectTransferToIndividual(GSCRoutingPage gscRoutingPag) {
		gscRouting = gscRoutingPag.clickOnTransferToIndividual();
		logger.log(LogStatus.PASS, "selecting transferToIndividual from Actions DD");
		return gscRouting;
	}

	// Lahari (03-08-2018): Entering invalid data into Operator field
	public GSCRoutingPage enterOperatorFiledDataInvalid(GSCRoutingPage gscRoutingPag, String oper) {
		gscRouting = gscRoutingPag.operatorFiledDataInval(oper);
		logger.log(LogStatus.PASS, " Entering data into Operator filed Data");
		return gscRouting;
	}

	// Lahari (03-08-2018): Entering valid data into Operator field
	public GSCRoutingPage enterOperatorFiledData(GSCRoutingPage gscRoutingPag, String oper) {
		gscRouting = gscRoutingPag.operatiorFiledDataValid(oper);
		logger.log(LogStatus.PASS, " Entering data into Operator field Data");
		return gscRouting;
	}

	// Lahari (03-08-2018): click on submit button
	public GSCRoutingPage clkSubmitBtnSwitchToAlert(GSCRoutingPage gscRoutingPag) {
		gscRouting = gscRoutingPag.submitBtnClick();
		logger.log(LogStatus.PASS, "  clicking on Submit button and handling the alert");
		return gscRouting;
	}

	// Lahari (03-08-2018): Entering data into Operator filed ,Selecting workbasket
	// value and
	// clicking on
	// submit button
	public GSCRoutingPage enterOperatorSelWBClkSub(GSCRoutingPage gscRoutingPag, String oper, String workbaket) {
		gscRouting = gscRoutingPag.operatiorFiledDataValid(oper).selectValFromWorkBasket(workbaket).clkSubmitBtn();
		logger.log(LogStatus.PASS,
				" Entering data into Operator filed ,Selecting workbasket value and clicking on submit button");
		return gscRouting;
	}

	// Lahari (03-08-2018): Perform Actions Functionalities
	// clickontransferToWorkBasket
	public GSCRoutingPage selectWorkCaseFrmActionsDD(GSCRoutingPage gscRoutingPag) {
		gscRouting = gscRoutingPag.clickonWorkCase();
		logger.log(LogStatus.PASS, "selecting WorkCase option from Actions ");
		return gscRouting;
	}

	// Lahari (03-08-2018):clickontransferToWorkBasket
	public GSCRoutingPage selectTranfWorkbasketFrmActionsDD(GSCRoutingPage gscRoutingPag) {
		gscRouting = gscRoutingPag.clickOnTransferToWorkBasket();
		logger.log(LogStatus.PASS, "selecting TransfertoWorkBasket  option from Actions ");
		return gscRouting;
	}

	// Lahari (03-08-2018): Clicking on Transfer button accepting alert
	public GSCRoutingPage clikTransfBtnAccetAlert(GSCRoutingPage gscRoutingPag) {
		gscRouting = gscRoutingPag.transferBtn().AcceptAlert();
		logger.log(LogStatus.PASS, "Clicking on Transfer button accepting alert ");
		return gscRouting;
	}

	// Lahari (03-08-2018): selecting Value From Workbasket and clicking on cancel
	// button
	public GSCRoutingPage selectWorkBasketFiledclickCancel(GSCRoutingPage gscRoutingPag) {
		gscRouting = gscRoutingPag.selectWB();
		logger.log(LogStatus.PASS, "  selecting Value From Workbasket and clicking on Cancel button");
		return gscRouting;
	}

	/*************************** TC6849--end ************************/
	/*************************** TC3670--end ************************/
	// Lahari (03-08-2018):opening webform
	public TechpubsLoginPage openWebformPortalTechpubs(WebDriver driver, String url) {
		driver.get(url);
		logger.log(LogStatus.PASS, "Opening Techpubs WebForm Portal");
		return new TechpubsLoginPage(driver);
	}

	// Lahari (03-08-2018): Logging into webforms
	public Techpubs logintoTechpubsWebform(TechpubsLoginPage techpubsLogin, String username, String password) {
		techpubsForm = techpubsLogin.enterUserName(username).enterPassword(password).clickSignInBtn();
		logger.log(LogStatus.PASS, "Logging into web form");
		return techpubsForm;
	}

	// Lahari (03-08-2018): Entering the WebForm Detailed_description
	public Techpubs enterdetailedDesUplaodFile(Techpubs techpub, String desc) {
		techpubsForm = techpub.detailedDescription(desc).uploadFile().clickSubmit();
		logger.log(LogStatus.PASS, "Entering description and uplaoding file");
		return techpubsForm;
	}

	// Lahari (03-08-2018): Get Case Id
	public Techpubs getCaseID(Techpubs techpub) {
		techpubsForm = techpub.getCaseID();
		logger.log(LogStatus.PASS, "Getting CaseId ");
		return techpubsForm;
	}

	// Lahari (03-08-2018): Click Case Search tab
	public CaseSearchPage clickCaseSearchHomeLnk(NavigationClass navigationClas) {
		caseSearch = navigationClas.clickCaseSearchHome();
		logger.log(LogStatus.PASS, "Clicking Case Search tab");
		return caseSearch;
	}

	// Lahari (03-08-2018): Navigate to Case Search page and switching to frame
	public ISGCasePage navigateToISGCasePage(CaseSearchPage caseSearchPag) {
		isgCase = caseSearchPag.navToISGCasePage();
		logger.log(LogStatus.PASS, "Navigating to Case Search page and Switchig to frame");
		return isgCase;
	}

	// Lahari (03-08-2018): clicking on Correspondence
	public ISGCaseSearchPage clickOnCorrespondence(ISGCasePage isgCasePag) {
		isgCaseSearch = isgCasePag.clkCorrespondence();
		logger.log(LogStatus.PASS, "clicking on Corresrpondence");
		return isgCaseSearch;
	}

	// Lahari (03-08-2018): click on new case creation Auto mail
	public ISGCaseSearchPage clickOnMail(ISGCaseSearchPage isgCaseSearchPag) {
		isgCaseSearch = isgCaseSearchPag.clickOnMail();
		logger.log(LogStatus.PASS, "clicking on Email link");
		return isgCaseSearch;
	}

	// Lahari (03-08-2018):Switching to Main Page
	public ISGCaseSearchPage switchToMainPage(ISGCaseSearchPage isgCaseSearchPag) {
		isgCaseSearch = isgCaseSearchPag.switchToMainPage();
		logger.log(LogStatus.PASS, "Switching to Main Page ");
		return isgCaseSearch;
	}

	/*************************** TC3670--end ************************/

	/*************************** TC3671--end ************************/
	// Lahari (03-08-2018): click on new case creation Auto mail
	public ViewEmailZeacomPage getOpenedCaseMessageZeacom(ViewEmailZeacomPage viewEmailZeacomPag) {
		viewEmailZeacom = viewEmailZeacomPag.getOpenedCaseMessageZeacom();
		logger.log(LogStatus.PASS, "Validatingd opened case Information details in zeacom ");
		return viewEmailZeacom;
	}

	// Lahari (03-08-2018): Switched to Main Page
	public ISGCasePage switchToMainPage(ViewEmailZeacomPage viewEmailZeacom) {
		isgCase = viewEmailZeacom.switchToMainPage();
		logger.log(LogStatus.PASS, "Switching to Main Page ");
		return isgCase;
	}

	/*************************** TC3671--end ************************/

	// --------------------Aparajita
	// 03-08-2018--------------------------------------------------------------------------
	// Entering GSC Customer details for withdrawing the case
	public GSCCustomerSearch enterGSCWithdrawDetails(GSCCustomerSearch gscCustomerSearch, String custfirstname,
			String custlastname, String country, String model, String farea, String fcode, String priority,
			String language, String origin, String summary, String workbasket) {
		gscCustomerSerch = gscCustomerSearch.enterCustomerFirstName(custfirstname).enterCustomerLastName(custlastname)
				.selectCountry(country).clickGscSearchCustomerBtn().clickSearchCustomerDetails().clickOnAddProductInfo()
				.enterProductModel(model).clickAddProductSubmit().enterCasecodingFA(farea).enterCasecodingFC(fcode)
				.enterPriority(priority).enterLanguage(language).enterOrigin(origin).enterAddSummary(summary);
		logger.log(LogStatus.PASS, "Entering GSC Customer details for withdrawing the case ");
		return gscCustomerSerch;
	}

	// click on cancel button and Actions button
	public GSCCustomerSearch clickOnCancelAndActns(GSCCustomerSearch gscCustomerSrch) {
		gscCustomerSearchPage = gscCustomerSrch.clickCancelBtn().clickOnAction();
		logger.log(LogStatus.PASS, "clciking on  cancel button and Actions button");
		return gscCustomerSearchPage;
	}

	// Click on GSC case from home page
	public CaseCoding clickOnGSCCaseCod(HomePage homePage) {
		casecodingPage = homePage.clickOnGSCCaseCo();
		logger.log(LogStatus.PASS, "Clicking on GSC case");
		return casecodingPage;
	}

	// Click Case Search tab
	public ISGCaseSearchPage clickOnCaseSearchHomeLink(NavigationClass navigationClas) {
		isgCaseSearch = navigationClas.clickCaseSearchHomeLink();
		logger.log(LogStatus.PASS, "Clicking on Case Search tab");
		return isgCaseSearch;
	}

	// ***************************************************************************
	// Navigate to Case Search page
	public CaseSearchPage navigateToCaseSerchPage(NavigationClass navigationCls) {
		caseSearch = navigationCls.clickCaseSearchHome();
		logger.log(LogStatus.PASS, "Navigating to Case Search  page");
		return caseSearch;
	}

	// Lahari(30-07-2018) : Entering the Case Id in Case Search Box and click on
	// case link
	public CaseSearchPage enterCaseIDClickCaseSerch(CaseSearchPage caseSearchPag, String caseId) {
		caseSearch = caseSearchPag.enterCaseIDInCaseSearchBox(caseId).clickCaseSearchImgLink().clickOnCasLink();
		logger.log(LogStatus.PASS, "Entering the Case Id in Case Search Box and clicking on case link");
		return caseSearch;
	}

	// Lahari(30-07-2018)Navigate to ISG case page
	public ISGCasePage navigateToISGCasPage(CaseSearchPage caseSearchPag) {
		isgCase = caseSearchPag.navToISGCasePage();
		logger.log(LogStatus.PASS, "Navigating to Case Search page and Switchig to frame");
		return isgCase;
	}

	/*
	 * //Lahari(30-07-2018) Navigate to ISGCaseSearchPage public ISGCaseSearchPage
	 * navigateToISGCaseSearchPage(CaseSearchPage caseSearchPag) { isgCaseSearch =
	 * caseSearchPag.navToISGCasePage(); logger.log(LogStatus.PASS,
	 * "Navigating to Case Search page and Switchig to frame"); return
	 * isgCaseSearch; }
	 */

	// *****************************************************************************
	// Report////

	// Navigate to GSCCaseCreation page
	public GSCCaseCreationPage navigateToGSCCaseCreationPage(GSCR4Page gscR4Pag) {
		gscCaseCreationPage = gscR4Pag.navigateToGSCCaseCreationPage();
		logger.log(LogStatus.PASS, "Switching to GSCCaseCreationPage");
		return gscCaseCreationPage;
	}

	// Click on Home Button of Main page
	public HomePage clickHomeLink(NavigationClass navigationClass) {
		homePage = navigationClass.clickHomeLink();
		logger.log(LogStatus.PASS, "Navigating to home page");
		return homePage;
	}

	// click on GSC Reports only
	public GSCR4Page clickGSCCaseReportOnly(HomePage homePage) {
		gscR4Page = homePage.clickGSCCaseReportOnly();
		logger.log(LogStatus.PASS, "Clicking GSC Case Reports only button");
		return gscR4Page;
	}

	// Click on Case Link to main Page
	public GSCR4Page clickCaseLinkGSCReportOnly(ISGCaseSearchPage isgCaseSearchPage) {
		gscR4Page = isgCaseSearchPage.clickCaseLinkGSCReportOnly();
		logger.log(LogStatus.PASS, "Clicking on Case search Link");
		return gscR4Page;
	}

	// Search for the customer
	public GSCCaseCreationPage gscSearchCustomerDetailsReportVerification(GSCCaseCreationPage gscCaseCreationPag,
			String custFirstName, String custLastName, String country, String model, String fArea, String fCode,
			String priority, String language, String origin, String summary, String workbasket) {
		gscCaseCreationPage = gscCaseCreationPag.enterCustomerFirstName(custFirstName)
				.enterCustomerLastName(custLastName).selectCountry(country).clickGSCSearchCustomer()
				.clickSearchCustomerDetails().clickOnAddProductInfo().enterProductModel(model).clickAddProductSubmit()
				.enterCasecodingFA(fArea).enterCasecodingFC(fCode).enterPriority(priority).enterLanguage(language)
				.enterOrigin(origin).enterAddSummary(summary).selectWorkBasket(workbasket).clickOnAcceptBtn();
		logger.log(LogStatus.PASS, "Searching customer ");
		return gscCaseCreationPage;
	}

	// Navigate to GSCCaseCreation page
	public GSCR4Page navigateToGSCR4Page(GSCCaseCreationPage gscCaseCreationPage) {
		gscR4Page = gscCaseCreationPage.navigateToGSCR4Page();
		logger.log(LogStatus.PASS, "Switching to GSCCaseCreationPage");
		return gscR4Page;
	}

	// click on casetype and give comments and internal comments
	public GSCR4Page selectCaseTypeValueTurf(GSCR4Page gscR4Pag, String caseType) {
		gscR4Page = gscR4Pag.selectCaseTypeValueTurf(caseType);
		logger.log(LogStatus.PASS, "selecting R4Turf as case value");
		return gscR4Page;
	}

	// click on close button
	public GSCR4Page clickOnClose(GSCR4Page gscR4Pag) {
		gscR4Page = gscR4Pag.clickOnClose();
		logger.log(LogStatus.PASS, "closing report only case");
		return gscR4Page;
	}

	// click on save button
	public GSCR4Page clickSave(GSCR4Page gscR4Pag) {
		gscR4Page = gscR4Pag.clickSave();
		logger.log(LogStatus.PASS, "saving report only case");
		return gscR4Page;
	}

	// switch to frame
	public GSCR4Page switchToIFrame(GSCR4Page gscR4Pag) {
		gscR4Page = gscR4Pag.switchToIFrame();
		logger.log(LogStatus.PASS, "Switching to frame");
		return gscR4Page;
	}

	// click on save button of Close box
	public GSCR4Page clickSaveInCloseBox(GSCR4Page gscR4Pag) {
		gscR4Page = gscR4Pag.clickSaveInCloseBox();
		logger.log(LogStatus.PASS, "closing report only case");
		return gscR4Page;
	}

	// Navigate to case search page
	public ISGCaseSearchPage navigateToCaseSearchPage(GSCR4Page gscR4Pag) {
		isgCaseSearchPage = gscR4Pag.navigateToCaseSearchPage();
		logger.log(LogStatus.PASS, "Navigating to case search page");
		return isgCaseSearchPage;
	}

	// Entering the Case Id in Case Search Box
	public ISGCaseSearchPage csEnterCaseId(ISGCaseSearchPage isgCaseSearchPag, String CaseId) {
		isgCaseSearchPage = isgCaseSearchPag.enterCaseIDInCaseSearchBox(CaseId);
		logger.log(LogStatus.PASS, "Entering the Case Id in Case Search Box");
		return isgCaseSearchPage;
	}

	// Click on Actions Button of R4Turf
	public GSCR4Page clickOnActionsR4Turf(GSCR4Page gscR4Pag) {
		gscR4Page = gscR4Pag.clickonActionsR4Turf().actions_ToTransferWBR4Turf();
		logger.log(LogStatus.PASS, "clicking on Actions button");
		return gscR4Page;
	}

	// Click on Actions_ToTransferWB button of R4Turf
	public GSCR4Page actions_ToTransferWBR4Turf(GSCR4Page gscR4Pag) {
		gscR4Page = gscR4Pag.actions_ToTransferWBR4Turf();
		logger.log(LogStatus.PASS, "Clicking on Actions_ToTransferWB button ");
		return gscR4Page;
	}

	// switch to Actions Frame of GSCR4Page
	public GSCR4Page switchToActionsIFrame(GSCR4Page gscR4Pag) {
		gscR4Page = gscR4Pag.switchToActionsIFrame();
		logger.log(LogStatus.PASS, "Switching to Actions frame");
		return gscR4Page;
	}

	private ISGWithdrawPage isgWithdraw;

	public ISGWithdrawPage clickWithdrawBtn(ISGWithdrawPage isgWithdrawPag) {
		isgCaseCreationPage = isgWithdrawPag.clickOnWithdraw();
		logger.log(LogStatus.PASS, "Click on withdraw button");
		return isgWithdraw;
	}

	// click on submit button
	public ISGCaseCreation clickSubmitButton(ISGCaseCreation isgCaseCreation) {
		isgCaseCreationPage = isgCaseCreation.clickSubmitButton();
		logger.log(LogStatus.PASS, "Click on submit button");
		return isgCaseCreationPage;
	}

	// click on withdraw button
	public ISGCaseCreation clickWithdrawBtn(ISGCaseCreation isgCaseCreation) {
		isgCaseCreationPage = isgCaseCreation.clickOnWithdraw();
		logger.log(LogStatus.PASS, "Click on withdraw button");
		return isgCaseCreationPage;
	}

	public ISGCaseCreation clickCancelAndActionBtn(ISGCaseCreation isgCaseCreation) {
		isgCaseCreationPage = isgCaseCreation.clickOnCancel().clickOnAction();
		logger.log(LogStatus.PASS, "Click on cancel button");
		return isgCaseCreationPage;
	}

	public ISGCaseCreation clickActionBtn(ISGCaseCreation isgCaseCreation) {
		isgCaseCreationPage = isgCaseCreation.clickOnAction();
		logger.log(LogStatus.PASS, "Click on action button");
		return isgCaseCreationPage;
	}

}