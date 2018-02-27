package com.spi.parentbean;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ClientApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Eager fetch..
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		Employee e = (Employee) factory.getBean("e2");
		e.show();

		
		XmlBeanFactory xbean;
	//	DefaultListableBeanFactory dd;
		
		// Lazy fetch

		// ApplicationContext context=new
		// ClassPathXmlApplicationContext("applicationContext.xml");

	}

}
