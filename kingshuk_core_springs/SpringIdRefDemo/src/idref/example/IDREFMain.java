package idref.example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IDREFMain {

	public static void main(String[] args) {
		BeanFactory beanfactory = new ClassPathXmlApplicationContext(
				"appconfig.xml");
		AnotherBean bean = (AnotherBean) beanfactory.getBean("another");
		bean.display();
	}
}
