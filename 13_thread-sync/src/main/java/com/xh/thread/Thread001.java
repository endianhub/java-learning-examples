package com.xh.thread;

/**
 * Title: 模拟多线程抢票
 * Description:
 *
 * @author H.Yang
 * @date 2020/12/16
 */
public class Thread001 implements Runnable {

    // 票数为100张
    private int count = 100;


    // 示例1：出票会有重复
//    @Override
//    public void run() {
//        while (count > 0) {
//            System.out.println(Thread.currentThread().getName() + "，正在出票第" + (100 - count + 1) + "张");
//            count--;
//        }
//    }

    // 示例2：出票重复和超卖，出现101张
//    @Override
//    public void run() {
//        while (count > 0) {
//            try {
//                Thread.sleep(30);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "，正在出票第" + (100 - count + 1) + "张");
//            count--;
//        }
//    }

    // 示例3：如果在该方法上使用 synchronized 则变为单线程
//    @Override
//    public synchronized void run() {
//        while (count > 0) {
//            try {
//                Thread.sleep(30);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "，正在出票第" + (100 - count + 1) + "张");
//            count--;
//        }
//    }


    // 示例4：
    @Override
    public void run() {
        while (count > 0) {
//            ticket1();
//            ticket2();
            ticket3();
        }
    }

    /**
     * 方法一：票数超卖问题
     */
//    public synchronized void ticket1() {
//        try {
//            Thread.sleep(30);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName() + ",正在出票第" + (100 - count + 1) + "张");
//        count--;
//
//    }

    /**
     * 方法二：解决票数超卖问题
     */
    public synchronized void ticket2() {
        // 判断票数是否超卖
        if (count > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ",正在出票第" + (100 - count + 1) + "张");
            count--;
        }

    }

    /**
     * 方法三：解决票数超卖问题
     */
    public void ticket3() {
        synchronized (this) {
            // 判断票数是否超卖
            if (count > 0) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ",正在出票第" + (100 - count + 1) + "张");
                count--;
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread001 ticketThread = new Thread001();
        new Thread(ticketThread, "窗口1").start();
        new Thread(ticketThread, "窗口2").start();

    }
}
