package com.example.ahnafsadi_cvbuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseHelper {

    private static final String DB_URL = "jdbc:sqlite:cv.db";
    private static Connection connection;

    public static void initDataBase() {
        try {
            // Load SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");
            
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL);
                String create = "CREATE TABLE IF NOT EXISTS cv (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "name TEXT, email TEXT, phone TEXT, address TEXT," +
                        "education TEXT, skills TEXT, work TEXT, project TEXT, image_path TEXT" +
                        ")";
                try (Statement stmt = connection.createStatement()) {
                    stmt.execute(create);
                }
                System.out.println("Database initialized successfully: cv.db");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("SQLite JDBC driver not found: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Failed to initialize database: " + e.getMessage());
            e.printStackTrace();
        }
    }

}

