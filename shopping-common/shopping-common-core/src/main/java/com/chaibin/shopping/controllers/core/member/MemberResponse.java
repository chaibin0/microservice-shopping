package com.chaibin.shopping.controllers.core.member;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponse {

    String id;

    String name;

    String phone;

    String address;

    @Builder
    public MemberResponse(String id, String name, String phone, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
}
