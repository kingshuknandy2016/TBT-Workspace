package com.spi.basics;

import org.testng.Assert;

public class TestEmployeeDetails {

	 EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();
	 EmployeeDetails employee = new EmployeeDetails();
	   
	 public void testCalculateYearlySalary() {
		   
	      employee.setName("Rajeev");
	      employee.setAge(25);
	      employee.setMonthlySalary(8000);
	      
	      double salary = empBusinessLogic.calculateYearlySalary(employee);
	      Assert.assertEquals(96000, salary, 0.0, "8000");
	   }
}
