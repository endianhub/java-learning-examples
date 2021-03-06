package com.xh.thread;

/**
 * Title: join顺序执行3
 * Description:
 * <p>
 * 使用join保证线程顺序问题
 * <p>
 * 正确的写法是在当前线程中阻塞。
 *
 * @author H.Yang
 * @date 2020/12/19
 */
public class Thread006 implements Runnable {

    private Thread thread;

    public Thread006(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        try {
            // 阻塞当前线程
            if (thread != null) {
                thread.join();
            }
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + ", " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 主线程调用 t1.join 住线程变为阻塞状态，同时释放锁，必须等待 t1 线程执行完毕后主线程才能继续执行
        Thread t1 = new Thread(new Thread006(null), "t1");
        Thread t2 = new Thread(new Thread006(t1), "t2");
        Thread t3 = new Thread(new Thread006(t2), "t3");

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(3000);
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + ", " + i);
        }
    }
}
