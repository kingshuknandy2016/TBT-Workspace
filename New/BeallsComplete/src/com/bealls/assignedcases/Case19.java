package com.bealls.assignedcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


//================================================================================================================
/*Test-23:Click on Category or sub category in the top navigation menu or left navigation .
*Expected Results:Pagination link will appear on top and bottom of the page with left(<),  
*                 right(>) and last page (>>)pagination arrow. 
*                 If we go to last page, there should be option to come back first page (<<).
* */
//================================================================================================================
public class Case19 {

	public static String url="http://www.beallsflorida.com/";
	public static String ExpectedResult="Site is navigating to first page";
	public static String ActualResult=null;
	public static String status=null;
	public static WebElement PageNodisplay=null;
	
	public static void main(String[] args) throws InterruptedException {
		
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
	    
	    
	    //Click on right (>) arrow
		 WebElement righttArrow=driver.findElement(By.xpath("(//span[@class='icon-page-next'])[1]"));
		 righttArrow.click();
		 Thread.sleep(1000);
		
		 int validtop1=1;
		 int validtop2=1;
		 int validtop3=1;
		 int validtop4=1;
		 
		 int validbottom1=1;
		 int validbottom2=1;
		 int validbottom3=1;
		 int validbottom4=1;
		//Page initiation link at the top
		//Click on next page (>) arrow.
		 if(driver.findElement(By.xpath("(//span[@class='icon-page-next'])[1]")).isDisplayed()){
			 System.out.println("The next page (>) arrow is displayed at the top ");
		 }else{
			 validtop1=0;
			 System.out.println("The next page (>) arrow is not displayed at the top ");
		 }
		//Click on last page (>>) arrow.
		 if(driver.findElement(By.xpath("(//span[@class='icon-page-last'])[1]")).isDisplayed()){
			 System.out.println("The last page (>>) arrow is displayed at the top ");
		 }
		 else{
			 validtop2=0;
			 System.out.println("The last page (>>) arrow is not displayed at the top ");
		 }
		 //Click on left  page (<) arrow.
		 if( driver.findElement(By.xpath("(//span[@class='icon-page-back'])[1]")).isDisplayed()){
			 System.out.println("The left  page (<) arrow is displayed at the top ");
		 }
		 else{
			 validtop3=0;
			 System.out.println("The left  page (<) arrow is not displayed at the top ");
		 }
		//Click on first  page (<<) arrow.
		 if( driver.findElement(By.xpath("(//span[@class='icon-page-first'])[1]")).isDisplayed()){
			 System.out.println("The first  page (<<) arrow is displayed at the top ");
		 }
		 else{
			 validtop4=0;
			 System.out.println("The first  page (<<) arrow is not displayed at the top ");
		 }
		
	
		 //Page initiation link at the bottom 
		 if(driver.findElement(By.xpath("(//span[@class='icon-page-next'])[2]")).isDisplayed()){
			 System.out.println("The next page (>) arrow is displayed at the bottom ");
		 }else{
			 validbottom1=0;
			 System.out.println("The next page (>) arrow is not displayed at the bottom ");
		 }
		//Click on last page (>>) arrow.
		 if(driver.findElement(By.xpath("(//span[@class='icon-page-last'])[2]")).isDisplayed()){
			 System.out.println("The last page (>>) arrow is displayed at the bottom ");
		 }
		 else{
			 validbottom2=0;
			 System.out.println("The last page (>>) arrow is not displayed at the bottom ");
		 }
		 //Click on left  page (<) arrow.
		 if( driver.findElement(By.xpath("(//span[@class='icon-page-back'])[2]")).isDisplayed()){
			 System.out.println("The left  page (<) arrow is displayed at the bottom ");
		 }
		 else{
			 validbottom3=0;
			 System.out.println("The left  page (<) arrow is not displayed at the bottom ");
		 }
		//Click on first  page (<<) arrow.
		 if( driver.findElement(By.xpath("(//span[@class='icon-page-first'])[2]")).isDisplayed()){
			 System.out.println("The first  page (<<) arrow is displayed at the bottom ");
		 }
		 else{
			 validbottom4=0;
			 System.out.println("The first  page (<<) arrow is not displayed at the bottom ");
		 }
		 
		 
		 if(validtop1==0 || validtop2==0 || validtop3==0 || validtop4==0|| validbottom1==0 ||validbottom2==0 ||validbottom3==0 ||validbottom4==0 ){
			 status="Fail";
		 }else{
			 status="Pass";
		 }
		 
		  System.out.println("Status:"+status);
	}

}
