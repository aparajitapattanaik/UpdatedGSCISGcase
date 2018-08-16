package com.deere.pages.isgcasecreation;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;
import com.deere.global.GlobalThings;
import com.deere.pages.OwnedCasePage;
import com.deere.pages.gmailverification.SendCaseEmail;
import com.deere.pages.gsccasecreation.GSCCustomerSearch;
import com.deere.pages.gsccasecreation.GSCRoutingPage;
import com.deere.pages.gsccasecreation.ViewEmailZeacomPage;
import com.deere.pages.solutionsearch.SolutionSearchHomePage;
import com.deere.pages.workbasketqueue.WorkGroupQueuePage;

public class ISGCasePage extends GlobalThings {

	@FindBy(xpath = "//button[@data-test-id='2014100911285001362285']")
	private WebElement clickActionButton;

	@FindBy(xpath = "//ul[@id='pyNavigation1528360059917']")
	private WebElement actionFrame;

	@FindBy(xpath = "//ul[@id='pyNavigation1528360059917']/li[2]")
	private WebElement actionWorkCase;

	@FindBy(xpath = "//*[@data-test-id='201802011400580656111285']")
	private WebElement acceptButton;

	@FindBy(xpath = "(//button[@data-test-id='20170614162426000640819'])[1]")
	private WebElement searchBtn;

	@FindBy(xpath = "//*[@class='menu menu-format-standard menu-regular']/li[2]")
	private WebElement isgTransferWB;

	@FindBy(xpath = "//span[contains(text(),'Send Case Email')]")
	private WebElement sendCaseEmail;

	@FindBy(xpath = "//tr[@id='$PD_ListWorkbasketInformationWithGSC$ppxResults$l1']")
	private WebElement newWorkBasketDropDown;

	@FindBy(xpath = "(//button[@data-test-id='20180419123512080115230'])[1]")
	private WebElement isgTransfer_Button;

	@FindBy(xpath = "//span[contains(text(),'Refresh')]")
	private WebElement refresh;

	@FindBy(xpath = "//input[@data-test-id='20180223145844071532513']")
	private WebElement isgCustomer_LastName;

	@FindBy(xpath = "//label[contains(text(),'Correspondence')]")
	private WebElement gscCorrespondence;

	@FindBy(xpath = "//table[@id='RULE_KEY'][@aria-label='Solution Search']")
	private WebElement soluSearch;

	@FindBy(xpath = "(//a[@class='Case_tools'])[2]")
	private WebElement gscNewCaseMailLink;

	@FindBy(xpath = "//div[@class='pzbtn-rgt']/descendant::div[contains(text(),'Actions')]")
	private WebElement workCaseInActions;

	@FindBy(xpath = "//div[@class='content-item content-field item-3 remove-top-spacing remove-bottom-spacing remove-left-spacing remove-right-spacing']")
	private WebElement resolvedCompleted;

	@FindBy(xpath = "(//a[starts-with(@title,'New Deere.com Case')])[1]")
	private WebElement gscNewCaseMailLinkZeacom;

	@FindBy(xpath = "//span[contains(text(),'Send Case Email')]")
	private WebElement clickGSCSendCaseMailButton;

	@FindBy(xpath = " //input[@class='customIntegerInput']")
	private WebElement solutionIdBox;

	@FindBy(xpath = "//span[@data-test-id='201708302308570779178839']")
	private WebElement solutionSuccessMsg;

	@FindBy(xpath = "//img[@src='webwb/jdsearch_11621810146.png!!.png']")
	private WebElement solutionIdSearchImg;

	@FindBy(xpath = " //span[contains(text(),'US')]")
	private WebElement isgCustCountryCodeAutoOption;

	@FindBy(xpath = "//div[@class='pzbtn-rgt']/descendant::div[contains(text(),'Actions')]")
	private WebElement isgActions;

	@FindBy(xpath = "//span[contains(text(),'Transfer Case To WB')]")
	private WebElement transferWorkBasket;

	@FindBy(xpath = "//span[contains(text(),'Transfer Case To Individu...')]")
	private WebElement isgTransferIndividualButton;

	@FindBy(xpath = "//input[@data-test-id='20170915163723049610155']")
	private WebElement isgTransferIndividualOperator;

	@FindBy(xpath = "//input[@data-test-id='2015031809055206723480']")
	private WebElement isgTransferIndividualWorkbasket;

	@FindBy(xpath = "//button[@data-test-id='20140919030420037410647']")
	private WebElement isgTransferSubmit;

	@FindBy(xpath = "//h2[contains(text(),'Audit')]")
	private WebElement auditTrails;

	@FindBy(xpath = "(//label[@data-stl='1'])[8]")
	private WebElement highlightClose;

	@FindBy(xpath = "//span[@id='close']")
	private WebElement caseclose;

	@FindBy(xpath = "(//div[@class='pzbtn-mid'])[1])")
	private WebElement discard;

	@FindBy(xpath = "//div[@class='pzbtn-rgt']/descendant::div[contains(text(),'Actions')]")
	private WebElement actionButton;

	@FindBy(xpath = "(//div[@data-test-id='20151123025854066711391'])[1]")
	private WebElement customerInfo;

	@FindBy(xpath = "//div[contains(text(),'Add Contact & Dealership Info')]")
	private WebElement contactDealesrship;

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

	@FindBy(xpath = "//span[contains(text(),'Summary')]")
	private WebElement summ;

	@FindBy(xpath = "//input[@data-test-id='2018021510105906303661'or @data-test-id='201710100918100500726859']")
	private WebElement workBasket;

	@FindBy(xpath = "(//button[@data-test-id='201802011400580656111285'])[1]")
	private WebElement accept;

	@FindBy(xpath = "(//button[@data-test-id='20180201140326025511943'])[1]")
	private WebElement acceptAndClose;

	@FindBy(xpath = "//iframe[@name='PegaGadget1Ifr']")
	private WebElement frame;

	@FindBy(xpath = "(//button[@data-test-id=\"20170614162426000639748\"])[1]")
	private WebElement clearBtn;

	@FindBy(xpath = "(//button[contains(text(),'Withdraw')])[1]")
	private WebElement withdraw;

	@FindBy(xpath = "//div[@class='content-item content-field item-3 remove-top-spacing remove-bottom-spacing remove-left-spacing remove-right-spacing' ]")
	private WebElement newDraft;

	@FindBy(xpath = "//h2[contains(text(),'Audit')]")
	private WebElement audit;

	@FindBy(xpath = "(//div[@data-test-id='20151123025854066711391'])[3]")
	private WebElement productInfoButton;

	@FindBy(xpath = "(//h2[contains(text(),'Case Coding')])[2]")
	private WebElement caseCoding;

