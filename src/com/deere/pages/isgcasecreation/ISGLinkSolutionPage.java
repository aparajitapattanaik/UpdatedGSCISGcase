package com.deere.pages.isgcasecreation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;

public class ISGLinkSolutionPage {

	@FindBy(xpath = "//table[@id='RULE_KEY'][@aria-label='Workgroup Queue']")
	private WebElement workGroupQueue;

	@FindBy(xpath = "//span[@data-test-id='20141009112850013217103']")
	private WebElement caseIdVerify;

	@FindBy(xpath = "//table[@pl_prop_class='Assign-WorkBasket']")
	private WebElement caseTable;

	@FindBy(xpath = "//label[contains(text(),'ISG-')]")
	private List<WebElement> sizeISGCase;
	
	@FindBy(xpath = "//a[@data-test-id='20160503060128021717349']")
	private List<WebElement> recommentdId;

	@FindBy(xpath = "//table[@id='RULE_KEY'][@aria-label='Solution Search']")
	private WebElement soluSearch;

	@FindBy(xpath = "(//button[@data-test-id='20170614162426000640819'])[1]")
	private WebElement searchBtn;
	
	@FindBy(xpath = "(//a[@data-test-id='20160324082916014825607'])[1]")
	private WebElement solutionId;

	@FindBy(xpath = "//table[@data-test-id='201709191447440631401-layout']")
	private WebElement listOfSolu;

	@FindBy(xpath = "(//a[@data-test-id='201708041604420982125695'])[1]")
	private WebElement listSolu;

	@FindBy(xpath = "//span[@id='modaldialog_hd_title']")
	private WebElement linkSoluPopUp;

	@FindBy(xpath = "//iframe[@name='PegaGadget5Ifr']")
	private WebElement frame;

	@FindBy(xpath = "(//input[@data-test-id='201706121156570626322805'])[1]")
	private WebElement soluLang;

	@FindBy(xpath = "//div[@id='po0']")
	private WebElement soluLangFrame;

	@FindBy(xpath = "//tr[@data-test-id='201710030705450264275-R3']")
	private WebElement difflanguage;

	@FindBy(xpath = "(//input[@data-test-id='20170608181712065454824'])[3]")
	private WebElement sellanguageCheckbox;

	@FindBy(xpath = "(//button[@data-test-id=\"20170614162426000640819\"])[2]")
	private WebElement searchButton;

	@FindBy(xpath = "(//a[@data-test-id='201708041604420982125695'])[1]")
	private WebElement linkToCase;

	@FindBy(xpath = "//li[@section_index='8']")
	private WebElement caseTab;

	@FindBy(xpath = "(//button[@data-test-id=\"20170614162426000639748\"])[1]")
	private WebElement clearBtn;

	@FindBy(xpath = "//a[@title='Advanced Filters']")
	private WebElement filterLink;

	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitBtn;

	@FindBy(xpath = "//span[contains(text(),'Filter Preferences')]")
	private WebElement filterPreferences;

	@FindBy(xpath = "(//input[@data-test-id='201709231530290040900469'])[5]")
	private WebElement isgChckBox;

	@FindBy(xpath = "//button[@data-test-id='20141008160437053510472']")
	private WebElement submit;
	
	@FindBy(xpath = "//span[@data-test-id='201711161622040015382477']")
	private WebElement listCaseId;
	
	
	@FindBy(xpath = "//a[@data-test-id='201709261246180628244177']")
	private WebElement clearFilter;

	@FindBy(xpath = "//div[@node_name='CaseHeader']//span[@class='workarea_header_id']")
	private WebElement isgCaseID;

	@FindBy(xpath = "//div[@id='modaldialog_hd']")
	private WebElement popHeader;

	@FindBy(xpath = "//*[@id=\"modaldialog_hd\"]")
	private WebElement popHeaderTwo;

	@FindBy(xpath = "//span[@id='modaldialog_hd_title']")
	private WebElement linkCaseId1;

	@FindBy(xpath = "(//*[@id='RULE_KEY']/tbody/tr/td[2]/span/label)[8]")
	private WebElement soluOpend;

