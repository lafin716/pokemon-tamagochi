package com.lafin.servlet.controller.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PatServlet", urlPatterns = "/action/pat")
public class PatServlet extends ActionServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        super.doPost(req, resp);
        var result = actionService.pat();
        req.setAttribute("actionResult", result);

        print("/_ajax/action_result");
    }
}