package org.agoncal.book.javaee6.chapter03.ex44;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Table(name = "ex44_order_line")
public class OrderLine44 {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @GeneratedValue
    private Long id;
    private String item;
    private Double unitPrice;
    private Integer quantity;

    // ======================================
    // =            Constructors            =
    // ======================================

    public OrderLine44() {
    }

    public OrderLine44(String item, Double unitPrice, Integer quantity) {
        this.item = item;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}