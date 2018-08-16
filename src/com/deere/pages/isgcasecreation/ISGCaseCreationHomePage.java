package com.deere.pages.isgcasecreation;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;

public class ISGCaseCreationHomePage {

	@FindBy(xpath = "//iframe[contains(@src,'ISG')]")
	private WebElement iframePegaGadget;

	@FindBy(xpath = "//span[@data-test-id='20150116110353086421138']")
	private WebElement isgPage;

	@FindBy(xpath = "//h2[contains(text(),'Case Information')]")
	private WebElement caseInfrom;

	@FindBy(xpath = "//select[@data-test-id='20160208091722005978870']")
	private WebElement priority;

	@FindBy(xpath = "//select[@data-test-id='20180424140126019614930']")
	private WebElement language;

	@FindBy(xpath = "//select[@data-test-id='20180424140140011822773']")
	private WebElement origin;

	@FindBy(xpath = "//input[@data-test-id='201803070836380322140204']")
	private WebElement nccaTxtBox;

	@FindBy(xpath = "//input[@data-test-id='201803070836380323151294']")
	private WebElement rallyTxtBox;

	@FindBy(xpath = "//input[@data-test-id='20180424140448030737529']")
	private WebElement solutionCreateChekBox;

	@FindBy(xpath = "//img[@src='cmicons/pyeye_13538075734.png!!.png']")
	private WebElement caseCretionEyeIcon;

	@FindBy(xpath = "//*[@id='po0']")
	private WebElement smallPopUp;

	@FindBy(xpath = "//span[@data-test-id='20180305082748020421782-Label']")
	private WebElement createdOn;

	@FindBy(xpath = "//span[@data-test-id='20180305082748020522224-Label']")
	private WebElement lastAssigned;

	@FindBy(xpath = "//span[@data-test-id='2018030508274802052377-Label']")
	private WebElement lastModified;

	@FindBy(xpath = "//span[@data-test-id='20180305082748020421782']")
	private WebElement createdOnWithDateTimeInfm;

	@FindBy(xpath = "//span[@data-test-id='20180305082748020522224']")
	private WebElement lastAssignedWithDateTimeInfm;

	@FindBy(xpath = "//span[@data-test-id='2018030508274802052377']")
	private WebElement lastModifiedWithDateTimeInfm;

	@FindBy(xpath = "//button[@data-test-id='20140919030420037410647']")
	private WebElement submitBtn;

	@FindBy(xpath = "//input[@data-test-id='2015100603215503417556']")
	private WebElement productInfoModelDD;

	@FindBy(xpath = "//table[@id='bodyTbl_right']/tbody//div[@class='oflowDiv']//span[@class='match-highlight']")
	private WebElement modelAutoOptions;

	@FindBy(xpath = "(//i[@data-test-id='201512210438090148308293'])[2]")
	private WebElement addProdBtn;

	@FindBy(xpath = "//h2[contains(text(),'Product')]")
	private WebElement prodHeading;

	@FindBy(xpath = "//a[@title='Edit']")
	private WebElement editBtn;

	@FindBy(xpath = "//*[@id='modaldialog_hd'] ")
	private WebElement prodInfm;

	@FindBy(xpath = "//button[@data-test-id='20180201164005073171878']")
	private WebElement isgCaseCreationBtn;

	@FindBy(xpath = "//button[@data-test-id='20180201164005073171878']")
	private WebElement isgBtn;

	@FindBy(xpath = "//iframe[@id='PegaGadget0Ifr']")
	private WebElement switchToFrame;

	protected WebDriver driver;

	public ISGCaseCreationHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public ISGCaseCreationHomePage clickCreateISGCaseBtn() {
		CommonFunctions.waitForElement(driver, isgCaseCreationBtn).click();
		return new ISGCaseCreationHomePage(driver);
	}

	public boolean hasISGCaseCreationHomePageDisplayed(String isgPageVerification) {
		return CommonFunctions.waitForElement(driver, isgPage).getText().contains(isgPageVerification);
	}

	public boolean hasCaseInformationSectionDisplayed(String caseInformation) {
		CommonFunctions.scrollToElement(driver, caseInfrom);
		return CommonFunctions.waitForElement(driver, caseInfrom).getText().contains(caseInformation);
	}

	public boolean hasPriorityDropDownDisplayed() {

		return CommonFunctions.isElementExist(driver, priority);
	}

	public boolean hasLanguageDropDownDisplayed() {
		return CommonFunctions.isElementExist(driver, language);
	}

