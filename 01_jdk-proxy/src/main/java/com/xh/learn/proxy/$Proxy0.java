package com.xh.learn.proxy;

import com.xh.learn.service.OrderService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * Title: 手写jdk动态代理类
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/18
 */
public class $Proxy0 implements OrderService {
    /**
     * 回调的类
     */
    protected InvocationHandler h;

    public $Proxy0(InvocationHandler h) {
        this.h = h;
    }

    @Override
    public final String addOrder(String var1) {
        try {
            Method m3 = Class.forName("com.xh.learn.service.OrderService")//
                    .getMethod("addOrder", Class.forName("java.lang.String"));
            return (String) this.h.invoke(this, m3, new Object[]{var1});
        } catch (RuntimeException | Error var3) {
            throw var3;
        } catch (Throwable var4) {
            throw new UndeclaredThrowableException(var4);
        }
    }
}
