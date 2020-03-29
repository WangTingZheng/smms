package com.wangtingzheng.smms.conf;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public abstract class ConfInterface {

    public abstract   JSONObject dealHashMap(HashMap<String, String> para, HashMap<String, String> header);

}
