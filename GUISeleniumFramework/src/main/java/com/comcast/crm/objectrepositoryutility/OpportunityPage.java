package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author Asha R
 */
public class OpportunityPage {
	WebDriver driver;
	public OpportunityPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@alt=\"Create Opportunity...\"]")
	private WebElement addNewOppBtn;
	public WebElement getAddNewOppBtn() {
		return addNewOppBtn;
	}
	@FindBy(xpath = "//td[@class=\"moduleName\"]//a[text()='Opportunities']")
	private WebElement oppLink;
	public WebElement getOppLink() {
		return oppLink;
	}
	
	
}
