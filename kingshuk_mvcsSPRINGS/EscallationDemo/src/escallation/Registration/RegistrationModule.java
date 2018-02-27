package escallation.Registration;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import escallation.Users.Users;

public class RegistrationModule {
	static int rowcount111=1;

	public int register(Users newuser, int row) {
		System.out.println("---------" + newuser.getUserid());
		System.out.println("---------" + newuser.getFirstname());
		System.out.println("---------" + newuser.getEmail());
		int p=write(newuser, row);
		return p;
	}

	public static int write(Users newuserregister, int row) {
             int i=1;
		try {
			File exlFile = new File("C:/WorkSpace/UsersDetails.xls");
			FileInputStream fi = new FileInputStream(exlFile);
			HSSFWorkbook workbook = new HSSFWorkbook(fi);
			HSSFSheet sheet = workbook.getSheet("Users");
			//int pat=sheet.getPhysicalNumberOfRows();
			//System.out.println("Rows:"+pat);
			//pat=pat+1;
			int rowcount = sheet.getLastRowNum();
			System.out.println("row entry="+rowcount);
			Row row1 = sheet.createRow(rowcount);
			sheet.getRow(rowcount).createCell(0)
					.setCellValue(newuserregister.getUserid());
			sheet.getRow(rowcount).createCell(1)
					.setCellValue(newuserregister.getFirstname());
			sheet.getRow(rowcount).createCell(2)
					.setCellValue(newuserregister.getEmail());
			sheet.getRow(rowcount).createCell(3)
			.setCellValue(newuserregister.getUsername());
			sheet.getRow(rowcount).createCell(4)
			.setCellValue(newuserregister.getPassword());

			FileOutputStream fos = new FileOutputStream(new File(
					"C:/WorkSpace/UsersDetails.xls"));
			workbook.write(fos);
			rowcount++;
			System.out.println("Successfull///////////");

		} catch (Exception e1) {
			System.out.println("Error:" + e1);
			i=0;
			//rowcount--;
		}
		return i;
	}

}
