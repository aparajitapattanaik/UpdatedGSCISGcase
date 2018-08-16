package com.deere.pages.webform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;

public class TechpubsLoginPage {

	@FindBy(xpath = "//input[@id='userName1']")
	private WebElement tpUsername;

	@FindBy(xpath = "//input[@id='password1']")
	private WebElement tppassword;

	@FindBy(xpath = "//input[@class='submit-btn cta_btn']")
	private WebElement tpSubmit;

	protected WebDriver driver;

	public TechpubsLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public TechpubsLoginPage enterUserName(String username) {
      CommonFunctions.waitForElement(driver, tpUsername).sendKeys(username);
		return new TechpubsLoginPage(driver);
	}

	public TechpubsLoginPage enterPassword(String password) {
		CommonFunctions.waitForElement(driver, tppassword).sendKeys(password);
		return new TechpubsLoginPage(driver);
	}

	public Techpubs clickSignInBtn() {
		CommonFunctions.waitForElement(driver, tpSubmit).click();
		return new Techpubs(driver);
	}

}
