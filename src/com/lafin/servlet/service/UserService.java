package com.lafin.servlet.service;

import com.lafin.servlet.constant.PokemonStatus;
import com.lafin.servlet.model.user.User;
import com.lafin.servlet.model.user.UserPokemon;
import com.lafin.servlet.persistence.PokemonPersistence;
import com.lafin.servlet.persistence.UserPersistence;
import com.lafin.servlet.persistence.UserPokemonPersistence;

import java.time.LocalDateTime;
import java.util.List;

public class UserService {

    private PokemonPersistence pokemonPersistence;

    private UserPersistence userPersistence;

    private UserPokemonPersistence userPokemonPersistence;

    public UserService() {
        userPersistence = new UserPersistence();
        pokemonPersistence = new PokemonPersistence();
        userPokemonPersistence = new UserPokemonPersistence();
    }

    public List<User> getUsers() {
        return userPersistence.getUsers();
    }

    public User getUser(int userId) {
        return userPersistence.getUser(userId);
    }

    public User login(String email, String password) {
        return userPersistence.getUser(email, password);
    }

    public boolean addUser(String name, String email, String password) {
        var user = User.createUser(name, email, password);
        return userPersistence.addUser(user);
    }

    public boolean hasPokemon(int userId) {
        var count = userPokemonPersistence.countUserPokemon(userId);
        return count > 0;
    }

    public boolean addPokemon(int userId, int pokemonId, String nickname, boolean isMain) {

        var pokemon = pokemonPersistence.getPokemonById(pokemonId);
        if (nickname.isEmpty()) {
            nickname = pokemon.getPokemonName();
        }

        var userPokemon = new UserPokemon();
        userPokemon.setOwnerId(userId);
        userPokemon.setPokemonId(pokemonId);
        userPokemon.setNickName(nickname);
        userPokemon.setStatus(PokemonStatus.NORMAL);
        userPokemon.setMain(isMain);
        userPokemon.setHapiness(50);
        userPokemon.setHungry(100);
        userPokemon.setCatchedAt(LocalDateTime.now());

        return userPokemonPersistence.addPokemon(userPokemon);
    }

    public UserPokemon getMainPokemon(int userId) {
        return userPokemonPersistence.getMainPokemon(userId);
    }
}
