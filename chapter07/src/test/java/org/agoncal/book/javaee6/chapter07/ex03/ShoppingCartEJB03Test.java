package org.agoncal.book.javaee6.chapter07.ex03;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class ShoppingCartEJB03Test {

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
    public void shouldAddTwoItemsToTheShoppingCart() throws Exception {

        // Looks up the EJB
        ShoppingCartEJB03 shoppingCartEJB = (ShoppingCartEJB03) ctx.lookup("java:global/classes/ShoppingCartEJB03!org.agoncal.book.javaee6.chapter07.ex03.ShoppingCartEJB03");

        // Checks the shopping cart is empty
        assertEquals("Cart should have no items", new Integer(0), shoppingCartEJB.getNumberOfItems());
        assertEquals("Total price should be zero", new Float(0), shoppingCartEJB.getTotal());

        // Creates an instance of book
        Item03 book = new Item03();
        book.setTitle("The Hitchhiker's Guide to the Galaxy");
        book.setPrice(12.5F);
        book.setDescription("Science fiction comedy book");

        // Adds the book to the shopping cart
        shoppingCartEJB.addItem(book);
        assertEquals("Cart should have one item", new Integer(1), shoppingCartEJB.getNumberOfItems());
        assertEquals("Total price should be 12.5F", new Float(12.5), shoppingCartEJB.getTotal());

        Item03 cd = new Item03();
        cd.setTitle("Zoot Allure");
        cd.setPrice(23f);
        cd.setDescription("Another Zappa's master piece");

        // Adds the cd to the shopping cart
        shoppingCartEJB.addItem(cd);
        assertEquals("Cart should have two items", new Integer(2), shoppingCartEJB.getNumberOfItems());
        assertEquals("Total price should be 35.5F", new Float(35.5), shoppingCartEJB.getTotal());

        // Empties the shopping cart
        shoppingCartEJB.empty();
        assertEquals("Cart should have no items", new Integer(0), shoppingCartEJB.getNumberOfItems());
        assertEquals("Total price should be zero", new Float(0), shoppingCartEJB.getTotal());

        // Checks out the shopping cart
        shoppingCartEJB.checkout();
        try {
            shoppingCartEJB.getNumberOfItems();
            fail("The checkout method has a @Remove annotation that clears the EJB. From here the EJB does not exist anymore");
        } catch (Exception e) {
        }
    }
}
