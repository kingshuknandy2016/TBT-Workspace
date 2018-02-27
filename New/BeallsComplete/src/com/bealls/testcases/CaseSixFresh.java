package com.bealls.testcases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Ordering;

public class CaseSixFresh {

	public static WebDriver chrome = null;
	public static List allItems = null;
	public static  List <String>titemsPerPage;
	public static WebDriverWait wait = null;
	public static void main(String[] args) throws InterruptedException {
		try
		{
		WebElement divPopup ;
 
		System.setProperty("webdriver.chrome.driver",
				"C:/My Files/Selenium/Chrome driver new/chromedriver.exe");
		allItems = new ArrayList<String>();

		chrome= new ChromeDriver();
		chrome.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//		chrome = new FirefoxDriver();
//		chrome.get("http://a3.beallsflorida.com/");
		
 
		chrome.get("http://www.beallsflorida.com/");
        chrome.manage().window().maximize();
		
		WebElement men = chrome.findElement(By.xpath("html/body/header/nav/a[6]"));
		 
		 Actions builder = new Actions(chrome);
		 Action mouseOver= builder.moveToElement(men).build();
		 
		 mouseOver.perform();
		 
		 Thread.sleep(500);
		 
		 WebElement tshirts = chrome.findElement(By.xpath("html/body/header/nav/div[6]/div/div[1]/span[1]/li[1]/a"));
		 tshirts.click();
		 
		 Select sortyBy = new Select(chrome.findElement(By.id("orderBy")));
		 sortyBy.selectByIndex(4);
		 Thread.sleep(1000);
//		 System.out.println(sortyBy.getFirstSelectedOption().getText());
		  
		 //60/page  
		 //chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/span[2]/a[1]")).click();
		 //Thread.sleep(1000);
		 //90/page 
		 chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/span[2]/a[2]")).click();
		 Thread.sleep(1000);		 
		 //int itemsPerPage =Integer.parseInt(chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/span[2]/span")).getText());
		 
		 
		 
		 String data = chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div[3]/div/span")).getText();
		 String ar [] = data.split(" ");
		
		 int upperLimit = Integer.parseInt(ar[ar.length-1]);
		 int lowerLimit = Integer.parseInt(ar[0].trim());
		 int total =0;
		 String num [] =chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div[1]/div")).getText().split(" ");
		
		 int itemsPerPage =(Integer.parseInt(num[4])-Integer.parseInt(num[2]))+1;
		 
 
			 
		 
		 
		 while(lowerLimit<=upperLimit && total<Integer.parseInt(num[6]))
	{
			
 
		 
		 num  =chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div[1]/div")).getText().split(" ");
//		 System.out.println("Ul "+num[4]+" Ll "+num[2]);
		  itemsPerPage =(Integer.parseInt(num[4])-Integer.parseInt(num[2]))+1;
//		 System.out.println("Items per page "+itemsPerPage);
		 
		 WebElement items = chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div/div[1]/div[2]/div[2]/a"));
	
		 titemsPerPage= new ArrayList<String>();
		 for (int counter =1;counter<=itemsPerPage;counter++)
		 {
			  
			 try
			 {
				
             items = chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div/div["+counter+"]/div[2]/div[2]/a"));
			 elementPresent("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div/div["+counter+"]/div[2]/div[2]/a");
			 if(counter%5==0)
			 {
			 ((JavascriptExecutor) chrome).executeScript(
	                "arguments[0].scrollIntoView();", items);
			 }
 
			 
			 
			 }
			 catch(NoSuchElementException exception)
			 {
				 try
				 {
				 items = chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div/div["+counter+"]/div[2]/div[2]/a"));
				 elementPresent("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div/div["+counter+"]/div[2]/div[2]/a");
				 
				 if(counter%5==0)
				 {
				 ((JavascriptExecutor) chrome).executeScript(
		                "arguments[0].scrollIntoView();", items);
				 }
 
				 }
				 catch(NoSuchElementException exp )
				 {
 
				 }
			 }
				 
			 total++;
			 
		 }
		 
		 //verfication purpose code
//		 List <String > tlist = new ArrayList<String>(titemsPerPage);
//		 Collections.sort(tlist);
//		 
//		 for(int i=0;i<tlist.size();i++)
//			 System.out.println(tlist.get(i)+"\t\t\t"+titemsPerPage.get(i));
		 
		 
		 //Test result pagewise
		 if(!Ordering.natural().isOrdered(titemsPerPage))
			System.out.println("The items are not sorted according to best seller in page "+lowerLimit);
		 else
			System.out.println("The items are sorted according to best seller in page "+lowerLimit);
		
		 
//		 System.out.println("Displayed "+itemsPerPage+" in page "+lowerLimit);
		 Thread.sleep(900);
			
		 	//next navigation click
		 	if(lowerLimit<=1 && (itemsPerPage==30 || itemsPerPage == 90 || itemsPerPage==60))
		 	{
		 		
            try
            {
            	chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[3]/div/div[3]/div[2]/div/div/a[1]/span")).click();	
            }
            catch(TimeoutException exp)
			{
				reloadPage();
			}
            catch(WebDriverException exp )
            {
            	divPopup = chrome.findElement(By.className("fsrFloatingMid"));
				 divPopup = chrome.findElement(By.className("fsrCloseBtn"));
				 System.out.println("Element found");
				 divPopup.click();
				 Thread.sleep(200);
				 chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[3]/div/div[3]/div[2]/div/div/a[1]/span")).click();
				 
            }
 
            
            
		 	}
			else
			{
			if(itemsPerPage==30 || itemsPerPage==90 || itemsPerPage ==60)
			{
				try
				{
			chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[3]/div/div[3]/div[2]/div/div/a[3]/span")).click();
				}
				catch(TimeoutException exp)
				{
					reloadPage();
				}
				catch(WebDriverException exp)
				{
					divPopup = chrome.findElement(By.className("fsrFloatingMid"));
					 divPopup = chrome.findElement(By.className("fsrCloseBtn"));
					 System.out.println("Element found");
					 divPopup.click();
					 Thread.sleep(200);
					 chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[3]/div/div[3]/div[2]/div/div/a[3]/span")).click();
				}
			
			}
 
			
			}  							
			
			data = chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div[3]/div/span")).getText();
			String nar[] = data.split(" ");
			
			lowerLimit = Integer.parseInt(nar[0]);
			
 
					
	}
		
		 
        System.out.println(allItems.size());
        
        
        if(!Ordering.natural().isOrdered(allItems))
        System.out.println("The items are not sorted according to best seller");
        else
        System.out.println("The items are sorted according to best seller");

        
        chrome.quit();
        
		}
		catch(TimeoutException touexcep)
		{
			reloadPage();
			System.out.println("Loading issue");
		}

	}
	
	public static boolean elementPresent(String xpath)
	{
		boolean found =false;
	
		try
		{
			WebElement element = chrome.findElement(By.xpath(xpath+"/span"));
			

			String item= chrome.findElement(By.xpath(xpath)).getText();
			item = item.substring(4, item.length());
//			System.out.println("--->"+item);
			allItems.add(item.toUpperCase());
			titemsPerPage.add(item.toUpperCase());

		}
		catch(NoSuchElementException ex)
		{
			if(!chrome.findElement(By.xpath(xpath)).getText().contains("New!"))
			{
						allItems.add(chrome.findElement(By.xpath(xpath)).getText().toUpperCase());
						titemsPerPage.add(chrome.findElement(By.xpath(xpath)).getText().toUpperCase());
			}
		}
		
		
		
		
		return found;
	}
	
	public static void reloadPage()
	{
		System.out.println("Page reloaded ");
					chrome.navigate().refresh();
	
	
	}


}
