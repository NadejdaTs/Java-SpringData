package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class _08_GetEmployeeWithProject {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Scanner sc = new Scanner(System.in);
        int employeeId = Integer.parseInt(sc.nextLine());

        Employee employee = em.createQuery("SELECT e FROM Employee e" +
                        " WHERE e.id = :employeeId", Employee.class)
                .setParameter("employeeId", employeeId)
                .getSingleResult();

        System.out.printf("%s %s - %s%n",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle());

        employee.getProjects().stream()
                .sorted(Comparator.comparing(p -> p.getName()))
                .forEach(p -> System.out.println("\t" + p.getName()));

        em.getTransaction().commit();
        em.close();
    }
}
