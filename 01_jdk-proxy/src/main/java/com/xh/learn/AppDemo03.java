package com.xh.learn;

import com.xh.learn.proxy.jdk.JdkInvocationHandler2;
import com.xh.learn.service.OrderService;
import com.xh.learn.service.impl.OrderServiceImpl;

/**
 * Title: 手写jdk动态代理生成类
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/18
 */
public class AppDemo03 {

    public static void main(String[] args) {

        JdkInvocationHandler2 jdkInvocationHandler2 = new JdkInvocationHandler2(new OrderServiceImpl());
        // 获取代理的生成的class文件
        // 查看 JDK 动态生成的代理类代码
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        // 创建代理类
//        Object proxy = jdkInvocationHandler.getProxy();
        OrderService orderService = jdkInvocationHandler2.getProxy();
        String orderName = orderService.addOrder("张三");
        System.out.println(orderName);

    }
}
