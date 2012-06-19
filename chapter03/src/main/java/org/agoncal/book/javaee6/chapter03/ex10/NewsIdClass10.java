package org.agoncal.book.javaee6.chapter03.ex10;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Table(name = "ex10_news")
@IdClass(NewsId10.class)
public class NewsIdClass10 {

    // ======================================
    // =             Attributes             =
    // ======================================
    @Id
    private String title;
    @Id
    private String language;
    private String content;

    // ======================================
    // =            Constructors            =
    // ======================================

    public NewsIdClass10() {
    }

    public NewsIdClass10(String title, String language, String content) {
        this.title = title;
        this.language = language;
        this.content = content;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}