package com.spi.beans;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class ClientCode {

	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationcontext.xml");
		

		
		
		
		
		// Second way
		// ApplicationContext context1 = new ClassPathXmlApplicationContext("Beans.xml");

		
		TextEditor obj = (TextEditor) context.getBean("txtEditor");
		obj.spellCheck();
		System.out.println("Complete.......");
		
//		
//		Test test=(Test)context.getBean("t1");
//		
//		System.out.println(test.getPan());
	}
}
