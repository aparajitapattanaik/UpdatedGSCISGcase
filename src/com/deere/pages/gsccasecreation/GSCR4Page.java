package com.deere.pages.gsccasecreation;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.deere.global.CommonFunctions;
import com.deere.global.CoreTestCase;
import com.deere.pages.isgcasecreation.ISGCaseSearchPage;





public class GSCR4Page extends CoreTestCase  {

	@FindBy(xpath = "//iframe[@name=\"PegaGadget0Ifr\"]")
	private WebElement iFramePegaGadget;
	
	@FindBy(xpath="//button[@data-test-id=\"201802140923560736151238\"][contains(text(),'Create GSC Case')]")
	private WebElement gscCaseReportOnly;

	@FindBy(xpath = "(//button[@data-test-id=\"2018021409524402562359\"])[1]")
	private WebElement submit;

	@FindBy(xpath = "(//button[@data-test-id=\"20180201140326025613196\"])[1]")
	private WebElement save;

	@FindBy(xpath = "//h2[contains(text(),'Problem Details')]")
	private WebElement problemDetails;

	@FindBy(xpath = "//input[@name=\"$PpyWorkPage$pCaseSummary\"]")
	private WebElement summary;

	@FindBy(xpath = "//select[@data-test-id=\"201802060658510010138182\"][@id=\"WorkbasketName\"]")
	private WebElement workBasket;

	@FindBy(xpath = "")
	private WebElement subGroup;

	@FindBy(xpath = "//select[@data-test-id=\"20180424083621000521988\"][@id=\"CaseType\"]")
	private WebElement caseType;

	@FindBy(xpath = "//select[@data-test-id=\"20180424083621000521988\"][@id=\"CaseType\"]")
	private List<WebElement> caseTypeSelector;

	@FindBy(xpath = "//option[@value=\"AgCC: R4 AgCC\"]")
	private WebElement caseTypeValueR4Agcc;

	@FindBy(xpath = "//option[@value=\"Turf: R4 Turf\"]")
	private WebElement caseTypeValueR4Turf;

	@FindBy(xpath = "//input[@data-test-id=\"20180424083814051622870\"][@id=\"CCCCaseNumber\"]")
	private WebElement cccCaseNumber;

	@FindBy(xpath = "//a[@data-test-id=\"20170908144733046212866\"][@name=\"CaseUpdatesSingleScreen_pyWorkPage_1\"]")
	private WebElement comments;

	@FindBy(xpath = "//a[@data-test-id=\"20170908144733046212866\"][@name=\"AddOrEditComment_pyWorkPage_1\"]")
	private WebElement internalComments;

	@FindBy(xpath = "(//i[@data-test-id='201512210438090148308293'])[2]")
	private WebElement addProductInfo;

	@FindBy(xpath = "(//i[@data-test-id='201512210438090148308293'])[1]")
	private WebElement gscAddCustInfoButton;

	@FindBy(xpath = "//iframe[@title=\"Rich Text Editor, PEGACKEDITOR1\"]")
	private WebElement iFrameComments;

	@FindBy(xpath = "//button[@data-test-id=\"20140919030420037410647\"]")
	private WebElement commentSubmit;

	@FindBy(xpath = "//body[@title=\"This is a rich text editor control.\"]")
	private WebElement commentBody;

	@FindBy(xpath = "//body[@title=\"This is a rich text editor control.\"]")
	private WebElement internalCommentBody;

	@FindBy(xpath = "//button[@data-test-id=\"20140919030420037410647\"]")
	private WebElement internalCommentSubmit;

	@FindBy(xpath = "//iframe[@title=\"Rich Text Editor, PEGACKEDITOR4\"]")
	private WebElement iFrameInternalComments;

	@FindBy(xpath = "//li[@tabgroupname='bd1a792e-128d-4c94-8ac7-70f846b2ed46'][starts-with(@title,'GSC')]")
	private WebElement gscCaseLink;

	@FindBy(xpath = "//*[@id='close']")
	private WebElement closeCase;

	@FindBy(xpath = "(//button[@data-test-id='20140827063806434'])[1]")
	private WebElement saveInCloseBox;

	@FindBy(xpath = "//span[contains(text(),'Home')]")
	private WebElement homeTab;

	@FindBy(xpath = "//a[@class='JD_Header_Link'][@title='Open Menu']")
	private WebElement openMenuDropDown;

	@FindBy(xpath = "//span[@id='TABSPAN']/span/label[text()='Home']")
	private WebElement homeBtn;

	@FindBy(xpath = "//label[text()='My Cases']")
	private WebElement myCasesLink;

	@FindBy(xpath = "//div[@uniqueid='yui-gen3']")
	private WebElement closePopup;

	@FindBy(xpath = "//iframe[@name='PegaGadget0Ifr']")
	private WebElement iFrameClose;

	@FindBy(xpath = "//div[@id='modaldialog_hd']/span[contains(text(),'Unsaved changes')]")
	private WebElement closePopupTitle;

	@FindBy(xpath = "(//div[contains(text(),'Resolved-Completed')])[1]")
	private WebElement resolvedCompleted;

	@FindBy(xpath = "//div[@class='pzbtn-rgt']/descendant::div[contains(text(),'Actions')]")
	private WebElement actionButton;

	@FindBy(xpath = "//*[@class=\"menu menu-format-standard menu-regular\"]/li[2]")
	private WebElement transferWB;

	@FindBy(xpath = "//iframe[@name=\"PegaGadget1Ifr\"]")
	private WebElement actionsIFrame;
	
	@FindBy(xpath = "//*[@data-test-id='20150212053008079033139']")
	private WebElement caseLinkToMainPage;

	String myWindowHandle;
    public static String gscCaseID;
	protected WebDriver driver;

