package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * elements related to quote page
 * created by - jhanvi
 */

public class quotesPage {
	WebDriver driver;
public quotesPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

  public @FindBy(xpath="//a[text()='More']")
  WebElement moreOption;
  public @FindBy(xpath="//a[text()='Quotes' and @id='more']")
  WebElement Quotes;
  
  public @FindBy(xpath="//span[@class='lvtHeaderText']")
  WebElement headerMessage;
  
  public @FindBy(xpath="//input[@name='subject']")
  WebElement subjectTextfield;
  
  public @FindBy(xpath="//textarea[@name='bill_street']")
  WebElement billingAddressTextarea;
  
  public @FindBy(xpath="//textarea[@name='ship_street']")
  WebElement shippingAddressTextarea;
  
  public @FindBy(xpath="//img[@id='searchIcon1']")
  WebElement searchIcon1;
  
  public @FindBy(xpath="//input[@id='qty1']")
  WebElement qtyTextfiled;
  
  public @FindBy(xpath="//input[@name='search_text']")
  WebElement searchBasicModeTexfield;
  
  public @FindBy(xpath="//input[@name='search']")
  WebElement searchNowButton;
  
  public WebElement getheaderMessage() {
		return headerMessage;
	}
  
  public WebElement getsubjectTextfield() {
		return subjectTextfield;
	}
  
  public WebElement getbillingAddressTextarea() {
		return billingAddressTextarea;
	}
  
  public WebElement getshippingAddressTextarea() {
		return shippingAddressTextarea;
	}
  
  public WebElement getsearchIcon1() {
		return searchIcon1;
	}
  
  
  public WebElement getqtyTextfiled() {
		return qtyTextfiled;
	}
  
  public WebElement getsearchBasicModeTexfield() {
		return searchBasicModeTexfield;
	}
  
  public WebElement getsearchNowButton() {
		return searchNowButton;
	}
}
