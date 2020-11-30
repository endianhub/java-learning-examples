package com.xh.responsibility.respon.handler;

import com.xh.responsibility.respon.handler.impl.BlacklistHandler;
import com.xh.responsibility.respon.handler.impl.CurrentLimitHandler;
import com.xh.responsibility.respon.handler.impl.TokenHandler;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/30
 */
public class FactoryHandler {

    public static CurrentLimitHandler getCurrentLimitHandler() {
        CurrentLimitHandler currentLimitHandler = new CurrentLimitHandler(
                new BlacklistHandler(
                        new TokenHandler(null)
                )
        );
        return currentLimitHandler;
    }

    public static void main(String[] args) {
        CurrentLimitHandler currentLimitHandler = FactoryHandler.getCurrentLimitHandler();
        currentLimitHandler.doService();
    }


}
