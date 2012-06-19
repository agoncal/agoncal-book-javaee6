package org.agoncal.book.javaee6.chapter04.ex25;

import javax.persistence.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Table(name = "ex25_customer")
@NamedQueries({
        @NamedQuery(name = "findAll", query = "select c from Customer25 c"),
        @NamedQuery(name = Customer25.FIND_ALL, query = "select c from Customer25 c"),
        @NamedQuery(name = "findVincent", query = "select c from Customer25 c where c.firstName = 'Vincent'"),
        @NamedQuery(name = "findWithParam", query = "select c from Customer25 c where c.firstName = :fname")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "findAllNative", query = "select * from JPQL_EX01_CUSTOMER", resultClass = Customer25.class)
})
public class Customer25 {

    public static final String FIND_ALL = "Customer.findAll";

    // ======================================
    // =             Attributes             =
    // ======================================
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "address_fk")
    private Address25 address;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Customer25() {
    }

    public Customer25(String firstName, String lastName, String email, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address25 getAddress() {
        return address;
    }

    public void setAddress(Address25 address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}