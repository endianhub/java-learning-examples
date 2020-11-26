package com.xh.decorative.controller;

import com.xh.decorative.model.UserDO;
import com.xh.decorative.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/26
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getByUserId")
    public UserDO getByUserId(Integer userId) {
        return userService.getById(userId);
    }

    @GetMapping("/getByUserId2")
    public UserDO getByUserId2(Integer userId) {
        return userService.getById2(userId);
    }

    @GetMapping("/getByUserId3")
    public UserDO getByUserId3(Integer userId) {
        return userService.getById3(userId);
    }

}
