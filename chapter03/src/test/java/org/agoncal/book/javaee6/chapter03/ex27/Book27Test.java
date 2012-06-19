package org.agoncal.book.javaee6.chapter03.ex27;

import org.agoncal.book.javaee6.chapter03.AbstractPersistentTest;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 *         Test class that creates a Book03
 */
public class Book27Test extends AbstractPersistentTest {

    // ======================================
    // =              Unit tests            =
    // ======================================
    @Test
    public void shouldCreateABookWithTags() throws Exception {

        ArrayList<String> tags = new ArrayList<String>();
        tags.add("scifi");
        tags.add("must have");
        tags.add("funny");
        Book27 book = new Book27("The Hitchhiker's Guide to the Galaxy", 12.5F, "The Hitchhiker's Guide to the Galaxy is a science fiction comedy series created by Douglas Adams.", "1-84023-742-2", 354, false, tags);
        tx.begin();
        em.persist(book);
        tx.commit();
        assertNotNull("ID should not be null", book.getId());
        assertEquals(3, book.getTags().size());
    }
}