package org.agoncal.book.javaee6.chapter04.ex25;

import org.agoncal.book.javaee6.chapter04.AbstractPersistentTest;
import org.junit.Test;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Queries25Test extends AbstractPersistentTest {

    // ======================================
    // =              Constants             =
    // ======================================
    private static final int ALL = 6;

    // ======================================
    // =              Unit tests            =
    // ======================================

    @Test
    public void shouldFindAllWithADynamicQuery() throws Exception {

        Customer25 customer01 = new Customer25("Antony", "Balla", "tballa@mail.com", 14);
        Address25 address01 = new Address25("Procession St", "Paris", "75015", "FR");
        customer01.setAddress(address01);

        Customer25 customer02 = new Customer25("Vincent", "Johnson", "vj@mail.com", 45);
        Address25 address02 = new Address25("Ritherdon Rd", "London", "8QE", "UK");
        customer02.setAddress(address02);

        Customer25 customer03 = new Customer25("Sebastian", "Twenty", "seb@yamail.com", 58);
        Address25 address03 = new Address25("Inacio Alfama", "Lisbon", "A54", "PT");
        customer03.setAddress(address03);

        Customer25 customer04 = new Customer25("Frederic", "Riou", "fred@carmail.com", 41);
        Address25 address04 = new Address25("Jardins", "Sao Paulo", "345678", "BR");
        customer04.setAddress(address04);

        Customer25 customer05 = new Customer25("Vincent", "Dubosc", "vd@yahoo.com", 14);
        Address25 address05 = new Address25("Coffey", "Perth", "654F543", "AU");
        customer05.setAddress(address05);

        Customer25 customer06 = new Customer25("David", "Chene", "dch@yahoo.com", 89);
        Address25 address06 = new Address25("Harbour Bridge", "Sydney", "JHG3", "AU");
        customer06.setAddress(address06);

        // Persist the object
        tx.begin();
        em.persist(customer01);
        em.persist(customer02);
        em.persist(customer03);
        em.persist(customer04);
        em.persist(customer05);
        em.persist(customer06);
        tx.commit();

        // Query
        Query query = em.createQuery("select c from Customer25 c");
        List<Customer25> customers = query.getResultList();
        assertEquals(ALL, customers.size());

        query = em.createQuery("select c from Customer25 c");
        query.setMaxResults(3);
        assertEquals(3, query.getResultList().size());

        boolean someCriteria = true;
        String jpqlQuery = "select c from Customer25 c";
        if (someCriteria)
            jpqlQuery += " where c.firstName = 'Vincent'";
        query = em.createQuery(jpqlQuery);
        assertEquals(2, query.getResultList().size());

        jpqlQuery = "select c from Customer25 c";
        if (someCriteria)
            jpqlQuery += " where c.firstName = :fname";
        query = em.createQuery(jpqlQuery);
        query.setParameter("fname", "Vincent");
        assertEquals(2, query.getResultList().size());

        jpqlQuery = "select c from Customer25 c";
        if (someCriteria)
            jpqlQuery += " where c.firstName = ?1";
        query = em.createQuery(jpqlQuery);
        query.setParameter(1, "Vincent");
        assertEquals(2, query.getResultList().size());

        query = em.createQuery("select c from Customer25 c  where c.firstName = :fname");
        query.setParameter("fname", "Vincent");
        query.setMaxResults(1);
        assertEquals(1, query.getResultList().size());

        query = em.createQuery("select c from Customer25 c  where c.firstName = :fname").setParameter("fname", "Vincent").setMaxResults(1);
        assertEquals(1, query.getResultList().size());

        // TypedQuery
        TypedQuery<Customer25> typedQuery = em.createQuery("select c from Customer25 c", Customer25.class);
        customers = typedQuery.getResultList();
        assertEquals(ALL, customers.size());

        typedQuery = em.createQuery("select c from Customer25 c", Customer25.class);
        typedQuery.setMaxResults(3);
        assertEquals(3, typedQuery.getResultList().size());

        jpqlQuery = "select c from Customer25 c";
        if (someCriteria)
            jpqlQuery += " where c.firstName = 'Vincent'";
        typedQuery = em.createQuery(jpqlQuery, Customer25.class);
        assertEquals(2, typedQuery.getResultList().size());

        jpqlQuery = "select c from Customer25 c";
        if (someCriteria)
            jpqlQuery += " where c.firstName = :fname";
        typedQuery = em.createQuery(jpqlQuery, Customer25.class);
        typedQuery.setParameter("fname", "Vincent");
        assertEquals(2, typedQuery.getResultList().size());

        jpqlQuery = "select c from Customer25 c";
        if (someCriteria)
            jpqlQuery += " where c.firstName = ?1";
        typedQuery = em.createQuery(jpqlQuery, Customer25.class);
        typedQuery.setParameter(1, "Vincent");
        assertEquals(2, typedQuery.getResultList().size());

        typedQuery = em.createQuery("select c from Customer25 c  where c.firstName = :fname", Customer25.class);
        typedQuery.setParameter("fname", "Vincent");
        typedQuery.setMaxResults(1);
        assertEquals(1, typedQuery.getResultList().size());

        typedQuery = em.createQuery("select c from Customer25 c  where c.firstName = :fname", Customer25.class).setParameter("fname", "Vincent").setMaxResults(1);
        assertEquals(1, typedQuery.getResultList().size());

        // Remove objects
        tx.begin();
        em.remove(customer01);
        em.remove(customer02);
        em.remove(customer03);
        em.remove(customer04);
        em.remove(customer05);
        em.remove(customer06);
        tx.commit();

    }

    @Test
    public void shouldFindAllWithANamedQueries() throws Exception {

        Customer25 customer01 = new Customer25("Antony", "Balla", "tballa@mail.com", 14);
        Address25 address01 = new Address25("Procession St", "Paris", "75015", "FR");
        customer01.setAddress(address01);

        Customer25 customer02 = new Customer25("Vincent", "Johnson", "vj@mail.com", 45);
        Address25 address02 = new Address25("Ritherdon Rd", "London", "8QE", "UK");
        customer02.setAddress(address02);

        Customer25 customer03 = new Customer25("Sebastian", "Twenty", "seb@yamail.com", 58);
        Address25 address03 = new Address25("Inacio Alfama", "Lisbon", "A54", "PT");
        customer03.setAddress(address03);

        Customer25 customer04 = new Customer25("Frederic", "Riou", "fred@carmail.com", 41);
        Address25 address04 = new Address25("Jardins", "Sao Paulo", "345678", "BR");
        customer04.setAddress(address04);

        Customer25 customer05 = new Customer25("Vincent", "Dubosc", "vd@yahoo.com", 14);
        Address25 address05 = new Address25("Coffey", "Perth", "654F543", "AU");
        customer05.setAddress(address05);

        Customer25 customer06 = new Customer25("David", "Chene", "dch@yahoo.com", 89);
        Address25 address06 = new Address25("Harbour Bridge", "Sydney", "JHG3", "AU");
        customer06.setAddress(address06);

        // Persist the object
        tx.begin();
        em.persist(customer01);
        em.persist(customer02);
        em.persist(customer03);
        em.persist(customer04);
        em.persist(customer05);
        em.persist(customer06);
        tx.commit();

        // Query
        Query query = em.createNamedQuery("findAll");
        List<Customer25> customers = query.getResultList();
        assertEquals(ALL, customers.size());

        query = em.createNamedQuery(Customer25.FIND_ALL);
        assertEquals(ALL, query.getResultList().size());

        query = em.createNamedQuery("findAll");
        query.setMaxResults(3);
        assertEquals(3, query.getResultList().size());

        query = em.createNamedQuery("findVincent");
        assertEquals(2, query.getResultList().size());

        query = em.createNamedQuery("findWithParam");
        query.setParameter("fname", "Vincent");
        assertEquals(2, query.getResultList().size());

        // TypedQuery
        TypedQuery<Customer25> typedQuery = em.createNamedQuery("findAll", Customer25.class);
        customers = typedQuery.getResultList();
        assertEquals(ALL, customers.size());

        typedQuery = em.createNamedQuery(Customer25.FIND_ALL, Customer25.class);
        assertEquals(ALL, typedQuery.getResultList().size());

        typedQuery = em.createNamedQuery("findAll", Customer25.class);
        typedQuery.setMaxResults(3);
        assertEquals(3, typedQuery.getResultList().size());

        typedQuery = em.createNamedQuery("findVincent", Customer25.class);
        assertEquals(2, typedQuery.getResultList().size());

        typedQuery = em.createNamedQuery("findWithParam", Customer25.class);
        typedQuery.setParameter("fname", "Vincent");
        assertEquals(2, typedQuery.getResultList().size());

        // Remove objects
        tx.begin();
        em.remove(customer01);
        em.remove(customer02);
        em.remove(customer03);
        em.remove(customer04);
        em.remove(customer05);
        em.remove(customer06);
        tx.commit();
    }

    @Test
    public void shouldFindAllWithANativeQueries() throws Exception {

        Customer25 customer01 = new Customer25("Antony", "Balla", "tballa@mail.com", 14);
        Address25 address01 = new Address25("Procession St", "Paris", "75015", "FR");
        customer01.setAddress(address01);

        Customer25 customer02 = new Customer25("Vincent", "Johnson", "vj@mail.com", 45);
        Address25 address02 = new Address25("Ritherdon Rd", "London", "8QE", "UK");
        customer02.setAddress(address02);

        Customer25 customer03 = new Customer25("Sebastian", "Twenty", "seb@yamail.com", 58);
        Address25 address03 = new Address25("Inacio Alfama", "Lisbon", "A54", "PT");
        customer03.setAddress(address03);

        Customer25 customer04 = new Customer25("Frederic", "Riou", "fred@carmail.com", 41);
        Address25 address04 = new Address25("Jardins", "Sao Paulo", "345678", "BR");
        customer04.setAddress(address04);

        Customer25 customer05 = new Customer25("Vincent", "Dubosc", "vd@yahoo.com", 14);
        Address25 address05 = new Address25("Coffey", "Perth", "654F543", "AU");
        customer05.setAddress(address05);

        Customer25 customer06 = new Customer25("David", "Chene", "dch@yahoo.com", 89);
        Address25 address06 = new Address25("Harbour Bridge", "Sydney", "JHG3", "AU");
        customer06.setAddress(address06);

        // Persist the object
        tx.begin();
        em.persist(customer01);
        em.persist(customer02);
        em.persist(customer03);
        em.persist(customer04);
        em.persist(customer05);
        em.persist(customer06);
        tx.commit();

        // Query
        Query query = em.createNativeQuery("select * from EX25_CUSTOMER", Customer25.class);
        List<Customer25> customers = query.getResultList();
        assertEquals(ALL, customers.size());

//        query = em.createNativeQuery("findAllNative");
//        customers = query.getResultList();
//        assertEquals(ALL, customers.size());
//
//        query = em.createNativeQuery("select lastname from JPQL_EX01_CUSTOMER", String.class);
//        List<String> customersNames = query.getResultList();
//        assertEquals(ALL, customersNames.size());

        // Remove objects
        tx.begin();
        em.remove(customer01);
        em.remove(customer02);
        em.remove(customer03);
        em.remove(customer04);
        em.remove(customer05);
        em.remove(customer06);
        tx.commit();
    }

    @Test
    public void shouldExecuteSeveralDynamicQueries() throws Exception {

        Customer25 customer01 = new Customer25("Antony", "Balla", "tballa@mail.com", 14);
        Address25 address01 = new Address25("Procession St", "Paris", "75015", "FR");
        customer01.setAddress(address01);

        Customer25 customer02 = new Customer25("Vincent", "Johnson", "vj@mail.com", 45);
        Address25 address02 = new Address25("Ritherdon Rd", "London", "8QE", "UK");
        customer02.setAddress(address02);

        Customer25 customer03 = new Customer25("Sebastian", "Twenty", "seb@yamail.com", 58);
        Address25 address03 = new Address25("Inacio Alfama", "Lisbon", "A54", "PT");
        customer03.setAddress(address03);

        Customer25 customer04 = new Customer25("Frederic", "Riou", "fred@carmail.com", 41);
        Address25 address04 = new Address25("Jardins", "Sao Paulo", "345678", "BR");
        customer04.setAddress(address04);

        Customer25 customer05 = new Customer25("Vincent", "Dubosc", "vd@yahoo.com", 14);
        Address25 address05 = new Address25("Coffey", "Perth", "654F543", "AU");
        customer05.setAddress(address05);

        Customer25 customer06 = new Customer25("David", "Chene", "dch@yahoo.com", 89);
        Address25 address06 = new Address25("Harbour Bridge", "Sydney", "JHG3", "AU");
        customer06.setAddress(address06);

        // Persist the object
        tx.begin();
        em.persist(customer01);
        em.persist(customer02);
        em.persist(customer03);
        em.persist(customer04);
        em.persist(customer05);
        em.persist(customer06);
        tx.commit();

        Query query = em.createQuery("select c from Customer25 c");
        assertEquals(ALL, query.getResultList().size());

        query = em.createQuery("select c.firstName from Customer25 c");
        assertEquals(ALL, query.getResultList().size());

        query = em.createQuery("select LOWER(c.firstName) from Customer25 c");
        assertEquals(ALL, query.getResultList().size());

        query = em.createQuery("select c.firstName, c.lastName  from Customer25 c");
        assertEquals(ALL, query.getResultList().size());

        query = em.createQuery("select distinct c.firstName from Customer25 c");
        assertEquals(ALL - 1, query.getResultList().size());

        query = em.createQuery("select c from Customer25 c where c.firstName = 'Vincent'");
        assertEquals(2, query.getResultList().size());

        query = em.createQuery("select c.address from Customer25 c where c.firstName = 'Vincent'");
        assertEquals(2, query.getResultList().size());

        query = em.createQuery("select c from Customer25 c where c.address.country = 'AU'");
        assertEquals(2, query.getResultList().size());

        query = em.createQuery("select new org.agoncal.book.javaee6.chapter04.ex25.CustomerDTO25(c.firstName, c.lastName, c.address.country) from Customer25 c where c.firstName = 'Vincent'");
        assertEquals(2, query.getResultList().size());

        query = em.createQuery("select count(c) from Customer25 c where c.firstName = 'Vincent'");
        assertEquals(2L, query.getSingleResult());

        query = em.createQuery("select c from Customer25 c where c.age > 40");
        assertEquals(4, query.getResultList().size());

        query = em.createQuery("select c from Customer25 c where c.age between 40 and 50");
        assertEquals(2, query.getResultList().size());

        query = em.createQuery("select c from Customer25 c where c.age not between 40 and 50");
        assertEquals(4, query.getResultList().size());

        query = em.createQuery("select c from Customer25 c where c.address.country in ('UK', 'FR')");
        assertEquals(2, query.getResultList().size());

        query = em.createQuery("select c from Customer25 c where c.email like '%mail.com'");
        assertEquals(4, query.getResultList().size());

        query = em.createQuery("select min(c.age) from Customer25 c");
        assertEquals(14, query.getSingleResult());

        query = em.createQuery("select c.address.country, count(c) from Customer25 c group by c.address.country");
        assertEquals(5, query.getResultList().size());

        query = em.createQuery("select c.address.country, count(c) from Customer25 c group by c.address.country having c.address.country <> 'UK'");
        assertEquals(4, query.getResultList().size());

        query = em.createQuery("select c from Customer25 c where c.age = (select min(cust.age) from Customer25 cust)");
        assertEquals(2, query.getResultList().size());

        tx.begin();
        query = em.createQuery("update Customer25 c set c.firstName = 'TOO YOUNG' where c.age < 18");
        assertEquals(2, query.executeUpdate());
        tx.commit();

        tx.begin();
        query = em.createQuery("delete from Customer25 c where c.age < 18");
        assertEquals(2, query.executeUpdate());
        tx.commit();

        // Remove objects
        tx.begin();
        em.remove(customer01);
        em.remove(customer02);
        em.remove(customer03);
        em.remove(customer04);
        em.remove(customer05);
        em.remove(customer06);
        tx.commit();
    }

    @Test
    public void shouldExecuteCaseQueries() throws Exception {

        Book25 book01 = new Book25("The Hitchhiker's Guide to the Galaxy", 12F, "The Hitchhiker's Guide to the Galaxy is a science fiction comedy series created by Douglas Adams.", "1-84023-742-2", 354, false, "Apress");
        Book25 book02 = new Book25("Java EE 6", 50F, "Learn about EE 6", "2-84023-742-2", 450, true, "Apress");
        Book25 book03 = new Book25("Narcisse and Golmund", 10F, "One of the best Herman Hesse book", "3-84023-742-2", 153, false, "Pinguin");

        // Persist the object
        tx.begin();
        em.persist(book01);
        em.persist(book02);
        em.persist(book03);
        tx.commit();

        Query query = em.createQuery("select b.price from Book25 b order by b.isbn");
        List<Float> prices = query.getResultList();
        assertEquals(3, prices.size());
        assertEquals(new Float(12F), prices.get(0));
        assertEquals(new Float(50F), prices.get(1));
        assertEquals(new Float(10F), prices.get(2));


// TODO should work but not with Derby
// TODO query = em.createQuery("SELECT CASE b.editor WHEN 'Apress' THEN b.price * 0.5 ELSE b.price * 0.8 END FROM Book25 b ORDER BY b.isbn ASC");

        query = em.createQuery("SELECT CASE WHEN b.editor ='Apress' THEN b.price * 0.5 ELSE b.price * 0.8 END FROM Book25 b ORDER BY b.isbn ASC");
        prices = query.getResultList();
        assertEquals(3, prices.size());
        assertEquals("12 * 0.5 = 6", new Double(6), prices.get(0));
        assertEquals("50 * 0.5 = 25", new Double(25), prices.get(1));
        assertEquals("10 * 0.8 = 8", new Double(8), prices.get(2));

        // Remove objects
        tx.begin();
        em.remove(book01);
        em.remove(book02);
        em.remove(book03);
        tx.commit();
    }
}

