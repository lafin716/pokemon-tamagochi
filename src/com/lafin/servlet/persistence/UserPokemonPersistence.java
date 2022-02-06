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
        var dbUtil = new DBUtil();
        var sql = new StringBuilder();
        sql.append("SELECT COUNT(ownerId) AS cnt ");
        sql.append("FROM tb_pokemon_detail ");
        sql.append("WHERE ownerId = '");
        sql.append(userId);
        sql.append("'");
        System.out.println(sql);

        try {
            var count = 0;
            var resultSet = dbUtil.select(sql.toString());
            if (resultSet.next()) {
                count = resultSet.getInt("cnt");
            }

            dbUtil.resultSetClose();
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
            dbUtil.resultSetClose();
        }

        return 0;
    }

    public boolean addPokemon(UserPokemon userPokemon) {
        var dbUtil = new DBUtil();
        var result = false;
        var main = userPokemon.isMain() ? 1 : 0;

        var sql = new StringBuilder();
        sql.append("INSERT INTO tb_pokemon_detail (");
        sql.append("ownerId, pokemonId, level, exp, isMain, status, nickname, hapiness, hungry, catchedAt");
        sql.append(") VALUES ('");
        sql.append(userPokemon.getOwnerId());
        sql.append("', '");
        sql.append(userPokemon.getPokemonId());
        sql.append("', ");
        sql.append(userPokemon.getLevel());
        sql.append(", ");
        sql.append(userPokemon.getExp());
        sql.append(", ");
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

        result = dbUtil.insert(sql.toString());
        dbUtil.insertClose();
        return result;
    }

    public UserPokemon getUserPokemon(int userPokemonId) {
        var dbUtil = new DBUtil();
        var sql = new StringBuilder();
        sql.append("SELECT pd.*, p.serialNumber ");
        sql.append("FROM tb_pokemon_detail as pd ");
        sql.append("LEFT JOIN tb_pokemon as p ");
        sql.append("ON pd.pokemonId = p.id ");
        sql.append("WHERE pd.id = ");
        sql.append(userPokemonId);
        System.out.println(sql);

        var result = dbUtil.select(sql.toString());
        if (Objects.isNull(result)) {
            dbUtil.resultSetClose();
            return null;
        }

        try {
            var pokemon = new UserPokemon();
            if (result.next()) {
                pokemon.setId(result.getInt("id"));
                pokemon.setOwnerId(result.getInt("ownerId"));
                pokemon.setPokemonId(result.getInt("pokemonId"));
                pokemon.setPokemonCode(result.getString("serialNumber"));
                pokemon.setLevel(result.getInt("level"));
                pokemon.setExp(result.getInt("exp"));
                pokemon.setMain(result.getInt("isMain") > 0);
                pokemon.setStatus(PokemonStatus.valueOf(result.getString("status")));
                pokemon.setHapiness(result.getInt("hapiness"));
                pokemon.setHungry(result.getInt("hungry"));
                pokemon.setCatchedAt(LocalDateTime.parse(result.getString("catchedAt"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }

            dbUtil.resultSetClose();
            return pokemon;
        } catch (SQLException e) {
            e.printStackTrace();
            dbUtil.resultSetClose();
            return null;
        }
    }

    public UserPokemon getMainPokemon(int userId) {
        var dbUtil = new DBUtil();
        var sql = new StringBuilder();
        sql.append("SELECT pd.*, p.serialNumber, p.pokemonName ");
        sql.append("FROM tb_pokemon_detail as pd ");
        sql.append("LEFT JOIN tb_pokemon as p ");
        sql.append("ON pd.pokemonId = p.id ");
        sql.append("WHERE pd.ownerId = ");
        sql.append(userId);
        sql.append(" AND pd.isMain = '1' ");
        System.out.println(sql);

        var result = dbUtil.select(sql.toString());
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
                pokemon.setLevel(result.getInt("level"));
                pokemon.setExp(result.getInt("exp"));
                pokemon.setOriginName(result.getString("pokemonName"));
                pokemon.setMain(result.getInt("isMain") > 0);
                pokemon.setStatus(PokemonStatus.valueOf(result.getString("status")));
                pokemon.setHapiness(result.getInt("hapiness"));
                pokemon.setHungry(result.getInt("hungry"));
                pokemon.setCatchedAt(LocalDateTime.parse(result.getString("catchedAt"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }

            dbUtil.resultSetClose();
            return pokemon;
        } catch (SQLException e) {
            e.printStackTrace();
            dbUtil.resultSetClose();
            return null;
        }
    }

    public List<UserPokemon> getUserPokemons(int userId) {
        var dbUtil = new DBUtil();
        var sql = new StringBuilder();
        sql.append("SELECT pd.*, p.serialNumber, p.pokemonName ");
        sql.append("FROM tb_pokemon_detail as pd ");
        sql.append("LEFT JOIN tb_pokemon as p ");
        sql.append("ON pd.pokemonId = p.id ");
        sql.append("WHERE pd.ownerId = ");
        sql.append(userId);
        System.out.println(sql);

        var result = dbUtil.select(sql.toString());
        if (Objects.isNull(result)) {
            dbUtil.resultSetClose();
            return null;
        }

        try {
            List<UserPokemon> pokemons = new ArrayList<>();
            if (result.next()) {
                var pokemon = new UserPokemon();
                pokemon.setId(result.getInt("id"));
                pokemon.setOwnerId(result.getInt("ownerId"));
                pokemon.setPokemonId(result.getInt("pokemonId"));
                pokemon.setLevel(result.getInt("level"));
                pokemon.setExp(result.getInt("exp"));
                pokemon.setPokemonCode(result.getString("serialNumber"));
                pokemon.setOriginName(result.getString("pokemonName"));
                pokemon.setMain(result.getInt("isMain") > 0);
                pokemon.setStatus(PokemonStatus.valueOf(result.getString("status")));
                pokemon.setHapiness(result.getInt("hapiness"));
                pokemon.setHungry(result.getInt("hungry"));
                pokemon.setCatchedAt(LocalDateTime.parse(result.getString("catchedAt"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

                pokemons.add(pokemon);
            }

            dbUtil.resultSetClose();
            return pokemons;
        } catch (SQLException e) {
            e.printStackTrace();
            dbUtil.resultSetClose();
            return null;
        }
    }

    public boolean updatePokemonId(int userPokemonId, int pokemonId) {
        var dbUtil = new DBUtil();
        var result = false;
        var sql = new StringBuilder();
        sql.append("UPDATE tb_pokemon_detail ");
        sql.append("SET pokemonId = ");
        sql.append(pokemonId);
        sql.append(" WHERE id = ");
        sql.append(userPokemonId);
        System.out.println(sql);

        result = dbUtil.insert(sql.toString());
        dbUtil.insertClose();
        return result;
    }

    public boolean updateExp(int userPokemonId, int exp) {
        var dbUtil = new DBUtil();
        var result = false;
        var sql = new StringBuilder();
        sql.append("UPDATE tb_pokemon_detail ");
        sql.append("SET exp = ");
        sql.append(exp);
        sql.append(" WHERE id = ");
        sql.append(userPokemonId);
        System.out.println(sql);

        result = dbUtil.insert(sql.toString());
        dbUtil.insertClose();
        return result;
    }

    public boolean updateLevel(int userPokemonId, int level) {
        var dbUtil = new DBUtil();
        var result = false;
        var sql = new StringBuilder();
        sql.append("UPDATE tb_pokemon_detail ");
        sql.append("SET level = ");
        sql.append(level);
        sql.append(" WHERE id = ");
        sql.append(userPokemonId);
        System.out.println(sql);

        result = dbUtil.insert(sql.toString());
        dbUtil.insertClose();
        return result;
    }

    public boolean updateHappy(int userPokemonId, int amount) {
        var dbUtil = new DBUtil();
        var result = false;
        var sql = new StringBuilder();
        sql.append("UPDATE tb_pokemon_detail ");
        sql.append("SET ");
        sql.append("hapiness = " + amount);
        sql.append(" WHERE ");
        sql.append("id = " + userPokemonId);
        System.out.println(sql);

        result = dbUtil.insert(sql.toString());
        dbUtil.insertClose();
        return result;
    }

    public boolean updateHungry(int userPokemonId, int amount) {
        var dbUtil = new DBUtil();
        var result = false;
        var sql = new StringBuilder();
        sql.append("UPDATE tb_pokemon_detail ");
        sql.append("SET ");
        sql.append("hungry = " + amount);
        sql.append(" WHERE ");
        sql.append("id = " + userPokemonId);
        System.out.println(sql);

        result = dbUtil.insert(sql.toString());
        dbUtil.insertClose();
        return result;
    }

    public boolean updateStatus(int userPokemonId, PokemonStatus status) {
        var dbUtil = new DBUtil();
        var result = false;
        var sql = new StringBuilder();
        sql.append("UPDATE tb_pokemon_detail ");
        sql.append("SET ");
        sql.append("status = '");
        sql.append(status.getCode());
        sql.append("' WHERE ");
        sql.append("id = " + userPokemonId);
        System.out.println(sql);

        result = dbUtil.insert(sql.toString());
        dbUtil.insertClose();
        return result;
    }

    public void deletePokemon(int userPokemonId) {
        var dbUtil = new DBUtil();
        var sql = new StringBuilder();
        sql.append("DELETE FROM tb_pokemon_detail ");
        sql.append("WHERE ");
        sql.append("id = " + userPokemonId);
        System.out.println(sql);

        dbUtil.insert(sql.toString());
        dbUtil.insertClose();
    }
}
