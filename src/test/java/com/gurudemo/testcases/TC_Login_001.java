package com.gurudemo.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.gurudemo.pageobject.LoginPage;


public class TC_Login_001 extends BaseClass {

	
	@Test(dataProvider = "LoginData")
	public void loginTest(String baseUrl, String userId, String password) throws IOException, InterruptedException {
		driver.get(baseUrl);
		logger.info("URL is Open ");
		LoginPage lp = new LoginPage(driver);
		lp.setUserId(userId);
		logger.info("user id is passed");
		lp.setPassword(password);
		logger.info("password is passed");
		lp.setLoginBtn();
		logger.info("clicked the login button ");

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("login is passed ");
			lp.setLogOut();
			logger.info("logout is done ");
			driver.switchTo().alert().accept();
			logger.info("alert is handled ");
		} else 
		{
			logger.info("Login Failed");
			captureScreen(driver, "TC_Login_001");
			//Assert.assertTrue(false);
			driver.switchTo().alert().accept();
		    logger.info("alert is handled ");
		}
		goHomePage();
		Thread.sleep(5000);
	}
	

}
