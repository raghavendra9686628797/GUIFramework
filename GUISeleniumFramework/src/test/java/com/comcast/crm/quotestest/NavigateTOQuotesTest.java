package com.comcast.crm.quotestest;

import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.quotesPage;

import junit.framework.Assert;

public class NavigateTOQuotesTest extends BaseClass{
	@Test(groups = "SmokeTest")
	public void quotesPAge() throws Throwable {
		quotesPage qp=new quotesPage(driver);
		WebDriverUtility utility=new WebDriverUtility();
		ExcelUtility fetch=new ExcelUtility();
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
	}

}
