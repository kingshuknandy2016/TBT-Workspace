package com.spi.basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageBypageNavigation {


	public static void main(String[] args) throws InterruptedException {
	WebDriver driver= new FirefoxDriver();
	driver.get("http://www.w3schools.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
	
	List <WebElement>  Menu=driver.findElements(By.xpath("//nav[@id='sidemenu']//a"));
	for (int i = 1; i <Menu.size(); i++) {
		Menu.get(i).click();
		List <WebElement>  SubMenu=driver.findElements(By.xpath("//div[@id='leftmenuinnerinner']/a"));
		 String winHandleBefore = driver.getWindowHandle();
		 System.out.println("winHandleBefore"+winHandleBefore);
		for (int j = 2; j <=SubMenu.size(); j++) {
			  /* List <WebElement> topics=driver.findElements(By.tagName("h2"));
			   
			   for (int j2 = 1; j2 <= topics.size(); j2++) {
				  topics.get(j2)
				  ;*/
				 
				 System.out.println("No of times::"+j);  
				  
			//}
			
		}
		//driver.switchTo().window(winHandleBefore);
		driver.get("http://www.w3schools.com/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		System.out.println("Inside Main Menu page::"+i);
	}

	}

	
	
	
}
