package com.deere.pages.gsccasecreation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.deere.global.CommonFunctions;


public class GSCCaseCreationPage {

	@FindBy(xpath = "(//label[contains(text(),'Home')])[1]")
	private WebElement homePagetab;

	@FindBy(xpath = "//iframe[contains(@src,'SolutionSearchHome')]")
	private WebElement iframePegaGadget;

	@FindBy(xpath = "//button[@data-test-id='20180201163908004467353']")
	private WebElement creategsccase;

	@FindBy(xpath = "(//i[@data-test-id='201512210438090148308293'])[1]")
	private WebElement gscAddCustInfoButton;

	@FindBy(xpath = "//span[@id='modaldialog_hd_title']")
	private WebElement customerSearchHeader;

	@FindBy(xpath = "//input[@id='firstName']")
	private WebElement customerFirstName;

	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement customerLastName;

	@FindBy(xpath = "//select[@id='country']")
	private WebElement customerCountry;

	@FindBy(xpath = "//input[@class='button btn btn-primary']")
	private WebElement gscAddCustInfoSearchCustomers;

	@FindBy(id = "PegaGadget0Ifr")
	private WebElement iFrameZero;

	@FindBy(xpath = "//table[@id='results']/tbody/tr[2]/td[2]/a")
	private WebElement customerSearchDetails;

	@FindBy(xpath = "(//i[@data-test-id='201512210438090148308293'])[2]")
	private WebElement gscAddProductInfoIcon;

	@FindBy(xpath = "//input[@id='DecalModel']")
	private WebElement gscModel;

	@FindBy(xpath = "(//span[text()='r/JD Miscellaneous Equipment'])[2]")
	private WebElement gscSelectedModel;

	@FindBy(xpath = "//button[@data-test-id='20140919030420037410647']")
	private WebElement gscProductInformationSubitButton;

	@FindBy(xpath = "//input[@id='FUNC_AREA_NM']")
	private WebElement caseCodingFunctionalArea;

	@FindBy(xpath = "(//span[text()='CCE'])[1]")
	private WebElement selectCaseCodingFunctionalArea;

	@FindBy(xpath = "//input[@id='FUNC_CODE_NM']")
	private WebElement caseCodingFunctionalcode;

	@FindBy(xpath = "//select[@id='CasePriority']")
	private WebElement gscPriority;

	@FindBy(xpath = "//select[@id='LanguageWithCode']")
	private WebElement gscLanguage;

	@FindBy(xpath = "//select[@id='Origin']")
	private WebElement gscOrigin;

	@FindBy(xpath = "//input[@name='$PpyWorkPage$pCaseSummary']")
	private WebElement gscAddSummary;

	@FindBy(xpath = "(//button[@data-test-id='201802011400580656111285'])[1]")
	private WebElement acceptButton;

	@FindBy(xpath = "//select[@id='WorkbasketName']")
	private WebElement workBasket;

	@FindBy(xpath = "//select[@id='GSCSubWorkgroup']")
	private WebElement workSubgroup;

	@FindBy(name = "PegaGadget0Ifr")
	private WebElement iframeHomepage;

	@FindBy(xpath = "//iframe[@id='CSC_Section']")
	private WebElement iFrameAddCustomer;

	@FindBy(xpath = "(//button[@data-test-id='201802011400580656111285'])[1]")
	private WebElement clickAcceptButton;

	@FindBy(xpath = "(//button[@data-test-id='201802011400580656112342'])[1]")
	private WebElement clickRouteButton;

	@FindBy(xpath = "//div[@class='content-item content-field item-3 remove-top-spacing remove-bottom-spacing remove-left-spacing remove-right-spacing']")
	private WebElement statusAsNew;

	@FindBy(xpath = "//div[@class='pzbtn-rgt']/descendant::div[contains(text(),'Actions')]")
	private WebElement actionButton;

	@FindBy(xpath = "//span[contains(text(),'Send Case Email')]")
	private WebElement gscSendCaseMailButton;

	@FindBy(xpath = "//input[@data-test-id='201612271036230356233958']")
	private WebElement gscEmailEnterBox;

	@FindBy(xpath = "//button[@data-test-id='20140919030420037410647']")
	private WebElement gscSendButton;

	@FindBy(xpath = "//h2[contains(text(),'Audit')]")
	private WebElement auditTrails;

	@FindBy(xpath = "//select[@id='Action']")
	private WebElement actionTextbox;

	@FindBy(xpath = "//select[@id='Action']")
	private WebElement ActionTextboxOptions;

