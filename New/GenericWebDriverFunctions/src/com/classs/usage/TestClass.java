package com.classs.usage;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;

import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.Pages.AllBealls.PopUpPage;
import com.Pages.AllBealls.ProductDisplayPage;
import com.Pages.AllBealls.SearchDisplayPage;
import com.excellibrary.bealls.ExcelLibrary;
import com.relevantcodes.extentreports.ExtentReports;

public class TestClass {
		public static SearchDisplayPage sdp=null;
		public static PopUpPage pup=null;
		public static ProductDisplayPage pdp =null;
		public static  ArrayList<String> classes=null;
		public static Class cls= null;
		public static ExtentReports report =null;
		public static int cellNo ;
	 
		public static ExcelLibrary excel=null; 
		
		public static void main(String[] args) throws InterruptedException   {
		
 
		try
		{
			excel = new ExcelLibrary("C:\\Users\\skandakumar.v\\Documents\\Bealls docs\\Bealls_Fresh_Excel\\Bealls_Execution_Excel.xlsx");
			
			String driver = (String) excel.getCellData("TestData", 0, 1);
			String url = (String) excel.getCellData("TestData", 1,1);
		report= new ExtentReports("TestExecutionReport.html");
		GenericWebDriverFunctions.loadDriver(driver);
		GenericWebDriverFunctions.startServer("http://d3.beallsflorida.com/");
	  
		sdp = new SearchDisplayPage();
		pup = new PopUpPage();
		pdp = new ProductDisplayPage();
		getAllClasses(System.getProperty("user.dir")+"\\src\\com\\Pages\\AllBealls\\");
		executeMethods();
  
		 
	     
	    Thread.sleep(500);
		GenericWebDriverFunctions.stopServer();
 
		
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
 

	}
	
	
	
	public static void getAllClasses(String path) {
		classes=new ArrayList<String>();
		 File folder = new File(path);
		 File[] listOfFiles = folder.listFiles();

		     for (int i = 0; i < listOfFiles.length; i++) {
		       if (listOfFiles[i].isFile()) {
		         //System.out.println(listOfFiles[i].getName().substring(0, listOfFiles[i].getName().indexOf(".")));
		         classes.add(listOfFiles[i].getName().substring(0, listOfFiles[i].getName().indexOf(".")));
		         
		         
		       }  
		     }
	 
		}
	
	
	public static void executeMethods()
	{
	 
 
		
		int rowCount = excel.getRowCount("Scenarios");
		 for(int counter1=1;counter1<=rowCount;counter1++)
		 {
			 cellNo = counter1;
			 String ar []=excel.getRowData("Scenarios", counter1);
			 System.out.println("Cell No "+cellNo);
			 
		String methods[] = ar;
		Class noParams[]={};
	
 //Code to check critical path entries from excel sheet
//		for(int counter2=0;counter2<methods.length;counter2++)
//		{
//		System.out.println(methods[counter2]);
//		}
		
	 	
		for(int counter2=0;counter2<methods.length;counter2++)
		{
		for(int counter3=0;counter3<classes.size();counter3++)
		{
		try
		{
			cls= Class.forName("com.Pages.AllBealls."+classes.get(counter3));
		 	Method method;
			Object obj = cls.newInstance();
		 
			invokeMethod(methods[counter2]);
		 
		}
		catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SecurityException | IllegalArgumentException  e)
		{
		e.printStackTrace();	
		}
		
		}
		}
		
		 }

	}
	
	
	public static void  invokeMethod(String methodName)
	{
	 
		Method[] ar=	cls.getDeclaredMethods();
		Method method = null;
		for(int counter=0;counter<ar.length;counter++)
		{
			 
			if(ar[counter].toString().contains(methodName))
			{
				 
				try
				{
				method = cls.getDeclaredMethod(methodName, null);
				method.invoke("", null);
				break;
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
 
			}
		}
		
	 
	}

}
