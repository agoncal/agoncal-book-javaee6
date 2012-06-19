package org.agoncal.book.javaee6.chapter03.ex43bis;

import org.agoncal.book.javaee6.chapter03.AbstractPersistentTest;
import org.junit.Test;

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
public class Customer43BisTest extends AbstractPersistentTest {

    // ======================================
    // =              Unit tests            =
    // ======================================
    @Test
    public void shouldCreateACustomerWithOneAddress() throws Exception {

        Customer43Bis customer = new Customer43Bis("John", "Smith", "jsmith@gmail.com", "1234565");
        Address43Bis address = new Address43Bis("65B Ritherdon Rd", "At James place", "London", "LDN", "7QE554", "UK");
        customer.setAddress(address);
        address.setCustomer(customer);
        tx.begin();
        em.persist(customer);
        em.persist(address);
        tx.commit();
        assertNotNull("ID should not be null", customer.getId());

        customer = em.find(Customer43Bis.class, customer.getId());
        assertNotNull("Address should not be null", customer.getAddress());
        assertEquals("Customers should be identical", customer, customer.getAddress().getCustomer());
    }
}