	@FindBy(xpath = "//span[@data-test-id='20151102025927043277266'][@class='jd_h3_text']")
	private WebElement isgProductValueAssertion;

	@FindBy(xpath = "(//span[@data-test-id='201802211054570002105727'])[1]")
	private WebElement isgCustomerFirstName;

	@FindBy(xpath = "(//span[@data-test-id='201802211054570002105727'])[2]")
	private WebElement isgCustomerLastName;

	@FindBy(xpath = "//span[@data-test-id='201803021304180157105844']")
	private WebElement isgCustomerPhoneNumber;

	@FindBy(xpath = "//span[@data-test-id='20180221105250019383254']")
	private WebElement isgEntityId;

	@FindBy(xpath = "//span[@data-test-id='20180221105140017779602']")
	private WebElement isgEmailAddress;

	@FindBy(xpath = "//span[@data-test-id='2018042413580400821689']")
	private WebElement isgWorkBasket;

	@FindBy(xpath = "//div[@class=' content layout-content-portal_header_group_primary  content-portal_header_group_primary clearfix']")
	private WebElement isgPSC_ErrorMsg;

	@FindBy(xpath = "//div[@class='content-item content-field item-3 remove-top-spacing remove-bottom-spacing remove-left-spacing remove-right-spacing' ]")
	private WebElement newStatus;

	@FindBy(xpath = "(//img[@src='webwb/pzediticon_13962397645.png!!.png'])")
	private WebElement isgCustomer_Clear;

	@FindBy(xpath = "(//div[@class='content-item content-field item-3 remove-top-spacing remove-bottom-spacing remove-left-spacing remove-right-spacing'])[1]")
	private WebElement isg_Status;

	@FindBy(xpath = "//iframe[contains(@src,'SolutionSearchHome')]")
	private WebElement framePegaGadget;

	@FindBy(xpath = "//input[@id='SolutionSummary'][contains(@name,'SolutionSummary')]")
	private WebElement searchTextBox;

	@FindBy(xpath = "//div[text()='Actions ']")
	private WebElement actionBtn;

	@FindBy(xpath = "//input[@id='CategoryString'][@title='Search Category']")
	private WebElement categoryTxtBox;

	@FindBy(xpath = "//table[@id='bodyTbl_right']//tbody//div[@class='oflowDiv']//div[@class='cellIn']/span")
	private List<WebElement> categoryAutoOptions;

	@FindBy(xpath = "//input[@id='SubCategoryString'][@title='Search Sub-Category']")
	private WebElement subCategoryTxtBox;

	@FindBy(xpath = "//table[@id='bodyTbl_right']//tr[contains(@id,'$PD_DTACSubCategory')]//div[@class='cellIn']/span")
	private List<WebElement> subCategoryAutoOptions;

	@FindBy(xpath = "//input[@id='SearchDecalModel']")
	private WebElement decalModelTxtBox;

	@FindBy(xpath = "//table[@id='bodyTbl_right']/tbody/tr//td/div[@class='oflowDiv']//span[@class='match-highlight']")
	private WebElement autoOptions;

	@FindBy(xpath = "//input[@id='ModelString'][@title='Select Decal Model']")
	private WebElement modelTxtBox;

	@FindBy(xpath = "//table[@id='bodyTbl_right']/tbody//div[@class='oflowDiv']//span[@class='match-highlight']")
	private WebElement modelAutoOptions;

	@FindBy(xpath = "//span[@data-test-id='20180424084340049412218']")
	private WebElement gscWorkBasket;
	
	@FindBy(xpath = "//iframe[@name='PegaGadget1Ifr']")
	private WebElement iFrame1;

	@FindBy(xpath = "//iframe[@id='PegaGadget0Ifr']")
	private WebElement iframePegaGadgetISG;

	@FindBy(xpath = "//iframe[@id='PegaGadget1Ifr']")
	private WebElement iframePegaGadgetISG_Assertion;

	@FindBy(xpath = "//iframe[@id='PegaGadget3Ifr']")
	private WebElement iframe_Case_Form_Assertion;

	@FindBy(xpath = "(//i[@data-test-id='201512210438090148308293'])[1]")
	private WebElement addCustomerInfoLink;

	@FindBy(xpath = "//div[@id='cke_1_contents']/iframe")
	private WebElement iframe;

	@FindBy(xpath = "//*[@id='CustomerSearchCountryCode']")
	private WebElement isgCustomer_CountryCode;

	@FindBy(xpath = "//*[@id='SearchContactFirstName']")
	private WebElement isgCustomer_FirstName;

	@FindBy(xpath = "(//button[@data-test-id='201802081002310780562'])[1]")
	private WebElement cancel;

	@FindBy(xpath = "(//button[@data-test-id='20180201162439008710139'])[2]")
	private WebElement close;

	@FindBy(xpath = "//button[@data-test-id='20140919030420037410647']")
	private WebElement isgProduct_Submit;

	@FindBy(xpath = "(//button[@data-test-id='20180419123512080115230'])[1]")
	private WebElement transferButton;

	@FindBy(xpath = "//*[@id='DefaultAG']")
	private WebElement isgCustomer_RadioButton;

	@FindBy(xpath = "//*[@data-test-id='20180222111133075630347']")
	private WebElement isgCustomer_SearchButton;

	@FindBy(xpath = "//button[@id='ModalButtonSubmit']")
	private WebElement isgCustomer_SubmitButton;

	@FindBy(xpath = "(//span[@data-test-id=\"201802211054570002105727\"])[1]")
	private WebElement isgCustomer_MainPage_FirstName;

	@FindBy(xpath = "(//*[@data-test-id='201512210438090148308293'])[2]")
	private WebElement isgAddProductInfo;

	@FindBy(xpath = "//input[@data-test-id='2015100603215503417556']")
	private WebElement isgProduct_Model;

	@FindBy(xpath = "//span[@data-test-id='20151102025927043277266']")
	private WebElement isgProduct_MainPage_Model;

	@FindBy(id = "FUNC_AREA_NM")
	private WebElement isgFunctionalArea;

	@FindBy(xpath = "//input[@id='FUNC_CODE_NM']")
	private WebElement isgFunctionalCode;

	@FindBy(xpath = "//span[text()='1602']")
	private WebElement isgFunctionalCode_Select;

	@FindBy(xpath = "(//span[text()=\"Ag\"])[1]")
	private WebElement isg_TWB_WB;

	@FindBy(xpath = "//div[@class=' content layout-content-portal_header_group_primary  content-portal_header_group_primary clearfix']")
	private WebElement isgPsc_errormsg;

	@FindBy(xpath = "(//img[@src='webwb/pzediticon_13962397645.png!!.png'])")
	private WebElement isgCustomer_clear;

	@FindBy(xpath = "//div[@class='pzbtn-rgt']/descendant::div[contains(text(),'Actions')]")
	private WebElement isgAction_Button;