	@FindBy(xpath = "//*[@id=\"nextButton\"]")
	private WebElement nextBtn;

	@FindBy(xpath = "//*[@id=\"backButton\"]")
	private WebElement backBtn;

	@FindBy(xpath = "//*[@id=\"submitButton\"]")
	private WebElement finBtn;
	
	
	
	@FindBy(xpath = "//input[@data-test-id='20170923174822053693855']")
	private WebElement caseIdTxtbox;

	@FindBy(xpath = "//a[contains(text(),'ISG-')]")
	private List<WebElement> sizeISGCasePopUp;

	@FindBy(xpath = "//div[@node_name='TSSAgentHome']")
	private WebElement homePage;

	@FindBy(xpath = "//button[@data-test-id='20151204140330064877245']")
	private WebElement lock;

	@FindBy(xpath = "(//span[@data-test-id=\"201802211054570002105727\"])[1]")
	private WebElement isgCustomer_MainPage_FirstName;

	@FindBy(xpath = "//input[@data-test-id='20170923174822053693855']")
	private WebElement txtBox;

	@FindBy(xpath = "//span[@data-test-id='201711161622040015382477']")
	private WebElement caseIdClick;

	@FindBy(xpath = "//iframe[@name=\"PegaGadget0Ifr\"]")
	private WebElement iFrame;

	@FindBy(xpath = "(//a[@data-test-id='20160324082916014825607'])[1]")
	private WebElement solutionClick;

	@FindBy(xpath = "//*[@id='RULE_KEY']/div[1]/div/div/div/div/div/div/div/div/div/div/div/div/div[1]/div/div")
	private WebElement actionClick;

	@FindBy(xpath = "//ul[@id='pyNavigation1509690005731']")
	private WebElement actionFrame;

	@FindBy(xpath = "//ul[@id='pyNavigation1509690005731']/li[1]")
	private WebElement actionLinksolu;

	@FindBy(xpath = "//ul[@id='pyNavigation1509690005731']/li[2]")
	private WebElement actionViewLang;

	@FindBy(xpath = "//ul[@id='pyNavigation1509690005731']/li[3]")
	private WebElement actionPrint;

	@FindBy(xpath = "//iframe[@id='PegaGadget5Ifr']")
	private WebElement iframe;

	@FindBy(xpath = "//tr[@data-test-id='201709290553370725472-R1']/following::span[contains(text(),'Recommended Solutions')]")
	private WebElement recmmdSolInLnkSol;

	@FindBy(xpath = "//tr[@data-test-id='201709290553370725472-R1']/following::div[contains(text(),'Language')][1]")
	private WebElement recmmdSolLangInLnkSol;

	@FindBy(xpath = "//tr[@data-test-id='201709290553370725472-R1']/following::div[contains(text(),'ID')][1]")
	private WebElement recmmdSolIDInLnkSol;

	@FindBy(xpath = "//tr[@data-test-id='201709290553370725472-R1']/following::div[contains(text(),'Description')][1]")
	private WebElement recmmdSolDescInLnkSol;

	@FindBy(xpath = "//tr[@data-test-id='201709290553370725472-R1']/following::span[contains(text(),'Link New Solution')][1]")
	private WebElement linkNewSolInLnkSol;

	@FindBy(xpath = "//tr[@data-test-id='201709290553370725472-R1']/following::div[contains(text(),'Language')][2]")
	private WebElement linkNewSolLangInLnkSol;

	@FindBy(xpath = "//tr[@data-test-id='201709290553370725472-R1']/following::div[contains(text(),'ID')][2]")
	private WebElement linkNewSolIDInLnkSol;

	@FindBy(xpath = "//tr[@data-test-id='201709290553370725472-R1']/following::div[contains(text(),'Description')][2]")
	private WebElement linkNewSolDescInLnkSol;

	@FindBy(xpath = "//tr[@data-test-id='201709290553370725472-R1']/following::div[contains(text(),'Link')][1]")
	private WebElement linkNewSolLinkInLnkSol;

