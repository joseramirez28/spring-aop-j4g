package org.j4g.spring.aop;

import java.util.ArrayList;
import java.util.List;

import org.l4g.spring.xml.model.ClientInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAnnotationsApp {

	public static void main(String[] args) {

		ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "Spring-Clients.xml" });
		// add some beans
		List<String> beanNames = new ArrayList<>();
		beanNames.add("client1");
		beanNames.add("client2");
		beanNames.add("client3");

		// get beans from context
		List<ClientInfo> clients = getTestBeans(appContext, beanNames);
		System.out.println("Clients");

		// call some bean methods
		for (ClientInfo client : clients) {
			try {
				System.out.println("##############################################");
				client.printClientInfo();
				client.printName();
				client.isClientInExpiredStatus();
				System.out.println("##############################################");
			} catch (Exception e) {
				System.err.println("Error with client");
			}

		}

	}

	public static List<ClientInfo> getTestBeans(ApplicationContext appContext, List<String> beanNames) {
		List<ClientInfo> clients = new ArrayList<ClientInfo>();
		for (String name : beanNames) {
			clients.add((ClientInfo) appContext.getBean(name));
		}
		return clients;
	}
}
