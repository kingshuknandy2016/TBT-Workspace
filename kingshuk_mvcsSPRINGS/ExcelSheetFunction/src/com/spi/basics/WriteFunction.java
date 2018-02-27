package com.spi.basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;
 
import org.apache.poi.ss.usermodel.Workbook;
import org.omg.CORBA.PUBLIC_MEMBER;

import jxl.*;
 



public class WriteFunction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WriteFunction wr=new WriteFunction();
		//   wr.Read();
		wr.write();
		

	}
	
	public void Read() {
		try{
			File exlFile = new File("C:/WorkSpace/CheckAutomation.xls");
			FileInputStream fi=new FileInputStream(exlFile);
		    jxl.Workbook w=jxl.Workbook.getWorkbook(exlFile);
			jxl.Sheet s=w.getSheet("Check2");
		
			for (int row = 1; row < s.getRows(); row++) {
				String st1=s.getCell(1,row).getContents();
				System.out.println("UserId:"+st1);
				String st2=s.getCell(2,row).getContents();
				System.out.println("Name:"+st2);
			}
			
            }catch(Exception e1){
			System.out.println("Error:"+e1);
		}
	}
	
	public void write(){
		try{File exlFile = new File("C:/WorkSpace/CheckAutomation.xls");
		FileInputStream fi=new FileInputStream(exlFile);
	   HSSFWorkbook workbook=new HSSFWorkbook(fi);
	   HSSFSheet sheet=workbook.getSheet("Check2");
		for (int row = 1; row < sheet.getPhysicalNumberOfRows(); row++) {
			String designation=sheet.getRow(row).getCell(0).getStringCellValue();
			System.out.println(designation);
			if(designation.equalsIgnoreCase("Manager")){
				sheet.getRow(row).createCell(3).setCellValue(6000);
			}else{
				sheet.getRow(row).createCell(3).setCellValue(14000);
			}
		}
		FileOutputStream fos=new FileOutputStream(new File("C:/WorkSpace/CheckAutomation.xls"));
		workbook.write(fos);
		System.out.println("Successfull///////////");
			
		
		
		}catch(Exception e1){
			System.out.println("Error:"+e1);
		}
	}

}
