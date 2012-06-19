package org.agoncal.book.javaee6.chapter03.ex47;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Table(name = "ex47_order")
public class Order47 {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @GeneratedValue
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @OneToMany
    @JoinTable(name = "ex47_jnd_ord_line", joinColumns = @JoinColumn(name = "order_fk"), inverseJoinColumns = @JoinColumn(name = "order_line_fk"))
    private List<OrderLine47> orderLines;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Order47() {
        this.creationDate = new Date();
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getId() {
        return id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<OrderLine47> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine47> orderLines) {
        this.orderLines = orderLines;
    }
}