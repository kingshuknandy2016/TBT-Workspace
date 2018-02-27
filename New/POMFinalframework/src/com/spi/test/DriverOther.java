package com.spi.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.spi.SearchDisplay.SearchDisplayPage;
import com.spi.data.ExcelLibrary;
import com.spi.extendedReport.BaseExample;

import com.spi.pages.ProductDisplayBealls;
import com.spi.practicepakage.PageHome;
import com.spi.practicepakage.SearchPage;
import com.spi.screenRecorder.VideoRecord;


public class DriverOther extends BaseExample {
	public static WebDriver driver; 
	//static ExtentTest Child1;
	//protected ExtentTest child1;
	
	
	// public static int rowIndex;
		public static String filePath= System.getProperty("user.dir")+"\\Lib\\KSRTC TestCase.xls";
		public static String recording="Yes";
		VideoRecord vr = new VideoRecord();
		@BeforeClass
		public void openApplication() throws Exception{
			//---Give the excel path--------------
			System.out.println(System.getProperty("user.dir"));
			System.out.println("-------------system started---------------");
		if(filePath != null){
				ExcelLibrary el = new ExcelLibrary(filePath);
				String browserType = (String) el.getCellData("Driver Details", 0, 1);
				if(browserType.equalsIgnoreCase("firefox"))
					driver = new FirefoxDriver();
				else if(browserType.equalsIgnoreCase("chrome")){
					String serverFilePath = (String) el.getCellData("Driver Details", 1, 1);
					System.setProperty("webdriver.chrome.driver", serverFilePath);
					driver = new ChromeDriver();
				}else if(browserType.equalsIgnoreCase("ie")){
					String serverFilePath = (String) el.getCellData("Driver Details", 1, 1);
					System.setProperty("webdriver.ie.driver", serverFilePath);
					driver = new InternetExplorerDriver();
				}
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				String url = (String) el.getCellData("Driver Details", 2, 1);
				driver.get(url);
				//Start Video Recording
				if(recording.equalsIgnoreCase("Yes"))
				{
				        vr.startRecording();
				}
			}
			}
			
		
//		public static String filePath = "C:\\MAHESH\\KSRTC TestCase.xlsx";
		
