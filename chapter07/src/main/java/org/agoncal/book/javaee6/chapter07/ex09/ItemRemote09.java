package org.agoncal.book.javaee6.chapter07.ex09;

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
public interface ItemRemote09 {

    // ======================================
    // =           Public Methods           =
    // ======================================
    String sayHello();

    List<Book09> findBooks();

    List<CD09> findCDs();

    Book09 findBookById(Long id);

    CD09 findCDById(Long id);

    Book09 createBook(Book09 book);

    CD09 createCD(CD09 cd);

    void deleteBook(Book09 book);

    void deleteCD(CD09 cd);

    Book09 updateBook(Book09 book);

    CD09 updateCD(CD09 cd);
}