	public boolean hasOriginDropDownDisplayed() {
		return CommonFunctions.isElementExist(driver, origin);
	}

	public boolean hasNCCATextFieldDisplayed() {
		return CommonFunctions.isElementExist(driver, nccaTxtBox);
	}

	public boolean hasRallyTextFieldDisplayed() {
		return CommonFunctions.isElementExist(driver, rallyTxtBox);
	}

	public boolean hasSolutionCreateChekBoxdDisplayed() {
		return CommonFunctions.isElementExist(driver, solutionCreateChekBox);
	}

	public boolean hasCaseCreationEYEIconDisplayed() {
		return CommonFunctions.isElementExist(driver, caseCretionEyeIcon);
	}

	public ISGCaseCreationHomePage clickEyeBtn() {
		CommonFunctions.waitForElement(driver, caseCretionEyeIcon).click();
		return new ISGCaseCreationHomePage(driver);
	}

	public boolean hasSmallPopUpDisplayed() {
		return CommonFunctions.isElementExist(driver, smallPopUp);
	}

	public boolean hasCreatedOnDisplayed(String createdOnInfm) {
		return CommonFunctions.waitForElement(driver, createdOn).getText().contains(createdOnInfm);
	}

	public boolean hasLastAssignedDisplayed(String dateofLastAssin) {
		return CommonFunctions.waitForElement(driver, lastAssigned).getText().contains(dateofLastAssin);
	}

	public boolean hasLastModifiedDisplayed(String dateofLastMod) {
		return CommonFunctions.waitForElement(driver, lastModified).getText().contains(dateofLastMod);
	}

	public boolean hasCreatedOnWithDateTimeInfmDisplayed() {
		return CommonFunctions.isElementExist(driver, createdOnWithDateTimeInfm);
	}

	public boolean hasLastAssignedWithDateTimeInfmDisplayed() {
		return CommonFunctions.isElementExist(driver, lastAssignedWithDateTimeInfm);
	}

	public boolean hasLastModifiedWithDateTimeInfmDisplayed() {
		return CommonFunctions.isElementExist(driver, lastModifiedWithDateTimeInfm);
	}

	public ISGCaseCreationHomePage productInfoModel(String model) {
		CommonFunctions.scrollToWebElement(driver, addProdBtn);
		CommonFunctions.waitForElement(driver, addProdBtn).click();
		CommonFunctions.waitForElement(driver, productInfoModelDD).sendKeys(model);
		productInfoModelDD.sendKeys(Keys.ARROW_DOWN);
		CommonFunctions.waitForElement(driver, modelAutoOptions);
		try {
			if (modelAutoOptions.getText().contains(model))
				modelAutoOptions.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, submitBtn).click();
		return new ISGCaseCreationHomePage(driver);
	}

	public ISGCaseCreationHomePage editproductInfoModel(String model) {
		CommonFunctions.waitForElement(driver, productInfoModelDD).sendKeys(model);
		productInfoModelDD.sendKeys(Keys.ARROW_DOWN);
		CommonFunctions.waitForElement(driver, modelAutoOptions);
		try {
			if (modelAutoOptions.getText().contains(model))
				modelAutoOptions.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, submitBtn).click();
		return new ISGCaseCreationHomePage(driver);
	}

	public boolean hasProductHeadingDisplayed(String prodcutSys) {
		return CommonFunctions.waitForElement(driver, prodHeading).getText().contains(prodcutSys);
	}

	public ISGCaseCreationHomePage clickEdit() {
		CommonFunctions.isElementExist(driver, editBtn);
		CommonFunctions.waitForElement(driver, editBtn).click();
		return new ISGCaseCreationHomePage(driver);
	}

	public boolean hasProductInfDisplayed(String productInfo) {
		return CommonFunctions.waitForElement(driver, prodInfm).getText().contains(productInfo);
	}

	public ISGCaseCreationHomePage clickISgBtn() {
		CommonFunctions.waitForElement(driver, isgBtn).click();
		return new ISGCaseCreationHomePage(driver);
	}

	public ISGCaseCreationHomePage switchToFrame() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitForElement(driver, switchToFrame);
		CommonFunctions.switchToiFrameByWebElement(driver, switchToFrame);
		return new ISGCaseCreationHomePage(driver);
	}

	public ISGCaseCreationHomePage clearproductInfoModel() {
		CommonFunctions.waitForElement(driver, productInfoModelDD).clear();
		return new ISGCaseCreationHomePage(driver);
	}

}
