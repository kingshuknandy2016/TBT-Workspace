package com.spi.client;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.spi.simple.HelloWorld;
import com.spi.simple.Student;

public class CliendCodeToAccessSpringBean {

	public static void main(String[] args) {

		// By Deafault singletone 
		
		// load only one file..
		//ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
				
				
	BeanFactory bean;
	
		
		// Can load more than one application config file		
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"Beans.xml","applicationContext.xml"});
     	System.out.println("See...");
		//Student obj4 = (Student) context.getBean("studentbean");
		try {
			//obj4.displayInfo();
			
		} catch (Exception e) {//It will throw an exception because it is not getting the address
			System.out.println(e);
		}
		
		//Student st=(Student)context.getBean("bn1");
		//st.displayInfo();
		
		
		//new ClassPathXmlApplicationContext(configLocations)
		
//		 ApplicationContext context1= new ClassPathXmlApplicationContext(
//				"Beans.xml");
//		
//		HelloWorld obj = (HelloWorld) context.getBean("bn1");
//
//		obj.getMessage();

		//HelloWorld obj1 = (HelloWorld) context.getBean("bn1");

		//obj1.getMessage();

		//Resource resource = new ClassPathResource("Beans.xml");
		//BeanFactory factory = new XmlBeanFactory(resource);
//		HelloWorld obj3 = (HelloWorld) factory.getBean("bn1");
//		obj3.getMessage();

	/*		Resource resource1 = new ClassPathResource("applicationContext.xml");
		BeanFactory factory1 = new XmlBeanFactory(resource1);
		Student obj4 = (Student) factory1.getBean("studentbean");
		obj4.displayInfo();*/


		
		/*Student obj5 = (Student) factory1.getBean("studentbean");
		obj5.displayInfo();

		*/
		
		
		
		/*
		 * 
		 * // It reads XML File. Resource resource = new
		 * ClassPathResource("applicationContext.xml"); BeanFactory factory =
		 * new XmlBeanFactory(resource);
		 * 
		 * 
		 * 
		 * 
		 * // ClassPathResource // ClassPathXmlApplicationContext
		 * 
		 * Student student = (Student) factory.getBean("studentbean");
		 * System.out.println(factory.containsBean("studentbean45"));
		 * 
		 * 
		 *   String s[]=factory.getAliases("studentbean");
		 * 
		 * System.out.println(Arrays.toString(s));
		 * 
		 * Object beanE=factory.getBean("studentbeanertert");
		 * 
		 * Student st=(Student) factory.getBean("studentbean",Student.class);
		 * 
		 * System.out.println(beanE);
		 * System.out.println("Is Singleton\t"+factory
		 * .isSingleton("studentbean"));
		 * 
		 * student.displayInfo(); student.setName("Hello");
		 * 
		 * student.displayInfo();
		 * 
		 * List list=new ArrayList();
		 * 
		 * 
		 * BeanFactory bean1=new XmlBeanFactory(null);
		 * 
		 * BeanFactory bean2= new XmlBeanFactory(null);
		 * 
		 * 
		 * BeanFactory bearf;
		 * 
		 * ApplicationContext app;
		 */

	}
}
