package com.comcast.crm.quotestest;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.createQuotes;
import com.comcast.crm.objectrepositoryutility.navigationorganizationPage;

public class navigateToProducts extends BaseClass {
	@Test
	public void productsPage() throws Throwable {
		navigationorganizationPage nop=new navigationorganizationPage(driver);
		FileUtility file=new FileUtility();
		WebDriverUtility utility=new WebDriverUtility();
		JavaUtility jv=new JavaUtility();
		ExcelUtility fetch=new ExcelUtility();
		String fetchHomeText=fetch.getDataFromExcel("Quotes", 15, 2);
		String pageVerification=utility.pageVerification(nop.headerText);
		Assert.assertEquals(fetchHomeText, pageVerification);
		utility.mousemoveOnElement(driver, nop.moreOption);
		

		utility.singleClick(nop.Quotes);
		String quotesText=fetch.getDataFromExcel("Quotes", 15, 3);

		String quotesPage=utility.pageVerification(nop.headerText);
		
		//page verification
		Assert.assertEquals(quotesText, quotesPage);
		
		createQuotes cop=new createQuotes(driver);
		cop.plusButon.click();
		utility.scrollTillElement(driver, cop.products);
		cop.products.click();
		cop.products.click();
		//switch to Product Page
		String parentProduct=driver.getWindowHandle();
		Set<String>childWindow=driver.getWindowHandles();
		String productTile=null;
		for(String productWindow:childWindow) {
			productTile=driver.getTitle();
		}
		utility.switchToTabOnURL(driver, productTile);
		String newWindow=cop.headerText.getText();
		String fetchedText=fetch.getDataFromExcel("Quotes", 15, 4);
		Assert.assertEquals(newWindow, fetchedText);
		cop.productsCheckBox.click();
		driver.switchTo().window(parentProduct);
	}

}
