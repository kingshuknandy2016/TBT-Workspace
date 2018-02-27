package com.spi.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TimeSheetFillUp {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=null;
		
		System.setProperty("webdriver.chrome.driver", "Files/chromedriver.exe");
	        	driver = new ChromeDriver();
		
		driver.get("http://www.spiproject.com/spiproject/");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.NANOSECONDS);
		
		
		driver.manage().window().maximize() ;
		WebElement username=driver.findElement(By.xpath("//input[@id='Login1_UserName']"));
		username.sendKeys("kingshuk.nandy");
		
		WebElement password=driver.findElement(By.xpath("//input[@id='Login1_Password']"));
		password.sendKeys("9007438097.kingshuk");
		
		WebElement button1=driver.findElement(By.xpath("//input[@id='Login1_LoginButton']"));
		button1.click();
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath(".//*[@id='mega-menu-2']/li[5]/a")).click(); 
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='ctl00_body_ucMyTimesheet_imgPreviousWeek']")).click();
		
	}

}
