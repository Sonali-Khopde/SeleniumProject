package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManufCatelogPOM_UNF_55 {
	private WebDriver driver;

	public ManufCatelogPOM_UNF_55(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// adding manuf in catelog
	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]")
	private WebElement lnkCatelog;

	public void clickLnkCatelog() {
		this.lnkCatelog.click();
	}

	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[2]/ul[1]/li[7]/a[1]")
	private WebElement lnkManuf;

	public void clickLnkManuf() {
		this.lnkManuf.click();
	}

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")
	private WebElement btnAddManuf;

	public void clickBtnAddManuf() {
		this.btnAddManuf.click();
	}

	// set manufacturing name
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]")
	private WebElement manufName;

	public void setManufName(String mfName) {
		this.manufName.clear();
		this.manufName.sendKeys(mfName);
	}

	// click on save button
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]/i[1]")
	private WebElement btnSaveManuf;

	public void clickBtnSaveManuf() {
		this.btnSaveManuf.click();
	}

	// getting the confirm message
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]")
	private WebElement confirmTxt;

	public String readConfirmTxt() {
		return this.confirmTxt.getText();
	}

	// clicking on product link
	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]")
	private WebElement lnkPdt;

	public void clickLnkPdt() {
		this.lnkPdt.click();
	}

	// clicking on add button
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/i[1]")
	private WebElement btnAddPdt;

	public void clickBtnAddPdt() {
		this.btnAddPdt.click();
	}

	// setting prouduct name
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	private WebElement pdtName;

	public void setPdtName(String pdtName) {
		this.pdtName.clear();
		this.pdtName.sendKeys(pdtName);
	}

	// set meta tag tiltle
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/input[1]")
	private WebElement metaTagTitle;

	public void setMetaTagTitle(String metaTitle) {
		this.metaTagTitle.clear();
		this.metaTagTitle.sendKeys(metaTitle);
	}

	// clicking on link data
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/ul[1]/li[2]/a[1]")
	private WebElement lnkData;

	public void clickLnkData() {
		this.lnkData.click();
	}

	// setting model data
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
	private WebElement modelData;

	public void setModelData(String model) {
		this.modelData.clear();
		this.modelData.sendKeys(model);
	}

	// setting price data
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[2]/div[9]/div[1]/input[1]")
	private WebElement priceData;

	public void setPriceData(String price) {
		this.priceData.clear();
		this.priceData.sendKeys(price);
	}

	// setting quantity
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[2]/div[11]/div[1]/input[1]")
	private WebElement qtyData;

	public void setQtyData(String qty) {
		this.qtyData.clear();
		this.qtyData.sendKeys(qty);
	}

	// click on link
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/ul[1]/li[3]/a[1]")
	private WebElement lnkLink;

	public void clickLnkLink() {
		this.lnkLink.click();
	}

	// setting manufacturer data
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[3]/div[1]/div[1]/input[1]")
	private WebElement manuf;

	public void setManufracturer(String manuf) {
		this.manuf.clear();
		this.manuf.sendKeys(manuf);
	}

	// setting category data
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[3]/div[2]/div[1]/input[1]")
	private WebElement category;

	public void setCategory(String category) {
		this.category.clear();
		this.category.sendKeys(category);
	}

	// clicking on save button
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]/i[1]")
	private WebElement btnFinalSave;

	public void clickBtnFinalSave() {
		this.btnFinalSave.click();
	}

	// reading confirmation message
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[1]")
	private WebElement finalConfirmTxt;

	public String readFinalConfirmTxt() {
		return this.finalConfirmTxt.getText();
	}
}
