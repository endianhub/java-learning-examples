## 授权中心服务

1、生成授权链接 - 获取授权码
> http://localhost:8080/oauth/authorize?client_id=mayikt_appid&response_type=code

2、根据授权码获取accessToken
> http://localhost:8080/oauth/token?code=IDXeHy&grant_type=authorization_code&redirect_uri=http://www.mayikt.com/callback&scope=all

