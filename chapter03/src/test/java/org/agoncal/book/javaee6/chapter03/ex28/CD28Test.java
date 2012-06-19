package org.agoncal.book.javaee6.chapter03.ex28;

import org.agoncal.book.javaee6.chapter03.AbstractPersistentTest;
import org.junit.Test;

import java.util.HashMap;

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
public class CD28Test extends AbstractPersistentTest {

    // ======================================
    // =              Unit tests            =
    // ======================================
    @Test
    public void shouldCreateACDWithAMapOfTracks() throws Exception {

        HashMap<Integer, String> tracks = new HashMap<Integer, String>();
        tracks.put(1, "Wind Up Workin' in a Gas Station");
        tracks.put(2, "Black Napkins");
        tracks.put(3, "The Torture Never Stops");
        CD28 cd = new CD28("Zoot Allures", 12.5F, "Released in October 1976, it is mostly a studio album", tracks);
        tx.begin();
        em.persist(cd);
        tx.commit();
        assertNotNull("ID should not be null", cd.getId());
        assertEquals(3, cd.getTracks().size());
    }
}