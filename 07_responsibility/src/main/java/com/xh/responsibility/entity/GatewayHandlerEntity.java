package com.xh.responsibility.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("gateway_handler")
public class GatewayHandlerEntity implements Serializable, Cloneable {
   /** 主键ID */
   private Integer id;
   /** handler名称 */
   private String handlerName;
   /** handler主键id */
   private String handlerId;
   /** 下一个handler */
   private String nextHandlerId;
}