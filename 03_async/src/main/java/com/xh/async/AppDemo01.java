package com.xh.async;

import com.xh.async.jdk.JdkInvocationHandler1;
import com.xh.async.service.OrderService;
import com.xh.async.service.impl.OrderServiceImpl1;

/**
 * Title: 不走代理方式
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/24
 */
public class AppDemo01 {

    public static void main(String[] args) {
        JdkInvocationHandler1 jdkInvocationHandler1 = new JdkInvocationHandler1(new OrderServiceImpl1());
        // 使用Jdk动态代理生成代理对象
        OrderService orderServicePorxy = jdkInvocationHandler1.getProxy();
        // 通过代理对象调用方法
        orderServicePorxy.addOrder();

    }
}
