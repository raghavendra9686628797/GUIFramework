package com.comcast.crm.producttest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewProductPage;
import com.comcast.crm.objectrepositoryutility.CreateNewVendoraPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.ProductInformationPage;
import com.comcast.crm.objectrepositoryutility.ProductsPage;
import com.comcast.crm.objectrepositoryutility.VendorsPage;

public class CreateProductTest extends BaseClass{

	@Test
	public void Create_Product_With_Mandatory_Fields() throws Throwable {
		WebDriverUtility wlib=new WebDriverUtility();
		ExcelUtility elib=new ExcelUtility();
		/*Navigate to Home page*/
		HomePage hp=new HomePage(driver);
		hp.getProductsLink().isDisplayed();
		

		/* Create New Product*/
		hp.getProductsLink().click();
		ProductsPage pp=new ProductsPage(driver);
		pp.getCreateProductImg().click();

		CreateNewProductPage cnp=new CreateNewProductPage(driver);
		String productName=elib.getDataFromExcel("Products", 1, 1);
		cnp.getProductnameEdt().sendKeys(productName);
		cnp.getSaveBtn().click();
		/* Verify the Created product */
		
		ProductInformationPage Pip = new ProductInformationPage(driver);
		String hdrMsg = Pip.getHeaderMsg().getText();
		boolean getBoolean = hdrMsg.contains(productName);
		Assert.assertTrue(getBoolean);
		
	}
	@Test
	public void Create_Product_With_ProductCategory() throws Throwable {
		WebDriverUtility wlib=new WebDriverUtility();
		ExcelUtility elib=new ExcelUtility();
		/*Navigate to Home page*/
		HomePage hp=new HomePage(driver);
		hp.getProductsLink().isDisplayed();
		

		/* Create New Product with Vendor */
		hp.getProductsLink().click();
		ProductsPage pp=new ProductsPage(driver);
		pp.getCreateProductImg().click();

		CreateNewProductPage cnp=new CreateNewProductPage(driver);
		String productName=elib.getDataFromExcel("Products", 3, 1);
		cnp.getProductnameEdt().sendKeys(productName);
		
		wlib.select(cnp.getProductcategoryDD(),elib.getDataFromExcel("Products", 3, 2));
		cnp.getSaveBtn().click();
		/* Verify the Created product */
		
		ProductInformationPage Pip = new ProductInformationPage(driver);
		String hdrMsg = Pip.getHeaderMsg().getText();
		boolean getBoolean = hdrMsg.contains(productName);
		Assert.assertTrue(getBoolean);
		String pcategoryTxt=Pip.getProductCategoryTxt().getText().trim();
		Assert.assertEquals(elib.getDataFromExcel("Products", 3, 2), pcategoryTxt);
		
	}
	@Test
	public void create_Product_With_VendorName() throws Throwable {
		WebDriverUtility wlib=new WebDriverUtility();
		ExcelUtility elib=new ExcelUtility();
		/*Navigate to Home page*/
		HomePage hp=new HomePage(driver);
		hp.getProductsLink().isDisplayed();
		/* Create New Vendor */
		VendorsPage vp=new VendorsPage(driver);
		hp.getMoretLink().click();
		hp.getVendorsLink().isDisplayed();
		wlib.mousemoveOnElement(driver,hp.getVendorsLink());
		hp.getVendorsLink().click();
		vp.getCreateVendorImg().click();
		CreateNewVendoraPage cnv=new CreateNewVendoraPage(driver);
		String vendorName=elib.getDataFromExcel("Products", 5, 2);
		cnv.getVendornameEdt().sendKeys(vendorName);
		cnv.getSaveBtn().click();

		/* Create New Product with Vendor */
		hp.getProductsLink().click();
		ProductsPage pp=new ProductsPage(driver);
		pp.getCreateProductImg().click();

		CreateNewProductPage cnp=new CreateNewProductPage(driver);
		String productName=elib.getDataFromExcel("Products", 5, 1);
		cnp.getProductnameEdt().sendKeys(productName);
		cnp.getVendorSelectImg().click();

		/*Switch to vendors tab*/
		wlib.switchToTabOnURL(driver, "module=Vendors");
		vp.getSearchForedt().sendKeys(vendorName);
		vp.getSearchNowBtn().click();
		driver.findElement(By.xpath("//a[text()='"+vendorName+"']")).click();
		/*Switch to product tab*/
		
		wlib.switchToTabOnURL(driver, "module=Products");
		cnp.getSaveBtn().click();
		
		/* Verify the Created product with vendor */
		
		ProductInformationPage Pip = new ProductInformationPage(driver);
		String hdrMsg = Pip.getHeaderMsg().getText();
		boolean getBoolean = hdrMsg.contains(productName);
		Assert.assertTrue(getBoolean);
		String actVendorName = Pip.getVendorNameTxt().getText().trim();
		Assert.assertEquals(actVendorName, vendorName);
		
	}
	@Test(dependsOnMethods =  "Create_Product_With_Mandatory_Fields")
	public void Add_Organization_To_ExistedProduct() throws Throwable {
		WebDriverUtility wlib=new WebDriverUtility();
		ExcelUtility elib=new ExcelUtility();
		/*Navigate to Home page*/
		HomePage hp=new HomePage(driver);
		hp.getProductsLink().isDisplayed();
		/* Create New organization */
		hp.getOrgLink().click();
		CreatingNewOrganizationPage cno=new CreatingNewOrganizationPage(driver);
		JavaUtility jlib=new JavaUtility();
		int num=jlib.getRandomNumber();
		String orgName=elib.getDataFromExcel("Products", 7, 2)+num;
		cno.createOrg(orgName);

		/* Add organization to existed product */
		hp.getProductsLink().click();
		String productName=elib.getDataFromExcel("Products", 7, 1);
		driver.findElement(By.xpath("//a[text()='Product Name ']/../../..//a[text()='"+productName+"']")).click();

		ProductInformationPage pip = new ProductInformationPage(driver);
		/*Verify existed product information is displayed*/
		String hdrMsg = pip.getHeaderMsg().getText();
		boolean getBoolean = hdrMsg.contains(productName);
		Assert.assertTrue(getBoolean);
		
		pip.getmoreInformationBtn().isDisplayed();
		pip.getmoreInformationBtn().click();
		pip.getorganizationTable().isDisplayed();
		pip.getorganizationTable().click();
		pip.getselectOrganizationsBtn().click();
		
		wlib.switchToTabOnURL(driver, "module=Accounts");
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getSerchEdt().sendKeys(orgName);
		op.getSearchNowBtn().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		/*Verify organization is added to product*/
		
		String OrgNameMore = pip.getorganizationNameinMoreTxt().getText().trim();
		Assert.assertEquals(orgName, OrgNameMore);
	}	
	@Test
	public void Delete_the_product() throws Throwable {
		HomePage hp=new HomePage(driver);
		/*Navigate to Home page*/
		ExcelUtility elib=new ExcelUtility();
		/* Create New Product */
		hp.getProductsLink().click();
		CreateNewProductPage cnp=new CreateNewProductPage(driver);
		String productName=elib.getDataFromExcel("Products", 1, 1);
		cnp.createProduct(productName);
		/* Create New Product with Vendor */
		
		
	}

}
