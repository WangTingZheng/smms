package com.wangtingzheng.smms.actions;

import com.alibaba.fastjson.JSONObject;
import com.wangtingzheng.smms.conf.ConfInterface;
import com.wangtingzheng.smms.conf.ConfParent;
import java.util.HashMap;
import static com.wangtingzheng.smms.utils.Post.post;
import static com.wangtingzheng.smms.utils.Get.get;

/**
 * @author WangTingZheng
 * @date 2020-04-05 15:39
 * @features based action about image
 */
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

}
