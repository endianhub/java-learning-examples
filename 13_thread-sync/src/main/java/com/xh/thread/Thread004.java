package com.xh.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Title: Lock锁 - 重入锁
 * Description:
 * <p>
 * 只需要在多线程下可能出现问题的代码块上加锁
 *
 * @author H.Yang
 * @date 2020/12/17
 */
public class Thread004 implements Runnable {
    private static int count = 100;
    // 重入锁
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (count > 0) {
            ticket();
        }
    }

    public void ticket() {
        // 获取锁
        try {
            Thread.sleep(30);
        } catch (Exception e) {

        }
        try {
            // 获取锁
            lock.lock();
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + ",正在出票第" + (100 - count + 1) + "张");
                count--;
            }
        } catch (Exception e) {

        } finally {
            // 释放锁
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        Thread004 thread007 = new Thread004();
        new Thread(thread007, "窗口1").start();
        new Thread(thread007, "窗口2").start();
    }
}
