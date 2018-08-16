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

public class R4Turf extends GlobalThings{

	public static String Caseid_R4Turf,alertMsg;

	@FindBy(xpath = "//span[@data-test-id='20180309154956071941973']")
	private WebElement r4TurfDashboardFirstName;
	
	@FindBy(xpath = "(//span[@data-test-id='20180309154956071942663'])[2]")
	private WebElement r4TurfDashboardAddress;

	@FindBy(xpath = "//span[@data-test-id=\"20180309154956072045627\"]")
	private WebElement r4TurfDashboard_PhoneNumber;

	@FindBy(xpath = "//span[@data-test-id=\"20180309163651024524817\"]")
	private WebElement r4TurfDashboard_Email;

	@FindBy(xpath = "//div[@data-test-id=\"20180309163423012514679\"]")
	private WebElement r4TurfDashboard_PrimaryMessage;

	@FindBy(xpath = "//select[@data-test-id='2018032215532701475431']")
	private WebElement r4TurfDashboard_SelectCountry;

	@FindBy(xpath = "//textarea[@data-test-id='2018031407540502455903']")
	private WebElement r4TurfDashboard_Description;
	
	@FindBy(xpath = "//button[@data-test-id='2018032009190808106446']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//button[@data-test-id='2018032009190808117329']")
	private WebElement clearBtn;

	@FindBy(xpath = "//input[@data-test-id='2018030916435602054843']")
	private WebElement r4TurfDashboard_DealerName;

	@FindBy(xpath = "//input[@data-test-id='20180309164356020549262']")
	private WebElement r4TurfDashboard_DealerCity;

	@FindBy(xpath = "//input[@data-test-id='20180309164356020550666']")
	private WebElement r4TurfDashboard_DealerState;

	@FindBy(xpath = "//img[@name='MKTCaseAttachments_pyWorkPage_3']")
	private WebElement r4TurfDashboard_AttButton;

	@FindBy(xpath = "//div[@class='file-input-wrapper centered']")
	private WebElement r4TurfDashboard_SelectButton;

	@FindBy(xpath = "//button[@data-test-id='20140919030420037410647']")
	private WebElement r4TurfDashboard_FileAttachButton;

	@FindBy(xpath = "//a[@class='Case_tools']")
	private WebElement r4TurfDashboard_attachedFileLink;

	@FindBy(xpath = "//button[@data-test-id='2018032009190808106446']")
	private WebElement r4TurfDashboard_AttachSubmitButton;

	@FindBy(xpath = "//div[@data-test-id='2015012615503109611417']")
	private WebElement r4TurfDashboard_subinfo;

	@FindBy(xpath = "//button[@data-test-id='2018032009190808117329']")
	private WebElement r4TurfDashboard_ClearButton;
	
	@FindBy(xpath = "//span[@data-test-id='20180309154956072045627']")
	private WebElement r4TurfDashboardPhoneNumber;
	
	@FindBy(xpath = "//div[@class='field-item dataLabelWrite jd_sans_app_title_dataLabelWrite'][@data-test-id='2015121807235809061025859']")
	private WebElement webForm;
	
	@FindBy(xpath = "//span[@data-test-id=\"20180309154956071941973\"]")
	private WebElement firstName;

	@FindBy(xpath = "//img[@name='MKTCaseAttachments_pyWorkPage_3']")
	private WebElement jdParts_AttButton;
	
	@FindBy(xpath = "//*[@id='$PpyWorkPage$pWebformCommentError']")
	private WebElement validMessg; 
	
	@FindBy(xpath = "//span[@data-test-id='20180309163651024524817']")
	private WebElement r4TurfDashboardEmail;
	
	@FindBy(xpath = "//div[@data-test-id='20180309163423012514679']")
	private WebElement primaryMessage;
	
	@FindBy(xpath = "//textarea[@data-test-id='2018031407540502455903']")
	private WebElement detaildDes;

	protected WebDriver driver;

