package TestScripts;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BeallsFlorida.Main;
import Libraries.Genericscripts;
import Libraries.Resultsummary;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.SeleniumException;

public class TC5_ShoppingItems {

	Resultsummary rs = new Resultsummary();
	public static Selenium sel;
	Genericscripts gs = new Genericscripts(getClass().getSimpleName());
//	public static Xpath xp;
	public static WebDriver driver;


	public TC5_ShoppingItems() throws Exception {
		sel = Main.sellaunch;
		driver = Main.driver;
	}

	public void TC5_ShoppingItems() throws Exception {
		try {
			System.out.println("*******----- TC5_ShoppingItems-----*******");
			Genericscripts gs = new Genericscripts(getClass().getSimpleName());
			sel.windowMaximize();
			
			/*Extract all links from the webpage using selenium webdriver*/
			List all_links_webpage = driver.findElements(By.tagName("a"));

			gs.writeResults("Total Number of Links on the Webpage - "+all_links_webpage.size());			
			
			/*Extract all links from Women Section*/
			gs.writePassLog("Items from WOMEN Sections Tab ");	
			List womenList = driver.findElement(By.xpath("//*[@id='cat-nav']/li[2]/ul/div")).findElements(By.tagName("a"));
			for(int i =0; i< womenList.size();i++){
			
			gs.writeResults(((WebElement) womenList.get(i)).getText());
			}
	         
			/*Extract all links from Plus Section*/
			gs.writePassLog("Items from PLUS SIZE Sections Tab ");	
			List plusList = driver.findElement(By.xpath("//*[@id='cat-nav']/li[3]/ul/div")).findElements(By.tagName("a"));
			for(int i =0; i< plusList.size();i++){
			
			gs.writeResults(((WebElement) plusList.get(i)).getText());
			}
			
			/*Extract all links from MEN Section*/
			gs.writePassLog("Items from MEN Sections Tab ");	
			List menList = driver.findElement(By.xpath("//*[@id='cat-nav']/li[4]/ul/div")).findElements(By.tagName("a"));
			for(int i =0; i< menList.size();i++){
			
			gs.writeResults(((WebElement) menList.get(i)).getText());
			}	
			
			/*Extract all links from Juniors Section*/
			gs.writePassLog("Items from Juniors Sections Tab ");	
			List JuniorsList = driver.findElement(By.xpath("//*[@id='cat-nav']/li[5]/ul/div")).findElements(By.tagName("a"));
			for(int i =0; i< JuniorsList.size();i++){
			
			gs.writeResults(((WebElement) JuniorsList.get(i)).getText());
			}
			
			/*Extract all links from Baby & Kids Section*/
			gs.writePassLog("Items from Baby & Kids Sections Tab ");	
			List bkList = driver.findElement(By.xpath("//*[@id='cat-nav']/li[6]/ul/div")).findElements(By.tagName("a"));
			for(int i =0; i< bkList.size();i++){
			
			gs.writeResults(((WebElement) bkList.get(i)).getText());
			}
			
			/*Extract all links from Swim Section*/
			gs.writePassLog("Items from Swim Sections Tab ");	
			List Swim = driver.findElement(By.xpath("//*[@id='cat-nav']/li[7]/ul/div")).findElements(By.tagName("a"));
			for(int i =0; i< Swim.size();i++){
			
			gs.writeResults(((WebElement) Swim.get(i)).getText());
			}
			
			/*Extract all links from Shoes & Sandals Section*/
			gs.writePassLog("Items from Shoes & Sandals Sections Tab ");	
			List SS = driver.findElement(By.xpath("//*[@id='cat-nav']/li[8]/ul/div")).findElements(By.tagName("a"));
			for(int i =0; i< SS.size();i++){
			
			gs.writeResults(((WebElement) SS.get(i)).getText());
			}
			
			/*Extract all links from Accessories & Jewelry Section*/
			gs.writePassLog("Items from Shoes & Sandals Sections Tab ");	
			List aj = driver.findElement(By.xpath("//*[@id='cat-nav']/li[9]/ul/div")).findElements(By.tagName("a"));
			for(int i =0; i< aj.size();i++){
			
			gs.writeResults(((WebElement) aj.get(i)).getText());
			}
			
			/*Extract all links from For Home Section*/
			gs.writePassLog("Items from For the Home Sections Tab ");	
			List HOME = driver.findElement(By.xpath("//*[@id='cat-nav']/li[10]/ul/div")).findElements(By.tagName("a"));
			for(int i =0; i< HOME.size();i++){
			
			gs.writeResults(((WebElement) HOME.get(i)).getText());
			}
			//Writing the test case results to Summary page 
			if (rs.failcounter > 0) {
				rs.writeFailSummary(getClass().getSimpleName(), "FAIL");
				 Main.fail++; 
		         Main.failTestScript.add(getClass().getSimpleName()); 
			} else {
				rs.writePassSummary(getClass().getSimpleName(), "PASS");
				 Main.pass++;
			}
		} catch (SeleniumException e) {
			System.out.println(e);
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String st = sw.toString();
			gs.writeFailLog(st);
			rs.writeFailSummary(getClass().getSimpleName(), "FAIL");
		}
	}
}