package com.xh.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class LoginController {

    @GetMapping("/login")
    public String login() {
        log.info("准备登录....");
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        log.info("准备退出....");
        return "login";
    }
}
