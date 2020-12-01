package com.xh.strategy.service;

import com.xh.strategy.strategy.MsgStrategy;
import com.xh.strategy.strategy.StrategyContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/12/1
 */
@RestController
public class MsgSerice {

    @Autowired
    private StrategyContext strategyContext;

    /**
     * 静态获取
     *
     * @param strategyId
     * @param phone
     * @return
     */
    @GetMapping("/sendMsg1")
    public String sendMsg1(String strategyId, String phone) {
        MsgStrategy msgStrategy = strategyContext.getStrategy(strategyId, MsgStrategy.class);
        if (msgStrategy == null) {
            return "当前渠道已经关闭或者是不存在";
        }
        return msgStrategy.sendMsg(phone);
    }

    /**
     * 数据库配置
     *
     * @param strategyId
     * @param phone
     * @return
     */
    @GetMapping("/sendMsg2")
    public String sendMsg2(String strategyId, String phone) {
        MsgStrategy msgStrategy = strategyContext.getStrategy(strategyId, "send_msg", MsgStrategy.class);
        if (msgStrategy == null) {
            return "当前渠道已经关闭或者是不存在";
        }
        return msgStrategy.sendMsg(phone);
    }

}
