package com.comcast.crm.campaigns;
/**
 * 
 * @author Raghavendra
 *        
 *
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CampaignInformationPage;
import com.comcast.crm.objectrepositoryutility.CampaignsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.MoreLinkPage;

import junit.framework.Assert;

public class Create_Campaigns extends BaseClass{
@Test
public void createCampaignsTest() throws Throwable {
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
	
	//create new campaign
	cplib.getCreateCampaignIcon().click();
	String name=elib.getDataFromExcel("Campaigns", 1, 1);
	System.out.println("name="+name);
	cilib.getEditCampaignName().sendKeys(name);
	cilib.getSavebutton().click();
	
	//verifying page
	String cname=cilib.getEnterdCampaignName().getText();
	boolean vname=cname.contains(name);
	Assert.assertEquals(vname, true);
	
	
	
}
}
