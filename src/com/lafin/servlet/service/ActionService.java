package com.lafin.servlet.service;

import com.lafin.servlet.constant.PokemonSay;
import com.lafin.servlet.constant.PokemonStatus;
import com.lafin.servlet.model.user.ActionResult;
import com.lafin.servlet.model.user.UserPokemon;
import com.lafin.servlet.persistence.UserPokemonPersistence;

public class ActionService {

    private final int EAT = 5;

    private final int WORKOUT = 10;

    private final int PAT = 5;

    private final int DIGEST = 3;

    private final int BORING = 3;

    private final int EAT_EXP = 1;

    private final int WORKOUT_EXP = 5;

    private final int PAT_EXP = 1;

    private UserPokemonPersistence userPokemonPersistence;

    private LevelService levelService;

    private RevolutionService revolutionService;

    public ActionService() {
        userPokemonPersistence = new UserPokemonPersistence();
        levelService = new LevelService();
        revolutionService = new RevolutionService();
    }

    public ActionResult feed(int userPokemonId) {
        var userPokemon = userPokemonPersistence.getUserPokemon(userPokemonId);
        var actionResult = new ActionResult();
        actionResult.setStatus(PokemonStatus.NORMAL);
        actionResult.setSay(PokemonSay.EAT);

        // 배고픔 계산
        var hungry = userPokemon.getHungry();
        hungry = limitAmount(hungry - EAT);

        if (hungry <= 0) {
            actionResult.setSay(PokemonSay.TOO_FULL);
        } else if (hungry <= 20) {
            actionResult.setSay(PokemonSay.FULL);
        } else if (hungry >= 100) {
            actionResult.setStatus(PokemonStatus.DEAD);
            actionResult.setSay(PokemonSay.DIE);
        }

        var levelUpUserPokemon = levelService.exp(userPokemon, EAT_EXP);
        var revolution = revolutionService.revolution(levelUpUserPokemon);
        if (revolution) {
            actionResult.setSay(PokemonSay.REVOLUTION);
        }

        // 저장
        userPokemonPersistence.updateHungry(userPokemon.getId(), hungry);
        userPokemonPersistence.updateStatus(userPokemon.getId(), actionResult.getStatus());
        
        return actionResult;
    }

    public ActionResult pat(int userPokemonId) {
        var userPokemon = userPokemonPersistence.getUserPokemon(userPokemonId);
        var actionResult = new ActionResult();
        actionResult.setStatus(PokemonStatus.NORMAL);
        actionResult.setSay(PokemonSay.GOOD);

        var happy = userPokemon.getHapiness();
        happy = limitAmount(happy + PAT);

        if (happy <= 0) {
            actionResult.setStatus(PokemonStatus.RUN);
            actionResult.setSay(PokemonSay.LEAVE);
        } else if (happy >= 100) {
            actionResult.setStatus(PokemonStatus.RUN);
            actionResult.setSay(PokemonSay.LEAVE);
        } else if (happy >= 80) {
            actionResult.setSay(PokemonSay.TOO_HAPPY);
        }

        var levelUpUserPokemon = levelService.exp(userPokemon, PAT_EXP);
        var revolution = revolutionService.revolution(levelUpUserPokemon);
        if (revolution) {
            actionResult.setSay(PokemonSay.REVOLUTION);
        }

        userPokemonPersistence.updateHappy(userPokemon.getId(), happy);
        userPokemonPersistence.updateStatus(userPokemon.getId(), actionResult.getStatus());

        return actionResult;
    }

    public ActionResult workout(int userPokemonId) {
        var userPokemon = userPokemonPersistence.getUserPokemon(userPokemonId);
        var actionResult = new ActionResult();
        actionResult.setStatus(PokemonStatus.NORMAL);
        actionResult.setSay(PokemonSay.WORKOUT);

        // 배고픔 계산
        var hungry = userPokemon.getHungry();
        hungry = limitAmount(hungry + WORKOUT);

        var levelUpUserPokemon = levelService.exp(userPokemon, WORKOUT_EXP);
        var revolution = revolutionService.revolution(levelUpUserPokemon);
        if (revolution) {
            actionResult.setSay(PokemonSay.REVOLUTION);
        }

        // 저장
        userPokemonPersistence.updateHungry(userPokemon.getId(), hungry);
        userPokemonPersistence.updateStatus(userPokemon.getId(), actionResult.getStatus());

        return actionResult;
    }

    public ActionResult digest(int userPokemonId) {
        var userPokemon = userPokemonPersistence.getUserPokemon(userPokemonId);
        var actionResult = new ActionResult();
        actionResult.setStatus(PokemonStatus.NORMAL);
        actionResult.setSay(PokemonSay.DIGEST);

        var hungry = userPokemon.getHungry();
        hungry = limitAmount(hungry + DIGEST);

        if (hungry <= 0) {
            actionResult.setStatus(PokemonStatus.RUN);
            actionResult.setSay(PokemonSay.LEAVE);
        } else if (hungry >= 100) {
            actionResult.setStatus(PokemonStatus.DEAD);
            actionResult.setSay(PokemonSay.DIE);
        } else if (hungry >= 80) {
            actionResult.setStatus(PokemonStatus.HUNGRY);
            actionResult.setSay(PokemonSay.HUNGRY);
        }

        userPokemonPersistence.updateHungry(userPokemon.getId(), hungry);
        userPokemonPersistence.updateStatus(userPokemon.getId(), actionResult.getStatus());

        return actionResult;
    }

    public ActionResult boring(int userPokemonId) {
        var userPokemon = userPokemonPersistence.getUserPokemon(userPokemonId);
        var actionResult = new ActionResult();
        actionResult.setStatus(PokemonStatus.NORMAL);
        actionResult.setSay(PokemonSay.BORED);

        var happy = userPokemon.getHapiness();
        happy = limitAmount(happy - BORING);

        if (happy <= 0) {
            actionResult.setStatus(PokemonStatus.RUN);
            actionResult.setSay(PokemonSay.LEAVE);
        } else if (happy <= 10) {
            actionResult.setStatus(PokemonStatus.SICK);
            actionResult.setSay(PokemonSay.SICK);
        } else if (happy <= 30) {
            actionResult.setSay(PokemonSay.LONELY);
        }

        userPokemonPersistence.updateHappy(userPokemon.getId(), happy);
        userPokemonPersistence.updateStatus(userPokemon.getId(), actionResult.getStatus());

        return actionResult;
    }

    public void abandon(int userPokemonId) {
        userPokemonPersistence.deletePokemon(userPokemonId);
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
}
