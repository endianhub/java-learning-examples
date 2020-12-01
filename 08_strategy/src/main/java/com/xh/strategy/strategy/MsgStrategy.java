package com.xh.strategy.strategy;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/12/1
 */
public interface MsgStrategy {

    /**
     * 共同行为方法
     *
     * @return
     */
    String sendMsg(String phone);
}
