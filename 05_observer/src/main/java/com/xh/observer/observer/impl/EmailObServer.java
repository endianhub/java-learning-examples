package com.xh.observer.observer.impl;

import com.alibaba.fastjson.JSONObject;
import com.xh.observer.observer.ObServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/30
 */
@Component
@Slf4j
public class EmailObServer implements ObServer {

    @Override
    public void sendMsg1(JSONObject jsonObject) {
        log.info("使用观察者发送邮件");
    }
}
