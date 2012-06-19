package org.agoncal.book.javaee6.chapter03.ex22;

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
public class CreditCard22Test extends AbstractPersistentTest {

    // ======================================
    // =              Unit tests            =
    // ======================================
    @Test
    public void shouldCreateACreditCard() throws Exception {

        CreditCard22 creditCard = new CreditCard22("123412341234", "12/12", 1253, CreditCardType22.AMERICAN_EXPRESS);
        tx.begin();
        em.persist(creditCard);
        tx.commit();
        assertNotNull("ID should not be null", creditCard.getNumber());
    }
}