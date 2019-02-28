package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerDetailsPOM_UNF_051 {
	private WebDriver driver;

	public AddCustomerDetailsPOM_UNF_051(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// add customer details page:select customer group name
	@FindBy(xpath = "//select[@id='input-customer-group']")
	private WebElement drpDownCustGroupName;

	public void setdrpDownCustGroupName(String groupName) {
		Select custGroupName = new Select(drpDownCustGroupName);
		custGroupName.selectByVisibleText(groupName);
	}

	// add customer details page:First name
	@FindBy(xpath = "//input[@id='input-firstname']")
	private WebElement custFirstName;

	public void setCustFirstName(String firstName) {
		this.custFirstName.sendKeys(firstName);
	}

	// add customer details page:Last name
	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement custLastName;

	public void setCustLastName(String lastName) {
		this.custLastName.sendKeys(lastName);
	}

	// add customer details page:email
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement custEMail;

	public void setCustEMail(String email) {
		this.custEMail.sendKeys(email);
	}

	// add customer details page:Telephone
	@FindBy(xpath = "//input[@id='input-telephone']")
	private WebElement custTelephoneNo;

	public void setCustTelephoneNo(String telNo) {
		this.custTelephoneNo.sendKeys(telNo);
	}

	// add customer details page:Password
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement custPassword;

	public void setCustPassword(String psw) {
		this.custPassword.sendKeys(psw);
	}

	// add customer details page:Confirm Password
	@FindBy(xpath = "//input[@id='input-confirm']")
	private WebElement custConfPassword;

	public void setCustConfPassword(String cPsw) {
		this.custConfPassword.sendKeys(cPsw);
	}

	// saving the new customer:save button
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnSaveCustomer;

	public void clickBtnSaveCustomer() {
		this.btnSaveCustomer.click();
	}

	// adding customer address fields :click address
	@FindBy(xpath = "//*[@id=\"address-add\"]/a")
	private WebElement lnkAddress;

	public void clickLnkAddress() {
		this.lnkAddress.click();
	}

	// adding customer address fields :click address1
	@FindBy(xpath = "//*[@id=\"address\"]/li[2]/a")
	private WebElement lnkAddress1;

	public void clickLnkAddress1() {
		this.lnkAddress1.click();
	}

	// --- resetting fname n lname on address page

	// address1 details page:First name
	@FindBy(xpath = "//div[@class='col-sm-10']//div[@class='tab-pane active']//div[@class='col-sm-10']//input[@placeholder='First Name']")
	private WebElement custFirstNameAddr;

	public void setCustFirstNameAddr(String firstName) {
		this.custFirstNameAddr.sendKeys(firstName);
	}

	// address1 details page:Last name
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/input[1]")
	private WebElement custLastNameAddr;

	public void setCustLastNameAddr(String lastName) {
		this.custLastNameAddr.sendKeys(lastName);
	}
	// ---end of adding names on addr page

	// adding customer address fields :click address1 textbox
	@FindBy(xpath = "//input[@id='input-address-11']")
	private WebElement address1Txt;

	public void setAddress1Txt(String address1) {
		this.address1Txt.sendKeys(address1);
	}

	// adding customer address fields :click address2 textbox
	@FindBy(xpath = "//input[@id='input-address-21']")
	private WebElement address2Txt;

	public void setAddress2Txt(String address2) {
		this.address2Txt.sendKeys(address2);
	}

	// adding customer address fields :click city textbox
	@FindBy(xpath = "//input[@id='input-city1']")
	private WebElement cityTxt;

	public void setCityTxt(String cty) {
		this.cityTxt.sendKeys(cty);
	}

	// adding customer address fields :click postalcode textbox
	@FindBy(xpath = "//input[@placeholder='Postcode']")
	private WebElement postCodeTxt;

	public void setPostCodeTxt(String postalcode) {
		this.postCodeTxt.clear();
		this.postCodeTxt.sendKeys(postalcode);
	}

	// adding customer address fields :click country textbox
	@FindBy(xpath = "//select[@id='input-country1']")
	private WebElement drpDwncountry;

	public void setCountryTxt(String country) {
		Select countryName = new Select(drpDwncountry);
		countryName.selectByVisibleText(country);
	}

	// adding customer address fields :click state textbox
	@FindBy(xpath = "//select[@id='input-zone1']")
	private WebElement drpDwnstate;

	public void setStateTxt(String state) {
		Select stateName = new Select(drpDwnstate);
		stateName.selectByVisibleText(state);
	}
}
