package com.ibm.examples;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.naming.Context;
import javax.naming.NamingException;

public class P2PUtils extends JmsUtils {

	private static final String QCF_NAME = "JMSDEMOCF";
	private static final String QUEUE_NAME = "JMSDEMOQueue";

	public Connection getConnection()
		throws NamingException, JMSException {
		Context context = getInitialContext();
		ConnectionFactory qcf =
			(ConnectionFactory) context.lookup(QCF_NAME);
		return qcf.createConnection();
	}

	public Destination getQueue() throws NamingException {
		Context context = getInitialContext();
		return (Destination) context.lookup(QUEUE_NAME);
	}
}
