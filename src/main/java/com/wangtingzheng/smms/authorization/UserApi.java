package com.wangtingzheng.smms.authorization;

import com.alibaba.fastjson.JSONObject;
import com.wangtingzheng.smms.api.UserApiFromRoot;
import com.wangtingzheng.smms.api.UserApiFromString;

/**
 * @author WangTingZheng
 * @date 2020-04-05 15:40
 * @features the api about user actions
 */
public class UserApi {
    Account account;
    UserApiFromString userApiFromString;
    UserApiFromRoot userApiFromRoot;

    /**
     * reset account and make UserApi object be null, refresh object.
     * @param account the new account
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * a function to get ImageApiFromRoot object use singleton
     * @return ImageApiFromRoot object which created with account
     */
    private UserApiFromString getUserApiFromString() {
        if(userApiFromString == null)
        {
            userApiFromString = new UserApiFromString(account);
        }
        return userApiFromString;
    }


    /**
     * a function to get ImageApiFromString object use singleton
     * @return ImageApiFromString object which created with account
     */
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

    /**
     * get user token
     * @return a JSON response object
     */
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

    /**
     * get user profile
     * @return a JSON response object
     */
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