	@FindBy(xpath = "//span[contains(text(),'Work Case')]")
	private WebElement workcaseButton;

	@FindBy(xpath = "(//div[@class='field-item dataValueRead'])[3]")
	private WebElement assertNew;

	@FindBy(xpath = "//div[@class='content-item content-field item-3 remove-top-spacing remove-bottom-spacing remove-left-spacing remove-right-spacing']")
	private WebElement statusOwned;

	@FindBy(xpath = "//li[@title='Transfer Case To WB']")
	private WebElement transfer_case_To_WB;

	@FindBy(xpath = "(//button[@data-test-id='20180206104022047318388'])[1]")
	private WebElement transfer_Button;

	protected WebDriver driver;

	public GSCCaseCreationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public boolean homePageDisplayed() {

		try {

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// CommonFunctions.waitAndSwitchToFrame(driver, iframePegaGadget);
		return CommonFunctions.isElementExist(driver, homePagetab);

	}

	public boolean gscPageDisplayed() {

		CommonFunctions.waitAndSwitchToFrame(driver, iframeHomepage);
		return CommonFunctions.isElementExist(driver, gscAddCustInfoButton);
	}

	public boolean addCustomerDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, customerSearchHeader);
	}

	public GSCCaseCreationPage clickGSCCase() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, creategsccase).click();
		// CommonFunctions.switchToiFrameByIDOrName(driver, "IframeHomepage");
		return new GSCCaseCreationPage(driver);
	}

	public GSCCaseCreationPage clickOnAddCustomeInfo() {
		CommonFunctions.waitForElement(driver, gscAddCustInfoButton).click();
		return new GSCCaseCreationPage(driver);

	}

	public boolean firstnameDisplayed() {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, customerFirstName);
	}

	public boolean lastnameDisplayed() {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, customerLastName);
	}

	public boolean hasCustomeInfoDisplayed() {
		try {
			Thread.sleep(1000);
			driver.switchTo().parentFrame();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, gscAddProductInfoIcon);
	}

	public boolean statusNew() {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, statusAsNew);
	}

	public boolean hasActionDisplayed() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, actionButton);
	}

	public GSCCaseCreationPage enterCustomerFirstName(String custFirstName) {
		// driver.switchTo().defaultContent();
		// CommonFunctions.waitAndSwitchToFrame(driver, IframeHomepage);
		CommonFunctions.waitAndSwitchToFrame(driver, iFrameAddCustomer);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, customerFirstName).sendKeys(custFirstName);
		return new GSCCaseCreationPage(driver);
	}

	public GSCCaseCreationPage enterCustomerLastName(String custLastName) {
		CommonFunctions.waitForElement(driver, customerLastName).sendKeys(custLastName);
		return new GSCCaseCreationPage(driver);
	}

	public GSCCaseCreationPage selectCountry(String country) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, customerCountry).sendKeys(country);
		return new GSCCaseCreationPage(driver);

	}

	public GSCCaseCreationPage clickGSCSearchCustomer() {
		CommonFunctions.waitForElement(driver, gscAddCustInfoSearchCustomers).click();
		return new GSCCaseCreationPage(driver);
	}

	public GSCCaseCreationPage clickOnAddProductInfo() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitAndSwitchToFrame(driver, iFrameZero);
		CommonFunctions.waitForElement(driver, gscAddProductInfoIcon).click();
		return new GSCCaseCreationPage(driver);
	}

	public GSCCaseCreationPage clickSearchCustomerDetails() {
		CommonFunctions.waitForElement(driver, customerSearchDetails).click();
		return new GSCCaseCreationPage(driver);
	}

	public GSCCaseCreationPage clickAddProductInfo() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, gscAddProductInfoIcon).click();
		return new GSCCaseCreationPage(driver);
	}

	public GSCCaseCreationPage enterProductModel(String model) {
		CommonFunctions.waitForElement(driver, gscModel).sendKeys(model);
		return new GSCCaseCreationPage(driver);
	}

	public GSCCaseCreationPage clickAddProductSubmit() {
		CommonFunctions.waitForElement(driver, gscProductInformationSubitButton).click();
		return new GSCCaseCreationPage(driver);
	}

	public GSCCaseCreationPage enterAddSummary(String summary) {
		CommonFunctions.waitForElement(driver, gscAddSummary).sendKeys(summary);
		return new GSCCaseCreationPage(driver);
	}

	public GSCCaseCreationPage clickOnAcceptBtn() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, acceptButton).click();
		return new GSCCaseCreationPage(driver);
	}

	public GSCR4Page navigateToGSCR4Page() {
		return new GSCR4Page(driver);
	}

	public GSCCaseCreationPage enterCasecodingFA(String FArea) {
		CommonFunctions.waitForElement(driver, caseCodingFunctionalArea).sendKeys(FArea);
		return new GSCCaseCreationPage(driver);
	}

	public GSCCaseCreationPage enterCasecodingFC(String FCode) {
		CommonFunctions.waitForElement(driver, caseCodingFunctionalcode).sendKeys(FCode);
		return new GSCCaseCreationPage(driver);
	}

	public GSCCaseCreationPage enterPriority(String priority) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, gscPriority).sendKeys(priority);
		return new GSCCaseCreationPage(driver);
	}

	public GSCCaseCreationPage enterLanguage(String Language) {
		CommonFunctions.waitForElement(driver, gscLanguage).sendKeys(Language);
		return new GSCCaseCreationPage(driver);
	}

	public GSCCaseCreationPage enterOrigin(String Origin) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, gscOrigin).sendKeys(Origin);
		return new GSCCaseCreationPage(driver);
	}

	public GSCCaseCreationPage EnterAddSummary(String summary) {
		CommonFunctions.waitForElement(driver, gscAddSummary).sendKeys(summary);
		return new GSCCaseCreationPage(driver);
	}

	public GSCCaseCreationPage selectWorkBasket(String Workbasket) {
		try {
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.selectFromDropdown(driver, Workbasket, workBasket);
		CommonFunctions.selectFromDropdown(driver, Workbasket, workBasket);

		return new GSCCaseCreationPage(driver);
	}

	public GSCCaseCreationPage selectWorkgroupDD(String Workgroup) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, workSubgroup).sendKeys(Workgroup);
		return new GSCCaseCreationPage(driver);
	}

	public GSCCaseCreationPage clickAccept() {
		CommonFunctions.waitForElement(driver, clickAcceptButton).click();
		return new GSCCaseCreationPage(driver);
	}

	public GSCCaseCreationPage clickRoute() {
		CommonFunctions.waitForElement(driver, clickRouteButton).click();
		return new GSCCaseCreationPage(driver);
	}

	// ******************Aparajita*AuditTrails*********************************
	public GSCCaseCreationPage clickActions() {
		CommonFunctions.waitForElement(driver, actionButton).click();
		return new GSCCaseCreationPage(driver);
	}

	public GSCCaseCreationPage clickSendCaseMail() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, gscSendCaseMailButton).click();
		return new GSCCaseCreationPage(driver);
	}

	public GSCCaseCreationPage enterSendCaseEmail(String mail) {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, gscEmailEnterBox).sendKeys(mail);
		return new GSCCaseCreationPage(driver);
	}

	public GSCCaseCreationPage clickOnSendButton() {
		CommonFunctions.waitForElement(driver, gscSendButton).click();
		return new GSCCaseCreationPage(driver);
	}

	public GSCCaseCreationPage expandAuditTrails() {
		CommonFunctions.scrollToElement(driver, auditTrails);
		CommonFunctions.waitForElement(driver, auditTrails).click();
		return new GSCCaseCreationPage(driver);

	}

	public GSCCaseCreationPage alertVerificationGSC() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForAlert(driver);
		return new GSCCaseCreationPage(driver);
	}

	// **************** Aparajita
	// US31497******************************************************************//

	public boolean Route_NewStatus() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, statusAsNew);
	}

	public boolean OwnedStatus() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, statusOwned);
	}

	public GSCCaseCreationPage clickActionBtn() {
		try {
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionButton).click();
		return new GSCCaseCreationPage(driver);

	}

	public GSCCaseCreationPage selectWorkcase() {
		try {
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, workcaseButton).click();
		return new GSCCaseCreationPage(driver);

	}

	public GSCCaseCreationPage clickTransferCaseWorkBasketOption() {
		try {
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, transfer_case_To_WB).click();
		return new GSCCaseCreationPage(driver);

	}

	public GSCCaseCreationPage clickTransferOption() {
		try {
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, transfer_Button).click();
		return new GSCCaseCreationPage(driver);
	}

	public boolean hasNewDraftStatysDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, statusAsNew);

	}

	public boolean isAddCustomerDisplayed() {
		try {

			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return CommonFunctions.isElementExist(driver, customerSearchHeader);
	}

}
