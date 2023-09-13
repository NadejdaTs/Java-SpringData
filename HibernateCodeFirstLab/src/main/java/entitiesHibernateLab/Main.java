package entitiesHibernateLab;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name1");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Bike bike = new Bike(21);
        Car car = new Car(5);
        Truck truck = new Truck(2500, 40000);

        em.persist(bike);
        em.persist(car);
        em.persist(truck);

        em.getTransaction().commit();
        em.close();
    }
}
