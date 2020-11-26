package com.xh.learn.proxy;

import com.xh.learn.service.OrderService;
import com.xh.learn.service.impl.OrderServiceImpl;

/**
 * Title: 静态代理 - 实现
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/18
 */
public class OrderServiceProxy1 implements OrderService {

    private OrderServiceImpl orderServiceImpl;

    public OrderServiceProxy1(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    @Override
    public String addOrder(String name) {
        System.out.println("静态代理 - 实现模式方式开始.");
        String orderName = orderServiceImpl.addOrder(name);
        System.out.println("静态代理 - 实现模式方式结束.");
        return orderName;
    }
}
