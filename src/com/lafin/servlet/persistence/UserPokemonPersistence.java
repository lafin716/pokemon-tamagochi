package com.lafin.servlet.persistence;

import com.lafin.servlet.constant.PokemonStatus;
import com.lafin.servlet.model.user.UserPokemon;
import com.lafin.servlet.util.DBUtil;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserPokemonPersistence {

    public int countUserPokemon(int userId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT COUNT(ownerId) AS cnt ");
        sql.append("FROM tb_pokemon_detail ");
        sql.append("WHERE ownerId = '");
        sql.append(userId);
        sql.append("'");

        System.out.println(sql);

        try {
            var count = 0;
            var resultSet = DBUtil.select(sql.toString());
            if (resultSet.next()) {
                count = resultSet.getInt("cnt");
            }

            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public boolean addPokemon(UserPokemon userPokemon) {

        var main = userPokemon.isMain() ? 1 : 0;

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO tb_pokemon_detail (");
        sql.append("ownerId, pokemonId, isMain, status, nickname, hapiness, hungry, catchedAt");
        sql.append(") VALUES ('");
        sql.append(userPokemon.getOwnerId());
        sql.append("', '");
        sql.append(userPokemon.getPokemonId());
        sql.append("', ");
        sql.append(main);
        sql.append(", '");
        sql.append(userPokemon.getStatus().getCode());
        sql.append("', '");
        sql.append(userPokemon.getNickName());
        sql.append("', '");
        sql.append(userPokemon.getHapiness());
        sql.append("', '");
        sql.append(userPokemon.getHungry());
        sql.append("', '");
        sql.append(userPokemon.getCatchedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        sql.append("')");

        System.out.println(sql);

        return DBUtil.insert(sql.toString());
    }

    public UserPokemon getUserPokemon(int userPokemonId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT pd.* ");
        sql.append("FROM tb_pokemon_detail as pd ");
        sql.append("WHERE pd.ownerId = ");
        sql.append(userPokemonId);

        System.out.println(sql);
        var result = DBUtil.select(sql.toString());
        if (Objects.isNull(result)) {
            return null;
        }

        try {
            var pokemon = new UserPokemon();
            if (result.next()) {
                pokemon.setId(result.getInt("id"));
                pokemon.setOwnerId(result.getInt("ownerId"));
                pokemon.setPokemonId(result.getInt("pokemonId"));
                pokemon.setMain(result.getInt("isMain") > 0);
                pokemon.setStatus(PokemonStatus.valueOf(result.getString("status")));
                pokemon.setHapiness(result.getInt("hapiness"));
                pokemon.setHungry(result.getInt("hungry"));
                pokemon.setCatchedAt(LocalDateTime.parse(result.getString("catchedAt"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }

            return pokemon;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public UserPokemon getMainPokemon(int userId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT pd.*, p.serialNumber, p.pokemonName ");
        sql.append("FROM tb_pokemon_detail as pd ");
        sql.append("LEFT JOIN tb_pokemon as p ");
        sql.append("ON pd.pokemonId = p.id ");
        sql.append("WHERE pd.ownerId = ");
        sql.append(userId);
        sql.append(" AND pd.isMain = '1' ");

        System.out.println(sql);
        var result = DBUtil.select(sql.toString());
        if (Objects.isNull(result)) {
            return null;
        }

        try {
            var pokemon = new UserPokemon();
            if (result.next()) {
                pokemon.setId(result.getInt("id"));
                pokemon.setOwnerId(result.getInt("ownerId"));
                pokemon.setPokemonId(result.getInt("pokemonId"));
                pokemon.setPokemonCode(result.getString("serialNumber"));
                pokemon.setOriginName(result.getString("pokemonName"));
                pokemon.setMain(result.getInt("isMain") > 0);
                pokemon.setStatus(PokemonStatus.valueOf(result.getString("status")));
                pokemon.setHapiness(result.getInt("hapiness"));
                pokemon.setHungry(result.getInt("hungry"));
                pokemon.setCatchedAt(LocalDateTime.parse(result.getString("catchedAt"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }

            return pokemon;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<UserPokemon> getUserPokemons(int userId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT pd.*, p.serialNumber, p.pokemonName ");
        sql.append("FROM tb_pokemon_detail as pd ");
        sql.append("LEFT JOIN tb_pokemon as p ");
        sql.append("ON pd.pokemonId = p.id ");
        sql.append("WHERE pd.ownerId = ");
        sql.append(userId);

        System.out.println(sql);
        var result = DBUtil.select(sql.toString());
        if (Objects.isNull(result)) {
            return null;
        }

        try {
            List<UserPokemon> pokemons = new ArrayList<>();
            if (result.next()) {
                var pokemon = new UserPokemon();
                pokemon.setId(result.getInt("id"));
                pokemon.setOwnerId(result.getInt("ownerId"));
                pokemon.setPokemonId(result.getInt("pokemonId"));
                pokemon.setPokemonCode(result.getString("serialNumber"));
                pokemon.setOriginName(result.getString("pokemonName"));
                pokemon.setMain(result.getInt("isMain") > 0);
                pokemon.setStatus(PokemonStatus.valueOf(result.getString("status")));
                pokemon.setHapiness(result.getInt("hapiness"));
                pokemon.setHungry(result.getInt("hungry"));
                pokemon.setCatchedAt(LocalDateTime.parse(result.getString("catchedAt"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

                pokemons.add(pokemon);
            }

            return pokemons;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateHappy(int userPokemonId, int amount) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE tb_pokemon_detail ");
        sql.append("SET ");
        sql.append("hapiness = " + amount);
        sql.append(" WHERE ");
        sql.append("id = " + userPokemonId);
        System.out.println(sql);

        return DBUtil.insert(sql.toString());
    }

    public boolean updateHungry(int userPokemonId, int amount) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE tb_pokemon_detail ");
        sql.append("SET ");
        sql.append("hungry = " + amount);
        sql.append(" WHERE ");
        sql.append("id = " + userPokemonId);
        System.out.println(sql);

        return DBUtil.insert(sql.toString());
    }

    public boolean updateStatus(int userPokemonId, PokemonStatus status) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE tb_pokemon_detail ");
        sql.append("SET ");
        sql.append("status = '");
        sql.append(status.getCode());
        sql.append("' WHERE ");
        sql.append("id = " + userPokemonId);
        System.out.println(sql);

        return DBUtil.insert(sql.toString());
    }
}
