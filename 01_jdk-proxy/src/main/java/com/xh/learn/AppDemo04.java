package com.xh.learn;

import com.xh.learn.proxy.jdk.impl.MyJdkInvocationHandlerImpl;
import com.xh.learn.service.OrderService;
import com.xh.learn.service.impl.OrderServiceImpl;

/**
 * Title: 纯手写Jdk动态代理
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/18
 */
public class AppDemo04 {

    public static void main(String[] args) {

        MyJdkInvocationHandlerImpl myJdkInvocationHandler = new MyJdkInvocationHandlerImpl(new OrderServiceImpl());
        OrderService orderService = myJdkInvocationHandler.getMyProxy();
        orderService.addOrder("张三");

    }
}
