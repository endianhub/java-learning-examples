package com.xh.thread;

/**
 * Title: 创建线程
 * Description:
 *
 * @author H.Yang
 * @date 2020/12/10
 */
public class Thread001 extends Thread {
    /**
     * 就是在run方法中写线程需要执行的代码
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ",我是子线程");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "，我是主线程");
        new Thread001().start();
    }
}
