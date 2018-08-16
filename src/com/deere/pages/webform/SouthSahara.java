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

public class SouthSahara extends GlobalThings {

	@FindBy(xpath = "//input[@name='userName']")
	private WebElement southSaharaUsername;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement southSaharapassword;

	@FindBy(xpath = "//input[@class='cta_btn']")
	private WebElement southSaharaSubmit;

	@FindBy(xpath = "//span[@data-test-id='20180309154956071941973']")
	private WebElement southSaharaDashboard_FirstName;

	@FindBy(xpath = "(//span[@data-test-id='20180309154956071942663'])[1]")
	private WebElement ssDashboard_BusinessName;

	@FindBy(xpath = "(//span[@data-test-id='20180309154956071942663'])[2]")
	private WebElement ssDashboard_BusinessAddr;

	@FindBy(xpath = "//span[@data-test-id=\"20180309154956072045627\"]")
	private WebElement southSaharaDashboard_PhoneNumber;

	@FindBy(xpath = "//span[@data-test-id=\"20180309163651024524817\"]")
	private WebElement southSaharaDashboard_Email;

	@FindBy(xpath = "//div[@data-test-id=\"20180309163423012514679\"]")
	private WebElement southSaharaDashboard_PrimaryMessage;

	@FindBy(xpath = "//select[@data-test-id=\"2018031412181703917767\"]")
	private WebElement southSaharaDashboard_SelectProduct;

	@FindBy(xpath = "#PIN")
	private WebElement southSaharaDashboard_MachinePIN;

	@FindBy(xpath = "//textarea[@data-test-id='2018031407540502455903']")
	private WebElement southSaharaDashboard_Description;

	@FindBy(xpath = "#DealerName")
	private WebElement southSaharaDashboard_Dealername;

	@FindBy(xpath = "#DealerCity")
	private WebElement southSaharaDashboard_DealerCity;

	@FindBy(xpath = "#DealerState")
	private WebElement southSaharaDashboard_DealerState;

	@FindBy(xpath = "//img[@name='MKTCaseAttachments_pyWorkPage_3']")
	private WebElement southSaharaDashboard_AttButton;

	@FindBy(xpath = "//div[@class='file-input-wrapper centered']")
	private WebElement southSaharaDashboard_SelectButton;

	@FindBy(xpath = "//button[@data-test-id='20140919030420037410647']")
	private WebElement southSaharaDashboard_FileAttachButton;

	@FindBy(xpath = "//button[@data-test-id='2018032009190808106446']")
	private WebElement southSaharaDashboard_AttachSubmitButton;

	@FindBy(xpath = "//div[@data-test-id='2015012615503109611417']")
	private WebElement southSaharaDashboard_subinfo;

	@FindBy(xpath = "//a[@class='Case_tools']")
	private WebElement southSaharaDashboard_attachedFileLink;

	@FindBy(xpath = "//select[@name='$PpyWorkPage$pWebformLanguage']")
	private WebElement southSaharaDashboard_DefaultLanguage;

	@FindBy(xpath = "//span[@class='iconRequired standard_iconRequired']")
	private WebElement southSaharaDashboard_DescriptionMsgInPortugues;

	@FindBy(xpath = "//option[@value='pt_BR']")
	private WebElement southSaharaDashboard_PortuguesLanguage;

	@FindBy(xpath = "//button[@data-test-id='2018032009190808117329']")
	private WebElement southSaharaDashboard_ClearButton;

	@FindBy(xpath = "//span[text()='Value cannot be blank']")
	private WebElement errorMsgCommts;

	@FindBy(xpath = "(//div[@class='content-item content-label item-2 standard_dataLabelWrite'])[2]")
	private WebElement southSaharaTitle;

	protected WebDriver driver;

