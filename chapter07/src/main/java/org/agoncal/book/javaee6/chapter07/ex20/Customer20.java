package org.agoncal.book.javaee6.chapter07.ex20;

import java.io.Serializable;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Customer20 implements Serializable {

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public String getBirthMonth() {
        return "12";
    }

    public String getBirthDay() {
        return "12";
    }
}