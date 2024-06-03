package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	WebDriver driver;

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title=\'Create Contact...\']")
	private WebElement createContactImg;
	
	@FindBy(name = "search_text")
	private WebElement searchForEdt;

	@FindBy(id = "bas_searchfield")
	private WebElement searchFieldDD;

	@FindBy(xpath = "//input[contains(@value,\"Search Now\")]")
	private WebElement searchNowBtn;

	public WebElement getSearchForEdt() {
		return searchForEdt;
	}

	public WebElement getSearchFieldDD() {
		return searchFieldDD;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public WebElement getCreateContactImg() {
		return createContactImg;
	}

}
