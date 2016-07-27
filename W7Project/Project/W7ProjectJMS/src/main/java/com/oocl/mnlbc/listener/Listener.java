/**
 * 
 */
package com.oocl.mnlbc.listener;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author DEQUILLA
 *
 */
public class Listener implements MessageListener {

	static List<String> messages;
	static String adminMessage;

	@Override
	public void onMessage(Message message) {
		if (message != null && message instanceof TextMessage) {
			try {
				TextMessage textMessage = (TextMessage) message;

				adminMessage = new String((String) textMessage.getText());
				// message.acknowledge();
				messages.add(adminMessage);
				// System.out.println(messages);
				System.out.println(adminMessage);
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

	public void setMessages(List<String> messages) {
		Listener.messages = messages;
	}

	/**
	 * @param adminMessage
	 *            the adminMessage to set
	 */
	public void setAdminMessage(String adminMessage) {
		Listener.adminMessage = adminMessage;
	}

	/**
	 * @return the messages
	 */
	public static List<String> getMessages() {
		return messages;
	}

	/**
	 * @return the adminMessage
	 */
	public String getAdminMessage() {
		return adminMessage;
	}

}
