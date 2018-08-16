package com.deere.pages.isgcasecreation;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;
import com.deere.global.GlobalThings;
import com.deere.pages.gsccasecreation.GSCR4Page;
import com.deere.pages.gsccasecreation.ViewEmailZeacomPage;
import com.deere.pages.isgcasecreation.ISGCasePage;
import com.deere.pages.solutionsearch.SolutionSearchHomePage;

public class ISGCaseSearchPage extends GlobalThings {

	@FindBy(xpath = "//iframe[contains(@src,'SolutionSearchHome')]")
	private WebElement iframePegaGadget;

	@FindBy(xpath = "//input[@id='SolutionSummary'][contains(@name,'SolutionSummary')]")
	private WebElement searchTextBox;

	@FindBy(xpath = "//input[@id='CategoryString'][@title='Search Category']")
	private WebElement categoryTxtbox;

	@FindBy(xpath = "(//a[starts-with(@title,'New JDParts Case GSC')])[1]")
	private WebElement gscNewCaseMailLinkZeacom;

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

	@FindBy(xpath = "(//a[@class='Case_tools'])[2]")
	private WebElement gscNewCaseMailLink;

	@FindBy(name = "PegaGadget0Ifr")
	private WebElement iframePegaGadgetCaseSearch;

	@FindBy(xpath = "//*[@id='pySearchText']")
	private WebElement caseSearchBox;

	@FindBy(xpath = "//img[contains(@data-click,'pyWorkSearch')]")
	private WebElement caseSearchImgLink;

	@FindBy(xpath = "//span[@data-test-id='20180424084340049412218']")
	private WebElement gscWorkBasket;

	@FindBy(xpath = "//iframe[@id='PegaGadget1Ifr']")
	private WebElement iframePegaGadgetISG_Assertion;

	@FindBy(xpath = "(//*[@id='TABSPAN']/span/label)[2]")
	private WebElement gscCorrespondence;

	@FindBy(xpath = "//iframe[@name='PegaGadget1Ifr']")
	private WebElement iframe;

	@FindBy(xpath = "//td[contains(text(),'JohnDeere.com')]")
	private WebElement mailFrom;

	@FindBy(xpath = "//div[@class='pzbtn-rgt']/descendant::div[contains(text(),'Actions')]")
	private WebElement actionBtn;

	@FindBy(xpath = "//span[text()='Work Case']")
	private WebElement workCaseInActions;

	@FindBy(xpath = "//*[@data-test-id='201802011400580656111285']")
	private WebElement acceptButton;

	@FindBy(xpath = "/html/body/table[2]/tbody/tr/td/table[1]/tbody/tr[4]/td[2]")
	private WebElement mail_Subject;

	@FindBy(xpath = "//iframe[@name='PegaGadget1Ifr']")
	private WebElement iFrame1;

	@FindBy(xpath = "//*[@data-test-id='20150212053008079033139']")
	private WebElement caseLinkToMainPage;

	public static String ParentHandle;

	protected WebDriver driver;

