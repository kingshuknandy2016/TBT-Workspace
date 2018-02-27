package com.bealls.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class CaseOne {

 
	public static void main(String[] args) throws InterruptedException {
		

//		FirefoxProfile profile = new FirefoxProfile();
//		profile.setAcceptUntrustedCertificates(true);
//		profile.setAssumeUntrustedCertificateIssuer(false);
		
		
//	 WebDriver firefox = new FirefoxDriver();
	 
//	 firefox.get("http://a3.beallsflorida.com/");
	 
		System.setProperty("webdriver.chrome.driver","C:/My Files/Selenium/Chrome driver new/chromedriver.exe");
		 
	 WebDriver chrome = new ChromeDriver();
	 chrome.get("http://a3.beallsflorida.com/");
	
	 chrome.manage().window().maximize();
	 
		
	 WebElement kids = chrome.findElement(By.xpath("html/body/header/nav/a[7]"));
	 
	 Actions builder = new Actions(chrome);
	 Action mouseOver= builder.moveToElement(kids).build();
	 
	 mouseOver.perform();
	 
		
        Thread.sleep(600);
		chrome.quit();
//		System.exit(0);
		
	}

}
