package com.Pages.AllBealls;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.GenericFunctions.WebDriver.GenericFunctionsExtra;
import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.constants.string.SDPExtendedConstants;
import com.constants.string.SearchBySpecificPropertyConstands;
import com.constants.string.StringConstants;
import com.constants.string.TopNavigationConstands;
import com.excellibrary.bealls.ExcelLibrary;
import com.reports.beallsCustom.CustomReporter;

public class TopNavigationChecker {

	

	public static WebElement submenu=null;
	public static WebElement subl3menu=null;
	public static WebDriverWait wait= null;
	
	@FindBy(className=StringConstants.POPUP)
	public static List<WebElement> popUplist;
	
	@FindBy(className=StringConstants.POPUP)
	public static WebElement popUp;
	
	@FindBy(xpath=TopNavigationConstands.TopNavigationLinks)
	public static List <WebElement> TopNavigationLinks;
	
	@FindBy(xpath=TopNavigationConstands.L2NavigationLinks)
	public static List <WebElement> L2NavigationLinks;
	
	@FindBy(xpath=TopNavigationConstands.Brand)
	public static List <WebElement> Brand;
	
	@FindBy(xpath=TopNavigationConstands.Categories)
	public static List <WebElement> Categories;

	@FindBy(xpath=TopNavigationConstands.Espots)
	public static List <WebElement> Espots;
	
	  @FindBy(className=TopNavigationConstands.ItemsBlock)
	  public static List <WebElement>  ItemsBlock;
	
	public TopNavigationChecker(){
		PageFactory.initElements(GenericWebDriverFunctions.driver,this);
	}
	
	public static void L1NavigationlinkValidation() throws InterruptedException{
		CustomReporter.startChild("Top Navigation Check", "");
        try {
        	StringBuffer Proper=new StringBuffer();
    		StringBuffer ImProper=new StringBuffer();

    		for (int counter = 1; counter <=TopNavigationLinks.size(); counter++) {
    			WebElement element=GenericWebDriverFunctions.findElementsBy("(//a[@class='main-nav-link'])["+counter+"]");
    			String str = element.getText();
    			String[] tokens = GenericFunctionsExtra.Split(str);
    			
    	    	GenericWebDriverFunctions.performAction(StringConstants.MOUSEOVER, element, "");
    	    	Thread.sleep(500);
    	    	GenericWebDriverFunctions.performAction(StringConstants.CLICK, element, "");
    	    	
    	    	if(GenericFunctionsExtra.ElementVisibility(popUplist)){
    	    		System.out.println("Popup is Present");
    	    		GenericWebDriverFunctions.performAction(StringConstants.CLICK, popUp, "");
    	    	}
    	    	
    	    	
    	    	/*if(GenericWebDriverFunctions.driver.findElements(By.className(StringConstants.POPUP)).size() != 0){
    	    		System.out.println("Popup is Present");
    	    		GenericWebDriverFunctions.driver.findElement(By.className(StringConstants.POPUP)).click();
    	    		}*/
    	    	
    	    	WebElement Expected = null;
    	    	boolean status=false;
    			for (int i = 0; i < tokens.length; i++) {
    				System.out.println("\\:" + tokens[i]);
    			    Expected=GenericWebDriverFunctions.findElementsBy("//h1[contains(text(),'" + tokens[i] + "')]");
    				
    				if (Expected.isDisplayed()) {
    					//status=true;
    					if(Expected.getText().equalsIgnoreCase("Markdowns")){
    						if(GenericFunctionsExtra.ElementVisibility(Espots)){
        						status=true;
        						GenericFunctionsExtra.Concatenation(Proper, str+",");
            				}else{
            					GenericFunctionsExtra.Concatenation(ImProper, str+",");
            				}
    					}else{
    						if(GenericFunctionsExtra.ElementVisibility(Categories) && GenericFunctionsExtra.ElementVisibility(Brand)  && GenericFunctionsExtra.ElementVisibility(Espots) ){
        						status=true;
        						GenericFunctionsExtra.Concatenation(Proper, str+",");
            				}else{
            					GenericFunctionsExtra.Concatenation(ImProper, str+",");
            				}
    					}
    					
    					//GenericFunctionsExtra.Concatenation(Proper, str+",");
    					break;
    				}else{
    					
    					GenericFunctionsExtra.Concatenation(ImProper, str+",");
    				}
    			}
    			
    			if(status){
    				System.out.println("It has landed to respective catagory");	
    				
    			}else{
    				System.out.println("It has not landed to respective catagory");
    			}
    		}
    		System.out.println("1:::"+Proper);
    		System.out.println("2:::"+ImProper);
    		CustomReporter.addChildInfo("The following Top Level Navigation has Landed to respective Landing Pages and displaying left navigation (category and brand) and landing page Espots::  "+Proper);
    		CustomReporter.addChildInfo("The following Top Level Navigation have not Landed to respective catagory::  "+ImProper);
    		CustomReporter.reportChild("pass", "Top-Level Navigation Has been verified");
		} catch (Exception e) {
			CustomReporter.reportChild("fail", "Error:Unable to verify Top-Level Navigation."+e);
		}
		
		CustomReporter.endChildTest();
	}
	@Parameters("L1CatagoryIndex")  
	@Test
	
