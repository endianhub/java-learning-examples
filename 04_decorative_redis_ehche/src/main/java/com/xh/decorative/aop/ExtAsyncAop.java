package com.xh.decorative.aop;

import com.xh.decorative.decorate.impl.RedisDecorate1;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/26
 */
@Aspect
@Component
@Slf4j
public class ExtAsyncAop {

    @Autowired
    private RedisDecorate1 redisDecorate1;

    /**
     * 使用Aop拦截我们的方法上是否使用缓存注解
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "@annotation(com.xh.decorative.annotation.ExtCache)")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取目标对象
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // 获取目标对象方法
        Method targetMethod = methodSignature.getMethod();
        // 表示我们目标方法 getUser(Integer userId) {
//        Object result = joinPoint.proceed();
//        // 拼接缓存的key
        String key = "USER_" + Arrays.toString(joinPoint.getArgs());

//        Object result = redisDecorate1.getCacheEntity(key);
        Object result = redisDecorate1.getCacheEntity2(key, targetMethod.getReturnType(), joinPoint);
        return result;
    }
}
