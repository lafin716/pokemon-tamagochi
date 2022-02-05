package com.lafin.servlet.controller;

import com.lafin.servlet.controller.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainServlet", urlPatterns = "/")
public class MainServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        super.doGet(request, response);
        print("/index");
    }
}
