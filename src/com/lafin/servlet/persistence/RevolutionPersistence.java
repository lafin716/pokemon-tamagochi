package com.lafin.servlet.persistence;

import com.lafin.servlet.model.pokemon.Revolution;
import com.lafin.servlet.util.DBUtil;

public class RevolutionPersistence {

    public Revolution getRevolution(int pokemonId) {
        var dbUtil = new DBUtil();
        var sql = new StringBuilder();
        sql.append("SELECT * ");
        sql.append("FROM tb_revolution ");
        sql.append("WHERE pokemonId = ");
        sql.append(pokemonId);
        System.out.println(sql);

        try {
            var revolution = new Revolution();
            var result = dbUtil.select(sql.toString());
            if (result.next()) {
                revolution.setId(result.getInt("id"));
                revolution.setPokemonId(result.getInt("pokemonId"));
                revolution.setNextPokemonId(result.getInt("nextPokemonId"));
                revolution.setRequireLevel(result.getInt("level"));
            }

            dbUtil.resultSetClose();
            return revolution;
        } catch (Exception e) {
            e.printStackTrace();
            dbUtil.resultSetClose();
            return null;
        }
    }
}
