package com.wangtingzheng.smms.conf;

import com.wangtingzheng.smms.utils.InformationConverter;

import java.util.*;

public class ConfFile {

    private static HashMap<String, HashMap<String,String>> confList = new HashMap<String, HashMap<String, String>>();

    /**
     * get user information from ~/smms.json and convert into hashMap
     * @return a hashMap contain user information stores in ~/smms.json
     */
    public static HashMap<String, HashMap<String,String>> getConf(String path)
    {
        if (confList.size() == 0)
        {
            String username = InformationConverter.getValue(path, "para", "username");
            String password = InformationConverter.getValue(path , "para", "password");
            String authorization = InformationConverter.getValue(path, "header", "Authorization");
            confList = InformationConverter.StringToHashMap(username, password, authorization);
        }
        return confList;
    }


}
