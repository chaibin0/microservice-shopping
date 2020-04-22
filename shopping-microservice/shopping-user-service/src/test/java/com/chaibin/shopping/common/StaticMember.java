package com.chaibin.shopping.common;

import com.chaibin.shopping.model.Member;

public interface StaticMember {
    Member MEMBER1 = Member.builder()
            .id("member1")
            .password("password1")
            .phone("01000000001")
            .build();

    Member MEMBER2 = Member.builder()
            .id("member2")
            .password("password2")
            .phone("01000000002")
            .build();
}
