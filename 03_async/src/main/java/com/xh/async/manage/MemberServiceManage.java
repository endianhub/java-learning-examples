package com.xh.async.manage;

import com.xh.async.ext.ExtAsync;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MemberServiceManage {

    //    @Async
    @ExtAsync
    public String addUserLog() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        log.info(">>>流程2");
        return "success";
    }
}
