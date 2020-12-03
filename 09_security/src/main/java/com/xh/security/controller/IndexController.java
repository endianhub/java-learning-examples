package com.xh.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @GetMapping("/getUserInfo")
    public String getUserInfo(HttpServletRequest request) {
        request.setAttribute("userName", request.getParameter("userName"));
        return "userinfo";
    }

}
