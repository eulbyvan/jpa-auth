package com.enigmacamp.service.implementations;

import com.enigmacamp.model.User;
import com.enigmacamp.repo.implementations.UserRepo;
import com.enigmacamp.service.interfaces.IUserService;
import com.enigmacamp.util.PasswordEncrypt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UserService implements IUserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void signUp(User user) {
        userRepo.create(user);
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

        String decryptedDbPassword = PasswordEncrypt.startDecrypt(dbPassword);

        System.out.println("== decrypted pass ==");
        System.out.println(decryptedDbPassword);
        System.out.println("== password ==");
        System.out.println(password);

        if (username.equals(dbUsername) && password.equals(decryptedDbPassword)) {
            System.out.println("hi, " + username);
            return true;
        }

        return false;
    }
}
