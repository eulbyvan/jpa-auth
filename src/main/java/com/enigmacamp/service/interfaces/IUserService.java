package com.enigmacamp.service.interfaces;

import com.enigmacamp.model.User;
import jakarta.persistence.EntityManager;

import java.util.List;

public interface IUserService {
    void signUp(EntityManager em, User user);
    List<User> findUsers();
    User findUser(EntityManager em, String username);
    void editUser(EntityManager em, User user);
    void deleteUser(EntityManager em, User user);
    Boolean userAuth(EntityManager em, String username, String password);
}
