package org.agoncal.book.javaee6.chapter13.ex11;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@MessageDriven(mappedName = "jms/javaee6/Topic", activationConfig = {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "orderAmount < 3000")
})
public class BillingMDB11 implements MessageListener {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Resource
    private MessageDrivenContext context;

    // ======================================
    // =           Public Methods           =
    // ======================================

    public void onMessage(Message message) {
        TextMessage msg = (TextMessage) message;
        try {
            System.out.println("Message received: " + msg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}