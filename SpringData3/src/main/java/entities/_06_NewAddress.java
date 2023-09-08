package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class _06_NewAddress {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        String addressText = "Vitoshka 156";
        Address address = new Address();
        address.setText(addressText);
        em.persist(address);

        Scanner sc = new Scanner(System.in);
        String lastName = sc.nextLine();

        /*Employee emp = em.createQuery("SELECT e FROM Employee e" +
                                " WHERE e.lastName = :lastName",
                        Employee.class)
                .setParameter("lastName", lastName)
                .getSingleResult();*/
        em.createQuery("UPDATE Employee e" +
                                " SET e.address =:address" +
                                " WHERE e.lastName = :lastName")
                .setParameter("lastName", lastName)
                .setParameter("address", address)
                .executeUpdate();

        em.getTransaction().commit();
        em.close();
    }
}
