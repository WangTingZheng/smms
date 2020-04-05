package com.wangtingzheng.smms.actions;

import com.alibaba.fastjson.JSONObject;
import com.wangtingzheng.smms.conf.ConfInterface;
import com.wangtingzheng.smms.conf.ConfParent;

import java.util.HashMap;

import static com.wangtingzheng.smms.utils.Post.post;

/**
 * @author WangTingZheng
 * @date 2020-04-05 15:40
 * @features based action about user
 */
public class User {

    //static String JSONPath = System.getProperty("user.home") + "/smms.json";

    /**
     * get user profile information
     * @param header  header hashMap, should put Authorization
     * @return  json response object contains user profile information
     */
    public static JSONObject getProfile(HashMap<String,String> header)
    {
        HashMap<String,String> bodyForma = new HashMap<String,String>();
        bodyForma.put("none","");
        HashMap<String,String> para = new HashMap<String, String>();
        String url = "https://sm.ms/api/v2/profile";
        return post(url, para, header, bodyForma);
    }

    /**
     * get user token information
     * @param para  parameter hashMap, should put Authorization
     * @param header header hashMap, should put Authorization
     * @return  json response object contains user token information
     */
    public static JSONObject getToken(HashMap<String,String> para, HashMap<String,String> header)
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
    public static JSONObject getProfile(String JSONPath)
    {
        ConfParent confParent = new ConfParent(new ConfInterface() {
            @Override
            public JSONObject dealHashMap(HashMap<String, String> para, HashMap<String, String> header) {
                return getProfile(header);
            }
        });
        return confParent.getResponse(JSONPath);
    }

    /**
     * access smms user key value from user home and get user token
     * @return token response json object
     */
    public static JSONObject getToken(String JSONPath)
    {
        ConfParent confParent = new ConfParent(new ConfInterface() {
            @Override
            public JSONObject dealHashMap(HashMap<String, String> para, HashMap<String, String> header) {
                return getToken(para,header);
            }
        });
        return confParent.getResponse(JSONPath);
    }
}
