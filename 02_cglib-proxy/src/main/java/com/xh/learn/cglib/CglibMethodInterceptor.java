package com.xh.learn.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/20
 */
public class CglibMethodInterceptor implements MethodInterceptor {
    /**
     *
     * @param obj cglib生成的代理类对象
     * @param method 目标方法
     * @param args 目标参数
     * @param methodProxy 根据该代理类通过 fastclass 查找到目标方法直接执行
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println(">>cglib动态代理执行开始<<");
        Object result = methodProxy.invokeSuper(obj, args);
        System.out.println(">>cglib动态代理执行结束<<");
        return result;
    }
}
