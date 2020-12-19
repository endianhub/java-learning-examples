package com.xh.thread;

/**
 * Title: join顺序执行2
 * Description:
 * <p>
 * 使用join保证线程顺序问题
 *
 * @author H.Yang
 * @date 2020/12/19
 */
public class Thread005 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + ", " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 主线程调用 t1.join 住线程变为阻塞状态，同时释放锁，必须等待 t1 线程执行完毕后主线程才能继续执行
        Thread t1 = new Thread(new Thread005(), "t1");
        Thread t2 = new Thread(new Thread005(), "t2");
        Thread t3 = new Thread(new Thread005(), "t3");

        t1.start();
        t2.start();
        t3.start();

        // 对上面的三个线程阻塞是不生效的，不生效的原因：上面线程已经被 CPU 调度，此时已经不能再阻塞了。
        t1.join();
        t2.join();
        t3.join();

        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + ", " + i);
        }
    }
}
