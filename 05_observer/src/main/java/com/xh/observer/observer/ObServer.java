package com.xh.observer.observer;

import com.alibaba.fastjson.JSONObject;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/30
 */
public interface ObServer {

    /**
     * 发送通知
     *
     * @param jsonObject
     */
    void sendMsg1(JSONObject jsonObject);
}
