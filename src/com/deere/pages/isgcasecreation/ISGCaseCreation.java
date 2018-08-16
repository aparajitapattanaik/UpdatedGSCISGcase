package com.deere.pages.isgcasecreation;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;

public class ISGCaseCreation {

	@FindBy(xpath = "//button[@data-test-id='20180201164005073171878']")
	private WebElement createIsgCase;

	@FindBy(xpath = "//iframe[@id='PegaGadget0Ifr']")
	private WebElement iframePegaGadgetISG;

	@FindBy(xpath = "(//i[@data-test-id='201512210438090148308293'])[1]")
	private WebElement addCustomerInfoLink;

	@FindBy(xpath = "//option[contains(text(),'Accept Offer')]")
	private List<WebElement> acceptOffer;

	@FindBy(xpath = "//option[contains(text(),'Activate')]")
	private List<WebElement> activate;

	@FindBy(xpath = "//option[contains(text(),'Add New Hardware')]")
	private List<WebElement> newHardware;

	@FindBy(xpath = "//option[contains(text(),'Deactivate')]")
	private List<WebElement> deactivate;

	@FindBy(xpath = "//option[contains(text(),'Decline Offer')]")
	private List<WebElement> declineOffer;

	@FindBy(xpath = "//option[contains(text(),'Decommission Transfer')] ")
	private List<WebElement> decommission;

	@FindBy(xpath = "//option[contains(text(),'Demo')]")
	private List<WebElement> demo;

	@FindBy(xpath = "//option[contains(text(),'Marketing Mirror')]")
	private List<WebElement> marketingMirror;

	@FindBy(xpath = "//option[contains(text(),'Normal Transfer')]")
	private List<WebElement> normalTransfer;

	@FindBy(xpath = "//option[contains(text(),'Preview Offer')]")
	private List<WebElement> previewOffer;

	@FindBy(xpath = "//option[contains(text(),'Publish Offer')]")
	private List<WebElement> publishOffer;

	@FindBy(xpath = "//option[contains(text(),'Reactivate')]")
	private List<WebElement> reactivate;

	@FindBy(xpath = "//option[contains(text(),'Reassign')]")
	private List<WebElement> reassign;

	@FindBy(xpath = "//option[contains(text(),'Refund Request')]")
	private List<WebElement> refundRequest;

	@FindBy(xpath = "//option[contains(text(),'Remove Offer')]")
	private List<WebElement> removeOffer;

	@FindBy(xpath = "//option[contains(text(),'Renew')]")
	private List<WebElement> renew;

	@FindBy(xpath = "//option[contains(text(),'Sync')]")
	private List<WebElement> sync;

	@FindBy(xpath = "//option[contains(text(),'Warranty Transfer')]")
	private List<WebElement> warrantyTransfer;
	
	@FindBy(xpath = "(//div[@class='field-item dataValueRead'])[3]")
	private WebElement newDraftStatus;

	@FindBy(name = "PegaGadget0Ifr")
	private WebElement iFrameHomepage;

	@FindBy(xpath = "(//i[@data-test-id='201512210438090148308293'])[1]")
	private WebElement addCustomerIcon;

	@FindBy(xpath = "(//label[contains(text(),'Home')])[1]")
	private WebElement homePageTab;

	@FindBy(xpath = "//select[@id='FunctionalIssue']")
	private WebElement actionTextBox;

	@FindBy(xpath = "//option[contains(text(),'Accept Offer')]")
	private List<WebElement> AcceptOffer;

	@FindBy(xpath = "//option[contains(text(),'Activate')]")
	private List<WebElement> Activate;

	@FindBy(xpath = "//option[contains(text(),'Decline Offer')]")
	private List<WebElement> DeclineOffer;

	@FindBy(xpath = "//option[contains(text(),'Demo')]")
	private List<WebElement> emo;

	@FindBy(xpath = "//option[contains(text(),'Marketing Mirror')]")
	private List<WebElement> MarketingMirror;

	@FindBy(xpath = "//option[contains(text(),'COMAR Issue')]")
	private List<WebElement> comarIssue;

	@FindBy(name = "PegaGadget0Ifr")
	private WebElement IframeHomepage;

	@FindBy(xpath = "(//i[@data-test-id='201512210438090148308293'])[1]")
	private WebElement AddcustomerIcon;

	@FindBy(xpath = "//span[@data-test-id='20150116110353086421138']")
	private WebElement createISG;

	@FindBy(xpath = "//span[contains(text(),'Refresh')]")
	private WebElement refresh;

	@FindBy(xpath = "//span[contains(text(),'Work Case')]")
	private WebElement workcase;

	@FindBy(xpath = "//span[contains(text(),'Print')]")
	private WebElement print;

