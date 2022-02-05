package com.lafin.servlet.controller.user;

import com.lafin.servlet.controller.base.BaseServlet;
import com.lafin.servlet.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Locale;

@WebServlet(name = "RegistServlet", urlPatterns = "/user/regist")
public class RegistServlet extends BaseServlet {

    private UserService userService;

    @Override
    public void init() {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        super.doGet(req, resp);
        print("/user/regist");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        super.doPost(req, resp);

        var name = req.getParameter("name");
        var email = req.getParameter("email");
        var password = req.getParameter("password");

        userService.addUser(name, email, password);

        redirect("/user/login");
    }
}
