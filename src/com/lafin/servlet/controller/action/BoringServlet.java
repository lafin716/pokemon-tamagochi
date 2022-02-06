package com.lafin.servlet.controller.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BoringServlet", urlPatterns = "/action/boring")
public class BoringServlet extends ActionServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        super.doPost(req, resp);
        var result = actionService.boring(userPokemonId);
        var userPokemon = userService.getPokemon(userPokemonId);

        req.setAttribute("actionResult", result);
        req.setAttribute("userPokemon", userPokemon);
        print("/_ajax/action_result_noreact");
    }
}
