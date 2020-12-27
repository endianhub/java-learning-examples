package com.xh.thread;

/**
 * 当主线程修改 FLAG 值时则停止线程
 */
public class Thread002 extends Thread {
    // 可以保证可见性；防止重排序；不能保证原子性
    // Lock 锁汇编指令实现，让副本数据主动刷新主内存中的数据，从而实现缓存数据一致性问题
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
