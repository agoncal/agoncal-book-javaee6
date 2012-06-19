package org.agoncal.book.javaee6.chapter03.ex50;

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
public class Artist50Test extends AbstractPersistentTest {

    // ======================================
    // =              Unit tests            =
    // ======================================
    @Test
    public void shouldCreateThreeCDsAndFourArtists() throws Exception {

        Artist50 ringo = new Artist50("Ringo", "Starr");
        Artist50 john = new Artist50("John", "Lenon");
        Artist50 franck = new Artist50("Franck", "Zappa");
        Artist50 jimi = new Artist50("Jimi", "Hendrix");

        CD50 zoot = new CD50("Zoot Allures", 12.5F, "Released in October 1976, it is mostly a studio album");
        CD50 sgtpepper = new CD50("Sergent Pepper", 28.5F, "Best Beatles Album");
        CD50 heyjoe = new CD50("Hey Joe", 32F, "Hendrix live with friends");

        ringo.appearsOn(sgtpepper);
        john.appearsOn(sgtpepper);
        john.appearsOn(heyjoe);
        franck.appearsOn(zoot);
        franck.appearsOn(heyjoe);
        jimi.appearsOn(heyjoe);
        jimi.appearsOn(sgtpepper);

        zoot.createdBy(franck);
        sgtpepper.createdBy(ringo);
        sgtpepper.createdBy(john);
        heyjoe.createdBy(jimi);

        tx.begin();
        em.persist(ringo);
        em.persist(john);
        em.persist(franck);
        em.persist(jimi);
        em.persist(zoot);
        em.persist(sgtpepper);
        em.persist(heyjoe);
        tx.commit();
        assertNotNull("Ringo ID should not be null", ringo.getId());
        assertNotNull("John ID should not be null", john.getId());
        assertNotNull("Franck ID should not be null", franck.getId());
        assertNotNull("Zoot ID should not be null", zoot.getId());
        assertNotNull("Sgt Pepper ID should not be null", sgtpepper.getId());
        assertNotNull("Hey Joe ID should not be null", heyjoe.getId());
    }
}