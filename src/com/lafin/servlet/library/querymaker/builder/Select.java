package com.lafin.servlet.library.querymaker.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Select {

    private List<String> selectors;

    private String tableName;

    private Map<String, Object> condition;

    private Map<String, OrderType> order;

    private Integer offset;

    private Integer limit;

    private String joinTableName;

    private Map<String, String> joinCondition;

    private List<Object> parameters = new ArrayList<>();

    public List<String> getSelectors() {
        return selectors;
    }

    public void setSelectors(List<String> selectors) {
        this.selectors = selectors;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Map<String, Object> getCondition() {
        return condition;
    }

    public void setCondition(Map<String, Object> condition) {
        this.condition = condition;
    }

    public Map<String, OrderType> getOrder() {
        return order;
    }

    public void setOrder(Map<String, OrderType> order) {
        this.order = order;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getJoinTableName() {
        return joinTableName;
    }

    public void setJoinTableName(String joinTableName) {
        this.joinTableName = joinTableName;
    }

    public Map<String, String> getJoinCondition() {
        return joinCondition;
    }

    public void setJoinCondition(Map<String, String> joinCondition) {
        this.joinCondition = joinCondition;
    }

    public List<Object> getParameters() {
        return parameters;
    }

    public String toQuery() {
        StringBuilder query = new StringBuilder();

        query.append("SELECT ");
        query.append(parseSelector());
        query.append("FROM ");
        query.append(tableName);

        if (joinTableName != null && !joinTableName.isEmpty()) {
            query.append("JOIN ");
            query.append(joinTableName);
        }

        if (!joinCondition.isEmpty()) {
            query.append("ON ");
            query.append(parseJoinCondition());
        }

        if (!condition.isEmpty()) {
            query.append("WHERE ");
            query.append(parseCondition());
        }

        if (!order.isEmpty()) {
            query.append("ORDER ");
            query.append(parseOrder());
        }

        if (limit != null && limit > 0) {
            query.append("LIMIT ");
            if (offset != null && offset > 0) {
                query.append(parseOffset());
            }
            query.append(parseLimit());
        }

        return query.toString();
    }

    private String parseSelector() {
        var query = new StringBuilder();
        var serial = String.join("`, `", selectors);
        query.append("`");
        query.append(serial);
        query.append("` ");

        return query.toString();
    }

    private String parseJoinCondition() {
        var query = new StringBuilder();
        var serial = String.join(" = ? AND ", joinCondition.keySet());
        query.append(serial);

        parameters.addAll(joinCondition.values());

        return query.toString();
    }

    private String parseCondition() {
        var query = new StringBuilder();
        var serial = String.join("` = ? AND `", condition.keySet());
        query.append("`");
        query.append(serial);
        query.append("` = ? ");

        parameters.addAll(condition.values());

        return query.toString();
    }

    private String parseOrder() {
        var query = new StringBuilder();
        var serial = order.entrySet().stream()
                .map(entry -> String.join(" ", entry.getKey(), entry.getValue().toString()))
                .collect(Collectors.joining(", "));
        query.append(serial);
        query.append(" ");

        return query.toString();
    }

    private String parseOffset() {
        var query = new StringBuilder();
        query.append("?, ");

        parameters.add(offset);

        return query.toString();
    }

    private String parseLimit() {
        var query = new StringBuilder();
        query.append("? ");

        parameters.add(limit);

        return query.toString();
    }
}
