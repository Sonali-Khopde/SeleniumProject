package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddOrderDetails_UNF_054 {
	private WebDriver driver;

	public AddOrderDetails_UNF_054(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Enter first name
	@FindBy(xpath = "//input[@id='input-firstname']")
	private WebElement firstname;

	public void setFirstName(String fstName) {
		this.firstname.clear();
		this.firstname.sendKeys(fstName);
	}

	// enter last name
	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement lastname;

	public void setLastName(String lstName) {
		this.lastname.clear();
		this.lastname.sendKeys(lstName);
	}

	// enter email address
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement email;

	public void setEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}

	// enter telephone number
	@FindBy(xpath = "//input[@id='input-telephone']")
	private WebElement teleNo;

	public void setTelephone(String teleNo) {
		this.teleNo.clear();
		this.teleNo.sendKeys(teleNo);
	}

	// click on continue button
	@FindBy(xpath = "//button[@id='button-customer']")
	private WebElement btnCustDetailsContinue;

	public void clickBtnCustDetailsContinue() {
		this.btnCustDetailsContinue.click();
	}

	// adding order details: product details 2
	@FindBy(xpath = "//input[@name='product']")
	private WebElement product;

	public void setProduct(String pdts) {
		// this.product.sendKeys(pdt);
		this.product.clear();
		this.product.click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[text()='" + pdts + "']")).click();
	}

	@FindBy(xpath = "//input[@id='input-quantity']")
	private WebElement pdtQty;

	public void setProductQty(String pdtQty) {
		this.pdtQty.clear();
		this.pdtQty.sendKeys(pdtQty);
	}

	// click on add button
	@FindBy(xpath = "//button[@id='button-product-add']")
	private WebElement btnAddPdt;

	public void clickBtnAddPdt() {
		this.btnAddPdt.click();
	}

	@FindBy(xpath = "//button[@id='button-cart']")
	private WebElement btnAddPdtContinue;

	public void clickBtnAddPdtContinue() {
		this.btnAddPdtContinue.click();
	}

	// adding order details: payments details 3
	@FindBy(xpath = "//input[@id='input-payment-firstname']")
	private WebElement paymentsFstName;

	public void setPaymentsFstName(String fstName) {
		this.paymentsFstName.clear();
		this.paymentsFstName.sendKeys(fstName);
	}

	@FindBy(xpath = "//input[@id='input-payment-lastname']")
	private WebElement paymentsLstName;

	public void setPaymentsLstName(String lstName) {
		this.paymentsLstName.clear();
		this.paymentsLstName.sendKeys(lstName);
	}

	@FindBy(xpath = "//input[@id='input-payment-address-1']")
	private WebElement paymentsAddr1;

	public void setPaymentsAddr1(String addr1) {
		this.paymentsAddr1.clear();
		this.paymentsAddr1.sendKeys(addr1);
	}

	@FindBy(xpath = "//input[@id='input-payment-city']")
	private WebElement paymentsCity;

	public void setPaymentsCity(String cty) {
		this.paymentsCity.clear();
		this.paymentsCity.sendKeys(cty);
	}

	// not mandatory initially (no red star) but on clicking continue shows
	// mandatory
	@FindBy(xpath = "//input[@id='input-payment-postcode']")
	private WebElement paymentsPostalCode;

	public void setpaymentsPostalCode(String postalcode) {
		this.paymentsPostalCode.clear();
		this.paymentsPostalCode.sendKeys(postalcode);
	}

	@FindBy(xpath = "//select[@id='input-payment-country']")
	private WebElement drpDwncountry;

	public void setPaymentsCountry(String country) {
		Select countryName = new Select(drpDwncountry);
		countryName.selectByVisibleText(country);
	}

	@FindBy(xpath = "//select[@id='input-payment-zone']")
	private WebElement drpDwnstate;

	public void setPaymentsState(String state) {
		Select stateName = new Select(drpDwnstate);
		stateName.selectByVisibleText(state);
	}

	@FindBy(xpath = "//button[@id='button-payment-address']")
	private WebElement btnPaymentsContinue;

	public void clickBtnPaymentsContinue() {
		this.btnPaymentsContinue.click();
	}

	// adding order details: payments details 4
	@FindBy(xpath = "//input[@id='input-shipping-firstname']")
	private WebElement shippingFstName;

	public void setShippingFstName(String fstName) {
		this.shippingFstName.clear();
		this.shippingFstName.sendKeys(fstName);
	}

	@FindBy(xpath = "//input[@id='input-shipping-lastname']")
	private WebElement shippingLstName;

	public void setShippingLstName(String lstName) {
		this.shippingLstName.clear();
		this.shippingLstName.sendKeys(lstName);
	}

	@FindBy(xpath = "//input[@id='input-shipping-address-1']")
	private WebElement shippingAddr1;

	public void setShippingAddr1(String addr1) {
		this.shippingAddr1.clear();
		this.shippingAddr1.sendKeys(addr1);
	}

	@FindBy(xpath = "//input[@id='input-shipping-city']")
	private WebElement shippingCity;

	public void setShippingCity(String cty) {
		this.shippingCity.clear();
		this.shippingCity.sendKeys(cty);
	}

	@FindBy(xpath = "//input[@id='input-shipping-postcode']")
	private WebElement shippingPostalCode;

	public void setShippingPostalCode(String postalcode) {
		this.shippingPostalCode.clear();
		this.shippingPostalCode.sendKeys(postalcode);
	}

	@FindBy(xpath = "//select[@id='input-shipping-country']")
	private WebElement drpDwnShippingcountry;

	public void setShippingCountry(String shippingCountry) {
		Select countryName = new Select(drpDwnShippingcountry);
		countryName.selectByVisibleText(shippingCountry);
	}

	@FindBy(xpath = "//select[@id='input-shipping-zone']")
	private WebElement drpDwnShippingstate;

	public void setShippingState(String stateShipping) {
		Select stateName = new Select(drpDwnShippingstate);
		stateName.selectByVisibleText(stateShipping);
	}

	@FindBy(xpath = "//button[@id='button-shipping-address']")
	private WebElement btnShippingContinue;

	public void clickBtnShippingContinue() {
		this.btnShippingContinue.click();
	}

	// order details page 5
	@FindBy(xpath = "//select[@id='input-shipping-method']")
	private WebElement drpDwnShippingMethod;

	public void setdrpDwnShippingMethod() {
		this.drpDwnShippingMethod.click();
		driver.findElement(By.xpath("//option[@value='free.free']")).click();
	}

	@FindBy(xpath = "//option[@value='cod']")
	private WebElement drpDwnPaymentMethod;

	public void setdrpDwnPaymentMethod() {
		this.drpDwnPaymentMethod.click();
	}

	@FindBy(xpath = "//button[@id='button-save']")
	private WebElement btnSaveOrder;

	public void clickBtnSaveOrder() {
		this.btnSaveOrder.click();
	}

	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement confirmMsg;

	public String getConfirmMsg() {
		return this.confirmMsg.getText();
	}
}
