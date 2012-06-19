package org.agoncal.book.javaee6.chapter03.ex50;

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
@Table(name = "ex50_cd")
public class CD50 {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Float price;
    private String description;
    @ManyToMany(mappedBy = "appearsOnCDs")
    private List<Artist50> createdByArtists;

    // ======================================
    // =            Constructors            =
    // ======================================

    public CD50() {
    }

    public CD50(String title, Float price, String description) {
        this.title = title;
        this.price = price;
        this.description = description;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Artist50> getCreatedByArtists() {
        return createdByArtists;
    }

    public void setCreatedByArtists(List<Artist50> createdByArtists) {
        this.createdByArtists = createdByArtists;
    }

    public void createdBy(Artist50 artist) {
        if (createdByArtists == null)
            createdByArtists = new ArrayList<Artist50>();
        createdByArtists.add(artist);
    }
}