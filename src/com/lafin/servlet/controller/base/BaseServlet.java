package com.lafin.servlet.controller.base;

import com.lafin.servlet.constant.SessionKey;
import com.lafin.servlet.util.JspPathUtil;
import com.lafin.servlet.util.StringUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public abstract class BaseServlet extends HttpServlet {

    protected int userId;

    protected HttpServletRequest request;

    protected HttpServletResponse response;

    protected HttpSession session;

    private void preHandle(HttpServletRequest req, HttpServletResponse resp) {
        initScopes(req, resp);
        setEncoding(req);
        setUserId();
    }

    private void initScopes(HttpServletRequest req, HttpServletResponse resp) {
        request = req;
        response = resp;
        session = req.getSession();
    }

    private void setEncoding(HttpServletRequest req) {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void setUserId() {
        userId = Integer.parseInt(StringUtil.of(session.getAttribute(SessionKey.USER_ID), "0"));
    }

    private void includeHeader() {
        include("/_layout/header");
    }

    private void includeFooter() {
        include("/_layout/footer");
    }

    protected void print(String jsp) {
        includeHeader();
        include(jsp);
        includeFooter();
    }

    protected void include(String jsp) {
        try {
            var path = JspPathUtil.getPath(jsp);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher(path);
            rd.include(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void forward(String jsp){
        try {
            var path = JspPathUtil.getPath(jsp);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher(path);
            rd.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void redirect(String url) {
        try {
            response.sendRedirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        preHandle(req, resp);
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) {
        preHandle(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        preHandle(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        preHandle(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        preHandle(req, resp);
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) {
        preHandle(req, resp);
    }

    @Override
    protected void doTrace(HttpServletRequest req, HttpServletResponse resp) {
        preHandle(req, resp);
    }
}
