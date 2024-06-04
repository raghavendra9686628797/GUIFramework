package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createFilterPage {

	WebDriver driver;
	public createFilterPage(WebDriver driver) {
		this.driver=driver;
				PageFactory.initElements(driver, this);
	}
	public @FindBy(xpath="//a[contains(text(),'Create Filter')]")
	WebElement createFilter;
	
	public @FindBy(xpath="//input[@name='viewName']")
	WebElement viewName;
	
	 public @FindBy(xpath="//select[@id='column1']")
	WebElement subjectDropDown;
	 
	 public @FindBy(xpath="//select[@id='column2']")
	 WebElement QuoteStage;
	  
	 public @FindBy(xpath="//select[@id='column3']")
	 WebElement Organization;
	 
	 public @FindBy(xpath="//select[@id='column5']")
	 WebElement billingAddress;
	 
	 public @FindBy(xpath="//input[@name='button2' and @type='submit']")
	 WebElement saveButton;
	 
	 public @FindBy(xpath="//a[@class='hdrLink']")
	 WebElement headerText;
	 
	 public @FindBy(xpath="(//select[@id='viewname']/./option/following-sibling::option)[1]")
	 WebElement createdName;
	 
	 
}
