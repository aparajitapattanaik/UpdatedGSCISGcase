package com.deere.pages.greenfleet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.deere.global.CommonFunctions;
import com.deere.global.GlobalThings;
import com.deere.pages.gsccasecreation.GSCCustomerSearch;

public class GreenFleetCreationPage extends GlobalThings{

	@FindBy(xpath = "(//label[contains(text(),'Home')])[1]")
	private WebElement homePageTab;

	@FindBy(xpath = "//iframe[contains(@src,'SolutionSearchHome')]")
	private WebElement iFramePegaGadget;

	@FindBy(xpath = "//button[@data-test-id='20180201163908004467353']")
	private WebElement createGreenfleetCase;

	@FindBy(xpath = "(//i[@data-test-id='201512210438090148308293'])[1]")
	private WebElement greenFleetAddCustInfoButton;

	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement greenFleetFirstName;

	@FindBy(xpath = "//input[@id='lastName']")
	private WebElement greenFleetLastName;

	@FindBy(xpath = "//select[@id='country']")
	private WebElement customerCountry;

	@FindBy(xpath = "//input[@class='button btn btn-primary']")
	private WebElement greenFleetAddCustInfoSearchCustomers;

	@FindBy(xpath = "(//button[@class='buttonTdButton'])[2]")
	private WebElement searchCancel;

	@FindBy(xpath = "(//input[@class='button'])[1]")
	private WebElement resetBtn;

	@FindBy(xpath = "//span[@id='modaldialog_hd_title']")
	private WebElement greenFleetCustomerSearchHeader;

	@FindBy(xpath = "//table[@id='results']/tbody/tr[2]/td[2]/a")
	private WebElement customerSearchDetails;

	@FindBy(xpath = "//h2[@id='headerlabel1600']")
	private WebElement customerInformation;

	@FindBy(xpath = "(//span[@data-test-id='201802211054570002105727'])[1]")
	private WebElement firstNameText;

	@FindBy(xpath = "(//span[@data-test-id='201802211054570002105727'])[2]")
	private WebElement lastNameText;

	@FindBy(xpath = "//span[@data-test-id='201803021304180155104235']")
	private WebElement phoneNumber;

	@FindBy(xpath = "//span[@ data-test-id='20180221105250019383254']")
	private WebElement entityId;

	@FindBy(xpath = "(//i[@data-test-id='201512210438090148308293'])[2]")
	private WebElement greenFleetAddProductInfoIcon;

	@FindBy(xpath = "//input[@id='DecalModel']")
	private WebElement greenFleetModel;

	@FindBy(xpath = "//div[@class='pzbtn-rgt']/descendant::div[contains(text(),'Actions')]")
	private WebElement actionButton;

	@FindBy(xpath = "(//span[text()='r/JD Miscellaneous Equipment'])[2]")
	private WebElement greenFleetSelectedModel;

	@FindBy(xpath = "//button[@data-test-id='20140919030420037410647']")
	private WebElement greenFleetProductInformationSubitButton;
	
	@FindBy(xpath="(//button[@data-test-id='2018021409524402562359'])[1]")
    private WebElement submitBtn;
	
	@FindBy(xpath="//a[@data-test-id='20151006032155032173347']")
	private WebElement clearButton;

	@FindBy(xpath = "//input[@id='FUNC_AREA_NM']")
	private WebElement caseCodingFunctionalArea;

	@FindBy(xpath = "(//span[text()='CCE'])[1]")
	private WebElement selectCaseCodingFunctionalArea;

	@FindBy(xpath = "//input[@id='FUNC_CODE_NM']")
	private WebElement caseCodingFunctionalcode;

	@FindBy(xpath = "//span[text()='1602']")
	private WebElement selectCaseCodingFunctionalcode;

	@FindBy(xpath = "//select[@data-test-id='20180420090320013510319']")
	private WebElement greenFleetPriority;

	@FindBy(xpath = "//select[@id='LanguageWithCode']")
	private WebElement greenFleetLanguage;

	@FindBy(xpath = "//select[@id='Origin']")
	private WebElement greenFleetOrigin;

	@FindBy(xpath = "//input[@name='$PpyWorkPage$pCaseSummary']")
	private WebElement greenFleetAddSummary;

	@FindBy(xpath = "(//button[@data-test-id=\"2018021409524402562359\"])[1]")
	private WebElement greenFleetSubmitButton;

