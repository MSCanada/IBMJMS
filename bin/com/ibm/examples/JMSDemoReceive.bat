@echo off

set CLASSPATH=.
set CLASSPATH=%CLASSPATH%;%MQ_JAVA_INSTALL_PATH%/lib/jms.jar
set CLASSPATH=%CLASSPATH%;%MQ_JAVA_INSTALL_PATH%/lib/com.ibm.mq.jar
set CLASSPATH=%CLASSPATH%;%MQ_JAVA_INSTALL_PATH%/lib/com.ibm.mqjms.jar
set CLASSPATH=%CLASSPATH%;%MQ_JAVA_INSTALL_PATH%/lib/connector.jar

echo java -cp "%CLASSPATH%" com.ibm.examples.JMSDemo
java -cp "%CLASSPATH%" com.ibm.examples.JMSDemo -receive  

