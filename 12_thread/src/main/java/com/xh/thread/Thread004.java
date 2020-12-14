package com.xh.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Title: 创建线程 - 有返回值
 * Description:
 *
 * @author H.Yang
 * @date 2020/12/10
 */
public class Thread004 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + ",开始异步发送短信");
        Thread.sleep(3000);
        return "异步发送短信成功";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread004 mayiktCallable = new Thread004();
        FutureTask<String> futureTask = new FutureTask<>(mayiktCallable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
