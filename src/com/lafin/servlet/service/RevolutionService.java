package com.lafin.servlet.service;

import com.lafin.servlet.model.user.UserPokemon;
import com.lafin.servlet.persistence.RevolutionPersistence;
import com.lafin.servlet.persistence.UserPokemonPersistence;

public class RevolutionService {

    private RevolutionPersistence revolutionPersistence;

    private UserPokemonPersistence userPokemonPersistence;

    public RevolutionService() {
        revolutionPersistence = new RevolutionPersistence();
        userPokemonPersistence = new UserPokemonPersistence();
    }

    public boolean revolution(UserPokemon userPokemon) {
        var result = false;
        var revolution = revolutionPersistence.getRevolution(userPokemon.getPokemonId());

        if (revolution.getRequireLevel() == 0) {
            return result;
        }

        if (userPokemon.getLevel() >= revolution.getRequireLevel()) {
            result = true;
            userPokemonPersistence.updatePokemonId(userPokemon.getId(), revolution.getNextPokemonId());
        }

        return result;
    }
}