	public SouthSahara(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public boolean hasSouthSaharaWebFormPageDisplayed(String title) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, southSaharaTitle).getText().contains(title);
	}

	public boolean hasFirstNameDisplayed(String firstName) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, southSaharaDashboard_FirstName).getText().contains(firstName);
	}

	public boolean hasSouthSaharaBusinessName(String bName) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, ssDashboard_BusinessName).getText().contains(bName);
	}

	public boolean hasSouthSaharaBusinessAddrDisplayed(String bAddr) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, ssDashboard_BusinessAddr).getText().contains(bAddr);
	}

	public boolean hasSouthSaharaPhoneDisplayed(String phone) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, southSaharaDashboard_PhoneNumber).getText().contains(phone);
	}

	public boolean hasSouthSaharaEmailDisplayed(String email) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, southSaharaDashboard_Email).getText().contains(email);
	}

	public boolean hasSouthSaharaPrimaryMessageDisplayed(String priMsg) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, southSaharaDashboard_PrimaryMessage).getText().contains(priMsg);
	}

	public boolean hasSouthSaharaDefaultLanguageSelected(String lang) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, southSaharaDashboard_DefaultLanguage).getText().contains(lang);

	}

	public boolean hasClearButtonDisplayed(String clearButn) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, southSaharaDashboard_ClearButton).getText().contains(clearButn);
	}

	public SouthSahara clickOnClearButton() {
		CommonFunctions.waitForElement(driver, southSaharaDashboard_ClearButton).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new SouthSahara(driver);
	}

	
	public boolean hasErrorMsgDisplayed(String errMsg) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, errorMsgCommts).getText().contains(errMsg);
	}


	public SouthSahara productSelection() {
		CommonFunctions.waitForElement(driver, southSaharaDashboard_SelectProduct);
		CommonFunctions.selectFromDropdown(driver, "SouthSahara Dashboard", southSaharaDashboard_SelectProduct);
		return new SouthSahara(driver);
	}

	
	public SouthSahara detailedDescription(String desc) {
		CommonFunctions.waitForElement(driver, southSaharaDashboard_Description).sendKeys(desc);
		return new SouthSahara(driver);
	}

	public SouthSahara verifyPortuguesLanguageMsg() {
		CommonFunctions.waitForElement(driver, southSaharaDashboard_DescriptionMsgInPortugues);
		return new SouthSahara(driver);
	}

	public SouthSahara selectPortuguesLanguage() {
		CommonFunctions.waitForElement(driver, southSaharaDashboard_PortuguesLanguage).click();
		return new SouthSahara(driver);
	}

	
	public SouthSahara uploadFile() {
		CommonFunctions.waitForElement(driver, southSaharaDashboard_AttButton).click();
		CommonFunctions.waitForElement(driver, southSaharaDashboard_SelectButton).click();
		try {
			CommonFunctions.uploadFileUsingRobotClass(filePathImage);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, southSaharaDashboard_FileAttachButton).click();
		return new SouthSahara(driver);
	}

	
	public boolean hasFileAttachedDisplayed(String fileAttach) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, southSaharaDashboard_attachedFileLink).getText()
				.contains(fileAttach);
	}

	
	public SouthSahara getCaseID() {
		String finalMsg = CommonFunctions.waitForElement(driver, southSaharaDashboard_subinfo).getText();
		String[] strArr = finalMsg.split(" ");
		String Case_ID = strArr[8];
		caseID_SouthSahara = strArr[8];
		FileWriter fw;
		try {
			fw = new FileWriter(filepath);
			fw.write(Case_ID);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.manage().deleteAllCookies();
		return new SouthSahara(driver);
	}

	public SouthSahara clickSubmitBtn() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, southSaharaDashboard_AttachSubmitButton).click();
		return new SouthSahara(driver);
	}

	public boolean hasFinalMessageDisplayed(String finalMsg) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, southSaharaDashboard_subinfo).getText().contains(finalMsg);
	}

	

	public SouthSahara waitForAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.alertIsPresent());
			Thread.sleep(500);
		 driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		return new SouthSahara(driver);
	}

}
