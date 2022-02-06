package com.lafin.servlet.service;

import com.lafin.servlet.model.user.UserPokemon;
import com.lafin.servlet.persistence.LevelPersistence;
import com.lafin.servlet.persistence.UserPokemonPersistence;

public class LevelService {

    private LevelPersistence levelPersistence;

    private UserPokemonPersistence userPokemonPersistence;

    public LevelService() {
        levelPersistence = new LevelPersistence();
        userPokemonPersistence = new UserPokemonPersistence();
    }

    public UserPokemon exp(UserPokemon userPokemon, int earnExp) {
        var level = userPokemon.getLevel();
        var exp = userPokemon.getExp() + earnExp;

        var levelInfo = levelPersistence.getLevel(level);
        var requireExp = levelInfo.getExp();

        if (exp >= requireExp) {
            level = level + 1;
            exp = 0;
            userPokemon.setLevel(level);
            userPokemonPersistence.updateLevel(userPokemon.getId(), level);
        }

        userPokemonPersistence.updateExp(userPokemon.getId(), exp);
        return userPokemon;
    }
}
