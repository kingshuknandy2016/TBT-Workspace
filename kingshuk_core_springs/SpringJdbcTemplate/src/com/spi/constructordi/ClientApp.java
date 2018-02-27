package com.spi.constructordi;

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

		
		Resource resource=new ClassPathResource("applicationcontext.xml");
		BeanFactory factory=new XmlBeanFactory(resource);
		

		Employee e1=(Employee)factory.getBean("empBean1");
		System.out.println(e1);
		
		Employee e2=(Employee)factory.getBean("empBean2");
		System.out.println(e2);
		
		
		
		Employee e3=(Employee)factory.getBean("empBean3");
		System.out.println(e3);
		
		
		Employee e4=(Employee)factory.getBean("empBean4");
		System.out.println(e4);
		
		
		Employee e5=(Employee)factory.getBean("empBean5");
		System.out.println(e5);
		
		
		
		Employee e6=(Employee)factory.getBean("empBean6");
		System.out.println(e6);
		
	}

}
