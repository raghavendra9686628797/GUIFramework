package com.comcast.crm.campaigns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CampaignInformationPage;
import com.comcast.crm.objectrepositoryutility.CampaignsMoreInformationpage;
import com.comcast.crm.objectrepositoryutility.CampaignsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.MassEditPage;
import com.comcast.crm.objectrepositoryutility.MoreLinkPage;

public class AddcontactToCampaign extends BaseClass {
	@Test
	public void add_Contact_To_Campaigns() throws Throwable {
		HomePage hlib=new HomePage(driver);
		WebDriverUtility wlib= new WebDriverUtility();
		MoreLinkPage mlib=new MoreLinkPage(driver);
		CampaignsPage cplib=new CampaignsPage(driver);
		CampaignInformationPage cilib=new CampaignInformationPage(driver);
		ExcelUtility elib=new ExcelUtility();
		MassEditPage mplib=new MassEditPage(driver);
		CampaignsMoreInformationpage cmplib=new CampaignsMoreInformationpage(driver);

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
		//click on campaign 
		String campaignName=elib.getDataFromExcel("Campaigns", 13, 1);
		System.out.println(campaignName);
		driver.findElement(By.xpath("//tbody//a[text()='"+campaignName+"' and @title='Campaigns']")).click();

		//verify page
		boolean header=cilib.getHeadertext().isDisplayed();
		Assert.assertEquals(true, header);
		//navigate to mor information page
		cilib.getMoreinformationLink().click();

		cmplib.getContactTabExpandButton().click();
		cmplib.getAddContactButton().click();

		//get data from excel
		String firstName=elib.getDataFromExcel("Campaigns", 13, 2);
		String lastName=elib.getDataFromExcel("Campaigns", 13, 3);
		String mobile=elib.getDataFromExcel("Campaigns", 13, 4);

		//enter excel data in contacts page
		cmplib.getEditFirstNameTextField().sendKeys(firstName);
		cmplib.getEditLastNameTextField().sendKeys(lastName);
		cmplib.getMobileTextField().sendKeys(mobile);
		
		cmplib.getSaveButton().click();
		//verify page
		boolean name=driver.findElement(By.xpath("//a[text()='"+firstName+"']")).isDisplayed();
		Assert.assertEquals(true, name);
	}
}
