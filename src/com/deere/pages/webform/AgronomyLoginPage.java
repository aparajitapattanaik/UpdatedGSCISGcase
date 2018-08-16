package com.deere.pages.webform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;

public class AgronomyLoginPage {

	@FindBy(xpath = "//input[@name='username1']")
	private WebElement agrUsername;

	@FindBy(xpath = "//input[@name='password1']")
	private WebElement agrPassword;

	@FindBy(xpath = "//input[@class='submit-btn cta_btn']")
	private WebElement agrSubmit;

	protected WebDriver driver;

	public AgronomyLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public AgronomyLoginPage enterUserName(String username) {
		CommonFunctions.waitForElement(driver, agrUsername).sendKeys(username);
		return new AgronomyLoginPage(driver);
	}

	public AgronomyLoginPage enterPassword(String password) {
		CommonFunctions.waitForElement(driver, agrPassword).sendKeys(password);
		return new AgronomyLoginPage(driver);
	}

	public Agronomy clickSignInBtn() {
		CommonFunctions.waitForElement(driver, agrSubmit).click();
		return new Agronomy(driver);
	}
}
