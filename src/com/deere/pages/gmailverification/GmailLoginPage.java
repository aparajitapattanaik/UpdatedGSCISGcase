package com.deere.pages.gmailverification;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.deere.global.CommonFunctions;

public class GmailLoginPage {

	@FindBy(xpath = "//input[@id='identifierId']")
	private WebElement gmailLoginPageUserName;

	@FindBy(id = "identifierNext")
	private WebElement gmailLoginPageUserNameNext;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement gmailLoginPagePassword;

	@FindBy(id = "passwordNext")
	private WebElement gmailLoginPagePasswordNext;

	@FindBy(xpath = "(//a[@href='https://www.google.co.in/intl/en/options/'])[1]")
	private WebElement gmailAppButton;

	@FindBy(xpath = "//input[@aria-label='Search']")
	private WebElement gmailSearchBox;

	@FindBy(xpath = "//span[@class='gbqfi gb_hc']")
	private WebElement gmailSearchIcon;

	@FindBy(xpath = "(//span[contains(text(),\"Global Support Center Case Update\")])[3]")
	private WebElement inboxMessageLink;

	@FindBy(xpath = "//a[contains(text(),'Click here to add additional comments to the ')]")
	private WebElement addCommentsLink;

	protected WebDriver driver;

	public GmailLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public GmailLoginPage enterUserName(String username) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		CommonFunctions.waitForElement(driver, gmailLoginPageUserName).sendKeys(username);
		CommonFunctions.waitForElement(driver, gmailLoginPageUserNameNext).click();
		return new GmailLoginPage(driver);
	}

	public GmailLoginPage enterUserNameNext(String username) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		CommonFunctions.waitForElement(driver, gmailLoginPageUserNameNext).click();
		return new GmailLoginPage(driver);
	}

	public GmailLoginPage enterPassword(String password) {
		CommonFunctions.waitForElement(driver, gmailLoginPagePassword).sendKeys(password);
		CommonFunctions.waitForElement(driver, gmailLoginPagePasswordNext).click();
		return new GmailLoginPage(driver);
	}

	public GmailLoginPage gmailLoginPagePasswordNext(String username) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		CommonFunctions.waitForElement(driver, gmailLoginPagePasswordNext).click();
		return new GmailLoginPage(driver);
	}

	public GmailLoginPage clickSignInBtn() {
		CommonFunctions.waitForElement(driver, gmailLoginPagePasswordNext).click();
		return new GmailLoginPage(driver);
	}

	public boolean hasAppButtonExist() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(gmailAppButton));

		return CommonFunctions.isElementExist(driver, gmailAppButton);
	}

	public GmailLoginPage clickSearchBox() {
		CommonFunctions.waitForElement(driver, gmailSearchBox).click();
		return new GmailLoginPage(driver);

	}

	public GmailLoginPage enterValueInSearchBox(String caseid) {
		CommonFunctions.waitForElement(driver, gmailSearchBox).sendKeys(caseid);
		return new GmailLoginPage(driver);

	}

	public GmailLoginPage clickOnSearchIcon() {
		CommonFunctions.waitForElement(driver, gmailSearchIcon).click();
		return new GmailLoginPage(driver);
	}

	public GmailLoginPage clickInboxLink() {
		CommonFunctions.waitForElement(driver, inboxMessageLink).click();
		return new GmailLoginPage(driver);
	}

	public GmailLoginPage clickOnAddCommentsLink() {
		CommonFunctions.waitForElement(driver, addCommentsLink).click();
		return new GmailLoginPage(driver);
	}

}
