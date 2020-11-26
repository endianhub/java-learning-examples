package com.xh.reflection;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Title: 反射
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/16
 */
public class AppDemo {

    public static Object newInstance(Class clazz) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 1. 使用java的反射技术拼接OrderServiceImpl源代码
        String clazzName = clazz.getSimpleName() + "Impl";
        StringBuffer sb = new StringBuffer();
        sb.append("package com.xh.reflection.service;");
        sb.append("import " + clazz.getName() + ";");
        sb.append("public class " + clazzName + " implements " + clazz.getSimpleName() + " {");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            sb.append("@Override ");
            sb.append("public " + method.getReturnType().getSimpleName() + " " + method.getName() + "(String name){");
            sb.append("return \"AAAA\";");
            sb.append("}");
        }
        sb.append("}");

        // 2.将java源代码编译为class文件。
        // 在java中使用什么技术实现编译class文件? 答：clazz.forName()
//        clazz.forName()作用：
//        1)装载一个类并且对其进行实例化的操作。
//        2)装载过程中使用到的类加载器是当前类。
        String pathname = "D:\\Workspace\\JavaWorkspace\\practice\\phase7\\01-reflection\\src\\main\\java\\com\\xh\\reflection\\service\\" + clazzName + ".java";
        File file = new File(pathname);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(sb.toString());
        fileWriter.flush();
        fileWriter.close();

        // 3. 编译class文件
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = javaCompiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> iterable = fileManager.getJavaFileObjects(pathname);
        JavaCompiler.CompilationTask task = javaCompiler.getTask(null, fileManager, null, null, null, iterable);
        task.call();
        fileManager.close();

        // 4. 使用加载器将class文件读取到内存中
        JavaClassLoader classLoader = new JavaClassLoader();
        Class<?> aClass = classLoader.findClass(clazzName);
        Object o = aClass.newInstance();
        return o;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException, IOException {
        // 方法一
//        Class clazz = UserEntity.class;
//        System.out.println(clazz.getSimpleName());
        // 方法二
//        Class<?> clazzInfo = Class.forName("com.xh.reflection.UserEntity");
//        System.out.println(clazzInfo.getSimpleName());

        // 使用java的反射技术new对象
//        Class<?> clazzInfo = Class.forName("com.xh.reflection.UserEntity");
//        实例化对象，无参构造参数
//        UserEntity user = (UserEntity) clazzInfo.newInstance();
//        user.setName("张三");
//        System.out.println(user.getName());

        // 实例化对象，有参构造参数
//        Constructor<?> constructor = clazzInfo.getConstructor(String.class);
//        UserEntity user = (UserEntity) constructor.newInstance("李四");
//        System.out.println(user.getName());

//        Constructor<?> constructor = clazzInfo.getConstructor(Integer.class, String.class);
//        UserEntity user = (UserEntity) constructor.newInstance(1, "李四");
//        System.out.println(user.getId());
//        System.out.println(user.getName());

        // 利用反射给属性赋值
        // name是私有属性，再赋值是如果属性是私有属性，必须开启权限，否则会报权限异常。
//        Field field = clazzInfo.getDeclaredField("name");
//        // 设置权限
//        field.setAccessible(true);
//        UserEntity user = (UserEntity) clazzInfo.newInstance();
//        field.set(user, "张三");
//        System.out.println(user.getName());

        // 利用反射调用方法
        // 共有方法传参
//        Method declaredMethod = clazzInfo.getDeclaredMethod("add");
//        Method declaredMethod = clazzInfo.getDeclaredMethod("addName", String.class);
        // 私有方法传参
//        Method declaredMethod = clazzInfo.getDeclaredMethod("addName2", String.class);
//        declaredMethod.setAccessible(true);
//        // 实例化对象
//        UserEntity user = (UserEntity) clazzInfo.newInstance();
//        // 获取返回值
//        String str = (String) declaredMethod.invoke(user, "张三");
//        System.out.println(str);


//        OrderService orderService = (OrderService) newInstance(OrderService.class);
//        String name = orderService.addOrder("AAAA");
//        System.out.println(name);
    }
}
