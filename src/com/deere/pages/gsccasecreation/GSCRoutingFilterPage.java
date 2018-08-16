package com.deere.pages.gsccasecreation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;

public class GSCRoutingFilterPage {

	@FindBy(xpath = "(//label[contains(text(),'Home')])[1]")
	private WebElement homePageTab;

	@FindBy(xpath = "(//*[@data-test-id='201708231545550244393669'])[1]")
	private WebElement filters;

	@FindBy(xpath = "//*[@name='$PpyDisplayHarness$pFilterOptList$gWG$pFilterOpt$l1$pPropertyName']")
	private WebElement workGroups;

	@FindBy(xpath = "//*[@id='RULE_KEY']/fieldset/div/div[2]/div/div/div/div/div")
	private WebElement subGroup;

	@FindBy(xpath = "(//input[@data-test-id='20180215124155099052369'])[1]")
	private WebElement subGroupSelection;

	@FindBy(xpath = "(//*[@class='buttonTdButton'])[1]")
	private WebElement subGroupSubmit;

	@FindBy(xpath = "(//*[@id='SelectCheckBox4'])[2]")
	private WebElement caseType;

	@FindBy(xpath = "//*[@data-test-id='20141008160437053510472']")
	private WebElement filterSubmit;

	@FindBy(xpath = "//span[@id='modaldialog_hd_title']")
	private WebElement filterPreferances;

	protected WebDriver driver;

	public GSCRoutingFilterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public GSCRoutingFilterPage clickWGQueueFilter() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, filters).click();
		return new GSCRoutingFilterPage(driver);
	}

	public GSCRoutingFilterPage clickFilter() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, filters).click();
		return new GSCRoutingFilterPage(driver);
	}

	public GSCRoutingFilterPage subGroupSubmitButton() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, subGroupSubmit).click();
		return new GSCRoutingFilterPage(driver);
	}

	public GSCRoutingFilterPage clickSubGroupSelection() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunctions.waitForElement(driver, subGroup).click();
		return new GSCRoutingFilterPage(driver);
	}

	public GSCRoutingFilterPage enterWorkBasket(String wbasket) {
		CommonFunctions.waitForElement(driver, workGroups).sendKeys(wbasket);
		return new GSCRoutingFilterPage(driver);
	}

	public GSCRoutingFilterPage selectSubGroups(String Subgroup) {
		CommonFunctions.waitForElement(driver, subGroupSelection).sendKeys(Subgroup);
		CommonFunctions.waitForElement(driver, subGroupSelection).click();

		return new GSCRoutingFilterPage(driver);
	}

	public boolean hasHomePageDisplayed() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, homePageTab);
	}

	public boolean hasFilterPreferancesDisplayed() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, filterPreferances);
	}

}