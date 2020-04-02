package com.wangtingzheng.smms.authorization;

public class Account {
    public String username;
    public String password;
    public String authorizationCode;

    public String JSONPath;

    public Account(String username, String password, String authorizationCode) {
        this.username = username;
        this.password = password;
        this.authorizationCode = authorizationCode;
    }

    public Account(String JSONPath) {
        this.JSONPath = JSONPath;
    }

    public Account() {
        JSONPath = System.getProperty("user.home") + "smms.json";
    }
}
