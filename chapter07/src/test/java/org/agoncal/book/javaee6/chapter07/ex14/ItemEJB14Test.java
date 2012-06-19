package org.agoncal.book.javaee6.chapter07.ex14;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class ItemEJB14Test {

    // ======================================
    // =             Attributes             =
    // ======================================
    private static EJBContainer ec;
    private static Context ctx;

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================

    @BeforeClass
    public static void initContainer() throws Exception {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(EJBContainer.MODULES, new File("target/classes"));
        ec = EJBContainer.createEJBContainer(properties);
        ctx = ec.getContext();
    }

    @AfterClass
    public static void closeContainer() throws Exception {
        if (ctx != null)
            ctx.close();
        if (ec != null)
            ec.close();
    }

    // ======================================
    // =              Unit tests            =
    // ======================================

    @Test
    public void shouldConvertThePriceOfAnItem() throws Exception {

        // Creates an instance of an item
        Item14 item = new Item14();
        item.setTitle("The Hitchhiker's Guide to the Galaxy");
        item.setPrice(12.5F);
        item.setIsbn("1-84023-742-2");
        item.setNbOfPage(354);
        item.setIllustrations(false);

        // Looks up the EJB with the no-interface view
//        ItemEJB14 itemEJB = (ItemEJB14) ctx.lookup("java:global/classes/ItemEJB14!org.agoncal.book.javaee6.chapter07.ex14.ItemEJB14");
        ItemEJB14 itemEJB = (ItemEJB14) ctx.lookup("java:global/classes/ItemEJB14");

        // Persists the book to the database
        item = itemEJB.convertPrice(item);
        assertEquals("The currency should be euros from the ejb-jar.xml", "Euros", item.getCurrency());
        assertEquals("Price should be 12.5 * 0.8", new Float(10), item.getPrice());
    }
}