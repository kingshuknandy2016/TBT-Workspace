package com.Pages.AllBealls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.classs.usage.TestClass;
import com.collection.garbage.Constants;
import com.constants.string.StringConstants;

public class SearchDisplayPage {
	
	public static String price ; 
	public static String qvPrice;
	
	@FindBy(id=StringConstants.SEARCHBOX)
	public static WebElement searchBox;
	
	@FindBy(id=StringConstants.SEARCHBUTTON)
	public static WebElement searchButton;
	
	@FindBy(xpath=StringConstants.SDPUNITPRICE)
	public static WebElement shirtPrice;
	
	@FindBy(xpath=StringConstants.SELPROD)
	public static WebElement selectProduct;
	
	@FindBy(xpath=StringConstants.QVLINK)
	public static WebElement quickView;
	
	@FindBy(xpath=StringConstants.QVCLOSE)
	public static WebElement quickViewClose;
	
	@FindBy(xpath=StringConstants.QVPRICE)
	public static WebElement QVPrice;
	
	@FindBy(xpath=StringConstants.QV_price)
	public static WebElement QV_OfferPrice;
	
	@FindBy(xpath=StringConstants.QV_price_reg)
	public static WebElement QV_ListPrice;
	
	@FindBy(xpath=StringConstants.QV_price_save)
	public static WebElement QV_DiscountPercent;
	
	
	@FindBy(xpath=StringConstants.SRP_price)
	public static WebElement SRPPrice;
	
	@FindBy(xpath=StringConstants.SRP_price_reg)
	public static WebElement SRPPriceReg;
	
	@FindBy(xpath=StringConstants.SRP_price_save)
	public static WebElement SRPPriceSave;
	
	@FindBy(xpath=StringConstants.SizeDropDown)
	public static WebElement SizeDropDown;
	
	@FindBy(xpath=StringConstants.AddToCartButton)
	public static WebElement AddToCartButton;
	
	
	@FindBy(xpath=StringConstants.CheckOutButton)
	public static WebElement CheckOutButton;
	
	
	@FindBy(xpath=StringConstants.CP_price)
	public static WebElement CP_OfferPrice;
	
	@FindBy(xpath=StringConstants.CP_price_reg)
	public static WebElement CP_ListPrice;
	
	@FindBy(xpath=StringConstants.CP_price_save)
	public static WebElement CP_DiscountPercent;
	
	
	
//	@FindBy(xpath=StringConstants.)
	
	
	public SearchDisplayPage()
	{
		PageFactory.initElements(GenericWebDriverFunctions.driver,this);
	}
	public static void search()
	{  
		String keyWord = (String) TestClass.excel.getCellData("TestData",4 , TestClass.cellNo);
		System.out.println("Search key Word "+keyWord);
		GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, searchBox, keyWord);
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, searchButton, keyWord);
		 
	}
	 
	
	public static void getSDPPrice()
	{
		GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, shirtPrice, "");
		SearchDisplayPage.price=GenericWebDriverFunctions.getText;
	}
	
	public static void getAllPageInfo()
	{
//		GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, shirtPrice, "");	
	}
	
	
	public static void selectProduct()
	{
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, selectProduct, "");
	}
	
	
	public static void selectQuickView() throws InterruptedException
	{
		hoverOnProd();
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, quickView, "");
		 
	}
	
	
	public static void closeQuickView()
	{
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, quickViewClose, "");
	}
	
	public static void getQVPrice()
	{
		GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, QVPrice, "");
		SearchDisplayPage.qvPrice =GenericWebDriverFunctions.getText;
		
	}
	
	public static void hoverOnProd()
	{
		GenericWebDriverFunctions.performAction(StringConstants.MOUSEOVER, selectProduct, "");
	}
	

	
	public static void ValidateDiscountsSRP() throws InterruptedException{
		//Thread.sleep(1000);
		String OfferPrice=null;
		String ListPrice=null;
		String DiscountPercent=null;
		if(GenericWebDriverFunctions.isDisplayed(SRPPrice)){
			GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, SRPPrice, "");
			String offerprice=" "+GenericWebDriverFunctions.getText;
			String OfferPrice1[]=offerprice.split("\\$");
			OfferPrice=OfferPrice1[1];
			System.out.println("OfferPrice:$"+OfferPrice);
		}else{
			System.out.println("Offer Price is not Displayed");
		}
		
		

		if(	GenericWebDriverFunctions.isDisplayed(SRPPriceReg)){
			GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, SRPPriceReg, "");
			String st=GenericWebDriverFunctions.getText;
			String starr[]=st.split("\\$");
			ListPrice=starr[1];
			System.out.println("List Price:$"+ListPrice);
		}else{
			System.out.println("List Price is not Displayed");
		}
		
		
		if(GenericWebDriverFunctions.isDisplayed(SRPPriceSave)){
			GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, SRPPriceSave, "");
			String st2[]=GenericWebDriverFunctions.getText.split("\\:");
			String Save1[]=(st2[1]+" ").split("\\%");
			DiscountPercent=Save1[0];
			System.out.println("Save :"+DiscountPercent+"%");
		}else{
			System.out.println("Save % is not Displayed");
		}
		
		Double OfferPriceFormattet=Double.valueOf(OfferPrice);
		double listPriceFormattet=Double.valueOf(ListPrice);
		double DiscountPercentFormattet=Double.valueOf(DiscountPercent);
		
		Double calculatedOfferPriceFormattet=listPriceFormattet*(1-(DiscountPercentFormattet/100));
		int OfferPriceint=OfferPriceFormattet.intValue();
	    int result=calculatedOfferPriceFormattet.intValue();
	    System.out.println("//////"+OfferPriceint+"//////"+result);
	    if(OfferPriceint==result){
	    	System.out.println("proper offer price is displayed in SRP");
	    }else{
	    	System.out.println("proper offer price is not displayed in SRP");
	    }
		
		
	}
	
