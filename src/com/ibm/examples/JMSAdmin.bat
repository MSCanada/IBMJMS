@echo off

rem ----------------------------------------------
rem  IBM Websphere MQ JMS Admin Tool Execution Script
rem  for Windows NT
rem
rem  Licensed Materials - Property of IBM
rem
rem  5724-H72 5655-L82 5724-L26
rem
rem  (c) Copyright IBM Corp. 2002, 2005.  All Rights Reserved.
rem
rem  US Government Users Restricted Rights - Use, duplication or
rem  disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
rem
rem  Note that the properties passed to the java program are defaults,
rem  and should be edited  to suit your installation if necessary
rem ----------------------------------------------

cls
java -DMQJMS_LOG_DIR="%MQ_JAVA_DATA_PATH%"\log -DMQJMS_TRACE_DIR="%MQ_JAVA_DATA_PATH%"\errors -DMQJMS_INSTALL_PATH="%MQ_JAVA_INSTALL_PATH%" com.ibm.mq.jms.admin.JMSAdmin %1 %2 %3 %4 %5

