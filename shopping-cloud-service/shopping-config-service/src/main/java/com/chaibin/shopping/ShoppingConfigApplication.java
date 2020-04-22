package com.chaibin.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ShoppingConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingConfigApplication.class, args);
	}

}
