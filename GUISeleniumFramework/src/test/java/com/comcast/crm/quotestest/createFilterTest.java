package com.comcast.crm.quotestest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.createFilterPage;
import com.comcast.crm.objectrepositoryutility.quotesPage;
public class createFilterTest  extends BaseClass{
	@Test
	public void createFilter() throws Throwable {
		FileUtility file=new FileUtility();
		quotesPage qp=new quotesPage(driver);
		WebDriverUtility utility=new WebDriverUtility();
		ExcelUtility fetch=new ExcelUtility();
		String fetchHomeText=fetch.getDataFromExcel("Quotes", 19, 2);
		String pageVerification=utility.pageVerification(qp.headerText);
		
		//page verification
		Assert.assertEquals(fetchHomeText, pageVerification);
	
		utility.mousemoveOnElement(driver, qp.moreOption);
		

		utility.singleClick(qp.Quotes);
		String quotesText=fetch.getDataFromExcel("Quotes", 19, 3);

		String quotesPage=utility.pageVerification(qp.headerText);
		//page verification
		Assert.assertEquals(quotesText, quotesPage);
		createFilterPage cfp=new createFilterPage(driver);
		cfp.createFilter.click();
		String pageName=fetch.getDataFromExcel("Quotes", 19, 3);
		String navigatingName=	cfp.headerText.getText();
		
		Assert.assertEquals(pageName, navigatingName);
		String name=file.getDataFromPropertiesFile("username");
		JavaUtility ju=new JavaUtility();
		int num=	ju.getRandomNumber();
		String viewName=name+num;
		cfp.viewName.sendKeys(viewName);
		utility.select(cfp.subjectDropDown, 3);
		utility.select(cfp.QuoteStage, 2);
		utility.select(cfp.Organization, 4);
		utility.select(cfp.billingAddress, 6);
		cfp.saveButton.click();
		String generatedName=cfp.createdName.getText();
		System.out.println(generatedName);
		boolean flag=generatedName.contains(name);
		utility.waitForPageToLoad(driver);
		Thread.sleep(1000);
		Assert.assertEquals(flag, true);
	}

}
