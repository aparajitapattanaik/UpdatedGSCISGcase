package com.deere.pages.webform;

import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.deere.global.CommonFunctions;
import com.deere.global.GlobalThings;

public class StellarSupportWebformSubmissionPage extends GlobalThings {

	@FindBy(xpath = "//input[@name='userName']")
	private WebElement ssUsername;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement sspassword;

	@FindBy(xpath = "//input[@class='cta_btn']")
	private WebElement ssSubmit;

	@FindBy(xpath = "(//div[@class='content-item content-label item-2 standard_dataLabelWrite'])[2]")
	private WebElement stellarSupportTitle;

	@FindBy(xpath = "//span[@data-test-id='20180309154956071941973']")
	private WebElement ssDashboard_FirstName;

	@FindBy(xpath = "//span[@data-test-id='20180309154956072045627']")
	private WebElement ssDashboard_PhoneNumber;

	@FindBy(xpath = "(//span[@data-test-id='20180309154956071942663'])[1]")
	private WebElement ssDashboard_BusinessName;

	@FindBy(xpath = "(//span[@data-test-id='20180309154956071942663'])[2]")
	private WebElement ssDashboard_BusinessAddr;

	@FindBy(xpath = "//span[@data-test-id='20180309163651024524817']")
	private WebElement ssDashboard_Email;

	@FindBy(xpath = "//div[@data-test-id='20180309163423012514679']")
	private WebElement ssDashboard_PrimaryMessage;

	@FindBy(xpath = "//input[@id='DealerName']")
	private WebElement deereDashboard_DealerName;

	@FindBy(xpath = "//input[@id='DealerCity']")
	private WebElement deereDashboard_DealerCity;

	@FindBy(xpath = "//input[@id='DealerState']")
	private WebElement deereDashboard_DealerState;

	@FindBy(xpath = "//button[@data-test-id='2018032009190808117329']")
	private WebElement deereDashboard_ClearButton;

	@FindBy(xpath = "//a[@class='Case_tools']")
	private WebElement r4Agcc_attachedFileLink;

	@FindBy(xpath = "//select[@data-test-id='2018031412181703917767']")
	private WebElement ssDashboard_SelectProduct;

	@FindBy(xpath = "#PIN")
	private WebElement ssDashboard_MachinePIN;

	@FindBy(xpath = "//textarea[@data-test-id='2018031407540502455903']")
	private WebElement ssDashboard_Description;

	@FindBy(xpath = "#DealerName")
	private WebElement ssDashboard_Dealername;

	@FindBy(xpath = "#DealerCity")
	private WebElement ssDashboard_DealerCity;

	@FindBy(xpath = "#DealerState")
	private WebElement ssDashboard_DealerState;

	@FindBy(xpath = "//img[@name='MKTCaseAttachments_pyWorkPage_3']")
	private WebElement ssDashboard_AttButton;

	@FindBy(xpath = "//div[@class='file-input-wrapper centered']")
	private WebElement ssDashboard_SelectButton;

	@FindBy(xpath = "//button[@data-test-id='20140919030420037410647']")
	private WebElement ssDashboard_FileAttachButton;

	@FindBy(xpath = "//button[@data-test-id='2018032009190808106446']")
	private WebElement ssDashboard_AttachSubmitButton;

	@FindBy(xpath = "//div[@data-test-id='2015012615503109611417']")
	private WebElement ssDashboard_subinfo;

	@FindBy(xpath = "//span[text()='Value cannot be blank']")
	private WebElement errorMsgCommts;

	protected WebDriver driver;

	public StellarSupportWebformSubmissionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public boolean hasStellarSupportWebFormPageDisplayed(String title) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, stellarSupportTitle).getText().contains(title);
	}

	public boolean hasFirstNameDispalyed(String firstName) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, ssDashboard_FirstName).getText().contains(firstName);
	}

	public boolean hasStellarBusinessNameDisplayed(String businessName) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, ssDashboard_BusinessName).getText().contains(businessName);
	}

	public boolean hasStellarBusinessAddrDisplayed(String businessAddr) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, ssDashboard_BusinessAddr).getText().contains(businessAddr);
	}

	public boolean hasStellarPhoneDisplayed(String phone) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, ssDashboard_PhoneNumber).getText().contains(phone);
	}

	public boolean hasStellarEmailDisplayed(String email) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, ssDashboard_Email).getText().contains(email);
	}

	public boolean hasStellarPrimaryMessageDisplayed(String priMsg) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, ssDashboard_PrimaryMessage).getText().contains(priMsg);
	}

	
	public boolean hasDealerNameDisplayed() {
		return CommonFunctions.isElementExist(driver, deereDashboard_DealerName);
	}

	// Assertion for DealerCity
	public boolean hasDealerCityDisplayed() {
		return CommonFunctions.isElementExist(driver, deereDashboard_DealerCity);
	}

	
	public boolean hasDealerStateDisplayed() {
		return CommonFunctions.isElementExist(driver, deereDashboard_DealerState);
	}

	
	public boolean hasClearButtonDisplayed(String clearButn) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, deereDashboard_ClearButton).getText().contains(clearButn);
	}

	
	public StellarSupportWebformSubmissionPage clickOnClearButton() {
		CommonFunctions.waitForElement(driver, deereDashboard_ClearButton).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new StellarSupportWebformSubmissionPage(driver);
	}

	
	public boolean hasFileAttachedDisplayed(String fileAttach) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, r4Agcc_attachedFileLink).getText().contains(fileAttach);
	}

	
	public boolean hasErrorMsgDisplayed(String validMsg) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, errorMsgCommts).getText().contains(validMsg);
	}

	

	public StellarSupportWebformSubmissionPage waitForAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.alertIsPresent());
			Thread.sleep(500);
			driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		return new StellarSupportWebformSubmissionPage(driver);
	}

	
	public StellarSupportWebformSubmissionPage detailedDescription(String desc) {
		CommonFunctions.waitForElement(driver, ssDashboard_Description).sendKeys(desc);
		return new StellarSupportWebformSubmissionPage(driver);
	}

	
	public StellarSupportWebformSubmissionPage uploadFile() {
		CommonFunctions.waitForElement(driver, ssDashboard_AttButton).click();
		CommonFunctions.waitForElement(driver, ssDashboard_SelectButton).click();
		try {
			CommonFunctions.uploadFileUsingRobotClass(filePathImage);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, ssDashboard_FileAttachButton).click();
		return new StellarSupportWebformSubmissionPage(driver);
	}

	public StellarSupportWebformSubmissionPage clickSubmit() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, ssDashboard_AttachSubmitButton).click();
		return new StellarSupportWebformSubmissionPage(driver);
	}

	public StellarSupportWebformSubmissionPage getCaseID() {

		String finalMsg = CommonFunctions.waitForElement(driver, ssDashboard_subinfo).getText();
		String[] strArr = finalMsg.split(" ");
		String Case_ID = strArr[8];
		caseID_StellarSupport = strArr[8];
		FileWriter fw;
		try {
			fw = new FileWriter(filepath);
			fw.write(Case_ID);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.manage().deleteAllCookies();
		return new StellarSupportWebformSubmissionPage(driver);
	}

	public boolean hasFinalMessageDisplayed(String finalMsg) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, ssDashboard_subinfo).getText().contains(finalMsg);
	}

}
