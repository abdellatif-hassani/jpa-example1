package net.hassani.test;

import jakarta.persistence.EntityManagerFactory;
import net.hassani.dao.CompteRepository;
import net.hassani.entities.Compte;
import net.hassani.entities.TypeCompte;

import jakarta.persistence.EntityManager;
import net.hassani.utils.EntityManagerFactorySingleton;

import java.util.List;

public class TestJpa {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = EntityManagerFactorySingleton.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CompteRepository compteRepository = new CompteRepository(entityManager);
        Compte compte = new Compte(null, 1000, "2021-09-01", TypeCompte.COURANT);
        compteRepository.save(compte);
        System.out.println("*****************");
        List<Compte> listComptes = compteRepository.findAll();
        listComptes.forEach(System.out::println);
        System.out.println("*****************");
        //Account with the highest balance
        System.out.println("*****************");
        Compte compteWithMaxSolde = compteRepository.getCompteWithMaxSolde();
        System.out.println(compteWithMaxSolde);
        System.out.println("*****************");
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-example");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//        Compte compte = new Compte(null, 1000, "2021-09-01", TypeCompte.COURANT);
//        entityManager.persist(compte);
//        transaction.commit();
//
//        //Getting the object from the database
//        Compte compte1 = entityManager.find(Compte.class, 1L);
//        System.out.println("*****************");
//        System.out.println(compte1);
//        System.out.println("*****************");
//
//        entityManager.close();
//        entityManagerFactory.close();

    }
}
