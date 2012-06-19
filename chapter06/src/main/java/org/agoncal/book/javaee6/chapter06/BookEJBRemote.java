package org.agoncal.book.javaee6.chapter06;

import javax.ejb.Remote;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Remote
public interface BookEJBRemote {

    // ======================================
    // =           Public Methods           =
    // ======================================

    List<Book> findBooks();

    Book findBookById(Long id);

    Book createBook(Book book);

    void deleteBook(Book book);

    Book updateBook(Book book);
}