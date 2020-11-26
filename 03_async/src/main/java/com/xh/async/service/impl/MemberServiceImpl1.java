package com.xh.async.service.impl;

import com.xh.async.manage.MemberServiceManage;
import com.xh.async.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * JDK动态代理
 * <p>
 * JDK动态代理基于接口实现
 * <p>
 * MemberServiceImpl 实现了 MemberService 接口采用的是JDK动态代理（JDK动态代理是基于接口的实现）
 * cglib是采用继承目标对象的模式
 *
 * @Async 异步注解原理：如果要生效需要用到动态代理模式帮我们创建一个代理类，然后根据代理类判断有没有加上注解
 * 注解的原理是AOP技术，AOP的原理是动态代理
 */
@RestController
@Slf4j
public class MemberServiceImpl1 implements MemberService {
    @Autowired
    private MemberServiceManage memberServiceManage;

    @Override
    @GetMapping("/jdk/addUser")
    public String addUser() {
        log.info(">>>流程1");
        // 如果直接调用带有 @Async 注解的方法会报404
        // this
        this.addUserLog();
//        memberServiceManage.addUserLog();
        log.info(">>>流程3");
        return "success";
    }

    /**
     * @return
     * @Async 直接调用带有 @Async 异步注解的方法，会出现404问题，原因：
     * 1. 如果控制类中有加上异步注解，并且有实现接口的情况下则采用的是JDK动态代理，控制器没有注册到容器中
     * 2. 如果控制类中有加上异步注解，并且没有实现接口的情况下则采用的是 cglib 动态代理，控制器可以注册到容器中，但异步注解会失效。
     * @Async 使用的是动态代理技术模式，而动态代理模式需要创建动态代理类
     * 异步注解原理：如果要生效需要用到动态代理模式帮我们创建一个代理类，然后根据代理类判断有没有加上注解
     * 注解的原理是AOP技术，AOP的原理是动态代理
     */
    @Async
    public String addUserLog() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        log.info(">>>流程2");
        return "success";
    }

}
