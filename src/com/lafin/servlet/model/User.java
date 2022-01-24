package com.lafin.servlet.model;

import java.time.LocalDateTime;
import java.util.Date;

public class User {

    private Long id;

    private String email;

    private String name;

    private String password;

    private Date createdAt;

    public static User createUser(String name, String email, String password) {
        var user = new User();
        user.name = name;
        user.email = email;
        user.password = password;
        user.createdAt = new Date();

        return user;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
