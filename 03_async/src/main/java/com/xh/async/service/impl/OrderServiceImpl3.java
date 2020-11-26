package com.xh.async.service.impl;

import com.xh.async.ext.ExtAsync;
import com.xh.async.service.OrderService;

/**
 * Title: Demo2 - 使用代理对象
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/24
 */

public class OrderServiceImpl3 implements OrderService {
    private OrderService orderServiceProxy;

    @Override
    public String addOrder() {
        System.out.println(Thread.currentThread().getName() + " >>>>> 流程1");
        orderServiceProxy.addOrderLog();
        System.out.println(Thread.currentThread().getName() + " >>>>> 流程3");
        return null;
    }

    @ExtAsync
    @Override
    public void addOrderLog() {
        System.out.println(Thread.currentThread().getName() + " >>>>> 流程2");
    }

    public void setProxy(OrderService proxy) {
        this.orderServiceProxy = proxy;
    }
}
