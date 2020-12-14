package com.xh.async.manage;

import com.xh.async.ext.ExtAsync;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MemberServiceManage {

    //    @Async
    @ExtAsync
    public String addUserLog1() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        log.info("addUserLog1 >>> 流程2");
        return "success";
    }

    @Async
    public String addUserLog2() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        log.info("addUserLog2 >>> 流程2");
        return "success";
    }

}
