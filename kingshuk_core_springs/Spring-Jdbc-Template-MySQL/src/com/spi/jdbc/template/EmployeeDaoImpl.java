package com.spi.jdbc.template;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


public class EmployeeDaoImpl  implements EmployeeDAO{
	private JdbcTemplate jdbcTemplate;
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	void testMethod(){
		new RowMapper() {
			public Object mapRow(ResultSet arg0, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}			
			
			
		};
	}
	

	public Employee getEmploye(int empId) {
		
			Employee e = (Employee)jdbcTemplate.queryForObject(this.employee_Select, 
				new Object[]{new Integer(empId)}, 
				new RowMapper(){

					public Object mapRow(ResultSet rs, int arg1)
							throws SQLException {
						System.out.println("Arg1\t"+arg1);
						Employee e = new Employee();
						e.setEmployeeName(rs.getString("EMP_NAME"));
						e.setEmployeeDept(rs.getString("EMP_DEPT"));
						e.setEmailId(rs.getString("EMP_EMAILID"));
						e.setEmpId(rs.getInt("EMP_ID"));
						return e;
					}
			
		} ); //  queryForObject method call ends.
			
			// RowMapper is an interface, Anonymously creates an objects.
		return e;
	}

	public void saveEmployee(Employee e) {
		this.jdbcTemplate.update(this.employee_insert, new Object[]{e.getEmployeeName(),e.getEmployeeDept(),e.getEmailId()});
				
	}			
	

	public void updateEmployee(Employee e) {
		this.jdbcTemplate.update(this.employee_update, new Object[]{e.getEmployeeName(), e.getEmployeeDept(), e.getEmailId(), new Integer(e.getEmpId())} );
		
	}
	
	private final String employee_Select = "SELECT * FROM EMPLOYEE WHERE EMP_ID= ?";
	private final String employee_insert = "INSERT INTO EMPLOYEE( EMP_NAME, EMP_DEPT, EMP_EMAILID) VALUES(?,?,?)";
	private final String employee_update = "UPDATE EMPLOYEE SET EMP_NAME=?, EMP_DEPT=?,EMP_EMAILID=? WHERE EMP_ID = ?" ;


	private final String employee_findbyname="select * from employee where emp_name=?";
	
	
	public Employee findByName(String empName) {
		// TODO Auto-generated method stub
	
		
		Employee e = (Employee)jdbcTemplate.queryForObject(this.employee_findbyname, 
				new Object[]{empName}, 
				new RowMapper(){

					public Object mapRow(ResultSet rs, int arg1)
							throws SQLException {
						System.out.println("Arg1\t"+arg1);
						Employee e = new Employee();
						e.setEmployeeName(rs.getString("EMP_NAME"));
						e.setEmployeeDept(rs.getString("EMP_DEPT"));
						e.setEmailId(rs.getString("EMP_EMAILID"));
						e.setEmpId(rs.getInt("EMP_ID"));
						return e;
					}
			
		} ); //  queryForObject method call ends.
		
		
		return e;
	}

}
