package com.xh.singleton;

/**
 * Title: 懒汉式双重检验锁
 * Description:
 * <p>
 * 双重锁单例 - 线程安全
 *
 * @author H.Yang
 * @date 2020/11/28
 */
public class Singleton03 {

    private static Singleton03 singleton03;

    private Singleton03() {
        System.out.println("Singleton03对象初始化..");
    }

    public static Singleton03 getInstance() {
        // 上锁（创建该对象） 第一次判断
        if (singleton03 == null) {
            synchronized (Singleton03.class) {
                //第二次判断
                if (singleton03 == null) {
                    singleton03 = new Singleton03();
                }
            }
        }
        return singleton03;
    }

    public static void main(String[] args) {
        Singleton03 instance1 = Singleton03.getInstance();
        Singleton03 instance2 = Singleton03.getInstance();
        System.out.println(instance1 == instance2);
    }
}
