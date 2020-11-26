package com.xh.learn.proxy;

import com.xh.learn.service.impl.OrderServiceImpl;

/**
 * Title: 静态代理继承模式
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/18
 */
public class OrderServiceProxy2 extends OrderServiceImpl {

    @Override
    public String addOrder(String name) {
        System.out.println("静态代理 - 继承模式方式开始:");
        String result = super.addOrder(name);
        System.out.println("静态代理 - 继承模式方式结束:");
        return result;
    }

}
