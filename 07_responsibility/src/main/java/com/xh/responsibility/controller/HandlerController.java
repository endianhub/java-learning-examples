package com.xh.responsibility.controller;

import com.xh.responsibility.service.GatewayHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HandlerController
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
@RestController
public class HandlerController {


    @Autowired
    private GatewayHandlerService gatewayHandlerService;
    
    @GetMapping("/getHandler")
    public void getHandler() {

        gatewayHandlerService.getFirstGatewayHandler().doService();
    }

}
