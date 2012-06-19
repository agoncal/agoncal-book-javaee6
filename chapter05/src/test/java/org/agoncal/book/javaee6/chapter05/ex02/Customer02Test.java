package org.agoncal.book.javaee6.chapter05.ex02;

import org.agoncal.book.javaee6.chapter05.AbstractPersistentTest;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Customer02Test extends AbstractPersistentTest {

    // ======================================
    // =              Unit tests            =
    // ======================================

    @Test
    public void shouldCheckTheAgeOfTheCustomer() throws Exception {

        // Instanciates an object
        Customer02 customer = new Customer02("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date());
        assertFalse(em.contains(customer));

        // Persists the object
        tx.begin();
        em.persist(customer);
        tx.commit();
        assertTrue("should be in the persistence context after persisting", em.contains(customer));
        assertEquals(new Integer(0), customer.getAge());

        // Finds the object
        customer = em.find(Customer02.class, customer.getId());
        assertTrue("should be in the persistence context after finding", em.contains(customer));
        assertEquals(new Integer(0), customer.getAge());

        // Removes the entity
        tx.begin();
        em.remove(customer);
        tx.commit();
        assertFalse("should not be in the persistence context after removing", em.contains(customer));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionBecauseFirstNameIsNull() throws Exception {

        // Instanciates an object
        Customer02 customer = new Customer02(null, "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date());

        // Persist the object
        tx.begin();
        em.persist(customer);
        tx.commit();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionBecauseLastNameIsNull() throws Exception {

        // Instanciates an object
        Customer02 customer = new Customer02("John", null, "jsmith@gmail.com", "1234565", new Date(), new Date());

        // Persist the object
        tx.begin();
        em.persist(customer);
        tx.commit();
    }
}