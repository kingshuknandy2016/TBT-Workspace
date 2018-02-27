package com.spi.practice.copy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButtonsdemo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.beginnersguidetohtml.com/guides/html/forms/radio-buttons");
		driver.manage().window().maximize();
		
		
		List <WebElement>  sexradioButton= driver.findElements(By.name("sex"));
        
		for(WebElement index:sexradioButton){
			index.click();
			Thread.sleep(1000);
		}
	}

}
