package com.xh.decorative.annotation;

import java.lang.annotation.*;

/**
 * 自定义缓存注解
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExtCache {
}