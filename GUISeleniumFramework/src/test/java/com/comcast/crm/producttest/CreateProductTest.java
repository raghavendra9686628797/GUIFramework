package com.comcast.crm.producttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewProductPage;
import com.comcast.crm.objectrepositoryutility.CreateNewVendoraPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewLeadPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LeadInformationPage;
import com.comcast.crm.objectrepositoryutility.LeadsPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.ProductInformationPage;
import com.comcast.crm.objectrepositoryutility.ProductsPage;
import com.comcast.crm.objectrepositoryutility.VendorsPage;

public class CreateProductTest extends BaseClass{

	@Test(priority = 0)
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
		String productName=elib.getDataFromExcel("Products",1,1);
		cnp.getProductnameEdt().sendKeys(productName);
		cnp.getSaveBtn().click();
		/* Verify the Created product */
		
		ProductInformationPage Pip = new ProductInformationPage(driver);
		String hdrMsg = Pip.getHeaderMsg().getText();
		boolean getBoolean = hdrMsg.contains(productName);
		Assert.assertTrue(getBoolean);
	//	pp.deleteProduct(productName);
		
	}
	@Test(priority = 1)
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
		String productName=elib.getDataFromExcel("Products",3,1);
		cnp.getProductnameEdt().sendKeys(productName);
		
		wlib.select(cnp.getProductcategoryDD(),elib.getDataFromExcel("Products",3,2));
		cnp.getSaveBtn().click();
		/* Verify the Created product */
		
		ProductInformationPage Pip = new ProductInformationPage(driver);
		String hdrMsg = Pip.getHeaderMsg().getText();
		boolean getBoolean = hdrMsg.contains(productName);
		Assert.assertTrue(getBoolean);
		String pcategoryTxt=Pip.getProductCategoryTxt().getText().trim();
		Assert.assertEquals(elib.getDataFromExcel("Products", 3, 2), pcategoryTxt);
		//pp.deleteProduct(productName);
		
	}
	@Test(priority = 2)
	public void Create_Product_With_VendorName() throws Throwable {
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
	//	pp.deleteProduct(productName);
		
	}
	@Test(priority = 3)
	public void Add_Organization_To_ExistedProduct() throws Throwable {
		WebDriverUtility wlib=new WebDriverUtility();
		ExcelUtility elib=new ExcelUtility();
		/*Navigate to Home page*/
		HomePage hp=new HomePage(driver);
		hp.getProductsLink().isDisplayed();
		/* Create New organization */
		hp.getOrgLink().click();
		CreatingNewOrganizationPage cno=new CreatingNewOrganizationPage(driver);
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		JavaUtility jlib=new JavaUtility();
		int num=jlib.getRandomNumber();
		String orgName=elib.getDataFromExcel("Products", 7, 2)+num;
		cno.createOrg(orgName);
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String orgNam = oip.getHeaderMsg().getText();
		boolean org = orgNam.contains(orgName);
		Assert.assertTrue(org);

		/* Add organization to existed product */
		
		hp.getProducts().click();
		
		String productName=elib.getDataFromExcel("Products", 7, 1);
		WebElement pro=driver.findElement(By.xpath("//a[contains(text(),'Product Name')]/../../..//a[text()='"+productName+"']"));
		wlib.waitUntillElementisvisible(driver, pro);
		pro.click();

		ProductInformationPage pip = new ProductInformationPage(driver);
		/*Verify existed product information is displayed*/
		String hdrMsg = pip.getHeaderMsg().getText();
		boolean getBoolean = hdrMsg.contains(productName);
		Assert.assertTrue(getBoolean);
		
		pip.getmoreInformationBtn().isDisplayed();
		pip.getmoreInformationBtn().click();
		
		wlib.scrollUntilElementIsVisible(driver, pip.getorganizationTable());
		
		pip.getorganizationTable().isDisplayed();
		
		pip.getorganizationTable().click();
		pip.getselectOrganizationsBtn().click();
		
		wlib.switchToTabOnURL(driver, "module=Accounts");
		op.getSerchEdt().sendKeys(orgName);
		op.getSearchNowBtn().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		/*Verify organization is added to product*/
		wlib.switchToTabOnURL(driver, "module=Products");
		String OrgNameMore = pip.getorganizationNameinMoreTxt().getText().trim();
		Assert.assertEquals(orgName, OrgNameMore);
		//ProductsPage pp=new ProductsPage(driver);
		//pp.deleteProduct(productName);
	}	
	@Test(priority = 4)
	public void Delete_the_product() throws Throwable {
		WebDriverUtility wlib=new WebDriverUtility();
		HomePage hp=new HomePage(driver);
		/*Navigate to Home page*/
		ExcelUtility elib=new ExcelUtility();
		/* Create New Product */
		hp.getProductsLink().click();
		CreateNewProductPage cnp=new CreateNewProductPage(driver);
		String productName=elib.getDataFromExcel("Products", 9, 1);
		cnp.createProduct(productName);
		hp.getProductsLink().click();
		driver.findElement(By.xpath("//a[text()='"+productName+"']/../..//input[@type=\"checkbox\"]")).click();
		ProductsPage pp=new ProductsPage(driver);
		pp.getDeleteBtn().click();
		wlib.switchtoAlertAndAccept(driver);
		WebElement product = driver.findElement(By.xpath("//a[text()='"+productName+"']/../..//input[@type=\"checkbox\"]"));
		wlib.waitUntillElementisInvisible(driver, product);
		boolean isDisplayedOrNot =wlib.verifyElementDisplayedOrNot(driver, product);
		Assert.assertFalse(isDisplayedOrNot);
		
	}

	@Test(groups = "regressionTest")
	public void Add_Leads_For_Products() throws Throwable {
		/*
		 * String filepath = "./testdata/testScriptdata.xlsx"; String productName =
		 * eLib.getDataFromExcel(filepath, "Product", "PR_017", "ProductName");
		 */
		String productName =eLib.getDataFromExcel("Products", 11, 1);
		String lastName = eLib.getDataFromExcel("Products", 11,2)+jLib.getRandomNumber();
		String company = eLib.getDataFromExcel("Products", 11,3);

		/* Navigate to Create Lead Page */
		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();

		LeadsPage lp = new LeadsPage(driver);
		lp.getCreateLeadImg().click();

		/* Create New Lead */
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.createLead(lastName, company);

		/* Verify the Created Lead */
		LeadInformationPage lip = new LeadInformationPage(driver);
		String hdrMsg = lip.getHeaderMsg().getText();
		boolean getBoolean = hdrMsg.contains(lastName);
		Assert.assertTrue(getBoolean);
		String actLastName = lip.getLastNameTxt().getText();
		Assert.assertEquals(actLastName, lastName);
		String actCompany = lip.getCompanyTxt().getText();
		Assert.assertEquals(actCompany, company);
		
		/* Create a Product */
		hp = new HomePage(driver);
		hp.getProductsLink().click();
		CreateNewProductPage cnp=new CreateNewProductPage(driver);
		cnp.createProduct(productName);
		
		/*Verify existed product information is displayed*/
		ProductInformationPage pip = new ProductInformationPage(driver);
		hdrMsg = pip.getHeaderMsg().getText();
		getBoolean = hdrMsg.contains(productName);
		Assert.assertTrue(getBoolean);
		
		/* Navigate to More Information */
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		oip.getmoreInformationLink().click();
		pip.getShowLeadsImg().click();
		pip.getSelectLeadsBtn().click();
		
		/* Navigate to Leads Tab and select the Lead */
		wLib.switchToTabOnURL(driver, "module=Leads");
		lp.getSearchForedt().sendKeys(lastName);
		lp.getSearchNowBtn().click();
		driver.findElement(By.linkText(lastName)).click();
		
		/* Navigate Back to More Information and Verify the Lead*/
		wLib.switchToTabOnURL(driver, "module=Products");
		actLastName = pip.getLastNameLnk().getText();
		Assert.assertEquals(actLastName, lastName);
		
	}

}
