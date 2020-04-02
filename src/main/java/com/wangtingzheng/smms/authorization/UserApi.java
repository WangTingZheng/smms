package com.wangtingzheng.smms.authorization;

import com.alibaba.fastjson.JSONObject;
import com.wangtingzheng.smms.api.UserApiFromRoot;
import com.wangtingzheng.smms.api.UserApiFromString;

public class UserApi {
    Account account;
    UserApiFromString userApiFromString;
    UserApiFromRoot userApiFromRoot;

    public void setAccount(Account account) {
        this.account = account;
    }

    private UserApiFromString getUserApiFromString() {
        if(userApiFromString == null)
        {
            userApiFromString = new UserApiFromString(account);
        }
        return userApiFromString;
    }

    private UserApiFromRoot getUserApiFromRoot() {
        if(userApiFromRoot == null)
        {
            userApiFromRoot = new UserApiFromRoot(account);
        }
        return userApiFromRoot;
    }

    public UserApi(Account account) {
        this.account = account;
    }

    public JSONObject getToken()
    {
        if(account.JSONPath == null)
        {
            return getUserApiFromString().getToken();
        }else
        {
            return getUserApiFromRoot().getToken();
        }
    }

    public JSONObject getProfile()
    {
        if(account.JSONPath == null)
        {
            return getUserApiFromString().getProfile();
        }else
        {
            return getUserApiFromRoot().getProfile();
        }
    }
}
