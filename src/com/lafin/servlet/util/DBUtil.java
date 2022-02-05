package com.lafin.servlet.util;

import java.sql.*;

public class DBUtil {

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final String DB_URL = "jdbc:mysql://localhost:3306/user";

    private static final String USERNAME = "test_user";

    private static final String PASSWORD = "test";

    public static ResultSet select(String sql) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

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

    public static boolean insert(String sql) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();

            return stmt.execute(sql);
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

        return false;
    }
}
