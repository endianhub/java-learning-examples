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
public class BlacklistHandler implements GatewayHandler {

    private GatewayHandler nextGatewayHandler;

    public BlacklistHandler() {

    }

    public BlacklistHandler(GatewayHandler nextGatewayHandler) {
        this.nextGatewayHandler = nextGatewayHandler;
    }


    @Override
    public void doService() {
        log.info(">>>第二关 黑名单业务逻辑判断<<<");
        nextGatewayHandler.doService();
    }

    @Override
    public void setNextGatewayHandler(GatewayHandler nextGatewayHandler) {
        this.nextGatewayHandler = nextGatewayHandler;
    }
}
