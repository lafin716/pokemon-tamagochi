package com.lafin.servlet.library.querymaker;

public class DatabaseConfig {

    private String driver = "com.mysql.cj.jdbc.Driver";

    private String url = "jdbc:mysql://localhost:3306/user";

    private String username = "test_user";

    private String password = "test";

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
