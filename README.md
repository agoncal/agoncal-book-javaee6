# Beginning Java EE 6 Platform with GlassFish 3: From Novice to Professional

* [Antonio Goncalves](http://www.antoniogoncalves.org) 
* [Apress Java EE 6 Book](http://apress.com/book/view/9781430219545)
* [Download code](http://kenai.com/projects/beginningee6/sources/src/show/chapters/trunk)
 
## Structure of the book

The code used in the book is defined in the following sub-directories :
* Chapter02 : Introduction to JPA 2.0
* Chapter03 : JPA Mapping
* Chapter04 : JPA Entity Manager and JPQL
* Chapter05 : JPA Lifecycle and Listeners
* Chapter06 : Introduction to EJB 3.1
* Chapter07 : Session beans
* Chapter08 : EJB Lifecycle and Interceptors
* Chapter09 : Transactions and security
* Chapter10 : Introduction to JSF 2.0
* Chapter11 : JSF Pages and components
* Chapter12 : Processing & JSF Navigation
* Chapter13 : JMS Sender
* Chapter13-MDB : JMS Message Driven Bean
* Chapter14-Consumer : SOAP Web service consumer
* Chapter14-Service : SOAP Web service
* Chapter15-Resource : RESTful Web service

## Compile / Package
To compile, package and execute the code you need the following software :
* Java SE 6 : http://java.sun.com/javase/downloads
* Derby 1.5 : http://db.apache.org/derby
* Maven 2 : http://maven.apache.org
* GlassFish v3 : http://glassfish.org


--
The test clases of this chapter, by default, use the Embedded mode of Derby (JavaDB). That means that the persistence.xml file defines a persistent unit with the folowing JDBC Driver

    <property name="javax.persistence.jdbc.driver" value="org.apache.derby.jdbc.EmbeddedDriver"/>
    <property name="javax.persistence.jdbc.url" value="jdbc:derby:chapter05DB;create=true"/>

Embedded mode is good for testing, but it means that no database is really created, so you can't browse its structure with a tool. If you can to be able to browse the database structure, you need to change the embedded mode to a client/server implementation that uses the Derby Network Server. For that, you'll have to do the following steps :

1. Install Derby. You must download the distribution and extract the package (http://db.apache.org) into DERBY_HOME directory. Add %DERBY_HOME%\bin to your PATH and run the sysinfo command line to display information about your Java environment and your version of Derby.
2. Start Derby server with the following command : java -jar %DERBY_HOME%\lib\derbyrun.jar server start (or startNetworkServer.bat)
3. Change the JDBC driver and url in your persistence.xml file :

    <property name="javax.persistence.jdbc.driver" value="org.apache.derby.jdbc.ClientDriver"/>
    <property name="javax.persistence.jdbc.url" value="jdbc:derby://localhost:1527/chapter05DB;create=true"/>

4. Run the test with Maven : mvn clean test
5. Once finished, shutdown the database with : java -jar %DERBY_HOME%\lib\derbyrun.jar server shutdown (or stopNetworkServer.bat)
