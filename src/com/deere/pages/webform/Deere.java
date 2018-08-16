package com.deere.pages.webform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.deere.global.CommonFunctions;
import com.deere.global.GlobalThings;

public class Deere extends GlobalThings {

	@FindBy(xpath = "//input[@name='userName']")
	private WebElement deereUsername;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement deerepassword;

	@FindBy(xpath = "//input[@class='cta_btn']")
	private WebElement deereSubmit;

	@FindBy(xpath = "//select[@data-test-id='2018032215532701475431']")
	private WebElement country;

	@FindBy(xpath = "//textarea[@data-test-id='2018031407540502455903']")
	private WebElement comment;

	@FindBy(xpath = "//span[@data-test-id='20180309154956071941973']")
	private WebElement fisrtName;

	@FindBy(xpath = "(//span[@data-test-id='20180309154956071942663'])[2]")
	private WebElement address;

	@FindBy(xpath = "//span[@data-test-id='20180309154956072045627']")
	private WebElement phoneNumber;

	@FindBy(xpath = "//span[@data-test-id='20180309154956071941973']")
	private WebElement deereDashboard_FirstName;

	@FindBy(xpath = "//span[@data-test-id='20180309163651024524817']")
	private WebElement emailAddress;

	@FindBy(xpath = "//textarea[@data-test-id='2018031407540502455903']")
	private WebElement description;

	@FindBy(xpath = "//span[@data-test-id='20180309154956071941973']")
	private WebElement deereDashboard_Address;

	@FindBy(xpath = "//div[@data-test-id='2015012615503109611417']")
	private WebElement deereDashboard_SubInfo;

	@FindBy(xpath = "//span[@data-test-id='20180309154956072045627']")
	private WebElement deereDashboard_PhoneNumber;

	@FindBy(xpath = "//span[@data-test-id='20180309163651024524817']")
	private WebElement deereDashboard_Email;

	@FindBy(xpath = "//div[@data-test-id='20180309163423012514679']")
	private WebElement deereDashboard_PrimaryMessage;

	@FindBy(xpath = "//select[@data-test-id='2018032215532701475431']")
	private WebElement deereDashboard_SelectCountry;

	@FindBy(xpath = "//textarea[@id='WebformComment']")
	private WebElement deereDashboard_Description;

	@FindBy(xpath = "//input[@id='DealerName']")
	private WebElement deereDashboard_DealerName;

	@FindBy(xpath = "//input[@id='DealerCity']")
	private WebElement deereDashboard_DealerCity;

	@FindBy(xpath = "//input[@id='DealerState']")
	private WebElement deereDashboard_DealerState;

	@FindBy(xpath = "//img[@name='MKTCaseAttachments_pyWorkPage_3']")
	private WebElement deereDashboard_AttButton;

	@FindBy(xpath = "//div[@class='file-input-wrapper centered']")
	private WebElement deereDashboard_SelectButton;

	@FindBy(xpath = "//button[@data-test-id='20140919030420037410647']")
	private WebElement deereDashboard_FileAttachButton;

	@FindBy(xpath = "//button[@data-test-id='2018032009190808106446']")
	private WebElement deereDashboard_AttachSubmitButton;

	@FindBy(xpath = "//a[@class='Case_tools']")
	private WebElement deereDashboard_AttachedFileLink;

	@FindBy(xpath = "//button[@data-test-id='2018032009190808117329']")
	private WebElement deereDashboard_ClearButton;

	@FindBy(xpath = "//button[@data-test-id=\"2018032009190808106446\"]")
	private WebElement submitBtn;

	@FindBy(xpath = "(//div[@class='content-item content-label item-2 standard_dataLabelWrite'])[2]")
	private WebElement deereTitle;

	@FindBy(xpath = "//*[@id='$PpyWorkPage$pWebformCommentError']")
	private WebElement validMessg;

	protected WebDriver driver;

