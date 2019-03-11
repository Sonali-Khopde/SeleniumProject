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
import com.training.pom.AddOrderDetails_UNF_054;
import com.training.pom.AdminLoginPOM_UNF_051;
import com.training.pom.DashboardPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class OrderSalesTest_UNF_054 {

	private WebDriver driver;
	private String baseUrl;
	private AdminLoginPOM_UNF_051 adminLoginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	/* To verify whether application allows admin to place an order for customer */

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
		screenShot.captureScreenShot("UNF_054_Login");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}

	@Test
	public void adminPlaceOrder() {
		String fstName = "Hema";
		String lstName = "Chandra";
		String addr1 = "6th Phase";
		String email = "hema.chandra@gmail.com";
		String cty = "bangalore";
		String postalcode = "560078";
		String tel = "9654321678";
		String shippingCountry = "India";
		String stateShipping = "Karnataka";
		String prod = "Blazer Girls(7-8)";
		String prodQt = "1";
		// String shippingMethod="Free Shipping";
		DashboardPOM dPOM = new DashboardPOM(driver);
		AddOrderDetails_UNF_054 aodPOM = new AddOrderDetails_UNF_054(driver);
		// 1. click on Sales icon
		dPOM.clickSales();
		// 2. Click on Orders link
		dPOM.clickOrder();
		// 3. Click on Add New icon
		dPOM.clickBtnAddOrder();
		// 4. Enter valid credentials in First Name textbox
		aodPOM.setFirstName(fstName);
		// 5. Enter valid credentials in Last Name textbox
		aodPOM.setLastName(lstName);
		// 6. Enter valid credentials in E-Mail textbox
		aodPOM.setEmail(email);
		// 7. Enter valid credentials in Telephone textbox
		aodPOM.setTelephone(tel);
		// 8. Click on Continue button
		aodPOM.clickBtnCustDetailsContinue();
		// 9. Enter valid credentials in Choose Product textbox
		aodPOM.setProduct(prod);
		// 10. Enter valid credentials in Quantity textbox
		aodPOM.setProductQty(prodQt);
		// 11. Click on Add product button
		aodPOM.clickBtnAddPdt();
		// 12. click on continue button
		aodPOM.clickBtnAddPdtContinue();
		// 13. Enter valid credentials in First Name textbox
		aodPOM.setPaymentsFstName(fstName);
		// 14. Enter valid credentials in Last Name textbox
		aodPOM.setPaymentsLstName(lstName);
		// 15. Enter valid credentials in Address1 textbox
		aodPOM.setPaymentsAddr1(addr1);
		// 17. Enter valid credentials in City textbox
		aodPOM.setPaymentsCity(cty);
		// 18. Enter valid credentials in Post Code textbox
		aodPOM.setpaymentsPostalCode(postalcode);
		// 19. Select credentials from Country list box
		aodPOM.setPaymentsCountry(shippingCountry);
		// 20. Select credentials from Region/State list box
		aodPOM.setPaymentsState(stateShipping);
		// 21. click on continue button
		aodPOM.clickBtnPaymentsContinue();
		// Entering same shipping details
		aodPOM.setShippingFstName(fstName);
		aodPOM.setShippingLstName(lstName);
		aodPOM.setShippingAddr1(addr1);
		aodPOM.setShippingCity(cty);
		aodPOM.setShippingPostalCode(postalcode);
		aodPOM.setShippingCountry(shippingCountry);
		aodPOM.setShippingState(stateShipping);
		// clicking continue button on shipping page
		aodPOM.clickBtnShippingContinue();
		aodPOM.setdrpDwnShippingMethod();
		// 22. select Payment Method
		aodPOM.setdrpDwnPaymentMethod();
		// 23. Click on Save button
		aodPOM.clickBtnSaveOrder();
		Assert.assertTrue(aodPOM.getConfirmMsg().contains("Success: You have "));
		screenShot.captureScreenShot("UNF_054_Confirmation Msg");
	}

}