	@FindBy(xpath = "//span[contains(text(),'Work Case')]")
	private WebElement workCase;

	@FindBy(xpath = "(//button[contains(text(),'Cancel')])[1]")
	private WebElement cancelButton;

	@FindBy(xpath = "//input[@id='WBName']")
	private WebElement newWorkBasket;

	@FindBy(xpath = "(//button[@data-test-id='20180201140326025613196'])[1]")
	private WebElement saveBtn;

	@FindBy(xpath = "//input[@data-test-id='2015100603215503417556']")
	private WebElement productInfoModelDD;

	@FindBy(xpath = "//h2[contains(text(),'Product')]")
	private WebElement prodHeading;

	@FindBy(xpath = "//tr[@id='$PD_ListWorkbasketInformationWithGSC$ppxResults$l1']")
	private WebElement newWorkBasketdropdown;

	@FindBy(xpath = "//span[contains(text(),'Transfer Case To WB')]")
	private WebElement transfer_Case_To_WB;

	@FindBy(xpath = "//span[contains(text(),'Transfer Case To Individu...')]")
	private WebElement transfer_Case_To_Individu;

	@FindBy(xpath = "//span[contains(text(),'Send Case Email')]")
	private WebElement send_Case_Email;

	@FindBy(xpath = "//div[@class='content-item content-field item-3 remove-top-spacing remove-bottom-spacing remove-left-spacing remove-right-spacing']")
	private WebElement statusAsNew;

	@FindBy(xpath = "//span[@data-test-id='2018042408424805539718']")
	private WebElement summary;

	@FindBy(xpath = "//span[@data-test-id='20180420090320013510319']")
	private WebElement priority;

	@FindBy(xpath = "//span[@data-test-id='2018042009040902873074']")
	private WebElement origin;

	@FindBy(xpath = "(//span[@data-test-id='20180420090320013510319'])|(//span[@data-test-id='20160208091722005978870'])")
	private WebElement priorityText;

	@FindBy(xpath = "//span[@data-test-id='20160208091722005978870']")
	private WebElement languageText;

	@FindBy(xpath = "(//span[@data-test-id='20180420090350031226135'])|(//span[@data-test-id='20180424140140011822773'])")
	private WebElement originText;

	@FindBy(xpath = "//div[contains(text(),'     Owned   ')]")
	private WebElement ownStatus;

	@FindBy(xpath = "(//button[@data-test-id='201802011400580656111285'])[1]")
	private WebElement acceptBtn;

	@FindBy(xpath = "(//button[@data-test-id='201802081002310780562'])[1]")
	private WebElement cancelBtn;

	@FindBy(xpath = "//span[@id='modaldialog_hd_title']")
	private WebElement isgCustomer_MainPage_Customerinfo;

	@FindBy(xpath = "//span[@id='modaldialog_hd_title']")
	private WebElement isgCustomer_Title;

	@FindBy(xpath = "//iframe[@id='PegaGadget1Ifr']")
	private WebElement iFramePegaGadgetISG_Assertion;

	@FindBy(id = "CasePriority")
	private WebElement isgCase_Priority;

	@FindBy(xpath = "//select[@data-test-id='20180424140126019614930']")
	private WebElement languDD;

	@FindBy(id = "LanguageWithCode")
	private WebElement isgCaselanguagecode;

	@FindBy(xpath = "//span[contains(text(),'Print')]")
	private WebElement print;

	@FindBy(xpath = "//div[@class='content-item content-field item-3 remove-top-spacing remove-bottom-spacing remove-left-spacing remove-right-spacing']")
	private WebElement owned;

	@FindBy(id = "Origin")
	private WebElement isgCase_Origin;

	@FindBy(xpath = "//*[@name='$PpyWorkPage$pCaseSummary']")
	private WebElement isgSummary;

	@FindBy(xpath = "(//button[@data-test-id='201802011400580656111285'])[1]")
	private WebElement isgAccept_Button;

	@FindBy(xpath = "//input[@data-test-id='201605271221250444446791']")
	private WebElement transferWorkbasket;

	@FindBy(xpath = "(//*[@data-test-id=\"201802011400580656112342\"])[1]")
	private WebElement isgRoute_Button;

	@FindBy(xpath = "(//*[@data-test-id=\"20180201162439008710139\"])[2]")
	private WebElement isgClose_Button;

	@FindBy(xpath = "(//div[@class='content-item content-field item-3 remove-top-spacing remove-bottom-spacing remove-left-spacing remove-right-spacing'])[1]")
	private WebElement statusOwned;

	@FindBy(xpath = "//span[contains(text(),'Transfer Case To WB')]")
	private WebElement transferCaseToWB;

	@FindBy(xpath = "//span[contains(text(),'Transfer Case To Individu...')]")
	private WebElement transferCaseToIndividu;

	@FindBy(xpath = "//li[@class='menu-item menu-item-enabled']//span[contains(text(),'Reopen')]")
	private WebElement reopen;

	@FindBy(xpath = "//div[@class='content-item content-field item-3 remove-top-spacing remove-bottom-spacing remove-left-spacing remove-right-spacing']")
	private WebElement reopenStatus;

	@FindBy(xpath = "//span[contains(text(),'TSS Reopen: ')]")
	private WebElement tss;

	@FindBy(xpath = "(//div[@class='field-item dataValueRead'])[2]")
	private WebElement resolved;

	@FindBy(xpath = "//label[@data-test-id='2015100603215503417556-Label']")
	private WebElement modelHeader;

	@FindBy(xpath = "//label[@data-test-id='2016041507482102291263-Label']")
	private WebElement usageHeader;

	@FindBy(xpath = "//label[@data-test-id='2016041507482102301328-Label']")
	private WebElement unitsHeader;

	@FindBy(xpath = "//th[@data-attribute-name='PIN']")
	private WebElement pinHeader;

	@FindBy(xpath = "//th[@data-attribute-name='Part Number']")
	private WebElement partNumHeader;

	@FindBy(xpath = "//th[@data-attribute-name='Component Serial Number']")
	private WebElement componentSerialHeader;

	@FindBy(xpath = "(//label[contains(text(),'Workgroup Queue')])[1]")
	private WebElement workGroupQue;

	@FindBy(xpath = "//span[@data-test-id='20150116110353086421138']")
	private WebElement createISG;

	@FindBy(xpath = "//span[@data-test-id=\"20141009112850013217103\"]")
	private WebElement storeIsgId;

	@FindBy(xpath = "//input[@data-test-id=\"20170923174822053693855\"]")
	private WebElement caseIDField;

	@FindBy(xpath = "(//a[@data-test-id=\"201708231545550244393669\"])[1]")
	private WebElement filterLink;

