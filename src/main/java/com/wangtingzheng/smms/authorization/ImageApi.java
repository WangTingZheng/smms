package com.wangtingzheng.smms.authorization;

import com.alibaba.fastjson.JSONObject;
import com.wangtingzheng.smms.actions.Image;
import com.wangtingzheng.smms.api.ImageApiFromRoot;
import com.wangtingzheng.smms.api.ImageApiFromString;

public class ImageApi {
    Account account;
    ImageApiFromRoot imageApiFromRoot;
    ImageApiFromString imageApiFromString;

    public void setAccount(Account account) {
        this.account = account;
    }

    public ImageApi(Account account) {
        this.account = account;
    }

    private ImageApiFromRoot getImageApiFromRoot() {
        if(imageApiFromRoot == null)
        {
            imageApiFromRoot = new ImageApiFromRoot(account);
        }
        return imageApiFromRoot;
    }

    private ImageApiFromString getImageApiFromString() {
        if(imageApiFromString == null)
        {
            imageApiFromString = new ImageApiFromString(account);
        }
        return imageApiFromString;
    }

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
