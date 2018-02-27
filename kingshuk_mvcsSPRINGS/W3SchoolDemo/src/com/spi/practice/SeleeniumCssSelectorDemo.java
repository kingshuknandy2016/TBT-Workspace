package com.spi.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.Wait;

public class SeleeniumCssSelectorDemo {


	public static void main(String[] args) {
    WebDriver driver=new FirefoxDriver();
    driver.get("http://www.surveyspaysu.com/signup/final-step/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    try {
		
    	
        WebElement name=driver.findElement(By.cssSelector(".wf-input"));
        name.sendKeys("King");
        driver.findElement(By.cssSelector("input.wf-input.wf-valid__email")).sendKeys("Pattt@spi.mail");
        //input[id^=’Em’]
        driver.findElement(By.cssSelector("input[name*='sto']")).sendKeys("Pune");
        
        driver.findElement(By.cssSelector("input:contains('Sign Up')")).click();
	} catch (Exception e) {
		System.out.println("error:::"+e);
	}


	}

}
