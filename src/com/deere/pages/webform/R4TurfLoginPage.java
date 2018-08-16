package com.deere.pages.webform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;

public class R4TurfLoginPage {

	@FindBy(xpath = "//input[@id='userName1']")
	private WebElement r4TurfUsername;

	@FindBy(xpath = "//input[@id='password1']")
	private WebElement r4Turfpassword;

	@FindBy(xpath = "//input[@class='submit-btn cta_btn']")
	private WebElement r4TurfSubmit;

	protected WebDriver driver;

	public R4TurfLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public R4TurfLoginPage enterUserName(String username) {

		CommonFunctions.waitForElement(driver, r4TurfUsername).sendKeys(username);
		return new R4TurfLoginPage(driver);
	}

	public R4TurfLoginPage enterPassword(String password) {
		CommonFunctions.waitForElement(driver, r4Turfpassword).sendKeys(password);
		return new R4TurfLoginPage(driver);
	}

	public R4Turf clickSignInBtn() {
		CommonFunctions.waitForElement(driver, r4TurfSubmit).click();
		return new R4Turf(driver);
	}

}
