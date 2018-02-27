package com.spi.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpecificTaskComparism {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
WebDriver driver=null;
		
		System.setProperty("webdriver.chrome.driver", "Files/chromedriver.exe");
	        	driver = new ChromeDriver();
		
		driver.get("http://www.spiproject.com/spiproject/");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.NANOSECONDS);
		
		
		driver.manage().window().maximize() ;
		WebElement username=driver.findElement(By.xpath("//input[@id='Login1_UserName']"));
		username.sendKeys("murugan.kn");
		
		WebElement password=driver.findElement(By.xpath("//input[@id='Login1_Password']"));
		password.sendKeys("asf");
		
		WebElement button1=driver.findElement(By.xpath("//input[@id='Login1_LoginButton']"));
		button1.click();
		try {
			driver.findElement(By.xpath("//ul[@id='mega-menu-2']//a[contains(text(),'Timesheet')]")).click();
			Thread.sleep(4000);
			WebElement webb=driver.findElement(By.xpath("//h3//label[@title='MST 2016 D2C WMS Support']"));
			Thread.sleep(4000);
			String st=webb.getText();
			System.out.println("::::"+st);
			
		} catch (Exception e) {
			System.out.println("erroe:::"+e);
		}


	}

}
