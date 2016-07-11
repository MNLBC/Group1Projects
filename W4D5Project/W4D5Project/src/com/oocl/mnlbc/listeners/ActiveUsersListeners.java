package com.oocl.mnlbc.listeners;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class ActiveUsersListiners
 *
 */

/**
 * 
 * @author Group 1
 *
 */
@WebListener
public class ActiveUsersListeners implements HttpSessionListener {

	/**
	 * Default constructor.
	 */
	public ActiveUsersListeners() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent paramHttpSessionEvent) {
		HttpSession session = paramHttpSessionEvent.getSession();
		ServletContext context = session.getServletContext();
		Integer counter = (Integer) context.getAttribute("counter");

		// Counting of Active Users
		if (counter == null)
			counter = new Integer(1);
		else
			counter = new Integer(counter + 1);

		context.setAttribute("counter", counter);

		// Session Timeout
		session.setMaxInactiveInterval(60);

		System.out.println("A new session is created.");
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent paramHttpSessionEvent) {
		HttpSession session = paramHttpSessionEvent.getSession();
		ServletContext context = session.getServletContext();
		Integer counter = (Integer) context.getAttribute("counter");

		// Updating the counter after user has logout
		if (counter == null)
			counter = new Integer(1);
		else
			counter = new Integer(counter + 1);

		context.setAttribute("counter", counter);

		session.setMaxInactiveInterval(1000);

		System.out.println("A new session is created.");
	}

}
