package com.xh.learn;

import com.xh.learn.proxy.jdk.JdkInvocationHandler1;
import com.xh.learn.service.OrderService;
import com.xh.learn.service.impl.OrderServiceImpl;

/**
 * Title: jdk动态代理
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/18
 */
public class AppDemo02 {

    public static void main(String[] args) {

        JdkInvocationHandler1 jdkInvocationHandler1 = new JdkInvocationHandler1(new OrderServiceImpl());
        // 获取代理的生成的class文件
        // 查看 JDK 动态生成的代理类代码
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        // 创建代理类
        OrderService orderService = jdkInvocationHandler1.getProxy();
        String orderName = orderService.addOrder("张三");
        System.out.println(orderName);

    }
}
