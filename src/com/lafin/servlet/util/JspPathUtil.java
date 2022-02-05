package com.lafin.servlet.util;

public class JspPathUtil {

    public static String getPath(String jsp) {
        StringBuilder jspResolver = new StringBuilder();
        jspResolver.append("/WEB-INF");
        jspResolver.append("/views");
        jspResolver.append(jsp);
        jspResolver.append(".jsp");

        return jspResolver.toString();
    }
}
