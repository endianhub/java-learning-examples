package com.xh.singleton;

/**
 * Title: 饿汉单例
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/28
 */
public class Singleton01 {
    // 当class文件被加载的时候就创建该对象
    public static final Singleton01 singleton01 = new Singleton01();

    private Singleton01() {
        System.out.println("Singleton01对象初始化..");
    }

    public static Singleton01 getInstance() {
        return singleton01;
    }

    public static void main(String[] args) {
        System.out.println(Singleton01.singleton01 == Singleton01.singleton01);
//        singleton01 instance1 = singleton01.getInstance();
//        singleton01 instance2 = singleton01.getInstance();
//        System.out.println(instance1==instance2);
    }

}
