/**
 * 
 */
package com.oocl.mnlbc.consumer;

import javax.jms.JMSException;

import com.oocl.mnlbc.listener.AdminListener;

/**
 * @author DEQUILLA
 *
 */
public class AdminConsumer extends Consumer {

	private AdminListener adminListener = new AdminListener();

	/**
	 * 
	 */
	public AdminConsumer() {
		createTopic();
		try {
			messageConsumer.setMessageListener(adminListener);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the listener
	 */
	public AdminListener getListener() {
		return adminListener;
	}

	/**
	 * @param AdminListener
	 *            the listener to set
	 */
	public void setListener(AdminListener AdminListener) {
		this.adminListener = AdminListener;
	}

}
