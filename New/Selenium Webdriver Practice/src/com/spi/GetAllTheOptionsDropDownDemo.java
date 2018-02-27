package com.spi;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class GetAllTheOptionsDropDownDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.ksrtc.in/AWATAROnline/?action=reg");
		
		
		WebElement countryDropDownElement = driver.findElement(By.name("selectCountry"));
		
		
		Select countrySelObj = new Select(countryDropDownElement);
		
		
		List<WebElement> options = countrySelObj.getOptions();
		String[] expectedCountryList = null;
		
		for(WebElement element:options){
			System.out.println(element.getText());
		}
		
		

	}

}
