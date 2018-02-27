package com.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;

public class StringTestDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1=new String("Hello");
		String s2=new String("Hello");
		System.out.println(s1==s2);
		
		System.out.println(s1.equals(s2));
		
		BeanFactory fact;
		ApplicationContext context;
		ListableBeanFactory list;
		
		 
		
	}

}

