package com.xh.responsibility.respon.handler.impl;

import com.xh.responsibility.respon.handler.GatewayHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/30
 */
@Slf4j
@Component
public class CurrentLimitHandler implements GatewayHandler {

    private GatewayHandler nextGatewayHandler;

    public CurrentLimitHandler() {

    }

    public CurrentLimitHandler(GatewayHandler nextGatewayHandler) {
        this.nextGatewayHandler = nextGatewayHandler;
    }


    /**
     * 构造函数或者人为set
     */

    @Override
    public void doService() {
        log.info(">>>第一关 IP限流处理业务逻辑判断<<<");
        // 如何指向下一个处理器对象
        nextGatewayHandler.doService();
    }

    @Override
    public void setNextGatewayHandler(GatewayHandler nextGatewayHandler) {
        this.nextGatewayHandler = nextGatewayHandler;
    }
}
