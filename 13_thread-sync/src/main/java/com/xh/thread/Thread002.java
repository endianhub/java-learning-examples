package com.xh.thread;

/**
 * Title: 模拟死锁
 * Description:
 *
 * @author H.Yang
 * @date 2020/12/16
 */
public class Thread002 implements Runnable {
    private static int count = 100;
    private Boolean flag = true;
    private Object object = new Object();

    @Override
    public void run() {
        if (flag) {
            while (count > 0) {
                synchronized (object) {
                    try {

                        Thread.sleep(10);
                    } catch (Exception e) {

                    }
                    ticket();
                }
            }

        } else {
            while (count > 0) {
                ticket();
            }

        }
    }

    private synchronized void ticket() {
        synchronized (object) {

            try {
                Thread.sleep(10);
            } catch (Exception e) {

            }
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + ",正在开始出售:" + (100 - count + 1));
                count--;
            }

        }

    }


    public static void main(String[] args) {
        Thread002 thread004 = new Thread002();
        new Thread(thread004, "窗口1").start();
        try {

            Thread.sleep(40);
            thread004.flag = false;
        } catch (Exception e) {

        }
        new Thread(thread004, "窗口2").start();
    }
}