package com.comcast.crm.campaigns;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CampaignInformationPage;
import com.comcast.crm.objectrepositoryutility.CampaignsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.MoreLinkPage;

import junit.framework.Assert;

public class MassEditForCampaign extends BaseClass {
@Test
public void  editCampaignStatusInMassEditThroughCampaigns() throws Throwable {
	HomePage hlib=new HomePage(driver);
	WebDriverUtility wlib= new WebDriverUtility();
	MoreLinkPage mlib=new MoreLinkPage(driver);
	CampaignsPage cplib=new CampaignsPage(driver);
	CampaignInformationPage cilib=new CampaignInformationPage(driver);
	ExcelUtility elib=new ExcelUtility();
	
	
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
	String campaignName = elib.getDataFromExcel("Campaigns", 1, 1);
	driver.findElement(By.xpath("//a[text()='Campaign Name']/../../..//a[text()='"+campaignName+"']")).click();
}
}
