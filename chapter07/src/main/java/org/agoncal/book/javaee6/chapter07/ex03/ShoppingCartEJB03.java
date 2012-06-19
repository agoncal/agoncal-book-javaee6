package org.agoncal.book.javaee6.chapter07.ex03;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateful
@StatefulTimeout(value = 20, unit = TimeUnit.SECONDS)
public class ShoppingCartEJB03 {

    // ======================================
    // =             Attributes             =
    // ======================================
    private List<Item03> cartItems = new ArrayList<Item03>();

    // ======================================
    // =           Public Methods           =
    // ======================================

    public void addItem(Item03 item) {
        if (!cartItems.contains(item))
            cartItems.add(item);
    }

    public void removeItem(Item03 item) {
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
        for (Item03 cartItem : cartItems) {
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