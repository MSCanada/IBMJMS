package com.ibm.examples;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.NamingException;

public class StandaloneSender {

	private P2PUtils utils;
	private Connection connection;
	private Session session;
	private MessageProducer sender;

	public static void main(String[] args)
		throws NamingException, JMSException, IOException {
		StandaloneSender sender = new StandaloneSender();
		sender.connect();
		String message = "ignored";
		while (message.length() > 0) {
			byte[] input = new byte[40];
			System.out.print("Enter a message: ");
			System.in.read(input);
			message = (new String(input, 0, input.length)).trim();
			if (message.length() > 0)
				sender.sendMessage(message);
		}
		sender.disconnect();
	}

	private StandaloneSender() {
		utils = new P2PUtils();
	}

	private void connect() throws NamingException, JMSException {
		connection = utils.getConnection();
		session =
			connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		sender = session.createProducer(utils.getQueue());
		System.out.println("Sender started.");
	}

	private void sendMessage(String text) throws JMSException {
		Message message = session.createTextMessage(text);
		sender.send(message);
		System.out.println(
			"Sent message <"
				+ text
				+ "> with ID <"
				+ message.getJMSMessageID()
				+ ">");
	}

	private void disconnect() throws JMSException {
		sender.close();
		session.close();
		connection.close();
		System.out.println("Sender stopped.");
	}
}
