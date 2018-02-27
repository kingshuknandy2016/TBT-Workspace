package com.spi.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spi.beanpostprocessor.HelloWorld;

public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationcontext.xml");

		
		// Second way
		// ApplicationContext context1 = new ClassPathXmlApplicationContext("Beans.xml");

		
		HelloWorld obj = (HelloWorld) context.getBean("bn1");
		obj.getMessage();
		System.out.println("Before Remove");
		context.registerShutdownHook(); // This is going to remove bean instance from Spring Pool
		
		System.out.println("After Remove....");
		obj.getMessage();

		
		
	}

}
