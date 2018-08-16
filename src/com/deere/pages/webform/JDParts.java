package com.deere.pages.webform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;

public class JDParts {

	@FindBy(xpath = "//input[@name='username1']")
	private WebElement userName;

	@FindBy(xpath = "//input[@name='password1']")
	private WebElement passWord;

	@FindBy(xpath = "//input[@class='submit-btn cta_btn']")
	private WebElement submit;

	protected WebDriver driver;

	public JDParts(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public JDParts enterUserName(String username) {
		CommonFunctions.waitForElement(driver, userName).sendKeys(username);
		return new JDParts(driver);
	}

	public JDParts enterPassword(String password) {
		CommonFunctions.waitForElement(driver, passWord).sendKeys(password);
		return new JDParts(driver);
	}

	public JDPartsWebFormSubmissionPage clickSignInBtn() {
		CommonFunctions.waitForElement(driver, submit).click();
		return new JDPartsWebFormSubmissionPage(driver);
	}
}
