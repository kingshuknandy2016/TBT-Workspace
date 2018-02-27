package com.spi.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InitHelloWorld implements BeanPostProcessor {

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub

		if (bean instanceof HelloWorld) {

			HelloWorld hw = (HelloWorld) bean;

			System.out.println("get Data... at Post Process After  Bean...");
			hw.getMessage();
			
			hw.setMessage("final update..");
		}

		System.out.println("BeforeInitialization : " + beanName);
		return bean; // you can return any other object as well
	}

	public Object postProcessBeforeInitialization(Object bean, String arg1)
			throws BeansException {
		// TODO Auto-generated method stub

		if (bean instanceof HelloWorld) {

			HelloWorld hw = (HelloWorld) bean;

			System.out.println(" Post Process Before ..");
			hw.getMessage();
			
			hw.setMessage("After Update..");
		}

		System.out.println("Post Process Before-int");
		return bean;
	}

}
