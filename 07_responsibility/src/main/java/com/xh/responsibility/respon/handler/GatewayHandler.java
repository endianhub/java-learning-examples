package com.xh.responsibility.respon.handler;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/30
 */
public interface GatewayHandler {

    void doService();

    void setNextGatewayHandler(GatewayHandler nextGatewayHandler);
}
