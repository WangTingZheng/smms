package com.wangtingzheng.smms.api;

import com.alibaba.fastjson.JSONObject;
import com.wangtingzheng.smms.actions.Image;
import com.wangtingzheng.smms.authorization.Account;
import com.wangtingzheng.smms.conf.ConfInterface;
import com.wangtingzheng.smms.conf.ConfParent;
import com.wangtingzheng.smms.utils.InformationConverter;

import java.util.HashMap;

/**
 * @author WangTingZheng
 * @date 2020-04-05 15:41
 * @features define function do Image-about action from json file
 */
public class ImageApiFromRoot {

    private String JSONPath;


    public ImageApiFromRoot(Account account) {
        this.JSONPath = account.JSONPath;
    }

    /**
     * access smms user key value from user home and upload image
     * @param path the file you want to upload
     * @return the upload response json object
     */
    public  JSONObject uploadFromRoot(String path)
    {
        ConfParent confParent = new ConfParent(new ConfInterface() {
            @Override
            public JSONObject dealHashMap(HashMap<String, String> para, HashMap<String, String> header) {
                return Image.upload(header, InformationConverter.pathToHashMap(path));
            }
        });
        return confParent.getResponse(JSONPath);
    }

    /**
     * access smms user key value from user home and get temporary History
     * @return the temporary History response json object
     */
    public JSONObject temporaryHistoryFromRoot()
    {
        ConfParent confParent = new ConfParent(new ConfInterface() {
            @Override
            public JSONObject dealHashMap(HashMap<String, String> para, HashMap<String, String> header) {
                return Image.temporaryHistory(header);
            }
        });
        return confParent.getResponse(JSONPath);
    }

    /**
     * access smms user key value from user home and get upload History
     * @return the tupload History response json object
     */
    public  JSONObject uploadHistoryFromRoot()
    {
        ConfParent confParent = new ConfParent(new ConfInterface() {
            @Override
            public JSONObject dealHashMap(HashMap<String, String> para, HashMap<String, String> header) {
                return Image.uploadHistory(header);
            }
        });
        return confParent.getResponse(JSONPath);
    }
}
