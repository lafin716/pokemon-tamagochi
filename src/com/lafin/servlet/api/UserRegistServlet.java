package com.lafin.servlet.api;

import com.lafin.servlet.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserRegistServlet", value = "/user/regist")
public class UserRegistServlet extends HttpServlet {
    
    private UserService userService;
    
    public UserRegistServlet() {
        userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        boolean result = false;
        try {
            result = userService.addUser(name, email, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (result) {
            resp.getWriter().println("{");
            resp.getWriter().println("result: true,");
            resp.getWriter().println("message: \"유저 등록 완료\",");
            resp.getWriter().println("}");
        } else {
            resp.getWriter().println("{");
            resp.getWriter().println("result: false,");
            resp.getWriter().println("message: \"유저 등록 실패 ㅠㅠ\",");
            resp.getWriter().println("}");
        }
    }
}
