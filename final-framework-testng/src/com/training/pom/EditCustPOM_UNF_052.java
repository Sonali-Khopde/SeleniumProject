package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustPOM_UNF_052 {
	private WebDriver driver;

	public EditCustPOM_UNF_052(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// clearing first name
	@FindBy(xpath = "//input[@id='input-firstname']")
	private WebElement firstName;

	public void clearFirstName() {
		this.firstName.clear();
	}

	// set first name
	public void setFirstName(String fname) {
		this.firstName.sendKeys(fname);
	}

	// click on reward points link
	@FindBy(xpath = "//a[@href='#tab-reward']")
	private WebElement rewardPointsLnk;

	public void clickRewardPointsLnk() {
		this.rewardPointsLnk.click();
	}

	// add description on rewards point page
	@FindBy(xpath = "//input[@id='input-reward-description']")
	private WebElement descTxt;

	public void setDescTxt(String desc) {
		this.descTxt.sendKeys(desc);
	}

	// add points on rewards point page
	@FindBy(xpath = "//input[@id='input-points']")
	private WebElement pointsTxt;

	public void setPointsTxt(String pnts) {
		this.pointsTxt.sendKeys(pnts);
	}

	// click add rewards point button (bottom right)
	@FindBy(xpath = "//button[@id='button-reward']")
	private WebElement btnAddRewardPoint;

	public void clickBtnAddRewardPoint() {
		this.btnAddRewardPoint.click();
	}
	
	//reading the bal reward points
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[4]/div[2]/div[1]/table[1]/tbody[1]/tr[7]/td[3]")
	private WebElement balRewardPoint;

	public String setBalRewardPoint() {
		return this.balRewardPoint.getAttribute("value");
	}

	// click save button (top right)
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnSave;

	public void clickBtnSave() {
		this.btnSave.click();
	}

	// Read confirmation msg
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement confirmTxt;

	public String readConfirmTxt() {
		return this.confirmTxt.getText();
	}

}