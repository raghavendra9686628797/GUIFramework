package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class ProductsPage {
	WebDriver driver;
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title=\"Create Product...\"]")
	private WebElement createProductImg;
	
	@FindBy(name="search_text")
	private WebElement searchForEdt;
	@FindBy(xpath = "//input[@class=\"crmbutton small delete\"]")
	WebElement deleteBtn;
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateProductImg() {
		return createProductImg;
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

	@FindBy(name="bas_searchfield")
	private WebElement searchFieldDD;
	
	@FindBy(xpath="//input[contains(@value,\"Search Now\")]")
	private WebElement searchNowBtn;
	
	public void deleteProduct(String productName) {
		try {
		HomePage hp=new HomePage(driver);
		WebDriverUtility wlib=new WebDriverUtility();
		hp.getProductsLink().click();
		driver.findElement(By.xpath("//a[text()='"+productName+"']/../..//input[@type=\"checkbox\"]")).click();//a[text()='SUV']/../..//input[@type="checkbox"]
		ProductsPage pp=new ProductsPage(driver);
		pp.getDeleteBtn().click();
		wlib.switchtoAlertAndAccept(driver);
		}
		catch (Exception e) {
		}
	}
}
