package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class _04_RichEmployees {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        List<String> result = em.createQuery("SELECT e.firstName FROM Employee e WHERE e.salary > 50000",
                        String.class)
                .getResultList();

        for (String r : result) {
            System.out.println(r);
        }

        em.getTransaction().commit();
        em.close();
    }
}
