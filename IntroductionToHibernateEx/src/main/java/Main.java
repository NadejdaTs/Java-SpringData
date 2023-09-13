import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Town town = em.find(Town.class, 1);
        System.out.println(town);

        em.getTransaction().commit();
    }
}
