/**********************************************************************************
 *                                                                                 
 * @author $Author: SPI(Barsha Mohanty)                                    
 * @version $Revision: $, $Date: $
 ***********************************************************************************
 * Package          :  default
 * Class Type       :  Class
 ***********************************************************************************
 *
 * This is the GenerateExcelFile class for APX ReportGeneration application.
 * It is acting as a class for Generating the report in excelsheet.
 ***********************************************************************************
 * Revision History
 * 
-----------------------------------------------------------------------------------
 * Created Date                :               13th November 2015
 * Last Modified Date          :               13th November 2015
-----------------------------------------------------------------------------------
 * Modification History
 * 1. Initial creation of GenerateExcelFile process .
 ***********************************************************************************
 */

package com.belk.excel;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.belk.dtos.ReportDTO;
import com.belk.file.ReadFile;

public class GenerateExcelFile {
	/**
	 * Creating the excel sheet with the reportdetailslist generated from the
	 * query
	 * 
	 * @param ReportDetailsList
	 * @param file
	 * @param logWriter
	 * @throws IOException
	 */
	public static void generateExcelFile(List<ReportDTO> reportDetailsList,
			ReadFile file, FileWriter logWriter) throws IOException {
		XSSFWorkbook myWorkBook = new XSSFWorkbook();
		XSSFSheet mySheet = myWorkBook.createSheet(file.getProperty("FirstSheet"));
		Row row = mySheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue(file.getProperty("DEPT_NBR"));
		cell = row.createCell(1);
		cell.setCellValue(file.getProperty("PLAN_NAME"));
		cell = row.createCell(2);
		cell.setCellValue(file.getProperty("VENDOR_STYLE_TXT"));
		cell = row.createCell(3);
		cell.setCellValue(file.getProperty("COLOR_DESCR"));
		cell = row.createCell(4);
		cell.setCellValue(file.getProperty("STORE_IMPORT_ID"));
		cell = row.createCell(5);
		cell.setCellValue(file.getProperty("ECOM_IMPORT_ID"));
		cell = row.createCell(6);
		cell.setCellValue(file.getProperty("ERR_MSG"));
		for (int index = 0; index < reportDetailsList.size(); index++) {
			ReportDTO reportDto = reportDetailsList.get(index);
			row = mySheet.createRow(index + 1);
			cell = row.createCell(index);
			cell.setCellValue(reportDto.getDeptNbr());
			cell = row.createCell(index);
			cell.setCellValue(reportDto.getPlanName());
			cell = row.createCell(index);
			cell.setCellValue(reportDto.getVendorStyleTxt());
			cell = row.createCell(index);
			cell.setCellValue(reportDto.getColorDescr());
			cell = row.createCell(index);
			cell.setCellValue(reportDto.getStoreImportId());
			cell = row.createCell(index);
			cell.setCellValue(reportDto.getEcomImportId());
			cell = row.createCell(index);
			cell.setCellValue(reportDto.getErrMsg());
		}
	    //Open an OutputStream to save written data into XLSX file 
		String outputDirPath =file.getProperty("excel.file");
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(outputDirPath);
			myWorkBook.write(fileOut);
		    }
		catch (IOException e) {
			logWriter.write("----------------ExcelSheet Saved Succesfully------------");
			e.printStackTrace();
     }
	}
}