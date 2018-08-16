package com.deere.pages.gsccasecreation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;
import com.deere.global.GlobalThings;

public class GSCCustomerSearch extends GlobalThings {

	@FindBy(xpath = "(//a[starts-with(@title,'New Deere.com Case')])[1]")
	private WebElement gscNewCaseMailLinkZeacom;

	@FindBy(xpath = "(//label[contains(text(),'Home')])[1]")
	private WebElement homePageTab;

	@FindBy(xpath = "//iframe[contains(@src,'SolutionSearchHome')]")
	private WebElement iFramePegaGadget;

	@FindBy(xpath = "//button[@data-test-id='20180201163908004467353']")
	private WebElement createGSCCase;

	@FindBy(xpath = "(//i[@data-test-id='201512210438090148308293'])[1]")
	private WebElement gscAddCustInfoButton;

	@FindBy(xpath = "(//i[@data-test-id='201512210438090148308293'])[2]")
	private WebElement addContactDealership;

	@FindBy(xpath = "(//div[@data-test-id='20151123025854066711391'])[3]")
	private WebElement productInfoButton;

	@FindBy(xpath = "(//h2[contains(text(),'Case Coding')])[2]")
	private WebElement caseCoding;

	@FindBy(xpath = "//span[@id='modaldialog_hd_title']")
	private WebElement customerSearchHeader;

	@FindBy(xpath = "//div[@data-test-id='201710031413550415704']")
	private WebElement auditHistory;

	@FindBy(xpath = "//input[@id='firstName']")
	private WebElement customerFirstName;

	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement customerLastName;

	@FindBy(xpath = "//input[@id='city1']")
	private WebElement cityField;

	@FindBy(xpath = "//select[@id='country']")
	private WebElement customerCountry;

	@FindBy(xpath = "//input[@class='button btn btn-primary']")
	private WebElement gscAddCustInfoSearchCustomers;

	@FindBy(xpath = "(//a[contains(text(),' DETAILS ')])[1]")
	private WebElement customerDetails;

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

	@FindBy(xpath = "//select[@id='GSCSubWorkgroup']")
	private WebElement workSubGroup;

	@FindBy(xpath = "//input[@id='GreenFleetNumber']")
	private WebElement greenFleetNumber;

	@FindBy(name = "PegaGadget0Ifr")
	private WebElement iFrameHomePage;

	@FindBy(xpath = "//span[@data-test-id='20150116110353086421138']")
	private WebElement createCase;

	@FindBy(xpath = "//span[@id='modaldialog_hd_title']")
	private WebElement customerSearchModal;

	@FindBy(xpath = "//iframe[@id='CSC_Section']")
	private WebElement iFrameAddCustomer;

	@FindBy(xpath = "(//button[@data-test-id='201802011400580656111285'])[1]")
	private WebElement acceptButton;

	@FindBy(xpath = "//span[@data-test-id='20141009112850013217103']")
	private WebElement caseId;

	@FindBy(xpath = "(//button[@data-test-id='2018021409524402562359'])[1]")
	private WebElement submitButton;

	@FindBy(xpath = "//a[@data-test-id='2014100609491604327565']")
	private WebElement name;

	@FindBy(xpath = "	//span[contains(text(),'Log off')]")
	private WebElement logout;

	@FindBy(xpath = "//div[@class='content-item content-field item-3 remove-top-spacing remove-bottom-spacing remove-left-spacing remove-right-spacing']")
	private WebElement newStatus;

/*	@FindBy(xpath = "//ul[@id='pyNavigation1528360059917']/li[2]")
	private WebElement tss;*/
	
	@FindBy(xpath = "//span[contains(text(),'TSS Reopen: ')]")
	private WebElement tss;
	
	@FindBy(xpath = "//div[@class='content-item content-field item-3 remove-top-spacing remove-bottom-spacing remove-left-spacing remove-right-spacing']")
	private WebElement reopenStatus;

	@FindBy(xpath = "//li[@class='menu-item menu-item-enabled']//span[contains(text(),'Reopen')]")
	private WebElement reopen;

	@FindBy(xpath = "//span[contains(text(),'Send Case Email')]")
	private WebElement clickGSCSendCaseMailButton;

	@FindBy(xpath = "//input[@data-test-id='201612271036230356233958']")
	private WebElement clickGSCEmailEnterBox;

