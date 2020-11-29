package com.xh.singleton.anticrack;

/**
 * Title: 防止被反射破解
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/28
 */
public class Singleton02 {
    private static Singleton02 singleton02 = null;

    /**
     * 私有化
     */
    private Singleton02() throws Exception {
        if (singleton02 != null) {
            throw new Exception("该对象已经创建");
        }

        System.out.println("Singleton02对象初始化..");
    }

    public static Singleton02 getInstance() throws Exception {
        if (singleton02 == null) {
            singleton02 = new Singleton02();
        }
        return singleton02;
    }

}
