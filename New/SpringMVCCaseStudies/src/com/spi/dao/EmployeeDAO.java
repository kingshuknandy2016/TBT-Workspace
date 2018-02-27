package com.spi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.spi.db.helper.DbHelper;
import com.spi.model.Employee;

public class EmployeeDAO {

	public boolean insertEmployee(Employee emp) {
		String qry="insert into employee_details(emp_id,name,emailId,cellno1,pincode) values(?,?,?,?,?)";
		DbHelper helper=new DbHelper();
		Connection con=helper.getConnection();
		boolean retVal=false;
		
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(qry);
			pst.setInt(1, emp.getEmpid());
			pst.setString(2,emp.getName());
			pst.setString(3, emp.getEmailid());
			pst.setInt(4, (int) emp.getCellno());
			pst.setInt(5, emp.getPincode());
			int ret=pst.executeUpdate();
			
			if(ret>0){
				retVal=true;
				
			}
				
			
		} catch (SQLException e) {
			return retVal;
		}
		
		
		
		
		return retVal;
	}


}
