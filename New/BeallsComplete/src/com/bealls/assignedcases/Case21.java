package com.bealls.assignedcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


//================================================================================================================
/*Test-21:Click on last page (>>) arrow.
*Expected Results:Site should navigate to last page.
* */
//================================================================================================================
public class Case21 {

	public static String url="http://www.beallsflorida.com/";
	public static String ExpectedResult="Site is navigating to last page";
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
	  
	   //Fetching the Last Page No
	   PageNodisplay=driver.findElement(By.xpath("(//span[@class='current-page'])[1]")) ;
	   String st1[]=PageNodisplay.getText().split(" ");
	   int CurrentPageNo=Integer.parseInt(st1[0]);
	   int LastPageNo=Integer.parseInt(st1[2]);
	   System.out.println("CurrentPageNo:"+CurrentPageNo);
	   
	   //Click on last page (>>) arrow.
	   WebElement LastPageArrow=driver.findElement(By.xpath("(//span[@class='icon-page-last'])[1]"));
	   LastPageArrow.click();
	   System.out.println("After Clicking on last page (>>) arrow");
	   
	   //Fetching the Current Page No
	   PageNodisplay=driver.findElement(By.xpath("(//span[@class='current-page'])[1]")) ;
	   String st2[]=PageNodisplay.getText().split(" ");
	   int CurrentPageNoLast=Integer.parseInt(st2[0]);
	   System.out.println("CurrentPageNo:"+CurrentPageNoLast);
	   
	   
	    if(CurrentPageNoLast==LastPageNo){
	    	ActualResult="Site is navigating to last page";
	    }else{
	    	ActualResult="Site is not-navigating to last page";
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