	@FindBy(xpath = "(//button[@data-test-id='20140919030420037410647'])[1]")
	private WebElement clickGSCSendButton;

	@FindBy(xpath = "//h2[contains(text(),'Audit')]")
	private WebElement auditTrails;

	@FindBy(xpath = "//select[@id='Action']")
	private WebElement actionTextbox;

	@FindBy(xpath = "//div[contains(text(),'Time')]")
	private WebElement time;

	@FindBy(xpath = "//div[@class='content-item content-field item-3 remove-top-spacing remove-bottom-spacing remove-left-spacing remove-right-spacing']")
	private WebElement statusOwned;

	@FindBy(xpath = "//li[@title='Transfer Case To WB']")
	private WebElement transferCaseToWB;

	@FindBy(xpath = "(//button[@data-test-id='20180206104022047318388'])[1]")
	private WebElement transferButton;

	@FindBy(xpath = "//button[@data-test-id='20180531073524008831831']")
	private WebElement withdrawButton;

	@FindBy(xpath = "(//button[@data-test-id='2018021409524402562359'])[2]")
	private WebElement withDrawSubmit;

	@FindBy(xpath = "//div[@data-test-id=\"20141009112130085821433\"]")
	private WebElement textMessage;

	@FindBy(xpath = "(//div[@class='field-item dataValueRead'])[2]")
	private WebElement withdrawn;

	@FindBy(xpath = "//div[@class='content-item content-field item-3 remove-top-spacing remove-bottom-spacing remove-left-spacing remove-right-spacing' ]")
	private WebElement newDraft;

	@FindBy(xpath = "//select[@id='WBName']")
	private WebElement selectWorkBasket;

	@FindBy(xpath = "(//button[contains(text(),'Cancel')])[1]")
	private WebElement cancelButton;

	@FindBy(xpath = "//div[@class='pzbtn-rgt']/descendant::div[contains(text(),'Actions')]")
	private WebElement withdrawAction;

	@FindBy(xpath = "//span[contains(text(),'Refresh')]")
	private WebElement refreshButton;

	@FindBy(xpath = "//span[contains(text(),'Work Case')]")
	private WebElement workcase;

	@FindBy(xpath = "//span[contains(text(),'Print')]")
	private WebElement print;

	@FindBy(xpath = "//iframe[@id='PegaGadget1Ifr']")
	private WebElement iFramePegaGadgetISGAssertion;

	@FindBy(xpath = "//span[@data-test-id='20180424084340049412218']")
	private WebElement gscWorkBasket;

	@FindBy(xpath = "//label[contains(text(),'Correspondence')]")
	private WebElement gscCorrespondence;

	@FindBy(xpath = "(//a[@class='Case_tools'])[2]")
	private WebElement gscNewCaseMailLink;

	@FindBy(xpath = "//img[@data-test-id='20150114172745004213890']")
	private WebElement gscAttButton;

	@FindBy(xpath = "//div[@class='file-input-wrapper centered']")
	private WebElement gscSelectButton;

	@FindBy(xpath = "(//div[@class='pzbtn-mid'])[1]")
	private WebElement gscFileAttachButton;

	@FindBy(xpath = "//div[contains(text(),'A file has been attached: ISG_cust.')]")
	private WebElement fileAttached;

	@FindBy(xpath = "//div[contains(text(),'Correspondence has been attached: fddddddd.')]")
	private WebElement correspondanceAttached;

	@FindBy(xpath = "//span[contains(text(),'Transfer Case To Individu...')]")
	private WebElement gscTransferIndividualButton;

	@FindBy(xpath = "//input[@data-test-id='20170915163723049610155']")
	private WebElement gscTransferIndividualOperator;

	@FindBy(xpath = "//input[@data-test-id='2015031809055206723480']")
	private WebElement gscTransferIndividualWorkbasket;

	@FindBy(xpath = "//button[@data-test-id='20140919030420037410647']")
	private WebElement gscTransferSubmit;

	@FindBy(xpath = "(//input[@class='button'])[2]")
	private WebElement back;

	@FindBy(xpath = "(//button[@data-test-id='201802011400580656111285'])[1]")
	private WebElement acceptStatusBtn;

	@FindBy(xpath = "(//button[@data-test-id='20180201140326025511943'])[1]")
	private WebElement acceptAndCloseBtn;

