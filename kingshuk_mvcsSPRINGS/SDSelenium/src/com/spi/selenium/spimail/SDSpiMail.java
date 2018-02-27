package com.spi.selenium.spimail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SDSpiMail {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://spimail.spi.com/");
		driver.manage().window().maximize();
		
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys("suvodip.ghosh");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("$picity12345");
		
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//td[@id='DWT22_dropdown']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='logOff_title']")).click();
		
		/*driver.quit();*/
	}

}
