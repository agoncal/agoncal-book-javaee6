package org.agoncal.book.javaee6.chapter03.ex26;

import org.agoncal.book.javaee6.chapter03.AbstractPersistentTest;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 *         Test class that creates a Customer18
 */
public class Customer26Test extends AbstractPersistentTest {

    // ======================================
    // =              Unit tests            =
    // ======================================
    @Test
    public void shouldCreateACustomer() throws Exception {

        Customer26 customer = new Customer26("John", "Smith", "jsmith@gmail.com", "1234565");
        tx.begin();
        em.persist(customer);
        tx.commit();
        assertNotNull("ID should not be null", customer.getId());
    }
}