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

public class navigateToOrganizationTest extends BaseClass {
	@Test
	public void organizationPageNavigation() throws Throwable {
		navigationorganizationPage nop=new navigationorganizationPage(driver);
		FileUtility file=new FileUtility();
		WebDriverUtility utility=new WebDriverUtility();
		JavaUtility jv=new JavaUtility();
		ExcelUtility fetch=new ExcelUtility();
		String fetchHomeText=fetch.getDataFromExcel("Quotes", 1, 2);
		String date=fetch.getDataFromExcel("Quotes", 4, 8);
		String pageVerification=utility.pageVerification(nop.headerText);
		System.out.println(pageVerification);
		Assert.assertEquals(fetchHomeText, pageVerification);
utility.mousemoveOnElement(driver, nop.moreOption);
		

		utility.singleClick(nop.Quotes);
		String quotesText=fetch.getDataFromExcel("Quotes", 1, 3);

		String quotesPage=utility.pageVerification(nop.headerText);
		
		//page verification
		Assert.assertEquals(quotesText, quotesPage);
		
		createQuotes cop=new createQuotes(driver);
		cop.plusButon.click();
		cop.organizationName.click();
		String parent=driver.getWindowHandle();
		Set<String>child=driver.getWindowHandles();
		String title = null;
		for(String window: child) {
		 title=driver.getTitle();
		}
		utility.switchToTabOnURL(driver, title);
		String newwindow=cop.headerText.getText();
		String windowName=fetch.getDataFromExcel("Quotes", 11, 4);
		//organizationPage Verification
		Assert.assertEquals(newwindow, windowName);
		cop.firstOrganization.click();
		utility.switchtoAlertAndAccept(driver);
		//Swtich Back to Parent Window
		driver.switchTo().window(parent);
	}

}
