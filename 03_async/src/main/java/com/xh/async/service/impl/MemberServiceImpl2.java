package com.xh.async.service.impl;

import com.xh.async.manage.MemberServiceManage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CGLIB动态代理
 * <p>
 * CGLIB动态代理采用继承目标对象实现
 */
@RestController
@Slf4j
public class MemberServiceImpl2 {
    @Autowired
    private MemberServiceManage memberServiceManage;

    @GetMapping("/cglib/addUser")
    public String addUser() {
        log.info(">>>流程1");
        this.addUserLog();
        log.info(">>>流程3");
        return "success";
    }

    @Async
    public String addUserLog() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        log.info(">>>流程2");
        return "success";
    }

}
