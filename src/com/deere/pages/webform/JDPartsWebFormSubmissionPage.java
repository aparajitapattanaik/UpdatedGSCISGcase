package com.deere.pages.webform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.deere.global.CommonFunctions;
import com.deere.global.GlobalThings;

public class JDPartsWebFormSubmissionPage extends GlobalThings{

	@FindBy(xpath = "//input[@name='userName']")
	private WebElement jdUserName;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement jdPassword;

	@FindBy(xpath = "//input[@class='cta_btn']")
	private WebElement jdSubmit;

	@FindBy(xpath = "//span[@data-test-id='20180309154956071941973']")
	private WebElement jdParts_FirstName;

	@FindBy(xpath = "//span[@data-test-id='20180309154956072045627']")
	private WebElement jdParts_PhoneNumber;

	@FindBy(xpath = "//span[@data-test-id='20180309163651024524817']")
	private WebElement jdParts_Email;

	@FindBy(xpath = "//div[@data-test-id='20180309163423012514679']")
	private WebElement jdParts_PrimaryMessage;

	@FindBy(xpath = "//select[@data-test-id='2018031412181703917767']")
	private WebElement jdParts_SelectProduct;

	@FindBy(xpath = "#PIN")
	private WebElement jdlDashboard_MachinePIN;

	@FindBy(xpath = "//textarea[@data-test-id='2018031407540502455903']")
	private WebElement jdParts_Description;

	@FindBy(xpath = "#DealerName")
	private WebElement jdlDashboard_DealerName;

	@FindBy(xpath = "#DealerCity")
	private WebElement jdlDashboard_DealerCity;

	@FindBy(xpath = "#DealerState")
	private WebElement jdlDashboard_DealerState;

	@FindBy(xpath = "//img[@name='MKTCaseAttachments_pyWorkPage_3']")
	private WebElement jdParts_AttButton;

	@FindBy(xpath = "//div[@class='file-input-wrapper centered']")
	private WebElement jdParts_SelectButton;

	@FindBy(xpath = "//button[@data-test-id='20140919030420037410647']")
	private WebElement jdParts_FileAttachButton;

	@FindBy(xpath = "//button[@data-test-id='2018032009190808106446']")
	private WebElement jdParts_AttachSubmitButton;

	@FindBy(xpath = "//div[@data-test-id='2015012615503109611417']")
	private WebElement jdParts_SubInfo;

	@FindBy(xpath = "//a[@class='Case_tools']")
	private WebElement jdParts_AttachedFileLink;

	@FindBy(xpath = "//button[@data-test-id='2018032009190808117329']")
	private WebElement jdParts_ClearButton;

	@FindBy(xpath = "//span[@data-test-id='20180309154956071941973']")
	private WebElement firstAndLastName;

	@FindBy(xpath = "//*[@id='$PpyWorkPage$pWebformCommentError']")
	private WebElement validMessg;

	@FindBy(xpath = "(//span[@data-test-id='20180309154956071942663'])[2]")
	private WebElement address;

	@FindBy(xpath = "//button[@data-test-id='2018032009190808106446']")
	private WebElement submitBtn;

	@FindBy(xpath = "//button[@data-test-id='2018032009190808117329']")
	private WebElement clearBtn;

	@FindBy(xpath = "(//div[@class='content-item content-label item-2 standard_dataLabelWrite'])[2]")
	private WebElement jdPartsWebForm;

	protected WebDriver driver;

	public JDPartsWebFormSubmissionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public JDPartsWebFormSubmissionPage product_Selection() {
		CommonFunctions.waitForElement(driver, jdParts_SelectProduct);
		CommonFunctions.selectFromDropdown(driver, "JDLink Dashboard", jdParts_SelectProduct);
		return new JDPartsWebFormSubmissionPage(driver);
	}

