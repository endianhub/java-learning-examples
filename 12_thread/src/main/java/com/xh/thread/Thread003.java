package com.xh.thread;

import java.util.concurrent.*;

/**
 * Title: 创建线程
 * Description:
 *
 * @author H.Yang
 * @date 2020/12/10
 */
public class Thread003 {
    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 6, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3));

    public static void main(String[] args) {
        threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + "我是线程池"));
    }
}
