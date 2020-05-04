package com.chaibin.shopping.common;

import com.chaibin.shopping.controllers.core.member.MemberRequest;
import com.chaibin.shopping.model.Member;


public interface StaticMember {
    Member MEMBER1 = Member.builder()
            .userId("member1")
            .name("홍길동1")
            .password("password1")
            .address("서울특별시 강남구 강남대로")
            .phone("01000000001")
            .build();

    Member MEMBER2 = Member.builder()
            .userId("member2")
            .name("홍길동2")
            .password("password2")
            .address("서울특별시 강남구 강남대로")
            .phone("01000000002")
            .build();

    MemberRequest MEMBER_REQUEST1 = MemberRequest.builder()
            .userId("member1")
            .name("홍길동1")
            .password("password1")
            .address("서울특별시 강남구 강남대로")
            .phone("01000000001")
            .build();

    MemberRequest MEMBER_REQUEST2 = MemberRequest.builder()
            .userId("member2")
            .name("홍길동2")
            .password("password2")
            .address("서울특별시 강남구 강남대로")
            .phone("01000000002")
            .build();
}
