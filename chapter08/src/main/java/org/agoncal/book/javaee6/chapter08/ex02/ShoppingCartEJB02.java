package org.agoncal.book.javaee6.chapter08.ex02;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateful
public class ShoppingCartEJB02 {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Resource(lookup="java:global/jdbc/__default")
    private DataSource ds;
    private Connection connection;
    private List<Item02> cartItems = new ArrayList<Item02>();

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================

    @PostConstruct
    @PostActivate
    private void init() {
        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @PreDestroy
    @PrePassivate
    private void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    // ======================================
    // =           Public Methods           =
    // ======================================

    public void addItem(Item02 item) {
        if (!cartItems.contains(item))
            cartItems.add(item);
    }

    public void removeItem(Item02 item) {
        if (cartItems.contains(item))
            cartItems.remove(item);
    }

    public Integer getNumberOfItems() {
        if (cartItems == null || cartItems.isEmpty())
            return 0;
        return cartItems.size();
    }

    public Float getTotal() {
        if (cartItems == null || cartItems.isEmpty())
            return 0f;

        Float total = 0f;
        for (Item02 cartItem : cartItems) {
            total += (cartItem.getPrice());
        }
        return total;
    }

    public void empty() {
        cartItems.clear();
    }

    @Remove
    public void checkout() {
        cartItems.clear();
    }
}