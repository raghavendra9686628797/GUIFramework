package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createQuotes {
	WebDriver driver;
	
	public createQuotes(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public 	@FindBy(xpath="//input[@name='subject']")
		WebElement subjectName;
		
	public 	@FindBy(xpath="//input[@name='validtill']")
		WebElement ValidateDate;
		
	public @FindBy(xpath="//input[@id='single_accountid']/../img")
		WebElement organizationName;
		
	public 	@FindBy(xpath="//a[contains(text(),'Organization Name')]/../../..//a[@id='1']")
		WebElement firstOrganization;
		
	public 	@FindBy(xpath="//textarea[@name='bill_street']")
		WebElement billingAddresss;
		
	public 	@FindBy(xpath="//textarea[@name='ship_street']")
		WebElement shippingAddress;
		
	public @FindBy(xpath="//input[@name='qty1']")
		WebElement Quantity;
		
	public 	@FindBy(xpath="//img[@title='Products']")
		WebElement products;
		
	public @FindBy(xpath="//a[contains(@id,'popup_product')]")
		WebElement productsCheckBox;
		
	public 	@FindBy(xpath="//td[@class='moduleName']")
		WebElement headerText;
		
	public @FindBy(xpath="//img[contains(@title,'Create Quote')]")
		WebElement plusButon;
	

	public @FindBy(xpath="//input[@title='Save [Alt+S]']")
	WebElement saveButton;
	
	public @FindBy(xpath="//span[@class='lvtHeaderText']")
	WebElement createdText;
}
