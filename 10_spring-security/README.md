## Spring Security 权限控制框架

### 本节内容

1. 什么是 Spring Security
2. Spring Security 认证模式
3. Spring Security 修改登陆页面
4. 数据库RBAC权限模型架构设计
5. Spring Security 实现动态权限控制

<br>


#### 什么是 Spring Security

Spring Security是一个能够为基于Spring的企业应用系统提供声明式的安全访问控制解决方案的安全框架。
它提供了一组可以在Spring应用上下文中配置的Bean，充分利用了Spring IoC，DI（控制反转Inversion of Control ,DI:Dependency Injection 依赖注入）和AOP（面向切面编程）功能，为应用系统提供声明式的安全访问控制功能，减少了为企业系统安全控制编写大量重复代码的工作。

<br>

**Security 作用**
- 权限控制：formLogin、httpBasic
- 身份验证

<br>


#### Spring Security 认证模式

**Spring Security 认证模式：**
- formLogin：基于表单形式
- httpBasic：是一种Http协议基本认证方式（浏览器弹窗式）

<br>


### 本节用例

- 使用 Security 手动配置权限授权和授权规则
- 使用数据库权限授权和授权规则

<br><br><br>



> #### 注意

- Spring Security 有默认的登录页面，也可以手动指定登录页面。
- 登陆时报错：There is no PasswordEncoder mapped for the id "null"。原因:升级为Security5.0以上密码支持多中加密方式，恢复以前模式
- Spring Security 还提供了一些注解，比如：@PreAuthorize 等，想要了解更多可以上网了解。

<br><br><br><br>


> #### 参考文献：

[手把手带你入门 Spring Security](https://www.cnblogs.com/lenve/p/11242055.html)

[Spring Security（二）--WebSecurityConfigurer配置以及filter顺序](https://juejin.cn/post/6844903872096387080)

[Spring Security基于数据库配置权限（角色，路径）](https://blog.csdn.net/pujiaolin/article/details/73928491)

[Spring Security Config : HttpSecurity安全配置器 ExpressionUrlAuthorizationConfigurer](https://blog.csdn.net/andy_zhang2007/article/details/93376098)

[Spring Security数据库身份认证和角色授权](https://www.jianshu.com/p/c3b79a625d84)
