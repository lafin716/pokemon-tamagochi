package com.lafin.servlet.persistence;

import com.lafin.servlet.model.User;
import com.lafin.servlet.util.DBUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserPersistence {

    public List<User> getUsers() throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM tb_user ");

        var list = new ArrayList<User>();
        var resultSet = DBUtil.select(sql.toString());
        while (resultSet.next()) {
            var user = new User();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setCreatedAt(resultSet.getDate("createdAt"));
            list.add(user);
        }

        return list;
    }

    public User getUser(Long id) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM tb_user WHERE id = '" + id + "'");

        var user = new User();
        var resultSet = DBUtil.select(sql.toString());
        if (resultSet.next()) {
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setCreatedAt(resultSet.getDate("createdAt"));
        }

        return user;
    }

    public boolean addUser(User user) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO tb_user (");
        sql.append("`name`, `email`, `password`, `createdAt`");
        sql.append(") VALUES (");
        sql.append("'" + user.getName() + "', '" + user.getEmail() + "', '" + user.getPassword() + "', now()");
        sql.append(")");

        return DBUtil.insert(sql.toString());
    }
}
