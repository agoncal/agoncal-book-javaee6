package org.agoncal.book.javaee6.chapter05;

import org.agoncal.book.javaee6.chapter05.ex00.Customer00Test;
import org.agoncal.book.javaee6.chapter05.ex01.Customer01Test;
import org.agoncal.book.javaee6.chapter05.ex02.Customer02Test;
import org.agoncal.book.javaee6.chapter05.ex05.Customer05Test;
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
        Customer00Test.class,
        Customer01Test.class,
        Customer02Test.class,
        Customer05Test.class
})

public class AllTests {
}