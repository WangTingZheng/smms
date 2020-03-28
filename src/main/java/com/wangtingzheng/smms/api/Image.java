package com.wangtingzheng.smms.api;

import com.alibaba.fastjson.JSONObject;
import com.wangtingzheng.smms.conf.ConfInterface;
import com.wangtingzheng.smms.conf.ConfParent;

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

    public static JSONObject upload(String path)
    {
        ConfParent confParent = new ConfParent(new ConfInterface() {
            @Override
            public JSONObject dealHashMap(HashMap<String, String> para, HashMap<String, String> header) {
                return upload(header, pathToHashMap(path));
            }
        });
        return confParent.getResponse();
    }

    public static JSONObject temporaryHistory()
    {
        ConfParent confParent = new ConfParent(new ConfInterface() {
            @Override
            public JSONObject dealHashMap(HashMap<String, String> para, HashMap<String, String> header) {
                return temporaryHistory(header);
            }
        });
        return confParent.getResponse();
    }

    public static JSONObject uploadHistory()
    {
        ConfParent confParent = new ConfParent(new ConfInterface() {
            @Override
            public JSONObject dealHashMap(HashMap<String, String> para, HashMap<String, String> header) {
                return uploadHistory(header);
            }
        });
        return confParent.getResponse();
    }


    public static HashMap<String, String> pathToHashMap(String path)
    {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("smfile", path);
        return hashMap;
    }

}
