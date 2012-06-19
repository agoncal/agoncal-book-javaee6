package org.agoncal.book.javaee6.chapter03.ex68;

import org.agoncal.book.javaee6.chapter03.AbstractPersistentTest;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Item68Test extends AbstractPersistentTest {

    // ======================================
    // =              Unit tests            =
    // ======================================
    @Test
    public void shouldCreateABook() throws Exception {

        Book68 book = new Book68("H2G2", 21f, "Best IT book", "123-456-789", "Pinguin", 321, false);
        tx.begin();
        em.persist(book);
        tx.commit();
        assertNotNull("Book ID should not be null", book.getId());
    }
}