package com.lafin.servlet.controller.lounge;

import com.lafin.servlet.constant.SessionKey;
import com.lafin.servlet.controller.base.BaseServlet;
import com.lafin.servlet.service.UserService;
import com.lafin.servlet.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoungeServlet", urlPatterns = "/lounge")
public class LoungeServlet extends BaseServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        super.doGet(req, resp);
        int userId = Integer.parseInt(StringUtil.of(session.getAttribute(SessionKey.USER_ID), "0"));
        if (userId <= 0) {
            redirect("/user/login");
            return;
        }

        boolean hasPokemon = userService.hasPokemon(userId);

        if (hasPokemon) {
            var mainPokemon = userService.getMainPokemon(userId);
            req.setAttribute("mainPokemon", mainPokemon);
            print("/lounge/index");
        } else {
            redirect("/intro");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        super.doPost(req, resp);
    }
}
