/**
 * 
 */
package com.oocl.mnlbc.consumer;

import javax.jms.JMSException;

import com.oocl.mnlbc.listener.ClientListener;

/**
 * @author DEQUILLA
 *
 */
public class ClientConsumer extends Consumer {

	private ClientListener clientListener = new ClientListener();

	/**
	 * 
	 */
	public ClientConsumer() {
		createTopic();
		try {
			messageConsumer.setMessageListener(clientListener);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the listener
	 */
	public ClientListener getListener() {
		return clientListener;
	}

	/**
	 * @param clientListener
	 *            the listener to set
	 */
	public void setListener(ClientListener clientListener) {
		this.clientListener = clientListener;
	}

}
