package com.spi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelLibrary {


	static String filePath = "C:\\MaheshM\\Student Details.xlsx";
	public static void main(String[] args) {
		
		
		System.out.println("Main Method Starts");
		String sheetName = "Students List";
		//rowCount will be having last Row number
		int rowCount = getRowCount(sheetName);
		System.out.println("Row Count = "+rowCount);
		
		for(int i = 1;i<=rowCount;i++){
			String name = (String)getCellData(sheetName, i, 0);
			String degree = (String)getCellData(sheetName, i, 1);
			double per = (Double)getCellData(sheetName, i, 2);
			System.out.println("Name = "+name+"\tDegree = "+degree+"\t% = "+per);
			if(per > 85)
				writeToCell(sheetName, i, 3, "PASS");
			else
				writeToCell(sheetName, i, 3, "FAIL");
		}
		System.out.println("Main Method Ends");
	}
	
	public static int getRowCount(String sheetName){
		int rowCount = -1;
		
		FileInputStream fis = null;
		try {
			//Open file in read mode
			fis = new FileInputStream(filePath);
			
			//to create a work book
			Workbook wb = WorkbookFactory.create(fis);
			
			//get into required sheet
			Sheet sh = wb.getSheet(sheetName);
			
			if(sh == null){
				//if sheetName is not valid
				throw new Exception("Invalid SheetName");
			}
			//get last row number as row count
			rowCount = sh.getLastRowNum();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rowCount;
		
	}
	
	
	public static Object getCellData(String sheetName,int rowNum,int cellNum){
		Object data = null;
		FileInputStream fis = null;
		try {
			//Open file in read mode
			fis = new FileInputStream(filePath);
			
			//to create a work book
			Workbook wb = WorkbookFactory.create(fis);
			
			//get into required sheet
			Sheet sh = wb.getSheet(sheetName);
			
			if(sh == null){
				//if sheetName is not valid
				throw new Exception("Invalid SheetName");
			}
			
			//get Into Row
			Row r = sh.getRow(rowNum);
			
			
			
			//get into cell
			Cell c = r.getCell(cellNum);
			
			switch(c.getCellType()){
			
			case Cell.CELL_TYPE_STRING: //get String cell value
										data = c.getStringCellValue();
										break;
			case Cell.CELL_TYPE_NUMERIC:data = c.getNumericCellValue();
										break;
			
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return data;
	}
	
	
	public static void writeToCell(String sheetName,int rowNum,int cellNum,String data){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			//Open file in read mode
			fis = new FileInputStream(filePath);
			
			//to create a work book
			Workbook wb = WorkbookFactory.create(fis);
			
			//get into required sheet
			Sheet sh = wb.getSheet(sheetName);
			
			if(sh == null){
				//if sheetName is not valid
				throw new Exception("Invalid SheetName");
			}
			
			//get Into Row
			Row r = sh.getRow(rowNum);
			
			//create cell 
			Cell c = r.createCell(cellNum);
			c.setCellValue(data);
			//open file in write mode
			fos = new FileOutputStream(filePath);
			//write data to file
			wb.write(fos);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
}
