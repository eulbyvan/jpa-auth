package com.enigmacamp.repo;

import java.util.List;

public interface IBaseRepo <T>{
    void create();
    List<T> getRows();
    T getRow();
    void update(Integer id);
    void delete(Integer id);
}
