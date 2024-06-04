package com.comcast.crm.campaigns;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
/*
 * @author Raghavendra
 */
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CampaignInformationPage;
import com.comcast.crm.objectrepositoryutility.CampaignsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.MassEditPage;
import com.comcast.crm.objectrepositoryutility.MoreLinkPage;


public class MassEditForCampaign extends BaseClass {
@Test
public void  editCampaignStatusInMassEditThroughCampaigns() throws Throwable {
	HomePage hlib=new HomePage(driver);
	WebDriverUtility wlib= new WebDriverUtility();
	MoreLinkPage mlib=new MoreLinkPage(driver);
	CampaignsPage cplib=new CampaignsPage(driver);
	CampaignInformationPage cilib=new CampaignInformationPage(driver);
	ExcelUtility elib=new ExcelUtility();
	MassEditPage mplib=new MassEditPage(driver);
	
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
	driver.findElement(By.xpath("//a[@title=\"Campaigns\" and text()='"+campaignName+"']/../..//input")).click();
	cplib.getMassEditButton().click();
	//verifing page
	String headerText=mplib.getMasseditHeader().getText();
	title=headerText.contains("Mass Edit");
	Assert.assertEquals(title, true);
	
	//selecting status in mass edit page
	mplib.getCampaignStatusCheckbox();
	String text=elib.getDataFromExcel("Campaigns",7, 3);
	WebElement element=mplib.getCampaignStatusDropDown();
	wlib.select(element, text);
	mplib.getSavebutton().click();
	
	//verifying page
		 currenttitle = driver.getTitle();
		System.out.println(currenttitle );
	    title=currenttitle.contains("Campaigns");
		Assert.assertEquals(title, true);
}
}
