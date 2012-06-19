package org.agoncal.book.javaee6.chapter03.ex07;

import javax.persistence.EmbeddedId;
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
@Table(name = "ex07_news")
public class NewsEmbeddedId07 {

    // ======================================
    // =             Attributes             =
    // ======================================
    @EmbeddedId
    private NewsId07 id;
    private String content;

    // ======================================
    // =            Constructors            =
    // ======================================

    public NewsEmbeddedId07() {
    }

    public NewsEmbeddedId07(NewsId07 id, String content) {
        this.id = id;
        this.content = content;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public NewsId07 getId() {
        return id;
    }

    public void setId(NewsId07 id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}