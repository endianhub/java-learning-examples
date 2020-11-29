package com.xh.singleton;

/**
 * Title:
 * Description:
 * <p>
 * 使用静态代码块创建单例
 *
 * @author H.Yang
 * @date 2020/11/28
 */
public class Singleton04 {
    private static Singleton04 singleton04 = null;

    private Singleton04() {
        System.out.println("Singleton04对象初始化..");
    }

    static {
        System.out.println("当前class被加载");
        singleton04 = new Singleton04();
    }

    public static Singleton04 getInstance() {
        return singleton04;
    }

    public static void main(String[] args) {
        Singleton04 instance1 = Singleton04.getInstance();
        Singleton04 instance2 = Singleton04.getInstance();
        System.out.println(instance1 == instance2);
    }
}
