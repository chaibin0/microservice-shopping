package com.chaibin.shopping.model;

import com.chaibin.shopping.controllers.core.member.MemberResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @Column
    String userId;

    @Column
    String password;

    @Column
    String name;

    @Column
    String phone;

    @Column
    String address;

    @Builder
    public Member(String userId, String password, String name, String phone, String address) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public MemberResponse toMemberResponse() {

        MemberResponse response = MemberResponse.builder()
                .userId(this.userId)
                .name(this.name)
                .phone(this.phone)
                .address(this.address)
                .build();
        return response;
    }
}
