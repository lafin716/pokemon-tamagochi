package com.lafin.servlet.util;

public class StringUtil {

    public static String of(Object obj) {
        if (obj == null) {
            return "";
        }

        if (obj.toString().isEmpty()) {
            return "";
        }

        return obj.toString();
    }

    public static String of(Object obj, String def) {
        if (obj == null) {
            return def;
        }

        if (obj.toString().isEmpty()) {
            return def;
        }

        return obj.toString();
    }
}