	@FindBy(xpath = "//div[@class='pzbtn-rgt']/descendant::div[contains(text(),'Actions')]")
	private WebElement clickOnActionButton;

	@FindBy(xpath = "//select[@id='WorkbasketName']")
	private WebElement workBasket;

	@FindBy(xpath = "(//i[@data-test-id='201512210438090148308293'])[1]")
	private WebElement customerInfoIcon;

	@FindBy(xpath = "(//div[@data-test-id='20151123025854066711391'])[1]")
	private WebElement addCustomerInfoHeader;

	@FindBy(xpath = "(//div[@data-test-id='20151123025854066711391'])[2]")
	private WebElement contactDealesrship;

	@FindBy(xpath = "(//h2[contains(text(),'Case Coding')])[2]")
	private WebElement caseCoding;

	@FindBy(xpath = "(//div[@data-test-id='20151123025854066711391'])[3]")
	private WebElement productInfo;
	
	@FindBy(xpath = "(//div[@data-test-id='20151123025854066711391'])[2]")
	private WebElement productInfoDealerUser;
	
	@FindBy(xpath = "//h2[contains(text(),'Case Information')]")
	private WebElement caseInformation;

	@FindBy(xpath = "//span[@class='iconRequired standard (label for field)_iconRequired']")
	private WebElement priority;

	@FindBy(xpath = "//label [@data-test-id='20180420090339039118414-Label']")
	private WebElement language;

	@FindBy(xpath = "//label [@data-test-id='20180420090417015835364-Label']")
	private WebElement greenFleetNumber;

	@FindBy(xpath = "//h2[contains(text(),'Related Case')]")
	private WebElement relatedCase;

	@FindBy(xpath = "//h2[contains(text(),'Problem Details')]")
	private WebElement problemDetails;

	@FindBy(xpath = "//div[@data-test-id='20151123094958005467694']")
	private WebElement addFiles;

	/*
	 * @FindBy(xpath="//span[@data-test-id='20150116110353086421138'])") private
	 * WebElement createGFCase;
	 */

	@FindBy(xpath = "//span[@data-test-id='20141009112850013116473']")
	private WebElement createGFCase;

	@FindBy(xpath = "//span[@data-test-id='20150116110353086421138']")
	private WebElement createGFCaseTCSMUser;

	@FindBy(xpath = "//span[contains(text(),'Summary')]")
	private WebElement summ;

	@FindBy(xpath = "//span[contains(text(),'Workbasket')]")
	private WebElement workBas;

	@FindBy(xpath = "//span[@data-test-id='201802060658510010138182']")
	private WebElement greenFleetR4;

	@FindBy(xpath = "(//button[@data-test-id='201802011400580656111285'])[1]")
	private WebElement accept;

	@FindBy(xpath = "(//i[@data-test-id='201512210438090148308293'])[2]")
	private WebElement productIcon;

	@FindBy(xpath = "(//button[contains(text(),'Accept And Close')])[1]")
	private WebElement accNClose;

	@FindBy(xpath = "(//button[@data-test-id='20180201140326025613196'])[1]")
	private WebElement save;

	@FindBy(xpath = "(//button[@data-test-id='2018021409524402562359'])[1]")
	private WebElement submit;

	@FindBy(xpath = "//*[@class='content-item content-field item-3 remove-top-spacing remove-bottom-spacing remove-left-spacing remove-right-spacing']")
	private WebElement owned;

	@FindBy(xpath = "(//button[@data-test-id='20180531073524008831831'])[1]")
	private WebElement withdraw;

	@FindBy(xpath = "//h2[contains(text(),'Audit')]")
	private WebElement audit;

	@FindBy(id = "PegaGadget0Ifr")
	private WebElement iFrameZero;

	@FindBy(id = "PegaGadget2Ifr")
	private WebElement iFrameGreenFleet;

	@FindBy(id = "PegaGadget1Ifr")
	private WebElement iFrameOne;

	@FindBy(id = "CSC_Section")
	private WebElement iFrameCustomerSearch;

	@FindBy(xpath = "(//button[@data-test-id='201802081002310780562'])[1]")
	private WebElement cancel;

	@FindBy(xpath = "(//button[@data-test-id='20180201162439008710139'])[1]")
	private WebElement close;

	@FindBy(xpath = "(//button[@data-test-id='20180201162439008710139'])[2]")
	private WebElement closeDown;

