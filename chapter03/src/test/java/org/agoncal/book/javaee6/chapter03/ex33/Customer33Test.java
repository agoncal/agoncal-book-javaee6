package org.agoncal.book.javaee6.chapter03.ex33;

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
public class Customer33Test extends AbstractPersistentTest {

    // ======================================
    // =              Unit tests            =
    // ======================================
    @Test
    public void shouldCreateACustomerWithAnEmbeddedAddress() throws Exception {

        Customer33 customer = new Customer33("John", "Smith", "jsmith@gmail.com", "1234565");
        Address33 address = new Address33("65B Ritherdon Rd", "At James place", "London", "LDN", "7QE554", "UK");
        customer.setAddress(address);
        tx.begin();
        em.persist(customer);
        tx.commit();
        assertNotNull("ID should not be null", customer.getId());
    }
}