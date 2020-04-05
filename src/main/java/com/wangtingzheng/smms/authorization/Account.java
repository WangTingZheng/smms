package com.wangtingzheng.smms.authorization;

/**
 * @author WangTingZheng
 * @date 2020-04-05 15:40
 * @features a class define smms account
 */
public class Account {
    public String username;
    public String password;
    public String authorizationCode;

    public String JSONPath;

    /**
     * create a account object though String
     * @param username  smms username
     * @param password smms password
     * @param authorizationCode smms key
     */
    public Account(String username, String password, String authorizationCode) {
        this.username = username;
        this.password = password;
        this.authorizationCode = authorizationCode;
    }

    /**
     * create a account object though json file
     * @param JSONPath the json file path
     */
    public Account(String JSONPath) {
        this.JSONPath = JSONPath;
    }

    /**
     * create a account object though json file which is stored in user.home/smms.json
     */
    public Account() {
        JSONPath = System.getProperty("user.home") + "smms.json";
    }
}
