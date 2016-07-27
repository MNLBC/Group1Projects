/**
 * 
 */
package com.oocl.mnlbc.provider;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @author DEQUILLA
 *
 */
public class Provider {
	private static final String USER_NAME = ActiveMQConnectionFactory.DEFAULT_BROKER_URL;
	private static final String PASSOWRD = ActiveMQConnectionFactory.DEFAULT_PASSWORD;
	private static final String BROKEN_URL = ActiveMQConnectionFactory.DEFAULT_BROKER_URL;

	private static ConnectionFactory connectionFactory = null;
	private static Connection connection = null;
	private static Session session = null;
	private static Destination destination = null;
	private static MessageProducer messageProducer = null;

	public Provider() {
		createTopic();
	}

	private void createTopic() {
		try {
			connectionFactory = new ActiveMQConnectionFactory(USER_NAME, PASSOWRD, BROKEN_URL);
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			destination = session.createTopic("BurgerQueenTopic");

		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param message
	 */
	public void sendMessage(String message) {
		try {
			messageProducer = session.createProducer(destination);
			Message textMessage = session.createTextMessage(message);
			messageProducer.send(textMessage);
			session.commit();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
