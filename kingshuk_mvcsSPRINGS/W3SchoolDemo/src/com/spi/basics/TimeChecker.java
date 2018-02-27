package com.spi.basics;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TimeChecker {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {

		//-------------Fetching current date
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println("Date:"+dateFormat.format(date)); 
		int st=date.getDate();
		System.out.println("Day"+st);
		
		
		//--------------Opening current site
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "C:/Users/kingshuk.nandy/Downloads/chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.get("http://www.spiproject.com/spiproject/");
		
		Thread.sleep(2000);  
		
		
		driver.manage().window().maximize() ;
		WebElement username=driver.findElement(By.xpath("//input[@id='Login1_UserName']"));
		username.sendKeys("kingshuk.nandy");
		
		WebElement password=driver.findElement(By.xpath("//input[@id='Login1_Password']"));
		password.sendKeys("9007438097.kingshuk");
		
		WebElement button1=driver.findElement(By.xpath("//input[@id='Login1_LoginButton']"));
		button1.click();
		
		
		Thread.sleep(10000);
	
		WebElement button2=driver.findElement(By.xpath("//a[text()='Reports']"));
		button2.click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("ctl00_body_MyProjectsDropDown")).click();
		//Action 
		Actions action = new Actions(driver);
		
		WebElement drop= driver.findElement(By.id("ctl00_body_MyProjectsDropDown")).findElement(By.xpath("//option[2]"));
		action.doubleClick(drop).perform();
		
	
			WebElement button3=driver.findElement(By.linkText("Project Access Card Report"));
            button3.click();
            
            
         List <WebElement> Heading=driver.findElements(By.xpath("//tr//th"));
         int count=0;
         int loopno=0;
         for(WebElement hrefs:Heading){
        	 String currDate=hrefs.getText();
        	 int DateCurrent=Integer.parseInt(currDate);
        	 if(DateCurrent==st){
        		 loopno=count;
        	 }else{
        		 count++;
        	 }
         }
         System.out.println("LoopNo:"+loopno);
		
		
		
		
	}

}
