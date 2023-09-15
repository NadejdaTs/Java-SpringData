package entitiesRelationships;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("onlyTest");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        ProductionBatch batch = new ProductionBatch(LocalDate.now());
        BasicLabel label = new BasicLabel("blue");
        BasicShampoo shampoo = new BasicShampoo("shower", label, batch);

        BasicIngredient ingredient = new BasicIngredient(100, "B12");
        BasicIngredient ingredient2 = new BasicIngredient(2, "Violet");

        shampoo.addIngredient(ingredient);
        shampoo.addIngredient(ingredient2);

        List<String> names = Arrays.asList("Syoss", "Wash&Go", "Aroma");
        shampoo.setNames(names);

        em.persist(ingredient);
        em.persist(ingredient2);
        em.persist(batch);
        em.persist(label);
        em.persist(shampoo);
//        em.getTransaction().commit();

        ProductionBatch productionBatch = em.find(ProductionBatch.class, 1);
        Set<BasicShampoo> shampoos = productionBatch.getShampoos();
        shampoos.forEach(System.out::println);

        em.getTransaction().commit();
    }
}
