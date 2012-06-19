package org.agoncal.book.javaee6.chapter11.ex13;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
public class ItemEJB {

    // ======================================
    // =             Attributes             =
    // ======================================

    @PersistenceContext(unitName = "chapter11PU")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================

    public List<Item> findItems() {
        Query query = em.createNamedQuery("findAllItems");
        return query.getResultList();
    }

    public Book createBook(Book book) {
        em.persist(book);
        return book;
    }

    public CD createCD(CD cd) {
        em.persist(cd);
        return cd;
    }
}