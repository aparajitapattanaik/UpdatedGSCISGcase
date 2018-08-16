package com.deere.pages.casesearch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;
import com.deere.global.GlobalThings;
import com.deere.pages.homepage.HomePage;
import com.deere.pages.isgcasecreation.ISGCasePage;
import com.deere.pages.isgcasecreation.ISGCaseSearchPage;

public class CaseSearchPage extends GlobalThings {

	@FindBy(name = "PegaGadget0Ifr")
	private WebElement iframePegaGadgetCaseSearch;

	@FindBy(xpath = "//input[@data-test-id='2015030515570700545405']")
	private WebElement caseSearchBox;
	
	@FindBy(xpath = "//img[contains(@data-click,'pyWorkSearch')]")
	private WebElement caseSearchImgLink;
	
	@FindBy(xpath = "//*[@data-test-id='20150212053008079033139']")
	private WebElement caseLinkToMainPage;
	
	@FindBy(xpath = "//iframe[@name='PegaGadget0Ifr']")
	private WebElement iframePegaGadget;

	@FindBy(xpath = "//input[@data-test-id='2015030515570700545405']")
	private WebElement searchTextBox;
	
	@FindBy(xpath = "//iframe[@name='PegaGadget1Ifr']")
	private WebElement iframe1;
	
	@FindBy(xpath = "(//*[@id='TABSPAN']/span/label)[2]")
	private WebElement gscCorrespondence;

	@FindBy(xpath = "//iframe[@name='PegaGadget1Ifr']")
	private WebElement iframe;
	
	protected WebDriver driver;
	
	public static String ParentHandle;

	public CaseSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	public boolean hasCaseSearchHomePageDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitAndSwitchToFrame(driver, iframePegaGadgetCaseSearch);
		return CommonFunctions.isElementExist(driver, caseSearchBox);
	}
	
	public CaseSearchPage enterCaseIDInCaseSearchBox(String caseId) {
		CommonFunctions.waitForElement(driver, caseSearchBox).sendKeys(caseId);
		return new CaseSearchPage(driver);
	}
	
	public CaseSearchPage clickCaseSearchImgLink() {
		CommonFunctions.waitForElement(driver, caseSearchImgLink).click();
		return new CaseSearchPage(driver);
	}
	public CaseSearchPage clickOnCasLink() {
		CommonFunctions.waitForElement(driver, caseLinkToMainPage).click();
		return new CaseSearchPage(driver);
	} 
	
	public ISGCasePage clickOnCaseLink() {
		CommonFunctions.waitForElement(driver, caseLinkToMainPage).click();
		return new ISGCasePage(driver);
	}
	
	


	public CaseSearchPage clickCaseLink() {
		CommonFunctions.waitForElement(driver, caseLinkToMainPage).click();
		return new CaseSearchPage(driver);
	}
	
	public boolean hasSolutionSearchHomePageDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitAndSwitchToFrame(driver, iframePegaGadget);
		return CommonFunctions.isElementExist(driver, searchTextBox);
	}
	
	public ISGCasePage navToISGCasePage() {
		CommonFunctions.waitForAlert(driver);
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitAndSwitchToFrame(driver, iframe1);
		return new ISGCasePage(driver);
	}


	
	

}
