package com.wangtingzheng.smms.utils;

import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class Get {

    /**
     * change hashMap header to Request.Builder object
     * @param header the hasHMap header
     * @return the Request.builder
     */
    public static Request.Builder returnHeaders(HashMap<String,String> header)
    {
        return Post.returnHeaders(header);
    }

    /**
     * change hashMap parameter to String, make it be addable to url
     * @param para the parameter hasMap
     * @return a String value which can be added after url
     */
    public static String returnPara(HashMap<String,String> para)
    {
        return Post.returnPara(para);
    }


    /**
     * send a get to a site
     * @param url the website url
     * @param para the parameter hashMap, use put to add
     * @param header the header hasMap, use put to add
     * @return a response json object
     */
    public static JSONObject get(String url, HashMap<String,String> para, HashMap<String,String> header)
    {
        String wholeUrl = url + returnPara(para);
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request.Builder builder = returnHeaders(header);
        Request request = builder
                .url(wholeUrl)
                .method("GET", null)
                .addHeader("accept", "*/*")
                .addHeader("connection", "Keep-Alive")
                .addHeader("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)")
                .build();

        try {
            Response response = client.newCall(request).execute();
            String res = Objects.requireNonNull(response.body()).string();
            InformationConverter informationConverter = new InformationConverter();
            return InformationConverter.StringToJson(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
