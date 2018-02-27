package com.spi.multipleDataLinksFetch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ClientCode {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 WebDriver driver=new FirefoxDriver();
			driver.get("https://en.wikipedia.org/wiki/List_of_NCAA_Division_I_FCS_football_programs");
			Thread.sleep(2000); 
			driver.manage().window().maximize() ;
			
			
			List<FootballTeamDetails> li=new ArrayList<FootballTeamDetails>();
	         
	         
	         try {
	        	List<WebElement> ClubNames = driver.findElements(By.xpath("(//table[@class='wikitable sortable jquery-tablesorter']//td)"));
	 			int i=1;
	 			Iterator ite1=ClubNames.iterator();
	 			
	 			while(ite1.hasNext()){
	 				//WebElement ClubName= (WebElement) ite1.next();
	 				WebElement club=driver.findElement(By.xpath("(//table[@class='wikitable sortable jquery-tablesorter']//td)["+i+"]//a"));
	 				//li.add(club.getAttribute("href"));
	 				int j=i+1;
	 				WebElement school=driver.findElement(By.xpath("(//table[@class='wikitable sortable jquery-tablesorter']//td)["+j+"]"));
	 				int k=j+1;
	 				WebElement city=driver.findElement(By.xpath("(//table[@class='wikitable sortable jquery-tablesorter']//td)["+k+"]"));
	 				int l=k+1;
	 				WebElement state=driver.findElement(By.xpath("(//table[@class='wikitable sortable jquery-tablesorter']//td)["+l+"]"));
	 				String link=club.getAttribute("href");
	 				FootballTeamDetails ft=new FootballTeamDetails();
	 				ft.setTeam(club.getText());
	 				ft.setSchool(school.getText());
	 				ft.setCity(city.getText());
	 				ft.setState(state.getText());
	 				ft.setHref(club.getAttribute("href"));
	 				li.add(ft);
	 				
	 				
	 				/*System.out.println("Names:::"+club.getText());
	 				System.out.println("Sch:::"+school.getText());
	 				System.out.println("links::=="+club.getAttribute("href"));*/
	 				i=i+5;
	 				
	 			}
			} catch (Exception e1) {
				System.out.println("Error Occured11::=="+ e1);
			}
			
	         String filepath="C:/WorkSpace/FootBallDetails.xls";
	         String Sheetname="CoachDetails";
	         
	         
	         int m=1;
	         try {System.out.println("-----------------");
	            // ExcellWriteOperation.write(filepath, Sheetname, rowRo, columnCo, value);
	        	 Iterator linkload=li.iterator();
		         while(linkload.hasNext()){
		        	 FootballTeamDetails detail=(FootballTeamDetails) linkload.next();
		        	 System.out.println("Club:::"+detail.getTeam());
		        	 ExcellWriteOperation.write(filepath, Sheetname, m, 0, detail.getTeam());
		        	 System.out.println("School:::"+detail.getSchool());
		        	 ExcellWriteOperation.write(filepath, Sheetname, m, 1, detail.getSchool());
		        	 System.out.println("City:::"+detail.getCity());
		        	 ExcellWriteOperation.write(filepath, Sheetname, m, 2, detail.getCity());
		        	 System.out.println("State:::"+detail.getState());
		        	 ExcellWriteOperation.write(filepath, Sheetname, m, 3, detail.getState());
		        	 driver.get(detail.getHref());
		        	 try {
		        		 System.out.println("First Season:::"+driver.findElement(By.xpath("//tr//th[contains(text(),'First season')]/following-sibling::td[1]")).getText());
		        		 String FS=driver.findElement(By.xpath("//tr//th[contains(text(),'First season')]/following-sibling::td[1]")).getText();
		        		 ExcellWriteOperation.write(filepath, Sheetname, m, 4, FS);
					} catch (Exception e) {
						System.out.println("First Season:::Data Not Found");
						 String FS="Data Not Found";
						 ExcellWriteOperation.write(filepath, Sheetname, m, 4, FS);
					}
		        	 
		        	 try {
		        		 System.out.println("Head Coach:::"+driver.findElement(By.xpath("//tr//th[contains(text(),'Head coach')]/following-sibling::td[1]//a")).getText());
			        	 String Co=driver.findElement(By.xpath("//tr//th[contains(text(),'Head coach')]/following-sibling::td[1]//a")).getText();
			        	 ExcellWriteOperation.write(filepath, Sheetname, m, 5, Co);
					} catch (Exception e) {
						 String Co="Data Not Found";
						 ExcellWriteOperation.write(filepath, Sheetname, m, 5, Co);
					}
		        	 
		        	 
                   Thread.sleep(2000);
				 System.out.println("///////////////////////");
				 m++;
		         }
		        
			} catch (Exception e2) {
				System.out.println("Error Occured22::=="+ e2);
			}

	}


}
