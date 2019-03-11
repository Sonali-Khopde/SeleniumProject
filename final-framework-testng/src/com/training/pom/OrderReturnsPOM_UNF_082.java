package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderReturnsPOM_UNF_082 {
	private WebDriver driver;
	private String idData;

	public OrderReturnsPOM_UNF_082(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// click on Returns link
	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[5]/ul[1]/li[3]/a[1]")
	private WebElement returnLnk;

	public void clickReturnLnk() {
		this.returnLnk.click();
	}

	// click on Add new icon
	@FindBy(xpath = "//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement addPdtReturn;

	public void clickAddPdtReturn() {
		this.addPdtReturn.click();
	}

	// enter valid credential in Order ID textbox
	@FindBy(xpath = "//input[@id='input-order-id']")
	private WebElement orderId;

	public void setOrderId(String ordId) {
		this.orderId.clear();
		this.orderId.sendKeys(ordId);
	}

	// enter valid credential in Customer textbox
	@FindBy(xpath = "//input[@id='input-customer']")
	private WebElement custName;

	public void setcustName(String custName) {
		this.custName.clear();
		this.custName.sendKeys(custName);
	}

	// enter valid credential in First Name textbox
	@FindBy(xpath = "//input[@placeholder='First Name']")
	private WebElement firstName;

	public void setFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
	}

	// enter valid credential in Last Name textbox
	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement lastName;

	public void setlastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}

	// enter valid credential in E-Mail textbox
	@FindBy(xpath = "//input[@placeholder='E-Mail']")
	private WebElement email;

	public void setEmail(String email) {
		this.email.sendKeys(email);
	}

	// enter valid credential in Phone textbox
	@FindBy(xpath = "//input[@id='input-telephone']")
	private WebElement phone;

	public void setPhone(String phone) {
		this.phone.sendKeys(phone);
	}

	// enter valid credential in Product textbox
	@FindBy(xpath = "//input[@id='input-product']")
	private WebElement pdt;

	public void setPdt(String pdt) {
		this.pdt.sendKeys(pdt);
	}

	// enter valid credential in Model textbox
	@FindBy(id = "input-model")
	private WebElement model;

	public void setModel(String model) {
		this.model.click();
		this.model.sendKeys(model);
	}

	// Click on Save icon
	@FindBy(xpath = "//button[@type='submit']//i[@class='fa fa-save']")
	private WebElement btnSave;

	public void clickBtnSave() {
		this.btnSave.click();
	}

	// click on checkbox beside return product
	@FindBy(xpath = "//table//tbody//tr[1]//td[2]")
	private WebElement returnid;

	public void returnId() {
		idData = this.returnid.getText();
		System.out.println(idData);
	}

	public void checkBox() {
		String before = "//input[@value='";
		String after = "']";
		String path = before + idData + after;
		System.out.println(path);
		driver.findElement(By.xpath(path)).click();
	}

	// Click on Delete icon
	@FindBy(xpath = "//i[@class='fa fa-trash-o']")
	private WebElement pdtDeleteLnk;

	public void clickBtnDelete() {
		this.pdtDeleteLnk.click();
	}

	// Reading the confirm msg
	@FindBy(xpath = "")
	private WebElement readConfirmMsg;

	public String getReadConfirmMsg() {
		return this.readNegativeMsg.getText();
	}

	// Click on Delete icon
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[1]")
	private WebElement readNegativeMsg;

	public String getReadNegativeMsg() {
		return this.readNegativeMsg.getText();
	}

	// click on orders in Sales menu
	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[5]/ul[1]/li[1]/a[1]")
	private WebElement ordersLnk;

	public void clickOrdersLnk() {
		this.ordersLnk.click();
	}
}