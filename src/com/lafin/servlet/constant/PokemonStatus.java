package com.lafin.servlet.constant;

public enum PokemonStatus {

    NORMAL("", PokemonSay.GREETING),
    DEAD("죽음", PokemonSay.DIE),
    HUNGRY("배고픔", PokemonSay.HUNGRY),
    SICK("아픔", PokemonSay.SICK),
    RELEASED("놓아줌", PokemonSay.SLIENT),
    RUN("도망감", PokemonSay.SLIENT);

    private String text;

    private PokemonSay say;

    PokemonStatus(String text, PokemonSay say) {
        this.text = text;
        this.say = say;
    }

    public String getText() {
        return text;
    }

    public String getSay() {
        return say.talk();
    }

    public String getCode() {
        return toString();
    }
}
