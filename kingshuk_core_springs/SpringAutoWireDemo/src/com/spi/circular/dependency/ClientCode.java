package com.spi.circular.dependency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class ClientCode {

	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationcontext.xml");

/*		A a=(A)context.getBean("a");
		a.showA();
	
		B b=(B)context.getBean("bref");
		b.showBMethod();
*/		
	
		
		A1 a1=(A1)context.getBean("a1");
		a1.showA();
		
		
		// 
		//Employee e=context.getBean("empBean",Employee.class);
		
		
		
	    
		
		
		// Second way
		// ApplicationContext context1 = new ClassPathXmlApplicationContext("Beans.xml");

		
	
	}
}
