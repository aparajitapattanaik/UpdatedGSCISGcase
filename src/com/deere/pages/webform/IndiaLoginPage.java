package com.deere.pages.webform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;

public class IndiaLoginPage {

	@FindBy(xpath = "//input[@name='username1']")
	private WebElement indiaUsername;

	@FindBy(xpath = "//input[@name='password1']")
	private WebElement indiaPassword;

	@FindBy(xpath = "//input[@class='submit-btn cta_btn']")
	private WebElement indiaSubmit;

	protected WebDriver driver;

	public IndiaLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public IndiaLoginPage enterUserName(String username) {
		CommonFunctions.waitForElement(driver, indiaUsername).sendKeys(username);
		return new IndiaLoginPage(driver);
	}

	public IndiaLoginPage enterPassword(String password) {
		CommonFunctions.waitForElement(driver, indiaPassword).sendKeys(password);
		return new IndiaLoginPage(driver);
	}

	public India clickSignInBtn() {
		CommonFunctions.waitForElement(driver, indiaSubmit).click();
		return new India(driver);
	}

}
