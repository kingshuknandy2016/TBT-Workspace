package com.spi.autowire;

import java.security.AllPermission;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientApp {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext(
				"applicationcontext.xml");
		Employee e = (Employee) app.getBean("emp");

	}
}
