package com.spi.criticalPathApproach;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.spi.data.ExcelLibrary;

public class Path1 {

	static WebDriver driver=new FirefoxDriver();
	static String filePath="C:\\Users\\kingshuk.nandy\\Desktop\\BeallsPOMModel.xls";
	static String InputSheet="TestData";
	
	public static 	ExtentReports report = new ExtentReports("FinalReport.html");
	public static 	 ExtentTest orderAsGuest = report.startTest("Place order as guest", "Select item, add to cart and check out");
public static 	ExtentTest selectCat=null;
public static	ExtentTest addToCart= null;
public static	ExtentTest checkOut  = null;
	public static void LandingPage(String url){
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void selectProduct(int cellNo) throws InterruptedException{
		   
		selectCat = report.startTest("Selection of product", "Select a product from a category");
		    //inputs
		try
		{
			ExcelLibrary exe=new ExcelLibrary(filePath);
		    String mainCatagory=(String) exe.getCellData(InputSheet, 1, cellNo);
		    String subCatagory=(String) exe.getCellData(InputSheet, 2, cellNo);
		    //Hover on Mens Catagory
			Actions actions = new Actions(driver);
		    WebElement mainMenu = driver.findElement(By.xpath("(//a[contains(text(),'"+mainCatagory+"')])[1]"));
		    actions.moveToElement(mainMenu).build().perform();
		    
		    //Click on T-Shirts
		    WebElement SubMenu=driver.findElement(By.xpath("//a[contains(text(),'"+subCatagory+"')]"));
		    SubMenu.click();
		    
		    //Click on a Product
		 
		    driver.findElement(By.xpath(Path1Constands.TShirtProduct)).click();
		   Thread.sleep(1000);
		   selectCat.log(LogStatus.PASS, "Product added successfully");
		   
		}
		catch(Exception e)
		{
			selectCat.log(LogStatus.FAIL, e.getLocalizedMessage());
		}
		report.endTest(selectCat);

	orderAsGuest.appendChild(selectCat);
	}
	
public static void AddToCart(int cellNo) throws InterruptedException{
	
	addToCart = report.startTest("Add to cart", "Add the selected product to cart");
	try
	{
	  ExcelLibrary exe=new ExcelLibrary(filePath);
      String mainCatagory=(String) exe.getCellData(InputSheet, 4, cellNo);
	   Path1.unwantedpopup();
       Thread.sleep(1000);
    	driver.findElement( By.linkText("Medium")).click();
    	Path1.unwantedpopup();
    	Thread.sleep(1000);
         driver.findElement(By.xpath(Path1Constands.AddtoCartBtnPDP)).click();
         Path1.unwantedpopup();
         Thread.sleep(1000);
         driver.findElement(By.xpath(Path1Constands.CheckOutPopup)).click();
         Path1.unwantedpopup();
         Thread.sleep(1000);
         addToCart.log(LogStatus.PASS, "Product added to cart successfully");
	}
	catch(Exception e)
	{
		addToCart.log(LogStatus.ERROR,e.getLocalizedMessage());
	}
	report.endTest(addToCart);
	orderAsGuest.appendChild(addToCart);
}


public static void checkOut(int cellNo) throws InterruptedException
{	 
	
	checkOut= report.startTest("Check out", "Check out and finish shopping");
	try
	{
		Thread.sleep(1000);
		
		//Clicking on secure Checkout Button on AddToCartPage
		WebElement secureCheckout = driver.findElement(By.xpath("//div[@id='checkout-button']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(secureCheckout);
		actions.perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", secureCheckout);
		secureCheckout.click();
		Thread.sleep(2000);
		
		
		
		//CheckOutProgressbar_Step:Sign in_Click on  Continue as guest
		WebElement guest = driver.findElement(By.xpath("//a[contains(text(),'Continue')]"));
		guest.click();
		Thread.sleep(2000);
		
		Path1.BillingAddress(cellNo);

		WebElement useEntry = driver.findElement(By.xpath("//b[contains(text(),'Use')]"));
		useEntry.click();
		Thread.sleep(1000);
  
		Path1.CardDetails(cellNo);
		Path1.validateOrderPlacement();
		checkOut.log(LogStatus.PASS, "Checked out and shopped a product successfully");
	}
	catch(Exception e)
	{
		checkOut.log(LogStatus.FAIL,e.getLocalizedMessage());
	}
	report.endTest(checkOut);
	orderAsGuest.appendChild(checkOut);
}

public static void BillingAddress(int cellNo) throws InterruptedException{
	
	ExcelLibrary exe=new ExcelLibrary(filePath);
    String FirstName=(String) exe.getCellData(InputSheet, 5, cellNo);
    String LastName=(String) exe.getCellData(InputSheet, 6, cellNo);
    String StreetAddress=(String) exe.getCellData(InputSheet, 7, cellNo);
    String City=(String) exe.getCellData(InputSheet, 8, cellNo);
    String State=(String) exe.getCellData(InputSheet, 9, cellNo);
   
    Double Zip=(Double) exe.getCellData(InputSheet, 10, cellNo);
	String v = Zip.toString().trim();
	String ZipCode=v.substring(0, v.indexOf("."));
    
	Long Phone=Double.valueOf( exe.getCellData(InputSheet, 11, 1).toString()).longValue();
	String PhoneNo=Phone.toString();
	
	String Email=(String) exe.getCellData(InputSheet, 12, cellNo);
   
    
	WebElement fname = driver.findElement(By.xpath("(//input[@name='firstName'])[2]"));
	fname.sendKeys(FirstName);

	WebElement lname = driver.findElement(By.xpath("(//input[@name='lastName'])[2]"));
    lname.sendKeys(LastName);

	WebElement add1 = driver.findElement(By.xpath("(//input[@name='address1'])[2]"));
	add1.sendKeys(StreetAddress);

	WebElement city = driver.findElement(By.xpath("html/body/div[5]/div/div[1]/div/div[2]/form/dl/div[2]/div[1]/input"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", city);
	city.sendKeys(City);

	Select state = new Select(driver.findElement(By.name("state")));
	state.selectByVisibleText(State);

	WebElement zip = driver.findElement(By.xpath("html/body/div[5]/div/div[1]/div/div[2]/form/dl/div[2]/div[3]/input"));
	zip.sendKeys(ZipCode);

	WebElement phone = driver.findElement(By.xpath("html/body/div[5]/div/div[1]/div/div[2]/form/dl/div[3]/div/div/input[2]"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", phone);
	phone.sendKeys(PhoneNo);

	WebElement email = driver.findElement(By.xpath("html/body/div[5]/div/div[1]/div/div[2]/form/dl/div[4]/div/input"));
	email.sendKeys(Email);

	WebElement checkOut = driver.findElement(By.xpath("html/body/div[5]/div/div[1]/div/div[4]/div/a"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", checkOut);
	checkOut.click();
	Thread.sleep(3000);
}

public static void CardDetails(int cellNo){
	
	ExcelLibrary exe=new ExcelLibrary(filePath);
    String CardType=(String) exe.getCellData(InputSheet, 13, cellNo);
   // String CardNo=(String) exe.getCellData(InputSheet, 14, cellNo);
    Long CardNumber=Double.valueOf( exe.getCellData(InputSheet, 14, cellNo).toString()).longValue();
	String CardNo=CardNumber.toString();
    
    //String Security=(String) exe.getCellData(InputSheet, 15, cellNo);
	Double Security11=(Double) exe.getCellData(InputSheet, 15, 1);
	String sec = Security11.toString().trim();
	//System.out.println("////:"+sec.substring(0, sec.indexOf(".")));
	String Security=sec.substring(0, sec.indexOf("."));
	
    String ExpiresOn=(String) exe.getCellData(InputSheet, 16, cellNo);
   // String Year=(String) exe.getCellData(InputSheet, 17, cellNo);
    
    Double Year11=(Double) exe.getCellData(InputSheet, 17, 1);
    String ye = Year11.toString().trim();
	//System.out.println("////:"+ye.substring(0, ye.indexOf(".")));
    String Year=ye.substring(0, ye.indexOf("."));
	
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	jse.executeScript("window.scrollBy(0,350)", "");

	Select cardType = new Select(
			driver.findElement(By
					.xpath("html/body/div[4]/div[2]/div[2]/div/div[3]/div/div/div[2]/form[1]/select")));
	// ((JavascriptExecutor)
	// driver).executeScript("arguments[0].scrollIntoView();", cardType);
	cardType.selectByVisibleText(CardType);

	WebElement cardNo = driver.findElement(By.xpath("html/body/div[4]/div[2]/div[2]/div/div[3]/div/div/div[2]/form[1]/div[1]/div[1]/input"));
	cardNo.sendKeys(CardNo);

	WebElement security = driver
			.findElement(By
					.xpath("html/body/div[4]/div[2]/div[2]/div/div[3]/div/div/div[2]/form[1]/div[1]/div[2]/input"));
	security.sendKeys(Security);

	Select expiresOn = new Select(
			driver.findElement(By
					.xpath("html/body/div[4]/div[2]/div[2]/div/div[3]/div/div/div[2]/form[1]/div[2]/div/div[1]/select")));

	expiresOn.selectByVisibleText(ExpiresOn);

	Select year = new Select(
			driver.findElement(By
					.xpath("html/body/div[4]/div[2]/div[2]/div/div[3]/div/div/div[2]/form[1]/div[2]/div/div[2]/select")));

	year.selectByVisibleText(Year);

	WebElement completeOrder = driver
			.findElement(By
					.xpath("html/body/div[4]/div[2]/div[2]/div/div[3]/div/div/div[2]/div[2]/a"));
	completeOrder.click();
}



public static void main(String[] args) throws InterruptedException {
	Path1.LandingPage("https://a3.beallsflorida.com");
	Path1.selectProduct(1);
	Path1.AddToCart(1);
	Path1.checkOut(1);
	report.endTest(orderAsGuest);
	report.flush();
}

public static void unwantedpopup(){
	try {
		driver.findElement(By.className("fsrCloseBtn")).click();
	} catch (Exception e) {
		// TODO: handle exception
	}
}

public static void validateOrderPlacement()
{
	
	if(driver.findElement(By.xpath("//h1[contains(text(),'Thank you')]")).getText().contains("Thank you"))
		orderAsGuest.log(LogStatus.PASS, "Placed order successfully as guest");
	else
		orderAsGuest.log(LogStatus.ERROR, "Some technical glitch");
	
}
    
    
}