	public R4Turf(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public boolean hasR4TurfWebFormOpened(String firstName) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, r4TurfDashboardFirstName).getText().contains(firstName);
	}
	
	public boolean hasAddressDisplayed(String addr) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, r4TurfDashboardAddress).getText().contains(addr);
	}

	public boolean hasPhoneNumberDisplayed(String phone) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, r4TurfDashboardPhoneNumber).getText().contains(phone);
	}

	public boolean hasR4TurfEmailAdressDisplayed(String email) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, r4TurfDashboardEmail).getText().contains(email);
	}

	public boolean hasR4TurfPrimaryMessageDisplayed(String priMsg) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, r4TurfDashboard_PrimaryMessage).getText().contains(priMsg);
	}

	
	
	public R4Turf clickOnClearButton() {
		CommonFunctions.waitForElement(driver, clearBtn).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, submitBtn).click();
		CommonFunctions.waitForAlert(driver);
		CommonFunctions.waitForElement(driver, validMessg);
		return new R4Turf(driver);
	}
	
	public R4Turf clickSubmitButton() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, submitBtn).click();
		CommonFunctions.waitForAlert(driver);
		CommonFunctions.waitForElement(driver, validMessg);
		return new R4Turf(driver);
	}

	
	public R4Turf Product_selection() {
		CommonFunctions.waitForElement(driver, r4TurfDashboard_SelectCountry);
		CommonFunctions.selectFromDropdown(driver, "JDLink Dashboard", r4TurfDashboard_SelectCountry);
		return new R4Turf(driver);
	}

	
	public R4Turf detailedDescription(String desc) {
		CommonFunctions.waitForElement(driver, r4TurfDashboard_Description).sendKeys(desc);
		return new R4Turf(driver);
	}

	public boolean hasDealerNameDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, r4TurfDashboard_DealerName);
	}

	public boolean hasDealerCityDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, r4TurfDashboard_DealerCity);

	}

	public boolean hasDealerStateDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, r4TurfDashboard_DealerState);

	}
	
	public boolean hasAddFileButtonDisplayed() {
		// TODO Auto-generated method stub
		return CommonFunctions.isElementExist(driver, jdParts_AttButton);
	}

	public boolean hasSubmitButtonDisplayed(String submitButn) {
		CommonFunctions.scrollSomeDown(driver);
		return CommonFunctions.waitForElement(driver, submitBtn).getText().contains(submitButn);
	}

	public boolean hasClearButtonDisplayed(String clearButn) {
		return CommonFunctions.waitForElement(driver, clearBtn).getText().contains(clearButn);
	}

	public R4Turf country_selection() {
		CommonFunctions.waitForElement(driver, r4TurfDashboard_SelectCountry);
		CommonFunctions.selectFromDropdown(driver, "United States", r4TurfDashboard_SelectCountry);
		return new R4Turf(driver);
	}

	public R4Turf dealerName() {
		CommonFunctions.waitForElement(driver, r4TurfDashboard_Description);
		return new R4Turf(driver);
	}

	public R4Turf dealerCity() {
		CommonFunctions.waitForElement(driver, r4TurfDashboard_Description);
		return new R4Turf(driver);
	}

	public R4Turf dealerState() {
		CommonFunctions.waitForElement(driver, r4TurfDashboard_Description);
		return new R4Turf(driver);
	}

	
	public R4Turf uploadFile() {
		CommonFunctions.waitForElement(driver, r4TurfDashboard_AttButton).click();
		CommonFunctions.waitForElement(driver, r4TurfDashboard_SelectButton).click();
		 try {
			CommonFunctions.uploadFileUsingRobotClass(filePathImage);
		} catch (Throwable e) {
			e.printStackTrace();
		}	
		CommonFunctions.waitForElement(driver, r4TurfDashboard_FileAttachButton).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new R4Turf(driver);
	}

	public boolean hasFileAttachmentDisplayed(String fileAttach) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return CommonFunctions.waitForElement(driver, r4TurfDashboard_attachedFileLink).getText().contains(fileAttach);
	}

	public R4Turf getCaseIDOfR4Turf() {

		CommonFunctions.waitForElement(driver, r4TurfDashboard_AttachSubmitButton).click();
		String tm = CommonFunctions.waitForElement(driver, r4TurfDashboard_subinfo).getText();

		String[] strArr = tm.split(" ");
		String Case_ID = strArr[8];
		Caseid_R4Turf = strArr[8];
		System.out.println("" + Case_ID);
		return new R4Turf(driver);

	}
	
	public R4Turf clickSubmit() {
		CommonFunctions.waitForElement(driver, r4TurfDashboard_AttachSubmitButton).click();
		return new R4Turf(driver);
	}
	
	public R4Turf getCaseID() {
		String finalMsg = CommonFunctions.waitForElement(driver, r4TurfDashboard_subinfo).getText();
		String[] finalMsgSplit = finalMsg.split(" ");
		String case_ID = finalMsgSplit[8];
		CaseID_R4Turf = finalMsgSplit[8];
		FileWriter fw;
		try {
			fw = new FileWriter(filepath);
			fw.write(case_ID);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.manage().deleteAllCookies();
		
		return new R4Turf(driver);
	}
		
	public boolean hasFinalMessageDisplayed(String msg){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (CommonFunctions.waitForElement(driver, r4TurfDashboard_subinfo ).getText().contains(msg)) {
			return true;
		} else {
			return false;
		}
	}
	public R4Turf waitForAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.alertIsPresent());
			Thread.sleep(500);
			alertMsg=driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
		}catch(Exception e) {
	 }
		return new R4Turf(driver);
	}

	public boolean hasR4TurfWebFormPageDisplayed(String title) {
		return CommonFunctions.waitForElement(driver, webForm).getText().contains(title);
	}

	public boolean hasFirstNameLastNameDisplayed(String fName) {
		return CommonFunctions.waitForElement(driver, firstName).getText().contains(fName);
	}

	public boolean hasPrimaryMessageDisplayed() {
		// TODO Auto-generated method stub
		return  CommonFunctions.isElementExist(driver, primaryMessage);
	}

	public boolean hasDetailedDesDisplayed() {
		// TODO Auto-generated method stub
		return  CommonFunctions.isElementExist(driver, detaildDes);
	} 


}
