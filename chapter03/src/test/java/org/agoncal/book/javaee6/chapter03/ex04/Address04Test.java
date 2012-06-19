package org.agoncal.book.javaee6.chapter03.ex04;

import org.agoncal.book.javaee6.chapter03.AbstractPersistentTest;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 *         Test class that creates an Address04
 */
public class Address04Test extends AbstractPersistentTest {

    // ======================================
    // =              Unit tests            =
    // ======================================
    @Test
    public void shouldCreateAnAddress() throws Exception {

        Address04 address = new Address04(getRandomId(), "65B Ritherdon Rd", "At James place", "London", "LDN", "7QE554", "UK");
        tx.begin();
        em.persist(address);
        tx.commit();
        assertNotNull("ID should not be null", address.getId());
    }
}