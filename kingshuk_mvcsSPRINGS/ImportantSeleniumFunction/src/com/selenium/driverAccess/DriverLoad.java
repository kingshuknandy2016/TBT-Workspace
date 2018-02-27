 package com.selenium.driverAccess;

 
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverLoad {
	public WebDriver Load(String browzername){
	     	WebDriver driver=null;
		    if(browzername.equalsIgnoreCase("IE")){
				System.setProperty("webdriver.ie.driver", "Files/IEDriverServer.exe");
				System.out.println(System.getProperty("webdriver.ie.driver"));
 				driver = new InternetExplorerDriver();
				
			}else if(browzername.equalsIgnoreCase("Firefox")){
	            driver=new FirefoxDriver();
				
			}else if(browzername.equalsIgnoreCase("Chrome")){
				System.setProperty("webdriver.chrome.driver", "Files/chromedriver.exe");
	        	driver = new ChromeDriver();
	
			} 
		    
		return driver;
	}


	public static void main(String[] args) {
		DriverLoad dap=new DriverLoad();
       WebDriver driver=dap.Load("Chrome");
       driver.get("http://www.w3schools.com/");
       System.out.println("-----------------------");

	}

}
