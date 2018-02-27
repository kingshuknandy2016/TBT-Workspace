package com.spi.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationcontext.xml");

		System.out.println("Setter based DI");
		// Uses setter based DI
		Question qn1 = (Question) context.getBean("qid1");
		qn1.showAnswers();

		// Uses Constructor based DI
		System.out.println("Construcotr based DI");
		com.spi.beans.constructor.Question qn2 = (com.spi.beans.constructor.Question) context.getBean("qid2");
		qn2.showAnswers();

		
		// List<Anserwers>
		
		com.spi.questions.pack.Question qn3=(com.spi.questions.pack.Question)context.getBean("qid3");
		qn3.showDetails();
		
		
		
	}

}
