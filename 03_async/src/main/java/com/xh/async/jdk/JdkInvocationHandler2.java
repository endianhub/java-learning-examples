package com.xh.async.jdk;

import com.xh.async.ext.ExtAsync;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Title: JDK动态代理 - 异步
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/24
 */
public class JdkInvocationHandler2 implements InvocationHandler {

    // 目标对象
    private Object target;
    // 定义线程池
    private ThreadPoolExecutor threadPool;

    public JdkInvocationHandler2(Object target) {
        this.target = target;
        this.threadPool = new ThreadPoolExecutor(5, 6, 3,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3));
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
        // 根据接口的信息查找到目标对象的方法
        Method methodImpl = target.getClass().getMethod(method.getName(), method.getParameterTypes());
        // 使用反射技术执行目标方法（判断接口）
        ExtAsync extAsync = methodImpl.getDeclaredAnnotation(ExtAsync.class);
        if (extAsync == null) {
            // 该方法上没有加上异步注解，则调用目标方法
            return method.invoke(target, args);
        }
        // 单独开启一个线程异步处理目标方法
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    method.invoke(target, args);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        });
        return null;
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
