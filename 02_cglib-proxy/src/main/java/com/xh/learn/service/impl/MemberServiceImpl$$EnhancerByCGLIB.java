package com.xh.learn.service.impl;

import net.sf.cglib.core.ReflectUtils;
import net.sf.cglib.core.Signature;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Factory;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 动态代理生成对象
 */
/* compiled from: <generated> */
public class MemberServiceImpl$$EnhancerByCGLIB extends MemberServiceImpl implements Factory {
    private static Object CGLIB$CALLBACK_FILTER;
    public static Object CGLIB$FACTORY_DATA;
    private static Callback[] CGLIB$STATIC_CALLBACKS = null;
    private static ThreadLocal CGLIB$THREAD_CALLBACKS = null;
    private static Method CGLIB$addMember$0$Method = null;
    private static MethodProxy CGLIB$addMember$0$Proxy = null;
    private static Method CGLIB$clone$4$Method = null;
    private static MethodProxy CGLIB$clone$4$Proxy = null;
    private static Object[] CGLIB$emptyArgs = null;
    private static Method CGLIB$equals$1$Method = null;
    private static MethodProxy CGLIB$equals$1$Proxy = null;
    private static Method CGLIB$hashCode$3$Method = null;
    private static MethodProxy CGLIB$hashCode$3$Proxy = null;
    private static Method CGLIB$toString$2$Method = null;
    private static MethodProxy CGLIB$toString$2$Proxy = null;
    private boolean CGLIB$BOUND;
    private MethodInterceptor CGLIB$CALLBACK_0;

