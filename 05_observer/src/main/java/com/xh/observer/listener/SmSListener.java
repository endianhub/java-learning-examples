package com.xh.observer.listener;

import com.xh.observer.entity.UserMessageEntity;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName EmailListener
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
@Component
public class SmSListener implements ApplicationListener<UserMessageEntity> {
    /**
     * 监听的方法
     *
     * @param event
     */
    @Override
    public void onApplicationEvent(UserMessageEntity event) {
        System.out.println("短信:" + event.toString());
    }
}
