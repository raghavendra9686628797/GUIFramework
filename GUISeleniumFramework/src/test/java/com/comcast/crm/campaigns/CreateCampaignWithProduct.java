package com.comcast.crm.campaigns;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
/**
 * 
 * @author Raghavendra
 *        
 *
 */
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CampaignInformationPage;
import com.comcast.crm.objectrepositoryutility.CampaignsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.MoreLinkPage;



public class CreateCampaignWithProduct extends BaseClass {
@Test
public void campaignWithProduct() throws Throwable {
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
	String name=elib.getDataFromExcel("Campaigns", 4, 1);
	System.out.println("name="+name);
	cilib.getEditCampaignName().sendKeys(name);
	
	String parentwindow=driver.getWindowHandle();
	//selecting product by switching driver focus to child window
	cilib.getAddProductIcon().click();
	String partialurl="module=Products&action=Popup&html=Popup_picker";
	wlib.switchToTabOnTitle(driver, partialurl);
	String prodName=elib.getDataFromExcel("Campaigns", 4, 2);
	driver.findElement(By.xpath("//a[contains(text(),'Product')]/../../..//a[text()='"+prodName+"']")).click();
	
	//switching focus back to parent window
	driver.switchTo().window(parentwindow);
	
	cilib.getSavebutton().click();
	//verifying page
			String cname=cilib.getEnterdCampaignName().getText();
			//System.out.println("verify="+cname+" "+name);
			
			boolean vname=cname.contains(name);
			Assert.assertEquals(vname, true);
	
	
}
}
