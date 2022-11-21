package com.enigmacamp.repo.interfaces;

import jakarta.persistence.EntityManager;

import java.util.List;

public interface IBaseRepo <T>{
    void create(EntityManager em, T data);
    List<T> getRows();
    T getRow(EntityManager em, String id);
    void update(EntityManager em, String id);
    void delete(EntityManager em, String id);
}
