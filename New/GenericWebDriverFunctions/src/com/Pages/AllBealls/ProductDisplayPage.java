package com.Pages.AllBealls;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.classs.usage.TestClass;
import com.constants.string.StringConstants;

public class ProductDisplayPage {

	@FindBy(xpath=StringConstants.PRODPRICE)
	public static WebElement productPrice;
	
	@FindBy(id=StringConstants.PDPADDTOCART)
	public static WebElement addToCart;
	
	@FindBy(xpath=StringConstants.SIZE)
	public static WebElement size;
	
	@FindBy(id=StringConstants.CARTPAGEPRICE)
	public static WebElement priceCartPage;
	
	@FindBy(xpath=StringConstants.ADDTOCARTCLOSE)
	public static WebElement AddToCartClose;
	
	public static String price;
	public static String priceCP;

	public ProductDisplayPage() {
		PageFactory.initElements(GenericWebDriverFunctions.driver, this);
	}
	
	public static void getPDPPrice()
	{
		GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, productPrice, "");
		ProductDisplayPage.price=GenericWebDriverFunctions.getText;
	}
	
	public static void addToCart_PDP()
	{
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, addToCart, "");
	
	}
	
	
	public static void selectSize()
	{
//		String size =(String) TestClass.excel.getCellData("TestData",5, 1);
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, size, "");
		
		
	}
	
	public static void getPriceCartPage()
	{
		GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, priceCartPage, "");
		ProductDisplayPage.priceCP=GenericWebDriverFunctions.getText;
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, AddToCartClose, "");
	}
	
	

}
