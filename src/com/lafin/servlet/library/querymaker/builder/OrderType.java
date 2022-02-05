package com.lafin.servlet.library.querymaker.builder;

public enum OrderType {

    ASC("ASC"),
    DESC("DESC");

    private String query;

    OrderType(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return query;
    }
}
