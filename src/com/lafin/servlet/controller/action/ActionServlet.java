package com.lafin.servlet.controller.action;

import com.lafin.servlet.controller.base.BaseServlet;
import com.lafin.servlet.service.ActionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends BaseServlet {

    protected ActionService actionService;

    @Override
    public void init() throws ServletException {
        super.init();
        actionService = new ActionService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        super.doPost(req, resp);
        var userPokemonId = Integer.parseInt(req.getParameter("userPokemonId"));
        actionService.init(userPokemonId);
    }
}
