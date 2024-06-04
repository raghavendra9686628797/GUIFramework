package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * elements related to quotes page 
 * created by - jhanvi
 */

public class QuotesPage {
	WebDriver driver;

	public QuotesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement headerMessage;
	
	@FindBy(xpath ="//input[@name='subject']")
	private WebElement subjectTextfield;
	

	@FindBy(xpath ="//textarea[@name='bill_street']")
	private WebElement billingAddressTextarea;
	
	@FindBy(xpath ="//textarea[@name='ship_street']")
	private WebElement shippingAddressTextarea;
	
	@FindBy(xpath ="//img[@id=\"searchIcon1\"]")
	private WebElement searchIcon;
	
	@FindBy(xpath ="//input[@name='search_text']")
	private WebElement searchBasicModeTexfield;
	
	@FindBy(xpath ="//input[@name='search']")
	private WebElement searchNowButton;
	
	@FindBy(xpath ="//input[@id=\"qty1\"]")
	private WebElement qtyTextfiled;
	
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
		return searchIcon;
	}
	
	public WebElement getsearchBasicModeTexfield() {
		return searchBasicModeTexfield;
	}
	
	public WebElement getsearchNowButton() {
		return searchNowButton;
	}

	public WebElement getqtyTextfiled() {
		return qtyTextfiled;
	}

}