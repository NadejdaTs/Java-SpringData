package _04_HospitalDatabase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class _04Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HospitalEx");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Diagnose diagnose1 = new Diagnose("Migrena", "Hard headache");
        Diagnose diagnose2 = new Diagnose("Broken leg", "Patient broke his left leg.");
        Set<Diagnose> diagnoses = new HashSet<>();
        diagnoses.add(diagnose1);
        diagnoses.add(diagnose2);

        Medicament medicament1 = new Medicament("Analgin");
        Medicament medicament2 = new Medicament("Aulin");
        Medicament medicament3 = new Medicament("Benalgin");
        Set<Medicament> headMedicaments = new HashSet<>();
        Set<Medicament> strongPainMedicaments = new HashSet<>();
        headMedicaments.add(medicament1);
        headMedicaments.add(medicament3);
        strongPainMedicaments.add(medicament2);

        Patient patient1 = new Patient("Todorka", "Atanasova", "Sofia", "todorka@mail.bg",
                LocalDate.of(1980, 3, 5), null, true);
        Patient patient2 = new Patient("Petko", "Todorov", "Plovdiv", "petko123@mail.bg",
                LocalDate.of(1988, 11, 8), null, true);

        Visitation visitation = new Visitation(LocalDate.now(), "Monday visitation.");
        Set<Visitation> visitations = new HashSet<>();
        visitations.add(visitation);

        em.persist(diagnose1);
        em.persist(diagnose2);
        em.persist(medicament1);
        em.persist(medicament2);
        em.persist(medicament3);
        em.persist(visitation);

        patient1.setDiagnose(diagnose1);
        patient1.setMedicaments(headMedicaments);
        patient1.setVisitations(visitations);
        em.persist(patient1);

        patient2.setDiagnose(diagnose2);
        patient2.setMedicaments(strongPainMedicaments);
        patient2.setVisitations(visitations);
        em.persist(patient2);

        //em.flush();
        em.getTransaction().commit();
        em.close();
    }
}
