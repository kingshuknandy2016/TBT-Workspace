package com.spi.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class ClentCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// BeanFactory factory= new XmlBeanFactory(new
		// ClassPathResource("beans.xml"));
		// this refers to class path of your project 
		Resource res1=new ClassPathResource("beans");

		// This is refers from File system
		Resource res = new FileSystemResource("C:\\Beans\\beans.xml");

		BeanFactory factory = new XmlBeanFactory(res); // Implementaion class of BeanFactory.
		Singer sObject = (Singer) factory.getBean("factoryMadeSingerBean");
		sObject.setSong("title Track");

		System.out.println(sObject.getSong());
		// fct.createSinger("Hello");
		
		
		
		// ApplicationContext & BeanFactory are interface & ClassPathXmlApplicationContext & XmlBeanFactor implementation classes of interface respectively.
		// 
		// More than one xml file can load...
		//ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml", "applicationContext-part2.xml"});
		
				
		// ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext-part2.xml");
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext-part2.xml");
		
		
		
		
		

	}

}
