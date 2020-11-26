package com.xh.learn;


import com.xh.learn.cglib.CglibMethodInterceptor;
import com.xh.learn.service.impl.MemberServiceImpl$$EnhancerByCGLIB;

/**
 * Title: cglib动态代理源码分析
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/20
 */
public class AppDemo02 {

    public static void main(String[] args) {

        MemberServiceImpl$$EnhancerByCGLIB serviceImpl$$EnhancerByCGLIB = new MemberServiceImpl$$EnhancerByCGLIB();
        serviceImpl$$EnhancerByCGLIB.setCallbacks(new CglibMethodInterceptor());
        String member = serviceImpl$$EnhancerByCGLIB.addMember("张三");
        System.out.println(member);

    }

}
