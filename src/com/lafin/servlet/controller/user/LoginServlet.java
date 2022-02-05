package com.lafin.servlet.controller.user;

import com.lafin.servlet.constant.SessionKey;
import com.lafin.servlet.controller.base.BaseServlet;
import com.lafin.servlet.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = "/user/login")
public class LoginServlet extends BaseServlet {

    private UserService userService;

    @Override
    public void init() {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        super.doGet(req, resp);
        print("/user/login");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        super.doPost(req, resp);

        var email = req.getParameter("email");
        var password = req.getParameter("password");

        var user = userService.login(email, password);

        if (user == null) {
            redirect("/user/login");
        } else {
            session.setAttribute(SessionKey.USER_ID, user.getId());
            session.setAttribute(SessionKey.USER_NAME, user.getName());
            redirect("/lounge");
        }
    }
}
