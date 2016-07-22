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

	List<String> messageList;

	@Override
	public void onMessage(Message message) {
		try {
			if (message != null && message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				messageList.add(textMessage.getText());
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param messageList
	 *            the messageList to set
	 */
	public void setMessageList(List<String> messageList) {
		this.messageList = messageList;
	}

}
