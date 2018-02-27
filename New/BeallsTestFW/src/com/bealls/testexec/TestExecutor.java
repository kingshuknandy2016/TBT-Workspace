package com.bealls.testexec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.bealls.data.ExcelLibrary;
import com.bealls.testdriver.Driver;
import com.google.common.collect.Ordering;

public class TestExecutor {

	 

	 String scenarioStatus = "PASS";
	 WebElement divPopup ;
	public static List<Double> prices,ratings;
	public static String sheetName = "High2Low",Order;
	public static final String PASS = "Pass", FAIL = "Fail";
	public static int itemsperpage;


	
	public   void run(String sheetName)    {

		
		

		ExcelLibrary el = new ExcelLibrary(Driver.filePath);
		int rowCount = el.getRowCount(sheetName);

		System.out.println(rowCount);
		for (int i = 1; i <= rowCount; i++) {
			String action = (String) el.getCellData(sheetName, i, 0);
			String idMethod = null, locator = null, data = null, status = null;
			if (!action.equalsIgnoreCase("verifytitle")) {
				// read IDMethod and locator from excel only if action is not a
				// verifyTitle
				idMethod = (String) el.getCellData(sheetName, i, 1);
				try {
					locator = (String) el.getCellData(sheetName, i, 2);
				} catch (ClassCastException exp) {
					int number = new Double(el.getCellData(sheetName, i, 2)
							.toString()).intValue();
					locator = String.valueOf(number);
				}

			}

			if (!action.equalsIgnoreCase("click")) {
				data = (String) el.getCellData(sheetName, i, 3);
			}

			if (action.toLowerCase().equalsIgnoreCase("verifytitle"))
				status = verifyTitle(data);
			else if (action.toLowerCase().equalsIgnoreCase("type"))
				status = type(idMethod, locator, data);
			else if (action.toLowerCase().equalsIgnoreCase("click"))
				status = click(idMethod, locator);
			else if (action.toLowerCase().equalsIgnoreCase("verifytext"))
				status = verifyText(idMethod, locator, data);
			else if (action.toLowerCase().equalsIgnoreCase("mouseover"))
				status = mouseOver(idMethod, locator);
			else if (action.toLowerCase().equalsIgnoreCase("select"))
				status = select(idMethod, locator, data);
			else if (action.toLowerCase().equalsIgnoreCase("getitemsperpage"))
				status = getitemsPerpage(idMethod, locator);
			else if (action.toLowerCase().equalsIgnoreCase("scroll"))
			{
				try {
					status = scroll(idMethod,locator);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
				if(action.toLowerCase().equalsIgnoreCase("highestRatings"))
				{
					try {
						status = highestRatings(idMethod, locator);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(action.toLowerCase().equalsIgnoreCase("noofitemsperpage")){
					status=noofitemsperpage(idMethod, locator, data);
					}
				else if(action.toLowerCase().equalsIgnoreCase("rightNavigation")){
					status=rightNavigation(idMethod, locator);
				}
				else if(action.toLowerCase().equalsIgnoreCase("lastNavigation")){
					status=lastNavigation(idMethod, locator);
				}
				else if(action.toLowerCase().equalsIgnoreCase("leftNavigation")){
					status=leftNavigation(idMethod, locator);
				}
				else if(action.toLowerCase().equalsIgnoreCase("firstNavigation")){
					status=firstNavigation(idMethod, locator);
				}
				else if(action.toLowerCase().equalsIgnoreCase("pageNavigation")){
					status=pageNavigation(idMethod, locator);
				}

			el.writeToCell(sheetName, i, 4, status);
			
			try {
				sleep();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		rowCount = el.getRowCount("Scenarios");
		for(int i = 1;i<=rowCount;i++){
			String scenarioName = (String) el.getCellData("Scenarios", i, 0);
			if(scenarioName.equalsIgnoreCase(sheetName)){
				el.writeToCell("Scenarios", i, 2, scenarioStatus);
				break;
			}
		}
	}

	private   String verifyText(String idMethod, String locator,
			String data) {
		String status = null;
		try {
			WebElement element = getElement(idMethod, locator);
			String actualText = element.getText();
			if (actualText.contains(data))
				status = PASS;
			else {
				status = FAIL;
				scenarioStatus = "FAIL";
			}

		} catch (Exception e) {
			status = FAIL + ": " + e.getMessage();
			scenarioStatus = "FAIL";
		}
		return status;
	}

	private   String click(String idMethod, String locator) {
		String status = PASS;
		WebElement element = null;
		try {
			element = getElement(idMethod, locator);

			element.click();
			sleep();

		}
		catch(WebDriverException wde )
		{ 
			divPopup = Driver.driver.findElement(By.className("fsrFloatingMid"));
          
				 divPopup = Driver.driver.findElement(By.className("fsrCloseBtn"));
				 System.out.println("Element found");
				 divPopup.click();
				  
		element.click();
		 
		}
		catch (Exception e) {
			status = FAIL + ": " + e.getMessage();
			scenarioStatus = "FAIL";
		}
		return status;
	}

	private   String type(String idMethod, String locator, String data) {
		String status = PASS;
		try {

			WebElement element = getElement(idMethod, locator);
			element.sendKeys(data);

		} catch (Exception e) {
			status = FAIL + ":" + e.getMessage();
			scenarioStatus = "FAIL";
		}
		return status;
	}

	private   String verifyTitle(String expectedTitle) {
		String status = null;
		try {
			String actualTitle = Driver.driver.getTitle();
			if (actualTitle.contains(expectedTitle)) {
				status = PASS;
			} else {
				status = FAIL;
				scenarioStatus = "FAIL";
			}

		} catch (Exception e) {
			status = FAIL + ": " + e.getMessage();
			scenarioStatus = "FAIL";
		}
		return status;
	}

	private   String mouseOver(String idmethod, String locator) {
		String status = null;
		WebElement element = null;
		Actions builder = new Actions(Driver.driver);
		Action mouseOver=null;
		try {
			element = getElement(idmethod, locator);
			mouseOver = builder.moveToElement(element).build();
			mouseOver.perform();
			sleep();
			status = PASS;
		}
		catch(WebDriverException wde)
		{
			divPopup = Driver.driver.findElement(By.className("fsrFloatingMid"));
	          
			 divPopup = Driver.driver.findElement(By.className("fsrCloseBtn"));
			 System.out.println("Element found");
			 divPopup.click();
			 
			 
			mouseOver = builder.moveToElement(element).build();
			mouseOver.perform();
			status = PASS;	
		}
		catch (Exception e) {
			status = FAIL + ":" + e.getMessage();
			scenarioStatus = "FAIL";
		}
		return status;
	}

	private   String select(String idmethod, String locator, String data) {
		String status = null;
		WebElement element = null;
		try {
			 element= getElement(idmethod, locator);

			Select sortyBy = new Select(element);
			sortyBy.selectByVisibleText(data);
			Order = data;
			status = PASS;
		} 
		catch(WebDriverException ex)
		{
			divPopup = Driver.driver.findElement(By.className("fsrFloatingMid"));
	          
			 divPopup = Driver.driver.findElement(By.className("fsrCloseBtn"));
			 System.out.println("Element found");
			 divPopup.click();
			 
			Select sortyBy = new Select(element);
			sortyBy.selectByVisibleText(data);
			Order = data;
			status = PASS;
		}
		catch (Exception e) {
			status = FAIL + ":" + e.getMessage();
			scenarioStatus = "FAIL";
		}

		return status;
	}

	/**
	 * @param idMethod
	 * @param locator
	 * @return
	 * @throws Exception
	 */
	public   String scroll(String idMethod, String locator) throws Exception     {
		String status = null;
		String[] price;
		 	prices = new ArrayList<Double>();
			String tempLocator = locator;
			WebElement element;
		 
//			try
//			{
			 
			for (int counter = 1; counter <= itemsperpage; counter++) {
				
				
				 StringBuilder actualPrice = new StringBuilder();
				locator =locator.replace("*", String.valueOf(counter));
				
				element =  getElement(idMethod, locator);
				
				 
				if(element.getText().contains("-"))
				{
				 price= element.getText().split("-");
				 actualPrice  = actualPrice.append(price[0]).deleteCharAt(0);
				}
				else
				{
					if(!element.getText().isEmpty())
					{
				    actualPrice.append(element.getText()).deleteCharAt(0);
					}
					else
					{
						pageReload();
						scroll(idMethod, tempLocator);	
						System.out.println("String empty case");
						break;
					}
					
				}
					 
				Double data = Double.parseDouble(actualPrice.toString());
//			   System.out.println("<-- "+data+" -->");
				prices.add(data);

				locator = tempLocator;
				 
			}
			
			if(Order.contains("High to Low"))
			{
			Collections.reverse(prices);
			}
			
			if (!Ordering.natural().isOrdered(prices))
				status = "Unsorted";
			else
				status ="Sorted";
		

//			}
//			catch(Exception e)
//			{
//			status=FAIL+":"+e.getMessage();
//			scenarioStatus = "FAIL";
//			}
			Thread.sleep(700);

		return status;
	}

	
	
	private   String highestRatings(String idMethod,String locator) throws InterruptedException
	{
		String status=null;
		String[] rate;
        ratings  = new ArrayList<Double>();
        
        
        String tempLocator = locator;
		WebElement element;
		try
		{
		for (int counter = 1; counter <= itemsperpage; counter++) {
			locator =locator.replace("*", String.valueOf(counter));
			
			element =  getElement(idMethod, locator);
			 rate= element.getAttribute("src").split("/");
			 
			ratings.add(Double.parseDouble(rate[5].trim()));

			locator = tempLocator;
		}
		Collections.reverse(ratings);
	 
		if (!Ordering.natural().isOrdered(ratings))
			status = "Unsorted";
		else
			status ="Sorted" ;
		}
		catch(Exception e)
		{
		status=FAIL+":"+e.getMessage();
		scenarioStatus = "FAIL";
		}
		Thread.sleep(700);
        
        
		
		
		return status;
	}
	private static String getitemsPerpage(String idMethod, String locator) {
		String status = null;

		try {
			String num[] = getElement(idMethod, locator).getText().split(" ");
			itemsperpage = (Integer.parseInt(num[4]) - Integer.parseInt(num[2])) + 1;
			status = PASS;
		} catch (Exception e) {
			status = FAIL + ":" + e.getMessage();
		}
		return status;

	}

	public static WebElement getElement(String idMethod, String locator)
			throws Exception {
		WebElement element = null;
		if (idMethod.equalsIgnoreCase("id"))
			element = Driver.driver.findElement(By.id(locator));
		else if (idMethod.equalsIgnoreCase("name"))
			element = Driver.driver.findElement(By.name(locator));
		else if (idMethod.equalsIgnoreCase("classname"))
			element = Driver.driver.findElement(By.className(locator));
		else if (idMethod.equalsIgnoreCase("xpath"))
			element = Driver.driver.findElement(By.xpath(locator));
		else if (idMethod.equalsIgnoreCase("linktext"))
			element = Driver.driver.findElement(By.linkText(locator));
		else if (idMethod.equalsIgnoreCase("partiallinktext"))
			element = Driver.driver.findElement(By.partialLinkText(locator));
		else if (idMethod.equalsIgnoreCase("cssselector"))
			element = Driver.driver.findElement(By.cssSelector(locator));
		else if (idMethod.equalsIgnoreCase("tagname"))
			element = Driver.driver.findElement(By.tagName(locator));
		else
			throw new Exception("Invalid ID Method");
		return element;
	}

	public static void sleep() throws InterruptedException {
		Thread.sleep(3000);
	}
	
	public static void pageReload()
	{
		Driver.driver.navigate().refresh();
		try {
			sleep();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String noofitemsperpage(String idMethod, String locator,String data)      {
		     List <WebElement> Items=Driver.driver.findElements(By.className("item-info-block"));
		    int size=Items.size();
		    String status=null;
		    //ActualResult="Items Per Page is " + size;
		    if(size==Integer.parseInt(data)){
		    	status="Items Per page"+size;
		    }else{
		    	status="Fail";
		    }
		   // System.out.println("ActualResult:"+ActualResult);
		   // System.out.println("Status:"+status);
		   return status;
	}
	
	public static String rightNavigation(String idMethod, String locator)     {
	       WebElement PageNodisplay=null;
	       String status=null;
		 //Fetching the Current Page No
		   PageNodisplay=Driver.driver.findElement(By.xpath("(//span[@class='current-page'])[1]")) ;
		   String st1[]=PageNodisplay.getText().split(" ");
		   int PreviousPageNo=Integer.parseInt(st1[0]);
		   System.out.println("PreviousPageNo:"+PreviousPageNo);
		   
		   //Click on right (>) arrow
		   WebElement righttArrow=Driver.driver.findElement(By.xpath("(//span[@class='icon-page-next'])[1]"));
		   righttArrow.click();
		   
		   //Fetching the Next Page No
		   PageNodisplay=Driver.driver.findElement(By.xpath("(//span[@class='current-page'])[1]")) ;
		   String st2[]=PageNodisplay.getText().split(" ");
		   int NextPageNo=Integer.parseInt(st2[0]);
		   System.out.println("CurrentPageNo:"+NextPageNo);
		   
		   
		    if(NextPageNo==(PreviousPageNo+1)){
		    	status="Site is navigating to next page";
		    }else{
		    	status="Site is not navigating to next page";
		    }
		    
		    return status;
	}
	
	public static String lastNavigation(String idMethod, String locator)       {
	       WebElement PageNodisplay=null;
	       String status=null;
		//Fetching the Last Page No
		 PageNodisplay=Driver.driver.findElement(By.xpath("(//span[@class='current-page'])[1]")) ;
		   String st1[]=PageNodisplay.getText().split(" ");
		   int CurrentPageNo=Integer.parseInt(st1[0]);
		   int LastPageNo=Integer.parseInt(st1[2]);
		   System.out.println("CurrentPageNo:"+CurrentPageNo);
		   
		   //Click on last page (>>) arrow.
		   WebElement LastPageArrow=Driver.driver.findElement(By.xpath("(//span[@class='icon-page-last'])[1]"));
		   LastPageArrow.click();
		   System.out.println("After Clicking on last page (>>) arrow");
		   
		   //Fetching the Current Page No
		   PageNodisplay=Driver.driver.findElement(By.xpath("(//span[@class='current-page'])[1]")) ;
		   String st2[]=PageNodisplay.getText().split(" ");
		   int CurrentPageNoLast=Integer.parseInt(st2[0]);
		   System.out.println("CurrentPageNo:"+CurrentPageNoLast);
		   
		   
		    if(CurrentPageNoLast==LastPageNo){
		    	status="Site is navigating to last page";
		    }else{
		    	status="Site is not-navigating to last page";
		    }
			return status;
		    
		    


		}
	
	public static String leftNavigation(String idMethod, String locator)     {
	       WebElement PageNodisplay=null;
	       String status=null;
	
	       
	       //Fetching the Current Page No
		   PageNodisplay=Driver.driver.findElement(By.xpath("(//span[@class='current-page'])[1]")) ;
		   String st2[]=PageNodisplay.getText().split(" ");
		   int CurrentPageNoLast=Integer.parseInt(st2[0]);
		   System.out.println("CurrentPageNo:"+CurrentPageNoLast);
		   
		   
		   //Click on left  page (<) arrow.
		   WebElement PreviousPageArrow=Driver.driver.findElement(By.xpath("(//span[@class='icon-page-back'])[1]"));
		   PreviousPageArrow.click();
		   
		   //Fetching previous page no
		   PageNodisplay=Driver.driver.findElement(By.xpath("(//span[@class='current-page'])[1]")) ;
		   String st1[]=PageNodisplay.getText().split(" ");
		   int PreviousPageNo=Integer.parseInt(st1[0]);
		   System.out.println("PreviousPageNo:"+PreviousPageNo);
		   
		   
		    if(PreviousPageNo==(CurrentPageNoLast-1)){
		    	status="Site is navigating to previous page";
		    }else{
		    	status="Site is not navigating to previous page";
		    }
			return status;
		  
	}
	
	public static String firstNavigation(String idMethod, String locator)      {
	       WebElement PageNodisplay=null;
	       String status=null;
           
	       
	       //Click on first  page (<<) arrow.
		   
		   WebElement FirstPageArrow=Driver.driver.findElement(By.xpath("(//span[@class='icon-page-first'])[1]"));
		   FirstPageArrow.click();
		   System.out.println("After Clicking on first page (<<) arrow");
	
	   
	   
	   //Fetching the Current Page No
	   PageNodisplay=Driver.driver.findElement(By.xpath("(//span[@class='current-page'])[1]")) ;
	   String st1[]=PageNodisplay.getText().split(" ");
	   int CurrentPageNo=Integer.parseInt(st1[0]);
	   
	   System.out.println("CurrentPageNo:"+CurrentPageNo);

	   
	    if(CurrentPageNo==1){
	    	status="Site is navigating to first page";
	    }else{
	    	status="Site is not navigating to first page";
	    }
		return status;


	}
	
	public static String pageNavigation(String idMethod, String locator)      {
		 String status=null; 
		//Click on right (>) arrow
		 WebElement righttArrow=Driver.driver.findElement(By.xpath("(//span[@class='icon-page-next'])[1]"));
		 righttArrow.click();
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		 if(Driver.driver.findElement(By.xpath("(//span[@class='icon-page-next'])[1]")).isDisplayed()){
			 System.out.println("The next page (>) arrow is displayed at the top ");
		 }else{
			 validtop1=0;
			 System.out.println("The next page (>) arrow is not displayed at the top ");
		 }
		//Click on last page (>>) arrow.
		 if(Driver.driver.findElement(By.xpath("(//span[@class='icon-page-last'])[1]")).isDisplayed()){
			 System.out.println("The last page (>>) arrow is displayed at the top ");
		 }
		 else{
			 validtop2=0;
			 System.out.println("The last page (>>) arrow is not displayed at the top ");
		 }
		 //Click on left  page (<) arrow.
		 if( Driver.driver.findElement(By.xpath("(//span[@class='icon-page-back'])[1]")).isDisplayed()){
			 System.out.println("The left  page (<) arrow is displayed at the top ");
		 }
		 else{
			 validtop3=0;
			 System.out.println("The left  page (<) arrow is not displayed at the top ");
		 }
		//Click on first  page (<<) arrow.
		 if( Driver.driver.findElement(By.xpath("(//span[@class='icon-page-first'])[1]")).isDisplayed()){
			 System.out.println("The first  page (<<) arrow is displayed at the top ");
		 }
		 else{
			 validtop4=0;
			 System.out.println("The first  page (<<) arrow is not displayed at the top ");
		 }
		
	
		 //Page initiation link at the bottom 
		 if(Driver.driver.findElement(By.xpath("(//span[@class='icon-page-next'])[2]")).isDisplayed()){
			 System.out.println("The next page (>) arrow is displayed at the bottom ");
		 }else{
			 validbottom1=0;
			 System.out.println("The next page (>) arrow is not displayed at the bottom ");
		 }
		//Click on last page (>>) arrow.
		 if(Driver.driver.findElement(By.xpath("(//span[@class='icon-page-last'])[1]")).isDisplayed()){
			 System.out.println("The last page (>>) arrow is displayed at the bottom ");
		 }
		 else{
			 validbottom2=0;
			 System.out.println("The last page (>>) arrow is not displayed at the bottom ");
		 }
		 //Click on left  page (<) arrow.
		 if( Driver.driver.findElement(By.xpath("(//span[@class='icon-page-back'])[1]")).isDisplayed()){
			 System.out.println("The left  page (<) arrow is displayed at the bottom ");
		 }
		 else{
			 validbottom3=0;
			 System.out.println("The left  page (<) arrow is not displayed at the bottom ");
		 }
		//Click on first  page (<<) arrow.
		 if( Driver.driver.findElement(By.xpath("(//span[@class='icon-page-first'])[1]")).isDisplayed()){
			 System.out.println("The first  page (<<) arrow is displayed at the bottom ");
		 }
		 else{
			 validbottom4=0;
			 System.out.println("The first  page (<<) arrow is not displayed at the bottom ");
		 }
		 
		 
		 if(validtop1==0 || validtop2==0 || validtop3==0 || validtop4==0|| validbottom1==0 ||validbottom2==0 ||validbottom3==0 ||validbottom4==0 ){
			 status="All navigators not present";
		 }else{
			 status="All navigators are present";
		 }
		 
		  //System.out.println("Status:"+status);
          return status;
	
	}
	
	
}
