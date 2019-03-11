package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders_UNF_084;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.DB_ReturnPOM_UNF_084;
import com.training.pom.DashboardPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class OrderReturn_DB_Test_UNF_084 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods;

	/*
	 * To Verify whether added product details get displayed in home screen
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver);
		// open the browser
		driver.get(baseUrl);
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("DB_test_UNF_084");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}

	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders_UNF_084.class)
	public void saveToDB(String pdt, String met, String mod, String pr, String qnty, String cate) {
		DashboardPOM dPOM = new DashboardPOM(driver);
		DB_ReturnPOM_UNF_084 dbPOM = new DB_ReturnPOM_UNF_084(driver);
		// Click on Catelog icon
		dPOM.clickCatelogLnk();
		// Click on Products link
		dPOM.clickProductsLnk();
		// Click on Add New icon
		dbPOM.clickAddProdBtn();
		// Enter Valid credentials in Product Name of General tab
		String pdtNm = dbPOM.setPdtName("Shoe");
		// Enter Valid credentials in Meta Tag Title of General tab
		String meta = dbPOM.setMeta("Shoe");
		// Click on Data tab
		dbPOM.clickDataLnk();
		// Enter valid credentials in Model textbox
		String model = dbPOM.setModal("SH-014");
		// Enter valid credentials in Price textbox
		String price = dbPOM.setPrice("1800");
		// Enter valid credentials in Quantity textbox
		String qty = dbPOM.setQuantity("20");
		// Click on Links tab
		dbPOM.clicklinkLnk();
		// Click on Categories textbox
		// Select Category from displayed category list
		String category = dbPOM.setCategory("Sports");
		// Keep default values in Attribute, Option, Recurring, Discount, Special,
		// Image, Reward Points and Design tab
		// Click on Save icon
		dbPOM.clickSaveBtn();
		// assertions
		Assert.assertEquals(pdtNm, pdt);
		Assert.assertEquals(meta, met);
		Assert.assertEquals(model, mod);
		Assert.assertEquals(price, pr);
		Assert.assertEquals(qty, qnty);
		Assert.assertEquals(category, cate);
		screenShot.captureScreenShot("DB_test_UNF_084_after");
	}

}