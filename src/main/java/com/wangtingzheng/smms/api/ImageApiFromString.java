package com.wangtingzheng.smms.api;

import com.alibaba.fastjson.JSONObject;
import com.wangtingzheng.smms.actions.Image;
import com.wangtingzheng.smms.authorization.Account;
import com.wangtingzheng.smms.utils.InformationConverter;

import java.util.HashMap;

public class ImageApiFromString {

    private HashMap<String,String> para;
    private HashMap<String,String> header;

    HashMap<String, HashMap<String,String>> response;

    public ImageApiFromString(Account account) {
        String username = account.username;
        String password = account.password;
        String authorizationCode = account.authorizationCode;
        response = InformationConverter.StringToHashMap(username, password, authorizationCode);
        para = response.get("para");
        header = response.get("header");
    }


    public JSONObject upload(String path)
    {
        HashMap<String,String> bodyForma;
        bodyForma = InformationConverter.pathToHashMap(path);
        return Image.upload(header, bodyForma);
    }

    public JSONObject temporaryHistory()
    {
        return Image.temporaryHistory(header);
    }

    public JSONObject uploadHistory()
    {
        return Image.uploadHistory(header);
    }
}
