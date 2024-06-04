package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class navigationorganizationPage {
	WebDriver driver;
	public navigationorganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public 	@FindBy(xpath="//input[@name='subject']")
	WebElement subjectName;
	
public 	@FindBy(xpath="//input[@name='validtill']")
	WebElement ValidateDate;
	
public @FindBy(xpath="//input[@id='single_accountid']/../img")
	WebElement organizationName;

public 	@FindBy(xpath="//td[@class='moduleName']")
	WebElement headerText;

public @FindBy(xpath="//a[text()='More']")
WebElement moreOption;

public @FindBy(xpath="//a[text()='Quotes' and @id='more']")
WebElement Quotes;

}
