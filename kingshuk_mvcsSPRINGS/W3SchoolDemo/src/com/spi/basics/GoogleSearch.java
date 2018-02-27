package com.spi.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.Wait;

public class GoogleSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		WebDriver driver=new FirefoxDriver();
	driver.get("https://www.google.co.in");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElement(By.cssSelector("input#gs_htif0")).sendKeys("NANDy");

	}

}
