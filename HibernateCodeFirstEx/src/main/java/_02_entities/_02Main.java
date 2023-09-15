package _02_entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class _02Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CodeFirst");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Product product = new Product("asd", 123, BigDecimal.TEN);
        Customer customer = new Customer("customer", "customer", "asd");
        StoreLocation location = new StoreLocation("location");
        Sale sale = new Sale(product, customer, location);

        em.persist(product);
        em.persist(customer);
        em.persist(location);
        em.persist(sale);

        em.getTransaction().commit();
        em.close();
    }
}
