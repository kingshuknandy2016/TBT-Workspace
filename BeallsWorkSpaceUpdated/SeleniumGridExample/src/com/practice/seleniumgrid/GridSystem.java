package com.practice.seleniumgrid;

import java.net.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridSystem {

	 public WebDriver driver;
	   public String URL, Node;
	   public static String recording="Yes";
	   
	   
	   public void launchapp(String browser) throws MalformedURLException
	   {
	      String URL = "http://www.calculator.net";
	      
	      if (browser.equalsIgnoreCase("firefox"))
	      {
	         System.out.println(" Executing on FireFox");
	         String Node = "http://10.0.102.112:5555/wd/hub";
	         //DesiredCapabilites is used to set the type of browser and OS that we will automate
	         DesiredCapabilities cap = DesiredCapabilities.firefox();
	         cap.setBrowserName("firefox");
	         cap.setPlatform(Platform.WINDOWS);
	         
	         //driver = new RemoteWebDriver(new URL(Node), cap);
	         driver = new RemoteWebDriver(new URL(Node), cap);
	         // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
	         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	         
	         // Launch website
	         driver.navigate().to(URL);
	         driver.manage().window().maximize();
	      }
	      else if (browser.equalsIgnoreCase("chrome"))
	      {
	         System.out.println(" Executing on CHROME");
	         DesiredCapabilities cap = DesiredCapabilities.chrome();
	         cap.setBrowserName("chrome");
	         String Node = "http://10.0.102.112:5557/wd/hub";
	         driver = new RemoteWebDriver(new URL(Node), cap);
	         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	         
	         // Launch website
	         driver.navigate().to(URL);
	         driver.manage().window().maximize();
	      }

	      else if (browser.equalsIgnoreCase("ie"))
	      {
	         System.out.println(" Executing on IE");
	         DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
	         cap.setBrowserName("internet explorer");
	         cap.setPlatform(Platform.WINDOWS);
	         String Node = "http://10.0.102.112:5558/wd/hub";
	         driver = new RemoteWebDriver(new URL(Node), cap);
	         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	         
	         // Launch website
	         driver.navigate().to(URL);
	         driver.manage().window().maximize();
	      }
	      else
	      {
	         throw new IllegalArgumentException("The Browser Type is Undefined");
	      }
	   }
	   
	   
	   public static void main(String[] args) throws MalformedURLException {
		   GridSystem gd=new GridSystem();
		   gd.launchapp("firefox");
	}
	
}
