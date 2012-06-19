package org.agoncal.book.javaee6.chapter03.ex44;

import org.agoncal.book.javaee6.chapter03.AbstractPersistentTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 *         Test class that creates a Customer18
 */
public class Order44Test extends AbstractPersistentTest {

    // ======================================
    // =              Unit tests            =
    // ======================================
    @Test
    public void shouldCreateAnOrderWithTwoOrderLines() throws Exception {

        Order44 order = new Order44();
        OrderLine44 ol1 = new OrderLine44("H2G2", 12d, 1);
        OrderLine44 ol2 = new OrderLine44("The White Album", 14.5d, 2);
        List<OrderLine44> orderLines = new ArrayList<OrderLine44>();
        orderLines.add(ol1);
        orderLines.add(ol2);
        order.setOrderLines(orderLines);
        tx.begin();
        em.persist(order);
        em.persist(ol1);
        em.persist(ol2);
        tx.commit();
        assertNotNull("Order ID should not be null", order.getId());
        assertNotNull("OL1 ID should not be null", ol1.getId());
        assertNotNull("OL1 ID should not be null", ol2.getId());

        order = em.find(Order44.class, order.getId());
        assertNotNull("OrderLines should not be null", order.getOrderLines());
        assertEquals("Should have 2 order lines", order.getOrderLines().size(), 2);
    }
}