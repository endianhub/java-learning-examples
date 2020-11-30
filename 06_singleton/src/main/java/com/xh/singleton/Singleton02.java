package com.xh.singleton;

/**
 * Title: 懒汉式
 * Description:
 * <p>
 * 非线程安全,在多线程下使用会出现问题
 *
 * @author H.Yang
 * @date 2020/11/28
 */
public class Singleton02 {
    private static Singleton02 singleton02 = null;

    /**
     * 私有化
     */
    private Singleton02() {
        System.out.println("Singleton02对象初始化..");
    }

    public static Singleton02 getInstance() {
        if (singleton02 == null) {
            singleton02 = new Singleton02();
        }
        return singleton02;
    }

    public static void main(String[] args) throws Exception {
        Singleton02 instance1 = Singleton02.getInstance();
        Singleton02 instance2 = Singleton02.getInstance();
        System.out.println(instance1 == instance2);
    }
}
