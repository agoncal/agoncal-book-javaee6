package org.agoncal.book.javaee6.chapter07.ex01;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
public class ItemEJB01 {

    // ======================================
    // =             Attributes             =
    // ======================================

    @PersistenceContext(unitName = "chapter07PU")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================

    public List<Book01> findBooks() {
        TypedQuery<Book01> query = em.createNamedQuery("Book01.findAllBooks", Book01.class);
        return query.getResultList();
    }

    public List<CD01> findCDs() {
        TypedQuery query = em.createNamedQuery("CD01.findAllCDs", CD01.class);
        return query.getResultList();
    }

    public Book01 findBookById(Long id) {
        return em.find(Book01.class, id);
    }

    public CD01 findCDById(Long id) {
        return em.find(CD01.class, id);
    }

    public Book01 createBook(Book01 book) {
        em.persist(book);
        return book;
    }

    public CD01 createCD(CD01 cd) {
        em.persist(cd);
        return cd;
    }

    public void deleteBook(Book01 book) {
        em.remove(em.merge(book));
    }

    public void deleteCD(CD01 cd) {
        em.remove(em.merge(cd));
    }

    public Book01 updateBook(Book01 book) {
        return em.merge(book);
    }

    public CD01 updateCD(CD01 cd) {
        return em.merge(cd);
    }
}