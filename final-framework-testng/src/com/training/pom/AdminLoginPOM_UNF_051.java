package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPOM_UNF_051 {
	private WebDriver driver;

	public AdminLoginPOM_UNF_051(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Admin login:Username,Password and login button
	@FindBy(id = "input-username")
	private WebElement userName;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(xpath = "/html/body/div/div/div/div/div/div/div[2]/form/div[3]/button")
	private WebElement loginBtn;

	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	public void clickLoginBtn() {
		this.loginBtn.click();
	}
}
