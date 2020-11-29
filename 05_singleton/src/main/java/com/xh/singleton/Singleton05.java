package com.xh.singleton;

/**
 * Title: 枚举单例
 * Description:
 * <p>
 * 枚举创建单例是最安全的，不可以被反射、序列化破解
 *
 * @author H.Yang
 * @date 2020/11/28
 */
public class Singleton05 {

    private Singleton05() {
        System.out.println("Singleton05对象初始化..");
    }

    /**
     * 枚举类型是线程安全的，并且只会装载一次
     */
    private enum Singleton {
        INSTANCE;

        private final Singleton05 instance;

        Singleton() {
            instance = new Singleton05();
        }

        public Singleton05 getInstance() {
            return instance;
        }
    }

    public static Singleton05 getInstance() {

        return Singleton.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        Singleton05 instance1 = Singleton05.getInstance();
        Singleton05 instance2 = Singleton05.getInstance();
        System.out.println(instance1 == instance2);
    }
}
