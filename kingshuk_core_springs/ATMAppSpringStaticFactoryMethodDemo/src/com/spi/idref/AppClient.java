package com.spi.idref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spi.date.Implementor;

public class AppClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("BEGINNING PROGRAM **************");

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"app-context.xml");
		Student st = (Student) context.getBean("student");
		String cityName = st.getCity().getCityName();
		System.out.println("cityNmae:" + cityName);
		System.out.println("Student Name\t"+st.getName());

	}

}
