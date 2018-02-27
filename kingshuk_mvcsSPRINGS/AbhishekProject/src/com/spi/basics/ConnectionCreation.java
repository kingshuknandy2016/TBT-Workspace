package com.spi.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreation {
	static String driver, url, user, password;

	static {
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/abhishek";
		user = "root";
		password = "root";
	}
	
	
	private static Connection getConnection() throws ClassNotFoundException,SQLException {
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
	}
	
	//Call the connection function from main
	/*public static void main(String[] args) {
		try {
			getConnection();
			System.out.println("Connection Created successfully");
		} catch (Exception e) {
          System.out.println("Error::"+e);
		} 
		
	}*/
}
