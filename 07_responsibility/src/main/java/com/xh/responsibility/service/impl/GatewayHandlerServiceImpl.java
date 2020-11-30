package com.xh.responsibility.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xh.responsibility.entity.GatewayHandlerEntity;
import com.xh.responsibility.mapper.GatewayHandlerMapper;
import com.xh.responsibility.respon.handler.GatewayHandler;
import com.xh.responsibility.service.GatewayHandlerService;
import com.xh.responsibility.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/30
 */
@Component
@Slf4j
public class GatewayHandlerServiceImpl implements GatewayHandlerService {

    @Autowired
    private GatewayHandlerMapper gatewayHandlerMapper;

    @Override
    public GatewayHandler getFirstGatewayHandler() {
        //1.查询头结点 Handler beanid  查询prev_handler_id 是为空的情况下 表明为头结点
        QueryWrapper<GatewayHandlerEntity> firstQueryWrapper = new QueryWrapper<GatewayHandlerEntity>();
        firstQueryWrapper.isNull("prev_handler_id");
        GatewayHandlerEntity gatewayHandlerEntity = gatewayHandlerMapper.selectOne(firstQueryWrapper);
        if (gatewayHandlerEntity == null) {
            log.error(">>>很抱歉，您没有配置头结点.");
            return null;
        }
        // 2.获取头结点的 handlerid
        String handlerId = gatewayHandlerEntity.getHandlerId();
        if (handlerId == null) {
            log.error(">>>很抱歉，您没有配置头结点. handlerId");
            return null;
        }
        // 3.从容器获取该handler对象 头对象
        GatewayHandler headGatewayHandler = SpringUtils.getBean(handlerId, GatewayHandler.class);
        if (headGatewayHandler == null) {
            log.error(">>>您代码中没有配置" + handlerId + ",对象");
            return null;
        }
        // 4.能够成功获取限流处理器，获取下一个处理器的 beanid
        String nextHandlerId = gatewayHandlerEntity.getNextHandlerId();
        // 记录当前循环对象
        GatewayHandler tempGatewayHandler = headGatewayHandler;
        while (nextHandlerId != null) {

            // 从spring容器中获取下一个节点对象
            GatewayHandler nextGatewayHandler = SpringUtils.getBean(nextHandlerId, GatewayHandler.class);
            if (nextGatewayHandler == null) {
                break;
            }
            QueryWrapper<GatewayHandlerEntity> nextQueryWrapper = new QueryWrapper<>();
            nextQueryWrapper.eq("handler_id", nextHandlerId);
            GatewayHandlerEntity nextGtewayHandlerEntity = gatewayHandlerMapper.selectOne(nextQueryWrapper);
            if (nextGtewayHandlerEntity == null) {
                break;

            }
            nextHandlerId = nextGtewayHandlerEntity.getNextHandlerId();

            tempGatewayHandler.setNextGatewayHandler(nextGatewayHandler);
            tempGatewayHandler = nextGatewayHandler;
        }
        // 头限流  下
        return headGatewayHandler;
    }
}
