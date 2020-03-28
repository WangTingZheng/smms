package com.wangtingzheng.smms.utils;

import com.alibaba.fastjson.JSONObject;
import com.wangtingzheng.smms.api.Image;
import com.wangtingzheng.smms.utils.InformationConverter;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 *
 */
public class Post {

    public  static void main(String[] args) throws IOException {
        String username = InformationConverter.getValue("conf/smms.json", "para", "username");
        String password = InformationConverter.getValue("conf/smms.json", "para", "password");
        String Authorization = InformationConverter.getValue("conf/smms.json", "header", "Authorization");

        HashMap<String,String> para = new HashMap<String, String>();
        para.put("username" , username);
        para.put("password", password);
        HashMap<String,String> header = new HashMap<String, String>();
        header.put("Authorization", Authorization);
        HashMap<String,String> body = new HashMap<String, String>();
        body.put("smfile","/C:/Users/14037/Pictures/github_education.png");

        JSONObject data = Image.upload(header, body);
        System.out.println(data);
    }



    /**
     * change hashMap parameter to String, make it be addable to url
     * @param para the parameter hasMap
     * @return a String value which can be added after url
     */
    public static String returnPara(HashMap<String,String> para)
    {
        String res = "";
        boolean first = true;
        Set<String> set = para.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext())
        {
            String next ;
            String one ;
            next = iterator.next();
            one = next +"="+para.get(next);
            if(first)
            {
                res += "?";
                first = false;
            }
            else
            {
                res +="&";
            }
            res += one;
        }
        return res;
    }

    /**
     * change hashMap header to Request.Builder object
     * @param header the hasHMap header
     * @return the Request.builder
     */
    public static Request.Builder returnHeaders(HashMap<String,String> header)
    {
        Request.Builder builder = new Request.Builder();
        Set<String> set = header.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext())
        {
            String next;
            next = iterator.next();
            builder.addHeader(next, header.get(next));
        }
        return builder;
    }

    /**
     * change bodyformat hashMap to RequestBody objects
     * @param bodyFormat the body hashMap, if use none, put("none",""), if form-data, put(key,value)
     * @return RequestBody
     */
    public static RequestBody returnBody(HashMap<String,String> bodyFormat)
    {

        MediaType mediaType = MediaType.parse("text/plain");

        if(bodyFormat.containsKey("none"))
        {
            return RequestBody.create(mediaType, "");
        }
        else
        {
            MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
            Set<String> set = bodyFormat.keySet();
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext())
            {
                String next;
                next = iterator.next();
                builder = builder.addFormDataPart("smfile",bodyFormat.get(next),
                    RequestBody.create(MediaType.parse("application/octet-stream"),
                            new File(bodyFormat.get(next))));
            }
            return builder.build();
        }
    }

    /**
     * send a post to a site
     * @param url the website url
     * @param para the parameter hashMap, use put to add
     * @param header the header hasMap, use put to add
     * @param bodyFormat the body hashMap, if use none, put("none",""), if form-data, put(key,value)
     * @return a response json object
     */
    public static JSONObject post(String url, HashMap<String,String> para, HashMap<String,String> header, HashMap<String,String> bodyFormat)
    {
        String wholeUrl = url + returnPara(para);
        RequestBody body = returnBody(bodyFormat);
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        Request.Builder builder = returnHeaders(header);
        Request request = builder.url(wholeUrl)
                            .method("POST", body)
                            .addHeader("accept", "*/*")
                            .addHeader("connection", "Keep-Alive")
                            .addHeader("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)")
                            .build();

        try {
            Response response = client.newCall(request).execute();
            String res = Objects.requireNonNull(response.body()).string();
            InformationConverter informationConverter = new InformationConverter();
            return informationConverter.StringToJson(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
