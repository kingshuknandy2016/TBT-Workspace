package com.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
	      ApplicationContext context =  new ClassPathXmlApplicationContext("Beans.xml");
	     AbstractApplicationContext context1 = new ClassPathXmlApplicationContext("Beans.xml");

	    //  HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
	      
	      
	      

	      //obj.getMessage();
	     // obj.getMarks();
	      
	      
	    
	      context1.registerShutdownHook();
	      
	   }
}
