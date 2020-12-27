package com.xh.thread;

/**
 * 当主线程修改 FLAG 值时则停止线程
 */
public class Thread002 extends Thread {
    private static volatile boolean FLAG = true;

    @Override
    public void run() {
        while (FLAG) {

        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread002().start();
        Thread.sleep(1000);
        FLAG = false;
    }
}
