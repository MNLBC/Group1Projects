package com.oocl.mnlbc.listeners;

import javax.servlet.annotation.WebListener;
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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent paramHttpSessionEvent) {
		// TODO Auto-generated method stub
	}

}
