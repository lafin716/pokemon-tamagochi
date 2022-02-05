package com.lafin.servlet.library.querymaker.builder;

import com.lafin.servlet.library.querymaker.DatabaseConfig;
import com.lafin.servlet.library.querymaker.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class QueryBuilder {

    public static SelectBuilder select(String selector) {
        var builder = new SelectBuilder();
        var selectors = Arrays.asList(selector);
        return builder.select(selectors);
    }

    public static SelectBuilder select(List<String> selectors) {
        var builder = new SelectBuilder();
        return builder.select(selectors);
    }

    static ResultSet querySelect(String query, List<Object> parameters) {
        var database = new DatabaseConnection(new DatabaseConfig());
        var connection = database.getConnection();
        try {
            var preparedStatement = connection.prepareStatement(query);
            for (int i = 1; i <= parameters.size(); i++) {
                preparedStatement.setObject(i, parameters.get(i - 1));
            }

            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            connection = null;
            return null;
        }
    }
}
