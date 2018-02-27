package com.collection.garbage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.excellibrary.bealls.ExcelLibrary;

public class Garbage {

//	Method[] ar=	cls.getDeclaredMethods();
//	for(int counter=0;counter<ar.length;counter++)
//	{
//		Class params[] =ar[counter].getParameterTypes();
//		for(int innCounter=0;innCounter<params.length;innCounter++)
//		{
//		System.out.println(params[innCounter]);
//		}
//	}
	
	public static void main(String[] args) {
		
		ExcelLibrary e  = new ExcelLibrary("C:\\Users\\skandakumar.v\\Documents\\Bealls docs\\Bealls_Fresh_Excel\\Bealls_Execution_Excel.xlsx");
		int rowCount = e.getRowCount("Scenarios");
		
		
		
	 for(int i=1;i<=rowCount;i++)
	 {
		 
		 Object ar []=e.getRowData("Scenarios", i);
		 
		 for(int j=0;j<ar.length;j++)
		 {
			 System.out.print(ar[j]);
		 }
		 System.out.println();
	 }
		
	}
}
