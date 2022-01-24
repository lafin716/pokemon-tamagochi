package com.lafin.servlet.api;

import com.lafin.servlet.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            var users = userService.getUsers();

            resp.getWriter().println("[");
            users.forEach(user -> {
            });
            resp.getWriter().println("]");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
