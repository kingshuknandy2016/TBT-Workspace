package com.spi.autowire1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class ClientCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// autowire="byName",autowire="byTypes" uses setters method..
	//	ApplicationContext factory = new ClassPathXmlApplicationContext("autowire.xml");
		BeanFactory factory=new XmlBeanFactory(new ClassPathResource("autowire.xml"));
		SPIIDE spiid=(SPIIDE)factory.getBean("spId");
		spiid.show();
	}

}
