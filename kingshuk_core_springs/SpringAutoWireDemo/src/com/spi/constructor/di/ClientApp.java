package com.spi.constructor.di;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientApp {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext(
				"applicationcontext.xml");
		
		
		//Employee-1
		Employee e1 = (Employee) app.getBean("emp1");
		System.out.println(e1);

		// Employee-2
		Employee e2 = (Employee) app.getBean("emp2");
		System.out.println(e2);

		// Employee-3
		Employee e3 = (Employee) app.getBean("emp3");
		System.out.println(e3);

		// Employee-3
		Employee e4 = (Employee) app.getBean("emp4");
		System.out.println(e4);
		
		
	}
}
