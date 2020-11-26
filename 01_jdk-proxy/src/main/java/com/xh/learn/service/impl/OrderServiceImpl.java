package com.xh.learn.service.impl;

import com.xh.learn.service.OrderService;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/18
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public String addOrder(String name) {
        System.out.println(">>> Proxy OrderService study. <<<");
        return "add order name : " + name;
    }
}
