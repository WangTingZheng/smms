package com.wangtingzheng.smms;

import com.wangtingzheng.smms.authorization.Account;
import com.wangtingzheng.smms.authorization.UserApi;

public class App {
    public static void main(String[] arg)
    {
        Account account = new Account();
        UserApi userApi = new UserApi(account);
        System.out.println(userApi.getToken());
    }
}