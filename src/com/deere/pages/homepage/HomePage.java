package com.deere.pages.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;
import com.deere.global.ExtentReportManager;
import com.deere.pages.SiteMinderLoginPage;
import com.deere.pages.greenfleet.GreenFleetCreationPage;
import com.deere.pages.gsccasecreation.CaseCoding;
import com.deere.pages.gsccasecreation.GSCCustomerSearch;
import com.deere.pages.gsccasecreation.GSCR4Page;
import com.deere.pages.gsccasecreation.GSCRoutingPage;
import com.deere.pages.isgcasecreation.ISGCaseCreation;
import com.deere.pages.isgcasecreation.ISGCaseCreationHomePage;
import com.deere.pages.isgcasecreation.ISGCasePage;
import com.deere.pages.isgcasecreation.ISGLinkSolutionPage;
import com.deere.pages.isgcasecreation.ISGRecommendedSolutionsSectionPage;
import com.deere.pages.solutionsearch.SolutionSearchHomePage;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage {

	@FindBy(xpath = "//span[@id='TABSPAN']/span/label[text()='Home']")
	private WebElement homeBtn;

	@FindBy(xpath = "//div[@node_name='TSSAgentHome']")
	private WebElement homePage;

	@FindBy(xpath = "//iframe[@id='PegaGadget0Ifr']")
	private WebElement iframePegaGadget;

	@FindBy(xpath = "//button[@class='JD_Home pzhc pzbutton'][contains(@data-click,'Deere-FW-CCMSFW-Work-Parts')]")
	private WebElement createDPACcaseBtn;

	@FindBy(xpath = "//label[text()='My Cases']")
	private WebElement myCasesLink;

	@FindBy(xpath = "//button[text()='Create DMAC Case']")
	private WebElement createDMACcaseBtn;

	@FindBy(xpath = "//button/span[text()='Create DMAC Case']")
	private WebElement createDMACcaseBtnDA;

	@FindBy(xpath = "//label[text() = 'My Organizati...']")
	private WebElement myOrganizationsCasesLink;

	@FindBy(xpath = "//a[@class='JD_Header_Link'][@title='Open Menu']")
	private WebElement openMenuDropDown;

	@FindBy(xpath = "//ul[contains(@id,'pyNavigation')]//li[3]//span[text()='Log off']")
	private WebElement logOffBtn;

	@FindBy(xpath = "//div[@id='RULE_KEY']//button[contains(@data-click,'Deere-FW-CCMSFW-Work-Parts')]")
	private WebElement createDPACCaseBtn;

	@FindBy(xpath = "//span[@id='modaldialog_hd_title']")
	private WebElement submitDPACCaseWindow;

	@FindBy(xpath = "//div[@id='RULE_KEY']//button[contains(@data-click,'Deere-FW-CCMSFW-Work-Service')]")
	private WebElement createDTACCase;

	@FindBy(xpath = "//span[@id='modaldialog_hd_title'][contains(text(),'Case creation prompt')]")
	private WebElement caseCreationPromptDTAC;

	@FindBy(xpath = "//button[@class='pzhc'][contains(@data-click,'Deere-CCMS-Case-CM-Work-Service')]")
	private WebElement okBtnCaseCreationPrompt;

	@FindBy(xpath = "//table[@id='RULE_KEY']//span/label[text()='Solution Search']")
	private WebElement solutionSearchTab;

	@FindBy(xpath = "//button[@data-test-id='20180201164005073171878']")
	private WebElement isgBtn;

	@FindBy(xpath = "//button[@data-test-id='20180201164005073171878']")
	private WebElement isgCaseCreationBtn;

	@FindBy(xpath = "//button[@data-test-id='20180201164005073171878']")
	private WebElement createISGCaseTab;
	
	@FindBy(xpath="//button[@data-test-id='20180201163908004467353']")
	private WebElement createGSCCaseTab;

	@FindBy(xpath = "(//label[contains(text(),'Home')])[1]")
	private WebElement hom;
	
	@FindBy(xpath = "//button[@data-test-id=\"201710051152570490264282\"][contains(text(),'Solution Search')]")
	private WebElement solutionSearchButton;

	@FindBy(xpath = "//button[@data-test-id='201710051152570490264282'][contains(text(),'Workgroup Queue')]")
	private WebElement workgroupQueue;

	@FindBy(xpath = "//button[@data-test-id='201710051152570490264282'][contains(text(),'FAQ/Help')]")
	private WebElement faqHelp;

	@FindBy(xpath = "//button[@data-test-id='201710051152570490264282'][contains(text(),'Create DTAC Case')]")
	private WebElement dtacTab;

	@FindBy(xpath = "//button[@data-test-id='20180201163908004467353'][contains(text(),'Create GSC Case')]")
	private WebElement gscTab;

	@FindBy(xpath = "//button[@data-test-id=\"201804021539280262224741\"][contains(text(),'Create GreenFleet Case')]")
	private WebElement greenFleetCase;

	@FindBy(xpath = "(//label[contains(text(),'Home')])[1]")
	private WebElement homePageTab;

	@FindBy(xpath = "//button[@data-test-id=\"201710051152570490264282\"][contains(text(),'My Cases')]")
	private WebElement myCases;

	@FindBy(xpath = "//button[@data-test-id='201710051152570490264282'][contains(text(),'Case Search')]")
	private WebElement caseSearch;

	@FindBy(xpath = "//button[@data-test-id='20180201163908004467353']")
	private WebElement createGreenfleetCaseDealerUser;
	
	@FindBy(xpath = "//button[@data-test-id='201804021539280262224741']")
	private WebElement createGreenfleetCase;
	
	@FindBy(xpath="//button[@data-test-id='201802140923560736151238'][contains(text(),'Create GSC Case')]")
	private WebElement gscCaseReportOnly;
	
	
	
	

	protected WebDriver driver;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public ISGRecommendedSolutionsSectionPage clickCreateISGCaseBtn() {
		CommonFunctions.waitForElement(driver, isgCaseCreationBtn).click();
		return new ISGRecommendedSolutionsSectionPage(driver);
	}

	public ISGCasePage clickCreateISGCaseHomeLink() {
		CommonFunctions.waitForElement(driver, createISGCaseTab).click();
		CommonFunctions.waitForAlert(driver);
		return new ISGCasePage(driver);
	}

	public boolean hasHomePageDisplayed() {
		return CommonFunctions.isElementExist(driver, homePage);
	}

	public boolean isHomePageDisplayed() {
		return CommonFunctions.isElementExist(driver, createDMACcaseBtn);
	}

	public boolean isHomePageDisplayedISG() {
		return CommonFunctions.isElementExist(driver, createISGCaseTab);
	}

	public boolean isHomePageDisplayedDA() {
		return CommonFunctions.isElementExist(driver, createDMACcaseBtnDA);
	}

	public synchronized SiteMinderLoginPage signOut(WebDriver driver) {
		try {
			driver.switchTo().defaultContent();
			CommonFunctions.waitForElement(driver, openMenuDropDown).click();
			CommonFunctions.waitForElement(driver, logOffBtn).click();
			ExtentReportManager.getLogger().log(LogStatus.PASS, "Logging Off from Application");
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return new SiteMinderLoginPage(driver);
	}

	public boolean hasCaseCreatedPromptDTACDisplayed() {
		return CommonFunctions.isElementExist(driver, caseCreationPromptDTAC);
	}

	public HomePage clickCreateDTACCaseBtn() {
		CommonFunctions.waitForElement(driver, createDTACCase).click();
		return new HomePage(driver);
	}

	public ISGCaseCreationHomePage clickISgBtn() {
		CommonFunctions.waitForElement(driver, isgBtn).click();

		return new ISGCaseCreationHomePage(driver);
	}

	public SolutionSearchHomePage clickSolutionSearchTab() {
		CommonFunctions.waitForElement(driver, solutionSearchTab).click();
		return new SolutionSearchHomePage(driver);
	}

	public boolean hasSolutionSearchTextDisplayed(String soluSech) {
		return CommonFunctions.waitForElement(driver, solutionSearchButton).getText().contains(soluSech);
	}

	public boolean hasWorkgroupDisplayed() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, workgroupQueue);
	}

	public GreenFleetCreationPage clickOnGreenFleetCaseForDealer() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, createGreenfleetCaseDealerUser).click();
		return new GreenFleetCreationPage(driver);
	}
	public GreenFleetCreationPage clickOnGreenFleetCase() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, createGreenfleetCase).click();
		return new GreenFleetCreationPage(driver);
	}
	
	public boolean hasFAQHelpDisplayed() {
		return CommonFunctions.isElementExist(driver, faqHelp);
	}

	public boolean hasDMACDisplayed() {
		return CommonFunctions.isElementExist(driver, createDMACcaseBtn);
	}

	public boolean hasDPACisplayed() {
		return CommonFunctions.isElementExist(driver, createDPACCaseBtn);
	}

	public boolean hasDTACisplayed() {
		return CommonFunctions.isElementExist(driver, dtacTab);
	}

	public boolean hasGSCCaseTextDisplayed(String gsccase) {
		return CommonFunctions.waitForElement(driver, gscTab).getText().contains(gsccase);
	}

	public boolean hasISGCaseTextDisplayed() {
		return CommonFunctions.isElementExist(driver, createISGCaseTab);
	}

	public boolean hasGreenfleetCaseTextDisplayed() {
		return CommonFunctions.isElementExist(driver, greenFleetCase);
	}

	public boolean hasMyCasesTextDisplayed(String myCasesTxt) {
		return CommonFunctions.waitForElement(driver, myCases).getText().contains(myCasesTxt);
	}

	public boolean hasCaseSearchTextDisplayed(String caseSearchTxt) {
		return CommonFunctions.waitForElement(driver, caseSearch).getText().contains(caseSearchTxt);
	}

	public ISGCasePage clickCreateISGCase() {
		CommonFunctions.waitForElement(driver, createISGCaseTab).click();
		CommonFunctions.waitForAlert(driver);
		return new ISGCasePage(driver);
	}
	
	public ISGCasePage clickCreateISGCaseForTranToWB() {
		try {
			Thread.sleep(3000);
		}catch(Exception e)
		{
			e.printStackTrace();
			}
		CommonFunctions.waitForElement(driver, createISGCaseTab).click();
		CommonFunctions.waitForAlert(driver);
		return new ISGCasePage(driver);
	}

	public boolean isHomePageDisplayed(String home) {
		try {
			Thread.sleep(3000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, hom).getText().contains(home);
	}

	public GSCCustomerSearch clickonGSCCase() {
		CommonFunctions.waitForElement(driver, createGSCCaseTab).click();
		return new GSCCustomerSearch(driver);
	}

	public CaseCoding clickonGSCCaseCo() {
		CommonFunctions.waitForElement(driver, createISGCaseTab).click();
		return new CaseCoding(driver);
	}

	public ISGCaseCreation clickCreateISGCas() {
		CommonFunctions.waitForElement(driver, createISGCaseTab).click();
		return new ISGCaseCreation(driver);
	}

	public boolean hasWorkgroupTextDisplayed(String wg) {
		try {

			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return CommonFunctions.waitForElement(driver, workgroupQueue).getText().contains(wg);
	}
	
	public ISGLinkSolutionPage clickOnHomeButton() {
		CommonFunctions.waitForElement(driver, homeBtn).click();
		return new ISGLinkSolutionPage(driver);
	}

	public boolean isHomePageDisplayedGSC(String home) {
		return CommonFunctions.isElementExist(driver, createISGCaseTab);
	}

	public boolean hasFAQHelpTextDisplayed(String faq) {
		return CommonFunctions.waitForElement(driver, faqHelp).getText().contains(faq);
	}

	public boolean hasDMACTextDisplayed(String dmac) {
		return CommonFunctions.waitForElement(driver, createDMACcaseBtn).getText().contains(dmac);
	}

	public boolean hasDPACTextDisplayed(String dpac) {
		return CommonFunctions.waitForElement(driver, createDPACCaseBtn).getText().contains(dpac);
	}

	public boolean hasDTACTextDisplayed(String dtac) {
		return CommonFunctions.waitForElement(driver, dtacTab).getText().contains(dtac);
	}
	
	public boolean hasGreenFleetCaseNotDisplayed(String dtac) {
		return CommonFunctions.waitForElement(driver, dtacTab).getText().contains(dtac);
	}

	public CaseCoding clickOnGSCCaseCo() {
		CommonFunctions.waitForElement(driver, createGSCCaseTab).click();
		return new CaseCoding(driver);
	}
	
	public GSCRoutingPage clickGSCCase() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, createGSCCaseTab).click();
		return new GSCRoutingPage(driver);
	}

	public GSCR4Page clickGSCCaseReportOnly() {
		CommonFunctions.waitForElement(driver, gscCaseReportOnly).click();
		return new GSCR4Page(driver);
	}
	
	
	
}
