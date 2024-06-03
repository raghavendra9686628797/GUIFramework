package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author Asha R
 */
public class OpportunityInformationPage {
	WebDriver driver;
	public OpportunityInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")private WebElement headerTxt;
	@FindBy(xpath = "//a[text()='Create Invoice']") private WebElement createInvoiceLink;
	public WebElement getHeaderTxt() {
		return headerTxt;
	}
	public WebElement getCreateInvoiceLink() {
		return createInvoiceLink;
	}
	
}
