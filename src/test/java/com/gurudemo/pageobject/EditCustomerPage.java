package com.gurudemo.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {

	WebDriver driver;

	public EditCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()='Edit Customer']")
	WebElement editclick;

	@FindBy(xpath = "//*[@name='cusid']")
	WebElement txtcustid;

	@FindBy(xpath = "//*[@name='AccSubmit']")
	WebElement btnsumbitid;

	@FindBy(xpath = "//*[@name='addr']")
	WebElement txtaddchange;

	@FindBy(xpath = "//*[@name='sub']")
	WebElement btnSub;
	
//	@FindBy(xpath="//*[text()='Home']")
//	WebElement homepage;

	public void getClickOnEditBtn() {
		editclick.click();
	}

	public void setCustId(String id) {
		txtcustid.sendKeys(id);
	}

	public void btnSubmit() {
		btnsumbitid.click();
	}

	public void changeAdd(String ad) {
		txtaddchange.clear();
		txtaddchange.sendKeys(ad);
	}

	public void subbtn() {
		btnSub.click();
	}
	
//	public void homePage()
//	{
//		homepage.click();
//	}

}
