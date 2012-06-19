package org.agoncal.book.javaee6.chapter12.ex12;

import org.agoncal.book.javaee6.chapter12.Book;
import org.agoncal.book.javaee6.chapter12.BookEJB;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@ManagedBean(name = "myBookController12")
@RequestScoped
public class BookController {

    // ======================================
    // =             Attributes             =
    // ======================================

    @EJB
    private BookEJB bookEJB;

    private Book book = new Book();
    private List<Book> bookList = new ArrayList<Book>();

    private Date publishedDate = new Date();
    private Number publishedPrice = new Integer(666);

    // ======================================
    // =           Public Methods           =
    // ======================================

    public String doCreateBook() {
        book = bookEJB.createBook(book);
        bookList = bookEJB.findBooks();
        return "listBooks.xhtml";
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Number getPublishedPrice() {
        return publishedPrice;
    }

    public void setPublishedPrice(Number publishedPrice) {
        this.publishedPrice = publishedPrice;
    }
}