package com.spi.client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spi.beans.JavaCollection;
import com.spi.beans.SetNull;

public class MainApp {

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationcontext.xml");
		
		
		SetNull stObj=(SetNull)context.getBean("testId");
		
		System.out.println(stObj.getName().length());
		

		JavaCollection jc = (JavaCollection) context.getBean("javaCollection");

		List list = jc.getAddressList();

		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));

		Set<String> set = jc.getAddressSet();
		Iterator<String> it = set.iterator();

		while (it.hasNext()){
			System.out.println(it.next());
		}
		jc.getAddressMap();
		jc.getAddressProp();

		// Trail

		// Keys & value both must be an objects.........

		Properties props = new Properties();
		System.out.println(props.getProperty("hi", "Not Found"));
		props.setProperty("hi", "Welcome to SPI,Mysore");

		System.out.println(props.getProperty("hi", "Not Found"));

		props.load(new FileInputStream("file.txt"));
		System.out.println(props.getProperty("Welcome", "Not Found"));

	}
}
