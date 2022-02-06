package com.lafin.servlet.persistence;

import com.lafin.servlet.model.pokemon.Pokemon;
import com.lafin.servlet.util.DBUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PokemonPersistence {

    public List<Pokemon> getPokemonByIds(List<String> ids) {
        var dbUtil = new DBUtil();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM tb_pokemon ");
            sql.append("WHERE id in ( ");
            sql.append(String.join(", ", ids));
            sql.append(")");
            System.out.println(sql);

            var resultSet = dbUtil.select(sql.toString());
            if (Objects.isNull(resultSet)) {
                dbUtil.resultSetClose();
                return null;
            }

            var pokemons = new ArrayList<Pokemon>();
            while (resultSet.next()) {
                var pokemon = new Pokemon();
                pokemon.setId(resultSet.getInt("id"));
                pokemon.setSerialNumber(resultSet.getString("serialNumber"));
                pokemon.setPokemonName(resultSet.getString("pokemonName"));
                pokemon.setPokemonType(resultSet.getString("pokemonType"));

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

    public Pokemon getPokemonById(int id) {
        var dbUtil = new DBUtil();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM tb_pokemon ");
            sql.append("WHERE id = ");
            sql.append(id);
            System.out.println(sql);

            var pokemon = new Pokemon();
            var resultSet = dbUtil.select(sql.toString());
            if (Objects.isNull(resultSet)) {
                dbUtil.resultSetClose();
                return null;
            }

            if (resultSet.next()) {
                pokemon.setId(resultSet.getInt("id"));
                pokemon.setSerialNumber(resultSet.getString("serialNumber"));
                pokemon.setPokemonName(resultSet.getString("pokemonName"));
                pokemon.setPokemonType(resultSet.getString("pokemonType"));
            }

            dbUtil.resultSetClose();
            return pokemon;
        } catch (SQLException e) {
            e.printStackTrace();
            dbUtil.resultSetClose();
            return null;
        }
    }
}
