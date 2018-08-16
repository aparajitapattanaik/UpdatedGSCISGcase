package com.deere.pages.gsccasecreation;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.deere.global.CommonFunctions;

public class CaseCoding {

	@FindBy(xpath = "//button[@data-test-id='20180201163908004467353']")
	private WebElement createGSCcase;

	@FindBy(xpath = "(//label[contains(text(),'Home')])[1]")
	private WebElement homePageTab;

	@FindBy(xpath = "(//i[@data-test-id='201512210438090148308293'])[1]")
	private WebElement gscAddCustInfoButton;

	@FindBy(xpath = "//input[@id='FUNC_AREA_NM']")
	private WebElement caseCodingFunctionalArea;

	@FindBy(xpath = "(//span[text()='CCE'])[1]")
	private WebElement selectCaseCodingFunctionalArea;

	@FindBy(xpath = "//input[@id='FUNC_CODE_NM']")
	private WebElement caseCodingFunctionalCode;

	@FindBy(name = "PegaGadget0Ifr")
	private WebElement iFrameHomePage;

	@FindBy(xpath = "//select[@id='Action']")
	private WebElement actionTextBox;

	@FindBy(xpath = "//option[contains(text(),'Denied Assistance')]")
	private WebElement actionDeniedAssistance;

	@FindBy(xpath = "//option[contains(text(),'Documented Information')]")
	private WebElement actionDocumentedInformation;

	@FindBy(xpath = "//span[@data-test-id='20150116110353086421138']")
	private WebElement createCase;

	@FindBy(xpath = "//select[@data-test-id='20180424083132047413538']")
	private WebElement actionForwardedToFieldManager;

	@FindBy(xpath = "//option[contains(text(),'Forwarded to Legal')]")
	private WebElement actionForwardedLegal;

	@FindBy(xpath = "//option[contains(text(),'Forwarded to Legal and Safety')]")
	private WebElement actionForwardedToLegalAndSafety;

	@FindBy(xpath = "//option[contains(text(),'Forwarded to Other Deere Unit')]")
	private WebElement actionForwardedToOtherDeereUnit;

	@FindBy(xpath = "//option[contains(text(),'Forwarded to Tier 2')]")
	private WebElement actionTierTwo;

	@FindBy(xpath = "//option[contains(text(),'No Action/Response by Customer')]")
	private WebElement actionResponeCustomer;

	@FindBy(xpath = "//option[contains(text(),'Referred to Dealer')]")
	private WebElement actionReferredDealer;

	@FindBy(xpath = "//option[contains(text(),'Resolved by Customer')]")
	private WebElement actionResolvedCustomer;

	@FindBy(xpath = "//option[contains(text(),'Resolved by DTAC')]")
	private WebElement actionResolvedDTAC;

	@FindBy(xpath = "//option[contains(text(),'Resolved by Dealer')]")
	private WebElement actionResolvedDealer;

	@FindBy(xpath = "//option[contains(text(),'Resolved with Coupon')]")
	private WebElement actionResolvedCoupon;

	@FindBy(xpath = "//option[contains(text(),'Resolved with JD Promise')]")
	private WebElement actionResolvedJD;

	@FindBy(xpath = "//option[contains(text(),'Resolved with Special Allowance')]")
	private WebElement actionResolveSpecial;

	@FindBy(xpath = "//option[contains(text(),'Resolved with Warranty')]")
	private WebElement actionResolveWaranty;

	@FindBy(xpath = "//option[contains(text(),'Sent Free Part(s)')]")
	private WebElement actionSentFreeParts;

	@FindBy(xpath = "//option[contains(text(),'Sent free manual')]")
	private WebElement actionSentFreeManual;

	@FindBy(xpath = "//option[contains(text(),'Supplied Information')]")
	private WebElement actionSuppliedInformation;

	@FindBy(xpath = "(//i[@data-test-id='201512210438090148308293'])[2]")
	private WebElement gscAddProductInfoIcon;

	@FindBy(xpath = "//input[@id='DecalModel']")
	private WebElement gscModel;

	@FindBy(xpath = "(//span[text()='r/JD Miscellaneous Equipment'])[2]")
	private WebElement gscSelectedModel;

	@FindBy(xpath = "//button[@data-test-id='20140919030420037410647']")
	private WebElement gscProductInformationSubmitButton;

	protected WebDriver driver;

