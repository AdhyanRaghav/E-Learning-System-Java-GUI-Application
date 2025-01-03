package com.elearning.services;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseService {
    private static final String URL = "jdbc:mysql://localhost:3306/elearning";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Database connection failed.");
        }
    }
}
