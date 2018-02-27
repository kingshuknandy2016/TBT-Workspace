package com.spi.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class ClientCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext app=new ClassPathXmlApplicationContext("bean.xml");
		Employee e=(Employee)app.getBean("eId");
		e.show();
		
		
	}

}
