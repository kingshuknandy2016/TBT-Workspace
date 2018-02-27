package com.spi.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CommonUtilities {

	
	WebDriver driver=null;
	   
	public void landingPage(){
		
	    driver=new FirefoxDriver();
	    driver.get("http://www.beallsflorida.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void hoverOnCatogoryAndClick(){
		Actions actions = new Actions(driver);
		//Hover on Mens Catagory
	    WebElement mainMenu = driver.findElement(By.xpath("(//a[contains(text(),'Men')])[1]"));
	    actions.moveToElement(mainMenu).build().perform();
	    
	    //Click on T-Shirts
	    WebElement SubMenu=driver.findElement(By.xpath("//a[contains(text(),'T-Shirts')]"));
	    SubMenu.click();
	}
}
