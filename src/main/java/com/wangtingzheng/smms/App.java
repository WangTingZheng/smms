package com.wangtingzheng.smms;


import com.wangtingzheng.smms.api.Image;
import com.wangtingzheng.smms.api.User;
import com.wangtingzheng.smms.utils.InformationConverter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] arg)
    {
        String username = InformationConverter.getValue("conf/smms.json", "para", "username");
        String password = InformationConverter.getValue("conf/smms.json", "para", "password");
        String Authorization = InformationConverter.getValue("conf/smms.json", "header", "Authorization");

        HashMap<String,String> para = new HashMap<String, String>();
        para.put("username" , username);
        para.put("password", password);
        HashMap<String,String> header = new HashMap<String, String>();
        header.put("Authorization", Authorization);

        System.out.println(User.getProfile(header));
    }
}
