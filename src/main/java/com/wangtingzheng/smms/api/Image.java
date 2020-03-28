package com.wangtingzheng.smms.api;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

import static com.wangtingzheng.smms.utils.Post.post;
import static com.wangtingzheng.smms.utils.Get.get;

public class Image {
    /**
     * upload image file to sm.ms
     * @param header put authorization to header hashMap
     * @param bodyForma put key, and value(image file path)
     * @return response json object
     */
    public static JSONObject upload(HashMap<String,String> header, HashMap<String,String> bodyForma)
    {
        HashMap<String,String> para = new HashMap<String, String>();
        String url = "https://sm.ms/api/v2/upload";
        return post(url, para, header, bodyForma);
    }

    public static JSONObject temporaryHistory(HashMap<String,String> header)
    {
        HashMap<String,String> para = new HashMap<String, String>();
        String url = "https://sm.ms/api/v2/history";
        return get(url, para, header);
    }

    public static JSONObject uploadHistory(HashMap<String,String> header)
    {
        HashMap<String,String> para = new HashMap<String, String>();
        String url = "https://sm.ms/api/v2/upload_history";
        return get(url, para, header);
    }


}
