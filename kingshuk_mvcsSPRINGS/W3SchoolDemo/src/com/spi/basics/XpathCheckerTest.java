package com.spi.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class XpathCheckerTest {

	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/kingshuk.nandy/Downloads/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.w3schools.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//Relative path
		//driver.findElement(By.xpath("//body/div[@class='w3-theme w3-card-2 w3-topnav w3-right-align w3-slim']/div[@class='topnavlinks']/a[@id='navbtn_tutorials']")).click();
		//Absolute path
		driver.findElement(By.xpath(".//*[@id='sidemenu']/a[2]")).click();
	}

}
