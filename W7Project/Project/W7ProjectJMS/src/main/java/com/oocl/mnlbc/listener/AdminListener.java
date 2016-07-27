/**
 * 
 */
package com.oocl.mnlbc.listener;

import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author DEQUILLA
 *
 */
public class AdminListener extends Listener implements MessageListener {

	private static List<String> messages = new ArrayList<String>();

	@Override
	public void onMessage(Message message) {
		if (message != null && message instanceof TextMessage) {
			try {
				TextMessage textMessage = (TextMessage) message;

				adminMessage = new String((String) textMessage.getText());
				messages.add(adminMessage);
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return the messages
	 */
	public List<String> getMessages() {
		return messages;
	}

	/**
	 * @param messages
	 *            the messages to set
	 */
	public void setMessages(List<String> messages) {
		AdminListener.messages = messages;
	}

}
