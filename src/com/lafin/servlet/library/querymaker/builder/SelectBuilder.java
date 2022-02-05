package com.lafin.servlet.library.querymaker.builder;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class SelectBuilder {

    private Select select;

    private String query;

    private List<Object> parameters;

    public SelectBuilder select(List<String> selectors) {
        select = new Select();
        select.setSelectors(selectors);
        return this;
    }

    public SelectBuilder from(String tableName) {
        select.setTableName(tableName);
        return this;
    }

    public SelectBuilder where(Map<String, Object> condition) {
        select.setCondition(condition);
        return this;
    }

    public SelectBuilder order(Map<String, OrderType> order) {
        select.setOrder(order);
        return this;
    }

    public SelectBuilder offset(Integer offset) {
        select.setOffset(offset);
        return this;
    }

    public SelectBuilder limit(Integer limit) {
        select.setLimit(limit);
        return this;
    }

    public SelectBuilder join(String joinTableName) {
        select.setJoinTableName(joinTableName);
        return this;
    }

    public SelectBuilder on(Map<String, String> joinCondition) {
        select.setJoinCondition(joinCondition);
        return this;
    }

    public ResultSet query() {
        return QueryBuilder.querySelect(select.toQuery(), select.getParameters());
    }
}
