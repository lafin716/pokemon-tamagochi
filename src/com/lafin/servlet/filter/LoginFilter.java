package com.lafin.servlet.filter;

import com.lafin.servlet.constant.SessionKey;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {

    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("", "/user", "/resources")));


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 전처리
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        httpRequest.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("text/html;charset=UTF-8");
        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length()).replaceAll("[/]+$", "");

        boolean loggedIn = isLoggedIn(session);
        boolean allowedPath = isRequireLogin(path);

        if (!loggedIn && !allowedPath) {
            httpResponse.sendRedirect("/user/login");
            return;
        }

        chain.doFilter(request, response);
    }

    private boolean isRequireLogin(String path) {
        return ALLOWED_PATHS.stream()
                .filter(s -> !s.isBlank())
                .anyMatch(path::contains);
    }

    private boolean isLoggedIn(HttpSession session) {
        if (session == null) {
            return false;
        }

        String userId = session.getAttribute(SessionKey.USER_ID) != null
                ? session.getAttribute(SessionKey.USER_ID).toString()
                : "";
        if (userId == null || userId.trim().isEmpty()) {
            return false;
        }

        return true;
    }
}
