package com.xh.async;

import com.xh.async.jdk.JdkInvocationHandler2;
import com.xh.async.service.OrderService;
import com.xh.async.service.impl.OrderServiceImpl3;

/**
 * Title: 使用代理实现异步请求
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/24
 */
public class AppDemo03 {

    public static void main(String[] args) {
        OrderServiceImpl3 orderServiceImpl3 = new OrderServiceImpl3();
        JdkInvocationHandler2 jdkInvocationHandler = new JdkInvocationHandler2(orderServiceImpl3);
        // 使用Jdk动态代理生成代理对象
        OrderService orderServicePorxy = jdkInvocationHandler.getProxy();
        //传递目标对象
        orderServiceImpl3.setProxy(orderServicePorxy);
        // 通过代理对象调用方法
        orderServicePorxy.addOrder();
    }
}
