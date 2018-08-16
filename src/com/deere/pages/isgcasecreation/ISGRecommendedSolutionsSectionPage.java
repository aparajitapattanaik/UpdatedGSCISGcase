package com.deere.pages.isgcasecreation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;

public class ISGRecommendedSolutionsSectionPage {

	@FindBy(xpath = "//button[@data-test-id='20180201164005073171878']")
	private WebElement isgCaseCreationBtn;

	@FindBy(xpath = "//span[contains(text(),'Recommended Solutions')]")
	private WebElement recommendedSolutions;

	@FindBy(xpath = "//iframe[@id='PegaGadget0Ifr']")
	private WebElement switchToFrame;

	@FindBy(xpath = "//iframe[@id='PegaGadget1Ifr']")
	private WebElement frame;

	@FindBy(xpath = "(//*[contains(text(),'Language')])[5]")
	private WebElement language;

	@FindBy(xpath = "//*[@data-test-id='201709191339170812600']//*[contains(text(),'ID')]")
	private WebElement id;

	@FindBy(xpath = "(//div[contains(text(),'Description')])[1]")
	private WebElement description;

	@FindBy(xpath = "//span[contains(text(),'Link New Solution')]")
	private WebElement linkSolution;

	@FindBy(xpath = "(//*[contains(text(),'Language')])[5]")
	private WebElement languageForLinkNewSolution;

	@FindBy(xpath = "(//div[contains(text(),'Description')])[2]")
	private WebElement descriptionForLinkNewSolution;

	@FindBy(xpath = "//div[contains(text(),'Link')]")
	private WebElement link;

	@FindBy(xpath = " //input[@class='customIntegerInput']")
	private WebElement solutionIdBox;

	@FindBy(xpath = " //img[@data-test-id='201709081532310671113459']")
	private WebElement searchIcon;

	@FindBy(xpath = " //span[@data-test-id='201708302308570779178839']")
	private WebElement valMesg;

	@FindBy(xpath = " //*[@data-test-id='201708302308570779178839']")
	private WebElement soluIdExist;

	@FindBy(xpath = " (//span[@data-test-id='2017083020192902615682'])[2]")
	private WebElement lanName;

	@FindBy(xpath = " (//*[@data-test-id='20160503060128021717349'])[2]")
	private WebElement solIdRecomnded;

