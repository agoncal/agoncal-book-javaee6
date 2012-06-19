package org.agoncal.book.javaee6.chapter03.ex56;

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
@Table(name = "ex56_news")
public class News56 {

    // ======================================
    // =             Attributes             =
    // ======================================
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String content;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @OrderColumn(name = "publication_index")
    private List<Comment56> comments;

    // ======================================
    // =            Constructors            =
    // ======================================

    public News56() {
    }

    public News56(String content) {
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

    public void addComment(Comment56 comment) {
        if (comments == null)
            comments = new ArrayList<Comment56>();
        comments.add(comment);
    }

    public List<Comment56> getComments() {
        return comments;
    }
}