	public GSCR4Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public boolean hasSubmitDisplayed() {
		return CommonFunctions.isElementExist(driver, submit);
	}

	public boolean hasSaveDisplayed() {
		return CommonFunctions.isElementExist(driver, save);
	}

	public boolean hasProblemDetailsDisplayed() {
		return CommonFunctions.isElementExist(driver, problemDetails);
	}

	public boolean hasSummaryDisplayed() {
		return CommonFunctions.isElementExist(driver, summary);
	}

	public boolean hasWorkBasketDisplayed() {
		return CommonFunctions.isElementExist(driver, workBasket);
	}

	public boolean hasCaseTypeDisplayed() {
		return CommonFunctions.isElementExist(driver, caseType);
	}

	public boolean hasCaseTypeValueR4AgccDisplayed() {
		return CommonFunctions.isElementExist(driver, caseTypeValueR4Agcc);
	}

	public boolean hasCaseTypeValueR4TurfDisplayed() {
		return CommonFunctions.isElementExist(driver, caseTypeValueR4Turf);
	}

	public boolean hasCCCCaseNumberDisplayed() {
		return CommonFunctions.isElementExist(driver, cccCaseNumber);
	}

	public boolean hasCommentsDisplayed() {
		return CommonFunctions.isElementExist(driver, comments);
	}

	public boolean hasInternalCommentsDisplayed() {
		return CommonFunctions.isElementExist(driver, internalComments);
	}

	// Switch to frame
	public GSCR4Page switchToIFrame() {

		// CommonFunctions.SwitchToDefaultFrame(driver);
		// System.out.println("switched to default frame");
		CommonFunctions.isElementExist(driver, iFramePegaGadget);
		System.out.println("switched to R4 frame");
		CommonFunctions.switchToiFrameByWebElement(driver, iFramePegaGadget);
		return new GSCR4Page(driver);
	}

	public GSCCaseCreationPage navigateToGSCCaseCreationPage() {
		return new GSCCaseCreationPage(driver);
	}

	// validate Auto options for Case Type
	public boolean hasCaseTypeValueDisplayed(String caseTypeValue) {
		// CommonFunctions.waitForElement(driver, ActionTextbox).click();
		CommonFunctions.waitForElement(driver, caseType).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, caseTypeSelector).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, caseTypeSelector).get(i).getText().contains(caseTypeValue)) {
				continue;
			} else {
				return true;
			}
		}
		return false;
	}

	// select case Type value as Turf
	public GSCR4Page selectCaseTypeValueTurf(String Value) {
		CommonFunctions.waitForElement(driver, caseType).sendKeys(Value);
		caseType.sendKeys(Keys.ARROW_DOWN);
		CommonFunctions.waitForElement(driver, caseTypeValueR4Turf);
		try {
			if (caseTypeValueR4Turf.getText().contains(Value))
				caseTypeValueR4Turf.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new GSCR4Page(driver);
	}

	public GSCR4Page clickComments(String comment) {
		CommonFunctions.waitForElement(driver, comments).click();
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitAndSwitchToFrame(driver, iFrameComments);
		CommonFunctions.waitForElement(driver, commentBody).sendKeys(comment);

		return new GSCR4Page(driver);
	}

	public GSCR4Page sendInternalComments(String internalComment) {
		CommonFunctions.waitForElement(driver, internalComments).click();
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitAndSwitchToFrame(driver, iFrameInternalComments);
		CommonFunctions.waitForElement(driver, internalCommentBody).sendKeys(internalComment);
		return new GSCR4Page(driver);
	}

	public GSCR4Page clickOnCommentSubmit() {
		CommonFunctions.waitForElement(driver, commentSubmit).click();
		return new GSCR4Page(driver);
	}

	public GSCR4Page clickOninternalCommentSubmit() {
		CommonFunctions.waitForElement(driver, commentSubmit).click();
		return new GSCR4Page(driver);
	}

	public GSCR4Page clickOnClose() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.isElementExist(driver, gscCaseLink);
		Actions action = new Actions(driver);
		action.moveToElement(closeCase).click().build().perform();
		return new GSCR4Page(driver);
	}

	public GSCR4Page clickSave() {
		CommonFunctions.waitForElement(driver, save).click();
		return new GSCR4Page(driver);
	}

	public GSCR4Page clickSaveInCloseBox() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.switchToiFrameByWebElement(driver, iFrameClose);
		CommonFunctions.isElementExist(driver, closePopupTitle);
		CommonFunctions.waitForElement(driver, saveInCloseBox).click();
		return new GSCR4Page(driver);
	}

	public GSCR4Page clickSubmit() {
		CommonFunctions.waitForElement(driver, submit).click();
		return new GSCR4Page(driver);
	}

	
	public boolean hasResolvedCompleted() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, resolvedCompleted);

	}

	public GSCR4Page clickonActionsR4Turf() {
		CommonFunctions.waitForElement(driver, actionButton).click();
		return new GSCR4Page(driver);
	}

	// Click on ISG Transfer Work Basket
	public GSCR4Page actions_ToTransferWBR4Turf() {
		CommonFunctions.waitForElement(driver, transferWB).click();
		return new GSCR4Page(driver);
	}

	// Switch to Actions frame
	public GSCR4Page switchToActionsIFrame() {
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.switchToiFrameByWebElement(driver, actionsIFrame);
		return new GSCR4Page(driver);
	}
	public GSCR4Page clickGSCCaseReportOnly() {
		CommonFunctions.waitForElement(driver, gscCaseReportOnly).click();
		return new GSCR4Page(driver);
	}

	public ISGCaseSearchPage navigateToCaseSearchPage() {
		return new ISGCaseSearchPage(driver);
	}
	
	

}
