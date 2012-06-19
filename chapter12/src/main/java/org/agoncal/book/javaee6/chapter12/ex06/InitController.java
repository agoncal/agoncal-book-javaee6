package org.agoncal.book.javaee6.chapter12.ex06;

import org.agoncal.book.javaee6.chapter12.Book;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@ManagedBean(eager = true, name = "initController06")
@ApplicationScoped
public class InitController {

    // ======================================
    // =             Attributes             =
    // ======================================

    private Book defaultBook = new Book();

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================

    @PostConstruct
    private void init() {
        System.out.println("#########################################################################################");
        defaultBook = new Book("default title", 0f, "default descritpion", "0000-000", 100, true);
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Book getDefaultBook() {
        return defaultBook;
    }

    public void setDefaultBook(Book defaultBook) {
        this.defaultBook = defaultBook;
    }
}