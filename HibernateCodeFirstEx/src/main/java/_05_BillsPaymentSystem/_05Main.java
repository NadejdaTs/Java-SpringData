package _05_BillsPaymentSystem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.Month;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;

public class _05Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Payments_Ex");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        User user1 = new User("Todorka", "Petrova", "todorka@mail.bg", "rola12");
        User user2 = new User("Petko", "Todorov", "petko@mail.bg", "pass12");
        em.persist(user1);
        em.persist(user2);

        BankAccount bankAccount = new BankAccount(123, user1,  "UBB", "SWIFT");
        CreditCard creditCard = new CreditCard(133, user2, "Visa", Month.DECEMBER, Year.now());
        Set<BillingDetails> billingDetails1 = new HashSet<>();
        //Set<BillingDetails> billingDetails2 = new HashSet<>();
        billingDetails1.add(bankAccount);
        billingDetails1.add(creditCard);
//        billingDetails2.add(creditCard);
        em.persist(bankAccount);
        em.persist(creditCard);



        em.getTransaction().commit();
        em.close();
    }
}
