package com.enigmacamp.repo.implementations;

import com.enigmacamp.model.User;
import com.enigmacamp.repo.interfaces.IUserRepo;
import jakarta.persistence.EntityManager;

import java.util.List;

public class UserRepo implements IUserRepo {

    @Override
    public Boolean create(EntityManager em, User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public List<User> getRows() {
        return null;
    }

    @Override
    public User getRow() {
        return null;
    }

    @Override
    public Boolean update(Integer id) {
        return true;
    }

    @Override
    public Boolean delete(Integer id) {
        return true;
    }
}
