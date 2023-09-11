package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class _11_FindEmployeesByFirstName {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Scanner sc = new Scanner(System.in);
        String nameStartedWith = sc.nextLine() + "%";

        List<Employee> employeeResult = em.createQuery("SELECT e FROM Employee e" +
                        " WHERE e.firstName LIKE :nameStartedWith", Employee.class)
                .setParameter("nameStartedWith", nameStartedWith)
                .getResultList();

        employeeResult.stream()
                        .forEach(e -> System.out.printf("%s %s - %s - ($%.2f)%n",
                                e.getFirstName(), e.getLastName(), e.getJobTitle(), e.getSalary()));

        em.getTransaction().commit();
        em.close();
    }
}
