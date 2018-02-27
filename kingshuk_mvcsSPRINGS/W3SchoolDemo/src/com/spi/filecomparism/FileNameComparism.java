package com.spi.filecomparism;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;







public class FileNameComparism {

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
	
	static Connection con;
	static Statement st;

	static java.sql.PreparedStatement pst;
	static ResultSet rs;
	
	
	public static List Questions(){
		String qry = "Select *from filelist";
		List list1 = new ArrayList ();
		

		try {
			con=getConnection();
			pst = con.prepareStatement(qry);
			rs = pst.executeQuery();
			while(rs.next()) {

				   list1.add(rs.getString("filename"));
				   }
			

		} catch (ClassNotFoundException e1) {
			System.out.println("Error:"+e1);
		} catch (SQLException e2) {
			System.out.println("Error:"+e2);
		}
		return list1;
		
	}
	
	
	
	private static List getDirectoryFileCount() throws IOException{
		
		List list2 = new ArrayList ();
		File f = new File("C:/Users/kingshuk.nandy/Downloads/abc/New folder");
        File[] filesFolders = f.listFiles();
		 
		 System.out.println("Files count: " + filesFolders.length);
		 for (int i = 0; i < filesFolders.length; i++) {
			//System.out.println("Names"+i+":"+filesFolders[i]);
			list2.add(filesFolders[i]);
		}
		 
		return list2;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		/*List li=Questions();
		Iterator ite1=li.iterator();
		while(ite1.hasNext()){
			String st1=(String) ite1.next();
			System.out.println("Files From Database="+st1);
		}
			
			
		List li2=getDirectoryFileCount();
		Iterator ite2=li2.iterator();
		while(ite2.hasNext()){
			String st2=ite2.next().toString();
			System.out.println("Files from Directory="+st2);
		}*/
		
		
		List li2=getDirectoryFileCount();
		Iterator ite2=li2.iterator();
		while(ite2.hasNext()){
			String st2=ite2.next().toString();
			//System.out.println("Files from Directory="+st2);
			List li=Questions();
			Iterator ite1=li.iterator();
			while(ite1.hasNext()){
				String st1=(String) ite1.next();
				if(st2.equalsIgnoreCase(st1))
					System.out.println("The "+st2+" file exist in Database");

			}
		}
		

		

	}
}