	@FindBy(xpath = "(//button[@data-test-id='20180201140326025613196'])[1]")
	private WebElement saveBtn;

	@FindBy(xpath = "(//button[@data-test-id='20180201162439008710139'])[2]")
	private WebElement closeBtn;

	@FindBy(xpath = "(//button[@data-test-id='201802081002310780562'])[1]")
	private WebElement cancelBtn;
	
	@FindBy(xpath="//button[@id='ModalButtonCancel']")
	private WebElement cancelBtnCustomerSearch;
	
	@FindBy(xpath = "//div[@class='pzbtn-rgt']/descendant::div[contains(text(),'Actions')]")
	private WebElement actionButton;

	@FindBy(xpath = "//div[@class='content-item content-field item-3 remove-top-spacing remove-bottom-spacing remove-left-spacing remove-right-spacing']")
	private WebElement reolvedCompletedStatus;

	@FindBy(xpath = "//td[contains(text(),'Phone:')]")
	private WebElement phone;

	@FindBy(xpath = "//td[contains(text(),'Business Name:')]")
	private WebElement businessName;

	@FindBy(xpath = "//td[contains(text(),'Last Name:')]")
	private WebElement lastName;

	@FindBy(xpath = "//td[contains(text(),'First/Familiar Name:')]")
	private WebElement firstName;

	@FindBy(xpath = "//td[contains(text(),'Country:')]")
	private WebElement country;

	@FindBy(xpath = "//div[@id='stateLabelSelect']")
	private WebElement state;

	@FindBy(xpath = "//div[@id='cityLabelText']")
	private WebElement city;

	@FindBy(xpath = "//td[contains(text(),'Zip/Postal Code:')]")
	private WebElement postalCode;

	@FindBy(xpath = "//input[@id='businessName']")
	private WebElement businessNameField;

	@FindBy(xpath = "//input[@id='postalCode']")
	private WebElement postal;

	@FindBy(xpath = "(//input[@class='button'])[1]")
	private WebElement reset;

	@FindBy(xpath = "//b[contains(text(),'Name')]")
	private WebElement business;

	@FindBy(xpath = "//b[contains(text(),'Physical Address')]")
	private WebElement physical;

	@FindBy(xpath = "(//span[@data-test-id='201802211054570002105727'])[1]")
	private WebElement firstNameDetails;

	@FindBy(xpath = "(//span[@data-test-id='201802211054570002105727'])[2]")
	private WebElement lastNameDetails;

	@FindBy(xpath = "//span[@data-test-id='201803021304180155104235']")
	private WebElement phoneDetails;

	@FindBy(xpath = "//span[@data-test-id='201802211050460576125212']")
	private WebElement addressDetails;
	

	@FindBy(xpath="//button[@id='ModalButtonCancel']")
	private WebElement can;

	@FindBy(xpath = "//span[@data-test-id='20180221105250019383254']")
	private WebElement entityDetails;

	@FindBy(xpath = "//b[contains(text(),'Mailing Address')]")
	private WebElement mailing;

	@FindBy(xpath = "//a[@data-test-id='20180509152210023139829']")
	private WebElement createCustomer;

	@FindBy(xpath = "//a[@data-test-id='201802121025230166233141']")
	private WebElement clearCustomer;

	@FindBy(xpath = "//b[contains(text(),'Contact Information')]")
	private WebElement businessNumber;

	@FindBy(xpath = "//select[@id='WorkbasketName']")
	private WebElement workBasketButton;

	@FindBy(xpath = "//span[@id='modaldialog_hd_title']")
	private WebElement searchCustomerModal;
	
	@FindBy(xpath = "//a[@data-test-id='201804240833000773168']")
	private WebElement changeCustomer;
		
	@FindBy(xpath = "(//div[@data-test-id='20151123025854066711391'])[1]")
	private WebElement customerInfo;

	@FindBy(xpath = "(//div[@data-test-id='20151123025854066711391'])[2]")
	private WebElement contactDealesrShip;

	@FindBy(xpath = "(//h2[contains(text(),'Case Coding')])[2]")
	private WebElement caseCodingHeader;

	@FindBy(xpath = "(//div[@data-test-id='20151123025854066711391'])[3]")
	private WebElement productInfo;

	@FindBy(xpath = "//h2[contains(text(),'Case Information')]")
	private WebElement caseInformation;

