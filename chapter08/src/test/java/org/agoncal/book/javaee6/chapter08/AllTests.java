package org.agoncal.book.javaee6.chapter08;

import org.agoncal.book.javaee6.chapter08.ex01.CacheEJB01Test;
import org.agoncal.book.javaee6.chapter08.ex02.ShoppingCartEJB02Test;
import org.agoncal.book.javaee6.chapter08.ex03.CustomerEJB03Test;
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
        CacheEJB01Test.class,
        ShoppingCartEJB02Test.class,
        CustomerEJB03Test.class
})
public class AllTests {
}