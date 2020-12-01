package com.xh.strategy.factory;


import com.xh.strategy.strategy.MsgStrategy;
import com.xh.strategy.strategy.impl.AliYunStrategy;
import com.xh.strategy.strategy.impl.HuaWeiStrategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Title: 这种模式用的不多，一般都是放到 Spring 容器中使用
 * Description:
 *
 * @author H.Yang
 * @date 2020/12/1
 */
public class FactoryStrategy {
    private static Map<String, MsgStrategy> msgStrategys = new ConcurrentHashMap<>();


    static {
        msgStrategys.put("huawei", new HuaWeiStrategy());
        msgStrategys.put("aliyun", new AliYunStrategy());
    }

    public static MsgStrategy getContextStrategy(String strategyId) {
        return msgStrategys.get(strategyId);
    }

}
