package com.deere.pages.webform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.deere.global.CommonFunctions;
import com.deere.global.GlobalThings;

public class R4_AgCCWebFormSubmissionPage extends GlobalThings {

	
	@FindBy(xpath = "//input[@name='userName']")
	private WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;

	@FindBy(xpath = "//input[@class='cta_btn']")
	private WebElement submit;

	@FindBy(xpath = "//span[@data-test-id='20180309154956071941973']")
	private WebElement firstName;

	@FindBy(xpath = "//span[@data-test-id='20180309154956072045627']")
	private WebElement phoneNumber;

	@FindBy(xpath = "//span[@data-test-id='20180309163651024524817']")
	private WebElement email;

	@FindBy(xpath = "//div[@data-test-id='20180309163423012514679']")
	private WebElement primaryMessage;

	@FindBy(xpath = "//select[@data-test-id='2018031412181703917767']")
	private WebElement selectProduct;

	@FindBy(xpath = "#PIN")
	private WebElement machinePIN;

	@FindBy(xpath = "//textarea[@data-test-id='2018031407540502455903']")
	private WebElement description;

	@FindBy(xpath = "#DealerName")
	private WebElement dealerName;

	@FindBy(xpath = "#DealerCity")
	private WebElement dealerCity;

	@FindBy(xpath = "#DealerState")
	private WebElement dealerState;

	@FindBy(xpath = "//img[@name='MKTCaseAttachments_pyWorkPage_3']")
	private WebElement attButton;

	@FindBy(xpath = "//div[@class='file-input-wrapper centered']")
	private WebElement selectButton;

	@FindBy(xpath = "//button[@data-test-id='20140919030420037410647']")
	private WebElement fileAttachButton;

	@FindBy(xpath = "//button[@data-test-id='2018032009190808106446']")
	private WebElement attachSubmitButton;

	@FindBy(xpath = "//div[@data-test-id='2015012615503109611417']")
	private WebElement subinfo;

	@FindBy(xpath = "#DealerName")
	private WebElement r4Agcc_DealerName;

	@FindBy(xpath = "#DealerCity")
	private WebElement r4Agcc_DealerCity;

	@FindBy(xpath = "#DealerState")
	private WebElement r4Agcc_DealerState;

	@FindBy(xpath = "//button[@data-test-id='2018032009190808117329']")
	private WebElement r4Agcc_ClearButton;

	@FindBy(xpath = "//a[@class='Case_tools']")
	private WebElement r4Agcc_attachedFileLink;

	@FindBy(xpath = "//textarea[@data-test-id='2018031407540502455903']")
	private WebElement jdParts_Description;

	@FindBy(xpath = "//img[@name='MKTCaseAttachments_pyWorkPage_3']")
	private WebElement jdParts_AttButton;

	@FindBy(xpath = "//button[@data-test-id='2018032009190808106446']")
	private WebElement submitBtn;

	@FindBy(xpath = "//button[@data-test-id='2018032009190808117329']")
	private WebElement cancleBtn;
	
	@FindBy(xpath = "//span[@data-test-id='20180309154956071941973']")
	private WebElement name;

	@FindBy(xpath = "//*[@id='$PpyWorkPage$pWebformCommentError']")
	private WebElement validMessg;

	@FindBy(xpath = "(//span[@data-test-id='20180309154956071942663'])[2]")
	private WebElement address;

       
	@FindBy(xpath = "//span[@data-test-id='20180309154956072045627']")
	private WebElement jdParts_PhoneNumber;

	@FindBy(xpath = "//span[@data-test-id='20180309163651024524817']")
	private WebElement jdParts_Email;

	@FindBy(xpath = "//div[@data-test-id='20180309163423012514679']")
	private WebElement jdParts_PrimaryMessage;

       
	@FindBy(xpath = "//input[@data-test-id=\"2018030916435602054843\"]")
	private WebElement dealName;

	@FindBy(xpath = "//span[@data-test-id='20180309163651024524817']")
	private WebElement dealCity;

	@FindBy(xpath = "//input[@data-test-id=\"20180309164356020550666\"]")
	private WebElement dealState;

	@FindBy(xpath = "(//div[@class=\"content-item content-label item-2 standard_dataLabelWrite\"])[2]")
	private WebElement r4AgccWebForm;


	protected WebDriver driver;

	public R4_AgCCWebFormSubmissionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public boolean hasWebFormPageDisplayed(String fName) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, firstName).getText().contains(fName);
	}

	public boolean hasPhoneNumDisplayed(String phone) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, phoneNumber).getText().contains(phone);
	}

	public boolean hasEmailDisplayed(String emailID) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, email).getText().contains(emailID);
	}

	public boolean hasPrimaryMessageDisplayed(String priMsg) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, primaryMessage).getText().contains(priMsg);
	}

	// Product DD selection in JDLinkswebform
	public R4_AgCCWebFormSubmissionPage productSelection() {
		CommonFunctions.waitForElement(driver, selectProduct);
		CommonFunctions.selectFromDropdown(driver, "JDLink Dashboard", selectProduct);
		return new R4_AgCCWebFormSubmissionPage(driver);
	}

	// Detailed_description entering in JDLinkswebform
	public R4_AgCCWebFormSubmissionPage detailedDescription(String desc) {

		CommonFunctions.waitForElement(driver, description).sendKeys(desc);
		return new R4_AgCCWebFormSubmissionPage(driver);
	}

	// File uploading and submit
	public R4_AgCCWebFormSubmissionPage uploadFile() {
		CommonFunctions.waitForElement(driver, attButton).click();
		CommonFunctions.waitForElement(driver, selectButton).click();
		try {
			CommonFunctions.uploadFileUsingRobotClass(filePathImage);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, fileAttachButton).click();
		return new R4_AgCCWebFormSubmissionPage(driver);
	}

	public R4_AgCCWebFormSubmissionPage clickSubmit() {
		CommonFunctions.waitForElement(driver, attachSubmitButton).click();
		return new R4_AgCCWebFormSubmissionPage(driver);
	}

	public R4_AgCCWebFormSubmissionPage getCaseID() {
		String tm = CommonFunctions.waitForElement(driver, subinfo).getText();
		String[] strArr = tm.split(" ");
		Caseid_R4Agcc = strArr[8];
		return new R4_AgCCWebFormSubmissionPage(driver);
	}

	public boolean hasFinalMessageDisplayed(String msg) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (CommonFunctions.waitForElement(driver, subinfo).getText().contains(msg)) {
			return true;
		} else {
			return false;
		}
	}

	public R4_AgCCWebFormSubmissionPage waitForAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.alertIsPresent());
			Thread.sleep(500);
			 driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		return new R4_AgCCWebFormSubmissionPage(driver);
	}

	public boolean hasDealerNameExist(String dName) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, r4Agcc_DealerName).getText().contains(dName);
	}
	public boolean hasDealerCityExist(String dCity) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, r4Agcc_DealerCity).getText().contains(dCity);
	}

	public boolean hasDealerStateExist(String dState) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, r4Agcc_DealerState).getText().contains(dState);

	}

	public boolean hasClearButton(String clearButn) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, r4Agcc_ClearButton).getText().contains(clearButn);
	}

	public R4_AgCCWebFormSubmissionPage clickOnClearButton() {
		CommonFunctions.waitForElement(driver, r4Agcc_ClearButton).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, submitBtn).click();
		CommonFunctions.waitForAlert(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, validMessg);
		return new R4_AgCCWebFormSubmissionPage(driver);
	}

	public R4_AgCCWebFormSubmissionPage clickSubmitButton() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, submitBtn).click();
		//CommonFunctions.waitForAlert(driver);
		//CommonFunctions.waitForElement(driver, validMessg);
		return new R4_AgCCWebFormSubmissionPage(driver);
	}

	
	public boolean hasFileAttachedDisplayed(String fileAttach) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, r4Agcc_attachedFileLink).getText().contains(fileAttach);
	}

	public boolean hasFirstNameLastNameDisplayed(String firstName) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, name).getText().contains(firstName);

	}

	public boolean hasAddressDisplayed(String addr) {
		return CommonFunctions.waitForElement(driver, address).getText().contains(addr);
	}

	public boolean hasCommentsTextAreaDisplayed() {
		return CommonFunctions.isElementExist(driver, jdParts_Description);
	}

	public boolean hasAddFileButtonDisplayed() {
		return CommonFunctions.isElementExist(driver, jdParts_AttButton);

	}

	public boolean hasSubmitButtonDisplayed(String submitButn) {
		// TODO Auto-generated method stub
		CommonFunctions.scrollSomeDown(driver);
		return CommonFunctions.waitForElement(driver, submitBtn).getText().contains(submitButn);
	}

	public boolean hasClearButtonDisplayed(String clearButn) {
		// TODO Auto-generated method stub
		return CommonFunctions.waitForElement(driver, cancleBtn).getText().contains(clearButn);
	}

	public boolean hasPhoneNumberDisplayed(String phone) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, jdParts_PhoneNumber).getText().contains(phone);
	}

	public boolean hasEmailAddressDisplayed(String email) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, jdParts_Email).getText().contains(email);
	}

	
	public boolean hasDealerNameTextAreaDisplayed() {
		return CommonFunctions.isElementExist(driver, dealName);
	}

	public boolean hasDealerCityTextAreaDisplayed() {
		return CommonFunctions.isElementExist(driver, dealCity);
	}

	public boolean hasDealerStateAreaDisplayed() {
		return CommonFunctions.isElementExist(driver, dealState);
	}

	public boolean hasR4AgccWebFormPageDisplayed(String title) {
		return CommonFunctions.waitForElement(driver, r4AgccWebForm).getText().contains(title);
	}

}
