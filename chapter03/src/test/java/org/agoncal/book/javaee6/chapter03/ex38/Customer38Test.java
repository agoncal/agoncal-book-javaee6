package org.agoncal.book.javaee6.chapter03.ex38;

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
public class Customer38Test extends AbstractPersistentTest {

    // ======================================
    // =              Unit tests            =
    // ======================================
    @Test
    public void shouldCreateACustomerWithOneAddress() throws Exception {

        Customer38 customer = new Customer38("John", "Smith", "jsmith@gmail.com", "1234565");
        Address38 address = new Address38("65B Ritherdon Rd", "At James place", "London", "LDN", "7QE554", "UK");
        customer.setAddress(address);
        tx.begin();
        em.persist(customer);
        em.persist(address);
        tx.commit();
        assertNotNull("ID should not be null", customer.getId());

        customer = em.find(Customer38.class, customer.getId());
        assertNotNull("Address should not be null", customer.getAddress());
    }
}