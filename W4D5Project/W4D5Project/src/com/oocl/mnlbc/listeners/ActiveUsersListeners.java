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
 * Listener Class. Used to count the current active users of the web application.
 * Counts the sessions that are made and are not yet destroyed.
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
		// session.setMaxInactiveInterval(60);

		System.out.println("A new session is created.");
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent paramHttpSessionEvent) {
		HttpSession session=paramHttpSessionEvent.getSession();
	    ServletContext context=session.getServletContext();
	    Integer counter=(Integer)context.getAttribute("counter"); 
	    if(counter==null)
	      return;
	    else
	      counter=new Integer(counter-1);

	    context.setAttribute("counter",counter);

	    System.out.println("A new session is to be destroyed.");
	  } 

}
