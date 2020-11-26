package com.xh.learn.proxy.jdk;

import com.xh.learn.proxy.$Proxy0;

/**
 * Title: jdk动态代理源码分析
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/18
 */
public class JdkInvocationHandler2 extends JdkInvocationHandler1 {

    public JdkInvocationHandler2(Object target) {
        super(target);
    }

    @Override
    public <T> T getProxy() {
        return (T) new $Proxy0(this);
    }
}
