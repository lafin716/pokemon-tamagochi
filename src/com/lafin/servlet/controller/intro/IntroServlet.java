package com.lafin.servlet.controller.intro;

import com.lafin.servlet.constant.SessionKey;
import com.lafin.servlet.controller.base.BaseServlet;
import com.lafin.servlet.service.PokemonService;
import com.lafin.servlet.service.UserService;
import com.lafin.servlet.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "IntroServlet", urlPatterns = "/intro")
public class IntroServlet extends BaseServlet {

    private UserService userService;

    private PokemonService pokemonService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
        pokemonService = new PokemonService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        super.doGet(req, resp);
        var userId = Integer.parseInt(StringUtil.of(session.getAttribute(SessionKey.USER_ID), "0"));
        var user = userService.getUser(userId);
        var pokemons = pokemonService.getStarterPokemons();

        req.setAttribute("userName", user.getName());
        req.setAttribute("pokemons", pokemons);
        print("/intro/index");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        super.doPost(req, resp);
    }
}
