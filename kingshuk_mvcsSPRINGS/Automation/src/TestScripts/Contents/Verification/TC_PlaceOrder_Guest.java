package TestScripts.Contents.Verification;

	import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BeallsFlorida.Main;
import Libraries.Genericscripts;
import Libraries.ProjectSpecific;
import Libraries.Resultsummary;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.SeleniumException;

	public class TC_PlaceOrder_Guest {
		
		ProjectSpecific ps = new ProjectSpecific();
		Resultsummary rs = new Resultsummary();
		public static Selenium sel;
		Genericscripts gs = new Genericscripts(getClass().getSimpleName());
		//public static Xpath xp;
		public static WebDriver driver;
		
		public TC_PlaceOrder_Guest ()throws Exception{
			sel=Main.sellaunch;
//			xp = Main.xpath;
			driver = Main.driver;
		}
	     
	     public void TC_PlaceOrder_Guest()throws Exception{
	    	 try
	 		{	
	    	 System.out.println("*******----- TC_PlaceOrder_Guest -----*******");	
	    	 Genericscripts gs = new Genericscripts(getClass().getSimpleName());
	    	 //Mouse over on the tab & Click on item
	    	 gs.mouseOver("//*[@id='cat-nav']/li[4]");
	    	 gs.clickLinkWD("//*[@id='cat-nav']/li[4]/ul/div/span[1]/li[1]/a");   
	    	 String shoppingItem = gs.gText("//*[@id='WC_CatalogSearchResultDisplay_div_6_1']/div/div[2]/div[2]");
	    	 System.out.println(shoppingItem);
	    	 gs.writePassLog("Selected Item for shopping - "+shoppingItem);
	    	 String displayPrice = gs.gText("//*[@id='WC_CatalogSearchResultDisplay_div_6_1']/div/div[2]/div[3]/div[1]");
	    	 System.out.println(displayPrice);
	    	 ps.price = displayPrice;
	    	 gs.writePassLog("Price of the selected Item for shopping order - "+displayPrice);
	    	 gs.clickLinkWD("//*[@id='product-item-info_2170793']");
	    	 String color = gs.gText("//*[@id='attribute-Color']/div");
	    	 gs.writePassLog("Color Selected  - "+color);
	    	 
	    	 /*Extract all links from Women Section*/
				gs.writeHeader("Availbel Size for [ "+shoppingItem+" ] are below :" );	
				List  size = driver.findElement(By.xpath("//*[@id='attribute-Size']")).findElements(By.tagName("a"));
				for(int i =0; i< size.size();i++){
				
				gs.writeResults(((WebElement) size.get(i)).getText());
				}
				
				gs.clickLinkWD("//*[@id='Size-undefined-Md']/a");
			//Comparing the price of the displayed & shopping item - Price checkpoint
				String shopingPrice = gs.gText("//*[@id='prod-price']/div");
				if(displayPrice.equals(shopingPrice)) {
					gs.writePassLog("Display price & Shopping oder price are same");
				}
				else
				{
					gs.writeFailLog("Display price is [ "+displayPrice+" ] & Shopping price [ "+shopingPrice+ " ]");
				}
				//Adding to cart
				gs.clickButtonWD("//*[@id='addToCartBtn']");
		/*		//Popping up select size alert message.
				Alert alert = driver.switchTo().alert();
		        // check if alert exists
		       gs.writePassLog("Alert Message - " +alert.getText());
		       alert.accept();
		       //Selecting size 
		       gs.clickButton("//*[@id='Size-undefined-Md']/a");
		  */     
		       gs.clickLinkWD("//*[@id='addToCartBtn']");
				
		  //     gs.clickLinkWD("//*[@id='shoppingcart-popout']/div[2]/div/p[1]");
		       
		       gs.clickButtonWD("//*[@id='shoppingcart-checkout-button']/a");
		       
		       String cartOrder = gs.gText("//*[@id='cart-area']/h1");
		       gs.writePassLog(cartOrder);
		      
		       String prodSubtotal = gs.gText("//*[@id='total-subtotal']");
		       gs.writePassLog("Product Subtotal - "+prodSubtotal);
		       String prodTotal = gs.gText("//*[@id='product-balance']");
		       gs.writePassLog("Product Total - "+prodTotal);
		       String estShipping = gs.gText("//*[@id='total-shipping']");
		       gs.writePassLog("Estimated Shipping - "+estShipping);
		       String estTotal = gs.gText("//*[@id='total-total']");
		       gs.writePassLog("Estimated Total - "+estTotal);
		       
		       gs.clickButtonWD("//*[@id='cart-area']/div[16]/a[1]");
		       
		       gs.clickButtonWD("//*[@id='guest-content']/a");
//		       String guest = gs.gText("//*[@id='guest-content']/div/p");
//		       gs.writeHeader(guest);
		       
		    		       
		       //Billing Address
		       Workbook w = Workbook.getWorkbook(new File("C:/WorkSpace/Automation/TestData/TestData.xls"));
				Sheet s = w.getSheet("TC_PlaceOrder_Guest");
				String fName = s.getCell(3, 1).getContents();
				String LName = s.getCell(3, 2).getContents();
				
				String StrAddress = s.getCell(3, 3).getContents();
				String AddDelInfo = s.getCell(3, 4).getContents();
				String City =  s.getCell(3, 5).getContents();
				String State =  s.getCell(3, 6).getContents();
				String ZipCode = s.getCell(3, 7).getContents();
				String PhNum1 = s.getCell(3, 8).getContents();
				String PhNum2 = s.getCell(4, 8).getContents();
				String PhNum3 = s.getCell(4, 9).getContents();
				String eMail = s.getCell(3, 9).getContents();
				
				//Entering the values in the Billing address
				gs.typeIntoEditBoxWD("//*[@id='addAddressForm_Billing']/dl/dd[1]/input",fName);
				gs.typeIntoEditBoxWD("//*[@id='addAddressForm_Billing']/dl/dd[2]/input",LName);
				gs.typeIntoEditBoxWD("//*[@id='addAddressForm_Billing']/dl/dd[3]/input",StrAddress);
				gs.typeIntoEditBoxWD("//*[@id='addAddressForm_Billing']/dl/dd[4]/input",AddDelInfo);
				gs.typeIntoEditBoxWD("//*[@id='addAddressForm_Billing']/dl/dd[5]/input",City);
				gs.typeIntoEditBoxWD("//*[@id='addAddressForm_Billing']/dl/dd[7]/input",ZipCode);
				gs.typeIntoEditBoxWD("//*[@id='addAddressForm_Billing']/dl/dd[8]/input[1]",PhNum1);
				gs.typeIntoEditBoxWD("//*[@id='addAddressForm_Billing']/dl/dd[8]/input[2]",PhNum2);
				gs.typeIntoEditBoxWD(".//*[@id='addAddressForm_Billing']/dl/dd[8]/input[3]",PhNum3);
				gs.typeIntoEditBoxWD("//*[@id='addAddressForm_Billing']/dl/dd[9]/input",eMail);
				
				gs.clickButtonWD("//*[@id='content-area']/div[6]/a[1]");
		      
		       
	        if(rs.failcounter>0){        	
	            rs.writeFailSummary(getClass().getSimpleName(), "FAIL");
	            Main.fail++; 
	            Main.failTestScript.add(getClass().getSimpleName()); 
	        }
	        else{
	        	 rs.writePassSummary(getClass().getSimpleName(), "PASS");
	        	 Main.pass++;
	        }
	      }
	    	 catch(SeleniumException e){
	 			System.out.println(e);
	 			StringWriter sw = new StringWriter();
	 			e.printStackTrace(new PrintWriter(sw));
	 			String st=sw.toString();
	 			gs.writeFailLog(st);
	 			rs.writeFailSummary(getClass().getSimpleName(), "FAIL");
	 		}
	     }     
	 }