	@FindBy(xpath = "(//button[@data-test-id='20180201162439008710139'])[1]")
	private WebElement action;

	@FindBy(xpath = "(//button[@data-test-id='20180201162439008710139'])[1]")
	private WebElement workcase;

	@FindBy(xpath = "@//div[@class='content-item content-field item-3 remove-top-spacing remove-bottom-spacing remove-left-spacing remove-right-spacing']")
	private WebElement resolved;

	@FindBy(xpath = "//span[contains(text(),'Refresh')]")
	private WebElement refresh;

	@FindBy(xpath = "//span[contains(text(),'Transfer Case To WB')]")
	private WebElement transferWorkbasket;

	@FindBy(xpath = "//span[contains(text(),'Transfer Case To Individu...')]")
	private WebElement transferToIndividua;

	@FindBy(xpath = "//*[@class='content-item content-field item-3 remove-top-spacing remove-bottom-spacing remove-left-spacing remove-right-spacing']")
	private WebElement resolvedCompleted;

	@FindBy(xpath = "//span[contains(text(),'Send Case Email')]")
	private WebElement sendCaseEmail;

	@FindBy(xpath = "//span[contains(text(),'Print')]")
	private WebElement print;

	@FindBy(xpath = "//a[@data-test-id='2014100609491604327565']")
	private WebElement clickOnName;

	@FindBy(xpath = "	//span[contains(text(),'Log off')]")
	private WebElement clickOnLogout;

	@FindBy(xpath = "//span[@data-test-id='20141009112850013217103']")
	private WebElement caseId;
	
	@FindBy(xpath = "//label[contains(text(),'GSC-')]")
	private WebElement caseIdDealerCase; 

	@FindBy(xpath = "//td[contains(text(),'Zip/Postal Code:')]")
	private WebElement postalCode;

	@FindBy(xpath = "//input[@id='postalCode']")
	private WebElement postalCod;

	@FindBy(xpath = "//span[contains(text(),'Model')]")
	private WebElement modal;

	@FindBy(xpath = "//label[contains(text(),'Usage')]")
	private WebElement usage;

	@FindBy(xpath = "//label[contains(text(),'Units')]")
	private WebElement units;

	@FindBy(xpath = "//input[@id='PinNumber']")
	private WebElement pin;

	@FindBy(xpath = "//input[@id='PartNumber1']")
	private WebElement part;
	
	@FindBy(xpath = "//span[@id='PegaRULESErrorFlag']")
	private WebElement messageInvalidProduct;
	
	@FindBy(xpath = "//input[@id='ComponentSerialNumber1']")
	private WebElement component;

	@FindBy(xpath = "//input[@id='ComponentSerialNumber1']")
	private WebElement comment;

	@FindBy(xpath = "//h2[contains(text(),'Audit')]")
	private WebElement auditTrails;

	@FindBy(xpath = "//div[@data-test-id='201710031413550415704']")
	private WebElement auditHistory;

	protected WebDriver driver;