	@FindBy(xpath = "//button[@data-test-id=\"20141008160437053510472\"]")
	private WebElement filterSubmit;

	@FindBy(xpath = "//span[@data-test-id=\"201708291329290533609717\"]")
	private WebElement wbCaseId;

	@FindBy(xpath = "(//a[@data-test-id='20170908144733046212866'])[2]")
	private WebElement addComment;

	@FindBy(xpath = "//div[@id='cke_1_contents']/iframe")
	private WebElement iFrame;

	@FindBy(xpath = "(//button[@data-test-id='20180201140326025613196'])[1]")
	private WebElement save;

	@FindBy(xpath = "//body[@class='cke_editable cke_editable_themed cke_contents_ltr'][@title='This is a rich text editor control.']")
	private WebElement comment;

	@FindBy(xpath = "//ul[@id='pyNavigation1528360059917']/li[3]")
	private WebElement sendEamil;

	@FindBy(xpath = "(//i[@data-test-id='201512210438090148308293'])[2]")
	private WebElement addProdBtn;

	@FindBy(xpath = "//button[@data-test-id='20140919030420037410647']")
	private WebElement submitBtn;

	@FindBy(xpath = "//span[@data-test-id='20150116110353086421138']")
	private WebElement createISGCase;

	protected WebDriver driver;

