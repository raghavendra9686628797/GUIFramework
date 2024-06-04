package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityMoreInfoPage {
	WebDriver driver;
	public OpportunityMoreInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@title=\"Add Document\"]") private WebElement addDocBtn;
	public WebElement getAddDocBtn() {
		return addDocBtn;
	}
	@FindBy(xpath = "//input[@title=\"Add Quote\"]") private WebElement addQuoteBtn;
	public WebElement getAddQuoteBtn() {
		return addQuoteBtn;
	}
@FindBy(xpath = "//span[@class=\"lvtHeaderText\"]") private WebElement headerTxt;
public WebElement getHeaderTxt() {
	return headerTxt;
}

}
