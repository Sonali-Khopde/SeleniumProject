package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DB_SalesPOM_UNF_81 {
	private WebDriver driver;

	public DB_SalesPOM_UNF_81(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// click on Returns link
	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[5]/ul[1]/li[3]/a[1]")
	private WebElement returnsLnk;

	public void clickReturnsLnk() {
		this.returnsLnk.click();
	}

	// click on Add new icon
	@FindBy(xpath = "//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement addBtn;

	public void clickAddBtn() {
		this.addBtn.click();
	}

	// enter valid credential in Order ID textbox
	@FindBy(id = "input-order-id")
	private WebElement orderId;

	public String setOrderId(String oId) {
		this.orderId.sendKeys(oId);
		return this.orderId.getAttribute("value");
	}

	// enter valid credential in Customer textbox
	@FindBy(id = "input-customer")
	private WebElement custName;

	public String setCustName(String cName) {
		this.custName.sendKeys(cName);
		return this.custName.getAttribute("value");
	}

	// enter valid credential in First Name textbox
	@FindBy(id = "input-firstname")
	private WebElement firstName;

	public String setFirstName(String fName) {
		this.firstName.sendKeys(fName);
		return this.firstName.getAttribute("value");
	}

	// enter valid credential in Last Name textbox
	@FindBy(id = "input-lastname")
	private WebElement lastName;

	public String setLastName(String lName) {
		this.lastName.sendKeys(lName);
		return this.lastName.getAttribute("value");
	}

	// enter valid credential in E-Mail textbox
	@FindBy(id = "input-email")
	private WebElement emailId;

	public String setEmailId(String email) {
		this.emailId.sendKeys(email);
		return this.emailId.getAttribute("value");
	}

	// enter valid credential in Phone textbox
	@FindBy(id = "input-telephone")
	private WebElement phoneNo;

	public String setPhoneNo(String phone) {
		this.phoneNo.sendKeys(phone);
		return this.phoneNo.getAttribute("value");
	}

	// enter valid credential in Product textbox
	@FindBy(id = "input-product")
	private WebElement product;

	public String setProduct(String pdt) {
		this.product.sendKeys(pdt);
		return this.product.getAttribute("value");
	}

	// enter valid credential in Model textbox
	@FindBy(id = "input-model")
	private WebElement model;

	public String setModel(String mod) {
		this.model.sendKeys(mod);
		return this.model.getAttribute("value");
	}

	// Click on Save icon
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveBtn;

	public void clickSaveBtn() {
		this.saveBtn.click();
	}
}
