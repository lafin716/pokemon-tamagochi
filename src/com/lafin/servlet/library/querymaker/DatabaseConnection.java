package com.lafin.servlet.library.querymaker;

import java.sql.*;

public class DatabaseConnection {

    private DatabaseConfig config;

    private Connection connection = null;

    public DatabaseConnection(DatabaseConfig config) {
        this.config = config;
        connect();
    }

    private void connect() {
        try {
            Class.forName(config.getDriver());
            connection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            connection = null;
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
