package com.wangtingzheng.smms.conf;

import com.alibaba.fastjson.JSONObject;
import com.wangtingzheng.smms.utils.InformationConverter;

import java.util.*;

public class ConfFile {

    private static HashMap<String, HashMap<String,String>> confList = new HashMap<String, HashMap<String, String>>();

    public static HashMap<String, HashMap<String,String>> getConf()
    {
        if (confList.size() == 0)
        {
            String filePath = System.getProperty("user.home") + "/smms.json";
            String username = InformationConverter.getValue(filePath, "para", "username");
            String password = InformationConverter.getValue(filePath , "para", "password");
            String Authorization = InformationConverter.getValue(filePath, "header", "Authorization");

            HashMap<String,String> para = new HashMap<String, String>();
            para.put("username" , username);
            para.put("password", password);
            HashMap<String,String> header = new HashMap<String, String>();
            header.put("Authorization", Authorization);
            confList.put("para", para);
            confList.put("header", header);
        }
        return confList;
    }


}
