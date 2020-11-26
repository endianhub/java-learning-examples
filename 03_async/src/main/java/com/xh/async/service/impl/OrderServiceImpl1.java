package com.xh.async.service.impl;

import com.xh.async.service.OrderService;

/**
 * Title: Demo1 - 不走代理方式
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/24
 */

public class OrderServiceImpl1 implements OrderService {
    private OrderService orderServiceProxy;

    @Override
    public String addOrder() {
        System.out.println(Thread.currentThread().getName() + " >>>>> 流程1");
        // demo1: this 不是代理对象，不会走代理类
        this.addOrderLog();
        System.out.println(Thread.currentThread().getName() + " >>>>> 流程3");
        return null;
    }

    @Override
    public void addOrderLog() {
        System.out.println(Thread.currentThread().getName() + " >>>>> 流程2");
    }

    public void setProxy(OrderService proxy) {
        this.orderServiceProxy = proxy;
    }
}
