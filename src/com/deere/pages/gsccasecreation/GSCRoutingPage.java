package com.deere.pages.gsccasecreation;


import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.deere.global.CommonFunctions;
import com.deere.global.GlobalThings;

public class GSCRoutingPage extends GlobalThings{

	@FindBy(name = "PegaGadget0Ifr")
	private WebElement iframeHomepage;

	@FindBy(xpath = "//button[@data-test-id='20180201163908004467353']")
	private WebElement createGSCCase;

	@FindBy(xpath = "//span[@id='modaldialog_hd_title']")
	private WebElement customerSearchHeader;

	@FindBy(xpath = "//*[@id='firstName']")
	private WebElement customerFirstName;

	@FindBy(xpath = "//*[@id='lastName']")
	private WebElement customerLastName;

	@FindBy(xpath = "//select[@id='country']")
	private WebElement customerCountry;

	@FindBy(xpath = "//input[@class='button btn btn-primary']")
	private WebElement searchCustomers;

	@FindBy(xpath = "//table[@id='results']/tbody/tr[2]/td[2]/a")
	private WebElement selectSearchDetails;

	@FindBy(xpath = "//iframe[contains(@src,'SolutionSearchHome')]")
	private WebElement iframePegaGadget;

	@FindBy(xpath = "(//button[@data-test-id='20180201162439008710139'])[1]")
	private WebElement closeBtn;
	
	@FindBy(name = "PegaGadget0Ifr")
	private WebElement iframe;
	
	

	@FindBy(xpath = "(//i[@data-test-id='201512210438090148308293'])[1]")
	private WebElement gscAddCustInfoButton;

	@FindBy(xpath = "(//i[@data-test-id='201512210438090148308293'])[2]")
	private WebElement addProdBtn;

	@FindBy(xpath = "//input[@data-test-id='2015100603215503417556']")
	private WebElement productInfoModelDD;

	@FindBy(xpath = "//span//label[text()='My Cases']")
	private WebElement myCases;

	@FindBy(xpath = "//table[@id='bodyTbl_right']/tbody//div[@class='oflowDiv']//span[@class='match-highlight']")
	private WebElement modelAutoOptions;

	@FindBy(xpath = "//table[@id='gridLayoutTable']/tbody//div[@class='oflowDiv']//span[@class='match-highlight']")
	private WebElement autoOptions;

	@FindBy(xpath = "//table[@id='EXPAND-OUTERFRAME']/tbody//div[@class='oflowDiv']//span[@class='match-highlight']")
	private WebElement operaterAutoOptions;