	@FindBy(xpath = "(//img[@data-test-id='201708311300570164137193'])[1]")
	private WebElement linkBtnInLnkSol;

	@FindBy(xpath = "//a[@data-test-id='20160503060128021717349']")
	private WebElement solIDInISGCase;

	@FindBy(xpath = "//iframe[@name='PegaGadget0Ifr']")
	private WebElement frameSwitch;

	@FindBy(xpath = "//span[@id='modaldialog_hd_title']")
	private WebElement linlSoluPopUpHead;

	@FindBy(xpath = "//select[@data-test-id='20180424140126019614930']")
	private WebElement languDD;

	@FindBy(xpath = "//tr[@data-test-id='201709290553370725472-R1']")
	private WebElement caseOne;

	@FindBy(xpath = "//tr[@data-test-id='201709290553370725472-R2']")
	private WebElement caseTwo;

	@FindBy(xpath = "//tr[@data-test-id='201709290553370725472-R3']")
	private WebElement caseThree;

	@FindBy(xpath = "//tr[@data-test-id='201709290553370725472-R4']")
	private WebElement caseFour;

	@FindBy(xpath = "//tr[@data-test-id='201709290553370725472-R5']")
	private WebElement caseFive;

	@FindBy(xpath = "//table[@pl_prop_class='Code-Pega-Thread']")
	private WebElement linkTable;

	@FindBy(xpath = "//button[@id='nextButton']")
	private WebElement nextButton;

	@FindBy(xpath = "(//input[@data-test-id='20160611050517053825243'])[1]")
	private WebElement checkBox;

	@FindBy(xpath = "//div[@data-test-id='201801090214370877163806']")
	private WebElement message;

	@FindBy(xpath = "//a[@data-test-id='20160503060128021717349']")
	private WebElement solution;

	@FindBy(xpath = "//button[@id='submitButton']")
	private WebElement finishBtn;

	@FindBy(xpath = "//iframe[@id='PegaGadget2Ifr']")
	private WebElement LinkIframe;

	@FindBy(xpath = "(//a[@data-test-id='20160511062025000045972'])[1]")
	private WebElement caseNum;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Recommended")
	private WebElement recommnedSol;

	@FindBy(xpath = "//span[@id='modaldialog_hd_title']")
	private WebElement linkPopUp;

	@FindBy(id = "FUNC_AREA_NM")
	private WebElement ISGFunctionalArea;

	@FindBy(xpath = "//input[@id='FUNC_CODE_NM']")
	private WebElement isgFunctionalCode;

	@FindBy(xpath = "//span[text()='1602']")
	private WebElement isgFunctionalCode_Select;

	@FindBy(id = "CasePriority")
	private WebElement isgCase_Priority;

	@FindBy(id = "LanguageWithCode")
	private WebElement isgCaselanguagecode;

	@FindBy(id = "Origin")
	private WebElement isgCase_Origin;

	@FindBy(xpath = "(//input[@data-test-id='20170608181712065454824'])[2]")
	private WebElement engLangChkBx;

	@FindBy(xpath = "(//input[@data-test-id='20170608181712065454824'])[4]")
	private WebElement FrenchLangChkBx;

	@FindBy(xpath = "//*[@name='$PpyWorkPage$pCaseSummary']")
	private WebElement isgSummary;

