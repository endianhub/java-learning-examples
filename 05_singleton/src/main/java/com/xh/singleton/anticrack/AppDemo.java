package com.xh.singleton.anticrack;


import java.lang.reflect.Constructor;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/28
 */
public class AppDemo {

    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.xh.singleton.anticrack.Singleton02");
        Constructor<?> constructor = aClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton02 instance02 = Singleton02.getInstance();
        Singleton02 singleton01 = (Singleton02) constructor.newInstance();
        System.out.println(singleton01 == instance02);

    }
}
