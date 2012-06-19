package org.agoncal.book.javaee6.chapter05.ex05;

import javax.persistence.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class CustomerListener {

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================

    @PrePersist
    void prePersist(Customer05 customer05) {
        System.out.println(". prePersist");
    }

    @PreUpdate
    void preUpdate(Customer05 customer05) {
        System.out.println(". preUpdate");
    }

    @PreRemove
    void preRemove(Customer05 customer05) {
        System.out.println(". preRemove");
    }

    @PostLoad
    void postLoad(Customer05 customer05) {
        System.out.println(". postLoad");
    }

    @PostRemove
    void postRemove(Customer05 customer05) {
        System.out.println(". postRemove");
    }

    @PostUpdate
    void postUpdate(Customer05 customer05) {
        System.out.println(". postUpdate");
    }

    @PostPersist
    void postPersist(Customer05 customer05) {
        System.out.println(". postPersist");
    }
}