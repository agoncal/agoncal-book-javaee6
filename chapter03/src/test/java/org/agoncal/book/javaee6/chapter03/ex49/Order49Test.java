package org.agoncal.book.javaee6.chapter03.ex49;

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
public class Order49Test extends AbstractPersistentTest {

    // ======================================
    // =              Unit tests            =
    // ======================================
    @Test
    public void shouldCreateAnOrderWithTwoOrderLines() throws Exception {

        Order49 order = new Order49();
        OrderLine49 ol1 = new OrderLine49("H2G2", 12d, 1);
        OrderLine49 ol2 = new OrderLine49("The White Album", 14.5d, 2);
        List<OrderLine49> orderLines = new ArrayList<OrderLine49>();
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

        order = em.find(Order49.class, order.getId());
        assertNotNull("OrderLines should not be null", order.getOrderLines());
        assertEquals("Should have 2 order lines", order.getOrderLines().size(), 2);
    }
}