	@FindBy(xpath = "(//button[@data-test-id='201802011400580656111285'])[1]")
	private WebElement isgAccept_Button;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "98516")
	private WebElement soluId;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Reinforcing Engine Cover to Prevent Cracks")
	private WebElement solDes;

	@FindBy(xpath = " //strong[contains(text(),'Publication Date')]")
	private WebElement publicationDate;

	@FindBy(xpath = " //strong[contains(text(),'Solution Number: 1234')]")
	private WebElement solutionNumber;

	@FindBy(xpath = " //strong[contains(text(),'Solution Summary: HBI-AX-1345 APR')]")
	private WebElement solutionSummary;

	@FindBy(xpath = "//div[@data-test-id='20171127073254009762390']")
	private WebElement linkSameLangPopUpMsg;

	@FindBy(xpath = "(//input[@data-test-id='201706121156570626322805'])[1]")
	private WebElement solLangDrpdwn;

	@FindBy(xpath = "(//button[@class='buttonTdButton'])[1]")
	private WebElement langSubBtn;

	@FindBy(xpath = "//tr[@data-test-id='201709290553370725472-R1']")
	private WebElement caseIDDrpdwn;

	@FindBy(xpath = "(//*[@id='RULE_KEY']/tbody/tr/td[2]/span/label)[8]")
	private WebElement caseId;

	@FindBy(xpath = "//div[@data-test-id='201801120045560378193546']")
	private WebElement linkOthrLangPopUpMsg;

	private static HashMap<Long, String> isgCaseIdTSS = new HashMap<Long, String>();

	public Iterator<String> caseiterator;
	public String checkbox;
	public String linkSolution;
	public String linksolutionNew;
	public Integer linksolustringconvertedToInt;

	protected WebDriver driver;

	public ISGLinkSolutionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public ISGLinkSolutionPage clickonWorkGroupQueue() {
		CommonFunctions.switchToDefaultFrame(driver);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, workGroupQueue).click();
		return new ISGLinkSolutionPage(driver);
	}

	public boolean hasWorkGroupQueueGridDisplayed() {
		return CommonFunctions.isElementExist(driver, caseTable);
	}
	
	public ISGLinkSolutionPage clickFilterLink() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, filterLink).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clearFilterLink();
		return new ISGLinkSolutionPage(driver);

	}
	



	public ISGLinkSolutionPage clearFilterLink() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, clearFilter).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ISGLinkSolutionPage(driver);
	}

	public ISGLinkSolutionPage chkIsg()  {
//		boolean checkBoxStatus = false;
//		checkBoxStatus = CommonFunctions.waitForElement(driver, isgChckBox).isSelected();
//		if (checkBoxStatus = true) {
//			CommonFunctions.waitForElement(driver, isgChckBox).click();
//		} else {
//			CommonFunctions.waitForElement(driver, isgChckBox).click();
//		}
		CommonFunctions.waitForElement(driver, isgChckBox).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, submit).click();
		return new ISGLinkSolutionPage(driver);
	}

	public String getIsgCaseId() {
		return isgCaseIdTSS.get(Thread.currentThread().getId());
	}

	public String setIsgCaseID() {
		return isgCaseIdTSS.put(Thread.currentThread().getId(),
				CommonFunctions.waitForElement(driver, isgCaseID).getText().replace("(", "").replace(")", ""));
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
	
	public ISGLinkSolutionPage storingSoluIdInToString() {
	linkSolution= CommonFunctions.waitForElement(driver, solutionId).getText();
    System.out.println(linkSolution.substring(0, 5));
    linksolutionNew=linkSolution.substring(0, 4);
     linksolustringconvertedToInt=Integer.valueOf(linksolutionNew);  
		return new ISGLinkSolutionPage(driver);
	}
	
	

	public ISGLinkSolutionPage selectLanguage() {
		CommonFunctions.waitForElement(driver, soluSearch).click();
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitAndSwitchToFrame(driver, frame);
		CommonFunctions.waitForElement(driver, soluLang).click();
		CommonFunctions.isElementExist(driver, soluLangFrame);
		CommonFunctions.isElementExist(driver, difflanguage);
		CommonFunctions.waitForElement(driver, sellanguageCheckbox).click();
		CommonFunctions.waitForElement(driver, searchButton).click();
		CommonFunctions.waitForElement(driver, linkToCase).click();
		return new ISGLinkSolutionPage(driver);
	}

	public boolean hasListOfSolutionsDisplayed() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitAndSwitchToFrame(driver, frame);
		return CommonFunctions.isElementExist(driver, listOfSolu);
	}

	public ISGLinkSolutionPage clickLinkSolution() {
		CommonFunctions.scrollToWebElement(driver, listSolu);
		WebElement element=CommonFunctions.waitForElement(driver, listSolu);
		Actions action = new Actions(driver).doubleClick(element);
		action.build().perform();
		return new ISGLinkSolutionPage(driver);
	}

	public boolean hasLinkSolutionInSameLanguagePopUpDisplayed(String popUpHeading) {
		return CommonFunctions.isElementExist(driver, linkSoluPopUp);
	}

	public static Iterator<String> iterator;

	public ISGLinkSolutionPage clickToOpenISGCase() {
		clickFilterLink();
		chkIsg();
		boolean breakIt = true;
		while (true) {
			breakIt = true;
			try {
				CommonFunctions.retryingFindElement(driver, caseTable);
				for (int i = 1; i <= 6; i++) {
					// terminate loop when i is 5.
					if (i == 6)
						break;
					//System.out.println("i: " + i);
					String caseIdNum = driver
							.findElement(By.xpath("(//span[@data-test-id='201711161622040015382477'])[" + i + "]"))
							.getText();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					driver.findElement(By.xpath("(//span[@data-test-id='201711161622040015382477'])[" + i + "]"))
							.click();

					try {
						Thread.sleep(3000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					Collection<String> Elements = new ArrayList<String>();
					Elements.add(caseIdNum);
					// System.out.println(Elements);
					iterator = Elements.iterator();
					// while loop
					while (iterator.hasNext()) {
						iterator.next();
						//System.out.println("value= " + iterator.next());
					}

					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					CommonFunctions.waitForElement(driver, workGroupQueue).click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					clickFilterLink();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					chkIsg();
				}
			} catch (Exception e) {
				if (e.getMessage().contains("element is not attached")) {
					breakIt = false;
				}
			}
			if (breakIt) {
				break;
			}
		}
		return new ISGLinkSolutionPage(driver);

	}

	public ISGLinkSolutionPage clickReleaseLock() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.switchToiFrameByWebElement(driver, frameSwitch);
		if (CommonFunctions.waitForElement(driver, lock).isDisplayed()) {
			CommonFunctions.waitForElement(driver, lock).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			CommonFunctions.switchToDefaultFrame(driver);
		} else if (CommonFunctions.waitForElement(driver, lock).isDisplayed() == false) {
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			CommonFunctions.isElementExist(driver, caseIdVerify);
			CommonFunctions.switchToDefaultFrame(driver);
		}

		CommonFunctions.switchToDefaultFrame(driver);
		return new ISGLinkSolutionPage(driver);

	}

	public ISGLinkSolutionPage isgCase_Origin(String orig) {
		CommonFunctions.waitAndSwitchToFrame(driver, languDD);
		CommonFunctions.selectFromDropdown(driver, orig, languDD);
		return new ISGLinkSolutionPage(driver);
	}

	public ISGLinkSolutionPage selectCheckBox() {
		CommonFunctions.isElementExist(driver, popHeader);
		int sizeOfISGCases = CommonFunctions.waitForElements(driver, sizeISGCasePopUp).size();
		System.out.println(sizeOfISGCases);
		for (int j = 0; j < sizeOfISGCases; j++) {
			if (j == sizeOfISGCases)
				break;
			String elementText = driver.findElements(By.xpath("//a[contains(text(),'ISG-')]")).get(j).getText();
			Collection<String> Elements = new ArrayList<String>();
			Elements.add(elementText);

			caseiterator = Elements.iterator();

			// while loop
			while (caseiterator.hasNext()) {
				System.out.println("value= " + caseiterator.next());
			}
		}
		boolean chkBoxStatus = false;
		chkBoxStatus = CommonFunctions.waitForElement(driver, checkBox).isSelected();
		if (chkBoxStatus = true) {
			CommonFunctions.waitForElement(driver, checkBox).click();
		} else {
			CommonFunctions.waitForElement(driver, checkBox).click();
		}
		checkbox = CommonFunctions.waitForElement(driver, caseNum).getText();
		CommonFunctions.waitForElement(driver, nextBtn).click();
		CommonFunctions.isElementExist(driver, popHeaderTwo);
		CommonFunctions.isElementExist(driver, backBtn);
		CommonFunctions.isElementExist(driver, finBtn);
		CommonFunctions.waitForElement(driver, backBtn).click();
		CommonFunctions.waitForElement(driver, nextBtn).click();
		CommonFunctions.isElementExist(driver, popHeaderTwo);
		CommonFunctions.isElementExist(driver, message);
		CommonFunctions.isElementExist(driver, backBtn);
		CommonFunctions.waitForElement(driver, finBtn).click();
		CommonFunctions.isElementExist(driver, linkSoluPopUp);
		return new ISGLinkSolutionPage(driver);
	}

	

	public ISGLinkSolutionPage comparerecentlyOpenedCasesInLinkSolution() {
		// Compare Two Iterators to over a Link List
		boolean same = true;
		while (iterator.hasNext()) {
			iterator.next();
		if (!iterator.next().equals(caseiterator.next())) {
				caseiterator.next();
			same = false;
				break;
			}
		}
		return new ISGLinkSolutionPage(driver);

	}

	public ISGLinkSolutionPage compareCaseIdsAndOpenCase() {
		// Compare Two Iterators to over a Link List
		boolean same = true;
		while (iterator.hasNext()) {
			iterator.next();
		if (!iterator.next().equals(checkbox)) {
				same = false;
				break;
			}
		}
		return new ISGLinkSolutionPage(driver);

	}

	public ISGLinkSolutionPage chkIsgCaseEnterDataIntoTxtFiled() {
		CommonFunctions.waitForElement(driver, isgChckBox).click();
		CommonFunctions.waitForElement(driver, txtBox).sendKeys(checkbox);
		CommonFunctions.waitForElement(driver, submit).click();
		return new ISGLinkSolutionPage(driver);
	}

	public ISGLinkSolutionPage openCase() {
		clickonWorkGroupQueue();
		clickFilterLink();
		chkIsgCaseEnterDataIntoTxtFiled();
		CommonFunctions.isElementExist(driver, caseIdClick);
		CommonFunctions.waitForElement(driver, caseIdClick).click();
		alertHandle();
		alertHandle();
		switchToFrame();
		return new ISGLinkSolutionPage(driver);

	}
	
	
	public ISGLinkSolutionPage solutionPresentedInRecommendedSolutions() {
		int	recommentdSoutionId=CommonFunctions.waitForElements(driver, recommentdId).size();
		System.out.println(recommentdSoutionId);
		for (int j = 0; j < recommentdSoutionId; j++) {
			if (j == linksolustringconvertedToInt)
				break;
		String elementText = driver.findElements(By.xpath("//a[@data-test-id='20160503060128021717349']")).get(j).getText();
		System.out.println(elementText);
		//CommonFunctions.isElementExist(driver, elementText);
		}
		return new ISGLinkSolutionPage(driver);

		}

	public ISGLinkSolutionPage switchToFrame() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.switchToiFrameByWebElement(driver, iFrame);

		return new ISGLinkSolutionPage(driver);

	}

	public ISGLinkSolutionPage alertHandle() {
		CommonFunctions.waitForAlert(driver);
		return new ISGLinkSolutionPage(driver);

	}

	public ISGLinkSolutionPage clickSolution() {
		CommonFunctions.waitForElement(driver, solutionClick).click();
		return new ISGLinkSolutionPage(driver);
	}

	public boolean hasSolutionOpend() {
		return CommonFunctions.isElementExist(driver, soluOpend);
	}

	public ISGLinkSolutionPage clickAction() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitAndSwitchToFrame(driver, iframe);
		// CommonFunctions.isElementExist(driver, actionClick);
		CommonFunctions.waitForElement(driver, actionClick).click();
		CommonFunctions.isElementExist(driver, actionFrame);
		CommonFunctions.isElementExist(driver, actionLinksolu);
		CommonFunctions.isElementExist(driver, actionViewLang);
		CommonFunctions.isElementExist(driver, actionPrint);
		CommonFunctions.waitForElement(driver, actionLinksolu).click();
		return new ISGLinkSolutionPage(driver);
	}

	private static String caseIdOne;

	public ISGLinkSolutionPage linksolutionPopUp() {
		CommonFunctions.isElementExist(driver, linlSoluPopUpHead);
		CommonFunctions.waitForElement(driver, checkBox).click();
		String caseIdOne = CommonFunctions.waitForElement(driver, caseNum).getText();
		System.out.println(caseIdOne);
		CommonFunctions.waitForElement(driver, nextButton).click();
		CommonFunctions.isElementExist(driver, message);
		CommonFunctions.waitForElement(driver, finishBtn).click();

		return new ISGLinkSolutionPage(driver);
	}

	public ISGLinkSolutionPage naviageToCase() {
		CommonFunctions.switchToDefaultFrame(driver);
		String caseNum = CommonFunctions.waitForElement(driver, caseId).getText();
		CommonFunctions.waitForElement(driver, caseId).click();
		CommonFunctions.isElementExist(driver, soluId);
		CommonFunctions.isElementExist(driver, solDes);
		return new ISGLinkSolutionPage(driver);
	}

	public boolean hasLinkSolutionDisplayed() {
		return CommonFunctions.isElementExist(driver, actionLinksolu);
	}

	public boolean hasViewLanguageDisplayed() {
		return CommonFunctions.isElementExist(driver, actionViewLang);

	}

	public boolean hasPrintDisplayed() {
		return CommonFunctions.isElementExist(driver, actionPrint);

	}

	public ISGLinkSolutionPage clickLinkSolutionOption() {
		CommonFunctions.waitForElement(driver, actionLinksolu).click();
		CommonFunctions.isElementExist(driver, linkPopUp);
		return new ISGLinkSolutionPage(driver);
	}

	public ISGLinkSolutionPage functionalarea(String category) {
		CommonFunctions.waitForElement(driver, ISGFunctionalArea).sendKeys(category);
		CommonFunctions.waitForElement(driver, ISGFunctionalArea).sendKeys(Keys.ARROW_DOWN);
		return new ISGLinkSolutionPage(driver);
	}

	public ISGLinkSolutionPage functionalCode(String category) {
		CommonFunctions.waitForElement(driver, isgFunctionalCode).sendKeys(category);
		CommonFunctions.waitForElement(driver, isgFunctionalCode).sendKeys(Keys.ARROW_DOWN);
		return new ISGLinkSolutionPage(driver);
	}

	public ISGLinkSolutionPage summary(String summary) {
		CommonFunctions.waitForElement(driver, isgSummary).sendKeys(summary);
		return new ISGLinkSolutionPage(driver);
	}

	public ISGLinkSolutionPage acceptButton() {

		CommonFunctions.waitForElement(driver, isgAccept_Button).click();
		return new ISGLinkSolutionPage(driver);
	}

	public boolean hasCustomerDetailsDisplayedInMainPage() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, isgCustomer_MainPage_FirstName);

	}

	public ISGLinkSolutionPage isgCase_Language(String language) {
		CommonFunctions.waitAndSwitchToFrame(driver, languDD);
		CommonFunctions.selectFromDropdown(driver, language, languDD);
		return new ISGLinkSolutionPage(driver);
	}

	public boolean hasHomePageDisplayed() {
		// TODO Auto-generated method stub
		return CommonFunctions.isElementExist(driver, homePage);
	}

	public ISGLinkSolutionPage clickLangInSol() {
		CommonFunctions.isElementExist(driver, solLangDrpdwn);
		Actions actions = new Actions(driver);
		actions.moveToElement(solLangDrpdwn).build().perform();
		actions.click(solLangDrpdwn).perform();
		CommonFunctions.waitForElement(driver, engLangChkBx).click();
		CommonFunctions.waitForElement(driver, FrenchLangChkBx).click();
		CommonFunctions.waitForElement(driver, langSubBtn).click();
		return new ISGLinkSolutionPage(driver);
	}

	public ISGLinkSolutionPage clickOnNextBtn() {
		CommonFunctions.waitForElement(driver, nextButton).click();
		return new ISGLinkSolutionPage(driver);
	}

	public ISGLinkSolutionPage clickCaseIDDrpdwn() {
		CommonFunctions.waitForElement(driver, caseIDDrpdwn).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ISGLinkSolutionPage(driver);
	}

	public ISGLinkSolutionPage clickLinkBtnInLnkSol() {
		CommonFunctions.waitForElement(driver, linkBtnInLnkSol).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ISGLinkSolutionPage(driver);
	}

	public boolean hasLinkSolPopHeaderDisplayed() {
		return CommonFunctions.isElementExist(driver, popHeader);
	}

	public boolean hasSearchBtnDisplayed() {
		return CommonFunctions.isElementExist(driver, searchBtn);
	}

	public boolean hasLinkSameLangPopUpMsgDisplayed() {
		return CommonFunctions.isElementExist(driver, linkSameLangPopUpMsg);
	}

	public boolean hasLinkOthrLangPopUpMsgDisplayed() {
		return CommonFunctions.isElementExist(driver, linkOthrLangPopUpMsg);
	}

	public boolean hasRecmmdSolInLnkSolDisplayed() {
		return CommonFunctions.isElementExist(driver, recmmdSolInLnkSol);
	}

	public boolean hasRecmmdSolLangInLnkSolDisplayed() {
		return CommonFunctions.isElementExist(driver, recmmdSolLangInLnkSol);
	}

	public boolean hasRecmmdSolIDInLnkSolDisplayed() {
		return CommonFunctions.isElementExist(driver, recmmdSolIDInLnkSol);
	}

	public boolean hasRecmmdSolDescInLnkSolDisplayed() {
		return CommonFunctions.isElementExist(driver, recmmdSolDescInLnkSol);
	}

	public boolean hasLinkNewSolInLnkSolDisplayed() {
		return CommonFunctions.isElementExist(driver, linkNewSolInLnkSol);
	}

	public boolean hasLinkNewSolLangInLnkSolDisplayed() {
		return CommonFunctions.isElementExist(driver, linkNewSolLangInLnkSol);
	}

	public boolean hasLinkNewSolIDInLnkSolDisplayed() {
		return CommonFunctions.isElementExist(driver, linkNewSolIDInLnkSol);
	}

	public boolean hasLinkNewSolDescInLnkSolDisplayed() {
		return CommonFunctions.isElementExist(driver, linkNewSolDescInLnkSol);
	}

	public boolean hasLinkNewSolLinkInLnkSolDisplayed() {
		return CommonFunctions.isElementExist(driver, linkNewSolLinkInLnkSol);
	}

	public ISGLinkSolutionPage clickFinishBtnInLnkSol() {
		CommonFunctions.waitForElement(driver, finishBtn).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ISGLinkSolutionPage(driver);
	}

	public ISGLinkSolutionPage clickCaseTab() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitForElement(driver, caseTab).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ISGLinkSolutionPage(driver);
	}

	public boolean hasValidateLinkedSolIDInISGCaseDisplayed() {
		CommonFunctions.waitAndSwitchToFrame(driver, frameSwitch);
		return CommonFunctions.isElementExist(driver, solIDInISGCase);
	}

	public boolean hasRecommendedSolutionsDisplayed(String recomm) {
		// TODO Auto-generated method stub
		return CommonFunctions.waitForElement(driver, recommnedSol).getText().contains(recomm);

	}

	public boolean hasSolutionsDisplayed() {
		// TODO Auto-generated method stub
		return CommonFunctions.isElementExist(driver, solution);
	}
	
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "1234")
	private WebElement idLinkText;
	
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "HBI-AX-1345 APR 21")
	private WebElement solDesRecomnded;
	
	public boolean hasSolutionIDRecomdedDisplayed(String string) {
		return CommonFunctions.isElementExist(driver, idLinkText);
	}
	
	public boolean hasSolutionDescriptionDisplayed(String string) {
		return CommonFunctions.isElementExist(driver, solDesRecomnded);
	}

}
