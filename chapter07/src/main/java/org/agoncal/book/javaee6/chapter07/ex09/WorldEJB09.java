package org.agoncal.book.javaee6.chapter07.ex09;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
public class WorldEJB09 {

    @EJB
    private ItemEJB09 itemEJB;

    public String sayWorld() {
        itemEJB.findBooks();
        return "World !!!!!!!!!!!!!!!";
    }
}
