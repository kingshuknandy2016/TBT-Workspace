package com.spi.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Firstproject {

	
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")
					+ "\\jars\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("www.w3schools.com");
	
}
}
