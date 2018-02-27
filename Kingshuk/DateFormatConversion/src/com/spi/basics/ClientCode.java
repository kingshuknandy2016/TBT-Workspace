package com.spi.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ClientCode {

	static String driver, url, user, password;

	static {
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/employeedb";
		user = "root";
		password = "root";
	}

	private static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
	}

	static Connection con;
	static Statement st;

	static java.sql.PreparedStatement pst;
	static ResultSet rs;

	public static void main(String[] args) {

		System.out.println("Enter the Date():");
		Scanner sc = new Scanner(System.in);

		// String input = sc.next(); // "2015-11-09";

		try {

			// System.out.println(new Date().getDate()+","+(new
			// Date().getYear()+1900)+","+(new Date().getMonth()+1));
			//String strDate = "2015-12-12 ";
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd ");
//			java.util.Date date = new Date("2014/12/4");
//			java.sql.Date date1 = new java.sql.Date(date.getTime());
//
//			// sqlDate.
//			System.err.println(date1);

			System.out.println("Current date " + new Date().getDate());
			System.out.println("Current Month " + (new Date().getMonth() + 1));
			System.out.println("Current Year " + (new Date().getYear() + 1900));
            int cday= new Date().getDate();
            int cmonth= new Date().getMonth()+ 1;
            int cyear= new Date().getYear()+ 1900;
            
            
            
            
            
            
			// Calendar cal = Calendar.getInstance();
			// cal.setTime(t);
			// int month = cal.get(Calendar.MONTH) + 1;
			// int day = cal.get(Calendar.DAY_OF_MONTH);
			// int year = cal.get(Calendar.YEAR);

			// ------------------------------inserting part -----------------//
			// String qry="insert into practice values(?,?)";
			// pst=getConnection().prepareStatement(qry);
			// pst.setString(1, "King");
			// pst.setDate(2, date1);
			//
			//
			// System.out.println("success");
			//
			// int s = pst.executeUpdate();

			// ------------------------inserting part ----------------------//

			// --------------------Fecthing part----------------//
			con = getConnection();
			String query = "select joiningdate from practice where name='"
					+ "King" + "'";
			st = con.createStatement();
			rs = st.executeQuery(query);

			if (rs.next()) {
				System.out.println("Database date "
						+ rs.getDate("joiningdate").getDate());

				System.out.println("Database month "
						+( rs.getDate("joiningdate").getMonth()+1));
				System.out.println("Database month "
						+( rs.getDate("joiningdate").getYear()+1900));
			}
			
			int sqlday=rs.getDate("joiningdate").getDate();
			int sqlmonth=rs.getDate("joiningdate").getMonth()+1;
			int sqlyear= rs.getDate("joiningdate").getYear()+1900;
		    
			int days;
			int months;
			int years;
			if(cday>sqlday){
				days=cday-sqlday;
				System.out.println("Duration day:"+days);
			}else{
			    days=(cday+31)-sqlday;
			    sqlmonth=sqlmonth+1;
			    System.out.println("Duration day:"+days);
			}
			
			if(cmonth>sqlmonth){
				months=cmonth-sqlmonth;
				System.out.println("Duration Months:"+months);
			}else{
				months=(cmonth+12)-sqlmonth;
				sqlyear=sqlyear+1;
				System.out.println("Duration Months:"+months);
				
			}
			
			years=cyear-sqlyear;
			System.out.println("Duration Years:"+years);
			// -------------------------Fecthing part-------------------------//
			System.out.println("-------------------------------------------");
			
			
			
			
			
			
			System.out.println("-------------------------------------------");

		} catch (Exception e1) {
			System.out.println(e1);
		}

	}

}