	public CaseCoding(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public boolean hasHomePageDisplayed() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, homePageTab);
	}

	
	public boolean hasGSCPageDisplayed() throws InterruptedException {
		CommonFunctions.waitAndSwitchToFrame(driver, iFrameHomePage);
		return CommonFunctions.isElementExist(driver, gscAddCustInfoButton);
	}

	public boolean hasActionDeniedAssistanceDisplayed(String msg) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).click();
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		if (CommonFunctions.waitForElement(driver, actionDeniedAssistance).getText().contains(msg)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isGSCPageDisplayed(String gsc) {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitAndSwitchToFrame(driver, iFrameHomePage);
		return CommonFunctions.waitForElement(driver, createCase).getText().contains(gsc);

		
	}

	
	public boolean hasActionOptionsDisplayed(String options) {
		try {

			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Select s = new Select(ActionTextbox);
		Select s = new Select(CommonFunctions.waitForElement(driver, actionTextBox));
		List<WebElement> Options = s.getOptions();

		for (int i = 0; i < Options.size(); i++) {
			if (!Options.get(i).getText().contains(options)) {
				continue;
			} else {
				return true;
			}
		}
		return false;
	}

	
	public boolean hasActionDocumentedInformationDisplayed(String msg) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		if (CommonFunctions.waitForElement(driver, actionDocumentedInformation).getText().contains(msg)) {
			return true;
		} else {
			return false;
		}
	}


	public boolean hasForwardedFieldManagerDisplayed(String msg) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		if (CommonFunctions.waitForElement(driver, actionForwardedToFieldManager).getText().contains(msg)) {
			return true;
		} else {
			return false;
		}
	}

	
	public boolean hasForwardedToLegalDisplayed(String legal) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		if (CommonFunctions.waitForElement(driver, actionForwardedLegal).getText().contains(legal)) {
			return true;
		} else {
			return false;
		}
	}


	public boolean hasDeereUnitDisplayed(String deereUnit) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		if (CommonFunctions.waitForElement(driver, actionForwardedToOtherDeereUnit).getText().contains(deereUnit)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasForwardedLegalSafetyDisplayed(String forwadLegal) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		if (CommonFunctions.waitForElement(driver, actionForwardedToLegalAndSafety).getText().contains(forwadLegal)) {
			return true;
		} else {
			return false;
		}
	}

	
	public boolean hasNoActionResponseDisplayed(String action) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		if (CommonFunctions.waitForElement(driver, actionResponeCustomer).getText().contains(action)) {
			return true;
		} else {
			return false;
		}
	}

	
	public boolean hasReferredDealerDisplayed(String referredDeler) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		if (CommonFunctions.waitForElement(driver, actionReferredDealer).getText().contains(referredDeler)) {
			return true;
		} else {
			return false;
		}
	}

	
	public boolean hasResolvedbyCustomerDisplayed(String text) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		if (CommonFunctions.waitForElement(driver, actionResolvedCustomer).getText().contains(text)) {
			return true;
		} else {
			return false;
		}
	}

	
	public boolean hasResolvedbyDealerDisplayed(String text) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		if (CommonFunctions.waitForElement(driver, actionResolvedDealer).getText().contains(text)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean hasResolvedbyDTACDisplayed(String text) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		if (CommonFunctions.waitForElement(driver, actionResolvedDTAC).getText().contains(text)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasResolvedwithCouponDisplayed(String text) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		if (CommonFunctions.waitForElement(driver, actionResolvedCoupon).getText().contains(text)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasResolvedwithSpecialAllowanceDisplayed(String text) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		if (CommonFunctions.waitForElement(driver, actionResolveSpecial).getText().contains(text)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasResolvedwithWarrantyDisplayed(String text) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		if (CommonFunctions.waitForElement(driver, actionResolveWaranty).getText().contains(text)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasSentfreeManualonDisplayed(String text) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		if (CommonFunctions.waitForElement(driver, actionSentFreeManual).getText().contains(text)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasSentFreePartDisplayed(String text) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		if (CommonFunctions.waitForElement(driver, actionSentFreeParts).getText().contains(text)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasSuppliedInformationDisplayed(String text) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		if (CommonFunctions.waitForElement(driver, actionSuppliedInformation).getText().contains(text)) {
			return true;
		} else {
			return false;
		}
	}

	
	public boolean hasResolvedwithJDPromiseDisplayed(String text) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		if (CommonFunctions.waitForElement(driver, actionResolvedJD).getText().contains(text)) {
			return true;
		} else {
			return false;
		}
	}

	
	public boolean hasForwardedTier2Displayed(String text) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, actionTextBox).sendKeys(Keys.ARROW_DOWN);
		if (CommonFunctions.waitForElement(driver, actionTierTwo).getText().contains(text)) {
			return true;
		} else {
			return false;
		}
	}
 

	public CaseCoding clickOnGSCCase() {
		try {
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, createGSCcase).click();
		// CommonFunctions.switchToiFrameByIDOrName(driver, "IframeHomepage");
		return new CaseCoding(driver);
	}

	
	public CaseCoding clickonAddProductInfo() throws InterruptedException {
		Thread.sleep(3000);
		CommonFunctions.waitForElement(driver, gscAddProductInfoIcon).click();
		return new CaseCoding(driver);
	}

	
	public CaseCoding enterProductModel(String model) {
		CommonFunctions.waitForElement(driver, gscModel).sendKeys(model);
		return new CaseCoding(driver);
	}

	
	public CaseCoding clickAddProductSubmit() {
		CommonFunctions.waitForElement(driver, gscProductInformationSubmitButton).click();
		return new CaseCoding(driver);
	}

	
	public CaseCoding enterCaseCodingFA(String FArea) {
		CommonFunctions.waitForElement(driver, caseCodingFunctionalArea).sendKeys(FArea);
		return new CaseCoding(driver);
	}

	
	public CaseCoding enterCaseCodingFC(String FCode) {
		CommonFunctions.waitForElement(driver, caseCodingFunctionalCode).sendKeys(FCode);
		return new CaseCoding(driver);
	}

	public CaseCoding caseCodingClickHomePageLink() {
		CommonFunctions.waitForElement(driver, homePageTab).click();
		return new CaseCoding(driver);

	}
}
