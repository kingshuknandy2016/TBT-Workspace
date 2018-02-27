package com.spi.basics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FootBallTeamInformationFetch {


	public static void main(String[] args) throws InterruptedException {
		     WebDriver driver=new FirefoxDriver();
			driver.get("https://en.wikipedia.org/wiki/List_of_NCAA_Division_I_FCS_football_programs");
			Thread.sleep(2000); 
			driver.manage().window().maximize() ;
			
			
			List<String> li=new ArrayList<String>();
	         
	         
	         try {
	        	 List<WebElement> ClubNames = driver.findElements(By.xpath("(//table[@class='wikitable sortable jquery-tablesorter']//td)"));
	 			int i=1;
	 			Iterator ite1=ClubNames.iterator();
	 			
	 			while(ite1.hasNext()){
	 				//WebElement ClubName= (WebElement) ite1.next();
	 				WebElement club=driver.findElement(By.xpath("(//table[@class='wikitable sortable jquery-tablesorter']//td)["+i+"]//a"));
	 				li.add(club.getAttribute("href"));
	 				int j=i+1;
	 				WebElement school=driver.findElement(By.xpath("(//table[@class='wikitable sortable jquery-tablesorter']//td)["+j+"]"));
	 				System.out.println("Names:::"+club.getText());
	 				System.out.println("Sch:::"+school.getText());
	 				System.out.println("links::=="+club.getAttribute("href"));
	 				i=i+5;
	 			}
			} catch (Exception e1) {
				System.out.println("Error Occured11::=="+ e1);
			}
			
	         
	         try {System.out.println("-----------------");
	        	 Iterator linkload=li.iterator();
		         while(linkload.hasNext()){
		        	 driver.get((String) linkload.next());
		        	
		        	 
		        	 try {
		        		 WebElement coachname=driver.findElement(By.xpath("//tr//th[contains(text(),'Head coach')]/following-sibling::td[1]//a"));
			        	 String caoch=coachname.getText();
			        	 System.out.println("Coach:::"+ caoch);
						
					} catch (Exception e3) {
						System.out.println("Error:::Coach name not found::"+e3);
					}
		        	// Thread.sleep(5000);
				 
		         }
			} catch (Exception e2) {
				System.out.println("Error Occured22::=="+ e2);
			}

	}

}
