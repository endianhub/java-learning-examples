## 互联网安全架构设计

### 本节内容

1. 基于过滤器解决xss注入等问题
2. 基于MD5防止篡改Http请求参数数据
4. UrlEncode编码/UrlDecode解码

<br>

### 安全架构设计方案

1. 使用api网关过滤器对防止xss、sql注入问题  <script>alert('ssss')</script>  or 1=1 
2. 对我们的接口实现对称加密，抓包的时候看不到明文的数据，但是可以被破解，因为客户端与服务器都是采用同一个密钥实现加解密，可以通过反编译客户端代码得出密钥实现破解。 Des、aes
3. 使用非对称加密RSA 公钥和私钥互换机制，客户端使用公钥实现加密，服务器端采用私钥实现解密，就算黑客破解出公钥也无法对数据实现解密。对称加解密速度比rsa要快，但是不安全。
4. 可以采用MD5对我们的参数实现验证签名，但是数据还是传输明文，可以防止篡改数据。
5. 互联网电商项目都会采用Https协议 ssl+证书  加密传输 默认443 而我们的Http协议采用明文实现对数据传输，效率比较Https要高，但是不安全。
6. 对我们的api接口实现黑名单和白名单控制
7. 对我们接口实现服务保护、限流、熔断
8. 使用图形验证码防止机器模拟请求
9. 对我们代码使用专门扫描工具实现检测漏洞
10. 在rpc传递参数过程中使用令牌隐藏真实的参数。
11. 数据库表权限框架设计

<br>


### 本节用例

1. 过滤器解决xss注入等问题
2. UrlEncode编码/UrlDecode解码

<b>


#### 补充

##### 什么要对 URL 进行 encode

URL 转义其实也只是为了符合 URL 的规范而已。因为在标准的 URL 规范中中文和很多的字符是不允许出现在 URL 中的。一些特殊字符或中文会发生变化，从而导致数据解析问题。

##### UrlEncode编码/UrlDecode解码使用场景

1. 在 URL 参数值中出现 & 字符拼接参数
2. URL 中含有中文或特殊字符时
3. 常用于 GET 请求
4. 为数据安全性和一致性使用

<br>


在使用过滤器是需要加上 `@Configuration`、`@WebFilter` 这两个注解，否则配置的 filter 是不生效的。
使用 `@WebFilter` 注解等价于在 `web.xml` 中配置 `<filter>` 和 `<filter-mapping>` 元素，容器会在部署时根据指定的属性将该类发布为过滤器。

```xml
<filter>
	<filter-name>XssFilter</filter-name>
	<filter-class>com.xh.security.filter.XssFilter</filter-class>
</filter>
<filter-mapping>
	<filter-name>SimpleFilter</filter-name>
	<servlet-name>SimpleServlet</servlet-name>
</filter-mapping>
```

<br>


#### 模板引擎

##### 常用的模板引擎

- freemarker
- thymeleaf

<br>


##### freemarker优缺点：

>- freemarker优点：

1. 性能。velocity应该是最好的，其次是jsp，普通的页面freemarker性能最差（虽然只是几毫秒到十几毫秒的差距）。但是在复杂页面上（包含大量判断、日期金额格式化）的页面上，freemarker的性能比使用tag和el的jsp好。
2. 宏定义比jsp tag方便
3. 内置大量常用功能。比如html过滤，日期金额格式化等等，使用非常方便。
4. 支持jsp标签
5. 可以实现严格的mvc分离

>- freemarker缺点：

1. 不是官方标准
2. 用户群体和第三方标签库没有jsp多

<br>

```yaml
# 配置freemarker
spring:
  freemarker:
    cache: false # 是否开启模板缓存，默认true。开发时可以设置为 false
    check-template-location: true # 是否检查模板路径是否存在，默认true
    template-loader-path: classpath:/templates # 设置ftl文件路径
    content-type: text/html # 设置文档类型
    charset: UTF-8 # 设置页面编码格式
    suffix: .ftl # 指定模板的后缀，默认为:.ftl
  mvc:
    static-path-pattern: /static/** # 设置静态文件路径，js,css等
```

<br>


##### thymeleaf优缺点

>- thymeleaf优点：

1. 与其它模板引擎相比，Thymeleaf最大的特点是能够直接在浏览器中打开并正确显示模板页面，而不需要启动整个Web应用。Thymeleaf是通过HTML的标签属性渲染标签内容。采用标签属性来进行模板的定义，没有破坏基本的html文档结构，这样就可以直接在浏览器中打开查看布局效果，也为前后端的分离开发奠定基础，前端只需要掌握thymeleaf，就可以单独开发，测试。
2. springboot官方推荐方案。这是 thymeleaf 自己讲，spring boot 默认推荐的是它们，但是从源码的层面来说，spring 团队很开放，它们只是不推荐 jsp 和 velocity，并没有明确表示默认应该是 Thymeleaf。Spring官方支持的服务的渲染模板是Thymeleaf和Freemarker等。

Thymeleaf 在有网络和无网络的环境下皆可运行，它可以让美工在浏览器查看页面的静态效果，也可以让程序员在服务器查看带数据的动态页面效果。这是由于它支持 html原型，然后在 html 标签里增加额外的属性来达到模板+数据的展示方式。浏览器解释 html 时会忽略未定义的标签属性，所以 thymeleaf 的模板可以静态地运行；当有数据返回到页面时，Thymeleaf 标签会动态地替换掉静态内容，使页面动态显示。


>- thymeleaf缺点

实际的开发体验也并不好，模板必须符合xml规范，就这一点就可以判死刑！太不方便了！直接当静态文件打开和以web服务器运行效果也不一样。这些细小的差别出现问题，很难进行排查。

另外，js脚本必须加入/<![CDATA[/标识，否则一个&符号就会导致后台模板合成抛异常，而且错误信息很不友好，害得大家调试了好几个小时才明白是怎么回事。js里面还好办，这样是在html里面含有&等符号，还需要转义，非常麻烦了！


```yaml
spring:
  thymeleaf:
    cache: false # 是否开启模板缓存，默认true。开发时可以设置为 false
    check-template-location: true # 是否检查模板路径是否存在，默认true
    enabled: true # 是否允许MVC使用Thymeleaf，默认为: true
    encoding: UTF-8 # 指定模板的编码，默认为: UTF-8
    mode: LEGACYHTML5 # 指定模板的模式，具体查看StandardTemplateModeHandlers，默认为: HTML5，LEGACYHTML5关闭严格模式
    prefix: classpath:/templates/ # 指定模板的前缀，默认为:classpath:/templates/
    suffix: .html # 指定模板的后缀，默认为:.html
    servlet:
      content-type: text/html # 指定Content-Type，默认为: text/html
  mvc:
    static-path-pattern: /static/** # 指定静态资源处理路径
    view:
      suffix: .html

```


