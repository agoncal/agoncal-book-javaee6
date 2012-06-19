package org.agoncal.book.javaee6.chapter03.ex10;

import org.agoncal.book.javaee6.chapter03.AbstractPersistentTest;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 *         Test class that creates a News (using the IdClass annotation)
 */
public class News10Test extends AbstractPersistentTest {

    // ======================================
    // =              Unit tests            =
    // ======================================
    @Test
    public void shouldCreateANews() throws Exception {

        NewsIdClass10 news = new NewsIdClass10("Richard Wright has died", "EN", "The keyboard of Pink Floyd has died today");
        tx.begin();
        em.persist(news);
        tx.commit();
        assertNotNull("ID should not be null", news.getTitle());
    }
}