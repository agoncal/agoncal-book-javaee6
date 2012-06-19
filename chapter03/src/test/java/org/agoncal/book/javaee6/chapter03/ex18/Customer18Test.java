package org.agoncal.book.javaee6.chapter03.ex18;

import org.agoncal.book.javaee6.chapter03.AbstractPersistentTest;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertNotNull;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 *         Test class that creates a Customer18
 */
public class Customer18Test extends AbstractPersistentTest {

    // ======================================
    // =              Unit tests            =
    // ======================================
    @Test
    public void shoulCreateACustomer() throws Exception {

        Customer18 customer = new Customer18("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date());
        tx.begin();
        em.persist(customer);
        tx.commit();
        assertNotNull("ID should not be null", customer.getId());
    }
}