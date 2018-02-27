package com.spi.date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spi.atm.ATM;

public class MainApp {

	public static void main(String[] args) {

		System.out.println("BEGINNING PROGRAM **************");

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"appContext.xml");
		
		Implementor impl = (Implementor)context.getBean("obj");
			
		System.out.println(impl);

		System.out.println("************** ENDING PROGRAM **************");
		
		
		
	}
}
