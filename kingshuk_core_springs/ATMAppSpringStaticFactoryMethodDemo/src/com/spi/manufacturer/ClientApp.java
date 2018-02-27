package com.spi.manufacturer;

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

		// Bean factory is Lazy fetch wheere as ApplicationContext is eager fetch
		Resource resource = new ClassPathResource("appContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		Manufacturer manu=(Manufacturer)factory.getBean("manfuId");
		manu.show();
		
	}

}
