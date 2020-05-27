package com.gurudemo.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sun.reflect.CallerSensitive;

public class CustomerPage {

	WebDriver driver;

	public CustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[text()='New Customer']")
	@CacheLookup
	WebElement clicknewCustomer;

	@FindBy(xpath = "//*[@name='name']")
	@CacheLookup
	WebElement txtname;

	@FindBy(xpath = "//*[@value='m']")
	@CacheLookup
	WebElement mgender;

	@FindBy(xpath = "//*[@value='f']")
	@CacheLookup
	WebElement fgender;

	@FindBy(xpath = "//*[@id='dob']")
	@CacheLookup
	WebElement clickdob;

	@FindBy(xpath = "//*[@name='addr']")
	@CacheLookup
	WebElement txtaddress;

	@FindBy(xpath = "//*[@name='city']")
	@CacheLookup
	WebElement txtcity;

	@FindBy(xpath = "//*[@name='state']")
	@CacheLookup
	WebElement txtstate;

	@FindBy(xpath = "//*[@name='pinno']")
	@CacheLookup
	WebElement txtpin;

	@FindBy(xpath = "//*[@name='telephoneno']")
	@CacheLookup
	WebElement txttelephoneno;

	@FindBy(xpath = "//*[@name='emailid']")
	@CacheLookup
	WebElement txtemail;

	@FindBy(xpath = "//*[@name='password']")
	@CacheLookup
	WebElement txtpassword;

	@FindBy(xpath = "//*[@name='sub']")
	@CacheLookup
	WebElement btnsub;
	
	
	public void getNewCoustomer() {
		clicknewCustomer.click();
	}

	public void setName(String name) {
		txtname.sendKeys(name);
	}

	public void setGender(String gender) {
		if (gender.equals("male")) {
			mgender.click();
		} else {
			fgender.click();
		}
	}

	public void setDob(String date) {
		clickdob.sendKeys(date);
	}

	public void setAddress(String addr) {
		txtaddress.sendKeys(addr);
	}

	public void setCity(String city) {
		txtcity.sendKeys(city);
	}

	public void setState(String state) {
		txtstate.sendKeys(state);
	}

	public void setPincode(String pin) {
		txtpin.sendKeys(pin);
	}

	public void setTelephone(String tele) {
		txttelephoneno.sendKeys(tele);
	}

	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}

	public void setPassword2(String password) {
		txtpassword.sendKeys(password);
	}

	public void clickSubmit() {
		btnsub.click();
	}
	
	
}
