package com.bealls.assignedcases;

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
	public ExcelLibrary(String filePath) {
		this.filePath = filePath;
	}
	String filePath;/*="C:\\WorkSpace\\BeallsProjectTest.xls" */
	
	
/*	public static void main(String[] args) {
		
		ExcelLibrary ell=new ExcelLibrary();
		ell.writeToCell("SubCategory", 1, 1, "run");
	System.out.println("Inside main");
	}*/
	
	
	public int getRowCount(String sheetName){
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
	
	
	public Object getCellData(String sheetName,int rowNum,int cellNum){
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
	
	
	public void writeToCell(String sheetName,int rowNum,int cellNum,String data){
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
	
	
	
	
	
	public void writeToCellCreatingRow(String sheetName,int rowNum,int cellNum,String data){
	FileInputStream fis = null;
	FileOutputStream fos = null;
	/*if(cellNum==0){
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
		
		Row r = sh.createRow(rowNum);
		//Row r = sh.getRow(rowNum);
		
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
	}else{*/

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
			
			//Row r = sh.createRow(rowNum);
			try {
				Row r = sh.getRow(rowNum);
				Cell c = r.createCell(cellNum);
				c.setCellValue(data);
			} catch (Exception e5) {
				System.out.println("Exception Ocured and it is:" + e5);
				Row r = sh.createRow(rowNum);
				Cell c = r.createCell(cellNum);
				c.setCellValue(data);
			}
			
			//create cell 
			
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
	
	
	public Object[][] getSheetDataAsArray(String sheetName,int noOfCols){
		Object[][] data = null;
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
			int rowCount = sh.getLastRowNum();
			data = new Object[rowCount][noOfCols]; 
			for(int i = 1;i<=rowCount;i++){
				for (int j = 0; j < noOfCols; j++) {
					Cell c = sh.getRow(i).getCell(j);
					switch (c.getCellType()) {
					case Cell.CELL_TYPE_STRING: // get String cell value
						data[i - 1][j] = c.getStringCellValue();
						break;
					case Cell.CELL_TYPE_NUMERIC:
						data[i - 1][j] = c.getNumericCellValue();
						break;
					}
				}
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
}
