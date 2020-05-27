package com.gurudemo.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.gurudemo.utilities.ReadConfig;
//import com.gurudemo.utilities.ReadConfig;
import com.gurudemo.utilities.XLUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	// ReadConfig configobj = new ReadConfig();
	// public String baseUrl = configobj.getApplicationUrl();
	// public String userId = configobj.getUserId();
	// public String password = configobj.getPassword();

	ReadConfig configobj = new ReadConfig();

	public String baseurl = configobj.getApplicationUrl();
	public String userId = configobj.getUserId();
	public String password = configobj.getPassword();
	public String name = configobj.getName();
	public String gender = configobj.getPassword();
	public String dob=configobj.getDob();
	public String address = configobj.getAddress();
	public String city = configobj.getCity();
	public String state = configobj.getState();
	public String pin = configobj.getPin();
	public String mobile = configobj.getMobile();
	
	//public String email = configobj.getEmail();
	public String pass = configobj.getPassword1();
	public static WebDriver driver;

	public static Logger logger;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		logger = Logger.getLogger("Guru99 Demos");
		// PropertyConfigurator.configure(System.getProperty(("user.dir")+"/Log4j.properties"));

		PropertyConfigurator.configure("GuruAppLoggs.properties");
		//driver.get(baseurl);
		// driver.get("http://demo.guru99.com/v4/manager/addcustomerpage.php");
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "//Screenshots//" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/gurudemo/testdata/LoginData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}

		return logindata;

	}

	public void alertHandle()
	{
		driver.switchTo().alert().accept();
	}
	
	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}

	public void goHomePage()
	{
		driver.findElement(By.xpath("//*[text()='Home']")).click();
		logger.info("Home Page ");
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
