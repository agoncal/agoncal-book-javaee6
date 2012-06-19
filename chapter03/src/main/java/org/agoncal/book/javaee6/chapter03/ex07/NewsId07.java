package org.agoncal.book.javaee6.chapter03.ex07;

import javax.persistence.Embeddable;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 *         Primary key of the news mapped as an Embeddable
 */
@Embeddable
public class NewsId07 {

    // ======================================
    // =             Attributes             =
    // ======================================
    private String title;
    private String language;

    // ======================================
    // =            Constructors            =
    // ======================================

    public NewsId07() {
    }

    public NewsId07(String title, String language) {
        this.title = title;
        this.language = language;
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

    // ======================================
    // =         hash, equals, toString     =
    // ======================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsId07 newsId = (NewsId07) o;

        if (!language.equals(newsId.language)) return false;
        if (!title.equals(newsId.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + language.hashCode();
        return result;
    }
}