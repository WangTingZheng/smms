package com.wangtingzheng.smms.api;

import com.alibaba.fastjson.JSONObject;
import com.wangtingzheng.smms.conf.ConfFile;
import com.wangtingzheng.smms.conf.ConfInterface;
import com.wangtingzheng.smms.conf.ConfParent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import static com.wangtingzheng.smms.utils.Post.post;

public class User {


    public static JSONObject getProfile(HashMap<String,String> header)
    {
        HashMap<String,String> bodyForma = new HashMap<String,String>();
        bodyForma.put("none","");
        HashMap<String,String> para = new HashMap<String, String>();
        String url = "https://sm.ms/api/v2/profile";
        return post(url, para, header, bodyForma);
    }

    public static  JSONObject getToken(HashMap<String,String> para, HashMap<String,String> header)
    {
        HashMap<String,String> bodyForma = new HashMap<String,String>();
        bodyForma.put("none","");
        String url = "https://sm.ms/api/v2/token";
        return post(url, para, header, bodyForma);
    }

    /**
     * access smms user key value from user home and get user profile
     * @return profile response json object
     */
    public static JSONObject getProfile()
    {
        ConfParent confParent = new ConfParent(new ConfInterface() {
            @Override
            public JSONObject dealHashMap(HashMap<String, String> para, HashMap<String, String> header) {
                return getProfile(header);
            }
        });
        return confParent.getResponse();
    }

    /**
     * access smms user key value from user home and get user token
     * @return token response json object
     */
    public static JSONObject getToken()
    {
        ConfParent confParent = new ConfParent(new ConfInterface() {
            @Override
            public JSONObject dealHashMap(HashMap<String, String> para, HashMap<String, String> header) {
                return getToken(para,header);
            }
        });
        return confParent.getResponse();
    }
}
