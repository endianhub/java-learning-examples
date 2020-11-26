package com.xh.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 分别使用JDK动态代理和CGLIB动态代理
 */
@SpringBootApplication
@EnableAsync
public class AppDemo04 {

    public static void main(String[] args) {
        SpringApplication.run(AppDemo04.class);
    }


}
