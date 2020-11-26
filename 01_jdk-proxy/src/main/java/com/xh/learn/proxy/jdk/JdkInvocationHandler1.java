package com.xh.learn.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Title: jdk动态代理
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/18
 */
public class JdkInvocationHandler1 implements InvocationHandler {

    /**
     * 目标对象（被代理类）
     */
    private Object target;

    public JdkInvocationHandler1(Object target) {
        this.target = target;
    }


    /**
     * JDK动态生成的代理类
     *
     * @param proxy  使用jdk程序生成的代理类
     * @param method 目标方法
     * @param args   方法需要传递的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
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
    public <T> T getProxy() {
//        ClassLoader：获取代理类class文件
//        Class<?>[] interfaces：基于接口拼接代理类源代码
//        InvocationHandler：this 当前类
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
