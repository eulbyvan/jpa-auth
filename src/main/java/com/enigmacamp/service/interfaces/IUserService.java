package com.enigmacamp.service.interfaces;

import com.enigmacamp.model.User;
import jakarta.persistence.EntityManager;

import java.util.List;

public interface IUserService {
    Boolean signUp(EntityManager em, User user);
    List<User> findUsers();
    User findUser();
    Boolean editUser(Integer id);
    Boolean deleteUser(Integer id);
}
