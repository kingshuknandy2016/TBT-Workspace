package com.spi.autowire2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;



public class ClientApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Resource resource=new ClassPathResource("autowire2.xml");
		BeanFactory factory=new XmlBeanFactory(resource);
		
		Categories cata=(Categories)factory.getBean("id1");
		cata.setName("Puzzlesss:");
		cata.show();
		
		
		
		
	}

}
