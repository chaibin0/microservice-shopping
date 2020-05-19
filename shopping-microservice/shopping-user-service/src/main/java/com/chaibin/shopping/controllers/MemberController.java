package com.chaibin.shopping.controllers;

import com.chaibin.shopping.core.member.MemberRequestDto;
import com.chaibin.shopping.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/users")
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

    @PostMapping("")
    public ResponseEntity<?> registerMember(@RequestBody MemberRequestDto request) {

        memberService.registerMember(request);
        return ResponseEntity.created(null).body(null);
    }

    @GetMapping("/check")
    public ResponseEntity<?> checkSameId(@RequestParam("id") String id){
        return ResponseEntity.ok().body(memberService.checkMember(id));
    }
}
