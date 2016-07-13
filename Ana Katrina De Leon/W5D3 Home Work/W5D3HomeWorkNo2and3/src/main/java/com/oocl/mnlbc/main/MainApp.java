/*package com.oocl.mnlbc.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oocl.mnlbc.model.User;
import com.oocl.mnlbc.template.UserJDBCTemplate;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/tutorialspoint/beans/Beans.xml");

		UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate) context.getBean("userJDBCTemplate");

		System.out.println("------Records Creation--------");
		userJDBCTemplate.create("Zara", 11);
		userJDBCTemplate.create("Nuha", 2);
		userJDBCTemplate.create("Ayan", 15);

		System.out.println("------Listing Multiple Records--------");
		List<User> user = userJDBCTemplate.listUsers();
		for (User record : user) {
			System.out.print(", Name : " + record.getFname());
			System.out.println(", Last : " + record.getLname());
			System.out.println(", User Name : " + record.getUserName());
			System.out.println(", Password : " + record.getPassword());
			System.out.println(", Email : " + record.getLname());
		}

	}

}
*/