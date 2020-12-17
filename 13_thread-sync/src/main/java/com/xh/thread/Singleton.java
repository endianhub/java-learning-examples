package com.xh.thread;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/12/16
 */
public class Singleton {
    private static Singleton singleton;

    private Singleton() {

    }

    public static Singleton getInstance() {
        // 上锁（创建该对象） 第一次判断
        if (singleton == null) {
            synchronized (Singleton.class) {
                // 如果不加判断，当A线程释放锁时，B线程则进入
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
    }

}
