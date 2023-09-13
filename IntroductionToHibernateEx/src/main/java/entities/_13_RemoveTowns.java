package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class _13_RemoveTowns {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Scanner sc = new Scanner(System.in);
        String city = sc.nextLine();

        // Id of Town
        Integer idOfTown = em.createQuery("SELECT t.id FROM Town t" +
                        " WHERE t.name = :city", Integer.class)
                .setParameter("city", city)
                .getSingleResult();

        // Town Record
        List<Town> towns = em.createQuery("SELECT t FROM Town t" +
                        " WHERE t.name is :city", Town.class)
                .setParameter("city", city)
                .getResultList();

        // All addresses for this Town
        List<Integer> addressesIds = em.createQuery("SELECT a.id FROM Address a" +
                            " WHERE a.town = :town", Integer.class)
                    .setParameter("town", towns.get(0))
                    .getResultList();

        for (Integer addressesId : addressesIds) {
            // Address record
            List<Address> addresses = em.createQuery("SELECT a FROM Address a" +
                            " WHERE id = :addressId", Address.class)
                    .setParameter("addressId", addressesId)
                    .getResultList();
            for (Address address : addresses) {
                EntityManagerFactory emfUpdate = Persistence.createEntityManagerFactory("soft_uni");
                EntityManager emUp = emfUpdate.createEntityManager();

                emUp.getTransaction().begin();

                //Remove connection with address_id from Employee
                emUp.createQuery("UPDATE Employee e" +
                                " SET e.address = null" +
                                " WHERE e.address = :address")
                        .setParameter("address", address)
                        .executeUpdate();

                emUp.getTransaction().commit();
                emUp.close();

                EntityManagerFactory emfUpdate1 = Persistence.createEntityManagerFactory("soft_uni");
                EntityManager emUp1 = emfUpdate1.createEntityManager();

                emUp1.getTransaction().begin();

                // Remove Address record
                emUp1.createQuery("DELETE Address a" +
                                " WHERE a.id = :addressesId")
                        .setParameter("addressesId", addressesId)
                        .executeUpdate();
                emUp1.getTransaction().commit();
                emUp1.close();
            }
        }
        em.getTransaction().commit();
        em.close();

        EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em2 = emf2.createEntityManager();

        em2.getTransaction().begin();

        // Remove town
        em2.createQuery("DELETE Town t" +
                        " WHERE t.id = :idOfTown")
                .setParameter("idOfTown", idOfTown)
                .executeUpdate();

        System.out.printf("%d address in %s deleted%n", addressesIds.size(), city);

        em2.getTransaction().commit();
        em2.close();
    }
}