	@FindBy(xpath = " (//button[@data-test-id='20180531073524008831831'])[1]")
	private WebElement withdrawButton;

	@FindBy(xpath = "(//button[contains(text(),'Cancel')])[1]")
	private WebElement cancelButton;

	@FindBy(xpath = "//div[@class='pzbtn-rgt']/descendant::div[contains(text(),'Actions')]")
	private WebElement actionButton;

	@FindBy(xpath = "(//button[@data-test-id='2018021409524402562359'])[1]")
	private WebElement submitButton;

	@FindBy(xpath = "//div[@class='content-item content-field item-3 remove-top-spacing remove-bottom-spacing remove-left-spacing remove-right-spacing']")
	private WebElement resolvedCompleted;

	@FindBy(xpath = "//div[@data-test-id='20141009112130085821433']")
	private WebElement finalMessage;

	protected WebDriver driver;

	public ISGCaseCreation(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public boolean hasHomePage() {

		try {

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// CommonFunctions.waitAndSwitchToFrame(driver, iframePegaGadget);
		return CommonFunctions.isElementExist(driver, homePageTab);

	}

	public boolean hasAcceptOfferDisplayed(String options) {
		try {

			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).click();
		// Call method for List of WebELEMENYS OF Actions

		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, AcceptOffer).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, AcceptOffer).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;

	}