	@FindBy(xpath = "//h2[contains(text(),'Related Case')]")
	private WebElement relatedCase;

	@FindBy(xpath = "//h2[contains(text(),'Problem Details')]")
	private WebElement problemDetails;

	@FindBy(xpath = "//div[@data-test-id='20151123094958005467694']")
	private WebElement addFiles;

	@FindBy(xpath = "//span[contains(text(),'Summary')]")
	private WebElement summ;

	@FindBy(xpath = "//select[@data-test-id='201802060658510010138182']")
	private WebElement gscCaseWorkBasket;

	@FindBy(xpath = "//span[@data-test-id='201802060658510010138182']")
	private WebElement greenFleetR4;

	@FindBy(xpath = "//span[contains(text(),'Workbasket')]")
	private WebElement workBasketHeader;

	@FindBy(xpath = "(//button[@data-test-id='201802011400580656111285'])[1]")
	private WebElement accept;

	@FindBy(xpath = "((//button[@data-test-id='20180201140326025511943'])[1]")
	private WebElement accNClose;

	@FindBy(xpath = "(//button[@data-test-id='20180201140326025613196'])[1]")
	private WebElement save;

	@FindBy(xpath = "(//button[@data-test-id='20180531073524008831831'])[1]")
	private WebElement withdraw;

	@FindBy(xpath = "//h2[contains(text(),'Audit')]")
	private WebElement audit;

	@FindBy(id = "CSC_Section")
	private static WebElement greenFleetIFrameAddCustomer;

	@FindBy(id = "PegaGadget0Ifr")
	private WebElement iFrameZero;

	@FindBy(xpath = "(//button[@data-test-id='201802081002310780562'])[1]")
	private WebElement cancel;

	@FindBy(xpath = "(//button[@data-test-id='20180201162439008710139'])[1]")
	private WebElement close;

	@FindBy(xpath = "//span[contains(text(),'Refresh')]")
	private WebElement refresh;

	@FindBy(xpath = "//span[contains(text(),'Work Case')]")
	private WebElement workCase;

	public static String ParentHandleGSC;
	protected WebDriver driver;

	public GSCCustomerSearch(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public boolean isHomePageDisplayed(String home) {

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return CommonFunctions.waitForElement(driver, homePageTab).getText().contains(home);
	}

	public boolean isGSCPageDisplayed(String cas) {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitAndSwitchToFrame(driver, iFrameHomePage);
		return CommonFunctions.waitForElement(driver, createCase).getText().contains(cas);

	}

	public boolean haCcustomerSearchModalHeaderDisplayed() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return CommonFunctions.isElementExist(driver, customerSearchModal);

	}

