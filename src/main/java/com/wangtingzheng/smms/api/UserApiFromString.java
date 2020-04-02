package com.wangtingzheng.smms.api;

import com.alibaba.fastjson.JSONObject;
import com.wangtingzheng.smms.actions.User;
import com.wangtingzheng.smms.authorization.Account;
import com.wangtingzheng.smms.utils.InformationConverter;

import java.util.HashMap;

public class UserApiFromString {
    private HashMap<String,String> para;
    private HashMap<String,String> header;
    private HashMap<String,String> bodyForma;

    HashMap<String, HashMap<String,String>> response;

    public UserApiFromString(Account account) {
        String username = account.username;
        String password = account.password;
        String authorizationCode = account.authorizationCode;
        response = InformationConverter.StringToHashMap(username, password, authorizationCode);
        para = response.get("para");
        header = response.get("header");
        bodyForma = response.get("bodyForma");
    }

    public  JSONObject getToken()
    {
        return User.getToken(para, header);
    }

    public JSONObject getProfile()
    {
        return User.getProfile(header);
    }


}
