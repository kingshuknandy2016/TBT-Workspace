package com.spi.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Driver {
	
	public static WebDriver driver;
	public static String filePath="C:\\WorkSpace\\New\\BeallsPOMmodel\\Lib\\BeallsPOMModel.xls";
    @BeforeClass
	public void openApplication(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://d3.beallsflorida.com/online/shop/mens-t-shirts?orderBy=6");
	}
    
    @Test
    public void testMethod() throws InterruptedException{
		Executor exe=new Executor();
		exe.run();
	}
    
    @AfterClass
	public void closeBrowser(){

		driver.close();
		driver.quit();
	
	}
	

}
