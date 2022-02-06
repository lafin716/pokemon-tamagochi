package com.lafin.servlet.controller.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AbandonServlet", urlPatterns = "/action/abandon")
public class AbandonServlet extends ActionServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        super.doPost(req, resp);
        actionService.abandon(userPokemonId);
        redirect("/");
    }
}
