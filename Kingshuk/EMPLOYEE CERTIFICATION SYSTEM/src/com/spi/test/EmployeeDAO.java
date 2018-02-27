package com.spi.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

	static String driver, url, user, password;

	static {
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/sep_java_case_study";
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
	static Employee eRec;

	/*------------insert emp------------------*/
	public static boolean insertEmployees(Employee e) throws EmployeeException {
		boolean ret = false;
		Date d = new Date(5, 11, 2015);
		try {
			con = getConnection();
			// st=con.createStatement();
			// ret=st.executeUpdate(iqry);
			pst = con
					.prepareStatement("insert into employee_details values(?,?,?,?,?,?,?,?,?,?)");
			pst.setInt(1, e.getEmpId());
			pst.setString(2, e.getName());
			pst.setString(3, e.getAddress());
			pst.setInt(4, e.getSkillId());
			pst.setString(5, e.getEmailId());
			pst.setInt(6, e.getCityId());
			pst.setInt(7, e.getCellNo1());
			pst.setInt(8, e.getCellNo2());
			pst.setDate(9, e.getDateOfJoining());
			pst.setInt(10, e.getPinCode());

			int s = pst.executeUpdate();
			if (s > 0) {
				System.out.println("Success!!");
				return ret = true;
			} else {
				throw new EmployeeException("Error, data unable to insert ..");
			}

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			throw new EmployeeException("Error, data unable to insert ..");
		}

		return ret;
	}

	/*---------------end insertemployee------------------*/

	/*-------------------findByEmployeeId start-------------------*/

	public static Employee findByEmployeeId(int eid) {
		String qry = "Select * from employee_details where emp_id=?";

		try {
			pst = getConnection().prepareStatement(qry);
			pst.setInt(1, eid);
			rs = pst.executeQuery();
			if (rs.next()) {
				eRec = new Employee();
				eRec.setEmpId(rs.getInt("emp_id"));
				eRec.setName(rs.getString("name"));
				eRec.setAddress(rs.getString("address"));
				eRec.setSkillId(rs.getInt("SkillID"));
				eRec.setEmailId(rs.getString("emailId"));
				eRec.setCityId(rs.getInt("cityid"));
				eRec.setCellNo1(rs.getInt("cellno1"));
				eRec.setCellNo2(rs.getInt("cellno2"));
				eRec.setDateOfJoining(rs.getDate("date_of_joining"));
				eRec.setPinCode(rs.getInt("pincode"));

				return eRec;
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	/*-------------------findByEmployeeId end---------------------*/

	/*-------------------findByCity Start---------------------*/

	public static List findByCity(String name) {
		int i;
		
		List list = new ArrayList();
		String qry1 = "Select id from city where name=?";
		try {
			pst = getConnection().prepareStatement(qry1);
			pst.setString(1, name);
			rs = pst.executeQuery();

			if (rs.next()) {
				i = rs.getInt("id");

				String qry2 = "Select * from employee_details where cityid=? ";
				pst = getConnection().prepareStatement(qry2);

				pst.setInt(1, i);
				
				rs = pst.executeQuery();

				if (rs.next()) {
					do {
					    
					    list.add(rs.getString("name"));
					    
					} while (rs.next());
				} 

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/*-------------------findByCity End---------------------*/

}
