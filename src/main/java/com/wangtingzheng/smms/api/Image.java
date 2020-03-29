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

    /**
     * base ip and get temporaryHistory
     * @param header header hashMap, should put Authorization
     * @return json response object contains temporaryHistory information
     */
    public static JSONObject temporaryHistory(HashMap<String,String> header)
    {
        HashMap<String,String> para = new HashMap<String, String>();
        String url = "https://sm.ms/api/v2/history";
        return get(url, para, header);
    }

    /**
     * get all upload History
     * @param header header hashMap, should put Authorization
     * @return json response object contains upload history information
     */
    public static JSONObject uploadHistory(HashMap<String,String> header)
    {
        HashMap<String,String> para = new HashMap<String, String>();
        String url = "https://sm.ms/api/v2/upload_history";
        return get(url, para, header);
    }

    /**
     * access smms user key value from user home and upload image
     * @param path the file you want to upload
     * @return the upload response json object
     */
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

    /**
     * access smms user key value from user home and get temporary History
     * @return the temporary History response json object
     */
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

    /**
     * access smms user key value from user home and get upload History
     * @return the tupload History response json object
     */
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


    /**
     * convert upload file path to body hashMap
     * @param path the file path
     * @return hasHMap which can be add into post/get function
     */
    public static HashMap<String, String> pathToHashMap(String path)
    {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("smfile", path);
        return hashMap;
    }
}
