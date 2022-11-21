package com.enigmacamp.service.implementations;

import com.enigmacamp.model.User;
import com.enigmacamp.repo.implementations.UserRepo;
import com.enigmacamp.service.interfaces.IUserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UserService implements IUserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void signUp(EntityManager em, User user) {
        userRepo.create(em, user);
    }

    @Override
    public List<User> findUsers() {
        return null;
    }

    @Override
    public User findUser(EntityManager em, String username) {
        return userRepo.getRow(em, username);
    }

    @Override
    public void editUser(EntityManager em, User user) {
    }

    @Override
    public void deleteUser(EntityManager em, User user) {
    }

    @Override
    public Boolean userAuth(EntityManager em, String username, String password) {
        User user = findUser(em, username);

        String dbUsername = user.getUsername();
        String dbPassword = user.getPassword();

        return username.equals(dbUsername) && password.equals(dbPassword);
    }
}
