package com.test.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileIO {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub

		
		Properties props=new Properties(); // Empty
		System.out.println(props.isEmpty());
		props.load(new FileInputStream("C:\\Props\\data.txt"));
		System.out.println(props.isEmpty());
		
		System.out.println(props.get("CJ101"));
		
	}

}
