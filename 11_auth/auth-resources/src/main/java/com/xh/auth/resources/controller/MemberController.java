package com.xh.auth.resources.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/12/6
 */
@RestController
public class MemberController {

    @GetMapping("/getMember")
    public String getMember() {
        return "我是会员服务接口";
    }


}
