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
import com.training.pom.DashboardPOM;
import com.training.pom.OrderReportPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class OrderReportTest {

	private WebDriver driver;
	private String baseUrl;
	private AdminLoginPOM_UNF_051 adminLoginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	/*
	 * To Verify whether application allows the admin to filter the order details
	 * from sales list from reports module
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
		adminLoginPOM = new AdminLoginPOM_UNF_051(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		// login as admin
		adminLoginPOM.sendUserName("admin");
		adminLoginPOM.sendPassword("admin@123");
		adminLoginPOM.clickLoginBtn();
		screenShot.captureScreenShot("UNF_022_Login");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}

	@Test
	public void salesReport() {
		DashboardPOM dPOM = new DashboardPOM(driver);
		dPOM.clickReport();
		dPOM.clickSales();
		dPOM.clickOrder();
		OrderReportPOM sPOM = new OrderReportPOM(driver);
		sPOM.setGroupByList();
		sPOM.clickFilterBtn();
		String title = "Sales Report";
		Assert.assertEquals(title, sPOM.getPagerHeaderTitle());
		screenShot.captureScreenShot("UNF_022_Final");
	}
}
