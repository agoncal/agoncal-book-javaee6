package org.agoncal.book.javaee6.chapter04.ex22;

import org.agoncal.book.javaee6.chapter04.AbstractPersistentTest;
import org.junit.Test;

import javax.persistence.Cache;

import static org.junit.Assert.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Caching22Test extends AbstractPersistentTest {

    // ======================================
    // =              Unit tests            =
    // ======================================

    @Test
    public void shouldCheckThatAddressIsCacheableEqualsFalse() throws Exception {

        Address22 address = new Address22("Ritherdon Rd", "London", "8QE", "UK");

        // Persist the object
        tx.begin();
        em.persist(address);
        tx.commit();

        assertNotNull(address.getId());

        Cache cache = emf.getCache();

        // Address should not be in the cache
        assertFalse(cache.contains(Address22.class, address.getId()));
    }

    @Test
    public void shouldCheckThatCustomerIsCacheableEqualsTrue() throws Exception {

        Customer22 customer = new Customer22("Antony", "Balla", "tballa@mail.com");

        // Persist the object
        tx.begin();
        em.persist(customer);
        tx.commit();

        assertNotNull(customer.getId());

        Cache cache = emf.getCache();

        // Customer should be in the cache
        assertTrue(cache.contains(Customer22.class, customer.getId()));

        cache.evict(Customer22.class);

        // After clearing the cache Customer should not be in the cache
        assertFalse(cache.contains(Customer22.class, customer.getId()));
    }

    @Test
    public void shouldCheckThatBookIsNotCacheableByDefault() throws Exception {

        Book22 book = new Book22(getRandomId(), "The Hitchhiker's Guide to the Galaxy", 12.5F, "The Hitchhiker's Guide to the Galaxy is a science fiction comedy series created by Douglas Adams.", "1-84023-742-2", 354, false);

        // Persist the object
        tx.begin();
        em.persist(book);
        tx.commit();

        assertNotNull(book.getId());

        Cache cache = emf.getCache();

        // Customer should not be in the cache by default
        assertFalse(cache.contains(Customer22.class, book.getId()));
    }
}