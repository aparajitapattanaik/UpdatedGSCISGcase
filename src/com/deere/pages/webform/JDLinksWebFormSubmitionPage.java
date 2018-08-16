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

public class JDLinksWebFormSubmitionPage extends GlobalThings {

	@FindBy(xpath = "//span[@data-test-id='20180309154956071941973']")
	private WebElement jdLDashboardFirstName;

	@FindBy(xpath = "(//span[@data-test-id='20180309154956071942663'])[2]")
	private WebElement jdDashboard_BusinessAddr;

	@FindBy(xpath = "//span[@data-test-id='20180309154956072045627']")
	private WebElement jdLDashboardPhoneNumber;

	@FindBy(xpath = "//span[@data-test-id='20180309163651024524817']")
	private WebElement jdLDashboardEmail;

	@FindBy(xpath = "//div[@data-test-id='20180309163423012514679']")
	private WebElement jdLDashboardPrimaryMessage;

	@FindBy(xpath = "//select[@data-test-id='2018031412181703917767']")
	private WebElement jdLDashboardSelectProduct;

	@FindBy(xpath = "#PIN")
	private WebElement jdLDashboardMachinePIN;

	@FindBy(xpath = "//textarea[@data-test-id='2018031408201703885440']")
	private WebElement jdlDashboardDescription;

	@FindBy(xpath = "#DealerName")
	private WebElement jdlDashboardDealername;

	@FindBy(xpath = "#DealerCity")
	private WebElement jdlDashboardDealerCity;

	@FindBy(xpath = "#DealerState")
	private WebElement jdlDashboarDealerState;

	@FindBy(xpath = "//img[@name='MKTCaseAttachments_pyWorkPage_3']")
	private WebElement jdlDashboardAttButton;

	@FindBy(xpath = "//div[@class='file-input-wrapper centered']")
	private WebElement jdlDashboardSelectButton;

	@FindBy(xpath = "//button[@data-test-id='20140919030420037410647']")
	private WebElement jdlDashboardFileAttachButton;

	@FindBy(xpath = "//button[@data-test-id='2018032009190808106446']")
	private WebElement jdlDashboardAttachSubmitButton;

	@FindBy(xpath = "//div[@data-test-id='2015012615503109611417']")
	private WebElement jdlDashboardSubInfo;

	@FindBy(xpath = "//a[@class='Case_tools']")
	private WebElement jdLinksDashboardAttachedFileLink;

	@FindBy(xpath = "//button[@data-test-id='2018032009190808117329']")
	private WebElement jdLinksDashboardClearButton;

	@FindBy(xpath = "//select[@data-test-id='2018031514545400505590']")
	private WebElement jdLLanguage;

	@FindBy(xpath = "//div[@id='$PpyWorkPage$pDecalModelError']")
	private WebElement jdLProdErrMessage;

	@FindBy(xpath = "//div[@id='$PpyWorkPage$pWebformCommentError']")
	private WebElement jdLDDErrMessage;

	@FindBy(xpath = "(//div[@class='content-item content-label item-2 standard_dataLabelWrite'])[2]")
	private WebElement jdLinksTitle;

	@FindBy(xpath = "//a[@class='Case_tools']")
	private WebElement r4Agcc_AttachedFileLink;

	protected WebDriver driver;

	public JDLinksWebFormSubmitionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public boolean hasJDLinksWebFormPageDisplayed(String title) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, jdLinksTitle).getText().contains(title);
	}

	public boolean hasJDLinksFirstNameDisplayed(String firstName) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, jdLDashboardFirstName).getText().contains(firstName);
	}

	public boolean hasJDLinksBusinessAddrDisplayed(String addr) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, jdDashboard_BusinessAddr).getText().contains(addr);
	}

	public boolean hasJDLinksPhoneDisplayed(String phone) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, jdLDashboardPhoneNumber).getText().contains(phone);
	}

	public boolean hasJDLinksEmailDisplayed(String email) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, jdLDashboardEmail).getText().contains(email);
	}

	public boolean hasJDLinksPrimaryMessageDisplayed(String priMsg) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, jdLDashboardPrimaryMessage).getText().contains(priMsg);
	}

	public JDLinksWebFormSubmitionPage productSelection() {
		CommonFunctions.waitForElement(driver, jdLDashboardSelectProduct);
		CommonFunctions.selectFromDropdown(driver, "JDLink Dashboard", jdLDashboardSelectProduct);
		return new JDLinksWebFormSubmitionPage(driver);
	}

	public JDLinksWebFormSubmitionPage selectLanguage() {
		CommonFunctions.waitForElement(driver, jdLLanguage);
		CommonFunctions.selectFromDropdown(driver, "Por favor seleccione su idioma: Español", jdLLanguage);
		return new JDLinksWebFormSubmitionPage(driver);
	}

	public JDLinksWebFormSubmitionPage detailedDescription(String desc) {
		CommonFunctions.waitForElement(driver, jdlDashboardDescription).sendKeys(desc);
		return new JDLinksWebFormSubmitionPage(driver);
	}

	public JDLinksWebFormSubmitionPage uploadFile() {
		CommonFunctions.waitForElement(driver, jdlDashboardAttButton).click();
		CommonFunctions.waitForElement(driver, jdlDashboardSelectButton).click();
		try {
			CommonFunctions.uploadFileUsingRobotClass(filePathImage);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, jdlDashboardFileAttachButton).click();
		return new JDLinksWebFormSubmitionPage(driver);
	}

	public boolean hasFileAttachedDisplayed(String fileAttach) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, jdLinksDashboardAttachedFileLink).getText().contains(fileAttach);
	}

	public boolean hasClearButtonDisplayed(String clearBtn) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, jdLinksDashboardClearButton).getText().contains(clearBtn);
	}

	public JDLinksWebFormSubmitionPage clickOnClearButton() {
		CommonFunctions.waitForElement(driver, jdLinksDashboardClearButton).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new JDLinksWebFormSubmitionPage(driver);
	}

	public JDLinksWebFormSubmitionPage clickOnSubmitButton() {
		CommonFunctions.waitForElement(driver, jdlDashboardAttachSubmitButton).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new JDLinksWebFormSubmitionPage(driver);
	}

	public JDLinksWebFormSubmitionPage waitForAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.alertIsPresent());
			Thread.sleep(500);
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		return new JDLinksWebFormSubmitionPage(driver);
	}

	public JDLinksWebFormSubmitionPage getCaseID() {
		String finalMsg = CommonFunctions.waitForElement(driver, jdlDashboardSubInfo).getText();
		String[] finalMsgSplit = finalMsg.split(" ");
		String case_ID = finalMsgSplit[8];
		caseID_JDlinks = finalMsgSplit[8];
		FileWriter fw;
		try {
			fw = new FileWriter(filepath);
			fw.write(case_ID);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.manage().deleteAllCookies();
		return new JDLinksWebFormSubmitionPage(driver);
	}

	public JDLinksWebFormSubmitionPage getCaseIDSpanish() {
		String finalMsg = CommonFunctions.waitForElement(driver, jdlDashboardSubInfo).getText();
		String[] finalMsgSplit = finalMsg.split(" ");
		String case_ID = finalMsgSplit[12];
		caseID_JDlinks = finalMsgSplit[12];
		FileWriter fw;
		try {
			fw = new FileWriter(filepath);
			fw.write(case_ID);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.manage().deleteAllCookies();
		return new JDLinksWebFormSubmitionPage(driver);
	}

	public boolean hasFinalMessageDisplayed(String finalMsg) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, jdlDashboardSubInfo).getText().contains(finalMsg);
	}

	public boolean hasJDLinksProdErrMessageDisplayed(String validMsg) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, jdLProdErrMessage).getText().contains(validMsg);
	}

	public boolean hasJDLinksDDErrMessage(String validMsg) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, jdLDDErrMessage).getText().contains(validMsg);
	}

}
