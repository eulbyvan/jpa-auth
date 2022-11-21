package com.enigmacamp.service.implementations;

import com.enigmacamp.model.User;
import com.enigmacamp.repo.implementations.UserRepo;
import com.enigmacamp.service.interfaces.IUserService;
import jakarta.persistence.EntityManager;

import java.util.List;

public class UserService implements IUserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Boolean signUp(EntityManager em, User user) {
        return userRepo.create(em, user);
    }

    @Override
    public List<User> findUsers() {
        return null;
    }

    @Override
    public User findUser() {
        return null;
    }

    @Override
    public Boolean editUser(Integer id) {
        return null;
    }

    @Override
    public Boolean deleteUser(Integer id) {
        return null;
    }
}
