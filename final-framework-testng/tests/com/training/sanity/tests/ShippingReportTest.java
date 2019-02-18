package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM;
import com.training.pom.DashboardPOM;
import com.training.pom.ShippingReportPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ShippingReportTest {

	private WebDriver driver;
	private String baseUrl;
	private AdminLoginPOM adminLoginPOM;
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
		adminLoginPOM = new AdminLoginPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		// login as admin
		adminLoginPOM.sendUserName("admin");
		adminLoginPOM.sendPassword("admin@123");
		adminLoginPOM.clickLoginBtn();
		screenShot.captureScreenShot("UNF_024_Login");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void taxReport() {
		DashboardPOM dPOM = new DashboardPOM(driver);
		dPOM.clickReport();
		dPOM.clickSales();
		dPOM.clickShippingLnk();
		ShippingReportPOM sPOM = new ShippingReportPOM(driver);
		sPOM.setGroupByList();
		sPOM.clickFilterBtn();
		String title = "Shipping Report";
		Assert.assertEquals(title, sPOM.getPagerHeaderTitle());
		screenShot.captureScreenShot("UNF_024_Final");
	}
}
