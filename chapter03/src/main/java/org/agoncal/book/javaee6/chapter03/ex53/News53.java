package org.agoncal.book.javaee6.chapter03.ex53;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Table(name = "ex53_news")
public class News53 {

    // ======================================
    // =             Attributes             =
    // ======================================
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String content;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @OrderBy("postedDate DESC")
    private List<Comment53> comments;

    // ======================================
    // =            Constructors            =
    // ======================================

    public News53() {
    }

    public News53(String content) {
        this.content = content;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void addComment(Comment53 comment) {
        if (comments == null)
            comments = new ArrayList<Comment53>();
        comments.add(comment);
    }

    public List<Comment53> getComments() {
        return comments;
    }
}