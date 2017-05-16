package com.ibm.examples;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.NamingException;

public class StandalonePublisher {

	private PubSubUtils utils;
	private Connection connection;
	private Session session;
	private MessageProducer publisher;

	public static void main(String[] args)
		throws NamingException, JMSException, IOException {
		StandalonePublisher publisher = new StandalonePublisher();
		publisher.connect();
		String message = "ignored";
		while (message.length() > 0) {
			byte[] input = new byte[40];
			System.out.print("Enter a message: ");
			System.in.read(input);
			message = (new String(input, 0, input.length)).trim();
			if (message.length() > 0)
				publisher.sendMessage(message);
		}
		publisher.disconnect();
	}

	private StandalonePublisher() {
		utils = new PubSubUtils();
	}

	private void connect() throws NamingException, JMSException {
		connection = utils.getConnection();
		session =
			connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		publisher = session.createProducer(utils.getTopic());
		System.out.println("Publisher started.");
	}

	private void sendMessage(String text) throws JMSException {
		Message message = session.createTextMessage(text);
		publisher.send(message);
		System.out.println(
			"Published message <"
				+ text
				+ "> with ID <"
				+ message.getJMSMessageID()
				+ ">");
	}

	private void disconnect() throws JMSException {
		publisher.close();
		session.close();
		connection.close();
		System.out.println("Publisher stopped.");
	}
}
