package com.xh.strategy.strategy.impl;

import com.xh.strategy.strategy.MsgStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/12/1
 */
@Component
@Slf4j
public class AliYunStrategy implements MsgStrategy {
    
    @Override
    public String sendMsg(String phone) {
        log.info("使用阿里云发送短信");
        return "使用阿里云发送短信";
    }
}
