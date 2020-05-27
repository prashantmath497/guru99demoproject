package com.gurudemo.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@name='uid']")
	@CacheLookup
	WebElement txtUserId;

	@FindBy(xpath = "//*[@name='password']")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath = "//*[@name='btnLogin']")
	@CacheLookup
	WebElement btnLogin;

	@FindBy(xpath = "//*[text()='Log out']")
	@CacheLookup
	WebElement btnLogout;

	public void setUserId(String userId) {
		txtUserId.sendKeys(userId);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void setLoginBtn() {
		btnLogin.click();
	}

	public void setLogOut() {
		btnLogout.click();
	}

}
