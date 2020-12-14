package com.xh.thread;

/**
 * Title: 创建线程 - 线程停止
 * Description:
 *
 * @author H.Yang
 * @date 2020/12/10
 */
public class Thread005 extends Thread {
    private volatile boolean flag = true;

    @Override
    public void run() {

        while (flag) {

        }

    }

    public void stopThrad() {
        this.flag = false;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread005 thread005 = new Thread005();
        thread005.start();

        Thread.sleep(3000);
        // 不建议使用stopt停止线程，因为他底层使用强制停止线程 如果线程代码没有执行完毕的情况下则强制停止
        thread005.stopThrad();
    }
}
