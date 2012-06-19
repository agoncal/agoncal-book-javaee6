package org.agoncal.book.javaee6.chapter07.ex12;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class ItemEJB12Test {

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
    public void shouldLookUpDifferentEJBInterfaces() throws Exception {

        // Creates an instance of book
        Book12 book = new Book12();
        book.setTitle("The Hitchhiker's Guide to the Galaxy");
        book.setPrice(12.5F);
        book.setDescription("Science fiction comedy book");
        book.setIsbn("1-84023-742-2");
        book.setNbOfPage(354);
        book.setIllustrations(false);

        // Looks up the EJB with the no-interface view
        ItemEJB12 itemEJB = (ItemEJB12) ctx.lookup("java:global/classes/ItemEJB12!org.agoncal.book.javaee6.chapter07.ex12.ItemEJB12");

        // Persists the book to the database
        book = itemEJB.createBook(book);
        assertNotNull("ID should not be null", book.getId());

        // Looks up the EJB with the local interface
// KO        ItemLocal12 itemLocal = (ItemLocal12) ctx.lookup("java:global/classes/ItemEJB12!org.agoncal.book.javaee6.chapter07.ex12.ItemLocal12");

        // Persists the book to the database
// KO        book = itemLocal.findBookById(book.getId());
// KO        assertNotNull("Book should not be null", book);
    }
}