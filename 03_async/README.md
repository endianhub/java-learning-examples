## @Async 异步注解

### 本节内容：

1. 基于 JDK 动态代理手写 @Async 实现异步代理
2. 基于 AOP 手写 @Async 实现异步代理
3. Spring 中如何使用 JDK 与 CGLIB 动态代理
4. this 为什么不能经过代理类拦截
5. 错用 @Async 导致 MVC 控制类无法注入
6. 分析 @Async 异步注解会失效

<br>

### 本节用例：

1. 手写基于JDK动态代理 - 无效代理方式：当方法中使用的是 this 调用的是当前对象，而不是代理类对象，this 调用的方法则不走代理类；
2. 手写基于JDK动态代理：在调用时传递了代理对象，在目标对象中则通过代理对象调用方法
3. 使用动态代理实现异步请求：根据接口的信息查找到目标对象的方法，然后再利用反射技术获取对象方法或类上是否带有指定注解，以此判断是否执行目标方法
4. 利用AOP实现JDK与CGLIB动态代理

<br>

#### @Async 异步注解原理

如果要生效需要用到动态代理模式帮我们创建一个代理类，然后根据代理类判断有没有加上注解。注解的原理是AOP技术，AOP的原理是动态代理

@Async 使用的是动态代理技术模式，而动态代理模式需要创建动态代理类

<br>

### 难点解析

1、this 为什么不能经过代理类拦截？

> 答：this 使用的是当前对象，而不是代理类对象，所以 this 调用的方法则不走代理类。

2、 错用 @Async 导致 SpringMVC 控制类无法注入或控制类为什么实现接口就会导致无法注册到 SpringMVC 容器中？

> 答：原因是动态代理模式没有把找到注解，所以无法注册到容器中。
> - JDK动态代理是基于接口实现的，接口上没有加上 @RestController 注解（一般在目标对象上加注解--接口实现类）,代理对象无法注册到容器中，所以会失效。
> - CGLIB动态代理使用继承模式，继承目标对象 @RestController 注解可以直接继承，cglib生成的代理对象就可以注册到SpringMVC容器中

3、分析 @Async 异步注解会失效
> 答：总结两点
> - 不要在当前类中使用 @async ，因为没有经过代理类
> - 官方建议新建一个类，专门处理异步操作

4、@Async 直接调用带有 @Async 异步注解的方法，会出现404问题

> 答：原因有两点
> - 如果控制类中有加上异步注解，并且有实现接口的情况下则采用的是JDK动态代理，控制器没有注册到容器中
> - 如果控制类中有加上异步注解，并且没有实现接口的情况下则采用的是 cglib 动态代理，控制器可以注册到容器中，但异步注解会失效。


<br>
<br>
<br>
<br>



 
> **注意：**
- 在项目中不建议直接 new Thread() ，建议 new 线程池的方式开启线程