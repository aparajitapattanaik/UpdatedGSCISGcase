package com.deere.pages.workbasketqueue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;

public class WorkGroupQueuePage {

	@FindBy(xpath = "//label[contains(text(),'Workgroup Queue')]")
	private WebElement workGroupQue;

	@FindBy(xpath = "(//a[@title='Advanced Filters'])[1]")
	private WebElement filters;

	@FindBy(xpath = "//input[@data-test-id='20170923174822053693855']")
	private WebElement caseIdFiled;

	@FindBy(xpath = "//button[@data-test-id='20141008160437053510472']")
	private WebElement submitBtn;

	protected WebDriver driver;

	public WorkGroupQueuePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public WorkGroupQueuePage clickOnWrkGrpQue() {

		CommonFunctions.waitForElement(driver, workGroupQue).click();
		return new WorkGroupQueuePage(driver);
	}

	public WorkGroupQueuePage clickOnFilter() {
		CommonFunctions.waitForElement(driver, filters).click();
		return new WorkGroupQueuePage(driver);
	}

	public WorkGroupQueuePage enterDataInCaseIDField(String caseIdTxtFiled) {
		CommonFunctions.waitForElement(driver, caseIdFiled).sendKeys(caseIdTxtFiled);
		return new WorkGroupQueuePage(driver);
	}

	public WorkGroupQueuePage clickOnFilterSubmit() {
		CommonFunctions.waitForElement(driver, submitBtn).click();
		return new WorkGroupQueuePage(driver);
	}

}