package com.spi.SearchDisplay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.google.common.collect.Ordering;
import com.relevantcodes.extentreports.model.ScreenCapture;
import com.spi.test.DriverOther;



public class SearchDisplayPage {

	//Variables for LowToHigh and HighToLow
	public static List<Double> prices;
	public static String Order="";
	public static int itemsPerpage;
	public static String status="Pass";
	
	//Variables for HighestRatings
	public static List<Double> ratings;
	
	
	
	 

	
	WebDriver driver;
	
	@FindBy(linkText=Constants.MENSLINKTEXT)
	WebElement mouseOverMens;
	
	
	@FindBy(linkText=Constants.TSHIRTSLINKTEXT)
	WebElement clickTshirts;
	
	@FindBy(id=Constants.IDORDERBY)
	WebElement orderBY;
	
	@FindBy(linkText=Constants.NINETYLINKTEXT)
	WebElement displayItemsPerPage;
	
	@FindBy(xpath=Constants.TOTALITEMSPERPAGE)
	WebElement getTotalItemsPerPage;
	
	@FindBy(xpath=Constants.PRICEPERITEM)
	WebElement scroll;
	
	@FindBy(xpath=Constants.NEXTPAGE)
	WebElement nextPageNavigator;
	
	@FindBy(className=Constants.CLOSEPOPUP)
	WebElement divpopup;
	
	
	

	public SearchDisplayPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
		
	
	
	
	public void mouseOver() {
		 
			Actions builder = new Actions(driver);
			Action mouseOver=null;
			try
			{
			mouseOver = builder.moveToElement(mouseOverMens).build();
			mouseOver.perform();
			sleepForOneSecond();
			}
			catch(WebDriverException exception)
			{
				divpopup.click();
				mouseOver = builder.moveToElement(mouseOverMens).build();
				mouseOver.perform();
				sleepForOneSecond();
			}
	}
	
	
	public void clickTshirts()
	{
		try
		{
		clickTshirts.click();
		sleepForOneSecond();
		}
		catch(WebDriverException exception)
		{
			divpopup.click();
			clickTshirts.click();
			sleepForOneSecond();
		}
	}
	
	
	public void selectOrderBy(String option)
	{
		Select sortyBy = null;
		try
		{
		sortyBy= new Select(orderBY);
		sortyBy.selectByVisibleText(option);
		Order = option;
		sleepForOneSecond();
		}
		catch(WebDriverException exception)
		{
			divpopup.click();
			sortyBy.selectByVisibleText(option);
			sleepForOneSecond();
		}
	}
	
	
	
	public void clickItemsPerPage()
	{
		try
		{
		displayItemsPerPage.click();
		sleepForOneSecond();
		}
		catch(NoSuchElementException exception)
		{
			System.out.println(exception);
		}
		
		catch(WebDriverException exception)
		{
			divpopup.click();
			displayItemsPerPage.click();
			sleepForOneSecond();
		}
	}
	
	
	
	public void sleepForOneSecond()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void getTotalItemsPerPage()
	{
		String num[] = getTotalItemsPerPage.getText().split(" ");
		itemsPerpage = (Integer.parseInt(num[4]) - Integer.parseInt(num[2])) + 1;
	}
	
	
	public void validateHighToLow_LowToHigh()
	{
		String locator=Constants.PRICEPERITEM;
		String[] price;
	 	prices = new ArrayList<Double>();
		String tempLocator = locator;
		WebElement element = null;
	 	 
		for (int counter = 1; counter <= itemsPerpage; counter++) {
			
			StringBuilder actualPrice = new StringBuilder();
			locator =locator.replace("*", String.valueOf(counter));
			element = DriverOther.driver.findElement(By.xpath(locator));
		
			if(element.getText().contains("-"))
			{
			 price= element.getText().split("-");
			 actualPrice  = actualPrice.append(price[0]).deleteCharAt(0);
			}
			else
			{
				if(!element.getText().isEmpty())
				{
			    actualPrice.append(element.getText()).deleteCharAt(0);
				}
				else
				{
					pageReload();
					validateHighToLow_LowToHigh();
					prices.clear();
					break;
				}
				
			}
				 
			Double data = Double.parseDouble(actualPrice.toString());
			prices.add(data);
			locator = tempLocator;
		}
	 
//		prices.add((double)1000);
		if(Order.contains("High to Low"))
		{
		Collections.reverse(prices);
		}
		
		if (!Ordering.natural().isOrdered(prices))
		{
			//ScreenCapture.Capture();
			//System.out.println("Unsorted");
			status="Fail";
			
		}
		else
		{
			//System.out.println("Sorted");
		   
		}
		
	}
	
	
	public  void pageReload()
	{
		driver.navigate().refresh();
		sleepForOneSecond();
	}
	
	public void clickNextPage()
	{
		try
		{
		nextPageNavigator.click();
		sleepForOneSecond();
		}
		catch(WebDriverException exception)
		{
		    divpopup.click();
			nextPageNavigator.click();
			sleepForOneSecond();
			
		}
		
	}
	
	
	
	//HighestRatings validation function
	public void validateHighestRatings()
	{
		String[] rate;
        ratings  = new ArrayList<Double>();
        String locator =Constants.RATINGPERITEM;
        
        String tempLocator = locator;
		WebElement element;
		for (int counter = 1; counter <= itemsPerpage; counter++) {
			locator =locator.replace("*", String.valueOf(counter));
	
			element =  DriverOther.driver.findElement(By.xpath(locator));
			rate= element.getAttribute("src").split("/");
 
			ratings.add(Double.parseDouble(rate[5].trim()));

			locator = tempLocator;
		}
		Collections.reverse(ratings);
	 
		if (!Ordering.natural().isOrdered(ratings))
		{
//			ScreenCapture.Capture();
			//System.out.println("Unsorted");
			status="Fail";
			
		}
		
		else
		{
		//	System.out.println("Sorted");
			
		}
		}
	
	public static  void toggleStatus()
	{
		SearchDisplayPage.status="Pass";
	}
	
}