	public Deere(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public boolean hasAddressDisplayed(String addr) {
		return CommonFunctions.waitForElement(driver, address).getText().contains(addr);
	}

	public boolean hasFisrtNameDisplayed(String firstName) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, deereDashboard_FirstName).getText().contains(firstName);
	}

	public boolean hasPhoneNumberDisplayed(String phone) {
		return CommonFunctions.waitForElement(driver, phoneNumber).getText().contains(phone);
	}

	public boolean hasPrimaryMessageDisplayed(String priMsg) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, deereDashboard_PrimaryMessage).getText().contains(priMsg);
	}

	public boolean hasDeereWebFormPageDisplayed(String title) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, deereTitle).getText().contains(title);
	}

	public boolean hasEmailAddressDispalyed(String email) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, deereDashboard_Email).getText().contains(email);
	}

	public boolean hasDealerNameExist() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, deereDashboard_DealerName);
	}

	public boolean hasDealerCityExist() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, deereDashboard_DealerCity);
	}

	public boolean hasDealerStateExist() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, deereDashboard_DealerState);
	}

	// Product DD selection in JDLinkswebform
	public Deere selectCountry() {
		CommonFunctions.waitForElement(driver, deereDashboard_SelectCountry);
		CommonFunctions.selectFromDropdown(driver, "United States", deereDashboard_SelectCountry);
		return new Deere(driver);
	}

	// Detailed_description entering in JDLinkswebform
	public Deere detailedDescription(String desc) {
		CommonFunctions.waitForElement(driver, deereDashboard_Description).sendKeys(desc);
		return new Deere(driver);
	}

	public Deere DealerName() {
		CommonFunctions.waitForElement(driver, deereDashboard_Description);
		return new Deere(driver);
	}

	public Deere DealerCity() {
		CommonFunctions.waitForElement(driver, deereDashboard_Description);
		return new Deere(driver);
	}

	public Deere DealerState() {
		CommonFunctions.waitForElement(driver, deereDashboard_Description);
		return new Deere(driver);
	}

	// File uploading and submit
	public Deere fileUpload() {
		CommonFunctions.waitForElement(driver, deereDashboard_AttButton).click();
		CommonFunctions.waitForElement(driver, deereDashboard_SelectButton).click();
		try {
			CommonFunctions.uploadFileUsingRobotClass(filePathImage);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, deereDashboard_FileAttachButton).click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.scrollSomeDown(driver);
		return new Deere(driver);
	}

	public Deere clickOnSubmitBtn() {
		CommonFunctions.waitForElement(driver, submitBtn).click();
		return new Deere(driver);
	}

	public boolean hasFileAttachedDisplayed(String fileAttach) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, deereDashboard_AttachedFileLink).getText().contains(fileAttach);
	}

	public boolean hasClearButton(String clearBtn) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, deereDashboard_ClearButton).getText().contains(clearBtn);
	}

	public Deere clickOnClearButton() {
		CommonFunctions.waitForElement(driver, deereDashboard_ClearButton).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Deere(driver);
	}

	public Deere GetCaseID() {
		String tm = CommonFunctions.waitForElement(driver, deereDashboard_SubInfo).getText();
		String[] strArr = tm.split(" ");
		String Case_ID = strArr[8];
		caseID_Deere = strArr[8];
		driver.manage().deleteAllCookies();
		return new Deere(driver);
	}

	public boolean hasFirstNameDisplayed(String firstName) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, fisrtName).getText().contains(firstName);
	}

	public boolean hasEmailAddressDisplayed(String email) {
		return CommonFunctions.waitForElement(driver, emailAddress).getText().contains(email);
	}

	public Deere detailedDesc(String desc) {
		CommonFunctions.waitForElement(driver, description).sendKeys(desc);

		return new Deere(driver);
	}

	public boolean hasFinalMessageDisplayed(String finalMsg) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, deereDashboard_SubInfo).getText().contains(finalMsg);
	}

	public boolean hasCountryDisplayed() {
		return CommonFunctions.isElementExist(driver, country);
	}

	public boolean hasCommentsDisplayed() {
		return CommonFunctions.isElementExist(driver, comment);
	}

	public boolean hasSubmitButton(String submtBtn) {
		return CommonFunctions.waitForElement(driver, submitBtn).getText().contains(submtBtn);
	}

	public Deere clkSubmitButton() {

try {
	Thread.sleep(1000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		CommonFunctions.waitForElement(driver, submitBtn).click();
		return new Deere(driver);
	}

	public boolean hasValidMessgDisplayed() {
		return CommonFunctions.isElementExist(driver, validMessg);
	}

	public Deere alertAccept() {
		CommonFunctions.waitForAlert(driver);
		return new Deere(driver);
	}

	public Deere clkSubmit() {
		CommonFunctions.waitForElement(driver, submitBtn).click();
		return new Deere(driver);
	}
}
