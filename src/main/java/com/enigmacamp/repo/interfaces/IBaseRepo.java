package com.enigmacamp.repo.interfaces;

import jakarta.persistence.EntityManager;

import java.util.List;

public interface IBaseRepo <T>{
    Boolean create(EntityManager em, T data);
    List<T> getRows();
    T getRow();
    Boolean update(Integer id);
    Boolean delete(Integer id);
}
