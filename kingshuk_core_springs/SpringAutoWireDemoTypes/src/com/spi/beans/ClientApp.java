package com.spi.beans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.spi.autowire.byconstructor.Student;

public class ClientApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Resource resource=new ClassPathResource("appContext.xml");
		BeanFactory factory=new XmlBeanFactory(resource);
		
		Categories cata=(Categories)factory.getBean("cat");
		cata.setName("Puzzlesss:");
		cata.show();

		
		System.out.println("**********");
		
		Student st=(Student)factory.getBean("stId");
		
	}

}
