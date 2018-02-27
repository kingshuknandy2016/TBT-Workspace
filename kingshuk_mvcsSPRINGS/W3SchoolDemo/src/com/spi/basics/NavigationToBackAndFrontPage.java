package com.spi.basics;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class NavigationToBackAndFrontPage {
	public static WebDriver driver=null;
	
	//Below method is used to get the main window handle. we will the driver as parameter.
	public static String getMainWindowHandle(WebDriver driver) {
		return driver.getWindowHandle();
	}
	
	//Below method is used to get the current window title
	public static String getCurrentWindowTitle() {
		String windowTitle = driver.getTitle();
		return windowTitle;
	}
	
	//Below method is used to close all the other windows except the main window.

	public static boolean closeAllOtherWindows(WebDriver driver, String openWindowHandle) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			if (!currentWindowHandle.equals(openWindowHandle)) {
				driver.switchTo().window(currentWindowHandle);
				driver.close();
			}
		}
		
		driver.switchTo().window(openWindowHandle);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	
	//Below method is used to wait for the new window to be present and switch to it.

	 public static void waitForNewWindowAndSwitchToIt(WebDriver driver) throws InterruptedException {
	        String cHandle = driver.getWindowHandle();
	        String newWindowHandle = null;
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        
	        //Wait for 20 seconds for the new window and throw exception if not found
	        for (int i = 0; i < 20; i++) {
	            if (allWindowHandles.size() > 1) {
	                for (String allHandlers : allWindowHandles) {
	                    if (!allHandlers.equals(cHandle))
	                    	newWindowHandle = allHandlers;
	                }
	                driver.switchTo().window(newWindowHandle);
	                break;
	            } else {
	                Thread.sleep(1000);
	            }
	        }
	        if (cHandle == newWindowHandle) {
	            throw new RuntimeException(
	                    "Time out - No window found");
	        }
	    }

	public static void main(String[] args) throws InterruptedException {
		
		 driver= new FirefoxDriver();
		driver.get("http://www.w3schools.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		System.out.println("Title:::::"+NavigationToBackAndFrontPage.getCurrentWindowTitle());
		String MainPage=NavigationToBackAndFrontPage.getCurrentWindowTitle();
		//String mainHandle = driver.getWindowHandle();
		


      //open a new window on click of hyperlink
      WebElement link = driver.findElement(By.xpath("//nav[@id='sidemenu']//a[3]"));
      Actions newWindow = new Actions(driver);
      newWindow.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
      Thread.sleep(6000);
      for(String winHandle : driver.getWindowHandles()){
          driver.switchTo().window(winHandle);
        }
     // NavigationToBackAndFrontPage.getMainWindowHandle(driver);
      System.out.println("Title:::::"+NavigationToBackAndFrontPage.getCurrentWindowTitle());
      
      String st=driver.findElement(By.xpath("id('main')//span")).getText();
      System.out.println("------------:::"+st);
      

      System.out.println("Title:::::"+NavigationToBackAndFrontPage.getCurrentWindowTitle());
      
		
      
		
	}

}