	public JDPartsWebFormSubmissionPage detailedDescription(String desc) {
		CommonFunctions.waitForElement(driver, jdParts_Description).sendKeys(desc); 
		return new JDPartsWebFormSubmissionPage(driver);
	}

	// File uploading and submit
	public JDPartsWebFormSubmissionPage uploadFile()  {
		CommonFunctions.waitForElement(driver, jdParts_AttButton).click();
		CommonFunctions.waitForElement(driver, jdParts_SelectButton).click();
		try {
			CommonFunctions.uploadFileUsingRobotClass(filePathImage);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, jdParts_FileAttachButton).click();
		return new JDPartsWebFormSubmissionPage(driver);
	}

	public JDPartsWebFormSubmissionPage clickSubmit(){
		CommonFunctions.waitForElement(driver, jdParts_AttachSubmitButton).click();
		return new JDPartsWebFormSubmissionPage(driver);
	}

	public JDPartsWebFormSubmissionPage getCaseID() {
		String tm = CommonFunctions.waitForElement(driver, jdParts_SubInfo).getText();
		String[] strArr = tm.split(" ");
		Caseid_JDParts = strArr[8];
		return new JDPartsWebFormSubmissionPage(driver);
	}

	public boolean hasFinalMessageDisplayed(String finalMsg ){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			CommonFunctions.isElementExist(driver, jdParts_SubInfo);
		return CommonFunctions.waitForElement(driver, jdParts_SubInfo).getText().contains(finalMsg);
	}

	public JDPartsWebFormSubmissionPage waitForAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.alertIsPresent());
			Thread.sleep(500);
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		return new JDPartsWebFormSubmissionPage(driver);
	}

	public boolean hasPhoneNumberDisplayed(String phone) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, jdParts_PhoneNumber).getText().contains(phone);
	}

	public boolean hasEmailAddressDisplayed(String email) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, jdParts_Email).getText().contains(email);
	}

	public boolean hasPrimaryMessageDisplayed(String priMsg) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, jdParts_PrimaryMessage).getText().contains(priMsg);
	}


	public boolean hasFileAttachedDisplayed(String fileAttach) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, jdParts_AttachedFileLink).getText().contains(fileAttach);
	}

	public JDPartsWebFormSubmissionPage clickOnClearButton() {
		CommonFunctions.waitForElement(driver, jdParts_ClearButton).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, submitBtn).click();
		CommonFunctions.waitForAlert(driver);
		CommonFunctions.waitForElement(driver, validMessg);
		return new JDPartsWebFormSubmissionPage(driver);
	}

	public JDPartsWebFormSubmissionPage submitButton() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, submitBtn).click();
		CommonFunctions.waitForAlert(driver);
		CommonFunctions.waitForElement(driver, validMessg);
		return new JDPartsWebFormSubmissionPage(driver);
	}

	public boolean hasFirstNameLastNameDisplayed(String firstName) {
		return CommonFunctions.waitForElement(driver, firstAndLastName).getText().contains(firstName);
	}

	public boolean hasAddressDisplayed(String addr) {
		return CommonFunctions.waitForElement(driver, address).getText().contains(addr);
	}

	public boolean hasCommentsTextAreaFiledDisplayed() {
		return CommonFunctions.isElementExist(driver, jdParts_Description);
	}

	public boolean hasAddFileButtonDisplayed() {
		return CommonFunctions.isElementExist(driver, jdParts_AttButton);
	}

	public boolean hasSubmitButtonDisplayed(String submitButn) {
		CommonFunctions.scrollSomeDown(driver);
		return CommonFunctions.waitForElement(driver, submitBtn).getText().contains(submitButn);
	}

	public boolean hasClearButtonDisplayed(String clearButn) {
		return CommonFunctions.waitForElement(driver, clearBtn).getText().contains(clearButn);
	}

	public boolean hasJDLinksWebFormPageDisplayed(String title) {
		return CommonFunctions.waitForElement(driver, jdPartsWebForm).getText().contains(title);
	}
}