	@FindBy(xpath = "//button[@data-test-id='20140919030420037410647']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "(//button[@data-test-id='20180419123512080115230'])[1]")
	private WebElement transferBtn;

	@FindBy(xpath = "//select[@data-test-id='201802060658510010138182']")
	private WebElement workBasket;

	@FindBy(xpath = "//table[@id='RULE_KEY'][@aria-label='Workgroup Queue']")
	private WebElement workGroupQueue;

	@FindBy(xpath = "//select[@data-test-id='201802060658510010138182']")
	private WebElement workBasketTrafer;

	@FindBy(xpath = "//iframe[@id='CSC_Section']")
	private WebElement frame;

	@FindBy(xpath = "//input[@data-test-id='2016050211281203883185']")
	private WebElement funCode;

	@FindBy(xpath = "//input[@data-test-id='201605021128120388258']")
	private WebElement funArea;

	@FindBy(xpath = "//*[@id='CasePriority']")
	private WebElement priorityDD;

	@FindBy(xpath = "//span[contains(text(),'PCDSC')]")
	private WebElement workSelect;

	@FindBy(xpath = "//*[@id='Origin']")
	private WebElement originDD;

	@FindBy(xpath = "//*[@id='RULE_KEY']/div/div/div/div/div/div/input")
	private WebElement summary;

	@FindBy(xpath = "//*[@class='content-item content-field item-3 remove-top-spacing remove-bottom-spacing remove-left-spacing remove-right-spacing']")
	private WebElement ownedStatus;

	@FindBy(xpath = "//*[@class='content-item content-field item-3 remove-top-spacing remove-bottom-spacing remove-left-spacing remove-right-spacing']")
	private WebElement resolvedCompleted;

	@FindBy(xpath = "(//button[@data-test-id='201802011400580656111285'])[1]")
	private WebElement acceptButton;

	@FindBy(xpath = "//select[@data-test-id='201802060658510010138182']")
	private WebElement workBasketTrans;

	@FindBy(xpath = "//select[@id='WorkbasketName']")
	private WebElement WorkBasket;

	@FindBy(xpath = "//select[@id='GSCSubWorkgroup']")
	private WebElement WorkSubGroup;

	@FindBy(xpath = "//h2[contains(text(),'Audit')]")
	private WebElement auditTrails;

	@FindBy(xpath = "(//button[@data-test-id='201802081002310780562'])[2]")
	private WebElement canBtn;

	@FindBy(xpath = "//input[@data-test-id='201605271221250444446791']")
	private WebElement workBasketFiled;

	@FindBy(xpath = "//*[@id='$PpyWorkPage$pWBNameError']")
	private WebElement mesage;

	@FindBy(xpath = "//button[@data-test-id=\"20180201163908004467353\"]")
	private WebElement gscCase;

	@FindBy(xpath = "(//button[@data-test-id='20180206104022047318388'])[1]")
	private WebElement transfer_Button;

	@FindBy(xpath = "(//button[@data-test-id='2018051414200104299296'])[2]")
	private WebElement withdrawBtn;

	@FindBy(xpath = "(//button[@data-test-id='2018051414164108233405'])[1]")
	private WebElement withdrawSubmit;
	
	@FindBy(xpath = "//span[@data-test-id='20150116110353086421138']")
	private WebElement gscPage;

	@FindBy(xpath = "//*[@class='content-item content-field item-3 remove-top-spacing remove-bottom-spacing remove-left-spacing remove-right-spacing']")
	private WebElement newStatus;
	
	@FindBy(xpath = "//*[@class='content-item content-field item-3 remove-top-spacing remove-bottom-spacing remove-left-spacing remove-right-spacing']")
	private WebElement newDraft;

	@FindBy(xpath = "(//div[@class='layout layout-noheader layout-noheader-jd_containers_outer_shadow'])[2]")
	private WebElement addCustInfoSct;

	@FindBy(xpath = "(//div[@class='layout layout-noheader layout-noheader-jd_containers_outer_shadow'])[3]")
	private WebElement addDealInfoSct;

	@FindBy(xpath = "(//div[@class='layout layout-noheader layout-noheader-jd_containers_outer_shadow'])[4]")
	private WebElement addProductInfoSct;

	@FindBy(xpath = "(//*[contains(text(),'Case Coding')])[4]")
	private WebElement caseCodingSct;

	@FindBy(xpath = "(//*[contains(text(),'Case Information')])[3]")
	private WebElement caseInformSct;

	@FindBy(xpath = "(//div[@class='layout layout-noheader layout-noheader-jd_containers_outer_shadow'])[8]")
	private WebElement relatedCaseSct;

	@FindBy(xpath = "(//*[contains(text(),'Problem Details')])[3]")
	private WebElement problemDetailsSct;

	@FindBy(xpath = "//*[contains(text(),'Add Files')]")
	private WebElement addFilesSct;

	@FindBy(xpath = "(//button[@data-test-id='201802011400580656111285'])[1]")
	private WebElement action;

	@FindBy(xpath = "(//button[@data-test-id='201802011400580656111285'])[1]")
	private WebElement accpBtn;

	@FindBy(xpath = "(//button[@data-test-id='20180201140326025511943'])[1]")
	private WebElement accepClodeBtn;

	@FindBy(xpath = "(//button[@data-test-id='20180201140326025613196'])[1]")
	private WebElement saveBtn;

	@FindBy(xpath = "(//button[@data-test-id='20180531073524008831831'])[1]")
	private WebElement withDrawBtn;

	@FindBy(xpath = "//button[@data-test-id='20141008160437053510472']")
	private WebElement subBtn;

	@FindBy(xpath = "(//button[@data-test-id='20180419123512080115230'])[1]")
	private WebElement transfer;

	@FindBy(xpath = "//label[@data-test-id='20170915163723049610155-Label']")
	private WebElement operatorTransfer;

	@FindBy(xpath = "//label[@data-test-id='2015031809055206723480-Label']")
	private WebElement workBasketTransfer;

	@FindBy(xpath = "//button[@data-test-id='20140919030420037511488']")
	private WebElement cancelButton;

	@FindBy(xpath = "//button[@data-test-id='20140919030420037410647']")
	private WebElement submitButton;

	@FindBy(xpath = "//div[@data-test-id='2017092112440000351153']")
	private WebElement errorMessage;

	@FindBy(xpath = "//*[@id='$PreAssignPage$ppyReassignWorkGroupNameError']/span")
	private WebElement validMessage;

	@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(text(),'Action')]")
	private WebElement actions;

	@FindBy(xpath = "//*[@id='pyNavigation1528360059917' or @id='pyNavigation1528360059959']")
	private WebElement actionsFrame;

	@FindBy(xpath = "//*[@id='pyNavigation1528360059959']/li[3]")
	private WebElement trasfCaseToInvidual;

	@FindBy(xpath = "//*[@id='pyNavigation1528360059959']/li[2]")
	private WebElement trasfCaseToWB;

	@FindBy(xpath = "//*[@id='pyNavigation1528360059917' or @id='pyNavigation1528360059959']/li[2]")
	private WebElement workCase;

	@FindBy(xpath = "//input[@data-test-id='20170915163723049610155']")
	private WebElement operater;

	@FindBy(xpath = " //input[@data-test-id='2015031809055206723480' or @data-test-id='201605271221250444446791'] ")
	private WebElement workBasketTranf;

	@FindBy(xpath = "//div[@id='modaldialog_hd']")
	private WebElement trandHeader;
	
	@FindBy(xpath = "//select[@data-test-id='201802060658510010138182']")
	private WebElement workBaskerforTrasWB;


	@FindBy(xpath = "//button[@data-test-id='20140919030420037410647']")
	private WebElement submit;

	@FindBy(xpath = "//input[@data-test-id='201710100918100500726859']")
	private WebElement workBasketAutoComp;

	@FindBy(xpath = "//table[@data-test-id='20171002083407021117-layout']")
	private WebElement caseTable;

	@FindBy(xpath = "//td[@data-attribute-name='Case ID']//div[@class='oflowDivM ']/span")
	private List<WebElement> caseIdList;

	@FindBy(xpath = "//input[@class='leftJustifyStyle']")
	private WebElement caseIdInput;

	@FindBy(xpath = "//a[text()='Clear Filters']")
	private WebElement clearFiltersLink;

	@FindBy(xpath = "//*[@id='state']")
	private WebElement province;

	@FindBy(xpath = "//span[contains(text(),'TS94982')]")
	private WebElement operaterSelect;
	
	protected static HashMap<Long, String> isgCaseIdTSS = new HashMap<Long, String>();
	public static HashMap<Long, String> gscCaseID = new HashMap<Long, String>();


	protected WebDriver driver;
	

	public GSCRoutingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public GSCRoutingPage clickGSCCase() {

		CommonFunctions.waitForElement(driver, createGSCCase).click();
		CommonFunctions.waitAndSwitchToFrame(driver, iframeHomepage);
		return new GSCRoutingPage(driver);
	}

	

	
	public GSCRoutingPage state(String stat) {
		CommonFunctions.scrollSomeDown(driver);
		CommonFunctions.selectFromDropdown(driver, stat, province);
		return new GSCRoutingPage(driver);
	}

	public GSCRoutingPage country(String country) {
		CommonFunctions.scrollSomeDown(driver);
		CommonFunctions.selectFromDropdown(driver, country, customerCountry);
		return new GSCRoutingPage(driver);
	}

	



	
	public GSCRoutingPage selectWB(String workbasket) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.selectFromDropdown(driver, workbasket, workBasketTrans);
		CommonFunctions.selectFromDropdown(driver, workbasket, workBasketTrans);
		return new GSCRoutingPage(driver);

	}

