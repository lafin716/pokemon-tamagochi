package com.lafin.servlet.util;

import java.sql.*;

public class DBUtil {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    private static final String DB_URL = "jdbc:mysql://localhost:3306/user";

    private static final String USERNAME = "test_user";

    private static final String PASSWORD = "test";

    public static ResultSet select(String sql) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            return rs;
        }catch(SQLException se1) {
            se1.printStackTrace();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            rs.close();
            stmt.close();
            conn.close();
        }

        return null;
    }

    public static boolean insert(String sql) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            return true;
        }catch(SQLException se1) {
            se1.printStackTrace();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            rs.close();
            stmt.close();
            conn.close();
        }

        return false;
    }
}
