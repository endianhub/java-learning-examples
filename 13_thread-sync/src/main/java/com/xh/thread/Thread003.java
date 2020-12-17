package com.xh.thread;

/**
 * Title: 重入锁
 * Description:
 *
 * @author H.Yang
 * @date 2020/12/17
 */
public class Thread003 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ",我是子线程");
        a();
    }

    public synchronized void a() {
        // this 锁
        System.out.println(Thread.currentThread().getName() + ",我是方法A 开始");
        b();
        System.out.println(Thread.currentThread().getName() + ",我是方法A 结束");
    }

    public synchronized void b() {
        System.out.println(Thread.currentThread().getName() + ",我是方法B");
    }

    public static void main(String[] args) {
        // 如果我们的锁具有可重入性的情况下
        Thread003 thread003 = new Thread003();
        new Thread(thread003, "线程1").start();
        new Thread(thread003, "线程2").start();
    }
}