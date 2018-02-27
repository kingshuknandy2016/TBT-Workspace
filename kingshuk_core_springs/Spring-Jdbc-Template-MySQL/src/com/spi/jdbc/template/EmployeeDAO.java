package com.spi.jdbc.template;
public interface EmployeeDAO {
	public void saveEmployee(Employee e);
	public void updateEmployee(Employee e);
	public Employee getEmploye(int empId);
	public Employee findByName(String empName);
	
}
