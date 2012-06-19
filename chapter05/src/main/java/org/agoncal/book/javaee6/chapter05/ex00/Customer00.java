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
public class Customer00 extends Person00 {

    // ======================================
    // =             Attributes             =
    // ======================================
    private String email;
    private String phoneNumber;
    @Transient
    private Integer age;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Customer00() {
    }

    public Customer00(String firstName, String lastName, String email, String phoneNumber) {
        super(firstName, lastName);
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================

    @PrePersist
    private void prePersist() {
        System.out.println("-- prePersist");
    }

    @PostPersist
    private void postPersist() {
        System.out.println("-- postPersist");
    }

    @PreUpdate
    private void preUpdate() {
        System.out.println("-- preUpdate");
    }

    @PostUpdate
    private void postUpdate() {
        System.out.println("-- postUpdate");
    }

    @PostLoad
    private void postLoad() {
        System.out.println("-- postLoad");
    }

    @PreRemove
    private void preRemove() {
        System.out.println("-- preRemove");
    }

    @PostRemove
    private void postRemove() {
        System.out.println("-- postRemove");
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}