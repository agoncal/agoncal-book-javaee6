package org.agoncal.book.javaee6.chapter07.ex09;

import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
//@Local
public interface ItemLocal09 {

    // ======================================
    // =           Public Methods           =
    // ======================================
    List<Book09> findBooks();

    List<CD09> findCDs();

    Book09 findBookById(Long id);

    CD09 findCDById(Long id);
}