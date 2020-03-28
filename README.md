## smms
smms是一个用Java写的sm.ms的api
### 安装
在项目的`pom.xml`中添加：
```xml
<dependency>
  <groupId>com.wangtingzheng.api</groupId>
  <artifactId>smms</artifactId>
  <version>1.0-snapshot</version>
</dependency>
```
然后执行：
```xml
mvn install
```
包的版本请随时关注本项目的[Package](https://github.com/WangTingZheng/smms/packages)
### 使用
#### 注册
请前往[smms官网](https://sm.ms/) 注册一个账号，每一个账号都有5G免费空间，注册之后，请前往
```json
User->Dashboard->API token
```
获取您的Secret Token。请您记住他，并且无论如何都不要向别人透露，如果有透露，请及时更改token。
#### json文件
为了您的信息安全，我特意设计了您可以从json文件读取用户名、密码和token的方法，您只需要将您的这些信息写入一个json文件中，然后确保这个json文件不被泄露就行了，您的源代码在什么情况下都不会泄露您的敏感信息，因为这些内容是在内存中被处理的。

您可以在您的计算机上新建一个json文件，比如我在项目根目录下的`conf`下新建了一个叫smms.json的文件，它的格式如下：
```json
{
  "para":
  {
    "username": "******",
    "password": "*************"
  },
  "header":
  {
    "Authorization": "****************"
  }
}
```
在程序中您可以通过`InformationConverter`中的方法来获取json文件里的数据：

```java
String username = InformationConverter.getValue("conf/smms.json", "para", "username");
String password = InformationConverter.getValue("conf/smms.json", "para", "password");
String Authorization = InformationConverter.getValue("conf/smms.json", "header", "Authorization");
```
#### 参数的传入
在本api中，您唯一需要关心的就是参数的传入，至于传入什么样的参数，您可以前往smms的[官方文档](https://doc.sm.ms/) 查阅，参数主要有三类：
1. para：即parameter，参数，也就是url后面跟着的字符串
2. header：头，在smms里只需要关心Authorization，也就是您的token
3. bodyFormat：在上传文件时需要用到，传的是文件
4. url：网页地址，smms的文档会给

对于para，您需要构建一个HashMap，然后put进去参数名称和值，比如说：
```java
HashMap<String,String> para = new HashMap<String, String>();
para.put("username" , username);
para.put("password", password);
```

对于header也同理：
```java
HashMap<String,String> header = new HashMap<String, String>();
header.put("Authorization", Authorization);
```

对于bodyformat就比较复杂了，如果不需要bodyformat，您就需要设置它为none：
```java
HashMap<String,String> bodyformat = new HashMap<String, String>();
header.put("none", "");
```
如果您需要传入文件来上传，你可以传入文件的地址：
```java
HashMap<String,String> body = new HashMap<String, String>();
body.put("smfile","/C:/Users/14037/Pictures/github_education.png");
```
构建好这些HashMap之后，您就可以传入你想要执行的函数中了，您将得到一个json格式的返回值

#### 例子

```java
public class App {

    public static void main(String[] arg)
    {
        String username = InformationConverter.getValue("conf/smms.json", "para", "username");
        String password = InformationConverter.getValue("conf/smms.json", "para", "password");
        String Authorization = InformationConverter.getValue("conf/smms.json", "header", "Authorization");

        HashMap<String,String> para = new HashMap<String, String>();
        para.put("username" , username);
        para.put("password", password);
        HashMap<String,String> header = new HashMap<String, String>();
        header.put("Authorization", Authorization);

        System.out.println(User.getProfile(header));
    }
}
```

成功后您将得到一个字符串：
```json

{
  "code":
       "success",
        "data":
        {
            "disk_limit_raw":5368709120,
            "role":"user",
            "group_expire":"0000-00-00",
            "email_verified":1,
            "disk_usage_raw":6087169,
            "disk_usage":"5.81 MB",
            "disk_limit":"5.00 GB",
            "email":"***********@***.com",
            "username":"*****"
        },
        "RequestId":"A******************6CC0A328AC",
        "success":true,
        "message":"Get user profile success."
}
```