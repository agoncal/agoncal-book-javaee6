package org.agoncal.book.javaee6.chapter07.ex12;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
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
public class ItemEJB12 implements ItemLocal12, ItemRemote12 {

    // ======================================
    // =             Attributes             =
    // ======================================

    @PersistenceContext(unitName = "chapter07PU")
    private EntityManager em;

    @Resource
    SessionContext ctx;


    // ======================================
    // =           Public Methods           =
    // ======================================

    public List<Book12> findBooks() {
        Query query = em.createNamedQuery("Book12.findAllBooks");
        return query.getResultList();
    }

    public List<CD12> findCDs() {
        Query query = em.createNamedQuery("CD12.findAllCDs");
        return query.getResultList();
    }

    public Book12 findBookById(Long id) {
        return em.find(Book12.class, id);
    }

    public CD12 findCDById(Long id) {
        return em.find(CD12.class, id);
    }

    public Book12 createBook(Book12 book) {
        em.persist(book);
        return book;
    }

    public CD12 createCD(CD12 cd) {
        em.persist(cd);
        return cd;
    }

    public void deleteBook(Book12 book) {
        em.remove(em.merge(book));
    }

    public void deleteCD(CD12 cd) {
        em.remove(em.merge(cd));
    }

    public Book12 updateBook(Book12 book) {
        return em.merge(book);
    }

    public CD12 updateCD(CD12 cd) {
        return em.merge(cd);
    }
}