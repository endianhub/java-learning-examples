package com.xh.observer.controller;

import com.xh.observer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/30
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/addOrder1")
    public String addOrder1() {
        return orderService.addOrder1();
    }

    @GetMapping("/addOrder2")
    public String addOrder2() {
        return orderService.addOrder2();
    }

    @GetMapping("/addOrder3")
    public String addOrder3() {
        return orderService.addOrder3();
    }

    @GetMapping("/addOrder4")
    public String addOrder4() {
        return orderService.addOrder4();
    }
}