	public GreenFleetCreationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public boolean hasGreenFleetPageDisplayed(String gsc) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitAndSwitchToFrame(driver, iFrameZero);
		return CommonFunctions.waitForElement(driver, createGFCase).getText().contains(gsc);
	}

	public boolean hasGreenFleetPageDisplayedTCSMUser(String gsc) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// CommonFunctions.waitAndSwitchToFrame(driver, greenFleetIframeHomepage);
		CommonFunctions.waitAndSwitchToFrame(driver, iFrameZero);
		return CommonFunctions.waitForElement(driver, createGFCaseTCSMUser).getText().contains(gsc);
	}

	public boolean hasGreenFleetPageDisplayedDealerUser(String gsc) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitAndSwitchToFrame(driver, iFrameOne);
		return CommonFunctions.waitForElement(driver, createGFCase).getText().contains(gsc);
	}

	public boolean hasAddCustomerrInfoHeaderDisplayed(String cust) {
		return CommonFunctions.waitForElement(driver, addCustomerInfoHeader).getText().contains(cust);

	}

	public boolean hasConatctAndDealershipHeaderDisplayed(String cd) {
		return CommonFunctions.waitForElement(driver, contactDealesrship).getText().contains(cd);
	}

	public boolean hasProductInfoHeaderDisplayed(String pro) {
		return CommonFunctions.waitForElement(driver, productInfo).getText().contains(pro);
	}
	
	public boolean hasProductInfoHeaderDealerDisplayed(String pro) {
		return CommonFunctions.waitForElement(driver, productInfoDealerUser).getText().contains(pro);
	}
	
	public boolean hasCaseCodingHeaderDisplayed(String cc) {
		return CommonFunctions.waitForElement(driver, caseCoding).getText().contains(cc);
	}

	public boolean hasCaseInformationHeaderDisplayed(String ci) {
		return CommonFunctions.waitForElement(driver, caseInformation).getText().contains(ci);
	}

	public boolean hasPriorityHeadDisplayed(String pri) {
		return CommonFunctions.waitForElement(driver, priority).getText().contains(pri);
	}

	public boolean hasLanguageHeaderDisplayed(String lang) {
		return CommonFunctions.waitForElement(driver, language).getText().contains(lang);
	}

	public boolean hasGrnFltHeaderDisplayed(String number) {
		return CommonFunctions.waitForElement(driver, greenFleetNumber).getText().contains(number);
	}

	public boolean hasRelatedCaseHeaderDisplayed(String relat) {
		return CommonFunctions.waitForElement(driver, relatedCase).getText().contains(relat);
	}

	public boolean hasProblemDetailsHeaderDisplayed(String prob) {
		return CommonFunctions.waitForElement(driver, problemDetails).getText().contains(prob);
	}

	public boolean hasSaveBtnDisplayed() {
		return CommonFunctions.isElementExist(driver, save);
	}

	public boolean hasSubmitBtnDisplayed() {
		return CommonFunctions.isElementExist(driver, submit);
	}

	public boolean hasWithdrawBtnDisplayed() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, withdraw);
	}
	
	public boolean hasAuditHistoryDisplayed() {
		return CommonFunctions.isElementExist(driver, audit);
	}
	public boolean hasSummaryHeaderDisplayed(String sum) {
		return CommonFunctions.waitForElement(driver, summ).getText().contains(sum);
	}

	public boolean hasWorkbasketHeaderDisplayed(String wb) {
		return CommonFunctions.waitForElement(driver, workBas).getText().contains(wb);
	}

	public boolean hasGreenFleetR4HeaderDisplayed(String gf) {
		return CommonFunctions.waitForElement(driver, greenFleetR4).getText().contains(gf);
	}

	public boolean hasCommentsHeaderDisplayed(String comm) {
		return CommonFunctions.waitForElement(driver, comment).getText().contains(comm);
	}

	public GreenFleetCreationPage getDealerCase() {
		CommonFunctions.switchToDefaultFrame(driver);
		caseIDGF=CommonFunctions.waitForElement(driver, caseIdDealerCase).getText();
		return new GreenFleetCreationPage(driver);
	}

	public boolean hasCaseIDDisplayed() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, caseId);
	}

	public GreenFleetCreationPage clickOnName() {
		CommonFunctions.waitForElement(driver, clickOnName).click();
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage clickOnLogout() {
		CommonFunctions.waitForElement(driver, clickOnLogout).click();
		return new GreenFleetCreationPage(driver);
	}

	public boolean hasAcceptBtnDisplayed() {
		return CommonFunctions.isElementExist(driver, accept);
	}

	public boolean hasAcceptandCloseBtnDisplayed() {
		return CommonFunctions.isElementExist(driver, accNClose);
	}

	public boolean hasCloseBtnDisplayed() {
		return CommonFunctions.isElementExist(driver, close);
	}

	public boolean hasResolvedCompletedDisplayed(String resolv) {
		return CommonFunctions.isElementExist(driver, resolved);
	}

	public boolean hasCancelBtnDisplayed() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, cancel);
	}

	public boolean hasRefreshOptionDisplayed(String ref) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, refresh).getText().contains(ref);
	}

	public boolean hasWorkBasketOptionDisplayed(String wb) {
		return CommonFunctions.waitForElement(driver, transferWorkbasket).getText().contains(wb);
	}

	public boolean hasTransferIndividualOptionDisplayed(String ti) {
		return CommonFunctions.waitForElement(driver, transferToIndividua).getText().contains(ti);
	}

	public boolean hasResolvedCompletedStatusDisplayed(String ti) {
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, resolvedCompleted).getText().contains(ti);
	}

	public boolean hasSendCaseEmailOptionDisplayed(String mail) {
		return CommonFunctions.waitForElement(driver, sendCaseEmail).getText().contains(mail);
	}

	public boolean hasPrintOptionDisplayed(String prn) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, print).getText().contains(prn);
	}

	public boolean hasOwnedDisplayed(String own) {
		return CommonFunctions.isElementExist(driver, owned);
	}

	public boolean hasAuditTextDisplayed() {
		return CommonFunctions.isElementExist(driver, audit);
	}

	public boolean hasComponentSerialNumberDisplayed() {
		return CommonFunctions.isElementExist(driver, audit);
	}

	public boolean hasOwnedStatusDisplayed() {
		return CommonFunctions.isElementExist(driver, owned);
	}

	public boolean hasResolvedCompletedDisplayed() {
		return CommonFunctions.isElementExist(driver, resolved);
	}

	public boolean addFiles() {
		return CommonFunctions.isElementExist(driver, addFiles);
	}

	public GreenFleetCreationPage clickOnGreenFleetCase() {
		CommonFunctions.waitForElement(driver, createGreenfleetCase).click();
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage clickGreenFleetAddCustomeInfo() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// CommonFunctions.switchToiFrameByWebElement(driver, iFrameCustomerSearch);
		CommonFunctions.waitForElement(driver, greenFleetAddCustInfoButton).click();
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage clickOnAccept() {
		CommonFunctions.waitForElement(driver, accept).click();
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage clkAcceptButton() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, accept).click();
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage clkCloseButton() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, close).click();
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage clkAcceptButtonForAlertVrfy() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitAndSwitchToFrame(driver, iFrameZero);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, accept).click();
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage clkSubmitButton() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, submit).click();
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage clickAddProductInfo() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, productIcon).click();
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage switchToAlert() {
		CommonFunctions.waitForAlert(driver);
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage enterGreenFleetCustomerFirstName(String firstName) {
		CommonFunctions.waitAndSwitchToFrame(driver, iFrameCustomerSearch);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, greenFleetFirstName).sendKeys(firstName);
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage enterGreenFleetCustomerFirstNameForAlert(String firstName) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, greenFleetFirstName).sendKeys(firstName);
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage auditTrails() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.scrollToWebElement(driver, auditTrails);
		CommonFunctions.waitForElement(driver, auditTrails).click();
		CommonFunctions.scrollToWebElement(driver, auditHistory);
		CommonFunctions.isElementExist(driver, auditHistory);
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage enterGreenFleetCustomerLastName(String lastName) {
		CommonFunctions.waitForElement(driver, greenFleetLastName).sendKeys(lastName);
		return new GreenFleetCreationPage(driver);
	}

	public boolean addCustomerDisplayed() {
		try {
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, greenFleetCustomerSearchHeader);
	}

	public GreenFleetCreationPage enterGreenFleetselectCountry(String Country) {
		CommonFunctions.waitForElement(driver, customerCountry).sendKeys(Country);
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage greenFleetSearchCustomer() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// CommonFunctions.switchToiFrameByWebElement(driver, iFrameCustomerSearch);
		CommonFunctions.waitForElement(driver, greenFleetAddCustInfoSearchCustomers).click();
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage grnFltClkSearchCustomerForAltVerfy() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.switchToiFrameByWebElement(driver, iFrameCustomerSearch);
		CommonFunctions.waitForElement(driver, greenFleetAddCustInfoSearchCustomers).click();
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage clkOnSearchCustomer() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, greenFleetAddCustInfoSearchCustomers).click();
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage clickOnCancel() {

		CommonFunctions.waitForElement(driver, searchCancel).click();
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage clickOnReset() {

		CommonFunctions.waitForElement(driver, resetBtn).click();
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage enterPostalCode(String code) {
		CommonFunctions.waitForElement(driver, postalCode).sendKeys(code);
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage enterPostalCod(String code) {
		CommonFunctions.waitForElement(driver, postalCod).sendKeys(code);
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage greenFleetSearchCustomerDetails() {
		try {

			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, customerSearchDetails).click();
		return new GreenFleetCreationPage(driver);
	}

	public boolean hasModalProductTextDisplayed() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, modal);
	}

	public boolean hasUsageProductTextDisplayed() {
		return CommonFunctions.isElementExist(driver, usage);
	}

	public boolean hasUnitsProductTextDisplayed() {
		return CommonFunctions.isElementExist(driver, units);
	}

	public boolean hasPinProductTextDisplayed() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, pin);
	}

	public boolean hasPartNumberProductTextDisplayed() {
		return CommonFunctions.isElementExist(driver, part);
	}
	
	public boolean hasMessageForInavlidProductDisplayed() {
		return CommonFunctions.isElementExist(driver, part);
	}

	
	public boolean hasComponentSerialNumberDisplayed(String num) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, component).getText().contains(num);
	}

	public GreenFleetCreationPage greenFleetClickonAddProductInfo() {
		CommonFunctions.waitAndSwitchToFrame(driver, iFrameZero);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CommonFunctions.waitForElement(driver, greenFleetAddProductInfoIcon).click();
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage greenFleetClickonAddProductInfoForDealer() {
		CommonFunctions.waitAndSwitchToFrame(driver, iFrameOne);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CommonFunctions.waitForElement(driver, greenFleetAddProductInfoIcon).click();
		return new GreenFleetCreationPage(driver);
	}
	public GreenFleetCreationPage greenFleetEnterProductModel(String model) {
		CommonFunctions.waitForElement(driver, greenFleetModel).clear();
		CommonFunctions.waitForElement(driver, greenFleetModel).sendKeys(model);
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage greenFleetEnterInvalidModel(String cha) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, greenFleetModel).sendKeys(cha);
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage greenFleetClickAddProductSubmit() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, greenFleetProductInformationSubitButton).click();
		return new GreenFleetCreationPage(driver);
	}
	
	public GreenFleetCreationPage clickOnSubmitBtn() {
		CommonFunctions.waitForElement(driver, submitBtn).click();
		return new GreenFleetCreationPage(driver);
	}
	
	
	
	public GreenFleetCreationPage clkOnClearButton() {
		CommonFunctions.waitForElement(driver, clearButton).click();
		return new GreenFleetCreationPage(driver);
	}
	
	

	public static void switchToiFrameByID(WebDriver driver, String id) {
		driver.switchTo().frame(id);
	}

	public static void switchToDefaultFrame(WebDriver driver, String id) {
		driver.switchTo().frame(id);
	}

	public boolean firstnameDisplayed() {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, greenFleetFirstName);
	}

	public boolean lastnameDisplayed() {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, greenFleetLastName);
	}

	public boolean hasCustomeInfoDisplayed() {
		try {
			Thread.sleep(1000);
			driver.switchTo().parentFrame();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, greenFleetAddProductInfoIcon);
	}

	public boolean hasFirstNameDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, firstNameText);
	}

	public GreenFleetCreationPage enterCustomerFirstName(String custFirstName) {
		CommonFunctions.waitForElement(driver, greenFleetFirstName).sendKeys(custFirstName);
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage enterCustomerLastName(String custLastName) {
		CommonFunctions.waitForElement(driver, greenFleetLastName).sendKeys(custLastName);
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage selectCountry(String country) {
		CommonFunctions.waitForElement(driver, customerCountry).sendKeys(country);
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage gscSearchCustomer() {
		CommonFunctions.waitForElement(driver, greenFleetAddCustInfoSearchCustomers).click();
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage gscSearchCustomerDetails() {
		CommonFunctions.waitForElement(driver, customerSearchDetails).click();
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage greenFleetEnterCasecodingFA(String fArea) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, caseCodingFunctionalArea).sendKeys(fArea);
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage greenFleetCasecodingFC(String fCode) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, caseCodingFunctionalcode).sendKeys(fCode);
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage greenFleetEnterPriority(String priority) {
		CommonFunctions.waitForElement(driver, greenFleetPriority).sendKeys(priority);
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage clickAction() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionButton).click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage clickOnCloseButton() {
		CommonFunctions.waitForElement(driver, closeDown).click();
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage greenFleetenterLanguage(String language) {
		CommonFunctions.waitForElement(driver, greenFleetPriority).sendKeys(language);
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage greenFleetenterOrigin(String origin) {
		CommonFunctions.waitForElement(driver, greenFleetPriority).sendKeys(origin);
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage greenFleetEnterAddSummary(String summary) {
		CommonFunctions.waitForElement(driver, greenFleetAddSummary).sendKeys(summary);
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage greenFleetSubmitButton() {
		CommonFunctions.waitForElement(driver, greenFleetSubmitButton).click();
		return new GreenFleetCreationPage(driver);
	}

	public GreenFleetCreationPage clickOnGreenFleetAction() {
		CommonFunctions.waitForElement(driver, clickOnActionButton).click();
		return new GreenFleetCreationPage(driver);
	}

}
