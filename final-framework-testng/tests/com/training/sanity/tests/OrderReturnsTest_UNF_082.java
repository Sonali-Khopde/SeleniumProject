package com.training.sanity.tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM_UNF_051;
import com.training.pom.DashboardPOM;
import com.training.pom.OrderReturnsPOM_UNF_082;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class OrderReturnsTest_UNF_082 {

	private WebDriver driver;
	private String baseUrl;
	private AdminLoginPOM_UNF_051 adminLoginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	/*
	 * To verify whether application allows admin to return multiple product of
	 * customer & delete from return list
	 */

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
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
		screenShot.captureScreenShot("UNF_082_Login");
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}

	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void adminPlaceOrder(String ordId, String custName, String firstName, String lastName, String email,
			String phone, String pdt, String model) throws AWTException, InterruptedException {
		DashboardPOM dPOM = new DashboardPOM(driver);
		OrderReturnsPOM_UNF_082 orpPOM = new OrderReturnsPOM_UNF_082(driver);
		// click on Sales icon
		dPOM.clickSales();
		// click on Returns link
		orpPOM.clickReturnLnk();
		// click on Add new icon
		orpPOM.clickAddPdtReturn();
		// enter valid credential in Order ID textbox
		orpPOM.setOrderId(ordId);
		// enter valid credential in Customer textbox
		orpPOM.setcustName(custName);
		// enter valid credential in First Name textbox
		orpPOM.setFirstName(firstName);
		// enter valid credential in Last Name textbox
		orpPOM.setlastName(lastName);
		// enter valid credential in E-Mail textbox
		orpPOM.setEmail(email);
		// enter valid credential in Phone textbox
		orpPOM.setPhone(phone);
		// enter valid credential in Product textbox
		orpPOM.setPdt(pdt);
		// enter valid credential in Model textbox
		orpPOM.setModel(model);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Click on Save icon
		orpPOM.clickBtnSave();
		// click on checkbox beside return product
		orpPOM.returnId();
		orpPOM.checkBox();
		// Click on Delete icon
		js.executeScript("window.scrollBy(0,1000)");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		orpPOM.clickBtnDelete();
		// click on OK button
		driver.switchTo().alert().accept();
		Assert.assertTrue(orpPOM.getReadConfirmMsg().contains("Success: You have "));
		screenShot.captureScreenShot("UNF_082_Confirmation Msg");
	}

}
