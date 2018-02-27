package com.bealls.assignedcases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

//================================================================================================================
/*Test-16:Click on Category or sub category in the top navigation menu or left navigation .
 *Expected Results:Click on Category or sub category in the top navigation menu or left navigation.
 * */
//================================================================================================================
public class Case15 {
	public static String url="http://beallsflorida.com/";
	public static String ExpectedResult="Items Per Page is 30";
	public static String ActualResult=null;
	public static String status=null;

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=null;
	    driver=new FirefoxDriver();
	    driver.get(url);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    Case15 c=new Case15();
	    c.Validation(driver);
   //c.writeOnExcel(driver);
	}
	
	public static void Validation(WebDriver driver) throws InterruptedException{
		List <WebElement> MainCatogory=driver.findElements(By.xpath("//a[@class='main-nav-link']"));
		   List <String> hrefs=new ArrayList<String>();
		   for(WebElement  catagory:MainCatogory){
			   hrefs.add(catagory.getAttribute("data-href"));
			   System.out.println("Links:"+ catagory.getAttribute("data-href"));
		   }
		   
		   for (int i = 0; i <10; i++) {
			  driver.get(hrefs.get(i));
			  Thread.sleep(4000);
			  ExcelLibrary lib=new ExcelLibrary("C:\\WorkSpace\\BeallsProject.xls");
			  List <WebElement> subCategory=driver.findElements(By.xpath("//div[@class='link-list-group']//a"));
			  int rowCount=lib.getRowCount("SubCategory");
			  int size=subCategory.size();
			  for (int j = 0; j <10; j++) {
				  if(subCategory.get(j).getText().equalsIgnoreCase("View More")){
					  subCategory.get(j).click(); 
					  
				  }else{
					  String st=subCategory.get(j).getText();
					  String st1[]=st.split("\\(");
				//  System.out.println("SubCategory:"+ st1[0]);
				 Object name=lib.getCellData("SubCategory", j+1, i);
                 String SubCategoryName=(String) name;
                 if(st1[0].endsWith(SubCategoryName)){
                	
                	 System.out.println("Expected:"+SubCategoryName);
                	 System.out.println("Actual:"+st1[0]);
                	 //System.out.println("CatagoryName Does Not Match");
                	 status="Pass";
                 }else{
                	 System.out.println("Expected:"+SubCategoryName);
                	 System.out.println("Actual:"+st1[0]);
                	 System.out.println("CatagoryName Does Not Match");
                	 status="Fail";
                	 break;
                 }
				  
				  }
				
			}
			  
			 
		    }	
		   System.out.println("Status"+status);
	}
	
  public void	writeOnExcel(WebDriver driver) throws InterruptedException{
	   // Actions actions = new Actions(driver);
	   List <WebElement> MainCatogory=driver.findElements(By.xpath("//a[@class='main-nav-link']"));
	   List <String> hrefs=new ArrayList<String>();
	   for(WebElement  catagory:MainCatogory){
		   hrefs.add(catagory.getAttribute("data-href"));
		   System.out.println("Links:"+ catagory.getAttribute("data-href"));
	   }
	   
	   for (int i = 0; i <11; i++) {
		  driver.get(hrefs.get(i));
		  Thread.sleep(1000);
		  ExcelLibrary lib=new ExcelLibrary("C:\\WorkSpace\\BeallsProject.xls");
		  List <WebElement> subCategory=driver.findElements(By.xpath("//div[@class='link-list-group']//a"));
		  int size=subCategory.size();
		  for (int j = 0; j <10; j++) {
			  if(subCategory.get(j).getText().equalsIgnoreCase("View More")){
				  subCategory.get(j).click(); 
				  
			  }else{
				  String st=subCategory.get(j).getText();
				  String st1[]=st.split("\\(");
			  System.out.println("SubCategory:"+ st1[0]);
			  int k=j+1;

			  lib.writeToCellCreatingRow("SubCategory", k, i,st1[0]);
			  }
			
		}
		 
	    }
  }

}
