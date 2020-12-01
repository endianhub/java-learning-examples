package com.xh.strategy.model;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("strategy")
public class StrategyDO {
    private Long id;
    private String strategyName;
    private String strategyId;
    private String strategyType;
    private String strategyBeanId;

    @TableLogic
    private Integer deleted = 0;
}
