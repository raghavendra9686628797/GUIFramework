package com.comcast.crm.quotestest;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.createQuotes;
import com.comcast.crm.objectrepositoryutility.deleteQuotes;
import com.comcast.crm.objectrepositoryutility.quotesPage;

public class deleteCreatedQuotesTest extends BaseClass {
static	String   subjectName =null;;
	@Test
	public void createQuotesPage() throws Throwable {
		
		FileUtility file=new FileUtility();
		 quotesPage qp=new quotesPage(driver);
				WebDriverUtility utility=new WebDriverUtility();
				JavaUtility jv=new JavaUtility();
				ExcelUtility fetch=new ExcelUtility();
			
				
	
		String Name=file.getDataFromPropertiesFile("username");
		int randomName=jv.getRandomNumber();
		subjectName=Name+randomName;
	
		
			//fetched data
		fetch.setDataIntoExcel("Quotes", 4, 4, subjectName);
			String quantity=fetch.getDataFromExcel("Quotes", 4,7 );
			String date=fetch.getDataFromExcel("Quotes", 4, 8);
			String fetchHomeText=fetch.getDataFromExcel("Quotes", 1, 2);
			String pageVerification=utility.pageVerification(qp.headerText);
			
			//page verification
			Assert.assertEquals(fetchHomeText, pageVerification);
		
			utility.mousemoveOnElement(driver, qp.moreOption);
			

			utility.singleClick(qp.Quotes);
			String quotesText=fetch.getDataFromExcel("Quotes", 1, 3);

			String quotesPage=utility.pageVerification(qp.headerText);
			
			//page verification
			Assert.assertEquals(quotesText, quotesPage);
			
			//object for createQuotes
			createQuotes cop=new createQuotes(driver);
			cop.plusButon.click();
			cop.subjectName.sendKeys(subjectName);
			cop.ValidateDate.sendKeys(date);
			cop.organizationName.click();
			String parent=driver.getWindowHandle();
			Set<String>child=driver.getWindowHandles();
			String title = null;
			for(String window: child) {
			 title=driver.getTitle();
			}
		
		cop.organizationName.click();
		//SWitch to child Window
		utility.switchToTabOnURL(driver, title);
		
		cop.firstOrganization.click();
		utility.switchtoAlertAndAccept(driver);
		//Swtich Back to Parent Window
		driver.switchTo().window(parent);
			String billAddress=fetch.getDataFromExcel("Quotes", 4, 5);
			String shipAddress=fetch.getDataFromExcel("Quotes", 4, 6);
			cop.billingAddresss.sendKeys(billAddress);
			cop.shippingAddress.sendKeys(shipAddress);
			//write back to the generateString 
			fetch.setDataIntoExcel("Quotes", 4, 4, subjectName);
			utility.scrollUntilElementIsVisible(driver, cop.products);
			cop.products.click();
			//switch to Product Page
	//String parentProduct=driver.getWindowHandle();
			Set<String>childWindow=driver.getWindowHandles();
			String productTile=null;
			for(String productWindow:childWindow) {
				productTile=driver.getTitle();
			}
			utility.switchToTabOnURL(driver, productTile);
			cop.productsCheckBox.click();
			driver.switchTo().window(parent);
			cop.Quantity.sendKeys(quantity);
			cop.saveButton.click();
			utility.waitForPageToLoad(driver);
			String savedName=utility.pageVerification(cop.createdText);
			Assert.assertTrue(true, savedName);
	}
	@Test(dependsOnMethods = "createQuotesPage")
	public void deleteQuotesPage() throws Throwable {
		deleteQuotes doq=new deleteQuotes(driver);
			
		WebDriverUtility utility=new WebDriverUtility();
		ExcelUtility fetch=new ExcelUtility();
		 quotesPage qp=new quotesPage(driver);
			//Perform's action

		utility.mousemoveOnElement(driver, qp.moreOption);
		

		utility.singleClick(qp.Quotes);
			String headerName=doq.headerText.getText();
			String fetchedName=fetch.getDataFromExcel("Quotes", 7, 3);
			Assert.assertEquals(headerName, fetchedName);
			doq.deleteQuotes(subjectName);
			utility.handleAlerts(driver);
			utility.verifyElementDisplayedOrNot(driver, "//a[text()='"+subjectName+"' and @title='Quotes']");
		
		
	}

}
