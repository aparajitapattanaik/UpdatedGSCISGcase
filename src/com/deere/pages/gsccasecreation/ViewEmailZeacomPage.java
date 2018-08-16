package com.deere.pages.gsccasecreation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;
import com.deere.global.GlobalThings;
import com.deere.pages.isgcasecreation.ISGCasePage;;

public class ViewEmailZeacomPage extends GlobalThings {

	@FindBy(xpath = "//iframe[@id='PegaGadget0Ifr']")
	private WebElement iFramePegaGadgetISG;

	@FindBy(xpath = "//td[contains(text(),'GSC@JohnDeere.com')]")
	private WebElement mailFrom;

	@FindBy(xpath = "//td[contains(text(),'copethomas@johndeere.com, tipaxenia@johndeere.com, zach.wright@ruletek.com, testinggscisg@gmail.com')]")
	private WebElement mailTo;

	protected WebDriver driver;

	public ViewEmailZeacomPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public boolean hasMailWindowZeacomDisplayed() {

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CommonFunctions.switchToNextWindow(driver);
		String ChildHandler = driver.getWindowHandle();
		//System.out.println("driver switched to next window" + ChildHandler);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CommonFunctions.isElementExist(driver, mailFrom);
	}

	public ISGCasePage SwitchToMainPage() {
		driver.switchTo().window(ISGCasePage.ParentHandle);
		return new ISGCasePage(driver);
	}

	public ViewEmailZeacomPage getOpenedCaseMessageZeacom() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		HTMLPageSourceCode = driver.getPageSource();
		CommonFunctions.assertTrue(HTMLPageSourceCode.contains("Please be informed, a customer has opened case"),
				"Message to customer is not displayed");
		return new ViewEmailZeacomPage(driver);
	}

	public ISGCasePage switchToMainPage() {
		driver.switchTo().window(ISGCasePage.ParentHandle);
		return new ISGCasePage(driver);
	}

}
