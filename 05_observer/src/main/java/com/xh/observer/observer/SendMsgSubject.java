package com.xh.observer.observer;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/30
 */
@Component
public class SendMsgSubject {

    /**
     * 类型 ObServer
     */
    private List<ObServer> listObServer = new ArrayList<>();
    /**
     * 线程池
     */
    // 定义线程池
    private ThreadPoolExecutor threadPool;

    public SendMsgSubject() {
        threadPool = new ThreadPoolExecutor(5, 6, 3,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3));
    }


    /**
     * 新增ObServer
     *
     * @param obServer
     */
    public void addObServer(ObServer obServer) {
        listObServer.add(obServer);
    }

    /**
     * 通知给所有的观察者
     *
     * @param jsonObject
     */
    public void notifyObServer(JSONObject jsonObject) {
        for (ObServer obServer : listObServer) {
            // 单独开启线程异步通知
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    obServer.sendMsg1(jsonObject);
                }
            });

        }
    }
}
