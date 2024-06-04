package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class deleteQuotes {
	WebDriver driver;

	public deleteQuotes (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public @FindBy(xpath="//table[@class='hdrTabBg']//td//a[text()='Quotes']")
	WebElement quotesPage;
	
	public 	@FindBy(xpath="//td[@class='moduleName']")
	WebElement headerText;
	
	public void deleteQuotes(String dynamicValue) {
		driver.findElement(By.xpath("//a[text()='"+dynamicValue+"']/../../td[9]/a[text()='del']")).click();
				
	}
	
}
