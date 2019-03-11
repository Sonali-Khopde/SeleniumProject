package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DB_ReturnPOM_UNF_084 {
	private WebDriver driver;

	public DB_ReturnPOM_UNF_084(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Click on Add New icon
	@FindBy(xpath = "//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement addBtn;

	public void clickAddProdBtn() {
		this.addBtn.click();
	}

	// Enter Valid credentials in Product Name of General tab
	@FindBy(id = "input-name1")
	private WebElement pdtName;

	public String setPdtName(String pName) {
		this.pdtName.sendKeys(pName);
		return this.pdtName.getAttribute("value");
	}

	// Enter Valid credentials in Meta Tag Title of General tab
	@FindBy(id = "input-meta-title1")
	private WebElement meta;

	public String setMeta(String meta) {
		this.meta.sendKeys(meta);
		return this.meta.getAttribute("value");
	}

	// Click on Data tab
	@FindBy(xpath = "//a[contains(text(),'Data')]")
	private WebElement dataLnk;

	public void clickDataLnk() {
		this.dataLnk.click();
	}

	// Enter valid credentials in Model textbox
	@FindBy(id = "input-model")
	private WebElement model;

	public String setModal(String mod) {
		this.model.sendKeys(mod);
		return this.model.getAttribute("value");
	}

	// Enter valid credentials in Price textbox
	@FindBy(id = "input-price")
	private WebElement price;

	public String setPrice(String price) {
		this.price.sendKeys(price);
		return this.price.getAttribute("value");
	}

	// Enter valid credentials in Quantity textbox
	@FindBy(id = "input-quantity")
	private WebElement quantity;

	public String setQuantity(String qty) {
		this.quantity.clear();
		this.quantity.sendKeys(qty);
		return this.quantity.getAttribute("value");
	}

	// Click on Links tab
	@FindBy(xpath = "//a[contains(text(),'Links')]")
	private WebElement linkLnk;

	public void clicklinkLnk() {
		this.linkLnk.click();
	}

	// Click on Categories textbox
	@FindBy(id = "input-category")
	private WebElement category;

	public String setCategory(String cate) {
		this.category.sendKeys(cate);
		return this.category.getAttribute("value");
	}

	// Select Category from displayed category list
	// Keep default values in Attribute, Option, Recurring, Discount, Special,
	// Image, Reward Points and Design tab
	// Click on Save icon
	@FindBy(xpath = "//i[@class='fa fa-save']")
	private WebElement saveBtn;

	public void clickSaveBtn() {
		this.saveBtn.click();
	}
}
