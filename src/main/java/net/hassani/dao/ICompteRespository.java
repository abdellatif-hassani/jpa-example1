package net.hassani.dao;

import net.hassani.entities.Compte;

import java.util.List;

public interface ICompteRespository extends IRepository<Compte, Long>{
    Compte save(Compte compte);
    List<Compte> findAll();
    Compte findById(Long id);
    List<Compte> findByType(String type);
    Compte update(Compte compte);
    void delete(Long id);
}
