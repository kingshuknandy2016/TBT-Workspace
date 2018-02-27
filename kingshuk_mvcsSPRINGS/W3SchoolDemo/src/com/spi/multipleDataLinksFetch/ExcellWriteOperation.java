package com.spi.multipleDataLinksFetch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class ExcellWriteOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//write("C:/WorkSpace/FootBallDetails.xls", "CoachDetails", 1, 1, "done");
	}
	
static void write(String filepath,String Sheetname,int rowRo,int columnCo,String value){
	try { 
		File exlFile = new File(filepath);
		FileInputStream fi = new FileInputStream(exlFile);
		HSSFWorkbook workbook = new HSSFWorkbook(fi);
		HSSFSheet sheet = workbook.getSheet(Sheetname);
        if(columnCo==0){
		Row row1 = sheet.createRow(rowRo);
        }
		sheet.getRow(rowRo).createCell(columnCo).setCellValue(value);
		System.out.println(rowRo+"---"+columnCo);
		
	//	Thread.sleep(2000);
		FileOutputStream fos = new FileOutputStream(new File(filepath));
		workbook.write(fos);
		
		System.out.println("Successfull///////////");

	} catch (Exception e1) {
	  System.out.println("Error in writting::::"+e1);
	}
	
	}

}
