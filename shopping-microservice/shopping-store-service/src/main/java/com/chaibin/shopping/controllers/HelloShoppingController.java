package com.chaibin.shopping.controllers;

import com.chaibin.shopping.clients.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloShoppingController {

    @Autowired
    UserFeignClient client;

    @GetMapping("/hello")
    public String getHello() {
        return "Hello microservices";
    }
}
