package com.deere.pages.webform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;

public class SouthEastAsiaLoginPage {

	@FindBy(xpath="//input[@name='username1']")
	private WebElement southEastAsiaUsername;
	
	@FindBy(xpath="//input[@name='password1']")
	private WebElement southEastAsiapassword;
	
	@FindBy(xpath="//input[@class='submit-btn cta_btn']")
	private WebElement southEastAsiaSubmit;

protected WebDriver driver;
	
	public  SouthEastAsiaLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public SouthEastAsiaLoginPage enterUserName(String username) {
		CommonFunctions.waitForElement(driver, southEastAsiaUsername).sendKeys(username);
		return new SouthEastAsiaLoginPage(driver);
	}
	
	public SouthEastAsiaLoginPage enterPassword(String password) {
		CommonFunctions.waitForElement(driver, southEastAsiapassword).sendKeys(password);
		return new SouthEastAsiaLoginPage(driver);
	}
	
	
	public SouthEastAsia clickSignInBtn() {
		CommonFunctions.waitForElement(driver, southEastAsiaSubmit).click();
		return new SouthEastAsia(driver);
	}

}
