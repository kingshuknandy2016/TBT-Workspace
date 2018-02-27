package com.bealls.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CaseTwo {

	public static WebDriver chrome = null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/My Files/Selenium/Chrome driver new/chromedriver.exe");

		chrome= new ChromeDriver();
//		chrome.get("http://a3.beallsflorida.com/");
		chrome.get("http://www.beallsflorida.com/");
        chrome.manage().window().maximize();
        chrome.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		WebElement kids = chrome.findElement(By.xpath("html/body/header/nav/a[7]"));
		 
		 Actions builder = new Actions(chrome);
		 Action mouseOver= builder.moveToElement(kids).build();
		 
		 mouseOver.perform();
		 
		 Thread.sleep(500);
		 
		 WebElement tshirts = chrome.findElement(By.xpath("html/body/header/nav/div[6]/div/div[1]/span[1]/li[1]/a"));
		 tshirts.click();
		 System.out.println("//////////1//");
		 Select sortyBy = new Select(chrome.findElement(By.id("orderBy")));
		 sortyBy.selectByIndex(5);
		 System.out.println("//////////2//");
		 Thread.sleep(1000);
		 System.out.println(sortyBy.getFirstSelectedOption().getText());
		  
		 //60/page  
		 //chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/span[2]/a[1]")).click();
		 //Thread.sleep(1000);
		 //90/page 
		 //chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/span[2]/a[2]")).click();
		 //Thread.sleep(1000);
		 
		 

				 
		 
				 
				 
 
		 
//		 int itemsPerPage =Integer.parseInt(chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/span[2]/span")).getText());
		 
		 
		 
		 String data = chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div[3]/div/span")).getText();
		 System.out.println("check::"+data);
		 String ar [] = data.split(" ");
		 
		 int upperLimit = Integer.parseInt(ar[ar.length-1]);
		 int lowerLimit = Integer.parseInt(ar[0].trim());
		 
		 while(lowerLimit<=upperLimit)
	{
			 
			
	
		 System.out.println("Upper limit "+ar[ar.length-1]);
		 System.out.println("Lower limit "+lowerLimit);
		 
		 String num [] =chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div[1]/div")).getText().split(" ");
		 System.out.println("Ul "+num[4]+" Ll "+num[2]);
		 int itemsPerPage =(Integer.parseInt(num[4])-Integer.parseInt(num[2]))+1;
		 System.out.println("Items per page "+itemsPerPage);
		 
		 WebElement items = chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div/div[1]/div[2]/div[2]/a"));
		 for (int counter =1;counter<=itemsPerPage;counter++)
		 {
			 items = chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div/div["+counter+"]/div[2]/div[2]/a"));
			 
			 elementPresent("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div/div["+counter+"]/div[2]/div[2]/a");
			 if(counter%5==0)
			 {
			 ((JavascriptExecutor) chrome).executeScript(
	                "arguments[0].scrollIntoView();", items);
			 
			 }
			 
		 }
		 System.out.println("Displayed "+itemsPerPage+" in page "+lowerLimit);
		 Thread.sleep(1000);
			
		 	//next navigation click
		 
		 	if(lowerLimit<=1 && itemsPerPage==30)
		 	{
		 		
 
			chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[3]/div/div[3]/div[2]/div/div/a[1]/span")).click();
			Thread.sleep(7000);
		 	}
			else
			{
			if(itemsPerPage==30)
			chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[3]/div/div[3]/div[2]/div/div/a[3]/span")).click();
			Thread.sleep(7000);
			}  							
			
			data = chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div[3]/div/span")).getText();
			String nar[] = data.split(" ");
			
			lowerLimit = Integer.parseInt(nar[0]);
					
	}
		
 

	}
	
	public static boolean elementPresent(String xpath)
	{
		boolean found =false;
	
		try
		{
			WebElement element = chrome.findElement(By.xpath(xpath+"/span"));
			System.out.print(chrome.findElement(By.xpath(xpath)).getText()+"->");
			System.out.println("Found");
		}
		catch(NoSuchElementException ex)
		{
			System.out.print(chrome.findElement(By.xpath(xpath)).getText()+"\t->\t");
			System.out.println("Element not found");
		}
		
		
		
		
		return found;
	}

}
