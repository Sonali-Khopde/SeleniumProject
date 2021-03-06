package com.training.sanity.tests;

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

import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM_UNF_051;
import com.training.pom.CustomersPOM_UNF_051;
import com.training.pom.DashboardPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminLoginTest {

	private WebDriver driver;
	private String baseUrl;
	private AdminLoginPOM_UNF_051 adminLoginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		adminLoginPOM = new AdminLoginPOM_UNF_051(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		// login as admin
		adminLoginPOM.sendUserName("admin");
		adminLoginPOM.sendPassword("admin@123");
		adminLoginPOM.clickLoginBtn();
		screenShot.captureScreenShot("First");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}

	@Test
	public void validLoginTest() {
		DashboardPOM dpom = new DashboardPOM(driver);
		dpom.clickCustomerLnk();
		dpom.clickCustomersLnk();
		CustomersPOM_UNF_051 cPOM = new CustomersPOM_UNF_051(driver);
		// Assuming there is a user with name "test"
		cPOM.setCustomerName("test");
		cPOM.clickFilterBtn();
		cPOM.clickCheckBox();
		cPOM.clickDeleteBtn();
		driver.switchTo().alert().accept();
		Assert.assertTrue(cPOM.getConfirmMsg().contains("Success: You have modified customers!"));
	}
}
