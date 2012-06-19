package org.agoncal.book.javaee6.chapter03.ex64;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Table(name = "ex64_book")
public class Book64 extends Item64 {

    // ======================================
    // =             Attributes             =
    // ======================================

    private String isbn;
    private String publisher;
    private Integer nbOfPage;
    private Boolean illustrations;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Book64() {
    }

    public Book64(String title, Float price, String description, String isbn, String publisher, Integer nbOfPage, Boolean illustrations) {
        super(title, price, description);
        this.isbn = isbn;
        this.publisher = publisher;
        this.nbOfPage = nbOfPage;
        this.illustrations = illustrations;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getNbOfPage() {
        return nbOfPage;
    }

    public void setNbOfPage(Integer nbOfPage) {
        this.nbOfPage = nbOfPage;
    }

    public Boolean getIllustrations() {
        return illustrations;
    }

    public void setIllustrations(Boolean illustrations) {
        this.illustrations = illustrations;
    }
}