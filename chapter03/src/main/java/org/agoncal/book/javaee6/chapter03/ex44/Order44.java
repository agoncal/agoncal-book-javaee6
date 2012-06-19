package org.agoncal.book.javaee6.chapter03.ex44;

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
@Table(name = "ex44_order")
public class Order44 {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @GeneratedValue
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    private List<OrderLine44> orderLines;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Order44() {
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

    public List<OrderLine44> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine44> orderLines) {
        this.orderLines = orderLines;
    }
}