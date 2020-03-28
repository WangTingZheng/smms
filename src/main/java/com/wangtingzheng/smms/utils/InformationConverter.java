package com.wangtingzheng.smms.utils;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @date 2020-3-35
 * @author 14037
 * @feature convert file JSONObject String
 */
public class InformationConverter {
    public JSONObject fileToJson(String path)
    {
        String text = null;
        String str;
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            while ((str = in.readLine()) != null) {
                text +=str;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(text != null)
        {
            text = text.replace("null", "");
        }
        return JSONObject.parseObject(text);
    }

    public void stringToFile(String text, String path)
    {
        File file = new File(path);
        try(FileWriter writer = new FileWriter(file);
            BufferedWriter out =  new BufferedWriter(writer)
        ){
            out.write(text);
            System.out.println("world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Map<String, Object> getItem(String path, String item)
    {
        JSONObject object = fileToJson(path);
        JSONObject nodeOject = object.getJSONObject(item);
        return nodeOject.getInnerMap();
    }

    /**
     * Convert jsonobject to hashMap
     * @param object the jsonObject need to convert
     * @return the hashMap<String, String>
     */
    public HashMap<String, String> jsonToHasMap(JSONObject object)
    {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        Set<String> set = object.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext())
        {
            String next = iterator.next();
            hashMap.put(next, object.getString(next));
        }
        return hashMap;
    }

    public JSONObject StringToJson(String msg)
    {
        return JSONObject.parseObject(msg);
    }

    public String JsonToString(JSONObject jsonObject)
    {
        return jsonObject.toJSONString();
    }

    public String getValue(String path, String item, String value)
    {
        JSONObject object = fileToJson(path);
        JSONObject nodeOject = object.getJSONObject(item);
        return nodeOject.getString(value);
    }

    /**
     * get a certain item json value from file path and convert it to hashMap
     * @param path the json file path
     * @param item the item of json
     * @return the hashMap<String, String>
     */
    public HashMap<String, String> getItemHasMap(String path, String item)
    {
        JSONObject object = fileToJson(path);
        object = object.getJSONObject(item);
        return jsonToHasMap(object);
    }
}
