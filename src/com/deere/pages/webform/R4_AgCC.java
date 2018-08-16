package com.deere.pages.webform;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.deere.global.CommonFunctions;


public class R4_AgCC {

	
	@FindBy(xpath = "//input[@name='username1']")
	private WebElement agccUsername;

	@FindBy(xpath = "//input[@name='password1']")
	private WebElement agccPassword;

	@FindBy(xpath = "//input[@class='submit-btn cta_btn']")
	private WebElement agccSubmit;

	@FindBy(xpath = "//textarea[@id='WebformComment']")
	private WebElement agccDescription;

	@FindBy(xpath = "//img[@name='MKTCaseAttachments_pyWorkPage_3']")
	private WebElement agccAttButton;

	@FindBy(xpath = "//input[@id='$PpyAttachmentPage$ppyNote']")
	private WebElement agccSelectButton;

	@FindBy(xpath = "data-test-id='20140919030420037410647'")
	private WebElement agccFileAttachButton;

	@FindBy(xpath = "//button[@data-test-id='2018032009190808106446']")
	private WebElement agccAttachSubmitButton;

	@FindBy(xpath = "//div[@data-test-id='2015012615503109611417']")
	private WebElement agccsubinfo;

	protected WebDriver driver;

	public R4_AgCC(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public R4_AgCC enterUserName(String username) {

		CommonFunctions.waitForElement(driver, agccUsername).sendKeys(username);
		return new R4_AgCC(driver);
	}

	public R4_AgCC enterPassword(String password) {
		CommonFunctions.waitForElement(driver, agccPassword).sendKeys(password);
		return new R4_AgCC(driver);
	}

	public R4_AgCCWebFormSubmissionPage clickSignInBtn() {
		CommonFunctions.waitForElement(driver, agccSubmit).click();
		return new R4_AgCCWebFormSubmissionPage(driver);
	}

}
