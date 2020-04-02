package com.wangtingzheng.smms.conf;

import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ConfParent {
    ConfInterface confInterface;

    public ConfParent(ConfInterface confInterface) {
        this.confInterface = confInterface;
    }


    public HashMap<String, HashMap<String, String>> getResponseHashMap(String path) {
        HashMap<String, HashMap<String,String>> response = new HashMap<>();
        HashMap<String, HashMap<String, String>> config = ConfFile.getConf(path);
        HashMap<String, String> para = null;
        HashMap<String, String> header = null;
        Set<String> set = config.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String next;
            HashMap<String, String> hashMap;
            next = iterator.next();
            hashMap = config.get(next);
            if ("para".equals(next)) {
                para = hashMap;
            } else if ("header".equals(next)) {
                header = hashMap;
            }
        }
        response.put("para",para);
        response.put("header", header);
        return response;
    }

    /**
     * get response from ConfInterface dealHashMap()
     * @return the response json object
     */
    public JSONObject getResponse(String path) {
        HashMap<String, HashMap<String,String>> response = getResponseHashMap(path);
        HashMap<String,String> para = response.get("para");
        HashMap<String,String> header = response.get("header");
        return confInterface.dealHashMap(para, header);
    }
}
