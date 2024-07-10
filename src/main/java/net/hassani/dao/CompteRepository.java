package net.hassani.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import net.hassani.entities.Compte;

import java.util.List;

public class CompteRepository implements ICompteRespository{
    private EntityManager entityManager;

    public CompteRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Compte save(Compte compte) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(compte);
        transaction.commit();
        System.out.println("Compte saved");
        return compte;
    }

    @Override
    public List<Compte> findAll() {
        List<Compte> listComptes = entityManager.createQuery("SELECT c FROM Compte c").getResultList();
        return listComptes;
    }

    @Override
    public Compte findById(Long id) {
        return entityManager.find(Compte.class, id);
    }

    @Override
    public List<Compte> findByType(String type) {
        return entityManager.createQuery("SELECT c FROM Compte c WHERE c.type = :type").setParameter("type", type).getResultList();
    }

    @Override
    public Compte update(Compte compte) {
        return entityManager.merge(compte);
    }

    @Override
    public void delete(Long id) {
        Compte compte = entityManager.find(Compte.class, id);
        entityManager.remove(compte);
    }
    //Account with the highest balance
    public Compte getCompteWithMaxSolde() {
        return (Compte) entityManager.createNamedQuery("getCompteWithMaxSolde").getSingleResult();
    }
}
