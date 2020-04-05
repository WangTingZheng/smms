package com.wangtingzheng.smms.authorization;

import com.alibaba.fastjson.JSONObject;
import com.wangtingzheng.smms.api.ImageApiFromRoot;
import com.wangtingzheng.smms.api.ImageApiFromString;

/**
 * @author WangTingZheng
 * @date 2020-04-05 15:40
 * @features the api about image action
 */
public class ImageApi {
    Account account;
    ImageApiFromRoot imageApiFromRoot;
    ImageApiFromString imageApiFromString;

    /**
     * reset account and make ImageApi object be null, refresh object.
     * @param account the new account
     */
    public void setAccount(Account account) {
        this.account = account;
        imageApiFromRoot = null;
        imageApiFromString = null;
    }

    public ImageApi(Account account) {
        this.account = account;
    }

    /**
     * a function to get ImageApiFromRoot object use singleton
     * @return ImageApiFromRoot object which created with account
     */
    private ImageApiFromRoot getImageApiFromRoot() {
        if(imageApiFromRoot == null)
        {
            imageApiFromRoot = new ImageApiFromRoot(account);
        }
        return imageApiFromRoot;
    }

    /**
     * a function to get ImageApiFromString object use singleton
     * @return ImageApiFromString object which created with account
     */
    private ImageApiFromString getImageApiFromString() {
        if(imageApiFromString == null)
        {
            imageApiFromString = new ImageApiFromString(account);
        }
        return imageApiFromString;
    }

    /**
     * upload a picture to sm.ms
     * @param path the picture's path
     * @return a JSON response object
     */
    public JSONObject upload(String path)
    {
        if(account.JSONPath == null)
        {
            return getImageApiFromString().upload(path);
        }
        else
        {
            return getImageApiFromRoot().uploadFromRoot(path);
        }
    }

    /**
     * get temporary History of upload
     * @return a JSON response object
     */
    public JSONObject temporaryHistory()
    {
        if(account.JSONPath == null)
        {
            return getImageApiFromString().temporaryHistory();
        }
        else
        {
            return getImageApiFromRoot().temporaryHistoryFromRoot();
        }
    }

    /**
     * get whole History of upload
     * @return a JSON response object
     */
    public JSONObject uploadHistory()
    {
        if(account.JSONPath == null)
        {
            return getImageApiFromString().uploadHistory();
        }
        else
        {
            return getImageApiFromRoot().uploadHistoryFromRoot();
        }
    }
}
