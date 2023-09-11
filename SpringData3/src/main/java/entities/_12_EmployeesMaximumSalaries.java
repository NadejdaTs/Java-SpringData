package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class _12_EmployeesMaximumSalaries {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        //TODO
        /*SELECT d.name, MAX(salary) maxSalary FROM Employees e
        JOIN departments d ON e.department_id = d.department_id
        GROUP BY e.department_id
        HAVING maxSalary not between 30000 and 70000;*/

        List<Employee> resultList = em.createQuery("SELECT d.name as names, MAX(e.salary) as maxSalary FROM Employee e" +
                        " GROUP BY e.id", Employee.class)
                .getResultList();

        resultList.stream().forEach(e -> System.out.println(e.getSalary()));

        em.getTransaction().commit();
        em.close();
    }
}
