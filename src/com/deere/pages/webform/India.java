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

public class India extends GlobalThings {

	@FindBy(xpath = "//input[@name='username1']")
	private WebElement indiaUsername;

	@FindBy(xpath = "//input[@name='password1']")
	private WebElement indiaPassword;

	@FindBy(xpath = "//input[@class='submit-btn cta_btn']")
	private WebElement indiaSubmit;

	@FindBy(xpath = "//span[@data-test-id='20180309154956071941973']")
	private WebElement indiaDashboard_FirstName;

	@FindBy(xpath = "(//span[@data-test-id='20180309154956071942663'])[1]")
	private WebElement indiaDashboard_BusinessName;

	@FindBy(xpath = "(//span[@data-test-id='20180309154956071942663'])[2]")
	private WebElement indiaDashboard_BusinessAddr;

	@FindBy(xpath = "//span[@data-test-id='20180309154956072045627']")
	private WebElement indiaDashboard_PhoneNumber;

	@FindBy(xpath = "//span[@data-test-id='20180309163651024524817']")
	private WebElement indiaDashboard_Email;

	@FindBy(xpath = "//div[@data-test-id='20180309163423012514679']")
	private WebElement indiaDashboard_PrimaryMessage;

	@FindBy(xpath = "//select[@data-test-id='2018031412181703917767']")
	private WebElement indiaDashboard_SelectProduct;

	@FindBy(xpath = "#PIN")
	private WebElement indiaDashboard_MachinePIN;

	@FindBy(xpath = "//textarea[@data-test-id='2018031407540502455903']")
	private WebElement indiaDashboard_Description;

	@FindBy(xpath = "#DealerName")
	private WebElement indiaDashboard_DealerName;

	@FindBy(xpath = "#DealerCity")
	private WebElement indiaDashboard_DealerCity;

	@FindBy(xpath = "#DealerState")
	private WebElement indiaDashboard_DealerState;

	@FindBy(xpath = "//img[@name='MKTCaseAttachments_pyWorkPage_3']")
	private WebElement indiaDashboard_AttButton;

	@FindBy(xpath = "//div[@class='file-input-wrapper centered']")
	private WebElement indiaDashboard_SelectButton;

	@FindBy(xpath = "//button[@data-test-id='20140919030420037410647']")
	private WebElement indiaDashboard_FileAttachButton;

	@FindBy(xpath = "//button[@data-test-id='2018032009190808106446']")
	private WebElement indiaDashboard_AttachSubmitButton;

	@FindBy(xpath = "//div[@data-test-id='2015012615503109611417']")
	private WebElement indiaDashboard_SubInfo;

	@FindBy(xpath = "//a[@class='Case_tools']")
	private WebElement indiaDashboard_AttachedFileLink;

	@FindBy(xpath = "//button[@data-test-id='2018032009190808117329']")
	private WebElement indiaDashboard_ClearButton;

	@FindBy(id = "$PpyWorkPage$pWebformCommentError")
	private WebElement errorMsgCommts;

	@FindBy(xpath = "(//div[@class='content-item content-label item-2 standard_dataLabelWrite'])[2]")
	private WebElement indiaWebformTitle;

	protected WebDriver driver;

	public India(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public boolean hasIndiaWebFormPageDisplayed(String title) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, indiaWebformTitle).getText().contains(title);
	}

	public boolean hasIndiaFirstNameDisplayed(String firstName) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, indiaDashboard_FirstName).getText().contains(firstName);
	}

	public boolean hasIndiaBusinessNameDisplayed(String businessName) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, indiaDashboard_BusinessName).getText().contains(businessName);
	}

	public boolean hasIndiaBusinessAddrDisplayed(String businessAddr) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, indiaDashboard_BusinessAddr).getText().contains(businessAddr);
	}

	public boolean hasIndiaPhoneDisplayed(String phone) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, indiaDashboard_PhoneNumber).getText().contains(phone);
	}

	public boolean hasIndiaEmailDisplayed(String email) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, indiaDashboard_Email).getText().contains(email);
	}


	public boolean hasIndiaPrimaryMessageDisplayed(String priMsg) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, indiaDashboard_PrimaryMessage).getText().contains(priMsg);
	}


	public boolean hasClearButtonDisplayed(String clear) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, indiaDashboard_ClearButton).getText().contains(clear);
	}


	public India clickOnClearButton() {
		CommonFunctions.waitForElement(driver, indiaDashboard_ClearButton).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new India(driver);
	}

	
	public India product_selection() {
		CommonFunctions.waitForElement(driver, indiaDashboard_SelectProduct);
		CommonFunctions.selectFromDropdown(driver, "Techpubs Dashboard", indiaDashboard_SelectProduct);
		return new India(driver);
	}


	public India detailedDescription(String desc) {
		CommonFunctions.waitForElement(driver, indiaDashboard_Description).sendKeys(desc);
		return new India(driver);
	}

	
	public India uploadFile() {
		CommonFunctions.waitForElement(driver, indiaDashboard_AttButton).click();
		CommonFunctions.waitForElement(driver, indiaDashboard_SelectButton).click();
		try {
			CommonFunctions.uploadFileUsingRobotClass(filePathImage);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, indiaDashboard_FileAttachButton).click();
		return new India(driver);
	}

	
	public boolean hasFileAttachedDisplayed(String attachFile) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, indiaDashboard_AttachedFileLink).getText().contains(attachFile);
	}

	public India clickSubmitBtn() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, indiaDashboard_AttachSubmitButton).click();
		return new India(driver);
	}

	
	public India getCaseID() {
		String finalMsg = CommonFunctions.waitForElement(driver, indiaDashboard_SubInfo).getText();
		String[] strArr = finalMsg.split(" ");
		String Case_ID = strArr[8];
		caseID_India = strArr[8];
		FileWriter fw;
		try {
			fw = new FileWriter(filepath);
			fw.write(Case_ID);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().deleteAllCookies();
		return new India(driver);
	}

	public India waitForAlert() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {

		}
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		return new India(driver);
	}

	public boolean hasFinalMessageDisplayed(String finalMsg) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, indiaDashboard_SubInfo).getText().contains(finalMsg);
	}


	public boolean hasCommErrorMsgDisplayed(String valMsg) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, errorMsgCommts).getText().contains(valMsg);
	}
}
