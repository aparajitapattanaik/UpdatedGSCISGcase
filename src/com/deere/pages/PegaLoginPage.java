package com.deere.pages;

import java.lang.reflect.Constructor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.deere.global.CommonFunctions;

public class PegaLoginPage {

	@FindBy(xpath = "//div[@class='logo-container']//img")
	private WebElement pegaLogo;

	@FindBy(id = "txtUserID")
	private WebElement useridTxtBox;

	@FindBy(id = "txtPassword")
	private WebElement passwordTxtBox;

	@FindBy(xpath = "//span[@class='loginButtonText']")
	private WebElement logInBtn;

	protected WebDriver driver;

	public PegaLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public PegaLoginPage enterUserId(String userId) {
		CommonFunctions.waitForElement(driver, useridTxtBox).sendKeys(userId);
		return new PegaLoginPage(driver);
	}

	public PegaLoginPage enterPassword(String password) {
		CommonFunctions.waitForElement(driver, passwordTxtBox).sendKeys(password);
		return new PegaLoginPage(driver);
	}

	public <T> T clickLogInBtn(Class<T> pomClass) {
		CommonFunctions.waitForElement(driver, logInBtn).click();
		try {
			Constructor<T> constructor = pomClass.getConstructor(WebDriver.class);
			return constructor.newInstance(driver);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public boolean hasPegaLoginPageDisplayed() {
		return CommonFunctions.isElementExist(driver, pegaLogo);
	}

}
