package com.chaibin.shopping.common;

import com.chaibin.shopping.core.member.MemberRequestDto;
import com.chaibin.shopping.models.Member;


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

    MemberRequestDto MEMBER_REQUEST1 = MemberRequestDto.builder()
            .userId("member1")
            .name("홍길동1")
            .password("password1")
            .address("서울특별시 강남구 강남대로")
            .phone("01000000001")
            .build();

    MemberRequestDto MEMBER_REQUEST2 = MemberRequestDto.builder()
            .userId("member2")
            .name("홍길동2")
            .password("password2")
            .address("서울특별시 강남구 강남대로")
            .phone("01000000002")
            .build();
}
