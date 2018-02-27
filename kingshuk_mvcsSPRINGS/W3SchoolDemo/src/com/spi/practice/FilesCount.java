package com.spi.practice;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class FilesCount {
	static int count = 0;
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		//getFile("C:/Users/kingshuk.nandy/Downloads/abc");
		//System.out.println("no. of files in total------------"+count);
        getDirectoryFileCount();
		
	}
	
	private static void getFile(String dirPath) {
	    File f = new File(dirPath);
	    File[] files = f.listFiles();

	    if (files != null)
	    for (int i = 0; i < files.length; i++) {
	        count++;
	        File file = files[i];

	        if (file.isDirectory()) {   
	             getFile(file.getAbsolutePath()); 
	             System.out.println(":::"+file.getAbsolutePath());
	             
	        }
	    }
	}
	
	private static void getDirectoryFileCount() throws IOException{
		File f = new File("C:\\Users\\kingshuk.nandy\\Downloads");
		//f.listFiles();
	//	System.out.println(f.getPath());
		 //File[] files = f.listFiles();
		 File[] files = f.listFiles(new FileFilter() {
			
			public boolean accept(File fat) {
				// TODO Auto-generated method stub
				return fat.isDirectory();
			}
		});
		 System.out.println("Folders count: " + files.length);

		 File[] filesFolders = f.listFiles();
		 int FileCount=filesFolders.length-files.length;
		 System.out.println("Files count: " + FileCount);
		 System.out.println("--------------------------------------------");
		 for (int i = 0; i < files.length; i++) {
			System.out.println("Name:"+files[i]);
			File innerf = new File(files[i].toString());
			
			File[] innerfiles = innerf.listFiles();
			 System.out.println("Files count: " + innerfiles.length);
			 for (int j = 0; j < innerfiles.length; j++) {

			String st1=innerfiles[j].toString();
			
			System.out.println("Files Path:"+st1);
			
			/*File exlFile = new File(st1);
			FileInputStream fi = new FileInputStream(exlFile);
			
				HSSFWorkbook workbook = new HSSFWorkbook(fi);
				HSSFSheet sheet = workbook.getSheetAt(1);
				
				int count1122=sheet.getPhysicalNumberOfRows();
				System.out.println("FileNames::"+innerfiles[j].getName()+" "+"No of Rows:"+count1122);		*/				
			}
			 System.out.println("--------------------------------------------");
		}
		
	}

}
