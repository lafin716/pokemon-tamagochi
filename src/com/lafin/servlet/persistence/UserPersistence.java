package com.lafin.servlet.persistence;

import com.lafin.servlet.model.user.User;
import com.lafin.servlet.util.DBUtil;

import java.sql.SQLException;

public class UserPersistence {

    private static final String TABLE = "tb_user";

    public User getUser(int id) {
        var dbUtil = new DBUtil();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM tb_user WHERE id = '" + id + "'");
            System.out.println(sql);

            var user = new User();
            var resultSet = dbUtil.select(sql.toString());
            if (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setCreatedAt(resultSet.getDate("createdAt"));
            }

            dbUtil.resultSetClose();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            dbUtil.resultSetClose();
            return null;
        }
    }

    public User getUser(String email, String password) {
        var dbUtil = new DBUtil();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM tb_user WHERE `email` = '" + email + "' AND `password` = '" + password + "'");
            System.out.println(sql);

            var user = new User();
            var resultSet = dbUtil.select(sql.toString());
            if (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setCreatedAt(resultSet.getDate("createdAt"));
            }

            dbUtil.resultSetClose();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            dbUtil.resultSetClose();
            return null;
        }
    }

    public boolean addUser(User user) {
        var dbUtil = new DBUtil();
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO tb_user (");
        sql.append("`name`, `email`, `password`, `createdAt`");
        sql.append(") VALUES (");
        sql.append("'" + user.getName() + "', '" + user.getEmail() + "', '" + user.getPassword() + "', now()");
        sql.append(")");
        System.out.println(sql);

        var result = dbUtil.insert(sql.toString());
        dbUtil.insertClose();
        return result;
    }
}
