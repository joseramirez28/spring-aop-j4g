package org.j4g.spring.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {

		ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "Spring-Beans.xml" });

		Object cust = (Object) appContext.getBean("ServiceProxy");

	}
}
