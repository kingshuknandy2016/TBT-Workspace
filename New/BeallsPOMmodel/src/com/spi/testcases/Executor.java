package com.spi.testcases;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.spi.data.ExcelLibrary;
import com.spi.pages.ProductDisplayPage;


public class Executor {
	   static WebDriver driver=null;
	   static String status=null;
	   static String description=null;
	   static String sheetName="ScenarioList";
	   

    
    
   
    public void run() throws InterruptedException{
        this.driver=Driver.driver;
        Executor exe=new Executor();
        ExcelLibrary el = new ExcelLibrary(Driver.filePath);
		int rowCount = el.getRowCount(sheetName);
		for(int i = 1;i<=rowCount;i++){
			String ScanarioName= (String) el.getCellData(sheetName, i, 0);
			String ExeStatus= (String) el.getCellData(sheetName, i, 1);
			if(ExeStatus.equalsIgnoreCase("yes")){
			switch (ScanarioName.toLowerCase()) {
			case "itemsper30pagevalidation":exe.itemsPer30PageValidation();
										break;
			case "itemsper60pagevalidation":exe.itemsPer60PageValidation();
			break;
			case "itemsper90pagevalidation":exe.itemsPer90PageValidation();
			break;

			default:
				break;
			}
			    el.writeToCell(sheetName, i, 2, status);
			    el.writeToCell(sheetName, i, 3, description);
			}else{
				el.writeToCell(sheetName, i, 2, "Skipped");
			}
			
		}
    	
    	
    	System.out.println("itemsPer30PageValidation():"+status+"\t"+description);
    }
    
	public  void itemsPer30PageValidation() throws InterruptedException{
		try {
			ProductDisplayPage Pdp=new ProductDisplayPage(driver);
			Pdp=PageFactory.initElements(driver, ProductDisplayPage.class);
			Pdp.ClickOnItemsPerPage(30);
			Thread.sleep(3000);
			int size;
			size=Pdp.NoOfItemsDisplayed();
			if(size==30){
				System.out.println("Pass"+"\t"+"Items Per Page is:"+"\t"+ size);
				status="Pass";
				description="Items Per Page is:"+"\t"+ size;
				
			}else{
				status="Fail";
				description="Items Per Page is:"+"\t"+ size;
				System.out.println("Fail"+"\t"+"Items Per Page is:"+"\t"+ size);
			}
		} catch (Exception e12) {
			    status="Fail";
			    description="ErrorOccured"+e12;
		}
		
		
		
		
	}
	
	public  void itemsPer60PageValidation() throws InterruptedException{
		try {
			ProductDisplayPage Pdp=new ProductDisplayPage(driver);
			Pdp=PageFactory.initElements(driver, ProductDisplayPage.class);
			Pdp.ClickOnItemsPerPage(60);
			Thread.sleep(3000);
			int size;
			size=Pdp.NoOfItemsDisplayed();
			if(size==60){
				System.out.println("Pass"+"\t"+"Items Per Page is:"+"\t"+ size);
				status="Pass";
				description="Items Per Page is:"+"\t"+ size;
				
			}else{
				status="Fail";
				description="Items Per Page is:"+"\t"+ size;
				System.out.println("Fail"+"\t"+"Items Per Page is:"+"\t"+ size);
			}
		} catch (Exception e12) {
			    status="Fail";
			    description="ErrorOccured"+e12;
		}
	}
	
	public  void itemsPer90PageValidation() throws InterruptedException{
		try {
			ProductDisplayPage Pdp=new ProductDisplayPage(driver);
			Pdp=PageFactory.initElements(driver, ProductDisplayPage.class);
			Pdp.ClickOnItemsPerPage(90);
			Thread.sleep(3000);
			int size;
			size=Pdp.NoOfItemsDisplayed();
			if(size==90){
				System.out.println("Pass"+"\t"+"Items Per Page is:"+"\t"+ size);
				status="Pass";
				description="Items Per Page is:"+"\t"+ size;
				
			}else{
				status="Fail";
				description="Items Per Page is:"+"\t"+ size;
				System.out.println("Fail"+"\t"+"Items Per Page is:"+"\t"+ size);
			}
		} catch (Exception e12) {
			    status="Fail";
			    description="ErrorOccured"+e12;
		}
	}
	
	

}
