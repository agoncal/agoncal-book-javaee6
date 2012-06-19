package org.agoncal.book.javaee6.chapter07;

import org.agoncal.book.javaee6.chapter07.ex01.ItemEJB01Test;
import org.agoncal.book.javaee6.chapter07.ex03.ShoppingCartEJB03Test;
import org.agoncal.book.javaee6.chapter07.ex04.Cache04Test;
import org.agoncal.book.javaee6.chapter07.ex04.CacheEJB04Test;
import org.agoncal.book.javaee6.chapter07.ex09.ItemEJB09Test;
import org.agoncal.book.javaee6.chapter07.ex12.ItemEJB12Test;
import org.agoncal.book.javaee6.chapter07.ex14.ItemEJB14Test;
import org.agoncal.book.javaee6.chapter07.ex17.OrderEJB17Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ItemEJB01Test.class,
        ShoppingCartEJB03Test.class,
        CacheEJB04Test.class,
        Cache04Test.class,
        ItemEJB09Test.class,
        ItemEJB12Test.class,
        ItemEJB14Test.class,
        OrderEJB17Test.class
})

public class AllTests {
}