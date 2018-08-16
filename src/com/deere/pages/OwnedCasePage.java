package com.deere.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;

public class OwnedCasePage {

	@FindBy(xpath = "//span[@data-test-id='20141009112850013217103']")
	private WebElement isgCaseId;

	protected WebDriver driver;

	public OwnedCasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public boolean hasISGCaseIdDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, isgCaseId);
	}

	public OwnedCasePage getISCCaseAId() {

		String Caseid = CommonFunctions.waitForElement(driver, isgCaseId).getText();
		System.out.println("ISGCaseId is " + Caseid);
		return new OwnedCasePage(driver);
	}

}
