package com.xh.learn;

import com.xh.learn.cglib.CglibMethodInterceptor;
import com.xh.learn.service.MemberService;
import com.xh.learn.service.impl.MemberServiceImpl;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * Title: cglib动态代理实现
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/20
 */
public class AppDemo01 {

    public static void main(String[] args) {
        // 生成代理类
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\core");

        Enhancer enhancer = new Enhancer();
        // 继承类
        enhancer.setSuperclass(MemberServiceImpl.class);
        // 回调类
        enhancer.setCallback(new CglibMethodInterceptor());
        // 创建代理对象
        // 注意：如果非继承或实现时会出现类型转换异常
        MemberService memberService = (MemberServiceImpl) enhancer.create();
        String member = memberService.addMember("张三");
        System.out.println(member);
    }

}
