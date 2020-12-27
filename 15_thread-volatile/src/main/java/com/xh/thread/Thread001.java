package com.xh.thread;

/**
 * 当主线程修改 FLAG 值时不会停止线程
 */
public class Thread001 extends Thread {
    private static boolean FLAG = true;

    @Override
    public void run() {
        while (FLAG) {

        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread001().start();
        Thread.sleep(1000);
        FLAG = false;
    }
}
