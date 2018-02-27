package com.spi.selenium.driverload;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SDWebDriverTest {

	public static void main(String[] args) {
		WebDriver driver1 = new FirefoxDriver();
		WebDriver driver2 = new FirefoxDriver();
		WebDriver driver3 = new FirefoxDriver();
		
		driver1.get("https://www.google.co.in/");
		System.out.println(driver1.getTitle());
		
		driver2.get("https://www.google.co.in/");
		System.out.println(driver2.getTitle());
		
		driver3.navigate().to("javatpoint.com");
		System.out.println(driver3.getTitle());
	}

}
