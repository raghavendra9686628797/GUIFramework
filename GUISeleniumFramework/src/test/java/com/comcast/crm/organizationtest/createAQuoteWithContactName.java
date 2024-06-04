package com.comcast.crm.organizationtest;

import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreateNewProductPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.ProductsPage;

public class createAQuoteWithContactName extends BaseClass {
	
	@Test
	public void  user_is_able_to_add_a_note() throws Throwable
	{

		HomePage hp=new HomePage(driver);
		
		

		/* Create New Product*/
		//hp.getProductsLink().click();
		ProductsPage pp=new ProductsPage(driver);
		pp.getCreateProductImg().click();

		CreateNewProductPage cnp=new CreateNewProductPage(driver);
		String productName= eLib.getDataFromExcel("Products",1,1);
		cnp.getProductnameEdt().sendKeys(productName);
		cnp.getSaveBtn().click();
	}
}
