package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPage {
	WebDriver driver;

	public EmailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="search_text")
	private WebElement searchEdt;
	
	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getFindBtn() {
		return findBtn;
	}

	public WebElement getFromEmailtxt() {
		return fromEmailtxt;
	}

	public WebElement getToEmailtxt() {
		return toEmailtxt;
	}

	public WebElement getSubjecttxt() {
		return subjecttxt;
	}
	@FindBy(name="find")
	private WebElement findBtn;
	
	@FindBy(xpath="//b[contains(.,\"From\")]/../following-sibling::td[2]")
	private WebElement fromEmailtxt;
	
	@FindBy(xpath="//b[contains(.,\"To\")]/../following-sibling::td[2]")
	private WebElement toEmailtxt;
	
	@FindBy(xpath="//b[contains(.,\"Subject\")]/../following-sibling::td[2]")
	private WebElement subjecttxt;

}
