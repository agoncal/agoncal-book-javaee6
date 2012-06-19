package org.agoncal.book.javaee6.chapter15.ex14;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com
 *         http://www.antoniogoncalves.org
 *         --
 */
@ManagedBean
@RequestScoped
public class BookController14 {

    // ======================================
    // =             Attributes             =
    // ======================================

    private Book14 book = new Book14();

    private List<Book14> books = new ArrayList<Book14>();

    // ======================================
    // =           Public Methods           =
    // ======================================

    public String doNewBook() {
        return "newBook.xhtml";
    }

    public String doCreateBook() {
        System.out.println("VVV ###################################");


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter15PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(book);
        Query query = em.createNamedQuery(Book14.FIND_ALL);
        books = query.getResultList();

//        book = bookEJB.createBook(book);
//        books = bookEJB.findBooks();

        tx.commit();
        em.close();
        emf.close();


        System.out.println("AAA ###################################");
        return "listBooks.xhtml";
    }

    public String doListBooks() {
        return "listBooks.xhtml";
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public List<Book14> getBooks() {
        return books;
    }

    public void setBooks(List<Book14> books) {
        this.books = books;
    }

    public Book14 getBook() {
        return book;
    }

    public void setBook(Book14 book) {
        this.book = book;
    }
}
