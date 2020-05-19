package com.chaibin.shopping.core.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Builder
@Getter
public class MemberRequestDto {

    @NotBlank(message = "정상적인 아이디가 아닙니다.")
    String userId;

    @NotBlank(message = "정상적인 비밀번호가 아닙니다.")
    String password;

    @NotBlank(message = "정상적인 이름이 아닙니다.")
    String name;

    @NotBlank(message = "정상적인 전화번호가 아닙니다.")
    String phone;

    @NotBlank(message = "주소가 존재하지 않습니다.")
    String address;

    public MemberRequestDto(String userId, String password, String name, String phone, String address) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
}
