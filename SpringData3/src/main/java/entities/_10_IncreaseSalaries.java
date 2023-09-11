package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class _10_IncreaseSalaries {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        List<Department> departmentResult = em.createQuery("SELECT d FROM Department d" +
                        " WHERE id in (1, 2, 4, 11)", Department.class)
                .getResultList();

        em.createQuery("UPDATE Employee e" +
                        " SET e.salary = e.salary + (e.salary * 0.12)" +
                        " WHERE e.department in :departmentResult")
                .setParameter("departmentResult", departmentResult)
                .executeUpdate();

        em.getTransaction().commit();
        em.close();

        EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em1 = emf1.createEntityManager();

        em1.getTransaction().begin();

        //Make another transaction and EMF to refresh the result into the output message
        List<Employee> employeeResult = em1.createQuery("SELECT e FROM Employee e" +
                        " WHERE e.department in :departmentResult", Employee.class)
                .setParameter("departmentResult", departmentResult)
                .getResultList();

        employeeResult.stream()
                .forEach(e -> System.out.printf("%s %s ($%.2f)%n",e.getFirstName(), e.getLastName(), e.getSalary()));


        em1.getTransaction().commit();
        em1.close();
    }
}
