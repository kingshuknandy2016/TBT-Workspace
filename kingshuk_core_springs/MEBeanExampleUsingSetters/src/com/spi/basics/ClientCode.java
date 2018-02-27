package com.spi.basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext  ACont=new  ClassPathXmlApplicationContext("Beans.xml");
		//AbstractApplicationContext  ACont1=new  ClassPathXmlApplicationContext("Beans.xml");
		
		///ACont1.registerShutdownHook();
		
		TextEditor te = (TextEditor) ACont.getBean("txtedit");

	      te.spellCheck();

	}

}
