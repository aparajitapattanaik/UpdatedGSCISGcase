package com.deere.pages.webform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;

public class SouthSaharaLoginPage {

	@FindBy(xpath = "//input[@name='username1']")
	private WebElement southSaharaUsername;

	@FindBy(xpath = "//input[@name='password1']")
	private WebElement southSaharapassword;

	@FindBy(xpath = "//input[@class='submit-btn cta_btn']")
	private WebElement southSaharaSubmit;

	protected WebDriver driver;

	public SouthSaharaLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public SouthSaharaLoginPage enterUserName(String username) {
		CommonFunctions.waitForElement(driver, southSaharaUsername).sendKeys(username);
		return new SouthSaharaLoginPage(driver);
	}

	public SouthSaharaLoginPage enterPassword(String password) {
		CommonFunctions.waitForElement(driver, southSaharapassword).sendKeys(password);
		return new SouthSaharaLoginPage(driver);
	}

	public SouthSahara clickSignInBtn() {
		CommonFunctions.waitForElement(driver, southSaharaSubmit).click();
		return new SouthSahara(driver);
	}

}
