package com.wangtingzheng.smms.api;

import com.alibaba.fastjson.JSONObject;
import com.wangtingzheng.smms.actions.User;
import com.wangtingzheng.smms.authorization.Account;

/**
 * @author WangTingZheng
 * @date 2020-04-05 15:41
 * @features define function do User-about action from json file
 */
public class UserApiFromRoot {

    private String JSONPath;


    public UserApiFromRoot(Account account) {
        this.JSONPath = account.JSONPath;
    }

    public JSONObject getToken()
    {
        return User.getToken(JSONPath);
    }

    public JSONObject getProfile()
    {
        return User.getProfile(JSONPath);
    }
}