	public ISGCaseSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public ISGCasePage frameSwitching() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitAndSwitchToFrame(driver, iframePegaGadgetISG_Assertion);
		return new ISGCasePage(driver);
	}

	public boolean hasCaseSearchHomePageDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitAndSwitchToFrame(driver, iframePegaGadgetCaseSearch);
		return CommonFunctions.isElementExist(driver, caseSearchBox);
	}

	public ISGCaseSearchPage enterCaseIDInCaseSearchBox(String caseId) {
		CommonFunctions.waitForElement(driver, caseSearchBox).sendKeys(caseId);
		return new ISGCaseSearchPage(driver);
	}

	public ISGCaseSearchPage enterCaseIDInCaseSearchBoxR4() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, caseSearchBox);
		CommonFunctions.waitForElement(driver, caseSearchBox).sendKeys(CaseID_R4Turf);
		return new ISGCaseSearchPage(driver);
	}

	public ISGCaseSearchPage clickCaseSearchImgLink() {
		CommonFunctions.waitForElement(driver, caseSearchImgLink).click();
		return new ISGCaseSearchPage(driver);
	}

	public ISGCaseSearchPage clickOnCaseLink() {
		CommonFunctions.waitForElement(driver, caseLinkToMainPage).click();
		return new ISGCaseSearchPage(driver);
	}

	public ISGCaseSearchPage clickOnWorkCaseOption() {
		CommonFunctions.waitForElement(driver, caseLinkToMainPage).click();
		return new ISGCaseSearchPage(driver);
	}

	public ISGCaseSearchPage clickCaseIdLink() {
		CommonFunctions.waitForElement(driver, caseLinkToMainPage).click();
		return new ISGCaseSearchPage(driver);
	}

	public boolean hasSolutionSearchHomePageDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitAndSwitchToFrame(driver, iframePegaGadget);
		return CommonFunctions.isElementExist(driver, searchTextBox);
	}

	public ISGCaseSearchPage switchToIFrame() {
		CommonFunctions.switchToiFrameByWebElement(driver, iframePegaGadgetCaseSearch);
		return new ISGCaseSearchPage(driver);
	}

	public boolean hasCategoryAutoOptionDisplayed(String category) {
		CommonFunctions.waitForElement(driver, categoryTxtbox).sendKeys(Keys.ARROW_DOWN);
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

	public SolutionSearchHomePage enterCategory(String category) {
		CommonFunctions.waitForElement(driver, categoryTxtbox).sendKeys(category);
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

	public SolutionSearchHomePage enterModel(String model) {
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

	public ISGCaseSearchPage clickCorrespondence() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.switchToiFrameByWebElement(driver, iframe);
		CommonFunctions.scrollSomeDown(driver);
		CommonFunctions.isElementExist(driver, gscCorrespondence);
		ParentHandle = driver.getWindowHandle();
		return new ISGCaseSearchPage(driver);
	}

	public ISGCaseSearchPage clickOnMail() {
		CommonFunctions.waitForElement(driver, gscNewCaseMailLink).click();
		return new ISGCaseSearchPage(driver);
	}

	public ViewEmailZeacomPage clickMailZeacom() {
		CommonFunctions.waitForElement(driver, gscNewCaseMailLinkZeacom).click();
		return new ViewEmailZeacomPage(driver);
	}

	public boolean hasMailWindowDisplayed() {

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.switchToNextWindow(driver);
		String ChildHandler = driver.getWindowHandle();
		System.out.println("driver switched to next window" + ChildHandler);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, mailFrom);
	}

	public boolean hasSubjectDisplayed() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, mail_Subject);

	}

	public ISGCasePage clickOnActionsBtn() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionBtn).click();
		return new ISGCasePage(driver);
	}

	public ISGCasePage clickOnActionsBtnForCaseSearch() {
		CommonFunctions.switchToiFrameByWebElement(driver, iFrame1);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionBtn).click();
		return new ISGCasePage(driver);
	}

	public ISGCasePage clickOnWorkCase() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public ISGCasePage switchToFrame1() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitAndSwitchToFrame(driver, iFrame1);
		return new ISGCasePage(driver);
	}

	public ISGCasePage navToISGCasePage() {
		CommonFunctions.waitForAlert(driver);
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitAndSwitchToFrame(driver, iFrame1);
		return new ISGCasePage(driver);
	}

	public ISGCaseSearchPage switchToMainPage() {
		driver.switchTo().window(ISGCasePage.ParentHandle);
		return new ISGCaseSearchPage(driver);
	}

	public ISGCaseSearchPage navDefaultWindow() {
		// driver.close();
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		return new ISGCaseSearchPage(driver);
	}

	public GSCR4Page clickCaseLinkGSCReportOnly() {
		CommonFunctions.waitForElement(driver, caseLinkToMainPage).click();
		return new GSCR4Page(driver);
	}
	
	public ISGCaseSearchPage navigateToCaseSearchPage() {
		return new ISGCaseSearchPage(driver);
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
