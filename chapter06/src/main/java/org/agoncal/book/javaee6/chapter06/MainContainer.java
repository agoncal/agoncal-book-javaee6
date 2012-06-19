package org.agoncal.book.javaee6.chapter06;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class MainContainer {

    // ======================================
    // =           Public Methods           =
    // ======================================

    public static void main(String[] args) {

        // Creates an instance of book
        Book book = new Book();
        book.setTitle("The Hitchhiker's Guide to the Galaxy");
        book.setPrice(12.5F);
        book.setDescription("Science fiction comedy series created by Douglas Adams.");
        book.setIsbn("1-84023-742-2");
        book.setNbOfPage(354);
        book.setIllustrations(false);

        EJBContainer ec = null;
        try {
            Map<String, Object> properties = new HashMap<String, Object>();
            properties.put(EJBContainer.MODULES, new File("target/classes"));
            ec = EJBContainer.createEJBContainer(properties);
            Context ctx = ec.getContext();

            BookEJB bookEJB = (BookEJB) ctx.lookup("java:global/classes/BookEJB!org.agoncal.book.javaee6.chapter06.BookEJB");

            book = bookEJB.createBook(book);
            book = bookEJB.findBookById(book.getId());
            System.out.println("### Book created : " + book);
            System.out.println("### " + bookEJB.findBooks().size() + " books in the db");
            bookEJB.deleteBook(book);
            System.out.println("### Book deleted");

        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            if (ec != null)
                ec.close();
        }
    }
}