package com.ibm.examples;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.NamingException;

public class StandaloneReceiver implements MessageListener {

	private P2PUtils utils;
	private Connection connection;
	private Session session;
	private MessageConsumer receiver;

	public static void main(String[] args)
		throws NamingException, JMSException, IOException {
		StandaloneReceiver receiver = new StandaloneReceiver();
		receiver.connect();
		System.in.read();
		receiver.disconnect();
	}

	private StandaloneReceiver() {
		utils = new P2PUtils();
	}

	private void connect() throws NamingException, JMSException {
		connection = utils.getConnection();
		session =
			connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		receiver = session.createConsumer(utils.getQueue());
		receiver.setMessageListener(this);
		connection.start();
		System.out.println("Receiver started.");
	}

	public void onMessage(Message message) {
		try {
			TextMessage tMessage = (TextMessage) message;
			String text;
			text = tMessage.getText();
			System.out.println(
				"Received message <"
					+ text
					+ "> with ID <"
					+ message.getJMSMessageID()
					+ ">");
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	private void disconnect() throws JMSException {
		receiver.close();
		session.close();
		connection.stop();
		connection.close();
		System.out.println("Receiver stopped.");
	}
}
