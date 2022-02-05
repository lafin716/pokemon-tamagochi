package com.lafin.servlet.model.user;

import com.lafin.servlet.constant.PokemonSay;
import com.lafin.servlet.constant.PokemonStatus;

public class ActionResult {

    private PokemonStatus status;

    private PokemonSay say;

    public PokemonStatus getStatus() {
        return status;
    }

    public void setStatus(PokemonStatus status) {
        this.status = status;
    }

    public PokemonSay getSay() {
        return say;
    }

    public void setSay(PokemonSay say) {
        this.say = say;
    }
}
