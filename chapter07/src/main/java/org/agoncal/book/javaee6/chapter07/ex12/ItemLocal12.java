package org.agoncal.book.javaee6.chapter07.ex12;

import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public interface ItemLocal12 {

    // ======================================
    // =           Public Methods           =
    // ======================================
    List<Book12> findBooks();

    List<CD12> findCDs();

    Book12 findBookById(Long id);

    CD12 findCDById(Long id);
}