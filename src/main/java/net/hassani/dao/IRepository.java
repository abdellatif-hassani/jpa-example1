package net.hassani.dao;

import net.hassani.entities.Compte;

import java.util.List;

public interface IRepository<T, ID>{
    Compte save(T t);
    List<T> findAll();
    T findById(ID id);
    T update(T t);
    void delete(ID id);
}
