package com.chaibin.shopping.core.member;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponseDto {

    String userId;

    String name;

    String phone;

    String address;

    @Builder
    public MemberResponseDto(String userId, String name, String phone, String address) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
}
