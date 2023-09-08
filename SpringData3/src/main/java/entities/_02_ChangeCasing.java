package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class _02_ChangeCasing {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate_intro");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query fromTown = em.createQuery("SELECT t FROM Town t", Town.class);
        List<Town> resultList = fromTown.getResultList();

        for (Town town : resultList) {
            String name = town.getName();
            if(town.getName().length() <= 5){
                String newName = name.toUpperCase();
                town.setName(newName);
                em.persist(town);

            }
            System.out.println(name);
        }

        //for test
        /*Town town1 = new Town("Sofia");
        Town town2 = new Town("Plovdiv");
        Town town3 = new Town("Burgas");

        em.persist(town1);
        em.persist(town2);
        em.persist(town3);
        Town town = em.find(Town.class, 1);
        System.out.println(town);*/

        em.getTransaction().commit();
        em.close();
    }
}
