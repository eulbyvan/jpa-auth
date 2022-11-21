package com.enigmacamp.console;

import com.enigmacamp.model.User;
import com.enigmacamp.repo.implementations.UserRepo;
import com.enigmacamp.service.implementations.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.SQLException;
import java.util.Scanner;

public abstract class MasterMenu {
    private static final Scanner in = new Scanner(System.in);
    private static Boolean isClosed = false;
    private static final EntityManager em = createEM();
    private static final UserRepo userRepo = new UserRepo();
    private static final UserService userService = new UserService(userRepo);
    private static String selectMenu() {
        String menu =   "\n=== main menu ===\n"
                        + "\n1. sign up\n"
                        + "2. sign in\n"
                        + "0. exit\n";
        System.out.println(menu);

        System.out.print("select menu : ");

        return in.nextLine();
    }

    public static void run() throws SQLException {
        System.out.println("=== JPA Authentication ===");
        startMenu();
    }

    private static void startMenu() throws SQLException {
        String selectedMenu = selectMenu();
        String selectedSubMenu;

        while (!isClosed) {
            try {
                if (selectedMenu.equalsIgnoreCase("1")) {
                    System.out.println("\n=== sign up ===");

                    System.out.print("enter new username: ");
                    String createUsername = in.nextLine();

                    System.out.print("enter new password: ");
                    String createPassword = in.nextLine();

                    User createUser = new User();

                    try {
                        createUser.setUsername(createUsername);
                        createUser.setPassword(createPassword);
                        createUser.setLocked(Boolean.FALSE);
                        userService.signUp(em, createUser);
                        System.out.println("new user added");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    } finally {
                        em.close();
                    }

                    startMenu();
                } else if (selectedMenu.equalsIgnoreCase("2")) {
                    System.out.println("\n=== sign in ===");

                    System.out.print("enter username: ");
                    String inputUsername = in.nextLine();

                    System.out.print("enter password: ");
                    String inputPassword = in.nextLine();

                    try {
                        userService.userAuth(em, inputUsername, inputPassword);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    } finally {
                        em.close();
                    }

                    startMenu();
                } else if (selectedMenu.equalsIgnoreCase("0")) {
                    System.out.println("\n=== goodbye ===");
                    isClosed = true;
                    break;
                } else {
                    System.err.println("invalid input\n");
                    startMenu();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                startMenu();
            }
        }
    }

    public static EntityManager createEM(){
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

            return emf.createEntityManager();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
