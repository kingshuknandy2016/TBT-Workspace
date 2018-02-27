package com.bealls.assignedcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

//================================================================================================================
  /*Test-16:Select the "30" option in the Item per Page
   *Expected Results:System displays only 30 items per page when user selects "30" option.
   * */
//================================================================================================================

public class Case16 {
	public static String url="http://a3.beallsflorida.com/";
	public static String ExpectedResult="Items Per Page is 30";
	public static String ActualResult=null;
	public static String status=null;

	
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
	    
	    //select-Items Per Page:30
	    WebElement NoofPage=null;
	    try{
	    NoofPage=driver.findElement(By.xpath("//span[contains(text(),'30')]"));
	    
	    }catch(Exception e1){
	    NoofPage=driver.findElement(By.xpath("//a[contains(text(),'30')]"));
	    NoofPage.click();
	    
	    }
	    
	    //Checking the no of items
	    List <WebElement> Items=driver.findElements(By.className("item-info-block"));
	    int size=Items.size();
	    ActualResult="Items Per Page is " + size;
	    if(ActualResult.equalsIgnoreCase(ExpectedResult)){
	    	status="Pass";
	    }else{
	    	status="Fail";
	    }
	    System.out.println("ActualResult:"+ActualResult);
	    System.out.println("Status:"+status);
	    
	    
	}

}
