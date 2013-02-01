package org.agoncal.book.javaee6.chapter13.ex12;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@MessageDriven(mappedName = "jms/javaee6/Topic", activationConfig = {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "orderAmount BETWEEN 3 AND 7")
})
public class BillingMDB12 implements MessageListener {

    @Resource(lookup = "jms/javaee6/Queue")
    private Destination printingQueue;
    @Resource(lookup = "jms/javaee6/ConnectionFactory")
    private ConnectionFactory connectionFactory;
    private Connection connection;

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================

    @PostConstruct
    private void initConnection() {
        System.out.println("######## Post Construct ####### avec queue");
        try {
            connection = connectionFactory.createConnection();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    private void closeConnection() {
        System.out.println("######## Pre Destroy #######  avec queue");
        try {
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    // ======================================
    // =           Public Methods           =
    // ======================================

    public void onMessage(Message message) {
        TextMessage msg = (TextMessage) message;
        try {
            System.out.println("Message received: " + msg.getText());
            sendPrintingMessage();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    private void sendPrintingMessage() throws JMSException {
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(printingQueue);
        TextMessage message = session.createTextMessage();
        message.setText("This message has been received and sent again");
        producer.send(message);
        session.close();
    }
}