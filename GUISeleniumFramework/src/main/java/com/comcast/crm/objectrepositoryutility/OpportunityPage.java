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
	
	@FindBy(name = "search_text")
	private WebElement searchForEdt;

	@FindBy(id = "bas_searchfield")
	private WebElement searchFieldDD;

	@FindBy(xpath = "//input[contains(@value,\"Search Now\")]")
	private WebElement searchNowBtn;
	
	public WebElement getAddNewOppBtn() {
		return addNewOppBtn;
	}

	public WebElement getSearchForEdt() {
		return searchForEdt;
	}

	public WebElement getSearchFieldDD() {
		return searchFieldDD;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
}
