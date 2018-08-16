package com.deere.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;
import com.deere.pages.casesearch.CaseSearchPage;
import com.deere.pages.greenfleet.GreenFleetCreationPage;
import com.deere.pages.gsccasecreation.GSCCaseCreationPage;
import com.deere.pages.gsccasecreation.GSCCustomerSearch;
import com.deere.pages.gsccasecreation.GSCR4Page;
import com.deere.pages.gsccasecreation.GSCRoutingFilterPage;
import com.deere.pages.gsccasecreation.GSCRoutingPage;
import com.deere.pages.homepage.HomePage;
import com.deere.pages.isgcasecreation.ISGCaseCreation;
import com.deere.pages.isgcasecreation.ISGCaseCreationHomePage;
import com.deere.pages.isgcasecreation.ISGCaseSearchPage;
import com.deere.pages.isgcasecreation.ISGLinkSolutionPage;
import com.deere.pages.isgcasecreation.ISGRecommendedSolutionsSectionPage;
import com.deere.pages.reports.ReportsPage;
import com.deere.pages.solutionsearch.SolutionSearchHomePage;

public class NavigationClass {

	@FindBy(xpath = "//span//label[text()='Home']")
	private WebElement home;

	@FindBy(xpath = "//a[@class='JD_Header_Secondary']")
	private WebElement header;

	@FindBy(xpath = "//button[text()='Case Search']")
	private WebElement caseSearchBtn;

	@FindBy(xpath = "//iframe[contains(@src,'ViewOnlyUserHome')]")
	private WebElement pegaGadgetIframe;

	@FindBy(xpath = "//iframe[contains(@src,'TCSMWorkGroupArea')]")
	private WebElement pegaGadgetFrame;

	@FindBy(xpath = "//div[@role='menuitem']//h3[text()='My Territory']")
	private WebElement myTerritoryLink;
	

	@FindBy(xpath = "//li[contains(@title,'Solution Search')]")
	private WebElement solutionSearchTab;

	@FindBy(xpath = "//label[text()='My Territory']")
	private WebElement myTerritoryMainLink;

	@FindBy(xpath = "//label[contains(text(),'Reports')]")
	private WebElement reportsLink;

	@FindBy(xpath = "//li[@aria-label='Case Search']")
	private WebElement caseSearchTab;

	@FindBy(xpath = "//button[@class='JD_Home pzhc pzbutton'][contains(@data-click,'Deere-CCMS-Case-CM-Work-ISG')]")
	private WebElement createISGCaseTab;

	@FindBy(xpath = "(//i[@data-test-id='201512210438090148308293'])[1]")
	private WebElement addCustomerInfoLink;
	
	@FindBy(xpath="//button[@data-test-id=\"201802140923560736151238\"][contains(text(),'Create GSC Case')]")
	private WebElement gscCaseReportOnly;

	protected WebDriver driver;

	public NavigationClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public HomePage clickHomeMenuButton() {
		CommonFunctions.waitForElement(driver, home).click();
		return new HomePage(driver);
	}

	public ISGLinkSolutionPage clickHomeButton() {
		CommonFunctions.waitForElement(driver, home).click();
		return new ISGLinkSolutionPage(driver);
	}

	public GSCRoutingPage clickHomeButn() {
		CommonFunctions.waitForElement(driver, home).click();
		return new GSCRoutingPage(driver);
	}

	public ISGRecommendedSolutionsSectionPage clickHomeBtn() {
		CommonFunctions.waitForElement(driver, home).click();
		return new ISGRecommendedSolutionsSectionPage(driver);
	}

	public HomePage clickOnHomeButton() {
		CommonFunctions.waitForElement(driver, home).click();
		return new HomePage(driver);
	}
	
	public CaseSearchPage clickCaseSearch() {
		CommonFunctions.waitForElement(driver, caseSearchTab).click();
		return new CaseSearchPage(driver);
	} 
	
