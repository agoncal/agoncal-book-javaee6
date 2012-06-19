package org.agoncal.book.javaee6.chapter07.ex14;

import javax.annotation.Resource;
import javax.ejb.Stateless;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
public class ItemEJB14 {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Resource(name = "currencyEntry")
    private String currency;
    @Resource(name = "changeRateEntry")
    private Float changeRate;

    // ======================================
    // =           Public Methods           =
    // ======================================

    public Item14 convertPrice(Item14 item) {
        item.setPrice(item.getPrice() * changeRate);
        item.setCurrency(currency);
        return item;
    }
}