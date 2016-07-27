/**
 * 
 */
package com.oocl.mnlbc.consumer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @author DEQUIAL
 *
 */
public class Consumer {
	static final String USER_NAME = ActiveMQConnectionFactory.DEFAULT_BROKER_URL;
	static final String PASSOWRD = ActiveMQConnectionFactory.DEFAULT_PASSWORD;
	static final String BROKEN_URL = ActiveMQConnectionFactory.DEFAULT_BROKER_URL;

	static ConnectionFactory connectionFactory = null;
	static Connection connection = null;
	static Session session = null;
	static Destination destination = null;
	static MessageConsumer messageConsumer = null;

	protected void createTopic() {
		try {
			connectionFactory = new ActiveMQConnectionFactory(USER_NAME, PASSOWRD, BROKEN_URL);
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			destination = session.createTopic("BurgerQueenTopic");
			messageConsumer = session.createConsumer(destination);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
