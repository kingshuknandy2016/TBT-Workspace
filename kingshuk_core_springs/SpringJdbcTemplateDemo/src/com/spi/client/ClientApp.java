package com.spi.client;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spi.jdbc.template.JdbcTemplateDemo;

public class ClientApp {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub

		DriverManagerDataSource ds;

	//	since lazy fetch so all configured no need to  bean class must be there in classpath
		Resource res = new ClassPathResource("appConfing.xml");
		BeanFactory factory = new XmlBeanFactory(res);

		
		
		// since eager fetch so all configured bean clas must be there in classpath
	//	ApplicationContext factory=new ClassPathXmlApplicationContext("appConfing.xml");

		JdbcTemplateDemo st = (JdbcTemplateDemo) factory.getBean("id3");

		 //st.createTable(); // Create a table.

		//st.insertRecord();
		
/*		System.out.println("Batch Update demo....");
		st.batchUpdateDemo();
		
		
		System.out.println("successfully Inserted...");
		
		Object obj=factory.getBean("dd");*/
		
		
/*		System.out.println("Before Update");
		st.loadAll();*/

	//	int ret = st.updateRecord();
	//	System.out.println("After Update\t" + ret);
	//	st.loadAll();

		/*
		 * Class.forName("oracle.jdbc.driver.OracleDriver");
		 * 
		 * Connection
		 * con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE"
		 * ,"system","$picity123");
		 * 
		 * 
		 * Statement st1= con.createStatement();
		 * st1.executeUpdate("create table testOne1(id number)");
		 * System.out.println("Successs");
		 */

	}

}
