package com.spi.bean.inheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientCodeForBeanInheritance {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationcontext.xml");

		HelloWorld objA = (HelloWorld) context.getBean("helloWorld");

		objA.getMessage1();
		objA.getMessage2();

		HelloIndia objB = (HelloIndia) context.getBean("helloIndia");
		System.out.println("Check");
		objB.getMessage1();
		objB.getMessage2();
		objB.getMessage3();
	}
}
