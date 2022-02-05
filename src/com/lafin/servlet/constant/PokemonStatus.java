package com.lafin.servlet.constant;

public enum PokemonStatus {

    NORMAL(""),
    DEAD("죽음"),
    HUNGRY("배고픔"),
    SICK("아픔"),
    RELEASED("놓아줌"),
    RUN("도망감");

    private String text;

    PokemonStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getCode() {
        return toString();
    }
}
