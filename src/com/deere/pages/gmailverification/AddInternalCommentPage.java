package com.deere.pages.gmailverification;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;

public class AddInternalCommentPage {
	
	@FindBy(xpath = "//span[@id=\"modaldialog_hd_title\"]")
	private WebElement addCommentPopUp;

	@FindBy(xpath = "(//a[@data-test-id='20170908144733046212866'])[2]")
	private WebElement addComment;
	
	@FindBy(xpath = "(//div[@class=\"field-item dataValueRead\"]/p)[1]")
	private WebElement enterdComment;
	
	@FindBy(xpath = "//div[@id='cke_1_contents']/iframe")
	private WebElement iframe;
	
	@FindBy(xpath = "//body[@class='cke_editable cke_editable_themed cke_contents_ltr'][@title='This is a rich text editor control.']")
	private WebElement comment;
	
	@FindBy(xpath = "//button[@data-test-id='20140919030420037410647']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//button[@data-test-id='20180201162439008710139']")
	private WebElement closeBtn;
	
	@FindBy(xpath = "//button[@data-test-id='2014100911285001362285']")
	private WebElement clickActionButton;
	
	@FindBy(xpath = "//ul[@id='pyNavigation1528360059917']")
	private WebElement actionFrame;
	
	@FindBy(xpath = "//ul[@id='pyNavigation1528360059917']/li[3]")
	private WebElement sendEmail;
	
	@FindBy(xpath = "//iframe[@name='PegaGadget1Ifr']")
	private WebElement iframe1;

	protected WebDriver driver;

	public AddInternalCommentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	
	public boolean hasAddCommentDisplayed(String comment) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.scrollSomeDown(driver);
		return CommonFunctions.waitForElement(driver, addComment).getText().contains(comment);
	}
	
	public AddInternalCommentPage clickAddCommentLink() {
		CommonFunctions.waitForElement(driver, addComment).click();
		return new AddInternalCommentPage(driver);
	}


	public boolean hasAddCommentPopUpDisplayed(String popup) {
		// TODO Auto-generated method stub
		return CommonFunctions.waitForElement(driver, addCommentPopUp).getText().contains(popup);
	}


	public AddInternalCommentPage enterComment(String comments) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.switchToiFrameByWebElement(driver, iframe);
	 CommonFunctions.waitForElement(driver, comment).sendKeys(comments);
	
		return new AddInternalCommentPage(driver);
	}


	public AddInternalCommentPage clickSubmitBtn() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.switchToiFrameByWebElement(driver, iframe1);
		  CommonFunctions.waitForElement(driver, submitBtn).click();
			return new AddInternalCommentPage(driver);
	}


	
	public boolean hasEnterdCommentDisplayed() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.scrollSomeDown(driver);
		return CommonFunctions.isElementExist(driver, enterdComment);
	}


	public AddInternalCommentPage closetBtnclick() {
		 CommonFunctions.waitForElement(driver, closeBtn).click();
			return new AddInternalCommentPage(driver);
	}
	
	public SendCaseEmail selectSendCaseEmail() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.switchToiFrameByWebElement(driver, iframe1);
		CommonFunctions.waitForElement(driver, clickActionButton).click();
		CommonFunctions.isElementExist(driver, actionFrame);
		CommonFunctions.waitForElement(driver, sendEmail).click();
		return new SendCaseEmail(driver);
	}

}
