/**
 * 
 */
package com.oocl.mnlbc.listener;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.oocl.mnlbc.model.MessageDetails;

/**
 * @author DEQUILLA
 *
 */
public class Listener implements MessageListener {

	List<MessageDetails> messageList;

	@Override
	public void onMessage(Message message) {
		try {
			if (message != null && message instanceof TextMessage) {

				TextMessage textMessage = (TextMessage) message;
				String comment = (String) textMessage.getText();
				String username = comment.split(":")[0].trim();
				String userMessage = comment.split(":")[1].trim();
				MessageDetails messageDetails = new MessageDetails();
				messageDetails.setUsername(username);
				messageDetails.setMessage(userMessage);

				messageList.add(messageDetails);
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param messageList
	 *            the messageList to set
	 */
	public void setMessageList(List<MessageDetails> messageList) {
		this.messageList = messageList;
	}
}
