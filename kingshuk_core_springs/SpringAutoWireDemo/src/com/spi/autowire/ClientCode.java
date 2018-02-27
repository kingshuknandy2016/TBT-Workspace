package com.spi.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class ClientCode {

	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationcontext.xml");

	
		Employee emp=(Employee)context.getBean("empBean");
		emp.showEmpDetails();
		
		// 
		//Employee e=context.getBean("empBean",Employee.class);
		
		
		
	    
		
		
		// Second way
		// ApplicationContext context1 = new ClassPathXmlApplicationContext("Beans.xml");

		
	
	}
}
