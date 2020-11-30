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
public class TokenHandler implements GatewayHandler {
    private GatewayHandler nextGatewayHandler;

    public TokenHandler() {

    }

    public TokenHandler(GatewayHandler nextGatewayHandler) {
        this.nextGatewayHandler = nextGatewayHandler;
    }

    @Override
    public void doService() {
        log.info(">>>第三关 验证Token逻辑判断<<<");
    }

    @Override
    public void setNextGatewayHandler(GatewayHandler nextGatewayHandler) {
        this.nextGatewayHandler = nextGatewayHandler;
    }
}
