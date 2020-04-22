package com.chaibin.shopping.controllers;

import com.chaibin.shopping.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/members")
public class MemberController {

    MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("")
    public ResponseEntity<?> getMember(@RequestParam("id") String id) {

        return ResponseEntity.ok().body(memberService.getMember(id));
    }

}