	public ISGCasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public boolean hasCustomerDetailsDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, isgCustomer_SearchButton);
	}

	public boolean hasCustomerDetailsDisplayedInMainPage() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, isgCustomer_MainPage_FirstName);
	}

	public boolean hasReopenDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, reopen);

	}

	public boolean hasTransferCaseToIndividulDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, transfer_Case_To_Individu);
	}

	public boolean hasRadioButtonDisplayed() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, isgCustomer_RadioButton);
	}

	public boolean hasErrorMsgDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, isgPsc_errormsg);

	}

	public boolean hasWorkCaseDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, workCase);

	}
	
	public ISGCasePage switchTOFrame() {
		CommonFunctions.switchToDefaultFrame(driver);
		return new ISGCasePage(driver);
	}

	public ISGCasePage enterCountryCode(String countryCode) {
		try {
			Thread.sleep(3000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, isgCustomer_CountryCode).sendKeys(countryCode);
		return new ISGCasePage(driver);
	}

	public SolutionSearchHomePage switchToIFrame() {
		CommonFunctions.switchToiFrameByWebElement(driver, framePegaGadget);
		return new SolutionSearchHomePage(driver);
	}

	public boolean hasCategoryAutoOptionDisplayed(String category) {
		CommonFunctions.waitForElement(driver, categoryTxtBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, categoryAutoOptions).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, categoryAutoOptions).get(i).getText().contains(category)) {
				continue;
			} else {
				return true;
			}
		}
		return false;
	}

	public boolean hasSubCategoryAutoOptionDisplayed(String subCategory) {
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, subCategoryTxtBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, subCategoryAutoOptions).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, subCategoryAutoOptions).get(i).getText()
					.contains(subCategory)) {
				continue;
			} else {
				return true;
			}
		}
		return false;
	}

	public SolutionSearchHomePage ssEnterCategory(String category) {
		CommonFunctions.waitForElement(driver, categoryTxtBox).sendKeys(category);
		return new SolutionSearchHomePage(driver);
	}

	public SolutionSearchHomePage enterDecalModel(String decalModel) {
		CommonFunctions.waitForElement(driver, decalModelTxtBox).sendKeys(decalModel);
		decalModelTxtBox.sendKeys(Keys.ARROW_DOWN);
		CommonFunctions.waitForElement(driver, autoOptions);
		try {
			if (autoOptions.getText().contains(decalModel))
				autoOptions.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new SolutionSearchHomePage(driver);
	}

	public SolutionSearchHomePage ssEnterModel(String model) {
		CommonFunctions.waitForElement(driver, modelTxtBox).sendKeys(model);
		modelTxtBox.sendKeys(Keys.ARROW_DOWN);
		CommonFunctions.waitForElement(driver, modelAutoOptions);
		try {
			if (modelAutoOptions.getText().contains(model))
				modelAutoOptions.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SolutionSearchHomePage(driver);
	}

	public boolean hasCreateISGCaseDisplayed(String isg) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// CommonFunctions.waitAndSwitchToFrame(driver, iframePegaGadgetISG);
		CommonFunctions.waitAndSwitchToFrame(driver, iframePegaGadgetISG);
		return CommonFunctions.waitForElement(driver, createISGCase).getText().contains(isg);

	}

	public boolean hasCustomerFirstNameDisplayed() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// switching to default content
		CommonFunctions.switchToDefaultFrame(driver);
		// Switch to Frame in Main Page
		CommonFunctions.waitAndSwitchToFrame(driver, iframePegaGadgetISG_Assertion);
		return CommonFunctions.isElementExist(driver, isgCustomerFirstName);

	}

	public boolean hasCustomerLastNameDisplayed() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, isgCustomerLastName);

	}

	public boolean hasCustomerPhoneNumberDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, isgCustomerPhoneNumber);

	}

	public GSCCustomerSearch clickOnActionsWorkCase() {
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

	public boolean hasCustomerEntityIdDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, isgEntityId);

	}

	public boolean hasCustomerEmailAddressDisplayed() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, isgEmailAddress);

	}

	public boolean hasWorkBasketDisplayed(String workBas) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, gscWorkBasket);

	}

	public boolean hasWorkBasketDisplayed() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, gscWorkBasket);

	}

	public ISGCasePage clickActionsBtn() {
		CommonFunctions.waitForElement(driver, isgAction_Button).click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ISGCasePage(driver);
	}

	public ISGCaseSearchPage GetGSCWorkBasket() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitAndSwitchToFrame(driver, iframePegaGadgetISG_Assertion);
		String WorkBasket = CommonFunctions.waitForElement(driver, gscWorkBasket).getText();
		System.out.println("WorkBasket : " + WorkBasket);
		return new ISGCaseSearchPage(driver);
	}

	public OwnedCasePage ISGRoute_Button() {
		String Status1 = CommonFunctions.waitForElement(driver, isg_Status).getText();
		System.out.println("Current case status is " + Status1);
		CommonFunctions.waitForElement(driver, isgRoute_Button).click();
		System.out.println("Clicked on Route Button");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String Status2 = CommonFunctions.waitForElement(driver, isg_Status).getText();
		System.out.println("Routed Case Status is " + Status2);
		// String WB1 = CommonFunctions.waitForElement(driver,
		// ISGWorkBasket1).getText();
		// System.out.println("Current WorkBasket is" +WB1);
		return new OwnedCasePage(driver);
	}

	public OwnedCasePage Actions_Button() {
		CommonFunctions.waitForElement(driver, isgAction_Button).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new OwnedCasePage(driver);
	}

	public OwnedCasePage Actions_Button_WorkCase() {
		CommonFunctions.waitForElement(driver, workCase).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new OwnedCasePage(driver);
	}

	public OwnedCasePage Actions_ToTransferWB() {
		CommonFunctions.waitForElement(driver, isgAccept_Button).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, isgAction_Button).click();
		CommonFunctions.waitForElement(driver, isgTransferWB).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return new OwnedCasePage(driver);
	}

	public ISGCasePage clickAcceptBtn() {
		CommonFunctions.waitForElement(driver, acceptButton).click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ISGCasePage(driver);
	}

	public OwnedCasePage reopen() {
		CommonFunctions.waitForElement(driver, reopen).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new OwnedCasePage(driver);
	}

	public OwnedCasePage Actions_ToAccept() {
		CommonFunctions.waitForElement(driver, isgAccept_Button).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new OwnedCasePage(driver);
	}

	public ISGCasePage clickCorrespondence() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, gscCorrespondence).click();
		ParentHandle = driver.getWindowHandle();
		System.out.println("Parent window is " + ParentHandle);
		return new ISGCasePage(driver);
	}

	public ISGCasePage clickMail() {
		CommonFunctions.waitForElement(driver, gscNewCaseMailLink).click();
		return new ISGCasePage(driver);
	}

	public ISGCasePage SwitchToMainPage() {
		CommonFunctions.switchToDefaultFrame(driver);
		return new ISGCasePage(driver);
	}

	public ISGCasePage SwitchToDefaultFrame() {
		CommonFunctions.switchToDefaultFrame(driver);
		return new ISGCasePage(driver);
	}

	public ISGCasePage SwitchToMainFrame() {
		CommonFunctions.waitAndSwitchToFrame(driver, iframePegaGadgetISG_Assertion);
		return new ISGCasePage(driver);
	}

	public ViewEmailZeacomPage clickMailZeacom() {
		CommonFunctions.waitForElement(driver, gscNewCaseMailLinkZeacom).click();
		return new ViewEmailZeacomPage(driver);
	}

	public SendCaseEmail sendCaseEmail() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, clickGSCSendCaseMailButton).click();
		return new SendCaseEmail(driver);

	}

	public boolean hasSummaryDispayed(String summ) {
		return CommonFunctions.isElementExist(driver, summary);
	}

	public boolean hasPriorityDrpDwnDisplayed(String prioy) {
		return CommonFunctions.isElementExist(driver, priority);
	}

	public boolean hasOriginDrpDwnDisplayed(String org) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, origin);
	}

	public ISGCasePage switchToFrame1() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitAndSwitchToFrame(driver, iFramePegaGadgetISG_Assertion);
		return new ISGCasePage(driver);
	}

	public boolean hasPriorityText() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.scrollSomeDown(driver);
		CommonFunctions.scrollSomeDown(driver);
		CommonFunctions.scrollSomeDown(driver);
		return CommonFunctions.isElementExist(driver, priorityText);
	}

	public boolean hasOriginText() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, originText);
	}

	public ISGCasePage acceptButton() {
		CommonFunctions.waitForElement(driver, isgAccept_Button).click();
		return new ISGCasePage(driver);
	}

	public boolean isStatusOwned() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, statusOwned);
	}

	public ISGCasePage clickReopenBtn() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, reopen).click();
		return new ISGCasePage(driver);
	}

	public boolean hasCloseBtnDisplayed(String clobtn) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, close).getText().contains(clobtn);
	}

	public boolean hasAcceptBtnDisplayed(String accbtn) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, acceptBtn).getText().contains(accbtn);
	}

	public boolean hasCancelBtnDisplayed(String canbtn) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, cancelBtn).getText().contains(canbtn);
	}

	public boolean hasReopenStatusDisplayed(String reopn) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, reopenStatus).getText().contains(reopn);
	}

	public boolean hasCustomerTitleDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, isgCustomer_Title);
	}

	public boolean hasProductDetailsDisplayedInMainPage() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, isgProduct_MainPage_Model);

	}

	public boolean hasPrint() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, print);
	}

	public boolean hasSend_Case_Email() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, sendCaseEmail);

	}

	public boolean hasTransfer_Case_To_WB() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, transferCaseToWB);

	}

	public boolean hasCustomerDetailsDisplayedInmainPage() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, isgCustomer_MainPage_Customerinfo);

	}

	public boolean hasErrormsgdisplayed() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, isgPSC_ErrorMsg);

	}

	public ISGCasePage clickAcceptButton() {
		CommonFunctions.waitForElement(driver, accept).click();
		return new ISGCasePage(driver);
	}

	public ISGCasePage clickAddComments() {
		// TODO Auto-generated method stub
		CommonFunctions.waitForElement(driver, addComment).click();

		return new ISGCasePage(driver);
	}

	// Click on AddCustomer Info Link
	public ISGCasePage clickAddCustomerInfo() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, addCustomerInfoLink).click();
		return new ISGCasePage(driver);
	}

	// Enter Last Name
	public ISGCasePage enterLastName(String lastname) {
		CommonFunctions.waitForElement(driver, isgCustomer_LastName).sendKeys(lastname);
		return new ISGCasePage(driver);
	}

	// Enter First Name
	public ISGCasePage enterFirstName(String firstname) {
		CommonFunctions.waitForElement(driver, isgCustomer_FirstName).sendKeys(firstname);
		return new ISGCasePage(driver);
	}

	// Click on Customer Search
	public ISGCasePage clickCustomerSearch() {
		CommonFunctions.waitForElement(driver, isgCustomer_SearchButton).click();
		return new ISGCasePage(driver);
	}

	// Click on Radio Button
	public ISGCasePage clickRadioButton() {
		CommonFunctions.waitForElement(driver, isgCustomer_RadioButton).click();
		return new ISGCasePage(driver);
	}

	// Click on Customer submit
	public ISGCasePage clickCustomerSubmitButton() {
		CommonFunctions.waitForElement(driver, isgCustomer_SubmitButton).click();
		return new ISGCasePage(driver);
	}

	public boolean hasNewStatusDisplayed(String newStatusVerfy) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, newStatus).getText().contains(newStatusVerfy);

	}

	public boolean hasGSCWorkBasketDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, gscWorkBasket);

	}

	// Click on Add Product Info Link
	public ISGCasePage clickAddProductInfo() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, isgAddProductInfo).click();
		return new ISGCasePage(driver);
	}

	// Enter Model Value
	public ISGCasePage enterModel(String category) {
		CommonFunctions.waitForElement(driver, isgProduct_Model).sendKeys(category);
		CommonFunctions.waitForElement(driver, isgProduct_Model).sendKeys(Keys.ARROW_DOWN);
		CommonFunctions.waitForElement(driver, autoOptions);
		try {
			if (autoOptions.getText().contains(category))
				autoOptions.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ISGCasePage(driver);
	}

	// Click on Product submit
	public ISGCasePage clickProductSubmitButton() {
		CommonFunctions.waitForElement(driver, isgProduct_Submit).click();
		return new ISGCasePage(driver);
	}

	// Click on Product submit
	public ISGCasePage submitButton() {
		CommonFunctions.waitForElement(driver, isgProduct_Submit).click();
		return new ISGCasePage(driver);
	}

	// Click on transfer submit.
	public ISGCasePage clickTransferButton() {
		CommonFunctions.waitForElement(driver, transferButton).click();
		return new ISGCasePage(driver);
	}

	// enter Functional code value
	public ISGCasePage functionalCode(String func_code) {
		CommonFunctions.waitForElement(driver, isgFunctionalCode).sendKeys(func_code);
		CommonFunctions.waitForElement(driver, isgFunctionalCode).sendKeys(Keys.ARROW_DOWN);
		CommonFunctions.waitForElement(driver, autoOptions);
		try {
			if (autoOptions.getText().contains(func_code))
				autoOptions.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ISGCasePage(driver);
	}

	public ISGCasePage selPriority(String pri) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		//CommonFunctions.selectFromDropdownByIndex(driver, 2, priority);
		CommonFunctions.selectFromDropdown(driver, pri, priority);
		
		return new ISGCasePage(driver);

	}

	public ISGCasePage selOrigin(String orign) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//CommonFunctions.selectFromDropdown(driver, orign, origin);
		CommonFunctions.selectFromDropdownByIndex(driver, 2, origin);
		return new ISGCasePage(driver);

	}

	// Get ISG WorkBasket value
	public ISGCasePage getWorkBasket() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitAndSwitchToFrame(driver, iFramePegaGadgetISG_Assertion);
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, isgWorkBasket).getText();
		return new ISGCasePage(driver);
	}

	// Get GSC WorkBasket value
	public ISGCasePage getWorkBasket_GSC() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitAndSwitchToFrame(driver, iFramePegaGadgetISG_Assertion);
		String WorkBasket = CommonFunctions.waitForElement(driver, gscWorkBasket).getText();
		return new ISGCasePage(driver);
	}

	// Get Work Basket Value for ISG
	public ISGCasePage getGSCWorkBasket() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitAndSwitchToFrame(driver, iFramePegaGadgetISG_Assertion);
		WorkBasket = CommonFunctions.waitForElement(driver, gscWorkBasket).getText();
		return new ISGCasePage(driver);
	}

	// Verify Clear button in Customer page
	public ISGCasePage clearCustomer(ISGCasePage isgCasePage) {
		CommonFunctions.waitForElement(driver, isgCustomer_Clear).click();
		return new ISGCasePage(driver);
	}

	// Validate the status after routing
	public OwnedCasePage isgRouteButton() {
		String Status1 = CommonFunctions.waitForElement(driver, isg_Status).getText();
		CommonFunctions.waitForElement(driver, isgRoute_Button).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String Status2 = CommonFunctions.waitForElement(driver, isg_Status).getText();
		System.out.println("Routed Case Status is " + Status2);
		return new OwnedCasePage(driver);
	}

	// Click on Actions Button
	public OwnedCasePage actionsButton() {
		CommonFunctions.waitForElement(driver, isgAction_Button).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new OwnedCasePage(driver);
	}

	// Click on Actions Button work case
	public OwnedCasePage actions_Button_WorkCase() {
		CommonFunctions.waitForElement(driver, workCase).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new OwnedCasePage(driver);
	}

	// Click on ISG Transfer Work Basket
	public OwnedCasePage actions_ToTransferWB() {
		CommonFunctions.waitForElement(driver, isgAccept_Button).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, isgAction_Button).click();
		CommonFunctions.waitForElement(driver, isgTransferWB).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new OwnedCasePage(driver);
	}

	// Click on ISG Transfer button
	public ISGCasePage newWorkBasket(String workBasket) {
		CommonFunctions.waitForElement(driver, newWorkBasket).sendKeys(workBasket);
		CommonFunctions.waitForElement(driver, newWorkBasketDropDown).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, isgTransfer_Button).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ISGCasePage(driver);
	}

	// click on Actions
	public ISGCasePage isgClickActionsButton() {
		CommonFunctions.waitForElement(driver, isgActions).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ISGCasePage(driver);
	}

	public ISGCasePage isgClickTransferToWButton() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, transferWorkBasket).click();
		return new ISGCasePage(driver);
	}

	public ISGCasePage enterToTransferWB(String value) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, transferWorkbasket).sendKeys(value);
		return new ISGCasePage(driver);
	}

	public ISGCasePage isgClickTransferToIndividual() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, isgTransferIndividualButton).click();
		return new ISGCasePage(driver);
	}

	// selected from operator dropdown
	public ISGCasePage isgEnterTransferOperator(String operator) {
		CommonFunctions.waitForElement(driver, isgTransferIndividualOperator).sendKeys(operator);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ISGCasePage(driver);
	}

	public ISGCasePage isgEnterTransferWorkbasket(String workbasket) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, isgTransferIndividualWorkbasket).sendKeys(workbasket);
		return new ISGCasePage(driver);
	}

	public ISGCasePage isgClkTransferSubmitButton() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, isgTransferSubmit).click();
		return new ISGCasePage(driver);
	}

	public ISGCasePage isgExpandAuditHistory() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.scrollToElement(driver, auditTrails);
		CommonFunctions.waitForElement(driver, auditTrails).click();
		return new ISGCasePage(driver);
	}

	public ISGCasePage isgClickCaseClose() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitForElement(driver, highlightClose).click();
		CommonFunctions.waitForElement(driver, caseclose).click();
		return new ISGCasePage(driver);
	}

	public ISGCasePage isgCaseDiscard() {
		CommonFunctions.waitForElement(driver, discard).click();
		return new ISGCasePage(driver);
	}

	// Click on ISG Close button
	public OwnedCasePage isg_Close_Button() {
		CommonFunctions.waitForElement(driver, isgClose_Button).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new OwnedCasePage(driver);
	}

	// Click on Reopen button
	public OwnedCasePage reOpen() {
		CommonFunctions.waitForElement(driver, reopen).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new OwnedCasePage(driver);
	}

	// Click on ISG Accept Button
	public OwnedCasePage actions_ToAccept() {
		CommonFunctions.waitForElement(driver, isgAccept_Button).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new OwnedCasePage(driver);
	}

	// Switch to Default frame
	public ISGCasePage switchToDefaultFrame() {
		CommonFunctions.switchToDefaultFrame(driver);
		return new ISGCasePage(driver);
	}

	// Switch to main Frame
	public ISGCasePage switchToMainFrame() {
		CommonFunctions.waitAndSwitchToFrame(driver, iFramePegaGadgetISG_Assertion);
		return new ISGCasePage(driver);
	}

	// click on GSC send case Mail Button
	public SendCaseEmail sendCaseMail() {
		try {
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, clickGSCSendCaseMailButton).click();
		return new SendCaseEmail(driver);
	}

	// Send Solution ID Value
	public ISGCasePage sendSolutionId(String solutionId) {
		CommonFunctions.waitForElement(driver, solutionIdBox).sendKeys(solutionId);
		return new ISGCasePage(driver);
	}

	// Validate Solution Success message
	public boolean hasSolutionSuccessMsgDisplayed(String ExpectedMsg) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (CommonFunctions.waitForElement(driver, solutionSuccessMsg).getText().contains(ExpectedMsg)) {
			return true;
		} else {
			return false;
		}
	}

	// Click on Solution search img
	public ISGCasePage clickSolutionSearchImg() {
		CommonFunctions.waitForElement(driver, solutionIdSearchImg).click();
		return new ISGCasePage(driver);
	}

	public boolean hasStatusNewDisplayed() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, statusAsNew);
	}

	public boolean hasCustomerInfoTextDisplayed(String cust) {
		return CommonFunctions.waitForElement(driver, customerInfo).getText().contains(cust);
	}

	public boolean hasConatctAndDealershipTextDisplayed(String contact) {
		return CommonFunctions.waitForElement(driver, contactDealesrship).getText().contains(contact);
	}

	public boolean hasProductInfoTextDisplayed(String product) {
		return CommonFunctions.waitForElement(driver, productInfoButton).getText().contains(product);
	}

	public boolean hasCaseCodingTextDisplayed(String cc) {
		return CommonFunctions.waitForElement(driver, caseCoding).getText().contains(cc);
	}

	public boolean hasCaseInformationTextDisplayed(String ci) {
		return CommonFunctions.waitForElement(driver, caseInformation).getText().contains(ci);
	}

	public boolean hasRelatedCaseTextDisplayed(String relcas) {
		return CommonFunctions.isElementExist(driver, relatedCase);
	}

	public boolean hasProblemDetailsTextDisplayed(String probdet) {
		return CommonFunctions.isElementExist(driver, problemDetails);
	}

	public boolean hasSummaryTextDisplayed(String summary) {
		return CommonFunctions.isElementExist(driver, summ);
	}

	public boolean hasWorkbasketTextDisplayed(String workbasketButton) {
		return CommonFunctions.isElementExist(driver, workBasket);
	}

	public boolean hasAcceptBtnDisplayed() {
		return CommonFunctions.isElementExist(driver, accept);
	}

	public boolean hasAcceptandCloseBtnDisplayed() {

		return CommonFunctions.isElementExist(driver, acceptAndClose);
	}

	public boolean hasWithdrawBtnDisplayed() {
		return CommonFunctions.isElementExist(driver, withdraw);
	}

	public boolean hasAuditTextDisplayed(String aud) {
		return CommonFunctions.isElementExist(driver, audit);
	}

	public boolean hasSaveBtnDisplayed() {
		return CommonFunctions.isElementExist(driver, save);
	}

	public ISGCasePage selFunctionalArea(String func_area) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// CommonFunctions.waitForElement(driver, isgFunctionalArea).sendKeys(category);
		CommonFunctions.waitForElement(driver, isgFunctionalArea).sendKeys(func_area);
		CommonFunctions.waitForElement(driver, isgFunctionalArea).sendKeys(Keys.ARROW_DOWN);
		CommonFunctions.waitForElement(driver, autoOptions);
		try {
			if (autoOptions.getText().contains(func_area))
				autoOptions.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// CommonFunctions.waitForElement(driver,
		// isgFunctionalArea).sendKeys(Keys.ARROW_DOWN);
		return new ISGCasePage(driver);
	}

	public ISGCasePage selFunCode(String category) {
		// CommonFunctions.waitForElement(driver, isgFunctionalCode).sendKeys(category);
		CommonFunctions.waitForElement(driver, isgFunctionalCode).sendKeys(category);
		// CommonFunctions.waitForElement(driver,
		// isgFunctionalCode).sendKeys(Keys.ARROW_DOWN);
		return new ISGCasePage(driver);
	}

	public ISGCasePage clickClose() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, close).click();
		return new ISGCasePage(driver);
	}

	public ISGCasePage enterSummary(String summary) {
		CommonFunctions.waitForElement(driver, isgSummary).sendKeys(summary);
		return new ISGCasePage(driver);
	}

	public ISGCasePage enterIsgSummary(String summary) {
		CommonFunctions.waitForElement(driver, isgSummary).sendKeys(summary);
		return new ISGCasePage(driver);
	}

	public ISGLinkSolutionPage isgCase_Language(String language) {
		CommonFunctions.waitAndSwitchToFrame(driver, languDD);
		CommonFunctions.selectFromDropdown(driver, language, languDD);
		return new ISGLinkSolutionPage(driver);
	}

	public ISGLinkSolutionPage isgCase_Origin(String orig) {
		CommonFunctions.waitAndSwitchToFrame(driver, languDD);
		CommonFunctions.selectFromDropdown(driver, orig, languDD);
		return new ISGLinkSolutionPage(driver);
	}

	public boolean hasPriorityTextDisplayed() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.scrollSomeDown(driver);
		CommonFunctions.scrollSomeDown(driver);
		CommonFunctions.scrollSomeDown(driver);
		return CommonFunctions.isElementExist(driver, priorityText);
	}

	public boolean hasLanguageTextDisplayed() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, languageText);
	}

	public boolean hasOriginTextDisplayed() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, originText);
	}

	public boolean hasRefreshOptionDisplayed(String refres) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, refresh).getText().contains(refres);

	}

	public boolean hasNewDraftStatusDisplayed(String newDrat) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, newDraft).getText().contains(newDrat);

	}

	public boolean hasTransferIndividuOptionDisplayed(String ti) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, transferCaseToIndividu).getText().contains(ti);

	}

	public boolean hasSendCaseEmailOptionDisplayed(String mail) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, sendCaseEmail).getText().contains(mail);

	}

	public ISGCasePage clickTSS() {
		CommonFunctions.waitForElement(driver, tss).click();
		return new ISGCasePage(driver);
	}

	public ISGCasePage clickWorkcase() {
		CommonFunctions.waitForElement(driver, workCase).click();
		return new ISGCasePage(driver);
	}

	public ISGCasePage selectWorkcaseOption() {
		CommonFunctions.waitForElement(driver, workCaseInActions).click();
		return new ISGCasePage(driver);
	}

	public ISGCasePage clickOnAcceptBtn() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, acceptButton).click();
		return new ISGCasePage(driver);
	}

	public ISGCasePage clickOnActionWorkcase() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, workCaseInActions).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Actions builder = new Actions(driver);
		builder.moveToElement(tss).perform();
		CommonFunctions.waitForElement(driver, workCase).click();
		return new ISGCasePage(driver);
	}

	public ISGCasePage clickCancelBtn() {
		CommonFunctions.waitForElement(driver, cancelButton).click();
		return new ISGCasePage(driver);
	}

	public boolean hasTransferCaseToWBOptionDisplayed(String wb) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, transferCaseToWB);

	}

	public boolean hasResolvedCompletedStatusDisplayed() {
		return CommonFunctions.isElementExist(driver, resolved);
	}

	public boolean hasPrintOptionDisplayed(String printVerfy) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, print).getText().contains(printVerfy);
	}

	public boolean hasOwnedStatusDisplayed(String ownedVerfy) {
		return CommonFunctions.waitForElement(driver, owned).getText().contains(ownedVerfy);
	}

	public boolean hasCloseBtnDisplayed() {
		return CommonFunctions.isElementExist(driver, close);
	}

	public boolean hasCancelBtnDisplayed() {
		return CommonFunctions.isElementExist(driver, cancel);
	}

	public boolean isModelHeaderDisplayed(String header) {
		return CommonFunctions.waitForElement(driver, modelHeader).getText().contains(header);
	}

	public boolean isUsageHeaderDisplayed(String string) {
		return CommonFunctions.waitForElement(driver, usageHeader).getText().contains(string);
	}

	public boolean isUnitsHeaderDisplayed(String string) {
		return CommonFunctions.waitForElement(driver, unitsHeader).getText().contains(string);
	}

	public boolean isPinHeaderDisplayed(String string) {
		return CommonFunctions.waitForElement(driver, pinHeader).getText().contains(string);
	}

	public boolean isPartNumHeaderDisplayed(String string) {
		return CommonFunctions.waitForElement(driver, partNumHeader).getText().contains(string);
	}

	public boolean isComponentHeaderDisplayed(String string) {
		return CommonFunctions.waitForElement(driver, componentSerialHeader).getText().contains(string);
	}

	public ISGCasePage clickWrkGrpQue() {
		CommonFunctions.waitForElement(driver, workGroupQue).click();
		return new ISGCasePage(driver);
	}

	public boolean hasProductHeadingDisplayed(String prodcutSys) {
		return CommonFunctions.waitForElement(driver, prodHeading).getText().contains(prodcutSys);
	}

	public ISGCasePage productInfoModel(String model) {
		// CommonFunctions.scrollToWebElement(driver, addProdBtn);
		// CommonFunctions.waitForElement(driver, addProdBtn).click();
		CommonFunctions.waitForElement(driver, productInfoModelDD).sendKeys(model);
		productInfoModelDD.sendKeys(Keys.ARROW_DOWN);
		CommonFunctions.waitForElement(driver, modelAutoOptions);
		try {
			if (modelAutoOptions.getText().contains(model))
				modelAutoOptions.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, submitBtn).click();
		return new ISGCasePage(driver);
	}

	public WorkGroupQueuePage clickWrkGrpQueue() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitForElement(driver, workGroupQue).click();
		return new WorkGroupQueuePage(driver);
	}

	public boolean hasCreateISGCasePageDisplayed(String isg) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitAndSwitchToFrame(driver, iframePegaGadgetISG);
		return CommonFunctions.waitForElement(driver, createISG).getText().contains(isg);

	}

	public boolean isOwnedStatusDisplayed(String owned) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, statusOwned).getText().contains(owned);
	}

	public boolean hasResolvedCompletedStatusDisplayed(String resolv) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, resolvedCompleted).getText().contains(resolv);
	}

	public boolean hasAcceptAndCloseButtonDisplayed(String acclose) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, acceptAndClose).getText().contains(acclose);

	}

	public ISGCasePage enterComment(String comments) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.switchToiFrameByWebElement(driver, iFrame);
		CommonFunctions.waitForElement(driver, comment).sendKeys(comments);
		return new ISGCasePage(driver);
	}

	public ISGCasePage clickSubmitBtn() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.switchToiFrameByWebElement(driver, iFrame);
		CommonFunctions.waitForElement(driver, submitBtn).click();
		return new ISGCasePage(driver);
	}

	public ISGCasePage clickSaveButton() {
		CommonFunctions.waitForElement(driver, save).click();
		return new ISGCasePage(driver);
	}

	public ISGCasePage clickCloseButton() {
		CommonFunctions.waitForElement(driver, close).click();
		return new ISGCasePage(driver);
	}

	public SendCaseEmail selectSendCaseEmail() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.switchToiFrameByWebElement(driver, iFrame);
		CommonFunctions.waitForElement(driver, actionButton).click();
		CommonFunctions.isElementExist(driver, actionFrame);
		CommonFunctions.waitForElement(driver, sendEamil).click();
		return new SendCaseEmail(driver);
	}

	public ISGLinkSolutionPage clickSoluSeach() {
		CommonFunctions.waitForElement(driver, soluSearch).click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitAndSwitchToFrame(driver, frame);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("frame switched");
		return new ISGLinkSolutionPage(driver);
	}

	public ISGLinkSolutionPage clickSearchBtn() {

		CommonFunctions.isElementExist(driver, clearBtn);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.isElementExist(driver, searchBtn);
		CommonFunctions.waitForElement(driver, searchBtn).click();
		return new ISGLinkSolutionPage(driver);
	}

	public ISGCasePage isgCase_Languag(String language) {
		//CommonFunctions.selectFromDropdown(driver, language, languDD);
		CommonFunctions.selectFromDropdownByIndex(driver, 6, languDD);
		
		return new ISGCasePage(driver);
	}

	public ISGCasePage clickActions() {
		CommonFunctions.waitForElement(driver, clickActionButton).click();
		CommonFunctions.isElementExist(driver, actionFrame);
		CommonFunctions.waitForElement(driver, actionWorkCase).click();
		return new ISGCasePage(driver);
	}

	public ISGCaseSearchPage clkCorrespondence() {

		CommonFunctions.scrollToWebElement(driver, gscCorrespondence);
		CommonFunctions.isElementExist(driver, gscCorrespondence);
		ParentHandle = driver.getWindowHandle();
		return new ISGCaseSearchPage(driver);
	}

	public ISGWithdrawPage clickOnAction() {
		CommonFunctions.waitForElement(driver, actionButton).click();
		return new ISGWithdrawPage(driver);

	}

	public ISGCasePage clickOnActionsBtnSwitchToFrame() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.switchToiFrameByWebElement(driver, iFrame1);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionBtn).click();
		return new ISGCasePage(driver);
	}

}
