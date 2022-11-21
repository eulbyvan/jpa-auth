package com.enigmacamp;

import com.enigmacamp.console.MasterMenu;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        try {
            MasterMenu.run();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
