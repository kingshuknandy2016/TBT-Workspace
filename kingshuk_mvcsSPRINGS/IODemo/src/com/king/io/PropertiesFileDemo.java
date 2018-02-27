package com.king.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFileDemo {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Properties prop;
		
		//read from properties
		/*InputStream in = new FileInputStream("demo.properties");
		prop = new Properties();
		prop.load(in);
		
		for (String key : prop.stringPropertyNames()){
			String val = prop.getProperty(key);
			System.out.println(key+"="+val);
		}*/
		
		
		//write into properties
		OutputStream out = new FileOutputStream("demo.properties");
		prop = new Properties();
		prop.setProperty("company", "spi");
		prop.setProperty("mob", "9999999999");
		prop.store(out, "details--");
	}

}
