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

import com.training.dataproviders.LoginDataProviders_UNF_81;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.DB_SalesPOM_UNF_81;
import com.training.pom.DashboardPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Sales_DB_Test_UNF_81 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods;

	/*
	 * To verify whether application allows admin to return product of customer &
	 * delete from return list & same get displayed in database
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
		screenShot.captureScreenShot("DB_test_UNF_081");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}

	@Test(dataProvider = "db-inputs_081", dataProviderClass = LoginDataProviders_UNF_81.class)
	public void saveToDB(String ordId, String customer, String firstname, String lastname, String email, String phone,
			String product, String model) {
		DashboardPOM dPOM = new DashboardPOM(driver);
		DB_SalesPOM_UNF_81 dbPOM = new DB_SalesPOM_UNF_81(driver);
		// click on Sales icon
		dPOM.clickSales();
		// click on Returns link
		dbPOM.clickReturnsLnk();
		// click on Add new icon
		dbPOM.clickAddBtn();
		// enter valid credential in Order ID textbox
		String oId = dbPOM.setOrderId("34");
		// enter valid credential in Customer textbox
		String custName = dbPOM.setCustName("Smriti");
		// enter valid credential in First Name textbox
		String fname = dbPOM.setFirstName("Smriti");
		// enter valid credential in Last Name textbox
		String lname = dbPOM.setLastName("Irani");
		// enter valid credential in E-Mail textbox
		String emailId = dbPOM.setEmailId("smriti@gmail.com");
		// enter valid credential in Phone textbox
		String ph = dbPOM.setPhoneNo("1234567890");
		// enter valid credential in Product textbox
		String pdt = dbPOM.setProduct("T shirt");
		// enter valid credential in Model textbox
		String mod = dbPOM.setModel("SH-002");
		// Click on Save icon
		dbPOM.clickSaveBtn();
		// assertions
		Assert.assertEquals(ordId, oId);
		Assert.assertEquals(customer, custName);
		Assert.assertEquals(firstname, fname);
		Assert.assertEquals(lastname, lname);
		Assert.assertEquals(email, emailId);
		Assert.assertEquals(phone, ph);
		Assert.assertEquals(product, pdt);
		Assert.assertEquals(model, mod);
		screenShot.captureScreenShot("DB_test_UNF_081_after");
	}

}