	@FindBy(xpath = " //*[@data-test-id='20171114143911056685661']")
	private WebElement delete;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "1234")
	private WebElement idLinkText;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "72904")
	private WebElement soluId;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "HBI-AX-1345 APR 21")
	private WebElement solDesRecomnded;

	@FindBy(xpath = " //strong[contains(text(),'Solution Number: 1234')]")
	private WebElement solutionNumber;

	@FindBy(xpath = " //strong[contains(text(),'Solution Summary: HBI-AX-1345 APR')]")
	private WebElement solutionSummary;

	@FindBy(xpath = " //strong[contains(text(),'Publication Date')]")
	private WebElement publicationDate;

	@FindBy(xpath = "//span[@data-test-id='20150116110353086421138']")
	private WebElement isgPage;

	protected WebDriver driver;

	public ISGRecommendedSolutionsSectionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public ISGRecommendedSolutionsSectionPage clickCreateISGCaseBtn() {
		CommonFunctions.waitForElement(driver, isgCaseCreationBtn).click();
		return new ISGRecommendedSolutionsSectionPage(driver);
	}

	public boolean hasRecommendedSolutionsDisplayed(String recomSolu) {
		CommonFunctions.scrollSomeDown(driver);
		// CommonFunctions.scrollToElement(driver, recommendedSolutions);
		return CommonFunctions.waitForElement(driver, recommendedSolutions).getText().contains(recomSolu);
	}

	public boolean hasISGCaseCreationHomePageDisplayed(String isgPageverify) {
		return CommonFunctions.waitForElement(driver, isgPage).getText().contains(isgPageverify);
	}

	public ISGRecommendedSolutionsSectionPage switchToFrame() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitForElement(driver, switchToFrame);
		CommonFunctions.switchToiFrameByWebElement(driver, switchToFrame);
		return new ISGRecommendedSolutionsSectionPage(driver);
	}

	public boolean hasLanguagesDisplayed(String langVerfy) {
		return CommonFunctions.waitForElement(driver, language).getText().contains(langVerfy);
	}

	public boolean hasIDDisplayed(String idverfy) {
		return CommonFunctions.waitForElement(driver, id).getText().contains(idverfy);
	}

	public boolean hasDescriptionDisplayed(String desVerfy) {
		return CommonFunctions.waitForElement(driver, description).getText().contains(desVerfy);
	}

	public boolean hasLinkNewSolutionDisplayed(String soluVerfy) {
		CommonFunctions.scrollSomeDown(driver);
		return CommonFunctions.waitForElement(driver, linkSolution).getText().contains(soluVerfy);
	}

	public boolean hasLanguageForLinkNewSolutionDisplayed(String solLangVerfy) {
		return CommonFunctions.waitForElement(driver, languageForLinkNewSolution).getText().contains(solLangVerfy);
	}

	public boolean hasDescriptionForLinkNewSolutionDisplayed(String soluDescVefy) {
		return CommonFunctions.waitForElement(driver, descriptionForLinkNewSolution).getText().contains(soluDescVefy);
	}

	public boolean hasLinkDisplayed(String soluLinkVefy) {
		return CommonFunctions.waitForElement(driver, link).getText().contains(soluLinkVefy);
	}

	public boolean hasSolutionIDTextBoxDisplayed() {
		return CommonFunctions.isElementExist(driver, solutionIdBox);
	}

	public boolean hasSearchIconDisplayed() {
		return CommonFunctions.isElementExist(driver, searchIcon);
	}

	public ISGRecommendedSolutionsSectionPage clickSearchIcon() {
		CommonFunctions.waitForElement(driver, searchIcon).click();
		return new ISGRecommendedSolutionsSectionPage(driver);
	}

	public boolean hasValidationMesgDisplayed(String erorMesg) {
		return CommonFunctions.waitForElement(driver, valMesg).getText().contains(erorMesg);
	}

	public ISGRecommendedSolutionsSectionPage enterIdInSolSearchFiled(String id) {
		CommonFunctions.waitForElement(driver, solutionIdBox).sendKeys(id);
		return new ISGRecommendedSolutionsSectionPage(driver);
	}

	public boolean hasSolutionIDDisplayed(String soluIdVerfy) {
		return CommonFunctions.waitForElement(driver, soluId).getText().contains(soluIdVerfy);
	}

	public boolean hasSolutionIDRecomdedDisplayed(String string) {
		return CommonFunctions.isElementExist(driver, idLinkText);
	}

	public boolean hasValidationMessageDisplayed(String mesageVefy) {
		return CommonFunctions.waitForElement(driver, soluIdExist).getText().contains(mesageVefy);
	}

	public boolean hasLanguageNameDisplayed(String string) {
		return CommonFunctions.isElementExist(driver, lanName);
	}

	public boolean hasRecomdSolutionIDDisplayed(String string) {
		return CommonFunctions.isElementExist(driver, solIdRecomnded);
	}

	public boolean hasSolutionDescriptionDisplayed(String string) {
		return CommonFunctions.isElementExist(driver, solDesRecomnded);
	}

	public boolean hasDeleteIconDisplayed() {
		return CommonFunctions.isElementExist(driver, delete);
	}

	public ISGRecommendedSolutionsSectionPage clickOnSolutionIdLink() {
		CommonFunctions.waitForElement(driver, idLinkText).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ISGRecommendedSolutionsSectionPage(driver);
	}

	public ISGRecommendedSolutionsSectionPage frameSwitching() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitForElement(driver, frame);
		CommonFunctions.switchToiFrameByWebElement(driver, frame);
		return new ISGRecommendedSolutionsSectionPage(driver);
	}

	public boolean hasSolutionNumberDisplayed(String soluID) {
		return CommonFunctions.waitForElement(driver, solutionNumber).getText().contains(soluID);
	}

	public boolean hasSolutionSummaryDisplayed(String string) {
		return CommonFunctions.isElementExist(driver, solutionSummary);
	}

	public boolean hasPublicationDateDisplayed(String date) {
		return CommonFunctions.waitForElement(driver, publicationDate).getText().contains(date);
	}

}
