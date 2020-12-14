package com.xh.thread;

/**
 * Title: 创建线程
 * Description:
 *
 * @author H.Yang
 * @date 2020/12/10
 */
public class Thread002 implements Runnable {
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + ",我是子线程");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        // 方法一：
        new Thread(new Thread002()).start();
        System.out.println("mayikt");

        // 方法二：
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName() + ",我是子线程");
//            }
//        }).start();

        // 方法三
//        new Thread(() -> System.out.println(Thread.currentThread().getName() + ",我是子线程")).start();

    }
}
