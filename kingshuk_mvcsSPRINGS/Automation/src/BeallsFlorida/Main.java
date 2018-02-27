package BeallsFlorida;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import Libraries.HtmlEmailSender;
import Libraries.Resultsummary;
import Libraries.Zipresults;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
//import TestScripts.Xpath;

public class Main {
	public static Selenium sellaunch;
	public static String Url;
	public static String Browser;
	public static String Port;
	public static String Host;
	public static String Env;
	public static String Tname;
	//public static Xpath xpath;
	public static String SubUrl;
	public static String CaseId;
	public static String SubUrlCaseId;
	public static WebDriver driver;
	public static int pass=0;
	public static int fail=0;
	public static String testSuite;
	public static String email;	
	public static String subject;
	public static List failTestScript = new ArrayList(); 
	
	public static void main(String[] args) {
		try {
			Resultsummary rsum = new Resultsummary();
			rsum.createSummaryFile();
			Workbook w = Workbook.getWorkbook(new File("C:/WorkSpace/Automation/Utility/Utility.xls"));
			Sheet s = w.getSheet("Setup");
			Host = s.getCell(1, 2).getContents();
			Port = s.getCell(1, 3).getContents();
			Browser = s.getCell(1, 4).getContents();
			Url = s.getCell(1, 5).getContents();
			Env = s.getCell(1, 8).getContents();
			email=s.getCell(1,11).getContents();
			subject = s.getCell(1, 12).getContents();
			testSuite=s.getCell(1,13).getContents();
			
			w.close();
			

			//Test Scripts Execution
			SubDriver obj_SD = new SubDriver();
			obj_SD.GetTestScriptName();

			//Zip Results
			Zipresults z = new Zipresults();
			z.zipRes();
			
			HtmlEmailSender email = new HtmlEmailSender();
		//	email.mail();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void StartSelenium() throws Exception {
		
		//Calling the AutoIT script for IE browser
		if(Browser.equals("iexplore") || Browser.equals("iehta"))
		{ 
		try{
			
			
           }
            catch (Exception e){
            e.printStackTrace();
            }
		}
		
		int intPort = Integer.parseInt(Port);
		if (Env.equals("Local")) {
			
			sellaunch = new DefaultSelenium(Host, intPort, "*" + Browser, Url);
		}
		
		sellaunch.start();
		
		sellaunch.setTimeout("1000000");
		sellaunch.open(Url);
		
		sellaunch.windowMaximize();		
	}

	public static void StopSelenium() throws Exception {
		sellaunch.stop();
	}
	
	public static void StartSeleniumWD() throws Exception {
		int intPort = Integer.parseInt(Port);

				
		if (Browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			//sellaunch = new WebDriverBackedSelenium(driver, Url);

		} else if(Browser.equalsIgnoreCase("googlechrome")) {
			driver = new ChromeDriver();
			//sellaunch = new WebDriverBackedSelenium(driver, Url);
			
		} else if (Browser.equalsIgnoreCase("iexplore")) {
			driver = new InternetExplorerDriver ();
			
		} else {
			Browser.equalsIgnoreCase("safari");
			driver = new SafariDriver ();
			//sellaunch = new WebDriverBackedSelenium(driver, Url);
		}

		driver.get(Url);
		driver.manage().window().maximize();
	}
}