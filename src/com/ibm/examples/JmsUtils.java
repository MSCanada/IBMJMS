package com.ibm.examples;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JmsUtils {
	private static final String CF_CLASS_NAME =
		"com.sun.jndi.fscontext.RefFSContextFactory";
	private static final String WMQ_FILENAME = "file:C:\\JMSDEMO\\JNDI";  //filename should be same as in JMSAdmin.config

	protected Context getInitialContext() throws NamingException {
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, CF_CLASS_NAME);
		props.put(Context.PROVIDER_URL, WMQ_FILENAME);
		return new InitialContext(props);
	}
}
