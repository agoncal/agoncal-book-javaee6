package org.agoncal.book.javaee6.chapter05.ex05;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ExcludeSuperclassListeners;
import javax.persistence.Transient;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 *         Simple entity
 */
@ExcludeSuperclassListeners()
@EntityListeners(CustomerListener.class)
@Entity
public class Customer05 extends Person05 {

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

    public Customer05() {
    }

    public Customer05(String firstName, String lastName, String email, String phoneNumber) {
        super(firstName, lastName);
        this.email = email;
        this.phoneNumber = phoneNumber;
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