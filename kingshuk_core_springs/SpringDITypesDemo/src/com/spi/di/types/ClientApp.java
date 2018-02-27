package com.spi.di.types;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spi.di.constructor.ConstructorInjection;

public class ClientApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Bean
		ApplicationContext context=new ClassPathXmlApplicationContext("appContext.xml");
		//TextEditor editor=(TextEditor)  context.getBean("txtId");
		//System.out.println(editor);
				
		
		ConstructorInjection constr=(ConstructorInjection)context.getBean("constId");
		
		System.out.println(constr);
		
	}

}