		@DataProvider
		public Object[][] getScenarioName(){
			
			//List<String> ScenarioNameList = new ArrayList<String>();
			List ProductPaginationPageList = new ArrayList();
			ProductPaginationPageList.add("ProductPaginationPage");
			List SearchDisplayPageList = new ArrayList();
			SearchDisplayPageList.add("SearchDisplayPage");
			
			
			
			ExcelLibrary el = new ExcelLibrary(filePath);
			int rowCount = el.getRowCount("ScenarioList");
			Object[][] data = new Object[2][1];
			for(int i = 1;i<=rowCount;i++){
				String	dataProviderObject=null;
				String PageName = (String) el.getCellData("ScenarioList", i, 0);
				String ScenarioName = (String) el.getCellData("ScenarioList", i, 1);
				String exeStatus = (String) el.getCellData("ScenarioList", i, 2);
				/*if(exeStatus.equalsIgnoreCase("yes")){
					dataProviderObject=ScenarioName+"_yes";
					}else{
					dataProviderObject=ScenarioName+"_no";	
					
					}*/
				if(exeStatus.equalsIgnoreCase("yes")){
					dataProviderObject=ScenarioName;
					el.writeToCell("ScenarioList", i, 3, "passing");
					switch (PageName) {
					case "ProductPaginationPage":ProductPaginationPageList.add(dataProviderObject);
						                         
						            
						break;
	                case "SearchDisplayPage":SearchDisplayPageList.add(dataProviderObject);
						
						break;

					default:
						break;
					}
				}else{
					dataProviderObject=null;
					el.writeToCell("ScenarioList", i, 3, "Skipped");
				}
				
				
				
			}
			data[0][0] = SearchDisplayPageList;
			data[1][0] = ProductPaginationPageList;
			

			return data;
		}
		
		
		@Test(dataProvider="getScenarioName")
		public void testMethod(List PageName) {
			 String Classname=(String) PageName.get(0);
			 int size=PageName.size();
			 System.out.println("Classname:"+Classname+"\t"+size);
			 test = extent.startTest(Classname);
			 if(size==1){
				 test.log(LogStatus.SKIP, "None of The cases are executed");
			 }else{
			
			
			 
			 
			
			 switch (Classname.toLowerCase()) {
			 
			 case "searchdisplaypage":SearchDisplayPage sp=new SearchDisplayPage(driver);
             //----------------Start---------------
             for (int i = 1; i < size; i++) {
           	  String st=(String) PageName.get(i);
           	  System.out.println("Testcasename::"+st);
           	  //String[] stArr=st.split("_");
           	  //System.out.println("/////---"+stArr[0]);
           	 // System.out.println("/////--"+stArr[1]);
           	 // if(st.equalsIgnoreCase("yes")){
           		  ExtentTest child2 = extent.startTest(st);
           		 // System.out.println("////--"+stArr[0].toLowerCase());
           		  		switch (st.toLowerCase()) {
           		  			case "hightolow":
           		  				try {
           		  					int lat=2/0;
           		  					sp.selectOrderBy("Price: High to Low");
           		  					sp.getTotalItemsPerPage();
           		  					sp.validateHighToLow_LowToHigh();
           		  					sp.clickNextPage();
           		  					sp.validateHighToLow_LowToHigh();
           		  				if (SearchDisplayPage.status.equalsIgnoreCase("pass"))
           		  				{
           		  					child2.log(LogStatus.PASS,
									"Items are in reverse scaling order according to price");
               
           		  				} else if (SearchDisplayPage.status
           		  						.equalsIgnoreCase("fail")) {
           		  					child2.log(LogStatus.FAIL,
           		  							"Items are not in reverse scaling order according to price");
               
           		  				} 
           		  				} catch (Exception e) {
								child2.log(LogStatus.FAIL,e);
           		  				}

							 
           		  			
							break;
           		  			case "lowtohigh":
           		  					try {int lat=2/0;
           		  						sp.selectOrderBy("Price: Low to High");
           		  						sp.getTotalItemsPerPage();
           		  						sp.validateHighToLow_LowToHigh();
           		  						sp.clickNextPage();
           		  						sp.validateHighToLow_LowToHigh();
           		  					if (SearchDisplayPage.status.equalsIgnoreCase("pass"))
       		  						{
       		  							child2.log(LogStatus.PASS,
       		  									"Items are in   scaling order according to price");
           
       		  						} else if (SearchDisplayPage.status
       		  								.equalsIgnoreCase("fail")) {
       		  							child2.log(LogStatus.FAIL,
       		  									"Items are not in  scaling order according to price");
           
       		  						} 
									} catch (Exception e) {
										child2.log(LogStatus.FAIL,
       		  									e);
									}
							
           		  						
							break;
							
           		  			case "highestratings":sp.selectOrderBy("Highest Ratings");
           		  						try {
           		  						int lat=2/0;
                   		  					sp.getTotalItemsPerPage();
                   		  					sp.validateHighestRatings();
                   		  					sp.clickNextPage();
                   		  					sp.validateHighestRatings();
                   		  				if (SearchDisplayPage.status.equalsIgnoreCase("pass"))
                						{
                							child2.log(LogStatus.PASS,
                									"Items are in reverse scaling order according to ratings");
                               
                						} else if (SearchDisplayPage.status
                								.equalsIgnoreCase("fail")) {
                							child2.log(LogStatus.FAIL,
                                       "Items are not in reverse scaling order according to ratings");
                               
                						} 
										} catch (Exception e) {
											child2.log(LogStatus.FAIL,
								                      e);
										}

						
						default: System.out.println("Test name doesn't exists");
							break;
						}
           		  // child1.log(LogStatus.PASS, "the following test has been Passed");
           		  test.appendChild(child2);
           	  
             }   
             //----------------end---------------
break;
			 //------------------------------------
			 case "productpaginationpage":ProductDisplayBealls Ph=new ProductDisplayBealls(driver);
			 					//----------------Start---------------
			 					for (int i = 1; i < size; i++) {
			 						String TestCaseName=(String) PageName.get(i);
			 						//String[] stArr=st.split("_");
			 						//if(stArr[1].equalsIgnoreCase("yes")){
			 							ExtentTest child1 = extent.startTest(TestCaseName,"Sample description");
			 							System.out.println("////"+TestCaseName.toLowerCase());
			 							switch (TestCaseName.toLowerCase()) {
										
			 					case "itemsperpage30validation":try {
			 									Ph.itemsPer30PageValidation();
			 									if (ProductDisplayBealls.status.equalsIgnoreCase("pass"))
			 									{
			 										child1.log(LogStatus.PASS,
			 												"Items per page is 30");
			                            
			 									} else if (ProductDisplayBealls.status
			 											.equalsIgnoreCase("fail")) {
			 										child1.log(LogStatus.FAIL,
			                                    "Items per page is not 30");
			                            
			 									} 
												} catch (InterruptedException e) {
											// TODO Auto-generated catch block
													e.printStackTrace();
													child1.log(LogStatus.FAIL,
						                                    e);
												}
									
			 									
										
			 									break;
			 					case "itemsperpage60validation":try {
	 									Ph.itemsPer60PageValidation();
	 									if (ProductDisplayBealls.status.equalsIgnoreCase("pass"))
	 									{
	 										child1.log(LogStatus.PASS,
	 												"Items per page is 60");
	                            
	 									} else if (ProductDisplayBealls.status
	 											.equalsIgnoreCase("fail")) {
	 										child1.log(LogStatus.FAIL,
	                                    "Items per page is not 60");
	                            
	 									}
										} catch (InterruptedException e) {
									// TODO Auto-generated catch block
											e.printStackTrace();
											child1.log(LogStatus.FAIL,
				                                    e);
										}
							
	 									 
								
	 									break;
			 					case "itemsperpage90validation":try {
	 									Ph.itemsPer90PageValidation();
	 									if (ProductDisplayBealls.status.equalsIgnoreCase("pass"))
	 									{
	 										child1.log(LogStatus.PASS,
	 												"Items per page is 90");
	                            
	 									} else if (ProductDisplayBealls.status
	 											.equalsIgnoreCase("fail")) {
	 										child1.log(LogStatus.FAIL,
	                                    "Items per page is not 90");
	                            
	 									} 
										} catch (InterruptedException e) {
									// TODO Auto-generated catch block
											e.printStackTrace();
											child1.log(LogStatus.FAIL,
				                                   e);
										}
							
	 									
								
	 									break;
									
											
											

										default:System.out.println("option not Found");
											break;
										}
			 							// child1.log(LogStatus.PASS, "the following test has been Passed");
			 							test.appendChild(child1);
			 						
			 					}   
			 					//----------------end---------------
				break;
           

			default:
				break;
			}
			 }	 
			 
		
		}

		@AfterClass
		public void closeBrowser() throws Exception{
			//Stop Video Recording
			System.out.println("driver is closing");
			/*if(recording.equalsIgnoreCase("Yes"))
			{
			        vr.stopRecording();        
			}*/
			
				driver.close();
				driver.quit();
			
			
			
		System.out.println("Browzer closed");
		}
}
