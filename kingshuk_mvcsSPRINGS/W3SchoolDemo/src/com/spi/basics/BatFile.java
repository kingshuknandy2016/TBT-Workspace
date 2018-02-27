package com.spi.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BatFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	 System.out.println("Hi this is a bat file ....");
     WebDriver driver=new FirefoxDriver();
     String st=driver.findElement(By.tagName("a")).findElement(By.tagName("h2")).getText();
	}

}
