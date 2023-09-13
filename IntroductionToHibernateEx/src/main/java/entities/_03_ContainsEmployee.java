package entities;

import entitiesLab.Student;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_ContainsEmployee {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Scanner sc = new Scanner(System.in);
        String[] searchFor = sc.nextLine().split(" ");

        /*Employee result = em.createQuery("SELECT e FROM Employee e WHERE e.firstName = :first_name "+
                "AND e.lastName = :last_name",
                Employee.class)
                .setParameter("first_name", searchFor[0])
                .setParameter("last_name", searchFor[1])
                .getSingleResult();*/

        Long result = em.createQuery("SELECT COUNT(e) FROM Employee e WHERE e.firstName = :first_name "+
                                "AND e.lastName = :last_name",
                        Long.class)
                .setParameter("first_name", searchFor[0])
                .setParameter("last_name", searchFor[1])
                .getSingleResult();

        if(result > 0) {
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

        em.getTransaction().commit();
        em.close();
    }
}
