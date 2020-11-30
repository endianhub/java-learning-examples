package com.xh.observer.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xh.observer.entity.UserMessageEntity;
import com.xh.observer.observer.ObServer;
import com.xh.observer.observer.SendMsgSubject;
import com.xh.observer.observer.impl.EmailObServer;
import com.xh.observer.observer.impl.SMSObServer;
import com.xh.observer.service.OrderService;
import com.xh.observer.utils.SpringBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/30
 */
@Component
@Slf4j
public class OrderServiceImpl implements OrderService {


    @Autowired
    private SpringBean springBean;
    @Autowired
    private SendMsgSubject sendMsgSubject;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * 传统方式
     *
     * @return
     */
    @Override
    public String addOrder1() {
        log.info("1.调用数据库下单订单代码:");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sms", "1865891111");
        jsonObject.put("email", "644064779@qq.com");

        log.info("2.发送短信");
        log.info("3.发送邮件");
        log.info("4.发送微信通知");

        return "success";
    }

    /**
     * 使用普通New的方式
     *
     * @return
     */
    @Override
    public String addOrder2() {
        log.info("1.调用数据库下单订单代码:");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sms", "1865891111");
        jsonObject.put("email", "644064779@qq.com");

        SendMsgSubject sendMsgSub = new SendMsgSubject();
        sendMsgSub.addObServer(new SMSObServer());
        sendMsgSub.addObServer(new EmailObServer());

        sendMsgSub.notifyObServer(jsonObject);

        return "success";
    }


    /**
     * 使用容器方式
     *
     * @return
     */
    @Override
    public String addOrder3() {
        log.info("1.调用数据库下单订单代码:");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sms", "1865891111");
        jsonObject.put("email", "644064779@qq.com");

        //根据接口类型返回相应的所有bean
        Map<String, ObServer> map = springBean.getApplicationContext().getBeansOfType(ObServer.class);
        for (String key : map.keySet()) {
            ObServer obServer = map.get(key);
            sendMsgSubject.addObServer(obServer);
        }
        sendMsgSubject.notifyObServer(jsonObject);
        return "success";
    }

    @Override
    public String addOrder4() {
        log.info("1.调用数据库下单订单代码:");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sms", "1865891111");
        jsonObject.put("email", "644064779@qq.com");

        UserMessageEntity userMessageEntity = new UserMessageEntity(this, "644064779@qq.com", "1865891111");
        applicationEventPublisher.publishEvent(userMessageEntity);

        return "success";
    }
}
