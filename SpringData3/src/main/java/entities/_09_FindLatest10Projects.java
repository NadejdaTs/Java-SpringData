package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class _09_FindLatest10Projects {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        List<Project> projectResult = em.createQuery("SELECT p FROM Project p" +
                        " ORDER BY p.startDate DESC, p.name ASC", Project.class)
                .setMaxResults(3)
                .getResultList();

        projectResult.stream()
                        .forEach(p -> System.out.printf("Project name: %s%n" +
                                        "Project Description: %s%n" +
                                        "Project Start Date: %s%n" +
                                        "Project End Date: %s%n",
                                p.getName(), p.getDescription(), p.getStartDate(), p.getEndDate()));

        em.getTransaction().commit();
        em.close();
    }
}