public static void ValidateDiscountsInQV() {
		

		String OfferPrice=null;
		String ListPrice=null;
		String DiscountPercent=null;
		
		if(GenericWebDriverFunctions.isDisplayed(QV_OfferPrice)){
			GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, QV_OfferPrice, "");
			String offerprice=" "+GenericWebDriverFunctions.getText;
			String OfferPrice1[]=offerprice.split("\\$");
			OfferPrice=OfferPrice1[1];
			System.out.println("OfferPrice:$"+OfferPrice);
		}else{
			System.out.println("Offer Price is not Displayed");
		}
		
		if(GenericWebDriverFunctions.isDisplayed(QV_ListPrice)){
			GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, QV_ListPrice, "");
			String st=GenericWebDriverFunctions.getText;
					
			String starr[]=st.split("\\$");
			ListPrice=starr[1];
			System.out.println("List Price:$"+ListPrice);
		}else{
			System.out.println("List Price is not Displayed");
		}
		
		if(GenericWebDriverFunctions.isDisplayed(QV_DiscountPercent)){
			GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, QV_DiscountPercent, "");
			String st2[]=GenericWebDriverFunctions.getText.split("\\:");
			String Save1[]=(st2[1]+" ").split("\\%");
			DiscountPercent=Save1[0];
			System.out.println("Save :"+DiscountPercent+"%");
		}else{
			System.out.println("Save % is not Displayed");
		}
		
		Double OfferPriceFormattet=Double.valueOf(OfferPrice);
		double listPriceFormattet=Double.valueOf(ListPrice);
		double DiscountPercentFormattet=Double.valueOf(DiscountPercent);
		
		Double calculatedOfferPriceFormattet=listPriceFormattet*(1-(DiscountPercentFormattet/100));
		int OfferPriceint=OfferPriceFormattet.intValue();
	    int result=calculatedOfferPriceFormattet.intValue();
	    System.out.println("//////"+OfferPriceint+"//////"+result);
	    if(OfferPriceint==result){
	    	System.out.println("proper offer price is displayed in Quick View");
	    }else{
	    	System.out.println("proper offer price is not displayed in Quick View");
	    }
		
	}
	
public static void addToCart_QV(){
	GenericWebDriverFunctions.performAction(StringConstants.SELECTINDEX,SizeDropDown , "1");
	GenericWebDriverFunctions.performAction(StringConstants.CLICK, AddToCartButton, "");
	GenericWebDriverFunctions.performAction(StringConstants.CLICK, CheckOutButton, "");
}


public static void ValidateDiscountsInCP() throws InterruptedException{
	
	//Thread.sleep(1000);
	String OfferPrice=null;
	String ListPrice=null;
	String DiscountPercent=null;
	if(GenericWebDriverFunctions.isDisplayed(CP_OfferPrice)){
		GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, CP_OfferPrice, "");
		String offerprice=" "+GenericWebDriverFunctions.getText;
		String OfferPrice1[]=offerprice.split("\\$");
		OfferPrice=OfferPrice1[1];
		System.out.println("OfferPrice:$"+OfferPrice);
	}else{
		System.out.println("Offer Price is not Displayed");
	}
	
	if(GenericWebDriverFunctions.isDisplayed(CP_ListPrice)){
		GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, CP_ListPrice, "");
		String st=GenericWebDriverFunctions.getText;
		
		String starr[]=st.split("\\$");
		ListPrice=starr[1];
		System.out.println("List Price:$"+ListPrice);
	}else{
		System.out.println("List Price is not Displayed");
	}
	
	if(GenericWebDriverFunctions.isDisplayed(CP_DiscountPercent)){
		GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, CP_DiscountPercent, "");
		String st2[]=GenericWebDriverFunctions.getText.split("\\:");
		String Save1[]=(st2[1]+" ").split("\\%");
		DiscountPercent=Save1[0];
		System.out.println("Save :"+DiscountPercent+"%");
	}else{
		System.out.println("Save % is not Displayed");
	}
	
	Double OfferPriceFormattet=Double.valueOf(OfferPrice);
	double listPriceFormattet=Double.valueOf(ListPrice);
	double DiscountPercentFormattet=Double.valueOf(DiscountPercent);
	
	Double calculatedOfferPriceFormattet=listPriceFormattet*(1-(DiscountPercentFormattet/100));
	int OfferPriceint=OfferPriceFormattet.intValue();
    int result=calculatedOfferPriceFormattet.intValue();
    System.out.println("//////"+OfferPriceint+"//////"+result);
    if(OfferPriceint==result){
    	System.out.println("proper offer price is displayed in Cart Page");
    }else{
    	System.out.println("proper offer price is not displayed in Cart Page");
    }
	
}
	

}
