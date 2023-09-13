package entitiesLab;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");

        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        Student student = new Student("Simona", 25);
        Student student2 = new Student("Lili", 37);
        entityManager.persist(student);
        entityManager.persist(student2);
        //Student stToRemove = entityManager.find(Student.class, 2);
        //entityManager.remove(stToRemove);
        Teacher teacher = new Teacher("Tamara", LocalDate.now());
        teacher.setName("Sara");
        entityManager.persist(teacher);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
