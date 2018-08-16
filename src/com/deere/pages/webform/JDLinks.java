package com.deere.pages.webform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.deere.global.CommonFunctions;
import com.deere.pages.webform.JDLinksWebFormSubmitionPage;

public class JDLinks {

	@FindBy(xpath = "//input[@name='username1']")
	private WebElement jdUserName;

	@FindBy(xpath = "//input[@name='password1']")
	private WebElement jdPassword;

	@FindBy(xpath = "//input[@class='submit-btn cta_btn']")
	private WebElement jdSubmit;

	protected WebDriver driver;

	public JDLinks(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public JDLinks enterUserName(String username) {
		CommonFunctions.waitForElement(driver, jdUserName).sendKeys(username);
		return new JDLinks(driver);
	}

	public JDLinks enterPassword(String password) {
		CommonFunctions.waitForElement(driver, jdPassword).sendKeys(password);
		return new JDLinks(driver);
	}

	public JDLinksWebFormSubmitionPage clickSignInBtn() {
		CommonFunctions.waitForElement(driver, jdSubmit).click();
		return new JDLinksWebFormSubmitionPage(driver);
	}

}
