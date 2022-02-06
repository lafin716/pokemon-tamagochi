package com.lafin.servlet.persistence;

import com.lafin.servlet.model.pokemon.Level;
import com.lafin.servlet.util.DBUtil;

public class LevelPersistence {

    public Level getLevel(int level) {
        var dbUtil = new DBUtil();
        var sql = new StringBuilder();
        sql.append("SELECT * ");
        sql.append("FROM tb_exp ");
        sql.append("WHERE level = ");
        sql.append(level);
        System.out.println(sql);

        try {
            var levelObj = new Level();
            var result = dbUtil.select(sql.toString());
            if (result.next()) {
                levelObj.setId(result.getInt("id"));
                levelObj.setLevel(result.getInt("level"));
                levelObj.setExp(result.getInt("exp"));

                return levelObj;
            }

            dbUtil.resultSetClose();
            return levelObj;
        } catch (Exception e) {
            e.printStackTrace();
            dbUtil.resultSetClose();
            return null;
        }
    }
}
