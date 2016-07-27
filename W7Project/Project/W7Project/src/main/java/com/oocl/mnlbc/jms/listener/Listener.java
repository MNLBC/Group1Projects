/**
 * 
 */
package com.oocl.mnlbc.jms.listener;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @author DEQUIAL
 *
 */
public class Listener implements MessageListener {

	protected String adminMessage = new String();

	@Override
	public void onMessage(Message arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the adminMessage
	 */
	public String getAdminMessage() {
		return adminMessage;
	}

	/**
	 * @param adminMessage
	 *            the adminMessage to set
	 */
	public void setAdminMessage(String adminMessage) {
		this.adminMessage = adminMessage;
	}
}
