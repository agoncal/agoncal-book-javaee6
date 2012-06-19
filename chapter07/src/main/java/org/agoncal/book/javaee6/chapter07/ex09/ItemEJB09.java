package org.agoncal.book.javaee6.chapter07.ex09;

import javax.annotation.Resource;
import javax.ejb.*;
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
@LocalBean
@Local(ItemLocal09.class)
@Remote(ItemRemote09.class)
public class ItemEJB09 implements ItemLocal09, ItemRemote09 {

    // ======================================
    // =             Attributes             =
    // ======================================

    @PersistenceContext(unitName = "chapter07PU")
    private EntityManager em;

    @Resource
    private SessionContext ctx;

    // ======================================
    // =           Public Methods           =
    // ======================================

    public String sayHello() {
// OK        WorldEJB09 worldEJB = (WorldEJB09) ctx.lookup("java:global/chapter07-2.0/WorldEJB09!org.agoncal.book.javaee6.chapter07.ex09.WorldEJB09");
// OK        WorldEJB09 worldEJB = (WorldEJB09) ctx.lookup("java:global/chapter07-2.0/WorldEJB09");
// OK        WorldEJB09 worldEJB = (WorldEJB09) ctx.lookup("java:app/chapter07-2.0/WorldEJB09!org.agoncal.book.javaee6.chapter07.ex09.WorldEJB09");
// OK        WorldEJB09 worldEJB = (WorldEJB09) ctx.lookup("java:app/chapter07-2.0/WorldEJB09");
// OK        WorldEJB09 worldEJB = (WorldEJB09) ctx.lookup("java:module/WorldEJB09!org.agoncal.book.javaee6.chapter07.ex09.WorldEJB09");

        WorldEJB09 worldEJB = (WorldEJB09) ctx.lookup("java:module/WorldEJB09");
        return "Hello " + worldEJB.sayWorld();
    }

    public List<Book09> findBooks() {
        Query query = em.createNamedQuery("Book09.findAllBooks");
        return query.getResultList();
    }

    public List<CD09> findCDs() {
        Query query = em.createNamedQuery("CD09.findAllCDs");
        return query.getResultList();
    }

    public Book09 findBookById(Long id) {
        return em.find(Book09.class, id);
    }

    public CD09 findCDById(Long id) {
        return em.find(CD09.class, id);
    }

    public Book09 createBook(Book09 book) {
        em.persist(book);
        return book;
    }

    public CD09 createCD(CD09 cd) {
        em.persist(cd);
        return cd;
    }

    public void deleteBook(Book09 book) {
        em.remove(em.merge(book));
    }

    public void deleteCD(CD09 cd) {
        em.remove(em.merge(cd));
    }

    public Book09 updateBook(Book09 book) {
        return em.merge(book);
    }

    public CD09 updateCD(CD09 cd) {
        return em.merge(cd);
    }
}