	public boolean isContactAndDealershipDisplayed() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, addContactDealership);
	}

	public boolean isProductInfo() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, productInfoButton);
	}

	public boolean hasPhoneDisplayed(String phon) {
		CommonFunctions.waitAndSwitchToFrame(driver, iFrameAddCustomer);
		return CommonFunctions.waitForElement(driver, phone).getText().contains(phon);
	}

	public boolean hasBusinessNameDisplayed(String business) {
		return CommonFunctions.waitForElement(driver, businessName).getText().contains(business);
	}

	public boolean hasLastNameDisplayed(String lname) {
		return CommonFunctions.waitForElement(driver, lastName).getText().contains(lname);
	}

	public boolean hasFirstNameDisplayed(String fname) {
		return CommonFunctions.waitForElement(driver, firstName).getText().contains(fname);
	}

	public boolean hasCountryDisplayed(String countri) {
		try {

			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, country).getText().contains(countri);
	}

	public boolean hasStateDisplayed(String sta) {
		try {

			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, state).getText().contains(sta);
	}

	public boolean hasCityDisplayed(String cit) {
		try {

			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, city).getText().contains(cit);
	}

	public boolean hasZipDisplayed(String zip) {
		try {

			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, postalCode).getText().contains(zip);
	}

	public boolean isCaseCodingDisplayed() {
		try {

			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, caseCoding);
	}

	public boolean isAddCustomerDisplayed() {
		try {

			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return CommonFunctions.isElementExist(driver, customerSearchHeader);
	}

	public boolean hasValidateAuditHistoryDetailsDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, auditHistory);
	}

	public GSCCustomerSearch clickOnGSCCase() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, createGSCCase).click();
		// CommonFunctions.switchToiFrameByIDOrName(driver, IframeHomepage);
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch enterBusiness(String business) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, businessNameField).sendKeys(business);
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch enterZip(String business) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, postal).sendKeys(business);
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch clickOnReset() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, reset).click();
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch clickOnAddCustomeInfoIcon() {

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForAlert(driver);
		CommonFunctions.waitForElement(driver, gscAddCustInfoButton).click();
		// CommonFunctions.waitAndSwitchToFrame(driver, iFrameAddCustomer);
		return new GSCCustomerSearch(driver);

	}

	public boolean isFirstNameDisplayed() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, customerFirstName);
	}

	public boolean isLastNameDisplayed() {
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

	public boolean hasStatusNewDisplayed() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, newStatus);
	}

	public boolean hasActionDisplayed() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, actionButton);
	}

	public GSCCustomerSearch enterCustomerFirstName(String custFirstName) {
		CommonFunctions.waitAndSwitchToFrame(driver, iFrameAddCustomer);
		try {

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, customerFirstName).sendKeys(custFirstName);
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch enterCustomerFirstNameValidation(String custFirstName) {
		try {
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, customerFirstName).sendKeys(custFirstName);
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch enterCustomerLastName(String custLastName) {
		CommonFunctions.waitForElement(driver, customerLastName).sendKeys(custLastName);
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch enterCityField(String city) {
		CommonFunctions.waitForElement(driver, cityField).sendKeys(city);
		return new GSCCustomerSearch(driver);
	}

	// method to select country
	public GSCCustomerSearch selectCountry(String country) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, customerCountry).sendKeys(country);
		return new GSCCustomerSearch(driver);

	}
	public GSCCustomerSearch selectCountrySwitchToFrame(String country) {
		CommonFunctions.waitAndSwitchToFrame(driver, iFrameAddCustomer);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, customerCountry).sendKeys(country);
		return new GSCCustomerSearch(driver);

	}

	public GSCCustomerSearch clickGscSearchCustomerBtn() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, gscAddCustInfoSearchCustomers).click();
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch clickGscSearchCustomerBtnAlrtVerfy() {
		CommonFunctions.waitAndSwitchToFrame(driver, iFrameAddCustomer);
		try {

			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, gscAddCustInfoSearchCustomers).click();
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch gscCustomerDetails() {
		try {

			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, customerDetails).click();
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch clickOnBackBtn() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, back).click();
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch clickChangeCustomerLink() {
		try {

			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, changeCustomer).click();
		return new GSCCustomerSearch(driver);
	}
	public GSCCustomerSearch clickCustomerClear() {
		try {

			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, clearCustomer).click();
		return new GSCCustomerSearch(driver);
	}
	
	

	public boolean hasSearchCustomerModalDisplayed(String headertext) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, searchCustomerModal).getText().contains(headertext);

	}

	public boolean hasClearCustomerLinkDisplayed() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, clearCustomer);
	}

	public GSCCustomerSearch clickSearchCustomerDetails() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, customerSearchDetails).click();
		return new GSCCustomerSearch(driver);
	}

	// click on Add product
	public GSCCustomerSearch clickOnAddProductInfo() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitAndSwitchToFrame(driver, iFrameZero);
		CommonFunctions.waitForElement(driver, gscAddProductInfoIcon).click();
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch clickOnAddProductInfoForAlrtVrfy() {
		CommonFunctions.waitForElement(driver, gscAddProductInfoIcon).click();
		return new GSCCustomerSearch(driver);
	}

	// enter product model
	public GSCCustomerSearch enterProductModel(String model) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, gscModel).sendKeys(model);
		return new GSCCustomerSearch(driver);
	}

	// click on product submit
	public GSCCustomerSearch clickAddProductSubmit() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, gscProductInformationSubitButton).click();
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch enterCasecodingFA(String fArea) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, caseCodingFunctionalArea).sendKeys(fArea);
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch enterCasecodingFC(String fCode) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, caseCodingFunctionalcode).sendKeys(fCode);
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch enterPriority(String priority) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, gscPriority).sendKeys(priority);
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch enterLanguage(String language) {
		CommonFunctions.waitForElement(driver, gscLanguage).sendKeys(language);
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch enterOrigin(String origin) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, gscOrigin).sendKeys(origin);
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch enterGreenFleetNumber(String number) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, greenFleetNumber).sendKeys(number);
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch enterAddSummary(String summary) {
		CommonFunctions.waitForElement(driver, gscAddSummary).sendKeys(summary);
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch clickOnCloseBtn() {
		CommonFunctions.waitForElement(driver, closeBtn).click();// button[@data-test-id='201802011400580656111285'])[1]
		return new GSCCustomerSearch(driver);
	}

	// click on Withdraw
	public GSCCustomerSearch clickOnWithdrawBtn() {
		CommonFunctions.waitForElement(driver, withdrawButton).click();
		return new GSCCustomerSearch(driver);
	}

	// File uploading and submit
	public GSCCustomerSearch enterFileAttachmentDetails() {
		CommonFunctions.waitForElement(driver, gscAttButton).click();
		CommonFunctions.waitForElement(driver, gscSelectButton).click();
		try {
			CommonFunctions.uploadFileUsingRobotClass(filePathImage);
		} catch (Throwable e) {

			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, gscFileAttachButton).click();
		return new GSCCustomerSearch(driver);
	}

	//////// AparajitaSelect//////
	public GSCCustomerSearch selectWorkBasket(String workbasket) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.selectFromDropdown(driver, workbasket, gscCaseWorkBasket);
		CommonFunctions.selectFromDropdown(driver, workbasket, gscCaseWorkBasket);
		CommonFunctions.selectFromDropdown(driver, workbasket, gscCaseWorkBasket);
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch selectWorkGroup(String workgroup) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, workSubGroup).sendKeys(workgroup);
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch clickOnAcceptBtn() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, acceptButton).click();
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch clickOnAcceptBtnAndSwitchToFrame() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitAndSwitchToFrame(driver, iFrameZero);
		CommonFunctions.waitForElement(driver, acceptButton).click();
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch switchToAlert() {
		CommonFunctions.waitForAlert(driver);
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch getDealerCase() {
		delarCaseID = CommonFunctions.waitForElement(driver, caseId).getText();
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch clickOnsubmit() {
		CommonFunctions.waitForElement(driver, submitButton).click();
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch clickOnName() {
		CommonFunctions.waitForElement(driver, name).click();
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch clickOnLogout() {
		CommonFunctions.waitForElement(driver, logout).click();
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch clickOnActionsBtn() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionButton).click();
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch clickOnActionsBtnWorkCaseBtn() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionButton).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Actions builder = new Actions(driver);
		builder.moveToElement(tss).perform();
		CommonFunctions.waitForElement(driver, workCase).click();

		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch clickOnReopenBtn() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, reopen).click();
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch gscTransferToIndividual() {
		CommonFunctions.waitForElement(driver, gscTransferIndividualButton).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch sendCaseMail() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, clickGSCSendCaseMailButton).click();
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch enterSendCaseMail(String mail) {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, clickGSCEmailEnterBox).sendKeys(mail);
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch sendButton() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, clickGSCSendButton).click();
		return new GSCCustomerSearch(driver);

	}

	public GSCCustomerSearch auditTrails() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.scrollToWebElement(driver, auditTrails);
		CommonFunctions.waitForElement(driver, auditTrails).click();
		CommonFunctions.scrollToWebElement(driver, auditHistory);
		CommonFunctions.isElementExist(driver, auditHistory);
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch alertVerification() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForAlert(driver);
		return new GSCCustomerSearch(driver);
	}

	public boolean routeNewStatus() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return CommonFunctions.isElementExist(driver, newStatus);

	}

	public boolean hasOwnedStatusDisplayed(String owned) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, statusOwned).getText().contains(owned);
	}

	public boolean hasCloseBtnDisplayed(String close) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, closeBtn).getText().contains(close);
	}

	public boolean hasSaveStatus() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, saveBtn);
	}

	public boolean hasCancelBtnDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, cancelBtn);
	}
	
	public boolean hasCancelBtnCustomerSearchDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, cancelBtnCustomerSearch);
	}

	public boolean hasResolveCompletedStatusDisplayed(String resolv) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, reolvedCompletedStatus).getText().contains(resolv);
	}

	public boolean hasReopenStatusDisplayed(String reopen) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, reopenStatus).getText().contains(reopen);
	}

	public boolean hasFileAttachedDisplayed(String msg) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		if (CommonFunctions.waitForElement(driver, fileAttached).getText().contains(msg)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasCorrespondanceAttachedDisplayed(String msg) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		if (CommonFunctions.waitForElement(driver, correspondanceAttached).getText().contains(msg)) {
			return true;
		} else {
			return false;
		}
	}

	public GSCCustomerSearch gscOperatortDropdown(String operator) {
		CommonFunctions.waitForElement(driver, gscTransferIndividualOperator).sendKeys(operator);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return new GSCCustomerSearch(driver);
	}

	// selected from transfer work basket drop down
	public GSCCustomerSearch gscTransferWorkbasket(String workbasket) {
		CommonFunctions.waitForElement(driver, gscTransferIndividualWorkbasket).sendKeys(workbasket);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch transferSubmitButton() {
		try {
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, gscTransferSubmit).click();
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch clickOnAction() {
		try {
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionButton).click();
		return new GSCCustomerSearch(driver);

	}

	public GSCCustomerSearch clickOnWorkCase() {
		try {
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, workcase).click();
		return new GSCCustomerSearch(driver);

	}

	public GSCCustomerSearch clickOnTransferCaseWorkbasket() {
		try {
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, transferCaseToWB).click();
		return new GSCCustomerSearch(driver);

	}

	public GSCCustomerSearch selectRoutingWorkBasket(String WB) {
		try {
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, selectWorkBasket).sendKeys(WB);
		return new GSCCustomerSearch(driver);

	}

	public GSCCustomerSearch clickOnTransfer() {
		try {
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, transferButton).click();
		return new GSCCustomerSearch(driver);
	}

	// click on cancel button.
	public GSCCustomerSearch clickCancelBtn() {
		CommonFunctions.waitForElement(driver, cancelButton).click();
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch clickOnSubmitWithdraw() {
		CommonFunctions.waitForElement(driver, withDrawSubmit).click();
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch clickonWithdrawAction() {
		CommonFunctions.waitForElement(driver, withdrawAction).click();
		return new GSCCustomerSearch(driver);
	}

	public boolean isOptionsRefreshDisplayed(String ref) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (CommonFunctions.waitForElement(driver, refresh).getText().contains(ref)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isOptionsWorkCaseDisplayed(String wc) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (CommonFunctions.waitForElement(driver, workcase).getText().contains(wc)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isOptionsPrintDisplayed(String prnt) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (CommonFunctions.waitForElement(driver, print).getText().contains(prnt)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasWithdrawStatusDisplayed() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, withdrawn);
	}

	public boolean hasNewDraftStatusDisplayed(String draft) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, newDraft).getText().contains(draft);
	}

	public boolean hasSaveBtnDisplayed(String save) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, saveBtn).getText().contains(save);

	}

	public boolean hasAcceptAndCloseBtnDisplayed() {
		return CommonFunctions.isElementExist(driver, acceptAndCloseBtn);

	}

	public boolean hasAcceptBtnDisplayed(String accept) {
		return CommonFunctions.waitForElement(driver, acceptButton).getText().contains(accept);

	}

	public GSCCustomerSearch enterCaseCodingFCReportonly(String fCode) {
		CommonFunctions.waitForElement(driver, caseCodingFunctionalcode).sendKeys(fCode);
		CommonFunctions.waitForElement(driver, caseCodingFunctionalcode).sendKeys(fCode);
		return new GSCCustomerSearch(driver);
	}

	// Get GSC WorkBasket value
	public GSCCustomerSearch getWorkBasketGSC() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitAndSwitchToFrame(driver, iFramePegaGadgetISGAssertion);
		WorkBasket = CommonFunctions.waitForElement(driver, gscWorkBasket).getText();
		return new GSCCustomerSearch(driver);
	}

	public boolean hasBusinessTextDisplayed(String busi) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, business).getText().contains(busi);

	}

	public boolean hasPhysicalTextDisplayed(String phy) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, physical).getText().contains(phy);

	}

	public boolean hasFirstnameDetailsDisplayed() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitAndSwitchToFrame(driver, iFrameZero);
		return CommonFunctions.isElementExist(driver, firstNameDetails);

	}

	public boolean hasLastnameDetailsDisplayed() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, lastNameDetails);

	}

	public boolean hasAddressDetailsDisplayed() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, addressDetails);

	}

	public boolean hasPhoneNumberDetailsDisplayed() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, phoneDetails);

	}

	public boolean hasEntityIDDetailsDisplayed() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, entityDetails);

	}

	public boolean hasMailingDisplayed(String mail) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, mailing).getText().contains(mail);

	}

	public boolean hasPhoneNumberDisplayed(String num) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, phone).getText().contains(num);
	}

	public boolean hasBackBtnDisplayed() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, back);

	}

	public boolean hasCreateCustomerDisplayed() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	//	CommonFunctions.scrollToWebElement(driver, createCustomer);
		CommonFunctions.switchToiFrameByWebElement(driver, iFrameZero);
		CommonFunctions.scrollToBottomOfPage(driver);
		return CommonFunctions.isElementExist(driver, createCustomer);

	}

	public boolean hasClearCustomerDisplayed() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, clearCustomer);

	}

	public boolean hasBusinessNumberDisplayed(String num) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		CommonFunctions.scrollToElement(driver, businessNumber);
		return CommonFunctions.waitForElement(driver, businessNumber).getText().contains(num);

	}

	public boolean hasCustomerInfoHeaderDisplayed(String cust) {
		return CommonFunctions.waitForElement(driver, customerInfo).getText().contains(cust);
	}

	public boolean hasConatctAndDealershipHeaderDisplayed(String contact) {
		return CommonFunctions.waitForElement(driver, contactDealesrShip).getText().contains(contact);
	}

	public boolean hasProductInfoHeaderDisplayed(String product) {
		return CommonFunctions.waitForElement(driver, productInfoButton).getText().contains(product);
	}

	public boolean hasCaseCodingHeaderDisplayed(String cc) {
		return CommonFunctions.waitForElement(driver, caseCoding).getText().contains(cc);
	}

	public boolean hasCaseInformationHeaderDisplayed(String ci) {
		return CommonFunctions.waitForElement(driver, caseInformation).getText().contains(ci);
	}

	public boolean hasRelatedCaseHeaderDisplayed(String relcas) {
		return CommonFunctions.waitForElement(driver, relatedCase).getText().contains(relcas);
	}

	public boolean hasProblemDetailsHeaderDisplayed(String probdet) {
		return CommonFunctions.waitForElement(driver, problemDetails).getText().contains(probdet);
	}

	public boolean hasSummaryHeaderDisplayed(String summary) {
		return CommonFunctions.waitForElement(driver, summ).getText().contains(summary);
	}

	public boolean hasWorkbasketHeaderDisplayed(String workbasketButton) {
		return CommonFunctions.isElementExist(driver, workBasketHeader);
	}

	public boolean hasAcceptBtnDisplayed() {
		return CommonFunctions.isElementExist(driver, accept);
	}

	public boolean hasAcceptandCloseBtnDisplayed() {
		return CommonFunctions.isElementExist(driver, acceptAndCloseBtn);
	}

	public boolean hasWithdrawBtnDisplayed() {
		return CommonFunctions.isElementExist(driver, withdraw);
	}

	public boolean hasAuditHistoryDisplayed(String aud) {
		return CommonFunctions.isElementExist(driver, audit);
	}

	public boolean hasSaveBtnDisplayed() {
		return CommonFunctions.isElementExist(driver, save);
	}

	public boolean hasWorkBasketDisplayed() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, gscWorkBasket);

	}

	// Click on Correspondence
	public GSCCustomerSearch clickOnCorrespondence() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, gscCorrespondence).click();
		ParentHandleGSC = driver.getWindowHandle();
		return new GSCCustomerSearch(driver);
	}

	public GSCCustomerSearch clickHomePageLink() {
		CommonFunctions.waitForElement(driver, homePageTab).click();
		return new GSCCustomerSearch(driver);

	}

	public GSCCustomerSearch clickonTSS() {
		CommonFunctions.waitForElement(driver, tss).click();
		return new GSCCustomerSearch(driver);
	}

	public ViewEmailZeacomPage clickOnMailZeacom() {
		CommonFunctions.waitForElement(driver, gscNewCaseMailLinkZeacom).click();
		return new ViewEmailZeacomPage(driver);
	}
	


}
