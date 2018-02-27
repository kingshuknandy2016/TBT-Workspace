package com.spi.SearchDisplay;

public class Constants {
	
	//User Directory
	public static final String USERDIRECTORY =System.getProperty("user.dir");

	
	//Excel Sheet path
	
	
	//Screen shot path
	public static final String SCREENSHOTPATH ="\\screenshots\\";
	
	
	//Static html file path
	public static final String FIRSTFILEPATH=System.getProperty("user.dir")+"\\first.txt";
	public static final String LASTFILEPATH=System.getProperty("user.dir")+"\\last.txt";
	public static final String FINALREPORT =System.getProperty("user.dir")+"\\FinalReport.html";
	
			
	
	
	//Browser and its path info 
	public static final String CHROMEDRIVER="\\lib\\chromedriver.exe";
	public static final String IEDRIVER="\\lib\\IEDriverServer.exe";
	
	
	
	//Elements By link text
	public static final String MENSLINKTEXT = "Men";
	public static final String TSHIRTSLINKTEXT="T-Shirts";
	public static final String NINETYLINKTEXT="90";
 
	
	
	//Elements By ID
	public static final String IDORDERBY ="orderBy";
	
	
	//Elements By Xpath
	public static final String TOTALITEMSPERPAGE="//div[contains(@class,'view-information')]";
	public static final String PRICEPERITEM="//div[contains(@class,'match-height-context row')]/div[*]/div[2]/div[3]/div[@class='price']";
	public static final String NEXTPAGE="//span[@class='icon-page-next']";
	public static final String RATINGPERITEM ="//div[contains(@class,'match-height-context row')]/div[*]/div[2]/div[4]/img";
	
	//Elements By ClassPath
	public static final String CLOSEPOPUP = "fsrCloseBtn";
	
	
	//Color codes 
	public static final String FAILED="style=background-color:red;";
	public static final String PASSED="style=background-color:#5FFF65;";
	public static final String SKIPPED="style=background-color:yellow;";
	
	
	//Pass /Fail /Skip statuses in String
	public static final String PASS="Pass";
	public static final String FAIL="Fail";
	public static final String SKIP="Skip";
	
	
}
