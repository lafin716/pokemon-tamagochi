package com.lafin.servlet.service;

import com.lafin.servlet.model.User;
import com.lafin.servlet.persistence.UserPersistence;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    private UserPersistence userPersistence;

    public UserService() {
        userPersistence = new UserPersistence();
    }

    public List<User> getUsers() throws SQLException {
        return userPersistence.getUsers();
    }

    public User getUser(Long id) throws SQLException {
        return userPersistence.getUser(id);
    }

    public boolean addUser(String name, String email, String password) throws SQLException {
        var user = User.createUser(name, email, password);
        return userPersistence.addUser(user);
    }
}
