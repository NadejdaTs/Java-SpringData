package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class _07_AddressWithEmpCnt {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.createQuery("FROM Address a" +
                        " ORDER BY a.employees.size DESC ",
                        Address.class)
                .setMaxResults(10)
                .getResultStream()
                .forEach(System.out::println);

        em.getTransaction().commit();
        em.close();
    }
}
