package com.enigmacamp.repo.implementations;

import com.enigmacamp.model.User;
import com.enigmacamp.repo.interfaces.IUserRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UserRepo implements IUserRepo {
    private final EntityManager em;

    public UserRepo(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public List<User> getRows() {
        return null;
    }

    @Override
    public User getRow(EntityManager em, String username) {
        TypedQuery<User> typedQuery = em.createNamedQuery("User.findById", User.class);

        typedQuery.setParameter("id", username);

        return typedQuery.getSingleResult();
    }

    @Override
    public void update(EntityManager em, String id) {
    }

    @Override
    public void delete(EntityManager em, String id) {
    }
}
