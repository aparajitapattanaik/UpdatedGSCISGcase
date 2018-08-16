package com.deere.pages.webform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.deere.global.CommonFunctions;


public class StellarSupport {

	@FindBy(xpath = "//input[@name='username1']")
	private WebElement ssUsername;

	@FindBy(xpath = "//input[@name='password1']")
	private WebElement sspassword;

	@FindBy(xpath = "//input[@class='submit-btn cta_btn']")
	private WebElement ssSubmit;

	@FindBy(xpath = "#DecalModel")
	private WebElement ssDashboard_SelectProduct;

	@FindBy(xpath = "#PIN")
	private WebElement ssDashboard_MachinePIN;

	@FindBy(xpath = "//textarea[@id='WebformComment']")
	private WebElement ssDashboard_Description;

	@FindBy(xpath = "#DealerName")
	private WebElement ssDashboard_Dealername;

	@FindBy(xpath = "#DealerCity")
	private WebElement ssDashboard_DealerCity;

	@FindBy(xpath = "#DealerState")
	private WebElement ssDashboard_DealerState;

	@FindBy(xpath = "//img[@name='MKTCaseAttachments_pyWorkPage_3']")
	private WebElement ssDashboard_AttButton;

	@FindBy(xpath = "//input[@id='$PpyAttachmentPage$ppyNote']")
	private WebElement ssDashboard_SelectButton;

	@FindBy(xpath = "data-test-id='20140919030420037410647'")
	private WebElement ssDashboard_FileAttachButton;

	@FindBy(xpath = "//button[@data-test-id='2018032009190808106446']")
	private WebElement ssDashboard_AttachSubmitButton;

	@FindBy(xpath = "//div[@data-test-id='2015012615503109611417']")
	private WebElement ssDashboard_subinfo;

	protected WebDriver driver;

	public StellarSupport(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public StellarSupport enterUserName(String username) {
		CommonFunctions.waitForElement(driver, ssUsername).sendKeys(username);
		return new StellarSupport(driver);
	}

	public StellarSupport enterPassword(String password) {
		CommonFunctions.waitForElement(driver, sspassword).sendKeys(password);
		return new StellarSupport(driver);
	}

	public StellarSupportWebformSubmissionPage clickSignInBtn() {
		CommonFunctions.waitForElement(driver, ssSubmit).click();
		return new StellarSupportWebformSubmissionPage(driver);
	}

}
