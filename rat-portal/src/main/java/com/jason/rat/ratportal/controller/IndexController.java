package com.jason.rat.ratportal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jason
 * @Date: 2019-05-15
 */
@RestController
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
