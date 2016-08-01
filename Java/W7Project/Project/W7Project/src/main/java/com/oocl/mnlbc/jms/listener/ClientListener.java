/**
 * 
 */
package com.oocl.mnlbc.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * @author DEQUILLA
 *
 */
public class ClientListener extends Listener {
	@Override
	public void onMessage(Message message) {
		if (message != null && message instanceof TextMessage) {
			try {
				TextMessage textMessage = (TextMessage) message;

				adminMessage = new String((String) textMessage.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