    static {
        try {
            CGLIB$STATICHOOK1();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public MemberServiceImpl$$EnhancerByCGLIB() {
        CGLIB$BIND_CALLBACKS(this);
    }

    private static final void CGLIB$BIND_CALLBACKS(Object obj) {
        MemberServiceImpl$$EnhancerByCGLIB memberServiceImpl$$enhancerByCGLIB = (MemberServiceImpl$$EnhancerByCGLIB) obj;
        if (!memberServiceImpl$$enhancerByCGLIB.CGLIB$BOUND) {
            memberServiceImpl$$enhancerByCGLIB.CGLIB$BOUND = true;
            Object obj2 = CGLIB$THREAD_CALLBACKS.get();
            if (obj2 != null || (obj2 = CGLIB$STATIC_CALLBACKS) != null) {
                memberServiceImpl$$enhancerByCGLIB.CGLIB$CALLBACK_0 = (MethodInterceptor) obj2;
            }
        }
    }

    public static void CGLIB$SET_STATIC_CALLBACKS(Callback[] callbackArr) {
        CGLIB$STATIC_CALLBACKS = callbackArr;
    }

    public static void CGLIB$SET_THREAD_CALLBACKS(Callback[] callbackArr) {
        CGLIB$THREAD_CALLBACKS.set(callbackArr);
    }

    static void CGLIB$STATICHOOK1() throws ClassNotFoundException {
        CGLIB$THREAD_CALLBACKS = new ThreadLocal();
        CGLIB$emptyArgs = new Object[0];
        Class<?> cls = Class.forName("com.xh.learn.service.impl.MemberServiceImpl$$EnhancerByCGLIB");
        Class<?> cls2 = Class.forName("java.lang.Object");
        Method[] findMethods = ReflectUtils.findMethods(new String[]{"equals", "(Ljava/lang/Object;)Z", "toString", "()Ljava/lang/String;", "hashCode", "()I", "clone", "()Ljava/lang/Object;"}, cls2.getDeclaredMethods());
        CGLIB$equals$1$Method = findMethods[0];
        CGLIB$equals$1$Proxy = MethodProxy.create(cls2, cls, "(Ljava/lang/Object;)Z", "equals", "CGLIB$equals$1");
        CGLIB$toString$2$Method = findMethods[1];
        CGLIB$toString$2$Proxy = MethodProxy.create(cls2, cls, "()Ljava/lang/String;", "toString", "CGLIB$toString$2");
        CGLIB$hashCode$3$Method = findMethods[2];
        CGLIB$hashCode$3$Proxy = MethodProxy.create(cls2, cls, "()I", "hashCode", "CGLIB$hashCode$3");
        CGLIB$clone$4$Method = findMethods[3];
        CGLIB$clone$4$Proxy = MethodProxy.create(cls2, cls, "()Ljava/lang/Object;", "clone", "CGLIB$clone$4");
        Class<?> cls3 = Class.forName("com.xh.learn.service.impl.MemberServiceImpl");
        CGLIB$addMember$0$Method = ReflectUtils.findMethods(new String[]{"addMember", "(Ljava/lang/String;)Ljava/lang/String;"}, cls3.getDeclaredMethods())[0];
        CGLIB$addMember$0$Proxy = MethodProxy.create(cls3, cls, "(Ljava/lang/String;)Ljava/lang/String;", "addMember", "CGLIB$addMember$0");
    }

    public static MethodProxy CGLIB$findMethodProxy(Signature signature) {
        String obj = signature.toString();
        switch (obj.hashCode()) {
            case -508378822:
                if (obj.equals("clone()Ljava/lang/Object;")) {
                    return CGLIB$clone$4$Proxy;
                }
                break;
            case 919144156:
                if (obj.equals("addMember(Ljava/lang/String;)Ljava/lang/String;")) {
                    return CGLIB$addMember$0$Proxy;
                }
                break;
            case 1826985398:
                if (obj.equals("equals(Ljava/lang/Object;)Z")) {
                    return CGLIB$equals$1$Proxy;
                }
                break;
            case 1913648695:
                if (obj.equals("toString()Ljava/lang/String;")) {
                    return CGLIB$toString$2$Proxy;
                }
                break;
            case 1984935277:
                if (obj.equals("hashCode()I")) {
                    return CGLIB$hashCode$3$Proxy;
                }
                break;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final String CGLIB$addMember$0(String str) {
        return MemberServiceImpl$$EnhancerByCGLIB.super.addMember(str);
    }

    /* access modifiers changed from: package-private */
    public final Object CGLIB$clone$4() throws CloneNotSupportedException {
        return MemberServiceImpl$$EnhancerByCGLIB.super.clone();
    }

    /* access modifiers changed from: package-private */
    public final boolean CGLIB$equals$1(Object obj) {
        return MemberServiceImpl$$EnhancerByCGLIB.super.equals(obj);
    }

    /* access modifiers changed from: package-private */
    public final int CGLIB$hashCode$3() {
        return MemberServiceImpl$$EnhancerByCGLIB.super.hashCode();
    }

    /* access modifiers changed from: package-private */
    public final String CGLIB$toString$2() {
        return MemberServiceImpl$$EnhancerByCGLIB.super.toString();
    }

    @Override
    public final String addMember(String str) {
        MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
        if (methodInterceptor == null) {
            CGLIB$BIND_CALLBACKS(this);
            methodInterceptor = this.CGLIB$CALLBACK_0;
        }
        if (methodInterceptor == null) {
            return MemberServiceImpl$$EnhancerByCGLIB.super.addMember(str);
        }
        try {
            return (String) methodInterceptor.intercept(this, CGLIB$addMember$0$Method, new Object[]{str}, CGLIB$addMember$0$Proxy);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @Override
    public final Object clone() throws CloneNotSupportedException {
        MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
        if (methodInterceptor == null) {
            CGLIB$BIND_CALLBACKS(this);
            methodInterceptor = this.CGLIB$CALLBACK_0;
        }
        try {
            return methodInterceptor != null ? methodInterceptor.intercept(this, CGLIB$clone$4$Method, CGLIB$emptyArgs, CGLIB$clone$4$Proxy) : MemberServiceImpl$$EnhancerByCGLIB.super.clone();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @Override
    public final boolean equals(Object obj) {
        MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
        if (methodInterceptor == null) {
            CGLIB$BIND_CALLBACKS(this);
            methodInterceptor = this.CGLIB$CALLBACK_0;
        }
        if (methodInterceptor == null) {
            return MemberServiceImpl$$EnhancerByCGLIB.super.equals(obj);
        }
        Object intercept = null;
        try {
            intercept = methodInterceptor.intercept(this, CGLIB$equals$1$Method, new Object[]{obj}, CGLIB$equals$1$Proxy);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        if (intercept == null) {
            return false;
        }
        return ((Boolean) intercept).booleanValue();
    }

    @Override
    public Callback getCallback(int i) {
        CGLIB$BIND_CALLBACKS(this);
        switch (i) {
            case 0:
                return this.CGLIB$CALLBACK_0;
            default:
                return null;
        }
    }

    @Override
    public Callback[] getCallbacks() {
        CGLIB$BIND_CALLBACKS(this);
        return new Callback[]{this.CGLIB$CALLBACK_0};
    }

    @Override
    public final int hashCode() {
        MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
        if (methodInterceptor == null) {
            CGLIB$BIND_CALLBACKS(this);
            methodInterceptor = this.CGLIB$CALLBACK_0;
        }
        if (methodInterceptor == null) {
            return MemberServiceImpl$$EnhancerByCGLIB.super.hashCode();
        }
        Object intercept = null;
        try {
            intercept = methodInterceptor.intercept(this, CGLIB$hashCode$3$Method, CGLIB$emptyArgs, CGLIB$hashCode$3$Proxy);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        if (intercept == null) {
            return 0;
        }
        return ((Number) intercept).intValue();
    }

    @Override
    public Object newInstance(Callback callback) {
        CGLIB$SET_THREAD_CALLBACKS(new Callback[]{callback});
        MemberServiceImpl$$EnhancerByCGLIB memberServiceImpl$$enhancerByCGLIB = new MemberServiceImpl$$EnhancerByCGLIB();
        CGLIB$SET_THREAD_CALLBACKS(null);
        return memberServiceImpl$$enhancerByCGLIB;
    }

    @Override
    public Object newInstance(Class[] clsArr, Object[] objArr, Callback[] callbackArr) {
        CGLIB$SET_THREAD_CALLBACKS(callbackArr);
        switch (clsArr.length) {
            case 0:
                MemberServiceImpl$$EnhancerByCGLIB memberServiceImpl$$enhancerByCGLIB = new MemberServiceImpl$$EnhancerByCGLIB();
                CGLIB$SET_THREAD_CALLBACKS(null);
                return memberServiceImpl$$enhancerByCGLIB;
            default:
                throw new IllegalArgumentException("Constructor not found");
        }
    }

    @Override
    public Object newInstance(Callback[] callbackArr) {
        CGLIB$SET_THREAD_CALLBACKS(callbackArr);
        MemberServiceImpl$$EnhancerByCGLIB memberServiceImpl$$enhancerByCGLIB = new MemberServiceImpl$$EnhancerByCGLIB();
        CGLIB$SET_THREAD_CALLBACKS(null);
        return memberServiceImpl$$enhancerByCGLIB;
    }

    @Override
    public void setCallback(int i, Callback callback) {
        switch (i) {
            case 0:
                this.CGLIB$CALLBACK_0 = (MethodInterceptor) callback;
                return;
            default:
                return;
        }
    }

    @Override
    public void setCallbacks(Callback[] callbacks) {

    }

    public void setCallbacks(Callback callbackArr) {
        this.CGLIB$CALLBACK_0 = (MethodInterceptor) callbackArr;
    }

    @Override
    public final String toString() {
        MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
        if (methodInterceptor == null) {
            CGLIB$BIND_CALLBACKS(this);
            methodInterceptor = this.CGLIB$CALLBACK_0;
        }
        try {
            return methodInterceptor != null ? (String) methodInterceptor.intercept(this, CGLIB$toString$2$Method, CGLIB$emptyArgs, CGLIB$toString$2$Proxy) : MemberServiceImpl$$EnhancerByCGLIB.super.toString();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}