package org.agoncal.book.javaee6.chapter03.ex50;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Table(name = "ex50_artist")
public class Artist50 {

    // ======================================
    // =             Attributes             =
    // ======================================
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToMany
    @JoinTable(name = "ex50_jnd_art_cd", joinColumns = @JoinColumn(name = "artist_fk"), inverseJoinColumns = @JoinColumn(name = "cd_fk"))
    private List<CD50> appearsOnCDs;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Artist50() {
    }

    public Artist50(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<CD50> getAppearsOnCDs() {
        return appearsOnCDs;
    }

    public void setAppearsOnCDs(List<CD50> appearsOnCDs) {
        this.appearsOnCDs = appearsOnCDs;
    }

    public void appearsOn(CD50 cd) {
        if (appearsOnCDs == null)
            appearsOnCDs = new ArrayList<CD50>();
        appearsOnCDs.add(cd);
    }

}