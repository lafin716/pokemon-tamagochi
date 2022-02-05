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

@WebServlet(name = "StarterServlet", urlPatterns = "/intro/starter")
public class StarterServlet extends BaseServlet {

    private UserService userService;

    private PokemonService pokemonService;

    @Override
    public void init() throws ServletException {
        super.init();
        pokemonService = new PokemonService();
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        super.doGet(req, resp);
        var starterPokemons = pokemonService.getStarterPokemons();

        req.setAttribute("starterPokemons", starterPokemons);
        print("/intro/starter");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        super.doPost(req, resp);

        var userId = Integer.parseInt(StringUtil.of(session.getAttribute(SessionKey.USER_ID), "0"));
        var pokemonId = Integer.parseInt(StringUtil.of(req.getParameter("pokemonId"), "0"));
        var pokemonNickName = "";
        var isMain = true;

        userService.addPokemon(userId, pokemonId, pokemonNickName, isMain);
        redirect("/lounge");
    }
}
