package com.lafin.servlet.service;

import com.lafin.servlet.constant.PokemonSay;
import com.lafin.servlet.constant.PokemonStatus;
import com.lafin.servlet.model.user.ActionResult;
import com.lafin.servlet.model.user.UserPokemon;
import com.lafin.servlet.persistence.UserPokemonPersistence;

public class ActionService {

    private final int HUNGRY_AMOUNT = 10;

    private final int FOOD_HAPPY_AMOUNT = 3;

    private final int PAT_HAPPY_AMOUNT = 5;

    private final int DIGEST_AMOUNT = 10;

    private UserPokemonPersistence userPokemonPersistence;

    private UserPokemon userPokemon;

    public ActionService() {
        userPokemonPersistence = new UserPokemonPersistence();
    }

    public void init(int userPokemonId) {
        userPokemon = userPokemonPersistence.getUserPokemon(userPokemonId);
    }

    public ActionResult feed() {

        // 배고픔 계산
        var hungry = userPokemon.getHungry();
        hungry = limitAmount(hungry - HUNGRY_AMOUNT);

        var result = calculateHungry(hungry, PokemonSay.EAT);
        userPokemonPersistence.updateHungry(userPokemon.getId(), hungry);

        // 행복도 계산
        var happy = userPokemon.getHapiness();
        happy = limitAmount(happy + FOOD_HAPPY_AMOUNT);

        userPokemonPersistence.updateHappy(userPokemon.getId(), happy);
        userPokemonPersistence.updateStatus(userPokemon.getId(), result.getStatus());
        
        return result;
    }

    public ActionResult pat() {

        var happy = userPokemon.getHapiness();
        happy = limitAmount(happy + PAT_HAPPY_AMOUNT);

        var result = calculateHappy(happy);
        userPokemonPersistence.updateHappy(userPokemon.getId(), happy);
        userPokemonPersistence.updateStatus(userPokemon.getId(), result.getStatus());

        return result;
    }

    public ActionResult digest() {

        // 배고픔 계산
        var hungry = userPokemon.getHungry();
        hungry = limitAmount(hungry + DIGEST_AMOUNT);

        var result = calculateHungry(hungry, PokemonSay.DIGEST);
        userPokemonPersistence.updateHungry(userPokemon.getId(), hungry);

        // 행복도 계산
        var happy = userPokemon.getHapiness();
        happy = limitAmount(happy - FOOD_HAPPY_AMOUNT);

        userPokemonPersistence.updateHappy(userPokemon.getId(), happy);
        userPokemonPersistence.updateStatus(userPokemon.getId(), result.getStatus());
        return result;
    }

    public int limitAmount(int amount) {
        if (amount <= 0) {
            return 0;
        }

        if (amount >= 100) {
            return 100;
        }

        return amount;
    }

    public ActionResult calculateHungry(int hungry, PokemonSay defaultSay) {
        var result = new ActionResult();
        result.setStatus(PokemonStatus.NORMAL);
        result.setSay(defaultSay);

        if (hungry <= 0) {
            result.setStatus(PokemonStatus.DEAD);
            result.setSay(PokemonSay.TOO_FULL);
        } else if (hungry <= HUNGRY_AMOUNT) {
            result.setStatus(PokemonStatus.SICK);
            result.setSay(PokemonSay.FULL);
        } else if (hungry >= 100) {
            result.setStatus(PokemonStatus.HUNGRY);
            result.setSay(PokemonSay.HUNGRY);
        }

        return result;
    }

    public ActionResult calculateHappy(int happy) {
        var result = new ActionResult();
        result.setStatus(PokemonStatus.NORMAL);
        result.setSay(PokemonSay.GOOD);

        if (happy <= 0) {
            result.setStatus(PokemonStatus.RUN);
            result.setSay(PokemonSay.LEAVE);
        } else if (happy <= PAT_HAPPY_AMOUNT) {
            result.setStatus(PokemonStatus.SICK);
            result.setSay(PokemonSay.LONELY);
        } else if (happy >= 100) {
            result.setSay(PokemonSay.TOO_HAPPY);
        }

        return result;
    }

    public boolean checkRevolution() {
        var hungry = userPokemon.getHungry();
        var happy = userPokemon.getHapiness();

        return hungry >= 0 && hungry <= 10 && happy <= 100 && happy >= 90;
    }

    public ActionResult revolution() {
        var result = new ActionResult();
        result.setStatus(PokemonStatus.NORMAL);
        result.setSay(PokemonSay.REVOLUTION);

        return result;
    }
}
