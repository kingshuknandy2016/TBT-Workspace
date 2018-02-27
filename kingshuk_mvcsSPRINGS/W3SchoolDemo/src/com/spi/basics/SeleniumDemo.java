package com.spi.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       WebDriver driver=new FirefoxDriver();
       driver.get("http://www.spiproject.com");
       driver.manage().window().maximize();
       
       
       driver.findElement(By.xpath("//table[@id='tblLogin']//td//input[@id='Login1_UserName']")).sendKeys("satyakam.m");
       driver.findElement(By.xpath("//input[@id='Login1_Password']")).sendKeys("26081991");
       driver.findElement(By.xpath("//input[@id='Login1_LoginButton']")).click();
     //input[@id='Login1_LoginButton']
     
	}

}
