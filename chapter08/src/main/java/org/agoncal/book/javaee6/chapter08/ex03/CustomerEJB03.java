package org.agoncal.book.javaee6.chapter08.ex03;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
public class CustomerEJB03 {

    // ======================================
    // =             Attributes             =
    // ======================================

    @PersistenceContext(unitName = "chapter08PU")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================

    @Interceptors(LoggingInterceptor03.class)
    public Customer03 createCustomer(Customer03 customer) {
        em.persist(customer);
        return customer;
    }

    public Customer03 findCustomerById(Long id) {
        return em.find(Customer03.class, id);
    }
}