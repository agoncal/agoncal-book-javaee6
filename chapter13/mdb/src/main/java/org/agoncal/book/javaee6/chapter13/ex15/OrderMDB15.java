package org.agoncal.book.javaee6.chapter13.ex15;

import org.agoncal.book.javaee6.chapter13.OrderDTO;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@MessageDriven(mappedName = "jms/javaee6/Queue", activationConfig = {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "orderAmount > 1000")
})
public class OrderMDB15 implements MessageListener {

    // ======================================
    // =           Public Methods           =
    // ======================================

    public void onMessage(Message message) {
        try {
            ObjectMessage msg = (ObjectMessage) message;
            OrderDTO order = (OrderDTO) msg.getObject();
            System.out.println("Order received: " + order.toString());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}