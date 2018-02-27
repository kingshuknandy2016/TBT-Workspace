package com.spi.jdbc.template;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.common.TemplateAwareExpressionParser;
import org.springframework.jdbc.core.JdbcTemplate;



public class EmployeeExec {
	
	
	public static void main(String[] args) {
	
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc.xml");
		EmployeeDAO empDao = (EmployeeDAO)ctx.getBean("employeeDao");
		Employee employee = new Employee();
		employee.setEmployeeName("Sidd");
		employee.setEmployeeDept("LND");
		employee.setEmailId("sidd@gmail.com");
		
		empDao.saveEmployee(employee);
		
		//getting the data 
		Employee emp1 = empDao.getEmploye(1);
		
		System.out.println(emp1);
		
		Employee emp=empDao.findByName("Sidd");
		
		
		System.out.println("Employee name :"+emp.getEmployeeName());
		System.out.println("Employee email :"+emp.getEmailId());
		System.out.println("Employee department:"+emp.getEmployeeDept());
		
		
		
		JdbcTemplate c=new JdbcTemplate();
		
	}

}
