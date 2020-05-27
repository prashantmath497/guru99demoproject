package com.gurudemo.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gurudemo.pageobject.EditCustomerPage;
import com.gurudemo.pageobject.LoginPage;

public class TC_CustomerEditPage extends BaseClass {

	@Test
	public void editCustomer() throws IOException, InterruptedException {
		driver.get(baseurl);
		logger.info("Application URL is Opened ");
        driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		lp.setUserId(userId);
		lp.setPassword(password);
		lp.setLoginBtn();
		logger.info("Logged in Application Home Page ");

		EditCustomerPage ecp = new EditCustomerPage(driver);
		ecp.getClickOnEditBtn();
		logger.info("Edit Page is Openned ");
		ecp.setCustId("14447");
		ecp.btnSubmit();
		logger.info("Customer Deatails Opened ");
		ecp.changeAdd("Managlore");
		logger.info("Customer Address is Changed");
		ecp.subbtn();
		logger.info("Sumbitted the Data ");
		String captureText = driver.findElement(By.xpath("//*[contains(text(),'update')]")).getText();
		if (captureText.contains("Customer details updated Successfully!!!")) {
			Assert.assertTrue(true);
			logger.info("TestCase is passed ");

		} else {
			captureScreen(driver, "editCustomer");
			Assert.assertFalse(false);
			logger.info("TestCase is Fails ");
		}
		
		Thread.sleep(5000);
		goHomePage();
		Thread.sleep(5000);

	}
}
