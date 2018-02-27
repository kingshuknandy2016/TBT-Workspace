package com.spi.checkbean.creation;

import java.util.Arrays;

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
		// TODO Auto-generated method stub\
		
		// This this line whether bean objects ready when loading xml file
		// None of the class objects ready.
		//Resource resource=new ClassPathResource("appplicationcontext.xml");
		//BeanFactory factory = new XmlBeanFactory(resource);
				
		
		ApplicationContext context = new ClassPathXmlApplicationContext("appplicationcontext.xml");
		
		
		// Id & name both can use... 
		A1 a1=(A1)context.getBean("id");
		System.out.println("Get Id \t"+context.getId());
		
		a1.show();
		
		
		String alias[]=context.getAliases("id");
		System.out.println(Arrays.toString(alias));
		
				
				

	}

}
