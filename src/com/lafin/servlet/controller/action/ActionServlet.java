package com.lafin.servlet.controller.action;

import com.lafin.servlet.controller.base.BaseServlet;
import com.lafin.servlet.service.ActionService;
import com.lafin.servlet.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends BaseServlet {

    protected ActionService actionService;

    protected UserService userService;

    protected int userPokemonId;

    @Override
    public void init() throws ServletException {
        super.init();
        actionService = new ActionService();
        userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        super.doPost(req, resp);
        userPokemonId = Integer.parseInt(req.getParameter("userPokemonId"));
    }
}
