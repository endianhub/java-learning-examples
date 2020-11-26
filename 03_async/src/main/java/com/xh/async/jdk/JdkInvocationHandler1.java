package com.xh.async.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Title: JDK动态代理
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/24
 */
public class JdkInvocationHandler1 implements InvocationHandler {

    // 目标对象
    private Object target;

    public JdkInvocationHandler1(Object target) {
        this.target = target;
    }

    /**
     * @param proxy
     * @param method 接口中的方法
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(">>>> 目标对象开始 <<<<");
        Object invokeObj = method.invoke(target, args);
        System.out.println(">>>> 目标对象结束 <<<<");
        return invokeObj;
    }

    /**
     * 生成代理对象
     *
     * @param <T>
     * @return
     */
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
