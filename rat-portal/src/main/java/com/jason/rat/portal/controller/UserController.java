package com.jason.rat.portal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jason.rat.client.model.User;
import com.jason.rat.client.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jason
 * @Date: 2019-05-17
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Reference(version = "1.0.0")
    private UserService userService;

    @GetMapping("/userInfo/{id}")
    public User getUserInfo(@PathVariable Long id) {
        try {
            return userService.findById(id);
        } catch (Exception e) {
            logger.error("userService.findById error,id=" + id, e);
        }
        return null;
    }
}
