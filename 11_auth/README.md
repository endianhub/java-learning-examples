## Oauth2.0 授权

### 本节内容

1. 如何保证Api接口合理安全调用
2. oatuh2.0授权认证平台设计原理
3. oatuh2.0认证协议四种模式
4. oatuh2.0实现对api接口保护

<br>

oauth2.0 不是一们技术，而是一种协议，开放授权协议。接口需要被外部合作商户调用。

<br>

### Oauth2.0应用场景

**真实案例：**

集团公司 总公司
----n多个不同子公司

> 如何管理开放接口

- 调用第三方接口 appid、appkey 回调地址 oauth2.授权协议

<br>


### Oauth2.0模式分类
1. 授权码模式 获取accessToken(推荐)
2. 密码模式 username和userpwd  不安全
3. 简化模式
4. 客户端模式

<br>

>调用接口的时候传递令牌为什么比较安全？

- 因为accessToken调用接口临时且唯一。

<br>


#### Oauth2.0协议授权模式

1、申请appid 和appkey 类似QQ账号和密码
> 注意 appid 一旦生成终身不会发生变化，appkey可以修改的。

2、根据appid 生成授权码
> 注意：授权码临时且唯一，只能使用一次。

3、根据授权获取accessToken，根据accessToken调用接口

<br>


#### 使用 Oauth 思路
1、生成授权链接 - 获取授权码
> http://localhost:8080/oauth/authorize?client_id=mayikt_appid&response_type=code

2、根据授权码获取accessToken
> http://localhost:8080/oauth/token?code=w_9MJg&grant_type=authorization_code&redirect_uri=http://www.mayikt.com/callback&scope=all&client_id=mayikt_appid&client_secret=mayikt_pwd

3、根据accessToken获取用户openId
4、根据用户openId获取用户信息

<br>


基于令牌访问接口
> 127.0.0.1:8081/getMember 访问该接口
 
需要在请求中传递 authorization 
> authorization=Bearer a9011867-236b-4751-a508-48ceed63bffc

<br>


### 设计综合oatuh api接口

- 获取access_token请求（/oauth/token）
> http://localhost:8080/oauth/token?code=IDXeHy&grant_type=authorization_code&redirect_uri=http://www.mayikt.com/callback&scope=all

- 检查头肯是否有效请求（/oauth/check_token）
> http://localhost:8080/oauth/check_token?token=ea2c1b1e-5541-4018-8728-07f1ac87e9e8

- 刷新token
> http://localhost:8080/oauth/token?grant_type=refresh_token&refresh_token=fbde81ee-f419-42b1-1234-9191f1f95be9&client_id=demoClientId&client_secret=demoClientSecret

<br><br><br>

### 异常

**异常1：**根据授权码获取 accessToken （访问/oauth/token）报 401 问题？
> 解决办法：一般都是参数问题，需要BasicAuth认证授权 传递参数clent_id、client_secret


<br><br><br>



### 参考
[SpringBoot搭建OAuth授权服务器demo](https://blog.csdn.net/qq_32370913/article/details/105572822)

[Spring Security Oauth2 从零到一完整实践](https://echocow.cn/articles/2019/07/14/1563082088646.html?utm_source=ld246.com)

[整合鉴权体系 Spring Security OAuth2](https://www.yuque.com/keep_zero/spring_cloud/apsq4o)

[解决Spring Boot 从1.x升级到 2.x 后 单点登陆(SSO)问题](https://juejin.cn/post/6844903940144758791)

[基于Spring Boot2 + Spring Security OAuth2 实现单点登陆](https://blog.csdn.net/qq_19671173/article/details/79748422)

[腾讯接入API](https://wiki.connect.qq.com/%E4%BD%BF%E7%94%A8authorization_code%E8%8E%B7%E5%8F%96access_token)

