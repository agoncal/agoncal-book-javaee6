package org.agoncal.book.javaee6.chapter05.ex00;

import javax.persistence.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 *         Simple entity
 */
@Entity
@Table(name = "ex00_customer")
public class Person00 {

    // ======================================
    // =             Attributes             =
    // ======================================
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;

// ======================================
// =            Constructors            =
// ======================================

    public Person00() {
    }

    public Person00(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================

    @PrePersist
    private void preSuperPersist() {
        System.out.println("^ prePersist");
    }

    @PostPersist
    private void postSuperPersist() {
        System.out.println("^ postPersist");
    }

    @PreUpdate
    private void preSuperUpdate() {
        System.out.println("^ preUpdate");
    }

    @PostUpdate
    private void postSuperUpdate() {
        System.out.println("^ postUpdate");
    }

    @PostLoad
    private void postSuperLoad() {
        System.out.println("^ postLoad");
    }

    @PreRemove
    private void preSuperRemove() {
        System.out.println("^ preRemove");
    }

    @PostRemove
    private void postSuperRemove() {
        System.out.println("^ postRemove");
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
}