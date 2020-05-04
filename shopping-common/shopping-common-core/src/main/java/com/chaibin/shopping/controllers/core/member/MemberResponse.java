package com.chaibin.shopping.controllers.core.member;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponse {

    String userId;

    String name;

    String phone;

    String address;

    @Builder
    public MemberResponse(String userId, String name, String phone, String address) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
}
