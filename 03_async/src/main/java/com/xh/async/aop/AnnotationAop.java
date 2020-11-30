package com.xh.async.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Title: 通过AOP技术，根据注解拦截
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/25
 */
@Component
@Aspect
@Slf4j
public class AnnotationAop {

    // 定义线程池
    private ThreadPoolExecutor threadPool;

    public AnnotationAop() {
        threadPool = new ThreadPoolExecutor(5, 6, 3,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3));
    }

    @Around(value = "@annotation(com.xh.async.ext.ExtAsync)")
    public void doBefore(ProceedingJoinPoint joinPoint) {
        // 直接获取到方法上有加上ExtAsync
        log.info(">>>拦截到我们方法上有加上ExtAsync");
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                // 执行我们的目标方法
                try {
                    joinPoint.proceed();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        });

    }
}
