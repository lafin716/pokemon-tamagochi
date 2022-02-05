package com.lafin.servlet.persistence;

import com.lafin.servlet.library.querymaker.builder.QueryBuilder;
import com.lafin.servlet.model.user.User;
import com.lafin.servlet.util.DBUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserPersistence {

    private static final String TABLE = "tb_user";

    public List<User> getUsers() {
        var list = new ArrayList<User>();
        var resultSet = QueryBuilder.select("*")
                .from(TABLE)
                .query();

        try {
            while (resultSet.next()) {
                var user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setCreatedAt(resultSet.getDate("createdAt"));
                list.add(user);
            }

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public User getUser(int id) {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM tb_user WHERE id = '" + id + "'");

            var user = new User();
            var resultSet = DBUtil.select(sql.toString());
            if (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setCreatedAt(resultSet.getDate("createdAt"));
            }

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User getUser(String email, String password) {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM tb_user WHERE `email` = '" + email + "' AND `password` = '" + password + "'");

            var user = new User();
            var resultSet = DBUtil.select(sql.toString());
            if (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setCreatedAt(resultSet.getDate("createdAt"));
            }

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean addUser(User user) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO tb_user (");
        sql.append("`name`, `email`, `password`, `createdAt`");
        sql.append(") VALUES (");
        sql.append("'" + user.getName() + "', '" + user.getEmail() + "', '" + user.getPassword() + "', now()");
        sql.append(")");

        return DBUtil.insert(sql.toString());
    }
}
