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

    public JSONObject getResponse() {
        HashMap<String, HashMap<String, String>> config = ConfFile.getConf();
        HashMap<String, String> para = null;
        HashMap<String, String> header = null;
        Set<String> set = config.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String next;
            HashMap<String, String> hashMap;
            next = iterator.next();
            hashMap = config.get(next);
            if (next.equals("para")) {
                para = hashMap;
            } else if (next.equals("header")) {
                header = hashMap;
            }
        }
        return confInterface.dealHashMap(para, header);
    }
}