	public GSCRoutingPage selectWorkBasketTrafCase(String workbasket) {
		CommonFunctions.selectFromDropdown(driver, workbasket, workBasketTrans);
		return new GSCRoutingPage(driver);

	}

	public GSCRoutingPage submitBtn() {
		CommonFunctions.waitForElement(driver, subBtn).click();
		return new GSCRoutingPage(driver);

	}

	public GSCRoutingPage transferBtn() {
		CommonFunctions.waitForElement(driver, transfer).click();
		return new GSCRoutingPage(driver);
	}

	

	public GSCRoutingFilterSearchPage clickOnWorkGroupQueue() {
		CommonFunctions.switchToDefaultFrame(driver);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, workGroupQueue).click();
		return new GSCRoutingFilterSearchPage(driver);
	}

	

	
	
	@FindBy(xpath = "//span[@id='TABSPAN']//span//label[text()='Home']")
	private WebElement homeBtn;
	
	@FindBy(xpath="//button[@data-test-id='20180201163908004467353']")
	private WebElement createGSCCaseTab;
	
	
	
	

	public GSCRoutingPage clickonWorkCase() {
		CommonFunctions.waitForElement(driver, actions).click();
		CommonFunctions.waitForElement(driver, actionsFrame);
		CommonFunctions.waitForElement(driver, workCase).click();
		return new GSCRoutingPage(driver);

	}

	public GSCRoutingPage clickOnTransferToWorkBasket() {
		CommonFunctions.waitForElement(driver, actions).click();
		CommonFunctions.waitForElement(driver, actionsFrame);
		CommonFunctions.waitForElement(driver, trasfCaseToWB).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new GSCRoutingPage(driver);

	}

	public GSCRoutingPage clickOnTransferToIndividual() {
		CommonFunctions.waitForElement(driver, actions).click();
		CommonFunctions.waitForElement(driver, actionsFrame);
		CommonFunctions.waitForElement(driver, trasfCaseToInvidual).click();
		return new GSCRoutingPage(driver);

	}

	public GSCRoutingPage clickOnActionsSelectWorkCase() {
		CommonFunctions.waitForElement(driver, actions).click();
		CommonFunctions.waitForElement(driver, actionsFrame);
		CommonFunctions.waitForElement(driver, trasfCaseToWB).click();
		return new GSCRoutingPage(driver);

	}

	public boolean hasNewStatusDisplayed(String newStatusVerfy) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, newStatus).getText().contains(newStatusVerfy);
	}
	
	
	
	

	public boolean hasOwnedStatusDisplayed(String ownedStatusVerfy) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, ownedStatus).getText().contains(ownedStatusVerfy);
	}

	public boolean hasWorkBasketAutoCompleteDisplayed() {
		return CommonFunctions.isElementExist(driver, workBasketAutoComp);
	}

	public boolean hasAddNewCusInfoSectionDisplayed() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.switchToiFrameByWebElement(driver, iframeHomepage);
		return CommonFunctions.isElementExist(driver, addCustInfoSct);
	}

	public boolean hasAddContactDealershipInfoSectionDisplayed() {
		CommonFunctions.scrollToElement(driver, addDealInfoSct);
		return CommonFunctions.isElementExist(driver, addDealInfoSct);
	}

	public boolean hasAddProductInfoSectionDisplayed() {
		return CommonFunctions.isElementExist(driver, addProductInfoSct);
	}

	public boolean hasCaseCodingSectionDisplayed(String casecodingVerfy) {
		return CommonFunctions.waitForElement(driver, caseCodingSct).getText().contains(casecodingVerfy);
	}

	public boolean hasCaseInformationSectionDisplayed(String caseInformationVerfy) {
		CommonFunctions.scrollToElement(driver, caseInformSct);
		return CommonFunctions.waitForElement(driver, caseInformSct).getText().contains(caseInformationVerfy);
	}

	public boolean hasRelatedCaseSectionDisplayed() {
		return CommonFunctions.isElementExist(driver, relatedCaseSct);
	}

	public boolean hasProbDetailsSectionDisplayed(String prbDet) {
		return CommonFunctions.waitForElement(driver, problemDetailsSct).getText().contains(prbDet);
	}

	public boolean hasAddFilesSectionDisplayed(String addfilesverfy) {
		return CommonFunctions.waitForElement(driver, addFilesSct).getText().contains(addfilesverfy);
	}

	public boolean hasAcceptBtnDisplayed(String accp) {
		CommonFunctions.scrollToElement(driver, accpBtn);
		return CommonFunctions.waitForElement(driver, accpBtn).getText().contains(accp);
	}

	public boolean hasAccpAndCloseBtnDisplayed(String acepclose) {
		return CommonFunctions.waitForElement(driver, accepClodeBtn).getText().contains(acepclose);
	}

	public boolean hasSaveBtnDisplayed(String savBtnVerfy) {
		return CommonFunctions.waitForElement(driver, saveBtn).getText().contains(savBtnVerfy);
	}

	public boolean hasWithdrawBtnDisplayed(String withdrawBtnVery) {
		return CommonFunctions.waitForElement(driver, withDrawBtn).getText().contains(withdrawBtnVery);
	}

	public boolean hasOperatorDisplayed(String operTxt) {
		return CommonFunctions.waitForElement(driver, operatorTransfer).getText().contains(operTxt);
	}

	public boolean hasWorkBasketFieldDisplayed(String workBasketTxt) {
		return CommonFunctions.waitForElement(driver, workBasketTransfer).getText().contains(workBasketTxt);
	}

	public boolean hasCancelButtonnDisplayed(String cancel) {
		return CommonFunctions.waitForElement(driver, cancelButton).getText().contains(cancel);
	}

	public boolean hasSubmitBtnDisplayed(String submit) {
		return CommonFunctions.waitForElement(driver, submitButton).getText().contains(submit);
	}

	public GSCRoutingPage submitBtnClick() {
		CommonFunctions.waitForElement(driver, submitButton).click();
		CommonFunctions.waitForAlert(driver);
		return new GSCRoutingPage(driver);
	}
	
	public GSCRoutingPage clkSubmitBtn() {
		CommonFunctions.waitForElement(driver, submitButton).click();
		
		return new GSCRoutingPage(driver);
	}

	public GSCRoutingPage operatorFiledDataInval(String oper) {
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, operater).clear();
		WebElement textBoxElement = CommonFunctions.waitForElement(driver, operater);
		textBoxElement.sendKeys(oper);
		textBoxElement.sendKeys(Keys.TAB);
		textBoxElement.sendKeys(Keys.ENTER);
		return new GSCRoutingPage(driver);
	}

	public GSCRoutingPage operatiorFiledDataValid(String oper) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, operater).clear();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, operater).sendKeys(oper);
		CommonFunctions.waitForElement(driver, operater).sendKeys(Keys.TAB);
		CommonFunctions.waitForElement(driver, operater).sendKeys(Keys.ENTER);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
