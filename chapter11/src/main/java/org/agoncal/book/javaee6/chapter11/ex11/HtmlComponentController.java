package org.agoncal.book.javaee6.chapter11.ex11;

import org.agoncal.book.javaee6.chapter11.Book;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@ManagedBean
@RequestScoped
public class HtmlComponentController {

    // ======================================
    // =             Attributes             =
    // ======================================
    List<Book> bookList;
    String title;

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================
    @PostConstruct
    private void init() {
        bookList = new ArrayList<Book>();
        bookList.add(new Book("H2G2", 12f, "Scifi IT book", "1234-234", 241, true));
        bookList.add(new Book("Robots", 18.5f, "Best seller", "564-694", 317, true));
        bookList.add(new Book("Dune", 23.25f, "The trilogy", "256-6-56", 529, true));
    }

    // ======================================
    // =           Public Methods           =
    // ======================================

    public String doNext() {
        return null;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}