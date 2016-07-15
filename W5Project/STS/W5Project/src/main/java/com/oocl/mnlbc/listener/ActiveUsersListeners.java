package com.oocl.mnlbc.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class ActiveUsersListeners
 *
 */
public class ActiveUsersListeners implements HttpSessionListener {

	/**
	 * Default constructor.
	 */
	public ActiveUsersListeners() {
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		ServletContext context = session.getServletContext();
		List<String> visitor = (List<String>) context.getAttribute("visitor");
		if (visitor == null) {
			visitor = new ArrayList<String>();
		}
		visitor.add(session.getId());
		context.setAttribute("visitor", visitor);
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		ServletContext context = session.getServletContext();
		List<String> visitor = (List<String>) context.getAttribute("visitor");
		if (visitor != null) {
			visitor.remove(session.getId());
		}
		context.setAttribute("visitor", visitor);
	}

}
