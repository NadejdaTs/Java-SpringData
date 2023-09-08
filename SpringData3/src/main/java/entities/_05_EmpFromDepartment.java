package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class _05_EmpFromDepartment {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        String department = "Research and Development";

        em.createQuery("SELECT e FROM Employee e" +
                        " WHERE e.department.name = :departmentName" +
                        //" WHERE d.name = :departmentName" +
                        " ORDER BY e.salary ASC, e.id ASC",
                        Employee.class)
                .setParameter("departmentName", department)
                .getResultStream()
                .forEach(e -> {
                    String format = String.format("%s %s from %s - $%f",
                            e.getFirstName(), e.getLastName(), department, e.getSalary());
                    System.out.println(format);
                });

        em.getTransaction().commit();
        em.close();
    }
}
