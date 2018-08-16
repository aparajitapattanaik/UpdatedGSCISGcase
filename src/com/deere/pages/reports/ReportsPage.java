package com.deere.pages.reports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.deere.global.CommonFunctions;
import com.deere.global.GlobalThings;


public class ReportsPage extends GlobalThings {	

	@FindBy(xpath="//iframe[@name='PegaGadget0Ifr']")
	private WebElement iframePegaGadget;
	
	@FindBy(xpath="//a[contains(text(),'Workgroup Queue')]")
	private WebElement workGroupQueuesLink;
	
	@FindBy(xpath="//input[@id='CategoryString'][@title='Search Category']")
	private WebElement categoryTxtbox;

	 protected WebDriver driver;
		
	public ReportsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
		
	public boolean hasReportsPageDisplayed() {
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonFunctions.switchToDefaultFrame(driver);
		CommonFunctions.waitAndSwitchToFrame(driver, iframePegaGadget);
		return CommonFunctions.isElementExist(driver,workGroupQueuesLink );
	}
		
	public ReportsPage switchToIFrame() {
		CommonFunctions.switchToiFrameByWebElement(driver, iframePegaGadget);
		return new ReportsPage(driver);
	}
	
	//Click on WorkGroupQueue Link
	public TssWorkBasketDetailsPage clickOnWorkGroupQueueLink() {
		ParentHandle=driver.getWindowHandle();
		CommonFunctions.waitForElement(driver, workGroupQueuesLink).click();
		return new TssWorkBasketDetailsPage(driver);
	}
			
}
