package com.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BrowserNavigation {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.ksrtc.in");
		
		
		
		driver.findElement(By.partialLinkText("[Register]")).click();
		
		
		Thread.sleep(2000);
		
		driver.navigate().back();//browser back button
		Thread.sleep(2000);
		
		driver.navigate().forward();//browser forward button
		Thread.sleep(2000);
		
		driver.findElement(By.name("txtUserLoginID")).sendKeys("kingshuk");
		WebElement ele=driver.findElement(By.name("selectNationality"));
		Select se=new Select(ele);
		se.selectByValue("F");
		
		//driver.findElement(By.name("selectNationality")).click();
		//driver.findElement(By.xpath("//select[@name='selectNationality']//option[2]")).click();
		
		
		
		
		driver.navigate().refresh();//browser reload
		
		driver.getCurrentUrl();
		driver.navigate().to("https://www.google.co.in");//to go other url
		
		

	}

}
