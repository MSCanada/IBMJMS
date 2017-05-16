package com.ibm.examples;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.naming.Context;
import javax.naming.NamingException;

public class PubSubUtils extends JmsUtils {

	private static final String TCF_NAME = "JMSDEMOCF";
	private static final String TOPIC_NAME = "JMSDEMOTopic";

	public Connection getConnection()
		throws NamingException, JMSException {
		Context context = getInitialContext();
		ConnectionFactory qcf =
			(ConnectionFactory) context.lookup(TCF_NAME);
		return qcf.createConnection();
	}

	public Destination getTopic() throws NamingException {
		Context context = getInitialContext();
		return (Destination) context.lookup(TOPIC_NAME);
	}
}
