package com.xh.learn;

import com.xh.learn.proxy.OrderServiceProxy1;
import com.xh.learn.proxy.OrderServiceProxy2;
import com.xh.learn.service.impl.OrderServiceImpl;

/**
 * Title: 静态代理
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/18
 */
public class AppDemo01 {

    public static void main(String[] args) {
        //实现模式
        OrderServiceProxy1 orderServiceProxy1 = new OrderServiceProxy1(new OrderServiceImpl());
        String name1 = orderServiceProxy1.addOrder("张三1");
        System.out.println(name1);

        System.out.println("\n");

        // 继承模式
        OrderServiceProxy2 orderServiceProxy2 = new OrderServiceProxy2();
        String name2 = orderServiceProxy2.addOrder("张三2");
        System.out.println(name2);
    }
}
