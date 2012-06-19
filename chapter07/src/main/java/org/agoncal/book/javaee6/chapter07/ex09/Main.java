package org.agoncal.book.javaee6.chapter07.ex09;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Context ctx = new InitialContext();

        // Portable JNDI Name with the remote interface
        ItemRemote09 itemEJB = (ItemRemote09) ctx.lookup("java:global/chapter07-2.0/ItemEJB09!org.agoncal.book.javaee6.chapter07.ex09.ItemRemote09");

        System.out.println("### " + itemEJB.sayHello());
        System.out.println("### " + itemEJB.findBooks().size());

        // Portable JNDI Name with no interface
        itemEJB = (ItemRemote09) ctx.lookup("java:global/chapter07-2.0/ItemEJB09");

        System.out.println("\n### " + itemEJB.sayHello());
        System.out.println("### " + itemEJB.findBooks().size());

    }
}
