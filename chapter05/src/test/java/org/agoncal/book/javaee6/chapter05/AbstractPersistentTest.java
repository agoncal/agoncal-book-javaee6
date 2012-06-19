package org.agoncal.book.javaee6.chapter05;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.SQLException;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public abstract class AbstractPersistentTest {

    // ======================================
    // =             Attributes             =
    // ======================================
    protected static EntityManagerFactory emf;
    protected static EntityManager em;
    protected static EntityTransaction tx;

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================

    @BeforeClass
    public static void initEntityManager() throws Exception {
        emf = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);
        em = emf.createEntityManager();
    }

    @AfterClass
    public static void closeEntityManager() throws SQLException {
        em.close();
        emf.close();
    }

    @Before
    public void initTransaction() {
        if (tx != null && tx.isActive())
            tx.rollback();
        tx = em.getTransaction();
    }
}