package com.wangtingzheng.smms;

import com.wangtingzheng.smms.authorization.Account;
import com.wangtingzheng.smms.authorization.UserApi;

/**
 * @author WangTingZheng
 * @date 2020-04-05 15:42
 * @features test class
 */
public class App {
    public static void main(String[] arg)
    {
        Account account = new Account("username","password","key");
        UserApi userApi = new UserApi(account);
        System.out.println(userApi.getToken());
    }
}