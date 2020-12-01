package com.xh.strategy.strategy;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xh.strategy.mapper.StrategyMapper;
import com.xh.strategy.model.StrategyDO;
import com.xh.strategy.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Title:
 * Description:
 * 为了不暴露 bean 名称，对外做一层封装
 *
 * @author H.Yang
 * @date 2020/12/1
 */
@Component
public class StrategyContext {
    @Autowired
    private StrategyMapper strategyMapper;

    public <T> T getStrategy(String strategyId, Class<T> t) {
        // strategyId bean id
        if (StringUtils.isEmpty(strategyId)) {
            return null;
        }
        return SpringUtils.getBean(strategyId, t);
    }

    public <T> T getStrategy(String strategyId, String strategyType, Class<T> t) {
        // strategyId bean id 验证参数
        if (StringUtils.isEmpty(strategyId) || StringUtils.isEmpty(strategyType) || t == null) {
            return null;
        }
        // 根据策略id查询
        QueryWrapper<StrategyDO> queryWrapper = new QueryWrapper<StrategyDO>();
        queryWrapper.eq("strategy_id", strategyId);
        queryWrapper.eq("strategy_type", strategyType);
        StrategyDO meiteStrategy = strategyMapper.selectOne(queryWrapper);
        if (meiteStrategy == null) {
            return null;
        }
        String strategyBeanId = meiteStrategy.getStrategyBeanId();
        if (StringUtils.isEmpty(strategyBeanId)) {
            return null;
        }
        return SpringUtils.getBean(strategyBeanId, t);
    }

}
