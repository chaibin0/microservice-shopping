package com.chaibin.shopping.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="userservice")
public interface UserFeignClient {

    @GetMapping("/v1/users")
    public ResponseEntity<?> getMember(@RequestParam("id") String id);

}
