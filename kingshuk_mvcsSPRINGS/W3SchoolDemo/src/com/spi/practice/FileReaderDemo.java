package com.spi.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileReaderDemo {

	public static void main(String[] args) {
		
		try {
			File fi=new File("C:\\WorkSpace\\abc.txt");
/*			FileOutputStream fos=new FileOutputStream(fi);
			 String s="Sachin Tendulkar is my llllllllllllllllllllll favourite player"; 
			 byte b[]=s.getBytes();//converting string into byte array  
			 fos.write(b);*/
			
			
			FileInputStream fis=new FileInputStream(fi);
			int i=0;  
		    while(fis.read()==-1){  
		     System.out.print((char)i);  
		    }  
		    fis.close();  
			 
			 
		} catch (Exception e1) {
           System.err.println("Error:::"+e1);
		}
		
		System.out.println("Successfully written.....");
	}
	
}
