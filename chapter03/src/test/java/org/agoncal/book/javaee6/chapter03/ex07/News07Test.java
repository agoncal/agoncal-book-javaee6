package org.agoncal.book.javaee6.chapter03.ex07;

import org.agoncal.book.javaee6.chapter03.AbstractPersistentTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 *         Test class that creates a News (using the EmbeddedId annotation)
 */
public class News07Test extends AbstractPersistentTest {

    // ======================================
    // =              Unit tests            =
    // ======================================
    @Test
    public void shouldCreateANews() throws Exception {

        NewsEmbeddedId07 news = new NewsEmbeddedId07(new NewsId07("Richard Wright has died", "EN"), "The keyboard of Pink Floyd has died today");
        tx.begin();
        em.persist(news);
        tx.commit();

        news = em.find(NewsEmbeddedId07.class, new NewsId07("Richard Wright has died", "EN"));

        assertEquals("The keyboard of Pink Floyd has died today", news.getContent());
    }
}