package com.xh.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class IndexController {
    /**
     * 跳转到首页
     *
     * @return
     */
    @RequestMapping("/")
    public String index() {
        log.info("默认请求....");
        return "index";
    }

    @ResponseBody
    @RequestMapping("/demo")
    public String indexDemo() {
        log.info("此方法不做拦截，所有人都可以访问.....");
        return "此方法不做拦截，所有人都可以访问.....";
    }

    @ResponseBody
    @RequestMapping("/addMember")
    public String addMember() {
        return "新增用户";
    }

    @ResponseBody
    @RequestMapping("/delMember")
    public String delMember() {
        return "删除用户";
    }

    @ResponseBody
    @RequestMapping("/updateMember")
    public String updateMember() {
        return "修改用户";
    }

    @ResponseBody
    @RequestMapping("/showMember")
    public String showMember() {
        return "查询用户";
    }


}
