package com.comcast.crm.campaigns;
/*
 * @author Raghavendra
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.AdvanceSearchPage;
import com.comcast.crm.objectrepositoryutility.CampaignInformationPage;
import com.comcast.crm.objectrepositoryutility.CampaignsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.MassEditPage;
import com.comcast.crm.objectrepositoryutility.MoreLinkPage;

public class Advance_Search extends BaseClass {
@Test
public void searchWithNameContainsInCampaignName() throws Throwable {
	HomePage hlib=new HomePage(driver);
	WebDriverUtility wlib= new WebDriverUtility();
	MoreLinkPage mlib=new MoreLinkPage(driver);
	CampaignsPage cplib=new CampaignsPage(driver);
	CampaignInformationPage cilib=new CampaignInformationPage(driver);
	ExcelUtility elib=new ExcelUtility();
	MassEditPage mplib=new MassEditPage(driver);
	AdvanceSearchPage aslib=new AdvanceSearchPage(driver);
	
	wlib.waitForPageToLoad(driver);
	
	//click on more link and campaigns link
	wlib.mousemoveOnElement(driver, hlib.getMorelink());
	WebElement campaignlink = mlib.getCampaignlink();
	mlib.getCampaignlink().click();
	
	//verifying page
	String currenttitle = driver.getTitle();
	System.out.println(currenttitle );
	boolean title=currenttitle.contains("Campaigns");
	Assert.assertEquals(title, true);
	
	//navigate to advance search
	cplib.getAdvanceSearchLink().click();
	
	//verifying page
		String pageheader =aslib.getAdvanceSearchtitle().getText();
		title=pageheader.contains("Advanced");
		Assert.assertEquals(title, true);
		
		//SELECT Campai gn options
	    String text=elib.getDataFromExcel("Campaigns", 10, 1);
		aslib.getCampaignNameDropdown().click();
		driver.findElement(By.xpath("//optgroup[@class=\"select\"]/option[text()='"+text+"']")).click();
		
		//select condition
		 String condition=elib.getDataFromExcel("Campaigns", 10, 2);
		 WebElement element=aslib.getConditionDropDown();
		 wlib.select(element, condition);
		 
		 text=elib.getDataFromExcel("Campaigns", 10, 3);
		 aslib.getTextfield().sendKeys(text);
		 
		 aslib.getSearchButton().click();
		 
		//verifying page
		 String campaignname=elib.getDataFromExcel("Campaigns", 10, 4);
			boolean campaignnametext=driver.findElement(By.xpath("//tbody//a[text()='"+campaignname+"']")).isDisplayed();
			Assert.assertEquals(campaignnametext, true);
}
}