	   public static void L2NavigationlinkValidation(int L1CatagoryIndex) throws InterruptedException{
		
		CustomReporter.startChild("L2 Navigation Check 'FOR HOME' Catagory", "");
		wait = new WebDriverWait(GenericWebDriverFunctions.driver, 15);
		try{

		StringBuffer ProperL2=new StringBuffer();
		StringBuffer ImProperL2=new StringBuffer();
		
		String actualMenu=null;
		
		//int L1CatagoryIndex=0;
		/*ExcelLibrary exe=new ExcelLibrary(TopNavigationConstands.filepath);
		String  L1catagoryName=(String) exe.getCellData(TopNavigationConstands.TestData, TopNavigationConstands.L1catagoryNameRow, TopNavigationConstands.cellno);
		switch (L1catagoryName.toLowerCase()) {
		case "for home" :L1CatagoryIndex=1;
						break;
		case "bed & bath " :L1CatagoryIndex=2;
				break;
		case "women" :L1CatagoryIndex=3;
				break;
		case "plus size" :L1CatagoryIndex=4;
		break;
		case "lingerie " :L1CatagoryIndex=5;
		break;
		case "men" :L1CatagoryIndex=6;
		break;
		case "juniors" :L1CatagoryIndex=7;
		break;
		case "kids" :L1CatagoryIndex=8;
		break;
		case "shoes & sandals " :L1CatagoryIndex=9;
		break;
		case "accessories" :L1CatagoryIndex=10;
		break;
		case "markdowns" :L1CatagoryIndex=11;
		break;

		default:
			break;
		}*/
    	
		WebElement element=GenericWebDriverFunctions.findElementsBy("(//a[@class='main-nav-link'])["+L1CatagoryIndex+"]");
    	GenericWebDriverFunctions.performAction(StringConstants.MOUSEOVER, element, "");
		Thread.sleep(3000);
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, element, "");
		
		List<WebElement> L2Navigator=GenericWebDriverFunctions.driver.findElements(By.xpath("//div[@class='left-nav']//a[@class='link-list-link']"));
		System.out.println("Counter Size::"+L2Navigator.size());
		int coutersize=L2Navigator.size()+1;
		
		for (int counter = 1; counter < coutersize; counter++) {
		   submenu=null;
		   submenu=GenericWebDriverFunctions.findElementsBy("(//div[@class='left-nav']//a[@class='link-list-link'])["+counter+"]");
		   
		   //Handling of viewMore
		   if(!submenu.isDisplayed()){
		    	List li=GenericWebDriverFunctions.driver.findElements(By.xpath("//a[contains(text(),'View More')]"));
		    	if(li.size()>0){
		    		for (int i = 1; i <=li.size(); i++) {
					WebElement ele=GenericWebDriverFunctions.findElementsBy("(//a[contains(text(),'View More')])["+i+"]");
					GenericWebDriverFunctions.performAction(StringConstants.CLICK, ele, "");
					}
		    	}
		    }
		   
		    GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, submenu, "");
			String str[]=GenericWebDriverFunctions.getText.split("\\(");
			actualMenu=str[0].trim();
		    System.out.println("///////::"+actualMenu);
		    
		    GenericWebDriverFunctions.performAction(StringConstants.CLICK, submenu, "");
		    GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, GenericWebDriverFunctions.findElementsBy("//h1"), "");
		    if(GenericWebDriverFunctions.getText.equalsIgnoreCase(actualMenu)){
		    	try {
		    		if(TopNavigationChecker.NoOfItemsDisplayed()>0){
		    			System.out.println("Landed Page::"+GenericWebDriverFunctions.getText);
				    	System.out.println("You have landed to respective catagory");
				    	GenericFunctionsExtra.Concatenation(ProperL2, GenericWebDriverFunctions.getText+",");
		    		}else if (L2NavigationLinks.size()>0) {
		    			System.out.println("Landed Page::"+GenericWebDriverFunctions.getText);
				    	System.out.println("You have landed to respective catagory");
				    	GenericFunctionsExtra.Concatenation(ProperL2, GenericWebDriverFunctions.getText+",");
					}/*else{
						
					}
			    	System.out.println("Landed Page::"+GenericWebDriverFunctions.getText);
			    	System.out.println("You have landed to respective catagory");
			    	GenericFunctionsExtra.Concatenation(ProperL2, GenericWebDriverFunctions.getText+",");*/
				} catch (Exception e) {
					// TODO: handle exception
				}
		    	

		    }else{
		    	    WebElement element11=GenericWebDriverFunctions.driver.findElement(By.xpath("//div[@class='dropdowns-additional']"));
		    	   	//GenericWebDriverFunctions.performAction(StringConstants.GETTITLE, GenericWebDriverFunctions.findElementsBy("//div[@class='dropdowns-additional']"), "");
		    	    element=wait.until(ExpectedConditions.visibilityOf(element));
		    	    String title=element.getAttribute("title");
		    	   	System.out.println("Landed Page::"+title);
		    	   	if(title.equalsIgnoreCase(actualMenu)){
		    	   		if(TopNavigationChecker.NoOfItemsDisplayed()>0){
		    	   			System.out.println("You have landed to respective catagory");
			    	   		GenericFunctionsExtra.Concatenation(ProperL2, title+",");
			    		}
		    	   		
		    	   	}else{
		    	   		//System.out.println("Landed Page::"+GenericWebDriverFunctions.getTitle);
		    	   		System.out.println("Error: You have landed to wrong catagory");
		    	   		GenericFunctionsExtra.Concatenation(ImProperL2, actualMenu+",");
		    	   	}
		    }
		    GenericWebDriverFunctions.driver.navigate().back();
		    //Thread.sleep(500);
	    	if(GenericWebDriverFunctions.driver.findElements(By.className(StringConstants.POPUP)).size() != 0){
	    		System.out.println("Popup is Present");
	    		GenericWebDriverFunctions.driver.findElement(By.className(StringConstants.POPUP)).click();
	    		}
		}
		
		System.out.println("1:::"+ProperL2);
		System.out.println("2:::"+ImProperL2);
		CustomReporter.addChildInfo("The following L2 Level Navigation Landed 'FOR HOME' has landed to respective pages::  "+ProperL2);
		CustomReporter.addChildInfo("The following L2 Level Navigation Landed 'FOR HOME' has not landed to respective pages:: "+ImProperL2);
		
		} catch (Exception e) {
			CustomReporter.reportChild("fail", "Error:Unable to verify L2-Level Navigation of "+"For Home"+"Catagory."+e);
		}
		
		CustomReporter.endChildTest();
		


	}
	
	
	   
		public static  int NoOfItemsDisplayed(){
			int size=ItemsBlock.size();
		    return size;
			
		}
}
