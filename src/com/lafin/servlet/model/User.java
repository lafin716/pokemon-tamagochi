package com.lafin.servlet.model;

import java.time.LocalDateTime;

public class User {

    private Long id;

    private String email;

    private String name;

    private String password;

    private LocalDateTime createdAt;

    private LocalDateTime deletedAt;

    public static User createUser(String name, String email, String password) {
        var user = new User();
        user.name = name;
        user.email = email;
        user.password = password;
        user.createdAt = LocalDateTime.now();

        return user;
    }
}
