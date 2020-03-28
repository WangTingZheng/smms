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
        System.out.println(User.getProfile());
    }
}
