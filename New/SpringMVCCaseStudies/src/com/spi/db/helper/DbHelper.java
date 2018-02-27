package com.spi.db.helper;

import java.sql.Connection;
import java.sql.DriverManager;




import static com.spi.db.helper.DbConstands.*;

public class DbHelper {
   public Connection getConnection(){
	   Connection con=null;
	   try {
		Class.forName(DRIVER);
		con=DriverManager.getConnection(URL, USER, PASS);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("-----:"+e);
	}
	   return con;
   }
   
   /*public static void main(String[] args) {
	new DbHelper().getConnection();
	System.out.println("After.......");
}*/
}
