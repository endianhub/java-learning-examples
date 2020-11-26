package com.xh.decorative.decorate.impl;

import com.xh.decorative.decorate.AbstractDecorate;
import com.xh.decorative.model.UserDO;
import com.xh.decorative.utils.RedisUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Title: 装饰实现类 - 二级缓存，对原有的一级缓存做增强
 * Description:
 * <p>
 * RedisDecorate 可以直接实现 ComponentCache ，但这样不太友好，装饰类有装饰类的需求；
 * 装饰类有二级缓存、三级缓存....有共同的父类，以此加以区分。
 * <p>
 * AbstractDecorate 抽象装饰类是可能未来会新增三级缓存、四级缓存做区分
 * <p>
 * 有两种写法：
 * - 继承模式
 * - 实现模式
 *
 * @author H.Yang
 * @date 2020/11/26
 */
@Component
public class RedisDecorate1 implements AbstractDecorate {

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private JvmComponentCache jvmComponentCache;

    @Override
    public <T> T getCacheEntity(String key) {
        // 查询二级缓存
        UserDO redisEntity = redisUtils.getEntity(key, UserDO.class);
        if (redisEntity != null) {
            return (T) redisEntity;
        }
        // if 二级缓存没有则查一级缓存
        // 一级缓存
        UserDO jvmEntity = jvmComponentCache.getCacheEntity(key);
        if (jvmEntity != null) {
            // 将缓存放入二级缓存中
            redisUtils.putEntity(key, jvmEntity);
            return (T) jvmEntity;
        }
        return null;
    }

    @Override
    public <T> T getCacheEntity2(String key, Class<T> clazz, ProceedingJoinPoint joinPoint) {
        // 查询二级缓存
        T t = redisUtils.getEntity(key, clazz);
        if (t != null) {
            return (T) t;
        }
        // if 二级缓存没有则查一级缓存
        // 一级缓存
        t = jvmComponentCache.getCacheEntity2(key, clazz, joinPoint);
        if (t != null) {
            // 将缓存放入二级缓存中
            redisUtils.putEntity(key, t);
            return (T) t;
        }
        return null;
    }

}
