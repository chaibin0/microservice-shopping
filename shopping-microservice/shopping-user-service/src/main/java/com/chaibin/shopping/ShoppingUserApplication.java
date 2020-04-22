package com.chaibin.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class ShoppingUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingUserApplication.class, args);
    }
}
