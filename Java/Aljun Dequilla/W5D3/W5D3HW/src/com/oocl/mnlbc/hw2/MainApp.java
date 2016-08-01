package com.oocl.mnlbc.hw2;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/oocl/mnlbc/hw2/Beans.xml");

		UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate) context.getBean("userJDBCTemplate");

		System.out.println("------Records Creation--------");

		try {
			userJDBCTemplate.create("dequial", "Aljun", "Dequilla", "password");
			userJDBCTemplate.create("kanench", "Christian", "Kanen", "wordpass");
			userJDBCTemplate.create("admin", "admin", "admin", "admin");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("------Listing Multiple Records--------");
		List<User> users = userJDBCTemplate.listUsers();
		for (User record : users) {
			System.out.print("Name : " + record.getFname() + " " + record.getLname());
			System.out.println("User name : " + record.getUname());
		}

		System.out.println("----Updating Record with uname = admin -----");
		userJDBCTemplate.update("admin", "ad", "min", "admin123");

		System.out.println("----Listing Record with uname = kanench -----");
		User user = userJDBCTemplate.getUser("kanench");
		System.out.print("Name : " + user.getFname() + " " + user.getLname());
		System.out.println("User name : " + user.getUname());

	}
}