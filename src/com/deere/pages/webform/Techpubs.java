package com.deere.pages.webform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.deere.global.CommonFunctions;
import com.deere.global.GlobalThings;

public class Techpubs extends GlobalThings {

	@FindBy(xpath = "//span[@data-test-id='20180309154956071941973']")
	private WebElement techpubsFirstNameLastName;

	@FindBy(xpath = "//span[@data-test-id='20180309154956072045627']")
	private WebElement techpubsPhoneNumber;

	@FindBy(xpath = "(//span[@data-test-id='20180309154956071942663'])[2]")
	private WebElement address;

	@FindBy(xpath = "//span[@data-test-id='20180309163651024524817']")
	private WebElement techpubsEmail;

	@FindBy(xpath = "//div[@data-test-id='20180309163423012514679']")
	private WebElement techpubsPrimaryMessage;

	@FindBy(xpath = "//select[@data-test-id='2018031412181703917767']")
	private WebElement techpubsSelectProduct;

	@FindBy(xpath = "#PIN")
	private WebElement techpubsDashboard_MachinePIN;

	@FindBy(xpath = "//textarea[@data-test-id='2018031408201703885440']")
	private WebElement techpubsDescription;

	@FindBy(xpath = "#DealerName")
	private WebElement TechpubsDealername;

	@FindBy(xpath = "#DealerCity")
	private WebElement techpubsDealerCity;

	@FindBy(xpath = "#DealerState")
	private WebElement techpubsDealerState;

	@FindBy(xpath = "//img[@name='MKTCaseAttachments_pyWorkPage_3']")
	private WebElement techpubsAttButton;

	@FindBy(xpath = "//div[@class='file-input-wrapper centered']")
	private WebElement techpubsSelectButton;

	@FindBy(xpath = "//button[@data-test-id='20140919030420037410647']")
	private WebElement techpubsFileAttachButton;

	@FindBy(xpath = "//button[@data-test-id='2018032009190808106446']")
	private WebElement techpubsAttachSubmitButton;

	@FindBy(xpath = "//div[@data-test-id='2015012615503109611417']")
	private WebElement techpubssubinfo;

	@FindBy(xpath = "//a[@class='Case_tools']")
	private WebElement techpubsattachedFileLink;

	@FindBy(xpath = "//select[@name='$PpyWorkPage$pWebformLanguage']")
	private WebElement techpubsDefaultLanguage;

	@FindBy(xpath = "//span[@class='iconRequired standard_iconRequired']")
	private WebElement techpubsDescriptionMsgInPortugues;

	@FindBy(xpath = "//img[@name='MKTCaseAttachments_pyWorkPage_3']")
	private WebElement jdParts_AttButton;

	@FindBy(xpath = "//option[@value='pt_BR']")
	private WebElement techpubsPortuguesLanguage;

	@FindBy(xpath = "//button[@data-test-id='2018032009190808106446']")
	private WebElement submitBtn;

	@FindBy(xpath = "//button[@data-test-id='2018032009190808117329']")
	private WebElement cancleBtn;

	@FindBy(xpath = "//button[@data-test-id='2018032009190808117329']")
	private WebElement techpubsClearButton;

	@FindBy(xpath = "(//div[@class='content-item content-label item-2 standard_dataLabelWrite'])[2]")
	private WebElement webForm;

	@FindBy(xpath = "//*[@id='$PpyWorkPage$pWebformCommentError']")
	private WebElement validMessg;

	@FindBy(xpath = "//textarea[@data-test-id='2018031408201703885440']")
	private WebElement desc;

	@FindBy(xpath = "//select[@data-test-id=\"2018031515004908565380\"]")
	private WebElement languageDD;

	

	protected WebDriver driver;

