# SMMS API
Java 版的sm.ms图床api
## 快速开始
请您查阅[本处](https://github.com/WangTingZheng/smms/wiki/Basic) 的教程来安装并配置您的smms账户信息。

获取用户信息：
```java
public class App {

    public static void main(String[] arg)
    {
        System.out.println(User.getProfile());
    }
}
```
## 功能

- [用户相关](https://github.com/WangTingZheng/smms/wiki/User)
  - 获取用户信息
  - 获取用户token
- [图片相关](https://github.com/WangTingZheng/smms/wiki/Image)
  - 上传图片
  - 根据IP获取临时历史
  - 获取上传历史
  
## 使用的库
- fastjson
- okhttp3
