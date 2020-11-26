package com.xh.decorative.decorate;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Title: 基本功能
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/26
 */
public interface ComponentCache {

    /**
     * 根据key查询缓存数据
     *
     * @param
     * @return
     */
    <T> T getCacheEntity(String key);

    <T> T getCacheEntity2(String key, Class<T> clazz, ProceedingJoinPoint joinPoint);
}
