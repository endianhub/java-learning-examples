package com.xh.decorative.decorate.impl;

import com.xh.decorative.decorate.ComponentCache;
import com.xh.decorative.mapper.UserMapper;
import com.xh.decorative.model.UserDO;
import com.xh.decorative.utils.JvmMapCacheUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Title: 一级缓存
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/26
 */
@Component
public class JvmComponentCache implements ComponentCache {
    @Autowired
    private UserMapper userMapper;

    @Override
    public <T> T getCacheEntity(String key) {
        // 一级缓存
        UserDO jvmEntity = JvmMapCacheUtils.getEntity(key, UserDO.class);
        if (jvmEntity != null) {
            return (T) jvmEntity;
        }
        // 此时的参数传参是个问题
        UserDO userDO = userMapper.selectById(1);
        if (userDO == null) {
            return null;
        }
        JvmMapCacheUtils.putEntity(key, userDO);
        return (T) userDO;
    }

    @Override
    public <T> T getCacheEntity2(String key, Class<T> clazz, ProceedingJoinPoint joinPoint) {
        // 一级缓存
        T t = JvmMapCacheUtils.getEntity(key, clazz);
        if (t != null) {
            return (T) t;
        }
        //  查询db测参数可以通过aop的方式获取目标对象方法
        // 解决参数传参问题
        try {
            Object resultDb = joinPoint.proceed();
            // 数据库DB有的情况 将该内容缓存到当前Jvm中
            JvmMapCacheUtils.putEntity(key, resultDb);
            return (T) resultDb;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }

}
