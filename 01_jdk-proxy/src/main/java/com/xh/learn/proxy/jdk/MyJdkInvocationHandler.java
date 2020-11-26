package com.xh.learn.proxy.jdk;

import java.lang.reflect.Method;

/**
 * Title: jdk动态代理源码分析
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/18
 */
public interface MyJdkInvocationHandler {

    Object invoke(Object proxy, Method method, Object[] args) throws Exception;

}