	public HomePage clickHomeBtnOne() {
		CommonFunctions.waitForElement(driver, home).click();
		return new HomePage(driver);
	} 
	public CaseSearchPage clickCaseSearchHome() {
		CommonFunctions.waitForElement(driver, caseSearchTab).click();
		return new CaseSearchPage(driver);
	} 


	public NavigationClass switchToIframe() {
		CommonFunctions.waitAndSwitchToFrame(driver, pegaGadgetIframe);
		return new NavigationClass(driver);
	}

	public SolutionSearchHomePage clickSolutionSearchHomeLink() {
		CommonFunctions.waitForElement(driver, solutionSearchTab).click();
		return new SolutionSearchHomePage(driver);
	}

	public boolean hasMyTerritoryPageDisplayed() {
		CommonFunctions.switchToiFrameByWebElement(driver, pegaGadgetFrame);
		return CommonFunctions.isElementExist(driver, myTerritoryLink);
	}

	public boolean isLandingPageDisplayed(String heardeText) {
		return CommonFunctions.waitForElement(driver, header).getText().contains(heardeText);
	}

	public boolean isLandingPageDisplayed() {
		return CommonFunctions.isElementExist(driver, header);
	}

	public GSCCustomerSearch clickHomePageLink() {
		CommonFunctions.waitForElement(driver, home).click();
		return new GSCCustomerSearch(driver);

	}

	public GSCRoutingFilterPage routingFilterHomePageLink() {
		CommonFunctions.waitForElement(driver, home).click();
		return new GSCRoutingFilterPage(driver);
	}

	public HomePage clickHomePageLinkOne() {
		CommonFunctions.waitForElement(driver, home).click();
		return new HomePage(driver);

	}

	public ReportsPage clickReportsLink() {
		CommonFunctions.waitForElement(driver, reportsLink).click();
		return new ReportsPage(driver);
	}

	public ISGCaseSearchPage clickCaseSearchHomeLink() {
		CommonFunctions.waitForElement(driver, caseSearchTab).click();
		return new ISGCaseSearchPage(driver);
	}

	public GSCCustomerSearch clickHomePageButton() {
		CommonFunctions.waitForElement(driver, home).click();
		return new GSCCustomerSearch(driver);

	}

	public ISGCaseCreation isgHomePageLink() {
		CommonFunctions.waitForElement(driver, home).click();
		return new ISGCaseCreation(driver);
	}

	public GreenFleetCreationPage clickHome() {
		CommonFunctions.waitForElement(driver, home).click();
		return new GreenFleetCreationPage(driver);
	}

	public GSCCaseCreationPage clickHomePagLink() {
		CommonFunctions.waitForElement(driver, home).click();
		return new GSCCaseCreationPage(driver);
	}

	public ISGCaseCreation clickCreateISGCas() {
		CommonFunctions.waitForElement(driver, createISGCaseTab).click();
		return new ISGCaseCreation(driver);
	}

	public HomePage clickHomeLink() {
		CommonFunctions.waitForElement(driver, home).click();
		return new HomePage(driver);
	}

	public ISGCaseCreationHomePage clickOnHomeBtn() {
		CommonFunctions.waitForElement(driver, home).click();
		return new ISGCaseCreationHomePage(driver);
	}

	public HomePage clickOnHome() {
		CommonFunctions.waitForElement(driver, home).click();
		return new HomePage(driver);
	}

	public HomePage clickOnGrnFltHome() {
		CommonFunctions.waitForElement(driver, home).click();
		return new HomePage(driver);
	}

	public HomePage clickHomePageLinkGF() {
		CommonFunctions.waitForElement(driver, home).click();
		return new HomePage(driver);

	}
	public GSCR4Page clickGSCCaseReportOnly() {
		CommonFunctions.waitForElement(driver, gscCaseReportOnly).click();
		return new GSCR4Page(driver);
	}
	

}
