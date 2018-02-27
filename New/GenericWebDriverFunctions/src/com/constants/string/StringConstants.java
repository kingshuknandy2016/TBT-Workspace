package com.constants.string;

public class StringConstants {

	//locator constants
	public static final String XPATH="xpath",ID="id",NAME="name",CLASSNAME="classname",LINKTEXT="linktext",PARTIALLINKTEXT="partiallinktext",CSSSELECTOR="cssselector",TAGNAME="tagname";
	
	//action names constants
	public static final String CLICK="click",SELECTINDEX="selectindex",SENDKEYS="sendkeys", SUBMIT="submit",MOUSEOVER="mouseover",GETTEXT="gettext",SELECTVALUE="selectvalue";
	
	//Browser names
	public static final String CHROME="chrome",IE="ie", FIREFOX="firefox";
	
	//Elements located by ID
	public static final String SEARCHBOX ="SimpleSearchForm_SearchTerm" ,SEARCHBUTTON="search-btn",PDPADDTOCART="addToCartBtnPdpText",
				CARTPAGEPRICE="modal-product-price" ;
	
	
	//Elements located by CLASSNAME
	public static final String POPUP="fsrCloseBtn";
	
	//Elements located by LINKTEXT
//	public static final String ;
	
	//Elements located by XPATH																							 
	public static final String SDPUNITPRICE = "//div[@class='search-results-container container-fluid section']/div[1]/div[1]/div[2]/div[3]/div[1]",
			PDPSHIRT="//div[@class='search-results-container container-fluid section']/div/div[1]/div[1]/a[1]",
			QUICKVIEW ="//div[@class='search-results-container container-fluid section']/div/div[1]/div[1]/a[2]",
			SDPPRICES="//div[@class='search-results-container container-fluid section']/div[1]/div[*]/div[2]/div[3]/div[1]",
					SIZE="//li[@id='Size-undefined-1X']/a";

	public static final String SELPROD="//div[@class='search-results-container container-fluid section']/div[1]/div[1]/div[1]/a[1]/img",
			PRODPRICE = "//div[@id='prod-price']/div[1]";
	public static final String QVLINK="//div[@class='search-results-container container-fluid section']/div[1]/div[1]/div[1]/a[2]",
			QVPRICE="//div[@id='prod-price']//div[@class='price']",
			ADDTOCARTCLOSE="//a[@class='simplemodal-close modal-close btn-alt2']",
			QVCLOSE="//div[@id='productAddToCartModal']/div[1]/div[1]/div[1]/a";
		
	
	
	
	
	
	
	
	//Environment
//	public static final String 
	
	
	
	
	public static final String CP_price="(//div[@class='item-price'])[1]//div[@class='price']";
	public static final String PDP_price="";
	public static final String QV_price="//div[@id='prod-price']//div[@class='price']";
	public static final String SRP_price="(//div[@class='price'])[1]";
	
	public static final String CP_price_reg="(//div[@class='item-price'])[1]//div[@class='price-reg']";
	public static final String PDP_price_reg="";
	public static final String QV_price_reg="//div[@class='list-price price-reg']";
	public static final String SRP_price_reg="(//div[@class='price-reg'])[1]";
	
	public static final String CP_price_save="(//div[@class='item-price'])[1]//div[@class='price-save save-price']";
	public static final String PDP_price_save="";
	public static final String QV_price_save="//div[@class='save-price price-save']";
	public static final String SRP_price_save="(//div[@class='price-save'])[1]";
	
	
	public static final String QVButton="(//a[@class='quick-view-button btn-secondary'])[1]";
	
	
	public static final String keyWordSearchbox="//input[@id='SimpleSearchForm_SearchTerm']";
	//a[@id='addToCartButton']
	public static final String AddToCartButton="//a[@id='addToCartButton']";
	
	public static final String  CheckOutButton="(//a[@class='checkout-button btn-checkout'])[1]";
	public static final String SizeDropDown ="//select[@id='dd-Size']";
}