	public Techpubs(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public boolean hasFirstNameDisplayed(String firstName) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, techpubsFirstNameLastName).getText().contains(firstName);
	}

	public boolean hasPhoneNumberDisplayed(String phone) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, techpubsPhoneNumber).getText().contains(phone);
	}

	public boolean hasAddressDisplayed(String addr) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, address).getText().contains(addr);
	}

	public boolean hasTechpubsEmailDisplayed(String email) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, techpubsEmail).getText().contains(email);
	}

	public boolean hasTechpubsPrimaryMessageDisplayed(String priMsg) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, techpubsPrimaryMessage).getText().contains(priMsg);
	}

	public boolean hasTechpubsDefaultLanguageSelected() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, techpubsDefaultLanguage);
	}

	public boolean hasClearButtonDisplayed() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, techpubsClearButton);
	}

	public Techpubs clickOnClearButton() {
		CommonFunctions.waitForElement(driver, techpubsClearButton).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, submitBtn).click();
		CommonFunctions.waitForAlert(driver);
		CommonFunctions.waitForElement(driver, validMessg);
		return new Techpubs(driver);
	}

	public Techpubs clickSumitButton() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, submitBtn).click();
		CommonFunctions.waitForAlert(driver);
		CommonFunctions.waitForElement(driver, validMessg);
		return new Techpubs(driver);
	}

	public Techpubs productSelection() {
		CommonFunctions.waitForElement(driver, techpubsSelectProduct);
		CommonFunctions.selectFromDropdown(driver, "Techpubs Dashboard", techpubsSelectProduct);
		return new Techpubs(driver);
	}

	
	public Techpubs detailedDescription(String desc) {
		CommonFunctions.waitForElement(driver, techpubsDescription).sendKeys(desc);
		return new Techpubs(driver);

	}

	public boolean hasPortuguesLanguageMsgDisplayed() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, techpubsDescriptionMsgInPortugues);
	}

	public Techpubs selectPortuguesLanguage() {
		CommonFunctions.waitForElement(driver, languageDD).click();
		CommonFunctions.selectFromDropdownByIndex(driver, 4, languageDD);
		// CommonFunctions.waitForElement(driver,techpubsPortuguesLanguage).click();
		return new Techpubs(driver);
	}

	public Techpubs selectEnglishLanguage() {
		CommonFunctions.waitForElement(driver, languageDD).click();
		CommonFunctions.selectFromDropdownByIndex(driver, 2, languageDD);
		// CommonFunctions.waitForElement(driver,techpubsPortuguesLanguage).click();
		return new Techpubs(driver);
	}

	
	public Techpubs uploadFile() {
		CommonFunctions.waitForElement(driver, techpubsAttButton).click();
		CommonFunctions.waitForElement(driver, techpubsSelectButton).click();
		try {
			CommonFunctions.uploadFileUsingRobotClass(filePathImage);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, techpubsFileAttachButton).click();
		return new Techpubs(driver);
	}


	public boolean hasFileAttachedDisplayed(String fileAttach) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, techpubsattachedFileLink).getText().contains(fileAttach);
	}


	public Techpubs getCaseID1() {
		CommonFunctions.waitForElement(driver, techpubsAttachSubmitButton).click();
		String tm = CommonFunctions.waitForElement(driver, techpubssubinfo).getText();
		String[] strArr = tm.split(" ");
		String Case_ID = strArr[8];
		Caseid_Techpubs = strArr[8];
		return new Techpubs(driver);
	}

	public Techpubs clickSubmit() {
		CommonFunctions.waitForElement(driver, techpubsAttachSubmitButton).click();
		return new Techpubs(driver);
	}

	public Techpubs getCaseID() {
		String tm = CommonFunctions.waitForElement(driver, techpubssubinfo).getText();
		String[] strArr = tm.split(" ");
		Caseid_Techpubs = strArr[8];
		return new Techpubs(driver);
	}

	public boolean hasFinalMessageDisplayed(String msg) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (CommonFunctions.waitForElement(driver, techpubssubinfo).getText().contains(msg)) {
			return true;
		} else {
			return false;
		}
	}

	public Techpubs waitForAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.alertIsPresent());
			Thread.sleep(500);
			 driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		return new Techpubs(driver);
	}

	public boolean hasAddFileButtonDisplayed() {
		return CommonFunctions.isElementExist(driver, jdParts_AttButton);
	}

	public boolean hasSubmitButtonDisplayed() {
		CommonFunctions.scrollSomeDown(driver);
		return CommonFunctions.isElementExist(driver, submitBtn);
	}

	public boolean hasCancelButtonDisplayed(String cancelButn) {
		return CommonFunctions.waitForElement(driver, cancleBtn).getText().contains(cancelButn);
	}

	public boolean hasDetailedDescriptionDisplayed() {
		// TODO Auto-generated method stub
		return CommonFunctions.isElementExist(driver, desc);
	}

	public boolean hasWebFormPageDisplayed(String title) {
		// TODO Auto-generated method stub
		return CommonFunctions.waitForElement(driver, webForm).getText().contains(title);
	}
	public boolean hasTechPubWebFormPageDisplayed(String title) {
		// TODO Auto-generated method stub
		return CommonFunctions.waitForElement(driver, webForm).getText().contains(title);
	} 
	
	public boolean hasSubmitButtonDisplayed(String submitButn) {
		CommonFunctions.scrollSomeDown(driver);
		return CommonFunctions.waitForElement(driver, submitBtn).getText().contains(submitButn);
	} 
	public boolean hasClearButtonDisplayed(String clearButn) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, techpubsClearButton).getText().contains(clearButn);
	} 

}
