package com.xh.learn.proxy;


import com.xh.learn.proxy.jdk.MyJdkInvocationHandler;
import com.xh.learn.service.OrderService;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/18
 */
public class MyProxy {

    private static String rt = "\r\t";

    /**
     * loader 加载我们生产好的class文件
     *
     * @param loader
     * @param classInfo
     * @param h
     * @return
     */
    public static Object newProxyInstance(JavaClassLoader loader, Class<?> classInfo, MyJdkInvocationHandler h) {
        try {
            //  1.使用java反射机制拼接$Proxy.java类的源代码
            Method[] methods = classInfo.getMethods();
            String proxyClass = "package com.xh.learn.proxy;" + rt
                    + "import java.lang.reflect.Method;" + rt
                    + "import com.xh.learn.proxy.jdk.MyJdkInvocationHandler;" + rt
                    + "import java.lang.reflect.UndeclaredThrowableException;" + rt
                    + "public class $Proxy1 implements " + classInfo.getName() + "{" + rt
                    + "MyJdkInvocationHandler h;" + rt
                    + "public $Proxy1(MyJdkInvocationHandler h)" + "{" + rt
                    + "this.h= h;" + rt + "}"
                    + getMethodString(methods, classInfo) + rt + "}";
            // 2. 将代理类源码文件写入硬盘中
            String filename = "d:/$Proxy1.java";
            File f = new File(filename);
            FileWriter fw = new FileWriter(f);
            fw.write(proxyClass);
            fw.flush();
            fw.close();
            // 3.需要将$Proxy.java编译成$Proxy.class
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
            Iterable units = fileMgr.getJavaFileObjects(filename);
            JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
            t.call();
            fileMgr.close();
            // 4.将class文件加入到内存中
            Class proxy1Class = loader.findClass("$Proxy1");
            //5.使用java反射机制给函数中赋值
            Constructor m = proxy1Class.getConstructor(MyJdkInvocationHandler.class);
            Object o = m.newInstance(h);
            return o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static String getMethodString(Method[] methods, Class intf) {
        String proxyMe = "";

        for (Method method : methods) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < parameterTypes.length; i++) {
                sb.append(parameterTypes[i].getName() + " ver" + (i + 1));
                if (i < parameterTypes.length - 1) {
                    sb.append(" ,");
                }

            }
            String parameterStr = sb.toString();
            proxyMe = "public " + method.getReturnType().getName() + " " + method.getName() + " ( " + parameterStr + " ) { " +
                    "try {   Method m3 = Class.forName(\"com.xh.learn.service.OrderService\").getMethod(\"addOrder\", Class.forName(\"java.lang.String\"));" +
                    "return (String) h.invoke(this, m3, new Object[]{ver1}); } catch (RuntimeException | Error var4) {  throw var4;  } catch (Throwable var5) {   throw new UndeclaredThrowableException(var5); } " +
                    "" +
                    " } ";

        }
        return proxyMe;
    }

    public static void main(String[] args) {
        MyProxy.newProxyInstance(null, OrderService.class, null);
    }


}
