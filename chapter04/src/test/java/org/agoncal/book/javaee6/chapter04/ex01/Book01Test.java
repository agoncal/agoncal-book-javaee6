package org.agoncal.book.javaee6.chapter04.ex01;

import org.agoncal.book.javaee6.chapter04.AbstractPersistentTest;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 *         Test class that creates a Book30
 */
public class Book01Test extends AbstractPersistentTest {

    // ======================================
    // =              Unit tests            =
    // ======================================
    @Test
    public void shouldCreateABook() throws Exception {

        Book01 book = new Book01(getRandomId(), "The Hitchhiker's Guide to the Galaxy", 12.5F, "The Hitchhiker's Guide to the Galaxy is a science fiction comedy series created by Douglas Adams.", "1-84023-742-2", 354, false);
        tx.begin();
        em.persist(book);
        tx.commit();
        assertNotNull("ID should not be null", book.getId());
    }
}