	public boolean hasAddNewHardwareDisplayed(String options) {
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// CommonFunctions.selectFromDropdown(driver, Value, elmt);

		// CommonFunctions.waitForElement(driver, ActionTextbox).click();
		// Call method for List of WebELEMENYS OF Actions

		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, newHardware).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, newHardware).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;

	}

	public boolean hasComarIssueDisplayed(String options) {
		try {

			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, comarIssue).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, comarIssue).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;

	}

	public boolean hasDeactivateDisplayed(String options) {
		try {

			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, deactivate).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, deactivate).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;
	}

	public boolean hasDeclineDisplayed(String options) {
		try {

			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).click();
		// Call method for List of WebELEMENYS OF Actions

		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, DeclineOffer).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, DeclineOffer).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;
	}

	public boolean hasDecomissionDisplayed(String options) {
		try {

			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).click();

		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, decommission).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, decommission).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;
	}

	public boolean hasDemoDisplayed(String options) {
		try {

			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		CommonFunctions.waitForElement(driver, actionTextBox).click();

		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, demo).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, demo).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;

	}

	public boolean hasMarketingDisplayed(String options) {
		try {

			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		CommonFunctions.waitForElement(driver, actionTextBox).click();
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, MarketingMirror).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, MarketingMirror).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;
	}

	public boolean hasNormalTransfer(String options) {
		try {

			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).click();
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, normalTransfer).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, normalTransfer).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;

	}

	public boolean hasPreviewDisplayed(String options) {
		try {

			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).click();
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, previewOffer).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, previewOffer).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;

	}

	public boolean hasPublishDisplayed(String options) {
		try {

			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).click();
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, publishOffer).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, publishOffer).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;

	}

	public boolean hasReactivateDisplayed(String options) {
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).click();
		// Call method for List of WebELEMENYS OF Actions

		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, reactivate).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, reactivate).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;

	}

	public boolean hasReassignDisplayed(String options) {
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// CommonFunctions.selectFromDropdown(driver, Value, elmt);

		CommonFunctions.waitForElement(driver, actionTextBox).click();
		// Call method for List of WebELEMENYS OF Actions

		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, reassign).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, reassign).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;

	}

	public boolean hasRefund_RequestDisplayed(String options) {
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// CommonFunctions.selectFromDropdown(driver, Value, elmt);

		CommonFunctions.waitForElement(driver, actionTextBox).click();
		// Call method for List of WebELEMENYS OF Actions

		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, refundRequest).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, refundRequest).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;

	}

	public boolean hasRemove_offer(String options) {
		try {

			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// CommonFunctions.selectFromDropdown(driver, Value, elmt);

		CommonFunctions.waitForElement(driver, actionTextBox).click();
		// Call method for List of WebELEMENYS OF Actions

		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, removeOffer).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, removeOffer).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;

	}

	public boolean hasRenewDisplayed(String options) {
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// CommonFunctions.selectFromDropdown(driver, Value, elmt);

		CommonFunctions.waitForElement(driver, actionTextBox).click();
		// Call method for List of WebELEMENYS OF Actions

		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, renew).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, renew).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;

	}

	public boolean hasSyncDisplayed(String options) {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// CommonFunctions.selectFromDropdown(driver, Value, elmt);

		CommonFunctions.waitForElement(driver, actionTextBox).click();
		// Call method for List of WebELEMENYS OF Actions

		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, sync).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, sync).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;

	}

	public boolean hasWaranty_transfer(String options) {
		try {

			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// CommonFunctions.selectFromDropdown(driver, Value, elmt);

		CommonFunctions.waitForElement(driver, actionTextBox).click();
		// Call method for List of WebELEMENYS OF Actions

		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, warrantyTransfer).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, warrantyTransfer).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;

	}

	public ISGCaseCreation clickISGCaseButton() {
		try {

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, createIsgCase).click();
		return new ISGCaseCreation(driver);
	}

	public boolean hasISGPage() {

		CommonFunctions.waitAndSwitchToFrame(driver, iFrameHomepage);
		return CommonFunctions.isElementExist(driver, addCustomerIcon);
	}

	public boolean hasAcceptOffer(String options) {
		try {

			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).click();
		// Call method for List of WebELEMENYS OF Actions
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, acceptOffer).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, acceptOffer).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;

	}

	public boolean hasActivate(String options) {
		try {

			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, activate).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, activate).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;

	}

	public boolean hasAddNewHardware(String options) {
		try {

			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// CommonFunctions.selectFromDropdown(driver, Value, elmt);

		// CommonFunctions.waitForElement(driver, ActionTextbox).click();
		// Call method for List of WebELEMENYS OF Actions

		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, newHardware).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, newHardware).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;

	}

	public boolean hasComarIssue(String options) {
		try {

			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, comarIssue).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, comarIssue).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;
	}

	public boolean hasDeactivate(String options) {
		try {

			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// CommonFunctions.selectFromDropdown(driver, Value, elmt);

		// CommonFunctions.waitForElement(driver, ActionTextbox).click();
		// Call method for List of WebELEMENYS OF Actions

		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, deactivate).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, deactivate).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;
	}

	public boolean hasDecline(String options) {
		try {

			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// CommonFunctions.selectFromDropdown(driver, Value, elmt);

		CommonFunctions.waitForElement(driver, actionTextBox).click();
		// Call method for List of WebELEMENYS OF Actions

		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, declineOffer).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, declineOffer).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;
	}

	public boolean hasDecomission(String options) {
		try {

			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// CommonFunctions.selectFromDropdown(driver, Value, elmt);

		CommonFunctions.waitForElement(driver, actionTextBox).click();
		// Call method for List of WebELEMENYS OF Actions

		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, decommission).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, decommission).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;
	}

	public boolean hasNormal_TransferDisplayed(String options) {
		try {

			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// CommonFunctions.selectFromDropdown(driver, Value, elmt);

		CommonFunctions.waitForElement(driver, actionTextBox).click();
		// Call method for List of WebELEMENYS OF Actions

		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, normalTransfer).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, normalTransfer).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;

	}

	public boolean hasRemove_OfferDisplayed(String options) {
		try {

			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// CommonFunctions.selectFromDropdown(driver, Value, elmt);

		CommonFunctions.waitForElement(driver, actionTextBox).click();
		// Call method for List of WebELEMENYS OF Actions

		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, removeOffer).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, removeOffer).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;

	}

	public boolean hasWarantyTransferDisplayed(String options) {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// CommonFunctions.selectFromDropdown(driver, Value, elmt);

		CommonFunctions.waitForElement(driver, actionTextBox).click();
		// Call method for List of WebELEMENYS OF Actions

		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		for (int i = 0; i < CommonFunctions.waitForElements(driver, warrantyTransfer).size(); i++) {
			if (!CommonFunctions.waitForElements(driver, warrantyTransfer).get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;

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

	public boolean hasWithdrawPageDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, finalMessage);

	}

	public boolean hasNewDraftStatusDisplayed(String draft) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.waitForElement(driver, newDraftStatus).getText().contains(draft);

	}

	public ISGCaseCreation clickOnWithdraw() {
		CommonFunctions.waitForElement(driver, withdrawButton).click();
		return new ISGCaseCreation(driver);

	}

	public ISGCaseCreation clickOnCancel() {
		CommonFunctions.waitForElement(driver, cancelButton).click();
		return new ISGCaseCreation(driver);

	}

	public ISGCaseCreation clickOnAction() {
		CommonFunctions.waitForElement(driver, actionButton).click();
		return new ISGCaseCreation(driver);

	}

	public ISGCaseCreation clickSubmitButton() {
		CommonFunctions.waitForElement(driver, submitButton).click();
		return new ISGCaseCreation(driver);

	}

	public ISGCaseCreation hasResolvedWithdrawn() {
		CommonFunctions.waitForElement(driver, resolvedCompleted).click();
		return new ISGCaseCreation(driver);

	}

}
