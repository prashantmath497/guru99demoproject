package com.gurudemo.testcases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gurudemo.pageobject.CustomerPage;
import com.gurudemo.pageobject.LoginPage;

public class TC_NewCustomer_002 extends BaseClass {
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {

		driver.get(baseurl);
		driver.manage().window().maximize();
		logger.info("Opened the Base URL");

		LoginPage lp = new LoginPage(driver);
		lp.setUserId(userId);
		lp.setPassword(password);
		lp.setLoginBtn();
		logger.info("Login done in Home Page ");
		Thread.sleep(5000);
		CustomerPage cp = new CustomerPage(driver);
		cp.getNewCoustomer();
		Thread.sleep(5000);
		cp.setName(name);
		logger.info("Name is Passed");
		cp.setGender(gender);
		logger.info("Gender is Selected ");
		cp.setDob(dob);
		logger.info("Data Of Birth is Passed");
		cp.setAddress(address);
		logger.info("Address is passed ");
		cp.setCity(city);
		logger.info("City  is Passed");
		cp.setState(state);
		logger.info("State is Passed");
		cp.setPincode(pin);
		logger.info("Pincode  is Passed");
		cp.setTelephone(mobile);
		logger.info("Mobile contact  is Passed");
		String email = randomestring() + "@gmail.com";
		cp.setEmail(email);
		logger.info("Email is Passed");
		cp.setPassword2(password);
		logger.info("User password is Passed");
		cp.clickSubmit();
		logger.info("Submitted the Button");
		Thread.sleep(5000);

		String msg = driver.findElement(By.xpath("//*[text()='Customer Registered Successfully!!!']")).getText();
		if (msg.contains("Customer Registered Successfully!!!")) {
			Assert.assertTrue(true);
			logger.info("Added new Customer info Successfully");
			logger.info("TestCase is passed ");
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
		
		goHomePage();
		Thread.sleep(5000);

	}

}
