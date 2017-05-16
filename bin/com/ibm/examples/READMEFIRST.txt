IBM Developerworks Article
"Developing a Standalone Java Application for WebSphere MQ v6.0"
https://www.ibm.com/developerworks/websphere/techjournal/0610_woolf/0610_woolf.html

Installation
------------
Unpack the distribution files to c:\ so that they end up in C:\JMSDEMO.
Open a command window and cd \JMSDEMO.
MQ Explorer installed is v9

The sample application assumes that there is a local queue manager named JMSDEMO set up as the default queue manager.  See the article for details on how to define the queue manager.  The only environment variables referenced are created in the installation of WebSphere MQ.  These include:

%MQ_JAVA_INSTALL_PATH%
%MQ_JAVA_DATA_PATH%
%CLASSPATH%


Configuration
-------------
To set up JNDI for bindings mode transport:
JMSAdmin.bat < jmsdemoJNDIbindings.scp

For client mode transport:
JMSAdmin.bat < jmsdemoJNDIclient.scp

The article assumes bindings mode transport.  Client mode will work with the default settings of the queue manager on Windows and is provided for educational value.  In general, use bindings mode transport whenever possible.  See the article for more discussion on this point.


Running the demo
----------------
Open up two command windows in C:\JMSDEMO (three if using Pub/Sub).

For point-to-point, run the following commands in their own window:
JMSDemoSend.bat
JMSDemoReceive.bat

For Pub/Sub, run the following commands in their own window:
JMSDemoPub.bat
JMSDemoSub.bat
JMSDemoSub.bat

Type messages into the Send/Pub window.  
You should see them appear in the Receive/Sub window(s).
In Receive/Subscribe mode, the program waits 10 seconds for messages and then quits.
