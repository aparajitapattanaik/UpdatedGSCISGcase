package com.deere.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;

public class SiteMinderLoginPage {

	@FindBy(id = "username")
	private WebElement usernameTxtBox;

	@FindBy(name = "PASSWORD")
	private WebElement passwordTxtBox;

	@FindBy(className = "call-to-action")
	private WebElement signInBtn;

	@FindBy(xpath = "//div[text()='Sign In']")
	private WebElement signInText;

	protected WebDriver driver;

	public SiteMinderLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public SiteMinderLoginPage enterUserName(String username) {
		CommonFunctions.waitForElement(driver, usernameTxtBox).sendKeys(username);
		return new SiteMinderLoginPage(driver);
	}

	public SiteMinderLoginPage enterPassword(String password) {
		CommonFunctions.waitForElement(driver, passwordTxtBox).sendKeys(password);
		return new SiteMinderLoginPage(driver);
	}

	public PegaLoginPage clickSignInBtn() {
		CommonFunctions.waitForElement(driver, signInBtn).click();
		return new PegaLoginPage(driver);
	}

	public boolean hasPortalOpened() {
		return CommonFunctions.isElementExist(driver, signInText);
	}

	public String getSignInText() {
		return CommonFunctions.waitForElement(driver, signInText).getText();
	}
}
