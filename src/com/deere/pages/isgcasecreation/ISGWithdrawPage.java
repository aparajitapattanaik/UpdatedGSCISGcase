package com.deere.pages.isgcasecreation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;

public class ISGWithdrawPage {

	@FindBy(xpath = "//div[@data-test-id='20141009112130085821433']")
	private WebElement finalMessage;

	@FindBy(xpath = "(//div[contains(text(),\"Resolved-Withdrawn\")])[1]")
	private WebElement resolvedWithdrawn;

	@FindBy(xpath = "(//button[@data-test-id='2018021409524402562359'])[1]")
	private WebElement submitButton;
	
	@FindBy(xpath = " (//button[@data-test-id='20180531073524008831831'])[1]")
	private WebElement withdrawButton;

	protected WebDriver driver;

	public ISGWithdrawPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// validate withdraw page
	public boolean hasWithdrawPageDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, finalMessage);

	}

	// validate resolved withdrawn
	public boolean hasResolvedWithdrawn() {

		return CommonFunctions.isElementExist(driver, resolvedWithdrawn);

	}

	// click on submit button
	public ISGWithdrawPage clickSubmitButton() {
		CommonFunctions.waitForElement(driver, submitButton).click();
		return new ISGWithdrawPage(driver);
	}
	
	public ISGCaseCreation clickOnWithdraw() {
		CommonFunctions.waitForElement(driver, withdrawButton).click();
		return new ISGCaseCreation(driver);

	}
	

}
