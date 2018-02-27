package com.spi.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.spi.data.ExcelLibrary;
import com.spi.testcases.Driver;
import com.spi.testcases.Executor;

public class ProductDisplayBealls {

	   WebDriver driver;	
	  // static WebDriver driver=null;
	   static String status=null;
	   static String description=null;
	   static String sheetName="ScenarioList";
	  
	  @FindBy(xpath=PDPConstants.NoofItemsPage30)
	  WebElement NoofItemsPage30;
	  
	  @FindBy(xpath=PDPConstants.NoofItemsPage60)
	  WebElement NoofItemsPage60;
	  
	  @FindBy(xpath=PDPConstants.NoofItemsPage90)
	  WebElement NoofItemsPage90;
	  
	  @FindBy(className=PDPConstants.ItemsBlock)
	  List <WebElement>  ItemsBlock;
	  
	  
	//---------------Page Navigators--------------------
	  
	  @FindBy(xpath=PDPConstants.TopRightArrow)
	  WebElement TopRightArrow;
	 
	  @FindBy(xpath=PDPConstants.BottomRightArrow)
	  WebElement BottomRightArrow;
	  
	  @FindBy(xpath=PDPConstants.TopLeftArrow)
	  WebElement TopLeftArrow;
	  
	  @FindBy(xpath=PDPConstants.BottomLeftArrow)
	  WebElement BottomLeftArrow;
	  
	  @FindBy(xpath=PDPConstants.TopLastPageArrow)
	  WebElement TopLastPageArrow;
	  
	  @FindBy(xpath=PDPConstants.BottomLastPageArrow)
	  WebElement BottomLastPageArrow;
	  
	  @FindBy(xpath=PDPConstants.TopLastPageArrow)
	  WebElement TopFirstPageArrow;
	  
	  @FindBy(xpath=PDPConstants.BottomFirstPageArrow)
	  WebElement BottomFirstPageArrow;
	  
	//--------------------------------------------------
	  
	  public ProductDisplayBealls(WebDriver driver2) {
		 this.driver=driver2;
	}


	public void ClickOnItemsPerPage(int NoOfItems){
		  if(NoOfItems==30){
			  try{
				  NoofItemsPage30.click();
				    
				    }catch(Exception e1){
				    System.out.println("Already NoofItems/Page is 30");	
				    }
		  }else if(NoOfItems==60){
			  try{
				  NoofItemsPage60.click();
				    
				    }catch(Exception e1){
				    System.out.println("Already NoofItems/Page is 60");	
				    }
		  }
	      else {
			  try{
				  NoofItemsPage90.click();
				    
				    }catch(Exception e1){
				    System.out.println("Already NoofItems/Page is 90");	
				    }
	    	 
	    	 
		  }
	  }

	public int NoOfItemsDisplayed(){
		int size=ItemsBlock.size();
	    return size;
		
	}
	
	
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
				ProductDisplayBealls Pdp=new ProductDisplayBealls(driver);
				Pdp=PageFactory.initElements(driver, ProductDisplayBealls.class);
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
				ProductDisplayBealls Pdp=new ProductDisplayBealls(driver);
				Pdp=PageFactory.initElements(driver, ProductDisplayBealls.class);
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
				ProductDisplayBealls Pdp=new ProductDisplayBealls(driver);
				Pdp=PageFactory.initElements(driver, ProductDisplayBealls.class);
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
