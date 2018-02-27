package com.bealls.assignedcases;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

//================================================================================================================
/*Test-20:Click on right (>) arrow.
*Expected Results:Site should navigate to next page.
* */
//================================================================================================================
public class Case20 {


	public static String url="http://www.beallsflorida.com/";
	public static String ExpectedResult="Site is navigating to next page";
	public static String ActualResult=null;
	public static String status=null;
	public static WebElement PageNodisplay=null;
	
	public static void main(String[] args) {

		
		WebDriver driver=null;
	    driver=new FirefoxDriver();
	    driver.get(url);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    Actions actions = new Actions(driver);
	    //Hover on Mens Catagory
	    WebElement mainMenu = driver.findElement(By.xpath("(//a[contains(text(),'Men')])[1]"));
	    actions.moveToElement(mainMenu).build().perform();
	    
	    //Click on T-Shirts
	    WebElement SubMenu=driver.findElement(By.xpath("//a[contains(text(),'T-Shirts')]"));
	    SubMenu.click();
	  
	   //Fetching the Current Page No
	   PageNodisplay=driver.findElement(By.xpath("(//span[@class='current-page'])[1]")) ;
	   String st1[]=PageNodisplay.getText().split(" ");
	   int PreviousPageNo=Integer.parseInt(st1[0]);
	   System.out.println("PreviousPageNo:"+PreviousPageNo);
	   
	   //Click on right (>) arrow
	   WebElement righttArrow=driver.findElement(By.xpath("(//span[@class='icon-page-next'])[1]"));
	   righttArrow.click();
	   
	   //Fetching the Next Page No
	   PageNodisplay=driver.findElement(By.xpath("(//span[@class='current-page'])[1]")) ;
	   String st2[]=PageNodisplay.getText().split(" ");
	   int NextPageNo=Integer.parseInt(st2[0]);
	   System.out.println("CurrentPageNo:"+NextPageNo);
	   
	   
	    if(NextPageNo==(PreviousPageNo+1)){
	    	ActualResult="Site is navigating to next page";
	    }else{
	    	ActualResult="Site is not navigating to next page";
	    }
	    
	    
	    if(ActualResult.equalsIgnoreCase(ExpectedResult)){
	    	status="Pass";
	    }else{
	    	status="Fail";
	    }
	    System.out.println("ActualResult:"+ActualResult);
	    System.out.println("Status:"+status);


	}

}
