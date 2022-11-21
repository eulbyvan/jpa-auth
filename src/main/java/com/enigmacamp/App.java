package com.enigmacamp;

import com.enigmacamp.console.MasterMenu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
            EntityManager em = emf.createEntityManager();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            MasterMenu.run();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
