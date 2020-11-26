package com.xh.async;

import com.xh.async.jdk.JdkInvocationHandler1;
import com.xh.async.service.OrderService;
import com.xh.async.service.impl.OrderServiceImpl2;

/**
 * Title: 走代理方式
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/24
 */
public class AppDemo02 {

    public static void main(String[] args) {
        OrderServiceImpl2 orderServiceImpl2 = new OrderServiceImpl2();
        JdkInvocationHandler1 jdkInvocationHandler1 = new JdkInvocationHandler1(orderServiceImpl2);
        // 使用Jdk动态代理生成代理对象
        OrderService orderServicePorxy = jdkInvocationHandler1.getProxy();
        //传递目标对象
        orderServiceImpl2.setProxy(orderServicePorxy);
        // 通过代理对象调用方法
        orderServicePorxy.addOrder();
    }
}
