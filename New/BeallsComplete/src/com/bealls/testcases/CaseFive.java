package com.bealls.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Ordering;


public class CaseFive {

	public static WebDriver chrome = null;
	public static List <Double>allItems = null;
	public static  List <Double>titemsPerPage;
	public static String[] price=null;
	public static WebDriverWait wait = null;
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebElement divPopup ;
		System.setProperty("webdriver.chrome.driver",
				"C:/My Files/Selenium/Chrome driver new/chromedriver.exe");
		allItems = new ArrayList<Double>();

		chrome= new ChromeDriver();
//		chrome = new FirefoxDriver();
//		chrome.get("http://a3.beallsflorida.com/");
		wait= new WebDriverWait(chrome, 7);
		chrome.get("http://www.beallsflorida.com/");
        chrome.manage().window().maximize();
		
        chrome.navigate().refresh();
		WebElement men = chrome.findElement(By.xpath("html/body/header/nav/a[6]"));
		 
		 Actions builder = new Actions(chrome);
		 Action mouseOver= builder.moveToElement(men).build();
		 
		 mouseOver.perform();
		 
		 Thread.sleep(500);
		 
		 WebElement tshirts = chrome.findElement(By.xpath("html/body/header/nav/div[6]/div/div[1]/span[1]/li[1]/a"));
		 tshirts.click();
		 
		 Select sortyBy = new Select(chrome.findElement(By.id("orderBy")));
		 sortyBy.selectByIndex(2);
		 Thread.sleep(800);
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
		 
		 
		 int d1=Integer.parseInt(num[6])-Integer.parseInt(num[4]);
		 int d2 = Integer.parseInt(num[6]) - d1;
		 if(d2 == itemsPerPage)

			try
			 {
				 wait.until(ExpectedConditions.visibilityOf(chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div/div["+d2+"]/div[2]/div[3]/div[1]"))));
			 }
			 catch (TimeoutException e) {
				 	reloadPage();
			}
		 
		 
		 
		 while(lowerLimit<=upperLimit && total<Integer.parseInt(num[6]))
	{
			
  		 
			 
			 
		 num  =chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div[1]/div")).getText().split(" ");
//		 System.out.println("Ul "+num[4]+" Ll "+num[2]);
		  itemsPerPage =(Integer.parseInt(num[4])-Integer.parseInt(num[2]))+1;
//		 System.out.println("Items per page "+itemsPerPage);
		 
		 WebElement items = chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div/div[1]/div[2]/div[2]/a"));
	
		 titemsPerPage= new ArrayList<Double>();
		 for (int counter =1;counter<=itemsPerPage;counter++)
		 {
			 
			 
			
			 
			 try
			 {
			 divPopup = chrome.findElement(By.className("fsrFloatingMid"));
			 divPopup = chrome.findElement(By.className("fsrCloseBtn"));
			 System.out.println("Element found");
			 divPopup.click();
			 Thread.sleep(600);
            items = chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div/div["+counter+"]/div[2]/div[3]/div[1]")); 
			 elementPresent("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div/div["+counter+"]/div[2]/div[3]/div[1]");
			 
			 if(counter%5==0)
			 {
			 ((JavascriptExecutor) chrome).executeScript(
	                "arguments[0].scrollIntoView();", items);
			 }
			 }
			 catch(NoSuchElementException exception)
			 {
				 try{
				 items = chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div/div["+counter+"]/div[2]/div[3]/div[1]"));
				 
				 elementPresent("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div/div["+counter+"]/div[2]/div[3]/div[1]");
				 
				 if(counter%5==0)
				 {
				 ((JavascriptExecutor) chrome).executeScript(
		                "arguments[0].scrollIntoView();", items);
				 }
				 }
				 catch(java.util.NoSuchElementException exp)
				 {
					 divPopup = chrome.findElement(By.className("fsrFloatingMid"));
					 divPopup = chrome.findElement(By.className("fsrCloseBtn"));
					 System.out.println("Element found");
					 divPopup.click();
					 Thread.sleep(600);
				 }
			 }
             
				 
			 total++;
			 
		 }
		 
 
		 
		 
		 Collections.reverse(titemsPerPage);
		 //Test result pagewise
		 if(!Ordering.natural().isOrdered(titemsPerPage))
			System.out.println("The prices are not in descending  order in page "+lowerLimit);
		 else
			System.out.println("The prices are in descending  order in page "+lowerLimit);
		
		 //verfication purpose code
//		 List <Double > tlist = new ArrayList<Double>(titemsPerPage);
//		 Collections.sort(tlist);
//		 
//		 for(int i=0;i<tlist.size();i++)
//			 System.out.println(tlist.get(i)+"\t\t\t"+titemsPerPage.get(i));
		 
		 
		 
		 
//		 System.out.println("Displayed "+itemsPerPage+" in page "+lowerLimit);
		 Thread.sleep(1000);
			
		 	//next navigation click
		 	if(lowerLimit<=1 && (itemsPerPage==30 || itemsPerPage == 90 || itemsPerPage==60))
		 	{
			chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[3]/div/div[3]/div[2]/div/div/a[1]/span")).click();
			Thread.sleep(5000);
		 	}
			else
			{
			if(itemsPerPage==30 || itemsPerPage == 90 || itemsPerPage==60)
			chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[3]/div/div[3]/div[2]/div/div/a[3]/span")).click();
			Thread.sleep(5000);
			}  							
			
			data = chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[1]/div[3]/div/span")).getText();
			String nar[] = data.split(" ");
			
			lowerLimit = Integer.parseInt(nar[0]);
			
			 d1=Integer.parseInt(num[6])-Integer.parseInt(num[4]);
			  d2 = Integer.parseInt(num[6]) - d1;
//			 if(d2 == itemsPerPage)
	
				try
				 {
					 wait.until(ExpectedConditions.visibilityOf(chrome.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[3]/div/div[2]/div/div["+d2+"]/div[2]/div[3]/div[1]"))));
				 }
				 catch (TimeoutException e) {
					 	reloadPage();
				}
            
					
	}
		
		 
        System.out.println(allItems.size());
        
        Collections.reverse(allItems);
//        
//        for(int j =0;j<allItems.size();j++)
//        	System.out.println(allItems.get(j));
        
        if(!Ordering.natural().isOrdered(allItems))
        System.out.println("All prices are not in descending  order");
        else
        System.out.println("All prices are in descending  order");

        
        chrome.quit();
        
        

	}
	public static String tempprice=null;
	public static boolean elementPresent(String xpath)
	{
		boolean found =false;
	
		try
		{
			WebElement element = chrome.findElement(By.xpath(xpath));
			String item= chrome.findElement(By.xpath(xpath)).getText();
			price = item.split("-");
			tempprice = price[0].trim();
			Double data = Double.parseDouble(tempprice.substring(1, tempprice.length()));
			titemsPerPage.add(data);
			allItems.add(data);
			

		}
		catch(NoSuchElementException ex)
		{
			 System.out.println(ex);
		}
		
		
		
		
		return found;
	}

	public static void reloadPage()
	{
		System.out.println("Inside reload function");
					chrome.navigate().refresh();
	
	
	}

}
