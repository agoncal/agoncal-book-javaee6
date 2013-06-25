# Beginning Java EE 6 Platform with GlassFish 3: From Novice to Professional

* [Antonio Goncalves](http://www.antoniogoncalves.org) 
* [Java EE 6 Book](http://www.amazon.com/gp/product/143022889X/ref=as_li_qf_sp_asin_il_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=143022889X&linkCode=as2&tag=antgonblo-20)
* [Download code on GitHub](https://github.com/agoncal/agoncal-book-javaee6/archive/master.zip)
 
# Structure of the book

Section 1 - Introduction

* Chapter  1 (42) - Java EE 7 at a Glance

Section 2 - Building a domain model

* Chapter  2 (18) - Java Persistence
* Chapter  3 (62) - Object-Relational Mapping
* Chapter  4 (44) - Managing Persistent Object
* Chapter  5 (12) - Callbacks & Listeners

Section 3 - Implementing business logic

* Chapter  6 (22) - Enterprise Java Beans (11/9)
* Chapter  7 (36) - Session Beans & Timer Service (29/5)
* Chapter  8 (16) - Callback & Interceptors (6/9)
* Chapter  9 (24) - Transactions & security (15/7)

Section 4 - Adding a web & user interface

* Chapter 10 (20) - JavaServer Faces
* Chapter 11 (48) - Pages & components (25/23)
* Chapter 12 (32) - Processing & Navigation

Section 5 - Interoperability

* Chapter 13 (38) - Messaging
* Chapter 14 (36) - SOAP Web Services
* Chapter 15 (34) - RESTful Web Service

# Structure of the code and Maven modules

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

# Compile / Package

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


# Licensing

<a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/"><img alt="Creative Commons License" style="border-width:0" src="http://i.creativecommons.org/l/by-sa/3.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/">Creative Commons Attribution-ShareAlike 3.0 Unported License</a>.

Book - Beginning Java EE 6 with Glassfish
Antonio Goncalves
--
--
