package com.xh.learn.proxy.jdk.impl;

import com.xh.learn.proxy.JavaClassLoader;
import com.xh.learn.proxy.MyProxy;
import com.xh.learn.proxy.jdk.MyJdkInvocationHandler;

import java.lang.reflect.Method;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/19
 */
public class MyJdkInvocationHandlerImpl implements MyJdkInvocationHandler {

    /**
     * 目标对象（被代理类）
     */
    private Object target;

    public MyJdkInvocationHandlerImpl(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        System.out.println("使用Jdk动态代理打印日志开始" + args[0]);
        // 通过反射调用目标方法
        // invoke作用：使用生产代理类拦截回掉
        Object obj = method.invoke(target, args);
        System.out.println("使用Jdk动态代理打印日志结束" + args[0]);
        return obj;
    }


    /**
     * 使用JDK生成代理类对象
     *
     * @param <T>
     * @return
     */
    public <T> T getMyProxy() {
//        ClassLoader：获取代理类class文件
//        Class<?>[] interfaces：基于接口拼接代理类源代码
//        InvocationHandler：this 当前类
        return (T) MyProxy.newProxyInstance(new JavaClassLoader(), target.getClass().getInterfaces()[0], this);
    }
}
