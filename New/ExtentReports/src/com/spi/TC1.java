package com.spi;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC1 {

	ExtentReports extent;
	ExtentTest test;
	WebDriver driver;

	@BeforeClass
	public void M1() {
		
		extent = ExtentManager.Instance();
		System.setProperty("webdriver.chrome.driver", "C:\\Sandalone server\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
	}

	@Test
	public void OpenAUT() {
		try {
			driver.get("http://www.qavalidation.com/");
			test = extent.startTest("OpenUT", "Verify HomePage");
			if (driver.getTitle().contains("QA & Validation"))
				test.log(LogStatus.PASS, driver.getTitle() + " contain "
						+ "QA & Validation");
			else
				test.log(LogStatus.FAIL, driver.getTitle()
						+ " doesn't contain " + "QA & Validation");
		} catch (Exception e) {
			test.log(LogStatus.ERROR, e.getMessage());
		}
	}

	@AfterClass
	public void tear() {
		extent.endTest(test);
		extent.flush();
		extent.close();
		driver.quit();
	}
}