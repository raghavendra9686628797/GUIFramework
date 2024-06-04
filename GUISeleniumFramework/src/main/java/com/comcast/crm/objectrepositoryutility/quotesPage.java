package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
public @FindBy(xpath="//a[@class='hdrLink']")
 WebElement headerText;
}