//		WebElement textBoxElement = CommonFunctions.waitForElement(driver, operater);
//		textBoxElement.clear();
//		textBoxElement.sendKeys(oper);
//		textBoxElement.sendKeys(Keys.TAB);
//		textBoxElement.sendKeys(Keys.ENTER);
		return new GSCRoutingPage(driver);
	}

	public GSCRoutingPage operatiorFiledData(String oper) {
		CommonFunctions.waitForElement(driver, operater).clear();
		CommonFunctions.waitForElement(driver, operater).sendKeys(oper);
		CommonFunctions.waitForElement(driver, operater).sendKeys(Keys.ARROW_DOWN);
		CommonFunctions.waitForElement(driver, modelAutoOptions);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, modelAutoOptions);
		try {
			if (modelAutoOptions.getText().contains(oper))
				modelAutoOptions.click();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new GSCRoutingPage(driver);
	}

	public boolean hasUserEnteredAlertDisplayed(String errorMesageVerfy) {
		return CommonFunctions.waitForElement(driver, errorMessage).getText().contains(errorMesageVerfy);
	}

	public boolean hasValidationMessgDisplayed(String valMesg) {
		return CommonFunctions.waitForElement(driver, validMessage).getText().contains(valMesg);
	}

	public GSCRoutingPage selectValFromWorkBasket(String workbaket) {
		CommonFunctions.waitForElement(driver, workBasketTranf).sendKeys(workbaket);
		CommonFunctions.waitForElement(driver, workBasketTranf).sendKeys(Keys.ARROW_DOWN);
		CommonFunctions.waitForElement(driver, modelAutoOptions);
		try {
			if (modelAutoOptions.getText().contains(workbaket))
				modelAutoOptions.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new GSCRoutingPage(driver);
	}

	public GSCRoutingPage selectWB() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.selectFromDropdownByIndex(driver, 10, workBasket);
		CommonFunctions.selectFromDropdownByIndex(driver, 10, workBasket);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, canBtn).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new GSCRoutingPage(driver);
	}

	public GSCRoutingPage clickonActionsSelectValTranWB(String wrkBask) {
		
//		CommonFunctions.waitForElement(driver, workBaskerforTrasWB).sendKeys(wrkBask);
//		workBasketTranf.sendKeys(Keys.ARROW_DOWN);
//		CommonFunctions.waitForElement(driver, operaterAutoOptions);
//		try {
//			if (operaterAutoOptions.getText().contains(wrkBask))
//				Thread.sleep(2500);
//			operaterAutoOptions.click();
//			Thread.sleep(2000);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		CommonFunctions.scrollSomeDown(driver);
		CommonFunctions.selectFromDropdown(driver, wrkBask, workBaskerforTrasWB);
		
		
		
		
		CommonFunctions.waitForElement(driver, transferBtn).click();
		return new GSCRoutingPage(driver);

	}
	public void selectOptionWithText(String textToSelect) {
		try {

			WebElement autoOptions = CommonFunctions.waitForElement(driver, operaterAutoOptions);
			//wait.until(ExpectedConditions.visibilityOf(autoOptions));
			List<WebElement> optionsToSelect = autoOptions.findElements(By.className("match-highlight"));
			for (WebElement option : optionsToSelect) {
				if (option.getText().equals(textToSelect)) {
					option.click();
					break;
				}
			}

		} catch (NoSuchElementException e) {
		} catch (Exception e) {
		}
	}

	public GSCRoutingPage selectValFromWorkBasketClikCancle(String workbaket) {
		CommonFunctions.waitForElement(driver, workBasketTranf).sendKeys(workbaket);
		workBasketTranf.sendKeys(Keys.ARROW_DOWN);
		CommonFunctions.waitForElement(driver, modelAutoOptions);
		try {
			if (modelAutoOptions.getText().contains(workbaket))
				modelAutoOptions.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, submit).click();
		return new GSCRoutingPage(driver);

	}

	public boolean hasCancelBtnDisplayed(String cancleButton) {
		return CommonFunctions.waitForElement(driver, canBtn).getText().contains(cancleButton);
	}

	public boolean hasTransferBtnDisplayed(String transferButton) {
		return CommonFunctions.waitForElement(driver, transfer).getText().contains(transferButton);
	}

	public boolean hasWorkBasektDisplayed() {
		return CommonFunctions.isElementExist(driver, workBasket);
	}

	public GSCRoutingPage AcceptAlert() {
		CommonFunctions.waitForAlert(driver);
		return new GSCRoutingPage(driver);
	}

	public boolean hasValidationMessageDisplayed() {
		return CommonFunctions.isElementExist(driver, mesage);
	}
	
	private GSCRoutingPage gscRoutingPage;
	
	
	public GSCRoutingPage getGscCaseId() {
		gscCaseID.get(Thread.currentThread().getId());
		return storeCaseId();

	}

	public GSCRoutingPage storeCaseId() {
		return  gscRoutingPage.getGscCaseId();

	}

	public GSCRoutingFilterSearchPage verifyCaseIdExistInTable(String caseId) {
		int count = 0;
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitForElement(driver, myCases).click();
		CommonFunctions.waitForElement(driver, caseTable);
		CommonFunctions.retryingFindElement(driver, caseTable);
		CommonFunctions.waitForElementsToReappear(driver, caseIdList);
		for (int i = 0; i < caseIdList.size(); i++) {
			if (caseIdList.get(i).getText().equalsIgnoreCase(caseId)) {
				caseIdList.get(i).getText();
				caseIdList.get(i).click();
				CommonFunctions.waitForAlert(driver);
				count++;
				break;
			}
		}

		return new GSCRoutingFilterSearchPage(driver);
	}

	
	
	

	public GSCRoutingPage clickOnCloseBtn() {
		CommonFunctions.waitForElement(driver, closeBtn).click();
		return new GSCRoutingPage(driver);
	}

	public boolean isResolvedCompletedStatusDisplayed() {
		return CommonFunctions.isElementExist(driver, resolvedCompleted);
	}
	
	
	@FindBy(xpath = "//span[@data-test-id=\"20141009112850013217103\"]")
	private WebElement caseID;
	
	@FindBy(xpath = "(//label[@data-stl=\"1\"])[8]")
	private WebElement caseClick;
	
	
	
	@FindBy(xpath = "//input[@data-test-id='201411181100280377101613']")
	private WebElement searchBox;
	
	@FindBy(xpath = "//iframe[@name='PegaGadget1Ifr']")
	private WebElement myCasesFrame;
	
	@FindBy(xpath = "//div//button[text()='Apply']")
	private WebElement applyButton;
	
	@FindBy(xpath = "//th[@sortfield='.pxRefObjectInsName']//a[@id='pui_filter']")
    private static WebElement filterMyCase;
	
	@FindBy(xpath = "(//span[@data-test-id=\"20160323044951077258530\"])[1]")
    private static WebElement caseIdClick;
	
	@FindBy(xpath = "//div[@data-test-id=\"201710031413550415704\"]")
    private static WebElement auditHis;
	

	
  
	@FindBy(xpath = "//table[@pl_prop_class='Assign-Worklist']")
	private WebElement myCaseTable;
	
	@FindBy(xpath = "//table[@id='RULE_KEY']//span[@aria-label='Close this tab']")
	private WebElement close;
	
	
	
	
	
	
		
	
	
	
	
	
	
	public boolean hasNewDraftStatusDisplayed(String newStatusDraftVerfy) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		switchToFrame();
		return CommonFunctions.waitForElement(driver, newDraft).getText().contains(newStatusDraftVerfy);
	}
	
	public GSCRoutingPage switchToFrame() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.switchToiFrameByWebElement(driver, iframe);
		
		return new GSCRoutingPage(driver);
	}
	
	public boolean hasGSCPageDisplayed(String gscPageText) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, gscPage).getText().contains(gscPageText);
	}
	
	public boolean isOwnedStatusDisplayed(String owned) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, ownedStatus).getText().contains(owned);
	}
	

	public GSCRoutingPage caseIdStote() {
		
		String test=CommonFunctions.waitForElement(driver, caseID).getText();
		String test1 = test.replace("(", " ");
		gscCaseIdNew = test1.replace(")", " ");
		return new GSCRoutingPage(driver);
	}
	
	public GSCRoutingPage clickAddCustomeInfo(String lastNme, String fisName, String country) {

		CommonFunctions.waitForElement(driver, gscAddCustInfoButton).click();
		CommonFunctions.switchToiFrameByWebElement(driver, frame);
		CommonFunctions.isElementExist(driver, customerSearchHeader);
		CommonFunctions.waitForElement(driver, customerLastName).sendKeys(lastNme);
		CommonFunctions.waitForElement(driver, customerFirstName).sendKeys(fisName);
		// state(state);
		CommonFunctions.scrollSomeDown(driver);
		CommonFunctions.waitForElement(driver, searchCustomers).click();
		CommonFunctions.waitForElement(driver, selectSearchDetails).click();
		return new GSCRoutingPage(driver);

	}
	
	public GSCRoutingPage clkProductInfoModel(String model) {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitAndSwitchToFrame(driver, iframeHomepage);
		CommonFunctions.scrollToWebElement(driver, addProdBtn);
		CommonFunctions.waitForElement(driver, addProdBtn).click();
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

		return new GSCRoutingPage(driver);
	}
	

	public GSCRoutingPage selFunctionalArea(String funcArea) {
		CommonFunctions.scrollToWebElement(driver, funArea);
		CommonFunctions.waitForElement(driver, funArea).sendKeys(funcArea);
		funArea.sendKeys(Keys.ARROW_DOWN);
		CommonFunctions.waitForElement(driver, modelAutoOptions);
		try {
			if (modelAutoOptions.getText().contains(funcArea))
				modelAutoOptions.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new GSCRoutingPage(driver);
	}

	public GSCRoutingPage selFunctionalCode(String functionCode) {
		CommonFunctions.scrollToWebElement(driver, funCode);
		CommonFunctions.waitForElement(driver, funCode).sendKeys(functionCode);
		funCode.sendKeys(Keys.ARROW_DOWN);
		CommonFunctions.waitForElement(driver, modelAutoOptions);
		try {
			if (modelAutoOptions.getText().contains(functionCode))
				modelAutoOptions.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new GSCRoutingPage(driver);
	}
	
	public GSCRoutingPage selPriority(String priority) {
		CommonFunctions.scrollSomeDown(driver);
		CommonFunctions.selectFromDropdown(driver, priority, priorityDD);
		return new GSCRoutingPage(driver);
	}

	public GSCRoutingPage selOrigin(String orig) {
		CommonFunctions.selectFromDropdown(driver, orig, originDD);
		return new GSCRoutingPage(driver);
	}

	public GSCRoutingPage entProblemDetailsSummary(String summ) {
		CommonFunctions.waitForElement(driver, summary).sendKeys(summ);
		return new GSCRoutingPage(driver);
	}
	
	public GSCRoutingPage selectWorkBasket() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.selectFromDropdownByIndex(driver, 10, workBasket);
		CommonFunctions.selectFromDropdownByIndex(driver, 10, workBasket);
		return new GSCRoutingPage(driver);

	}
	
	public GSCRoutingPage clickonAcceptBtn() {
		CommonFunctions.waitForElement(driver, acceptButton).click();
		return new GSCRoutingPage(driver);
	}
	
	public GSCRoutingPage clickonActionsSelectVal(String oper, String work) {
		CommonFunctions.waitForElement(driver, actions).click();
		CommonFunctions.waitForElement(driver, actionsFrame);
		CommonFunctions.waitForElement(driver, trasfCaseToInvidual).click();
		CommonFunctions.waitForElement(driver, trandHeader);
		WebElement operaterFiled=CommonFunctions.waitForElement(driver, operater);
		operaterFiled.sendKeys(oper);
		operaterFiled.sendKeys(Keys.TAB);
		operaterFiled.sendKeys(Keys.ENTER);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		WebElement textBoxElement = CommonFunctions.waitForElement(driver, workBasketTranf);
		textBoxElement.sendKeys(work);
		workBasketTranf.sendKeys(Keys.ARROW_DOWN);
		CommonFunctions.waitForElement(driver, operaterAutoOptions);
		try {
			if (operaterAutoOptions.getText().contains(work))
				Thread.sleep(2500);
			operaterAutoOptions.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, submitBtn).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new GSCRoutingPage(driver);
	}
	public GSCRoutingPage enterDataInCaseIdSchBox(String gscCaseIdNew) {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitForElement(driver, myCases).click();
		CommonFunctions.switchToiFrameByWebElement(driver, myCasesFrame);
		/*CommonFunctions.waitForElement(driver, filterMyCase).click();
		CommonFunctions.waitForElement(driver, searchBox).sendKeys(gscCaseIdNew);
		CommonFunctions.waitForElement(driver, applyButton).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		CommonFunctions.waitForElementClickable(driver, myCaseTable);
		//CommonFunctions.retryingFindElement(driver, myCaseTable);
		for(int i =0; i < caseIdList.size(); i++) {
			if(caseIdList.get(i).getText().equalsIgnoreCase(gscCaseIdNew)) {
				caseIdList.get(i).click();
				CommonFunctions.waitForAlert(driver);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				else {
					//System.out.println("No results are found");
					CommonFunctions.switchToDefaultFrame(driver);
					CommonFunctions.waitForElement(driver, caseClick).click();
					break;
				}
		
	
			}
		
		return new GSCRoutingPage(driver);
	}
	
public GSCRoutingPage clickAudit()  {
		
		switchToFrame();
		CommonFunctions.scrollToWebElement(driver, auditTrails);
		CommonFunctions.waitForElement(driver, auditTrails).click();
		CommonFunctions.scrollToWebElement(driver, auditHis);
		CommonFunctions.isElementExist(driver, auditHis);
		CommonFunctions.switchToDefaultFrame(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, caseClick).click();
		CommonFunctions.waitForElement(driver, close).click();
		//CommonFunctions.HiddenElements(driver, close).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new GSCRoutingPage(driver);
	}

public GSCRoutingPage clickHomeAndGSCbutton() {
	CommonFunctions.waitForElement(driver, homeBtn).click();
	CommonFunctions.waitForElement(driver, createGSCCaseTab).click();
	return new GSCRoutingPage(driver);

}
}
