package com.lafin.servlet.util;

import java.sql.*;

public class DBUtil {

    private Connection conn = null;

    private Statement stmt = null;

    private ResultSet rs = null;

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final String DB_URL = "jdbc:mysql://localhost:3306/pokemon_tamagochi";

    private static final String USERNAME = "pokemon";

    private static final String PASSWORD = "poke12#$";

    public ResultSet select(String sql) {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            return rs;
        } catch(Exception e) {
            e.printStackTrace();
            try {
                stmt.close();
                conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }

            stmt = null;
            conn = null;
        }

        return null;
    }

    public boolean insert(String sql) {
        var result = false;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            result = stmt.execute(sql);

            return result;
        } catch(Exception ex) {
            ex.printStackTrace();
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            stmt = null;
            conn = null;
        }

        return result;
    }

    public void resultSetClose() {
        try {
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            rs = null;
            stmt = null;
            conn = null;
        }
    }

    public void insertClose() {
        try {
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            stmt = null;
            conn = null;
        }
    }
}
