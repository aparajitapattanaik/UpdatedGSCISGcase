package com.deere.pages.reports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.deere.global.CommonFunctions;

public class TssWorkBasketDetailsPage {
	
	
	@FindBy(xpath="//span[@class='report_title']")
	private WebElement reportTitle;

	 protected WebDriver driver;
		
	public TssWorkBasketDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public boolean hasTssWorkBasketDetailsPageDisplayed() {
		
		CommonFunctions.switchToNextWindow(driver);
		return CommonFunctions.isElementExist(driver,reportTitle );
	}
	
	public ReportsPage switchToParentWindow() {
		driver.switchTo().window(ReportsPage.ParentHandle);
		return new ReportsPage(driver);
	}
	
	public  ReportsPage closeWindow(){
		driver.close();
		return new ReportsPage(driver);
	}
	
	
	
}
