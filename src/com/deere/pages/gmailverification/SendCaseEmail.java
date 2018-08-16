package com.deere.pages.gmailverification;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;

public class SendCaseEmail {

	@FindBy(xpath = "//span[contains(text(),'Send Case Email')]")
	private WebElement clickGSCSendCaseMailButton;

	@FindBy(xpath = "//input[@data-test-id='201612271036230356233958']")
	private WebElement clickGSCEmailEnterBox;

	@FindBy(xpath = "//button[@data-test-id='20140919030420037410647']")
	private WebElement sendButton;

	@FindBy(xpath = "//div[@data-node-id='JDStandardModalTemplateSendCaseEmail']")
	private WebElement sendMailPopUp;

	@FindBy(xpath = "//span[@id='modaldialog_hd_title']")
	private WebElement sendMailPopUpHeding;

	@FindBy(xpath = "//input[@data-test-id='201612271036230356233958']")
	private WebElement toTxtField;

	@FindBy(xpath = "//div[@data-test-id='201612271036230340230136']")
	private WebElement toLabel;

	@FindBy(xpath = "//input[@data-test-id='20170908094953025718646']")
	private WebElement checkBox;

	@FindBy(xpath = "//iframe[@name='PegaGadget1Ifr']")
	private WebElement iframe;

	protected WebDriver driver;

	public SendCaseEmail(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public boolean hasSendEmailPopUpDisplayed() {
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return CommonFunctions.isElementExist(driver, sendMailPopUp);
	}

	public SendCaseEmail enterSendCaseMail(String mail) {
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, clickGSCEmailEnterBox).sendKeys(mail);
		return new SendCaseEmail(driver);

	}

	public SendCaseEmail clickSendButton() {

		CommonFunctions.waitForElement(driver, sendButton).click();
		return new SendCaseEmail(driver);

	}

	public SendCaseEmail enterToFieldData(String data) {
		CommonFunctions.isElementExist(driver, sendMailPopUpHeding);
        CommonFunctions.isElementExist(driver, toLabel);
		CommonFunctions.waitForElement(driver, toTxtField).sendKeys(data);
		//CommonFunctions.waitForElement(driver, checkBox).click();
		return new SendCaseEmail(driver);
	}
}
