package com.xh.async.ext;


import java.lang.annotation.*;

/**
 * Title: 自定义注解
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/24
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExtAsync {
}
